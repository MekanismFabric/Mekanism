package mekanism.tools;

import mekanism.advancements.MekanismAdvancement;
import mekanism.registries.MekanismItems;
import mekanism.resource.PrimaryResources;
import mekanism.resource.ResourceTypes;
import mekanism.tools.advancements.ToolsAdvancements;
import mekanism.tools.datagen.BaseItemModelProvider;
import mekanism.tools.datagen.ConfigLangHelper;
import mekanism.tools.item.*;
import mekanism.tools.registries.ToolsItems;
import mekanism.tools.util.ToolsTags;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.CriterionConditions;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static mekanism.tools.MekanismTools.id;
import static mekanism.tools.datagen.ToolsRecipeHelper.registerRecipeSet;
import static mekanism.tools.datagen.ToolsRecipeHelper.registerVanillaPaxels;

public class MekanismToolsDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        final FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(MekanismToolsItemGenerator::new);
        pack.addProvider(MekanismToolsLangGenerator::new);
        pack.addProvider(MekanismToolsRecipeGenerator::new);
        pack.addProvider(MekanismToolsAdvancementGenerator::new);
        pack.addProvider(MekanismToolsItemTagGenerator::new);
        pack.addProvider(MekanismToolsBlockTagGenerator::new);
    }

    private static class MekanismToolsItemGenerator extends BaseItemModelProvider {

        public MekanismToolsItemGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {}

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            for (Map.Entry<Item, String> entry : ToolsItems.ALL_ITEMS.entrySet()) {
                Item item = entry.getKey();
                String itemKey = entry.getValue();
                Identifier texture = getTexture(item, itemKey);

                if (item instanceof ArmorItem) {
                    armorWithTrim(itemModelGenerator, item, texture);
                } else {
                    handheld(itemModelGenerator, item, texture);
                }
            }
        }

        private Identifier getTexture(Item item, String itemKey) {
            if (isVanilla(item, itemKey)) {
                return id("item/" + itemKey);
            }
            int index = itemKey.lastIndexOf('_');
            return id("item/" + itemKey.substring(0, index) + '/' + itemKey.substring(index + 1));
        }

        private boolean isVanilla(Item item, String name) {
            if (item instanceof ItemMekanismPaxel) {
                return name.startsWith("netherite") || name.startsWith("diamond") || name.startsWith("gold") || name.startsWith("iron") ||
                        name.startsWith("stone") || name.startsWith("wood");
            }
            return false;
        }
    }

    private static class MekanismToolsLangGenerator extends FabricLanguageProvider {

        FabricDataOutput dataGenerator;

        private MekanismToolsLangGenerator(FabricDataOutput dataGenerator) {
            super(dataGenerator, "en_us");
            this.dataGenerator = dataGenerator;
        }

        @Override
        public void generateTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add("itemgroup.mekanismtools.items", "Mekanism Tools");

            for (Map.Entry<Item, String> entry : ToolsItems.ALL_SHIELDS.entrySet()) {
                ItemMekanismShield shield = (ItemMekanismShield) entry.getKey();
                String itemKey = entry.getValue();

                translationBuilder.add(shield, convertItemKeyToDisplay(itemKey));
            }

            for (Map.Entry<Item, String> entry : ToolsItems.ALL_ITEMS.entrySet()) {
                Item item = entry.getKey();
                String itemKey = entry.getValue();

                translationBuilder.add(item, convertItemKeyToDisplay(itemKey));
            }

            ConfigLangHelper.addCategoryNames(translationBuilder);
            ConfigLangHelper.addMaterialNames(translationBuilder);

            translationBuilder.add("tooltip.mekanismtools.hp", "HP: %1$s");
            addAdvancement(translationBuilder, ToolsAdvancements.PAXEL, "Multi-tool", "Craft any Paxel (Pickaxe, Axe, Shovel)");
            addAdvancement(translationBuilder, ToolsAdvancements.ALTERNATE_ARMOR, "More Armor Types!", "Craft any piece of Armor from Mekanism Tools");
            addAdvancement(translationBuilder, ToolsAdvancements.ALTERNATE_TOOLS, "More Tool Types!", "Craft any tool or weapon (except Paxels) from Mekanism Tools");
            addAdvancement(translationBuilder, ToolsAdvancements.NOT_ENOUGH_SHIELDING, "Not Enough Shielding", "Craft any Shield added by Mekanism Tools");
            addAdvancement(translationBuilder, ToolsAdvancements.BETTER_THAN_NETHERITE, "Better Than Netherite", "Protect yourself with a piece of Refined Obsidian Armor");
            addAdvancement(translationBuilder, ToolsAdvancements.LOVED_BY_PIGLINS, "Loved By Piglins", "Refined Glowstone Armor glows even brighter than gold!");
        }

        private void addAdvancement(TranslationBuilder translationBuilder, MekanismAdvancement advancement, String title, String description) {
            translationBuilder.add(advancement.title(), title);
            translationBuilder.add(advancement.description(), description);
        }

        private String convertItemKeyToDisplay(String itemKey) {
            String[] words = itemKey.replaceAll("_", " ").split(" ");
            StringBuilder result = new StringBuilder();
            for (String word : words) {
                result.append(WordUtils.capitalizeFully(word)).append(" ");
            }

            return result.toString().trim();
        }
    }

    private static class MekanismToolsRecipeGenerator extends FabricRecipeProvider {

        public MekanismToolsRecipeGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generate(Consumer<RecipeJsonProvider> exporter) {
            registerRecipeSet(exporter, "bronze", ToolsItems.BRONZE_HELMET, ToolsItems.BRONZE_CHESTPLATE, 
                    ToolsItems.BRONZE_LEGGINGS, ToolsItems.BRONZE_BOOTS, ToolsItems.BRONZE_SWORD, ToolsItems.BRONZE_PICKAXE, 
                    ToolsItems.BRONZE_AXE, ToolsItems.BRONZE_SHOVEL, ToolsItems.BRONZE_HOE, ToolsItems.BRONZE_PAXEL, 
                    ToolsItems.BRONZE_SHIELD, MekanismItems.BRONZE_INGOT, Items.STICK, MekanismItems.BRONZE_NUGGET);
            
            registerRecipeSet(exporter, "lapis_lazuli", ToolsItems.LAPIS_LAZULI_HELMET, ToolsItems.LAPIS_LAZULI_CHESTPLATE,
                    ToolsItems.LAPIS_LAZULI_LEGGINGS, ToolsItems.LAPIS_LAZULI_BOOTS, ToolsItems.LAPIS_LAZULI_SWORD, ToolsItems.LAPIS_LAZULI_PICKAXE,
                    ToolsItems.LAPIS_LAZULI_AXE, ToolsItems.LAPIS_LAZULI_SHOVEL, ToolsItems.LAPIS_LAZULI_HOE, ToolsItems.LAPIS_LAZULI_PAXEL,
                    ToolsItems.LAPIS_LAZULI_SHIELD, Items.LAPIS_LAZULI, Items.STICK, null);
            
            registerRecipeSet(exporter, "osmium", ToolsItems.OSMIUM_HELMET, ToolsItems.OSMIUM_CHESTPLATE,
                    ToolsItems.OSMIUM_LEGGINGS, ToolsItems.OSMIUM_BOOTS, ToolsItems.OSMIUM_SWORD, ToolsItems.OSMIUM_PICKAXE,
                    ToolsItems.OSMIUM_AXE, ToolsItems.OSMIUM_SHOVEL, ToolsItems.OSMIUM_HOE, ToolsItems.OSMIUM_PAXEL,
                    ToolsItems.OSMIUM_SHIELD, MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.INGOT, PrimaryResources.OSMIUM), 
                    Items.STICK, MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.NUGGET, PrimaryResources.OSMIUM));
            
            registerRecipeSet(exporter, "refined_glowstone", ToolsItems.REFINED_GLOWSTONE_HELMET, ToolsItems.REFINED_GLOWSTONE_CHESTPLATE,
                    ToolsItems.REFINED_GLOWSTONE_LEGGINGS, ToolsItems.REFINED_GLOWSTONE_BOOTS, ToolsItems.REFINED_GLOWSTONE_SWORD, ToolsItems.REFINED_GLOWSTONE_PICKAXE,
                    ToolsItems.REFINED_GLOWSTONE_AXE, ToolsItems.REFINED_GLOWSTONE_SHOVEL, ToolsItems.REFINED_GLOWSTONE_HOE, ToolsItems.REFINED_GLOWSTONE_PAXEL,
                    ToolsItems.REFINED_GLOWSTONE_SHIELD, MekanismItems.REFINED_GLOWSTONE_INGOT, Items.STICK, MekanismItems.REFINED_GLOWSTONE_NUGGET);
            
            registerRecipeSet(exporter, "refined_obsidian", ToolsItems.REFINED_OBSIDIAN_HELMET, ToolsItems.REFINED_OBSIDIAN_CHESTPLATE,
                    ToolsItems.REFINED_OBSIDIAN_LEGGINGS, ToolsItems.REFINED_OBSIDIAN_BOOTS, ToolsItems.REFINED_OBSIDIAN_SWORD, ToolsItems.REFINED_OBSIDIAN_PICKAXE,
                    ToolsItems.REFINED_OBSIDIAN_AXE, ToolsItems.REFINED_OBSIDIAN_SHOVEL, ToolsItems.REFINED_OBSIDIAN_HOE, ToolsItems.REFINED_OBSIDIAN_PAXEL,
                    ToolsItems.REFINED_OBSIDIAN_SHIELD, MekanismItems.REFINED_OBSIDIAN_INGOT, Items.STICK, MekanismItems.REFINED_OBSIDIAN_NUGGET);
            
            registerRecipeSet(exporter, "steel", ToolsItems.STEEL_HELMET, ToolsItems.STEEL_CHESTPLATE,
                    ToolsItems.STEEL_LEGGINGS, ToolsItems.STEEL_BOOTS, ToolsItems.STEEL_SWORD, ToolsItems.STEEL_PICKAXE,
                    ToolsItems.STEEL_AXE, ToolsItems.STEEL_SHOVEL, ToolsItems.STEEL_HOE, ToolsItems.STEEL_PAXEL,
                    ToolsItems.STEEL_SHIELD, MekanismItems.STEEL_INGOT, Items.IRON_INGOT, MekanismItems.STEEL_NUGGET);

            registerVanillaPaxels(exporter);
        }
    }

    private static class MekanismToolsAdvancementGenerator extends FabricAdvancementProvider {

        protected MekanismToolsAdvancementGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateAdvancement(Consumer<Advancement> consumer) {
            createAdvancement(consumer, ToolsAdvancements.PAXEL, ToolsItems.DIAMOND_PAXEL, AdvancementFrame.TASK, "any_paxel", InventoryChangedCriterion.Conditions.items(
                    getItems(item -> item instanceof ItemMekanismPaxel)
            ));
            createAdvancement(consumer, ToolsAdvancements.ALTERNATE_ARMOR, ToolsItems.OSMIUM_CHESTPLATE, AdvancementFrame.TASK, "armor", InventoryChangedCriterion.Conditions.items(
                    getItems(item -> item instanceof ItemMekanismArmor)
            ));
            createAdvancement(consumer, ToolsAdvancements.ALTERNATE_TOOLS, ToolsItems.OSMIUM_PICKAXE, AdvancementFrame.TASK, "tools", InventoryChangedCriterion.Conditions.items(
                    getItems(item -> item instanceof ItemMekanismAxe || item instanceof ItemMekanismHoe || item instanceof ItemMekanismPickaxe || item instanceof ItemMekanismShovel || item instanceof ItemMekanismSword)
            ));
            createAdvancement(consumer, ToolsAdvancements.NOT_ENOUGH_SHIELDING, ToolsItems.OSMIUM_SHIELD, AdvancementFrame.TASK, "shields", InventoryChangedCriterion.Conditions.items(
                    getShields(item -> item instanceof ItemMekanismShield)
            ));
            createAdvancement(consumer, ToolsAdvancements.BETTER_THAN_NETHERITE, ToolsItems.REFINED_OBSIDIAN_CHESTPLATE, AdvancementFrame.GOAL, "armor", InventoryChangedCriterion.Conditions.items(
                    ToolsItems.REFINED_OBSIDIAN_HELMET, ToolsItems.REFINED_OBSIDIAN_CHESTPLATE, ToolsItems.REFINED_OBSIDIAN_LEGGINGS, ToolsItems.REFINED_OBSIDIAN_BOOTS));
            createAdvancement(consumer, ToolsAdvancements.LOVED_BY_PIGLINS, ToolsItems.REFINED_GLOWSTONE_CHESTPLATE, AdvancementFrame.GOAL, "armor", InventoryChangedCriterion.Conditions.items(
                    ToolsItems.REFINED_GLOWSTONE_HELMET, ToolsItems.REFINED_GLOWSTONE_CHESTPLATE, ToolsItems.REFINED_GLOWSTONE_LEGGINGS, ToolsItems.REFINED_GLOWSTONE_BOOTS
            ));
        }

        private Advancement createAdvancement(Consumer<Advancement> consumer, MekanismAdvancement advancement, Item displayItem, AdvancementFrame frame, String criteriaName, CriterionConditions conditions) {
            Advancement created = Advancement.Builder
                    .create()
                    .parent(advancement.parentAsAdvancement())
                    .criterion(criteriaName, conditions)
                    .display(
                            displayItem,
                            Text.translatable(advancement.title()),
                            Text.translatable(advancement.description()),
                            null,
                            frame,
                            true,
                            true,
                            false
                    )
                    .build(advancement.name());
            consumer.accept(created);
            return created;
        }

        private ItemConvertible[] getItems(Predicate<Item> matcher) {
            return ToolsItems.ALL_ITEMS.keySet().stream()
                    .filter(matcher)
                    .toArray(ItemConvertible[]::new);
        }

        private ItemConvertible[] getShields(Predicate<Item> matcher) {
            return ToolsItems.ALL_SHIELDS.keySet().stream()
                    .filter(matcher)
                    .toArray(ItemConvertible[]::new);
        }
    }

    private static class MekanismToolsItemTagGenerator extends FabricTagProvider.ItemTagProvider {
        public MekanismToolsItemTagGenerator(FabricDataOutput output, CompletableFuture registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            addToolTags();
            addItemsToTag(ItemTags.PIGLIN_LOVED,
                    ToolsItems.GOLD_PAXEL,
                    ToolsItems.REFINED_GLOWSTONE_PICKAXE,
                    ToolsItems.REFINED_GLOWSTONE_AXE,
                    ToolsItems.REFINED_GLOWSTONE_SHOVEL,
                    ToolsItems.REFINED_GLOWSTONE_HOE,
                    ToolsItems.REFINED_GLOWSTONE_SWORD,
                    ToolsItems.REFINED_GLOWSTONE_PAXEL,
                    ToolsItems.REFINED_GLOWSTONE_HELMET,
                    ToolsItems.REFINED_GLOWSTONE_CHESTPLATE,
                    ToolsItems.REFINED_GLOWSTONE_LEGGINGS,
                    ToolsItems.REFINED_GLOWSTONE_BOOTS,
                    ToolsItems.REFINED_GLOWSTONE_SHIELD
            );
            createTag(ItemTags.CLUSTER_MAX_HARVESTABLES, item -> item instanceof ItemMekanismPickaxe || item instanceof ItemMekanismPaxel);
        }

        private void addToolTags() {
            addPaxels();
            addSwords();
            addAxes();
            addPickaxes();
            addShovels();
            addHoes();
            addShields();
            // Armor
            addHelmets();
            addChestplates();
            addLeggings();
            addBoots();
            addItemsToTag(ItemTags.TRIMMABLE_ARMOR,
                    ToolsItems.BRONZE_HELMET, ToolsItems.BRONZE_CHESTPLATE, ToolsItems.BRONZE_LEGGINGS, ToolsItems.BRONZE_BOOTS,
                    ToolsItems.LAPIS_LAZULI_HELMET, ToolsItems.LAPIS_LAZULI_CHESTPLATE, ToolsItems.LAPIS_LAZULI_LEGGINGS, ToolsItems.LAPIS_LAZULI_BOOTS,
                    ToolsItems.OSMIUM_HELMET, ToolsItems.OSMIUM_CHESTPLATE, ToolsItems.OSMIUM_LEGGINGS, ToolsItems.OSMIUM_BOOTS,
                    ToolsItems.REFINED_GLOWSTONE_HELMET, ToolsItems.REFINED_GLOWSTONE_CHESTPLATE, ToolsItems.REFINED_GLOWSTONE_LEGGINGS, ToolsItems.REFINED_GLOWSTONE_BOOTS,
                    ToolsItems.REFINED_OBSIDIAN_HELMET, ToolsItems.REFINED_OBSIDIAN_CHESTPLATE, ToolsItems.REFINED_OBSIDIAN_LEGGINGS, ToolsItems.REFINED_OBSIDIAN_BOOTS,
                    ToolsItems.STEEL_HELMET, ToolsItems.STEEL_CHESTPLATE, ToolsItems.STEEL_LEGGINGS, ToolsItems.STEEL_BOOTS
            );
        }

        private void addPaxels() {
            getOrCreateTagBuilder(ItemTags.TOOLS).addTag(ToolsTags.Items.TOOLS_PAXELS);
            addAllToBuilder(
                    ToolsTags.Items.TOOLS_PAXELS,
                    // Vanilla Paxels
                    ToolsTags.Items.TOOLS_PAXELS_WOOD,
                    ToolsTags.Items.TOOLS_PAXELS_STONE,
                    ToolsTags.Items.TOOLS_PAXELS_IRON,
                    ToolsTags.Items.TOOLS_PAXELS_GOLD,
                    ToolsTags.Items.TOOLS_PAXELS_DIAMOND,
                    ToolsTags.Items.TOOLS_PAXELS_NETHERITE,
                    // MekanismTools Paxels
                    ToolsTags.Items.TOOLS_PAXELS_BRONZE,
                    ToolsTags.Items.TOOLS_PAXELS_LAPIS_LAZULI,
                    ToolsTags.Items.TOOLS_PAXELS_OSMIUM,
                    ToolsTags.Items.TOOLS_PAXELS_REFINED_GLOWSTONE,
                    ToolsTags.Items.TOOLS_PAXELS_REFINED_OBSIDIAN,
                    ToolsTags.Items.TOOLS_PAXELS_STEEL
            );
            addItemsToTag(ToolsTags.Items.TOOLS_PAXELS_WOOD, ToolsItems.WOOD_PAXEL);
            addItemsToTag(ToolsTags.Items.TOOLS_PAXELS_STONE, ToolsItems.STONE_PAXEL);
            addItemsToTag(ToolsTags.Items.TOOLS_PAXELS_GOLD, ToolsItems.GOLD_PAXEL);
            addItemsToTag(ToolsTags.Items.TOOLS_PAXELS_IRON, ToolsItems.IRON_PAXEL);
            addItemsToTag(ToolsTags.Items.TOOLS_PAXELS_DIAMOND, ToolsItems.DIAMOND_PAXEL);
            addItemsToTag(ToolsTags.Items.TOOLS_PAXELS_NETHERITE, ToolsItems.NETHERITE_PAXEL);
            addItemsToTag(ToolsTags.Items.TOOLS_PAXELS_BRONZE, ToolsItems.BRONZE_PAXEL);
            addItemsToTag(ToolsTags.Items.TOOLS_PAXELS_LAPIS_LAZULI, ToolsItems.LAPIS_LAZULI_PAXEL);
            addItemsToTag(ToolsTags.Items.TOOLS_PAXELS_OSMIUM, ToolsItems.OSMIUM_PAXEL);
            addItemsToTag(ToolsTags.Items.TOOLS_PAXELS_REFINED_GLOWSTONE, ToolsItems.REFINED_GLOWSTONE_PAXEL);
            addItemsToTag(ToolsTags.Items.TOOLS_PAXELS_REFINED_OBSIDIAN, ToolsItems.REFINED_OBSIDIAN_PAXEL);
            addItemsToTag(ToolsTags.Items.TOOLS_PAXELS_STEEL, ToolsItems.STEEL_PAXEL);
        }

        private void addSwords() {
            addAllToBuilder(ItemTags.SWORDS,
                    ToolsTags.Items.TOOLS_SWORDS_BRONZE,
                    ToolsTags.Items.TOOLS_SWORDS_LAPIS_LAZULI,
                    ToolsTags.Items.TOOLS_SWORDS_OSMIUM,
                    ToolsTags.Items.TOOLS_SWORDS_REFINED_GLOWSTONE,
                    ToolsTags.Items.TOOLS_SWORDS_REFINED_OBSIDIAN,
                    ToolsTags.Items.TOOLS_SWORDS_STEEL
            );
            addItemsToTag(ToolsTags.Items.TOOLS_SWORDS_BRONZE, ToolsItems.BRONZE_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_SWORDS_LAPIS_LAZULI, ToolsItems.LAPIS_LAZULI_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_SWORDS_OSMIUM, ToolsItems.OSMIUM_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_SWORDS_REFINED_GLOWSTONE, ToolsItems.REFINED_GLOWSTONE_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_SWORDS_REFINED_OBSIDIAN, ToolsItems.REFINED_OBSIDIAN_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_SWORDS_STEEL, ToolsItems.STEEL_SWORD);
        }

        private void addAxes() {
            addAllToBuilder(ItemTags.AXES,
                    ToolsTags.Items.TOOLS_AXES_BRONZE,
                    ToolsTags.Items.TOOLS_AXES_LAPIS_LAZULI,
                    ToolsTags.Items.TOOLS_AXES_OSMIUM,
                    ToolsTags.Items.TOOLS_AXES_REFINED_GLOWSTONE,
                    ToolsTags.Items.TOOLS_AXES_REFINED_OBSIDIAN,
                    ToolsTags.Items.TOOLS_AXES_STEEL
            );
            addItemsToTag(ToolsTags.Items.TOOLS_AXES_BRONZE, ToolsItems.BRONZE_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_AXES_LAPIS_LAZULI, ToolsItems.LAPIS_LAZULI_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_AXES_OSMIUM, ToolsItems.OSMIUM_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_AXES_REFINED_GLOWSTONE, ToolsItems.REFINED_GLOWSTONE_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_AXES_REFINED_OBSIDIAN, ToolsItems.REFINED_OBSIDIAN_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_AXES_STEEL, ToolsItems.STEEL_SWORD);
        }

        private void addPickaxes() {
            addAllToBuilder(ItemTags.PICKAXES,
                    ToolsTags.Items.TOOLS_PICKAXES_BRONZE,
                    ToolsTags.Items.TOOLS_PICKAXES_LAPIS_LAZULI,
                    ToolsTags.Items.TOOLS_PICKAXES_OSMIUM,
                    ToolsTags.Items.TOOLS_PICKAXES_REFINED_GLOWSTONE,
                    ToolsTags.Items.TOOLS_PICKAXES_REFINED_OBSIDIAN,
                    ToolsTags.Items.TOOLS_PICKAXES_STEEL
            );
            addItemsToTag(ToolsTags.Items.TOOLS_PICKAXES_BRONZE, ToolsItems.BRONZE_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_PICKAXES_LAPIS_LAZULI, ToolsItems.LAPIS_LAZULI_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_PICKAXES_OSMIUM, ToolsItems.OSMIUM_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_PICKAXES_REFINED_GLOWSTONE, ToolsItems.REFINED_GLOWSTONE_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_PICKAXES_REFINED_OBSIDIAN, ToolsItems.REFINED_OBSIDIAN_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_PICKAXES_STEEL, ToolsItems.STEEL_SWORD);
        }

        private void addShovels() {
            addAllToBuilder(ItemTags.SHOVELS,
                    ToolsTags.Items.TOOLS_SHOVELS_BRONZE,
                    ToolsTags.Items.TOOLS_SHOVELS_LAPIS_LAZULI,
                    ToolsTags.Items.TOOLS_SHOVELS_OSMIUM,
                    ToolsTags.Items.TOOLS_SHOVELS_REFINED_GLOWSTONE,
                    ToolsTags.Items.TOOLS_SHOVELS_REFINED_OBSIDIAN,
                    ToolsTags.Items.TOOLS_SHOVELS_STEEL
            );
            addItemsToTag(ToolsTags.Items.TOOLS_SHOVELS_BRONZE, ToolsItems.BRONZE_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_SHOVELS_LAPIS_LAZULI, ToolsItems.LAPIS_LAZULI_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_SHOVELS_OSMIUM, ToolsItems.OSMIUM_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_SHOVELS_REFINED_GLOWSTONE, ToolsItems.REFINED_GLOWSTONE_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_SHOVELS_REFINED_OBSIDIAN, ToolsItems.REFINED_OBSIDIAN_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_SHOVELS_STEEL, ToolsItems.STEEL_SWORD);
        }

        private void addHoes() {
            addAllToBuilder(ItemTags.HOES,
                    ToolsTags.Items.TOOLS_HOES_BRONZE,
                    ToolsTags.Items.TOOLS_HOES_LAPIS_LAZULI,
                    ToolsTags.Items.TOOLS_HOES_OSMIUM,
                    ToolsTags.Items.TOOLS_HOES_REFINED_GLOWSTONE,
                    ToolsTags.Items.TOOLS_HOES_REFINED_OBSIDIAN,
                    ToolsTags.Items.TOOLS_HOES_STEEL
            );
            addItemsToTag(ToolsTags.Items.TOOLS_HOES_BRONZE, ToolsItems.BRONZE_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_HOES_LAPIS_LAZULI, ToolsItems.LAPIS_LAZULI_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_HOES_OSMIUM, ToolsItems.OSMIUM_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_HOES_REFINED_GLOWSTONE, ToolsItems.REFINED_GLOWSTONE_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_HOES_REFINED_OBSIDIAN, ToolsItems.REFINED_OBSIDIAN_SWORD);
            addItemsToTag(ToolsTags.Items.TOOLS_HOES_STEEL, ToolsItems.STEEL_SWORD);
        }

        private void addShields() {
            addItemsToTag(ToolsTags.Items.TOOLS_SHIELDS_BRONZE, ToolsItems.BRONZE_SHIELD);
            addItemsToTag(ToolsTags.Items.TOOLS_SHIELDS_LAPIS_LAZULI, ToolsItems.LAPIS_LAZULI_SHIELD);
            addItemsToTag(ToolsTags.Items.TOOLS_SHIELDS_OSMIUM, ToolsItems.OSMIUM_SHIELD);
            addItemsToTag(ToolsTags.Items.TOOLS_SHIELDS_REFINED_GLOWSTONE, ToolsItems.REFINED_GLOWSTONE_SHIELD);
            addItemsToTag(ToolsTags.Items.TOOLS_SHIELDS_REFINED_OBSIDIAN, ToolsItems.REFINED_OBSIDIAN_SHIELD);
            addItemsToTag(ToolsTags.Items.TOOLS_SHIELDS_STEEL, ToolsItems.STEEL_SHIELD);
        }

        private void addHelmets() {
            addItemsToTag(ToolsTags.Items.ARMORS_HELMETS_BRONZE, ToolsItems.BRONZE_HELMET);
            addItemsToTag(ToolsTags.Items.ARMORS_HELMETS_LAPIS_LAZULI, ToolsItems.LAPIS_LAZULI_HELMET);
            addItemsToTag(ToolsTags.Items.ARMORS_HELMETS_OSMIUM, ToolsItems.OSMIUM_HELMET);
            addItemsToTag(ToolsTags.Items.ARMORS_HELMETS_REFINED_GLOWSTONE, ToolsItems.REFINED_GLOWSTONE_HELMET);
            addItemsToTag(ToolsTags.Items.ARMORS_HELMETS_REFINED_OBSIDIAN, ToolsItems.REFINED_OBSIDIAN_HELMET);
            addItemsToTag(ToolsTags.Items.ARMORS_HELMETS_STEEL, ToolsItems.STEEL_HELMET);
        }

        private void addChestplates() {
            addItemsToTag(ToolsTags.Items.ARMORS_CHESTPLATES_BRONZE, ToolsItems.BRONZE_CHESTPLATE);
            addItemsToTag(ToolsTags.Items.ARMORS_CHESTPLATES_LAPIS_LAZULI, ToolsItems.LAPIS_LAZULI_CHESTPLATE);
            addItemsToTag(ToolsTags.Items.ARMORS_CHESTPLATES_OSMIUM, ToolsItems.OSMIUM_CHESTPLATE);
            addItemsToTag(ToolsTags.Items.ARMORS_CHESTPLATES_REFINED_GLOWSTONE, ToolsItems.REFINED_GLOWSTONE_CHESTPLATE);
            addItemsToTag(ToolsTags.Items.ARMORS_CHESTPLATES_REFINED_OBSIDIAN, ToolsItems.REFINED_OBSIDIAN_CHESTPLATE);
            addItemsToTag(ToolsTags.Items.ARMORS_CHESTPLATES_STEEL, ToolsItems.STEEL_CHESTPLATE);
        }

        private void addLeggings() {
            addItemsToTag(ToolsTags.Items.ARMORS_LEGGINGS_BRONZE, ToolsItems.BRONZE_LEGGINGS);
            addItemsToTag(ToolsTags.Items.ARMORS_LEGGINGS_LAPIS_LAZULI, ToolsItems.LAPIS_LAZULI_LEGGINGS);
            addItemsToTag(ToolsTags.Items.ARMORS_LEGGINGS_OSMIUM, ToolsItems.OSMIUM_LEGGINGS);
            addItemsToTag(ToolsTags.Items.ARMORS_LEGGINGS_REFINED_GLOWSTONE, ToolsItems.REFINED_GLOWSTONE_LEGGINGS);
            addItemsToTag(ToolsTags.Items.ARMORS_LEGGINGS_REFINED_OBSIDIAN, ToolsItems.REFINED_OBSIDIAN_LEGGINGS);
            addItemsToTag(ToolsTags.Items.ARMORS_LEGGINGS_STEEL, ToolsItems.STEEL_LEGGINGS);
        }

        private void addBoots() {
            addItemsToTag(ToolsTags.Items.ARMORS_BOOTS_BRONZE, ToolsItems.BRONZE_BOOTS);
            addItemsToTag(ToolsTags.Items.ARMORS_BOOTS_LAPIS_LAZULI, ToolsItems.LAPIS_LAZULI_BOOTS);
            addItemsToTag(ToolsTags.Items.ARMORS_BOOTS_OSMIUM, ToolsItems.OSMIUM_BOOTS);
            addItemsToTag(ToolsTags.Items.ARMORS_BOOTS_REFINED_GLOWSTONE, ToolsItems.REFINED_GLOWSTONE_BOOTS);
            addItemsToTag(ToolsTags.Items.ARMORS_BOOTS_REFINED_OBSIDIAN, ToolsItems.REFINED_OBSIDIAN_BOOTS);
            addItemsToTag(ToolsTags.Items.ARMORS_BOOTS_STEEL, ToolsItems.STEEL_BOOTS);
        }
        
        private void addItemsToTag(TagKey<Item> tagKey, Item... items) {
            getOrCreateTagBuilder(tagKey).add(items);
        }

        private void addTagToTag(TagKey<Item> tagKey, TagKey<Item> addedTag) {
            getOrCreateTagBuilder(tagKey).addOptionalTag(addedTag);
        }

        private void addAllToBuilder(TagKey<Item> tagKey, TagKey<Item>... addedTags) {
            for (TagKey<Item> addedTag : addedTags) {
                addTagToTag(tagKey, addedTag);
            }
        }

        private void createTag(TagKey<Item> tag, Predicate<Item> matcher) {
            for (Item item : ToolsItems.ALL_ITEMS.keySet()) {
                if (matcher.test(item)) {
                    addItemsToTag(tag, item);
                }
            }
        }
    }

    private static class MekanismToolsBlockTagGenerator extends FabricTagProvider.BlockTagProvider {

        public MekanismToolsBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            addAllToBuilder(ToolsTags.Blocks.MINEABLE_WITH_PAXEL,
                    BlockTags.AXE_MINEABLE,
                    BlockTags.PICKAXE_MINEABLE,
                    BlockTags.SHOVEL_MINEABLE
            );

        }

        private void addTagToTag(TagKey<Block> tagKey, TagKey<Block> addedTag) {
            getOrCreateTagBuilder(tagKey).addOptionalTag(addedTag);
        }

        private void addAllToBuilder(TagKey<Block> tagKey, TagKey<Block>... addedTags) {
            for (TagKey<Block> addedTag : addedTags) {
                addTagToTag(tagKey, addedTag);
            }
        }
    }
}
