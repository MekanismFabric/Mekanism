package mekanism.tools.material;

import mekanism.tools.MekanismTools;
import net.minecraft.block.Block;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;
import org.jetbrains.annotations.Nullable;

public abstract class BaseMekanismMaterial extends IItemMaterialHelper implements IArmorMaterialHelper, IPaxelMaterial {

    @Nullable
    @Override
    public abstract TagKey<Block> getTag();

    public abstract int getShieldDurability();

    public float getSwordDamage() {
        return 3;
    }

    public float getSwordAtkSpeed() {
        return -2.4F;
    }

    public float getShovelDamage() {
        return 1.5F;
    }

    public float getShovelAtkSpeed() {
        return -3.0F;
    }

    public abstract float getAxeDamage();

    public abstract float getAxeAtkSpeed();

    public float getPickaxeDamage() {
        return 1;
    }

    public float getPickaxeAtkSpeed() {
        return -2.8F;
    }

    public float getHoeDamage() {
        //Default to match the vanilla hoe's implementation of being negative the attack damage of the material
        return -getAttackDamage();
    }

    public float getHoeAtkSpeed() {
        return getAttackDamage() - 3.0F;
    }

    @Override
    public float getPaxelDamage() {
        return getAxeDamage() + 1;
    }

    @Override
    public int getPaxelMaxUses() {
        return 2 * getDurability();
    }

    @Override
    public float getPaxelEfficiency() {
        return getMiningSpeedMultiplier();
    }

    @Override
    public int getPaxelEnchantability() {
        return getCommonEnchantability();
    }

    public abstract int getPaxelMiningLevel();

    public abstract String getRegistryPrefix();

    //Recombine the methods that are split in such a way as to make it so the compiler can reobfuscate them properly
    public abstract int getCommonEnchantability();

    public boolean burnsInFire() {
        return true;
    }

    @Override
    public int getItemEnchantability() {
        return getCommonEnchantability();
    }

    @Override
    public int getArmorEnchantability() {
        return getCommonEnchantability();
    }

    public abstract Ingredient getCommonRepairMaterial();

    @Override
    public Ingredient getItemRepairMaterial() {
        return getCommonRepairMaterial();
    }

    @Override
    public Ingredient getArmorRepairMaterial() {
        return getCommonRepairMaterial();
    }

    @Override
    public String getName() {
        return MekanismTools.MODID + ":" + getRegistryPrefix();
    }
}
