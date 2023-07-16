package mekanism.tools.registries;

import mekanism.tools.config.MekanismToolsConfig;
import mekanism.tools.item.*;
import mekanism.tools.material.MaterialCreator;
import mekanism.tools.material.VanillaPaxelMaterialCreator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static mekanism.tools.MekanismTools.MEKANISM_TOOLS;
import static mekanism.tools.MekanismTools.id;

public class ToolsItems {

    public static final Map<Item, String> ALL_SHIELDS = new HashMap<>();
    public static final Map<Item, String> ALL_ITEMS = new HashMap<>();

    public static final ItemMekanismPaxel WOOD_PAXEL = registerPaxel(MekanismToolsConfig.config.wood);
    public static final ItemMekanismPaxel STONE_PAXEL = registerPaxel(MekanismToolsConfig.config.stone);
    public static final ItemMekanismPaxel IRON_PAXEL = registerPaxel(MekanismToolsConfig.config.iron);
    public static final ItemMekanismPaxel GOLD_PAXEL = registerPaxel(MekanismToolsConfig.config.gold);
    public static final ItemMekanismPaxel DIAMOND_PAXEL = registerPaxel(MekanismToolsConfig.config.diamond);
    public static final ItemMekanismPaxel NETHERITE_PAXEL = registerPaxel(MekanismToolsConfig.config.netherite);

