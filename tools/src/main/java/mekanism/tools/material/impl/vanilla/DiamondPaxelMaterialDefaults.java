package mekanism.tools.material.impl.vanilla;

import mekanism.tools.material.VanillaPaxelMaterial;
import net.minecraft.item.ToolMaterials;
import org.jetbrains.annotations.NotNull;

public class DiamondPaxelMaterialDefaults extends VanillaPaxelMaterial {

    @Override
    public ToolMaterials getVanillaMaterial() {
        return ToolMaterials.DIAMOND;
    }

    @Override
    public float getPaxelDamage() {
        return 6;
    }

    @Override
    public String getConfigCommentName() {
        return "Diamond";
    }

    @NotNull
    @Override
    public String getRegistryPrefix() {
        return "diamond";
    }
}