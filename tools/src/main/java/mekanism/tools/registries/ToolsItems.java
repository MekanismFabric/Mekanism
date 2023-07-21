package mekanism.tools.registries;

import mekanism.tools.MekanismTools;
import mekanism.tools.config.tools.RefinedGlowstone;
import mekanism.tools.item.*;
import mekanism.tools.material.BaseMekanismMaterial;
import mekanism.tools.material.MaterialCreator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import static mekanism.tools.MekanismTools.id;

public class ToolsItems {

    public static final Map<Item, String> ALL_SHIELDS = new HashMap<>();
    public static final Map<Item, String> ALL_ITEMS = new HashMap<>();
    public static final List<ItemStack> ALL_TOOLS = new ArrayList<>();

    public static final TagKey<Block> PAXEL_MINEABLE = TagKey.of(RegistryKeys.BLOCK, MekanismTools.id("mineable/paxel"));
    public static final int REFINED_GLOWSTONE_LIGHT_LEVEL = 0xF000F0;

    public static final ItemMekanismPaxel WOOD_PAXEL = registerPaxel(ToolMaterials.WOOD);
    public static final ItemMekanismPaxel STONE_PAXEL = registerPaxel(ToolMaterials.STONE);
    public static final ItemMekanismPaxel IRON_PAXEL = registerPaxel(ToolMaterials.IRON);
    public static final ItemMekanismPaxel GOLD_PAXEL = registerPaxel(ToolMaterials.GOLD);
    public static final ItemMekanismPaxel DIAMOND_PAXEL = registerPaxel(ToolMaterials.DIAMOND);
    public static final ItemMekanismPaxel NETHERITE_PAXEL = registerPaxel(ToolMaterials.NETHERITE);

