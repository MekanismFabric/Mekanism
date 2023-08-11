package mekanism.tools.config.tools;

import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.tools.material.BaseMekanismMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractMaterialConfig extends BaseMekanismMaterial {

    @ConfigEntry.Gui.Excluded
    protected final BaseMekanismMaterial DEFAULT;

    public abstract int getHelmetDurability();
    public abstract int getChestplateDurability();
    public abstract int getLeggingDurability();
    public abstract int getBootDurability();

    public abstract int getHelmetArmor();
    public abstract int getChestplateArmor();
    public abstract int getLeggingArmor();
    public abstract int getBootArmor();

    protected AbstractMaterialConfig(BaseMekanismMaterial defaultMaterial) {
        this.DEFAULT = defaultMaterial;
    }

    @Override
    public @NotNull String getRegistryPrefix() {
        return DEFAULT.getRegistryPrefix();
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return switch (type) {
            case HELMET  -> getHelmetDurability();
            case CHESTPLATE -> getChestplateDurability();
            case LEGGINGS  -> getLeggingDurability();
            case BOOTS  -> getBootDurability();
        };
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return switch (type) {
            case HELMET  -> getHelmetArmor();
            case CHESTPLATE -> getChestplateArmor();
            case LEGGINGS  -> getLeggingArmor();
            case BOOTS  -> getBootArmor();
        };
    }

    @Override
    public SoundEvent getEquipSound() {
        return DEFAULT.getEquipSound();
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return DEFAULT.getRepairIngredient();
    }
}
