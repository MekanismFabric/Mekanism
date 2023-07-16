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

public class LapisLazuliMaterialDefaults extends BaseMekanismMaterial {

    @Override
    public int getShieldDurability() {
        return 224;
    }

    @Override
    public float getAxeDamage() {
        return 4;
    }

    @Override
    public float getAxeAtkSpeed() {
        return -2.9F;
    }

    @Override
    public int getDurability() {
        return 128;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9;
    }

    @Override
    public float getAttackDamage() {
        return 1;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getCommonEnchantability() {
        return 32;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public int getDurability(@NotNull ArmorItem.Type armorType) {
        return switch (armorType) {
            case BOOTS -> 130;
            case LEGGINGS -> 150;
            case CHESTPLATE -> 160;
            case HELMET -> 110;
        };
    }

    @Override
    public int getProtection(@NotNull ArmorItem.Type armorType) {
        return switch (armorType) {
            case BOOTS -> 1;
            case LEGGINGS -> 3;
            case CHESTPLATE -> 4;
            case HELMET -> 1;
        };
    }

    @NotNull
    @Override
    public String getConfigCommentName() {
        return "Lapis Lazuli";
    }

    @NotNull
    @Override
    public String getRegistryPrefix() {
        return "lapis_lazuli";
    }

    @Nullable
    @Override
    public TagKey<Block> getTag() {
        return TagKey.of(RegistryKeys.BLOCK, id("needs_lapis_lazuli_tool"));
    }

    @NotNull
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @NotNull
    @Override
    public Ingredient getCommonRepairMaterial() {
        return Ingredient.fromTag(TagKey.of(RegistryKeys.ITEM, new Identifier("lapis_lazuli")));
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}