    public static final ItemMekanismPickaxe BRONZE_PICKAXE = registerPickaxe(MekanismTools.config().bronzeMaterialStats);
    public static final ItemMekanismAxe BRONZE_AXE = registerAxe(MekanismTools.config().bronzeMaterialStats);
    public static final ItemMekanismShovel BRONZE_SHOVEL = registerShovel(MekanismTools.config().bronzeMaterialStats);
    public static final ItemMekanismHoe BRONZE_HOE = registerHoe(MekanismTools.config().bronzeMaterialStats);
    public static final ItemMekanismSword BRONZE_SWORD = registerSword(MekanismTools.config().bronzeMaterialStats);
    public static final ItemMekanismPaxel BRONZE_PAXEL = registerPaxel(MekanismTools.config().bronzeMaterialStats);
    public static final ItemMekanismArmor BRONZE_HELMET = registerArmor(MekanismTools.config().bronzeMaterialStats, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor BRONZE_CHESTPLATE = registerArmor(MekanismTools.config().bronzeMaterialStats, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor BRONZE_LEGGINGS = registerArmor(MekanismTools.config().bronzeMaterialStats, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor BRONZE_BOOTS = registerArmor(MekanismTools.config().bronzeMaterialStats, ArmorItem.Type.BOOTS);
    public static final ItemMekanismShield BRONZE_SHIELD = registerShield(MekanismTools.config().bronzeMaterialStats);

    public static final ItemMekanismPickaxe LAPIS_LAZULI_PICKAXE = registerPickaxe(MekanismTools.config().lapisLazuliMaterialStats);
    public static final ItemMekanismAxe LAPIS_LAZULI_AXE = registerAxe(MekanismTools.config().lapisLazuliMaterialStats);
    public static final ItemMekanismShovel LAPIS_LAZULI_SHOVEL = registerShovel(MekanismTools.config().lapisLazuliMaterialStats);
    public static final ItemMekanismHoe LAPIS_LAZULI_HOE = registerHoe(MekanismTools.config().lapisLazuliMaterialStats);
    public static final ItemMekanismSword LAPIS_LAZULI_SWORD = registerSword(MekanismTools.config().lapisLazuliMaterialStats);
    public static final ItemMekanismPaxel LAPIS_LAZULI_PAXEL = registerPaxel(MekanismTools.config().lapisLazuliMaterialStats);
    public static final ItemMekanismArmor LAPIS_LAZULI_HELMET = registerArmor(MekanismTools.config().lapisLazuliMaterialStats, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor LAPIS_LAZULI_CHESTPLATE = registerArmor(MekanismTools.config().lapisLazuliMaterialStats, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor LAPIS_LAZULI_LEGGINGS = registerArmor(MekanismTools.config().lapisLazuliMaterialStats, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor LAPIS_LAZULI_BOOTS = registerArmor(MekanismTools.config().lapisLazuliMaterialStats, ArmorItem.Type.BOOTS);
    public static final ItemMekanismShield LAPIS_LAZULI_SHIELD = registerShield(MekanismTools.config().lapisLazuliMaterialStats);

    public static final ItemMekanismPickaxe OSMIUM_PICKAXE = registerPickaxe(MekanismTools.config().osmiumMaterialStats);
    public static final ItemMekanismAxe OSMIUM_AXE = registerAxe(MekanismTools.config().osmiumMaterialStats);
    public static final ItemMekanismShovel OSMIUM_SHOVEL = registerShovel(MekanismTools.config().osmiumMaterialStats);
    public static final ItemMekanismHoe OSMIUM_HOE = registerHoe(MekanismTools.config().osmiumMaterialStats);
    public static final ItemMekanismSword OSMIUM_SWORD = registerSword(MekanismTools.config().osmiumMaterialStats);
    public static final ItemMekanismPaxel OSMIUM_PAXEL = registerPaxel(MekanismTools.config().osmiumMaterialStats);
    public static final ItemMekanismArmor OSMIUM_HELMET = registerArmor(MekanismTools.config().osmiumMaterialStats, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor OSMIUM_CHESTPLATE = registerArmor(MekanismTools.config().osmiumMaterialStats, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor OSMIUM_LEGGINGS = registerArmor(MekanismTools.config().osmiumMaterialStats, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor OSMIUM_BOOTS = registerArmor(MekanismTools.config().osmiumMaterialStats, ArmorItem.Type.BOOTS);
    public static final ItemMekanismShield OSMIUM_SHIELD = registerShield(MekanismTools.config().osmiumMaterialStats);

    public static final ItemMekanismPickaxe REFINED_GLOWSTONE_PICKAXE = registerPickaxe(MekanismTools.config().refinedGlowstoneMaterialStats);
    public static final ItemMekanismAxe REFINED_GLOWSTONE_AXE = registerAxe(MekanismTools.config().refinedGlowstoneMaterialStats);
    public static final ItemMekanismShovel REFINED_GLOWSTONE_SHOVEL = registerShovel(MekanismTools.config().refinedGlowstoneMaterialStats);
    public static final ItemMekanismHoe REFINED_GLOWSTONE_HOE = registerHoe(MekanismTools.config().refinedGlowstoneMaterialStats);
    public static final ItemMekanismSword REFINED_GLOWSTONE_SWORD = registerSword(MekanismTools.config().refinedGlowstoneMaterialStats);
    public static final ItemMekanismPaxel REFINED_GLOWSTONE_PAXEL = registerPaxel(MekanismTools.config().refinedGlowstoneMaterialStats);
    public static final ItemMekanismArmor REFINED_GLOWSTONE_HELMET = registerArmor(MekanismTools.config().refinedGlowstoneMaterialStats, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor REFINED_GLOWSTONE_CHESTPLATE = registerArmor(MekanismTools.config().refinedGlowstoneMaterialStats, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor REFINED_GLOWSTONE_LEGGINGS = registerArmor(MekanismTools.config().refinedGlowstoneMaterialStats, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor REFINED_GLOWSTONE_BOOTS = registerArmor(MekanismTools.config().refinedGlowstoneMaterialStats, ArmorItem.Type.BOOTS);
    public static final ItemMekanismShield REFINED_GLOWSTONE_SHIELD = registerShield(MekanismTools.config().refinedGlowstoneMaterialStats);

    public static final ItemMekanismPickaxe REFINED_OBSIDIAN_PICKAXE = registerPickaxe(MekanismTools.config().refinedObsidianMaterialStats);
    public static final ItemMekanismAxe REFINED_OBSIDIAN_AXE = registerAxe(MekanismTools.config().refinedObsidianMaterialStats);
    public static final ItemMekanismShovel REFINED_OBSIDIAN_SHOVEL = registerShovel(MekanismTools.config().refinedObsidianMaterialStats);
    public static final ItemMekanismHoe REFINED_OBSIDIAN_HOE = registerHoe(MekanismTools.config().refinedObsidianMaterialStats);
    public static final ItemMekanismSword REFINED_OBSIDIAN_SWORD = registerSword(MekanismTools.config().refinedObsidianMaterialStats);
    public static final ItemMekanismPaxel REFINED_OBSIDIAN_PAXEL = registerPaxel(MekanismTools.config().refinedObsidianMaterialStats);
    public static final ItemMekanismArmor REFINED_OBSIDIAN_HELMET = registerArmor(MekanismTools.config().refinedObsidianMaterialStats, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor REFINED_OBSIDIAN_CHESTPLATE = registerArmor(MekanismTools.config().refinedObsidianMaterialStats, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor REFINED_OBSIDIAN_LEGGINGS = registerArmor(MekanismTools.config().refinedObsidianMaterialStats, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor REFINED_OBSIDIAN_BOOTS = registerArmor(MekanismTools.config().refinedObsidianMaterialStats, ArmorItem.Type.BOOTS);
    public static final ItemMekanismShield REFINED_OBSIDIAN_SHIELD = registerShield(MekanismTools.config().refinedObsidianMaterialStats);

    public static final ItemMekanismPickaxe STEEL_PICKAXE = registerPickaxe(MekanismTools.config().steelMaterialStats);
    public static final ItemMekanismAxe STEEL_AXE = registerAxe(MekanismTools.config().steelMaterialStats);
    public static final ItemMekanismShovel STEEL_SHOVEL = registerShovel(MekanismTools.config().steelMaterialStats);
    public static final ItemMekanismHoe STEEL_HOE = registerHoe(MekanismTools.config().steelMaterialStats);
    public static final ItemMekanismSword STEEL_SWORD = registerSword(MekanismTools.config().steelMaterialStats);
    public static final ItemMekanismPaxel STEEL_PAXEL = registerPaxel(MekanismTools.config().steelMaterialStats);
    public static final ItemMekanismArmor STEEL_HELMET = registerArmor(MekanismTools.config().steelMaterialStats, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor STEEL_CHESTPLATE = registerArmor(MekanismTools.config().steelMaterialStats, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor STEEL_LEGGINGS = registerArmor(MekanismTools.config().steelMaterialStats, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor STEEL_BOOTS = registerArmor(MekanismTools.config().steelMaterialStats, ArmorItem.Type.BOOTS);
    public static final ItemMekanismShield STEEL_SHIELD = registerShield(MekanismTools.config().steelMaterialStats);

    public static void registerTools() {}

    private static ItemMekanismPickaxe registerPickaxe(BaseMekanismMaterial material) {
        return register(ItemMekanismPickaxe::new, "_pickaxe", material);
    }

    private static ItemMekanismAxe registerAxe(BaseMekanismMaterial material) {
        return register(ItemMekanismAxe::new, "_axe", material);
    }

    private static ItemMekanismShovel registerShovel(BaseMekanismMaterial material) {
        return register(ItemMekanismShovel::new, "_shovel", material);
    }

    private static ItemMekanismHoe registerHoe(BaseMekanismMaterial material) {
        return register(ItemMekanismHoe::new, "_hoe", material);
    }

    private static ItemMekanismSword registerSword(BaseMekanismMaterial material) {
        return register(ItemMekanismSword::new, "_sword", material);
    }

    private static ItemMekanismPaxel registerPaxel(BaseMekanismMaterial material) {
        return register(ItemMekanismPaxel::new, "_paxel", material);
    }

    private static ItemMekanismPaxel registerPaxel(ToolMaterials material) {
        if (material == ToolMaterials.NETHERITE) {
            return registerVanilla(ItemMekanismPaxel::new, material, new FabricItemSettings().fireproof());
        }
        return registerVanilla(ItemMekanismPaxel::new, material, new FabricItemSettings());
    }

    private static ItemMekanismArmor registerArmor(BaseMekanismMaterial material, ArmorItem.Type armorType) {
        return registerArmor(material, armorType, ItemMekanismArmor::new, material instanceof RefinedGlowstone);
    }

    private static ItemMekanismShield registerShield(BaseMekanismMaterial materialCreator) {
        return register(ItemMekanismShield::new, "_shield", materialCreator);
    }

    private static <ITEM extends Item> ITEM register(BiFunction<BaseMekanismMaterial, Item.Settings, ITEM> itemCreator, String suffix, BaseMekanismMaterial material) {
        return register(itemCreator, suffix, material, new FabricItemSettings());
    }

    private static <ITEM extends Item> ITEM register(BiFunction<BaseMekanismMaterial, Item.Settings, ITEM> itemCreator, String suffix, BaseMekanismMaterial material, FabricItemSettings settings) {
        ITEM item = itemCreator.apply(material, settings);
        String itemKey = material.getRegistryPrefix() + suffix;
        ALL_TOOLS.add(item.getDefaultStack());
        if (item instanceof ItemMekanismShield) {
            ALL_SHIELDS.put(item, itemKey);
        } else {
            ALL_ITEMS.put(item, itemKey);
        }
        return Registry.register(Registries.ITEM, id(itemKey), item);
    }

    private static <ITEM extends Item> ITEM registerVanilla(BiFunction<ToolMaterials, Item.Settings, ITEM> itemCreator, ToolMaterials material, FabricItemSettings settings) {
        ITEM item = itemCreator.apply(material, settings);
        String itemKey = material.name().toLowerCase() + "_paxel";
        ALL_TOOLS.add(item.getDefaultStack());
        ALL_ITEMS.put(item, itemKey);
        return Registry.register(Registries.ITEM, id(itemKey), item);
    }

    private static ItemMekanismArmor registerArmor(BaseMekanismMaterial material, ArmorItem.Type armorType, ArmorCreator armorCreator, boolean makesPiglinsNeutral) {
        ItemMekanismArmor armor = armorCreator.create(new MaterialCreator(material), armorType, new FabricItemSettings(), makesPiglinsNeutral);
        String itemKey = material.getRegistryPrefix() + "_" + armorType.getName();
        ALL_TOOLS.add(armor.getDefaultStack());
        ALL_ITEMS.put(armor, itemKey);
        return Registry.register(Registries.ITEM, id(itemKey), armor);
    }

    private interface ArmorCreator {
        ItemMekanismArmor create(MaterialCreator material, ArmorItem.Type armorType, Item.Settings settings, boolean makesPiglinsNeutral);
    }
}
