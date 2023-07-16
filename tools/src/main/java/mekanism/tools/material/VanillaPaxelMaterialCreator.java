package mekanism.tools.material;

import net.minecraft.item.ToolMaterials;

public class VanillaPaxelMaterialCreator implements IPaxelMaterial {
    private final VanillaPaxelMaterial fallback;

    private final float paxelDamage;
    private final float paxelAtkSpeed;
    private final float paxelEfficiency;
    private final int paxelEnchantability;
    private final int paxelMaxUses;

    public VanillaPaxelMaterialCreator(VanillaPaxelMaterial materialDefaults) {
        this.fallback = materialDefaults;
        paxelDamage = materialDefaults.getPaxelDamage();
        paxelAtkSpeed = materialDefaults.getPaxelAtkSpeed();
        paxelEfficiency = materialDefaults.getPaxelEfficiency();
        paxelEnchantability = materialDefaults.getPaxelEnchantability();
        paxelMaxUses = materialDefaults.getPaxelMaxUses();
    }

    public ToolMaterials getVanillaMaterial() {
        return fallback.getVanillaMaterial();
    }

    public String getRegistryPrefix() {
        return fallback.getRegistryPrefix();
    }

    @Override
    public int getPaxelMaxUses() {
        return paxelMaxUses;
    }

    @Override
    public float getPaxelEfficiency() {
        return paxelEfficiency;
    }

    @Override
    public float getPaxelDamage() {
        return paxelDamage;
    }

    @Override
    public float getPaxelAtkSpeed() {
        return paxelAtkSpeed;
    }

    @Override
    public int getPaxelEnchantability() {
        return paxelEnchantability;
    }

    @Override
    public String getConfigCommentName() {
        return fallback.getConfigCommentName();
    }
}
