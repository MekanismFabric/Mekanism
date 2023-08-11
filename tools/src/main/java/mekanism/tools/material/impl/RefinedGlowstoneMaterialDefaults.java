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

public class RefinedGlowstoneMaterialDefaults extends BaseMekanismMaterial {

    public static final String name = "refined_glowstone";

    @Override
    public int getShieldDurability() {
        return 381;
    }

    @Override
    public float getAxeDamage() {
        return 6;
    }

    @Override
    public float getAxeAtkSpeed() {
        return -2.9F;
    }

    @Override
    public int getPaxelMiningLevel() {
        return 3;
    }

    @Override
    public int getDurability() {
        return 384;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 15;
    }

    @Override
    public float getAttackDamage() {
        return 2;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getCommonEnchantability() {
        return 20;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public int getDurability(@NotNull ArmorItem.Type armorType) {
        return switch (armorType) {
            case BOOTS -> 221;
            case LEGGINGS -> 255;
            case CHESTPLATE -> 272;
            case HELMET -> 187;
        };
    }

    @Override
    public int getProtection(@NotNull ArmorItem.Type armorType) {
        return switch (armorType) {
            case BOOTS -> 3;
            case LEGGINGS -> 6;
            case CHESTPLATE -> 8;
            case HELMET -> 3;
        };
    }

    @NotNull
    @Override
    public String getConfigCommentName() {
        return "Refined Glowstone";
    }

    @NotNull
    @Override
    public String getRegistryPrefix() {
        return "refined_glowstone";
    }

    @Nullable
    @Override
    public TagKey<Block> getTag() {
        return TagKey.of(RegistryKeys.BLOCK, id("needs_refined_glowstone_tool"));
    }

    @NotNull
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @NotNull
    @Override
    public Ingredient getCommonRepairMaterial() {
        return Ingredient.fromTag(TagKey.of(RegistryKeys.ITEM, new Identifier("mekanism", "refined_glowstone_ingot")));
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}