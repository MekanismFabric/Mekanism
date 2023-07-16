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

public class RefinedObsidianMaterialDefaults extends BaseMekanismMaterial {

    @Override
    public int getShieldDurability() {
        return 1_680;
    }

    @Override
    public float getAxeDamage() {
        return 7;
    }

    @Override
    public float getAxeAtkSpeed() {
        return -2.9F;
    }

    @Override
    public int getDurability() {
        return 4_096;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 12;
    }

    @Override
    public float getAttackDamage() {
        return 8;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getCommonEnchantability() {
        return 18;
    }

    @Override
    public boolean burnsInFire() {
        return false;
    }

    @Override
    public float getToughness() {
        return 5;
    }

    @Override
    public int getDurability(@NotNull ArmorItem.Type armorType) {
        return switch (armorType) {
            case BOOTS -> 975;
            case LEGGINGS -> 1_125;
            case CHESTPLATE -> 1_200;
            case HELMET -> 825;
        };
    }

    @Override
    public int getProtection(@NotNull ArmorItem.Type armorType) {
        return switch (armorType) {
            case BOOTS -> 5;
            case LEGGINGS -> 8;
            case CHESTPLATE -> 12;
            case HELMET -> 6;
        };
    }

    @NotNull
    @Override
    public String getConfigCommentName() {
        return "Refined Obsidian";
    }

    @NotNull
    @Override
    public String getRegistryPrefix() {
        return "refined_obsidian";
    }

    @Nullable
    @Override
    public TagKey<Block> getTag() {
        return TagKey.of(RegistryKeys.BLOCK, id("needs_refined_obsidian_tool"));
    }

    @NotNull
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @NotNull
    @Override
    public Ingredient getCommonRepairMaterial() {
        return Ingredient.fromTag(TagKey.of(RegistryKeys.ITEM, new Identifier("mekanism", "refined_obsidian_ingot")));
    }

    @Override
    public float getKnockbackResistance() {
        return 0.2F;
    }
}