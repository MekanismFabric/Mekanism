package mekanism.tools.datagen;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigLangHelper {

    private static final String AUTO_CONFIG_PREFIX = "text.autoconfig.mekanismtools.";
    private static final String CATEGORY_PREFIX = AUTO_CONFIG_PREFIX + "category.";
    private static final String OPTION_PREFIX = AUTO_CONFIG_PREFIX + "option.";
    private static final String CONFIG_PREFIX = OPTION_PREFIX + "config.";
    private static final String TOOLS_CONFIG_PREFIX = CONFIG_PREFIX + "config";
    private static final List<String> MATERIAL_LIST = new ArrayList<>(){{
        add("bronze");
        add("lapisLazuli");
        add("osmium");
        add("refinedGlowstone");
        add("refinedObsidian");
        add("steel");
    }};

    private static final Map<String, String> COMMON_CONFIG_FIELDS = new HashMap<>(){{
        put("attackDamage", "Attack Damage");
        put("shieldDurability", "Shield Durability");
        put("swordDamage", "Sword Damage");
        put("swordAtkSpeed", "Sword Attack Speed");
        put("shovelDamage", "Shovel Damage");
        put("shovelAtkSpeed", "Shovel Attack Speed");
        put("axeDamage", "Axe Damage");
        put("axeAtkSpeed", "Axe Attack Speed");
        put("pickaxeDamage", "Pickaxe Damage");
        put("pickaxeAtkSpeed", "PickaxeAttack Speed");
        put("hoeDamage", "Hoe Damage");
        put("hoeAtkSpeed", "Hoe Attack Speed");
        put("durability", "Durability");
        put("miningSpeedMultiplier", "Mining Speed Multiplier");
        put("paxelHarvestLevel", "Paxel Mining Level");
        put("paxelDamage", "Paxel Damage");
        put("paxelAtkSpeed", "Paxel Attack Speed");
        put("paxelEfficiency", "Paxel Efficiency");
        put("paxelEnchantability", "Paxel Enchantability");
        put("paxelMaxUses", "Paxel Max Uses");
        put("miningLevel", "Mining Level");
        put("enchantability", "Enchantability");
        put("toughness", "Toughness");
        put("knockbackResistance", "Knockback Resistance");
        put("bootDurability", "Boot Durability");
        put("leggingDurability", "Legging Durability");
        put("chestplateDurability", "Chestplate Durability");
        put("helmetDurability", "Helmet Durability");
        put("bootArmor", "Boot Protection");
        put("leggingArmor", "Legging Protection");
        put("chestplateArmor", "Chestplate Protection");
        put("helmetArmor", "Helmet Protection");
    }};

    private static final Map<String, String> ARMOR_CONFIG_FIELDS = new HashMap<>(){{
       put("swordChance", "Sword Chance");
       put("helmetChance", "Helmet Chance");
       put("chestplateChance", "Chestplate Chance");
       put("leggingsChance", "Legging Chance");
       put("bootsChance", "Boot Chance");
    }};

    public static void addCategoryNames(FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(CATEGORY_PREFIX + "tools_common", "Mekanism Tools Common");
        translationBuilder.add(CATEGORY_PREFIX + "tools_client", "Mekanism Tools Client");
        translationBuilder.add(OPTION_PREFIX + "clientConfig.displayDurabilityTooltips", "Display Durability Tooltips");
    }

    public static void addMaterialNames(FabricLanguageProvider.TranslationBuilder translationBuilder) {
        String mobArmorSpawnRate = CONFIG_PREFIX + "mobArmorSpawnRate";

        translationBuilder.add(TOOLS_CONFIG_PREFIX, "Tool Stats");
        translationBuilder.add(mobArmorSpawnRate, "Mob Armor Spawn Rate");
        translationBuilder.add(mobArmorSpawnRate + ".general", "Spawn Chance");

        for (String material : MATERIAL_LIST) {
            String suffix = material + "MaterialStats";
            translationBuilder.add(TOOLS_CONFIG_PREFIX + "." + suffix, convertStringToSpacedProper(suffix));
            for (Map.Entry<String, String> entry : COMMON_CONFIG_FIELDS.entrySet()) {
                String mapping = TOOLS_CONFIG_PREFIX + "." + suffix + "." + entry.getKey();
                translationBuilder.add(mapping, entry.getValue());
            }

            String armorCategory = mobArmorSpawnRate + "." + material;
            translationBuilder.add(armorCategory, convertStringToSpacedProper(material));
            for (Map.Entry<String, String> entry : ARMOR_CONFIG_FIELDS.entrySet()) {
                String mapping = mobArmorSpawnRate + "." + material + "." + entry.getKey();
                translationBuilder.add(mapping, entry.getValue());
            }
        }
    }

    private static String convertStringToSpacedProper(String string) {
        String correctedFirstLetter = string.substring(0, 1).toUpperCase() + string.substring(1);
        String[] splitWordsByProper = correctedFirstLetter.split("(?=\\p{Upper})");
        return String.join(" ", splitWordsByProper);
    }
}
