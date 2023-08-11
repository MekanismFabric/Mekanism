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

public class BronzeMaterialDefaults extends BaseMekanismMaterial {
    public static final String name = "bronze";

    @Override
    public int getShieldDurability() {
        return 403;
    }

    @Override
    public float getAxeDamage() {
        return 7;
    }

    @Override
    public float getAxeAtkSpeed() {
        return -3.0F;
    }

    @Override
    public int getPaxelMiningLevel() {
        return 3;
    }

    @Override
    public int getDurability() {
        return 375;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 7;
    }

    @Override
    public float getAttackDamage() {
        return 2;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getCommonEnchantability() {
        return 10;
    }

    @Override
    public float getToughness() {
        return 1;
    }

    @Override
    public int getDurability(@NotNull ArmorItem.Type armorType) {
        return switch (armorType) {
            case BOOTS -> 234;
            case LEGGINGS -> 270;
            case CHESTPLATE -> 288;
            case HELMET -> 198;
        };
    }

    @Override
    public int getProtection(@NotNull ArmorItem.Type armorType) {
        return switch (armorType) {
            case BOOTS -> 2;
            case LEGGINGS -> 6;
            case CHESTPLATE -> 7;
            case HELMET -> 3;
        };
    }

    @NotNull
    @Override
    public String getConfigCommentName() {
        return "Bronze";
    }

    @NotNull
    @Override
    public String getRegistryPrefix() {
        return "bronze";
    }

    @Nullable
    @Override
    public TagKey<Block> getTag() {
        return TagKey.of(RegistryKeys.BLOCK, id("needs_bronze_tool"));
    }

    @NotNull
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @NotNull
    @Override
    public Ingredient getCommonRepairMaterial() {
        return Ingredient.fromTag(TagKey.of(RegistryKeys.ITEM, new Identifier("mekanism", "bronze_ingot")));
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
