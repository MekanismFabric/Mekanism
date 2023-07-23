package mekanism;

import mekanism.advancements.MekanismAdvancement;
import mekanism.advancements.MekanismAdvancements;
import mekanism.advancements.MekanismCriterion;
import mekanism.registries.MekanismBlocks;
import mekanism.registries.MekanismItems;
import mekanism.resource.PrimaryResources;
import mekanism.resource.ResourceTypes;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.text.Text;

import java.util.List;
import java.util.function.Consumer;

import static mekanism.Mekanism.id;

public class MekanismDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        final FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(MekanismRecipeGenerator::new);
        pack.addProvider(MekanismAdvancementGenerator::new);
//        pack.addProvider(MekanismLangGenerator::new);
    }

    private static class MekanismRecipeGenerator extends FabricRecipeProvider {

        private static final String INGOT_TO_BLOCK_PATH = "ingot_to_block/";
        private static final String INGOT_TO_NUGGET_PATH = "ingot_to_nugget/";
        private static final String BLOCK_TO_INGOT_PATH = "block_to_ingot/";
        private static final String NUGGET_TO_INGOT_PATH = "nugget_to_ingot/";
        private static final String ORE_TO_INGOT_PATH = "ore_to_ingot/";
        private static final String DUST_TO_INGOT_PATH = "dust_to_ingot/";
        private static final String SMELTING_PATH = "smelting/";
        private static final String BLASTING_PATH = "blasting/";

        private MekanismRecipeGenerator(FabricDataOutput output) {
            super(output);
        }

        private String extractIdentifier(ItemConvertible output) {
            String[] translationKeyParts = output.asItem().getTranslationKey().split("\\.");
            return translationKeyParts[translationKeyParts.length - 1];
        }

        private void createShapelessRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible input, ItemConvertible output, String path) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, 9)
                    .input(input)
                    .criterion(FabricRecipeProvider.hasItem(output),
                            FabricRecipeProvider.conditionsFromItem(output))
                    .criterion(FabricRecipeProvider.hasItem(input),
                            FabricRecipeProvider.conditionsFromItem(input))
                    .offerTo(exporter, path + extractIdentifier(output));
        }

        private void create3x3ShapedRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible input, ItemConvertible output, RecipeCategory category, String path) {
            ShapedRecipeJsonBuilder.create(category, output)
                    .pattern("aaa").pattern("aaa").pattern("aaa")
                    .input('a', input)
                    .criterion(FabricRecipeProvider.hasItem(input),
                            FabricRecipeProvider.conditionsFromItem(input))
                    .criterion(FabricRecipeProvider.hasItem(output),
                            FabricRecipeProvider.conditionsFromItem(output))
                    .offerTo(exporter, path + extractIdentifier(output));
        }

        private void createShapelessBlockToIngotRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible input, ItemConvertible output) {
            createShapelessRecipe(exporter, input, output, BLOCK_TO_INGOT_PATH);
        }

        private void createShapelessIngotToNuggetRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible input, ItemConvertible output) {
            createShapelessRecipe(exporter, input, output, INGOT_TO_NUGGET_PATH);
        }

        private void createShapedIngotToBlockRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible input, ItemConvertible output) {
            create3x3ShapedRecipe(exporter, input, output, RecipeCategory.BUILDING_BLOCKS, INGOT_TO_BLOCK_PATH);
        }

        private void createShapedNuggetToIngotRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible input, ItemConvertible output) {
            create3x3ShapedRecipe(exporter, input, output, RecipeCategory.MISC, NUGGET_TO_INGOT_PATH);
        }

        private void createShapelessBlockToIngotRecipeFromResource(Consumer<RecipeJsonProvider> exporter, PrimaryResources resource) {
            ItemConvertible inputRaw = MekanismBlocks.PROCESSED_RESOURCE_BLOCKS.get(resource.getRawResourceBlockInfo());
            ItemConvertible input = MekanismBlocks.PROCESSED_RESOURCE_BLOCKS.get(resource);
            ItemConvertible outputRaw = MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.RAW, resource);
            ItemConvertible output = MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.INGOT, resource);

            if (output != null) {
                createShapelessBlockToIngotRecipe(exporter, input, output);
            }

            if (outputRaw != null) {
                createShapelessBlockToIngotRecipe(exporter, inputRaw, outputRaw);
            }
        }

        private void createShapelessIngotToNuggetRecipeFromResource(Consumer<RecipeJsonProvider> exporter, PrimaryResources resource) {
            ItemConvertible input = MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.INGOT, resource);
            ItemConvertible output = MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.NUGGET, resource);

            if (output != null && input != null) {
                createShapelessIngotToNuggetRecipe(exporter, input, output);
            }
        }

        private void createShapedIngotToBlockRecipeFromResource(Consumer<RecipeJsonProvider> exporter, PrimaryResources resource) {
            ItemConvertible inputRaw = MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.RAW, resource);
            ItemConvertible input = MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.INGOT, resource);
            ItemConvertible outputRaw = MekanismBlocks.PROCESSED_RESOURCE_BLOCKS.get(resource.getRawResourceBlockInfo());
            ItemConvertible output = MekanismBlocks.PROCESSED_RESOURCE_BLOCKS.get(resource);

            if (input != null) {
                createShapedIngotToBlockRecipe(exporter, input, output);
            }

            if (inputRaw != null) {
                createShapedIngotToBlockRecipe(exporter, inputRaw, outputRaw);
            }
        }

        private void createShapedNuggetToIngotRecipeFromResource(Consumer<RecipeJsonProvider> exporter, PrimaryResources resource) {
            ItemConvertible input = MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.NUGGET, resource);
            ItemConvertible output = MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.INGOT, resource);

            if (output != null && input != null) {
                createShapedNuggetToIngotRecipe(exporter, input, output);
            }
        }

        private void createCookingRecipe(Consumer<RecipeJsonProvider> exporter, List<ItemConvertible> inputs, ItemConvertible output, String path) {
            RecipeProvider.offerSmelting(exporter, inputs, RecipeCategory.MISC, output, 0.45F, 300, SMELTING_PATH + path);
            RecipeProvider.offerBlasting(exporter, inputs, RecipeCategory.MISC, output, 0.45F, 300, BLASTING_PATH + path);
        }

        private void createCookingRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible input, ItemConvertible output, String path) {
            createCookingRecipe(exporter, List.of(input), output, path);
        }

        @Override
        public void generate(Consumer<RecipeJsonProvider> exporter) {
            for (PrimaryResources resource : PrimaryResources.values()) {
                if (!resource.isVanilla()) {
                    createShapelessBlockToIngotRecipeFromResource(exporter, resource);
                    createShapelessIngotToNuggetRecipeFromResource(exporter, resource);
                    createShapedIngotToBlockRecipeFromResource(exporter, resource);
                    createShapedNuggetToIngotRecipeFromResource(exporter, resource);
                    createCookingRecipe(exporter, MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.DUST, resource), MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.INGOT, resource), DUST_TO_INGOT_PATH);
                }
            }

            // Block to Ingot
            createShapelessBlockToIngotRecipe(exporter, MekanismBlocks.BRONZE_BLOCK, MekanismItems.BRONZE_INGOT);
            createShapelessBlockToIngotRecipe(exporter, MekanismBlocks.REFINED_OBSIDIAN_BLOCK, MekanismItems.REFINED_OBSIDIAN_INGOT);
            createShapelessBlockToIngotRecipe(exporter, MekanismBlocks.REFINED_GLOWSTONE_BLOCK, MekanismItems.REFINED_GLOWSTONE_INGOT);
            createShapelessBlockToIngotRecipe(exporter, MekanismBlocks.STEEL_BLOCK, MekanismItems.STEEL_INGOT);
            createShapelessBlockToIngotRecipe(exporter, MekanismBlocks.CHARCOAL_BLOCK, Items.CHARCOAL);
            createShapelessBlockToIngotRecipe(exporter, MekanismBlocks.FLUORITE_BLOCK, MekanismItems.FLUORITE_GEM);

            // Ingot to Nugget\
            createShapelessIngotToNuggetRecipe(exporter, MekanismItems.BRONZE_INGOT, MekanismItems.BRONZE_NUGGET);
            createShapelessIngotToNuggetRecipe(exporter, MekanismItems.REFINED_OBSIDIAN_INGOT, MekanismItems.REFINED_OBSIDIAN_NUGGET);
            createShapelessIngotToNuggetRecipe(exporter, MekanismItems.REFINED_GLOWSTONE_INGOT, MekanismItems.REFINED_GLOWSTONE_NUGGET);
            createShapelessIngotToNuggetRecipe(exporter, MekanismItems.STEEL_INGOT, MekanismItems.STEEL_NUGGET);

            // Ingot to Block
            createShapedIngotToBlockRecipe(exporter, MekanismItems.BRONZE_INGOT, MekanismBlocks.BRONZE_BLOCK);
            createShapedIngotToBlockRecipe(exporter, MekanismItems.REFINED_OBSIDIAN_INGOT, MekanismBlocks.REFINED_OBSIDIAN_BLOCK);
            createShapedIngotToBlockRecipe(exporter, MekanismItems.REFINED_GLOWSTONE_INGOT, MekanismBlocks.REFINED_GLOWSTONE_BLOCK);
            createShapedIngotToBlockRecipe(exporter, MekanismItems.STEEL_INGOT, MekanismBlocks.STEEL_BLOCK);
            createShapedIngotToBlockRecipe(exporter, Items.CHARCOAL, MekanismBlocks.CHARCOAL_BLOCK);
            createShapedIngotToBlockRecipe(exporter, MekanismItems.FLUORITE_GEM, MekanismBlocks.FLUORITE_BLOCK);

            // Nugget to Ingot
            createShapedNuggetToIngotRecipe(exporter, MekanismItems.BRONZE_NUGGET, MekanismItems.BRONZE_INGOT);
            createShapedNuggetToIngotRecipe(exporter, MekanismItems.REFINED_OBSIDIAN_NUGGET, MekanismItems.REFINED_OBSIDIAN_INGOT);
            createShapedNuggetToIngotRecipe(exporter, MekanismItems.REFINED_GLOWSTONE_NUGGET, MekanismItems.REFINED_GLOWSTONE_INGOT);
            createShapedNuggetToIngotRecipe(exporter, MekanismItems.STEEL_NUGGET, MekanismItems.STEEL_INGOT);

            // Smelting + Blasting
            createCookingRecipe(exporter, MekanismItems.BRONZE_DUST, MekanismItems.BRONZE_INGOT, DUST_TO_INGOT_PATH);
            createCookingRecipe(exporter, MekanismItems.STEEL_DUST, MekanismItems.STEEL_INGOT, DUST_TO_INGOT_PATH);
            createCookingRecipe(exporter, MekanismItems.NETHERITE_DUST, Items.NETHERITE_INGOT, DUST_TO_INGOT_PATH);
            createCookingRecipe(exporter, MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.DUST, PrimaryResources.GOLD), Items.GOLD_INGOT, DUST_TO_INGOT_PATH);
            createCookingRecipe(exporter, MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.DUST, PrimaryResources.IRON), Items.IRON_INGOT, DUST_TO_INGOT_PATH);
            createCookingRecipe(exporter, MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.DUST, PrimaryResources.COPPER), Items.COPPER_INGOT, DUST_TO_INGOT_PATH);
            createCookingRecipe(exporter, List.of(MekanismBlocks.OSMIUM_ORE, MekanismBlocks.DEEPSLATE_OSMIUM_ORE), MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.INGOT, PrimaryResources.OSMIUM), ORE_TO_INGOT_PATH);
            createCookingRecipe(exporter, List.of(MekanismBlocks.TIN_ORE, MekanismBlocks.DEEPSLATE_TIN_ORE), MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.INGOT, PrimaryResources.TIN), ORE_TO_INGOT_PATH);
            createCookingRecipe(exporter, List.of(MekanismBlocks.LEAD_ORE, MekanismBlocks.DEEPSLATE_LEAD_ORE), MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.INGOT, PrimaryResources.LEAD), ORE_TO_INGOT_PATH);
            createCookingRecipe(exporter, List.of(MekanismBlocks.URANIUM_ORE, MekanismBlocks.DEEPSLATE_URANIUM_ORE), MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.INGOT, PrimaryResources.URANIUM), ORE_TO_INGOT_PATH);
            createCookingRecipe(exporter, List.of(MekanismBlocks.FLUORITE_ORE, MekanismBlocks.DEEPSLATE_FLUORITE_ORE), MekanismItems.FLUORITE_GEM, ORE_TO_INGOT_PATH);

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MekanismBlocks.SALT_BLOCK).pattern("ss ").pattern("ss ")
                    .input('s', MekanismItems.SALT)
                    .criterion(FabricRecipeProvider.hasItem(MekanismItems.SALT),
                            FabricRecipeProvider.conditionsFromItem(MekanismItems.SALT))
                    .criterion(FabricRecipeProvider.hasItem(MekanismBlocks.SALT_BLOCK),
                            FabricRecipeProvider.conditionsFromItem(MekanismBlocks.SALT_BLOCK))
                    .offerTo(exporter);
        }
    }

    private static class MekanismAdvancementGenerator extends FabricAdvancementProvider {

        protected MekanismAdvancementGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateAdvancement(Consumer<Advancement> consumer) {
            Advancement root = Advancement.Builder.create()
                .display(
                    MekanismItems.EMERALD_DUST,
                    Text.translatable(MekanismAdvancements.ROOT.title()),
                    Text.translatable(MekanismAdvancements.ROOT.description()),
                    id("textures/block/block_osmium.png"),
                    AdvancementFrame.GOAL,
                    false,
                    false,
                    false
                )
                .criterion("automatic", new TickCriterion.Conditions(MekanismCriterion.LOGGED_IN.getId(), LootContextPredicate.EMPTY))
                .build(id("root"));
            consumer.accept(root);

            Advancement materials = Advancement.Builder.create()
                .parent(root)
                .display(
                    MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.INGOT, PrimaryResources.OSMIUM),
                    Text.translatable(MekanismAdvancements.MATERIALS.title()),
                    Text.translatable(MekanismAdvancements.MATERIALS.description()),
                    null,
                    AdvancementFrame.TASK,
                    true,
                    false,
                    false
                )
                .criterion("material", InventoryChangedCriterion.Conditions.items(
                    MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.INGOT, PrimaryResources.OSMIUM),
                    MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.INGOT, PrimaryResources.TIN),
                    MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.INGOT, PrimaryResources.LEAD),
                    MekanismItems.PROCESSED_RESOURCES.get(ResourceTypes.INGOT, PrimaryResources.URANIUM)
                ))
                .build(id("materials"));
            consumer.accept(materials);
        }
    }

    private static class MekanismLangGenerator extends FabricLanguageProvider {

        private MekanismLangGenerator(FabricDataOutput dataGenerator) {
            super(dataGenerator, "en_us");
        }

        @Override
        public void generateTranslations(TranslationBuilder translationBuilder) {
            addAdvancement(translationBuilder, MekanismAdvancements.ROOT, "Mekanism", "Welcome to Mekanism!");
            addAdvancement(translationBuilder, MekanismAdvancements.MATERIALS, "First Steps", "Acquire some natural Mekanism resources");
        }

        private void addAdvancement(TranslationBuilder translationBuilder, MekanismAdvancement advancement, String title, String description) {
            translationBuilder.add(advancement.title(), title);
            translationBuilder.add(advancement.description(), description);
        }
    }
}