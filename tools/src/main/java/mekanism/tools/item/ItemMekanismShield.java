package mekanism.tools.item;

import mekanism.tools.IHasGlowEffect;
import mekanism.tools.IHasRepairType;
import mekanism.tools.material.BaseMekanismMaterial;
import mekanism.tools.registries.ToolsItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static mekanism.tools.registries.ToolsItems.REFINED_GLOWSTONE_LIGHT_LEVEL;

public class ItemMekanismShield extends ShieldItem implements IHasRepairType, IHasGlowEffect {

    private final BaseMekanismMaterial material;

    public ItemMekanismShield(BaseMekanismMaterial material, Item.Settings settings) {
        super(settings.maxDamage(material.getShieldDurability()));
        this.material = material;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
    }

    @NotNull
    @Override
    public Ingredient getRepairMaterial() {
        return material.getRepairIngredient();
    }

    @Override
    public boolean isDamageable() {
        return material.getShieldDurability() > 0;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return getRepairMaterial().test(ingredient);
    }

    @Override
    public int getEnchantability() {
        return material.getEnchantability();
    }

    @Override
    public int getCustomLightLevel(ItemStack itemStack, int defaultLightLevel) {
        if (itemStack.getItem() == ToolsItems.REFINED_GLOWSTONE_SHIELD) {
            return REFINED_GLOWSTONE_LIGHT_LEVEL;
        }

        return defaultLightLevel;
    }
}
