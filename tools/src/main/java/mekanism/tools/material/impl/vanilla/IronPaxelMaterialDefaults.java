package mekanism.tools.material.impl.vanilla;

import mekanism.tools.material.VanillaPaxelMaterial;
import net.minecraft.item.ToolMaterials;
import org.jetbrains.annotations.NotNull;

public class IronPaxelMaterialDefaults extends VanillaPaxelMaterial {

    @Override
    public ToolMaterials getVanillaMaterial() {
        return ToolMaterials.IRON;
    }

    @Override
    public float getPaxelDamage() {
        return 7;
    }

    @Override
    public String getConfigCommentName() {
        return "Iron";
    }

    @NotNull
    @Override
    public String getRegistryPrefix() {
        return "iron";
    }
}