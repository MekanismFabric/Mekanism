package mekanism.tools.material.impl;

import mekanism.tools.material.BaseMekanismMaterial;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static mekanism.tools.MekanismTools.id;

public class OsmiumMaterialDefaults extends BaseMekanismMaterial {

    @Override
    public int getShieldDurability() {
        return 672;
    }

    @Override
    public float getAxeDamage() {
        return 8;
    }

    @Override
    public float getAxeAtkSpeed() {
        return -3.3F;
    }

    @Override
    public int getDurability() {
        return 1_024;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4;
    }

    @Override
    public float getAttackDamage() {
        return 4;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getCommonEnchantability() {
        return 14;
    }

    @Override
    public float getToughness() {
        return 3;
    }

    @Override
    public int getDurability(@NotNull ArmorItem.Type armorType) {
        return switch (armorType) {
            case BOOTS -> 390;
            case LEGGINGS -> 450;
            case CHESTPLATE -> 480;
            case HELMET -> 330;
        };
    }

    @Override
    public int getProtection(@NotNull ArmorItem.Type armorType) {
        return switch (armorType) {
            case BOOTS -> 3;
            case LEGGINGS -> 6;
            case CHESTPLATE -> 8;
            case HELMET -> 4;
        };
    }

    @NotNull
    @Override
    public String getConfigCommentName() {
        return "Osmium";
    }

    @NotNull
    @Override
    public String getRegistryPrefix() {
        return "osmium";
    }

    @Nullable
    @Override
    public TagKey<Block> getTag() {
        return TagKey.of(RegistryKeys.BLOCK, id("needs_osmium_tool"));
    }

    @NotNull
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @NotNull
    @Override
    public Ingredient getCommonRepairMaterial() {
        return Ingredient.fromTag(TagKey.of(RegistryKeys.ITEM, new Identifier("mekanism", "osmium_ingot")));
    }

    @Override
    public float getKnockbackResistance() {
        return 0.1F;
    }
}