package mekanism.tools.material;

import net.minecraft.item.ToolMaterials;

import java.util.Locale;

public abstract class VanillaPaxelMaterial implements IPaxelMaterial {
    public abstract ToolMaterials getVanillaMaterial();

    public String getRegistryPrefix() {
        return getVanillaMaterial().name().toLowerCase(Locale.ROOT);
    }

    @Override
    public int getPaxelMaxUses() {
        return 2 * getVanillaMaterial().getDurability();
    }

    @Override
    public float getPaxelEfficiency() {
        return getVanillaMaterial().getMiningSpeedMultiplier();
    }

    @Override
    public int getPaxelEnchantability() {
        return getVanillaMaterial().getEnchantability();
    }
}