    public static final ItemMekanismPickaxe BRONZE_PICKAXE = registerPickaxe(MekanismToolsConfig.config.bronze);
    public static final ItemMekanismAxe BRONZE_AXE = registerAxe(MekanismToolsConfig.config.bronze);
    public static final ItemMekanismShovel BRONZE_SHOVEL = registerShovel(MekanismToolsConfig.config.bronze);
    public static final ItemMekanismHoe BRONZE_HOE = registerHoe(MekanismToolsConfig.config.bronze);
    public static final ItemMekanismSword BRONZE_SWORD = registerSword(MekanismToolsConfig.config.bronze);
    public static final ItemMekanismPaxel BRONZE_PAXEL = registerPaxel(MekanismToolsConfig.config.bronze);
    public static final ItemMekanismArmor BRONZE_HELMET = registerArmor(MekanismToolsConfig.config.bronze, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor BRONZE_CHESTPLATE = registerArmor(MekanismToolsConfig.config.bronze, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor BRONZE_LEGGINGS = registerArmor(MekanismToolsConfig.config.bronze, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor BRONZE_BOOTS = registerArmor(MekanismToolsConfig.config.bronze, ArmorItem.Type.BOOTS);
//    public static final ItemMekanismShield BRONZE_SHIELD = registerShield(MekanismToolsConfig.config.bronze);

    public static final ItemMekanismPickaxe LAPIS_LAZULI_PICKAXE = registerPickaxe(MekanismToolsConfig.config.lapisLazuli);
    public static final ItemMekanismAxe LAPIS_LAZULI_AXE = registerAxe(MekanismToolsConfig.config.lapisLazuli);
    public static final ItemMekanismShovel LAPIS_LAZULI_SHOVEL = registerShovel(MekanismToolsConfig.config.lapisLazuli);
    public static final ItemMekanismHoe LAPIS_LAZULI_HOE = registerHoe(MekanismToolsConfig.config.lapisLazuli);
    public static final ItemMekanismSword LAPIS_LAZULI_SWORD = registerSword(MekanismToolsConfig.config.lapisLazuli);
    public static final ItemMekanismPaxel LAPIS_LAZULI_PAXEL = registerPaxel(MekanismToolsConfig.config.lapisLazuli);
    public static final ItemMekanismArmor LAPIS_LAZULI_HELMET = registerArmor(MekanismToolsConfig.config.lapisLazuli, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor LAPIS_LAZULI_CHESTPLATE = registerArmor(MekanismToolsConfig.config.lapisLazuli, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor LAPIS_LAZULI_LEGGINGS = registerArmor(MekanismToolsConfig.config.lapisLazuli, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor LAPIS_LAZULI_BOOTS = registerArmor(MekanismToolsConfig.config.lapisLazuli, ArmorItem.Type.BOOTS);
//    public static final ItemMekanismShield LAPIS_LAZULI_SHIELD = registerShield(MekanismToolsConfig.config.lapisLazuli);

    public static final ItemMekanismPickaxe OSMIUM_PICKAXE = registerPickaxe(MekanismToolsConfig.config.osmium);
    public static final ItemMekanismAxe OSMIUM_AXE = registerAxe(MekanismToolsConfig.config.osmium);
    public static final ItemMekanismShovel OSMIUM_SHOVEL = registerShovel(MekanismToolsConfig.config.osmium);
    public static final ItemMekanismHoe OSMIUM_HOE = registerHoe(MekanismToolsConfig.config.osmium);
    public static final ItemMekanismSword OSMIUM_SWORD = registerSword(MekanismToolsConfig.config.osmium);
    public static final ItemMekanismPaxel OSMIUM_PAXEL = registerPaxel(MekanismToolsConfig.config.osmium);
    public static final ItemMekanismArmor OSMIUM_HELMET = registerArmor(MekanismToolsConfig.config.osmium, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor OSMIUM_CHESTPLATE = registerArmor(MekanismToolsConfig.config.osmium, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor OSMIUM_LEGGINGS = registerArmor(MekanismToolsConfig.config.osmium, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor OSMIUM_BOOTS = registerArmor(MekanismToolsConfig.config.osmium, ArmorItem.Type.BOOTS);
//    public static final ItemMekanismShield OSMIUM_SHIELD = registerShield(MekanismToolsConfig.config.osmium);

    public static final ItemMekanismPickaxe REFINED_GLOWSTONE_PICKAXE = registerPickaxe(MekanismToolsConfig.config.refinedGlowstone);
    public static final ItemMekanismAxe REFINED_GLOWSTONE_AXE = registerAxe(MekanismToolsConfig.config.refinedGlowstone);
    public static final ItemMekanismShovel REFINED_GLOWSTONE_SHOVEL = registerShovel(MekanismToolsConfig.config.refinedGlowstone);
    public static final ItemMekanismHoe REFINED_GLOWSTONE_HOE = registerHoe(MekanismToolsConfig.config.refinedGlowstone);
    public static final ItemMekanismSword REFINED_GLOWSTONE_SWORD = registerSword(MekanismToolsConfig.config.refinedGlowstone);
    public static final ItemMekanismPaxel REFINED_GLOWSTONE_PAXEL = registerPaxel(MekanismToolsConfig.config.refinedGlowstone);
    public static final ItemMekanismArmor REFINED_GLOWSTONE_HELMET = registerArmor(MekanismToolsConfig.config.refinedGlowstone, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor REFINED_GLOWSTONE_CHESTPLATE = registerArmor(MekanismToolsConfig.config.refinedGlowstone, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor REFINED_GLOWSTONE_LEGGINGS = registerArmor(MekanismToolsConfig.config.refinedGlowstone, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor REFINED_GLOWSTONE_BOOTS = registerArmor(MekanismToolsConfig.config.refinedGlowstone, ArmorItem.Type.BOOTS);
//    public static final ItemMekanismShield REFINED_GLOWSTONE_SHIELD = registerShield(MekanismToolsConfig.config.refinedGlowstone);

    public static final ItemMekanismPickaxe REFINED_OBSIDIAN_PICKAXE = registerPickaxe(MekanismToolsConfig.config.refinedObsidian);
    public static final ItemMekanismAxe REFINED_OBSIDIAN_AXE = registerAxe(MekanismToolsConfig.config.refinedObsidian);
    public static final ItemMekanismShovel REFINED_OBSIDIAN_SHOVEL = registerShovel(MekanismToolsConfig.config.refinedObsidian);
    public static final ItemMekanismHoe REFINED_OBSIDIAN_HOE = registerHoe(MekanismToolsConfig.config.refinedObsidian);
    public static final ItemMekanismSword REFINED_OBSIDIAN_SWORD = registerSword(MekanismToolsConfig.config.refinedObsidian);
    public static final ItemMekanismPaxel REFINED_OBSIDIAN_PAXEL = registerPaxel(MekanismToolsConfig.config.refinedObsidian);
    public static final ItemMekanismArmor REFINED_OBSIDIAN_HELMET = registerArmor(MekanismToolsConfig.config.refinedObsidian, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor REFINED_OBSIDIAN_CHESTPLATE = registerArmor(MekanismToolsConfig.config.refinedObsidian, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor REFINED_OBSIDIAN_LEGGINGS = registerArmor(MekanismToolsConfig.config.refinedObsidian, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor REFINED_OBSIDIAN_BOOTS = registerArmor(MekanismToolsConfig.config.refinedObsidian, ArmorItem.Type.BOOTS);
//    public static final ItemMekanismShield REFINED_OBSIDIAN_SHIELD = registerShield(MekanismToolsConfig.config.refinedObsidian);

    public static final ItemMekanismPickaxe STEEL_PICKAXE = registerPickaxe(MekanismToolsConfig.config.steel);
    public static final ItemMekanismAxe STEEL_AXE = registerAxe(MekanismToolsConfig.config.steel);
    public static final ItemMekanismShovel STEEL_SHOVEL = registerShovel(MekanismToolsConfig.config.steel);
    public static final ItemMekanismHoe STEEL_HOE = registerHoe(MekanismToolsConfig.config.steel);
    public static final ItemMekanismSword STEEL_SWORD = registerSword(MekanismToolsConfig.config.steel);
    public static final ItemMekanismPaxel STEEL_PAXEL = registerPaxel(MekanismToolsConfig.config.steel);
    public static final ItemMekanismArmor STEEL_HELMET = registerArmor(MekanismToolsConfig.config.steel, ArmorItem.Type.HELMET);
    public static final ItemMekanismArmor STEEL_CHESTPLATE = registerArmor(MekanismToolsConfig.config.steel, ArmorItem.Type.CHESTPLATE);
    public static final ItemMekanismArmor STEEL_LEGGINGS = registerArmor(MekanismToolsConfig.config.steel, ArmorItem.Type.LEGGINGS);
    public static final ItemMekanismArmor STEEL_BOOTS = registerArmor(MekanismToolsConfig.config.steel, ArmorItem.Type.BOOTS);
//    public static final ItemMekanismShield STEEL_SHIELD = registerShield(MekanismToolsConfig.config.steel);

    public static void registerTools() {}

    private static ItemMekanismPickaxe registerPickaxe(MaterialCreator material) {
        return register(ItemMekanismPickaxe::new, "_pickaxe", material);
    }

    private static ItemMekanismAxe registerAxe(MaterialCreator material) {
        return register(ItemMekanismAxe::new, "_axe", material);
    }

    private static ItemMekanismShovel registerShovel(MaterialCreator material) {
        return register(ItemMekanismShovel::new, "_shovel", material);
    }

    private static ItemMekanismHoe registerHoe(MaterialCreator material) {
        return register(ItemMekanismHoe::new, "_hoe", material);
    }

    private static ItemMekanismSword registerSword(MaterialCreator material) {
        return register(ItemMekanismSword::new, "_sword", material);
    }

    private static ItemMekanismPaxel registerPaxel(MaterialCreator material) {
        return register(ItemMekanismPaxel::new, "_paxel", material);
    }

    private static ItemMekanismPaxel registerPaxel(VanillaPaxelMaterialCreator material) {
        if (material.getVanillaMaterial() == ToolMaterials.NETHERITE) {
            return registerVanilla(ItemMekanismPaxel::new, "_paxel", material, new FabricItemSettings().fireproof());
        }
        return registerVanilla(ItemMekanismPaxel::new, "_paxel", material);
    }

    private static ItemMekanismArmor registerArmor(MaterialCreator material, ArmorItem.Type armorType) {
        return registerArmor(material, armorType, ItemMekanismArmor::new);
    }

    private static ItemMekanismShield registerShield(MaterialCreator materialCreator) {
        return register(ItemMekanismShield::new, "_shield", materialCreator);
    }

    private static <ITEM extends Item> ITEM register(BiFunction<MaterialCreator, Item.Settings, ITEM> itemCreator, String suffix, MaterialCreator material) {
        return register(itemCreator, suffix, material, new FabricItemSettings());
    }

    private static <ITEM extends Item> ITEM register(BiFunction<MaterialCreator, Item.Settings, ITEM> itemCreator, String suffix, MaterialCreator material, FabricItemSettings settings) {
        ITEM item = itemCreator.apply(material, settings);
        String itemKey = material.getRegistryPrefix() + suffix;
        MEKANISM_TOOLS.addItemToGroup(item.getDefaultStack());
        if (item instanceof ItemMekanismShield) {
            ALL_SHIELDS.put(item, itemKey);
        } else {
            ALL_ITEMS.put(item, itemKey);
        }
        return Registry.register(Registries.ITEM, id(itemKey), item);
    }

    private static <ITEM extends Item> ITEM registerVanilla(BiFunction<VanillaPaxelMaterialCreator, Item.Settings, ITEM> itemCreator, String suffix, VanillaPaxelMaterialCreator material) {
        return registerVanilla(itemCreator, suffix, material, new FabricItemSettings());
    }

    private static <ITEM extends Item> ITEM registerVanilla(BiFunction<VanillaPaxelMaterialCreator, Item.Settings, ITEM> itemCreator, String suffix, VanillaPaxelMaterialCreator material, FabricItemSettings settings) {
        ITEM item = itemCreator.apply(material, settings);
        String itemKey = material.getRegistryPrefix() + suffix;
        MEKANISM_TOOLS.addItemToGroup(item.getDefaultStack());
        ALL_ITEMS.put(item, itemKey);
        return Registry.register(Registries.ITEM, id(itemKey), item);
    }

    private static ItemMekanismArmor registerArmor(MaterialCreator material, ArmorItem.Type armorType, ArmorCreator armorCreator) {
        ItemMekanismArmor armor = armorCreator.create(material, armorType, new FabricItemSettings());
        String itemKey = material.getRegistryPrefix() + "_" + armorType.getName();
        MEKANISM_TOOLS.addItemToGroup(armor.getDefaultStack());
        ALL_ITEMS.put(armor, itemKey);
        return Registry.register(Registries.ITEM, id(itemKey), armor);
    }

    private interface ArmorCreator {
        ItemMekanismArmor create(MaterialCreator material, ArmorItem.Type armorType, Item.Settings settings);
    }
}