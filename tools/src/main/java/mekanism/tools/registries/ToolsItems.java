package mekanism.tools.registries;

import mekanism.tools.MekanismTools;
import mekanism.tools.config.tools.RefinedGlowstone;
import mekanism.tools.config.tools.Tools;
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

    private static Tools config = MekanismTools.config().config;

    public static final ItemMekanismPaxel WOOD_PAXEL = registerPaxel(ToolMaterials.WOOD);
    public static final ItemMekanismPaxel STONE_PAXEL = registerPaxel(ToolMaterials.STONE);
    public static final ItemMekanismPaxel IRON_PAXEL = registerPaxel(ToolMaterials.IRON);
    public static final ItemMekanismPaxel GOLD_PAXEL = registerPaxel(ToolMaterials.GOLD);
    public static final ItemMekanismPaxel DIAMOND_PAXEL = registerPaxel(ToolMaterials.DIAMOND);
    public static final ItemMekanismPaxel NETHERITE_PAXEL = registerPaxel(ToolMaterials.NETHERITE);

    public static final ItemMekanismPickaxe BRONZE_PICKAXE = registerPickaxe(config.bronzeMaterialStats);
    public static final ItemMekanismAxe BRONZE_AXE = registerAxe(config.bronzeMaterialStats);
    public static final ItemMekanismShovel BRONZE_SHOVEL = registerShovel(config.bronzeMaterialStats);
    public static final ItemMekanismHoe BRONZE_HOE = registerHoe(config.bronzeMaterialStats);
    public static final ItemMekanismSword BRONZE_SWORD = registerSword(config.bronzeMaterialStats);
    public static final ItemMekanismPaxel BRONZE_PAXEL = registerPaxel(config.bronzeMaterialStats);
    public static final ItemMekanismArmor BRONZE_HELMET = registerArmor(config.bronzeMaterialStats, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor BRONZE_CHESTPLATE = registerArmor(config.bronzeMaterialStats, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor BRONZE_LEGGINGS = registerArmor(config.bronzeMaterialStats, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor BRONZE_BOOTS = registerArmor(config.bronzeMaterialStats, ArmorItem.Type.BOOTS);
    public static final ItemMekanismShield BRONZE_SHIELD = registerShield(config.bronzeMaterialStats);

    public static final ItemMekanismPickaxe LAPIS_LAZULI_PICKAXE = registerPickaxe(config.lapisLazuliMaterialStats);
    public static final ItemMekanismAxe LAPIS_LAZULI_AXE = registerAxe(config.lapisLazuliMaterialStats);
    public static final ItemMekanismShovel LAPIS_LAZULI_SHOVEL = registerShovel(config.lapisLazuliMaterialStats);
    public static final ItemMekanismHoe LAPIS_LAZULI_HOE = registerHoe(config.lapisLazuliMaterialStats);
    public static final ItemMekanismSword LAPIS_LAZULI_SWORD = registerSword(config.lapisLazuliMaterialStats);
    public static final ItemMekanismPaxel LAPIS_LAZULI_PAXEL = registerPaxel(config.lapisLazuliMaterialStats);
    public static final ItemMekanismArmor LAPIS_LAZULI_HELMET = registerArmor(config.lapisLazuliMaterialStats, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor LAPIS_LAZULI_CHESTPLATE = registerArmor(config.lapisLazuliMaterialStats, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor LAPIS_LAZULI_LEGGINGS = registerArmor(config.lapisLazuliMaterialStats, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor LAPIS_LAZULI_BOOTS = registerArmor(config.lapisLazuliMaterialStats, ArmorItem.Type.BOOTS);
    public static final ItemMekanismShield LAPIS_LAZULI_SHIELD = registerShield(config.lapisLazuliMaterialStats);

    public static final ItemMekanismPickaxe OSMIUM_PICKAXE = registerPickaxe(config.osmiumMaterialStats);
    public static final ItemMekanismAxe OSMIUM_AXE = registerAxe(config.osmiumMaterialStats);
    public static final ItemMekanismShovel OSMIUM_SHOVEL = registerShovel(config.osmiumMaterialStats);
    public static final ItemMekanismHoe OSMIUM_HOE = registerHoe(config.osmiumMaterialStats);
    public static final ItemMekanismSword OSMIUM_SWORD = registerSword(config.osmiumMaterialStats);
    public static final ItemMekanismPaxel OSMIUM_PAXEL = registerPaxel(config.osmiumMaterialStats);
    public static final ItemMekanismArmor OSMIUM_HELMET = registerArmor(config.osmiumMaterialStats, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor OSMIUM_CHESTPLATE = registerArmor(config.osmiumMaterialStats, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor OSMIUM_LEGGINGS = registerArmor(config.osmiumMaterialStats, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor OSMIUM_BOOTS = registerArmor(config.osmiumMaterialStats, ArmorItem.Type.BOOTS);
    public static final ItemMekanismShield OSMIUM_SHIELD = registerShield(config.osmiumMaterialStats);

    public static final ItemMekanismPickaxe REFINED_GLOWSTONE_PICKAXE = registerPickaxe(config.refinedGlowstoneMaterialStats);
    public static final ItemMekanismAxe REFINED_GLOWSTONE_AXE = registerAxe(config.refinedGlowstoneMaterialStats);
    public static final ItemMekanismShovel REFINED_GLOWSTONE_SHOVEL = registerShovel(config.refinedGlowstoneMaterialStats);
    public static final ItemMekanismHoe REFINED_GLOWSTONE_HOE = registerHoe(config.refinedGlowstoneMaterialStats);
    public static final ItemMekanismSword REFINED_GLOWSTONE_SWORD = registerSword(config.refinedGlowstoneMaterialStats);
    public static final ItemMekanismPaxel REFINED_GLOWSTONE_PAXEL = registerPaxel(config.refinedGlowstoneMaterialStats);
    public static final ItemMekanismArmor REFINED_GLOWSTONE_HELMET = registerArmor(config.refinedGlowstoneMaterialStats, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor REFINED_GLOWSTONE_CHESTPLATE = registerArmor(config.refinedGlowstoneMaterialStats, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor REFINED_GLOWSTONE_LEGGINGS = registerArmor(config.refinedGlowstoneMaterialStats, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor REFINED_GLOWSTONE_BOOTS = registerArmor(config.refinedGlowstoneMaterialStats, ArmorItem.Type.BOOTS);
    public static final ItemMekanismShield REFINED_GLOWSTONE_SHIELD = registerShield(config.refinedGlowstoneMaterialStats);

    public static final ItemMekanismPickaxe REFINED_OBSIDIAN_PICKAXE = registerPickaxe(config.refinedObsidianMaterialStats);
    public static final ItemMekanismAxe REFINED_OBSIDIAN_AXE = registerAxe(config.refinedObsidianMaterialStats);
    public static final ItemMekanismShovel REFINED_OBSIDIAN_SHOVEL = registerShovel(config.refinedObsidianMaterialStats);
    public static final ItemMekanismHoe REFINED_OBSIDIAN_HOE = registerHoe(config.refinedObsidianMaterialStats);
    public static final ItemMekanismSword REFINED_OBSIDIAN_SWORD = registerSword(config.refinedObsidianMaterialStats);
    public static final ItemMekanismPaxel REFINED_OBSIDIAN_PAXEL = registerPaxel(config.refinedObsidianMaterialStats);
    public static final ItemMekanismArmor REFINED_OBSIDIAN_HELMET = registerArmor(config.refinedObsidianMaterialStats, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor REFINED_OBSIDIAN_CHESTPLATE = registerArmor(config.refinedObsidianMaterialStats, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor REFINED_OBSIDIAN_LEGGINGS = registerArmor(config.refinedObsidianMaterialStats, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor REFINED_OBSIDIAN_BOOTS = registerArmor(config.refinedObsidianMaterialStats, ArmorItem.Type.BOOTS);
    public static final ItemMekanismShield REFINED_OBSIDIAN_SHIELD = registerShield(config.refinedObsidianMaterialStats);

    public static final ItemMekanismPickaxe STEEL_PICKAXE = registerPickaxe(config.steelMaterialStats);
    public static final ItemMekanismAxe STEEL_AXE = registerAxe(config.steelMaterialStats);
    public static final ItemMekanismShovel STEEL_SHOVEL = registerShovel(config.steelMaterialStats);
    public static final ItemMekanismHoe STEEL_HOE = registerHoe(config.steelMaterialStats);
    public static final ItemMekanismSword STEEL_SWORD = registerSword(config.steelMaterialStats);
    public static final ItemMekanismPaxel STEEL_PAXEL = registerPaxel(config.steelMaterialStats);
    public static final ItemMekanismArmor STEEL_HELMET = registerArmor(config.steelMaterialStats, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor STEEL_CHESTPLATE = registerArmor(config.steelMaterialStats, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor STEEL_LEGGINGS = registerArmor(config.steelMaterialStats, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor STEEL_BOOTS = registerArmor(config.steelMaterialStats, ArmorItem.Type.BOOTS);
    public static final ItemMekanismShield STEEL_SHIELD = registerShield(config.steelMaterialStats);

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
