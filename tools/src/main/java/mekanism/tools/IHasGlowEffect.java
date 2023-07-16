package mekanism.tools;

import net.minecraft.item.ItemStack;

public interface IHasGlowEffect {
    int getCustomLightLevel(ItemStack itemStack, int defaultLightLevel);
}