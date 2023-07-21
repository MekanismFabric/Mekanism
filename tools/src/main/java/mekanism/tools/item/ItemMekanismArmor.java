package mekanism.tools.item;

import mekanism.tools.material.MaterialCreator;
import mekanism.tools.registries.ToolsItems;
import mekanism.tools.util.ToolsUtils;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static mekanism.tools.registries.ToolsItems.REFINED_GLOWSTONE_LIGHT_LEVEL;

public class ItemMekanismArmor extends ArmorItem implements IHasPiglinInfluence, IHasGlowEffect {

    private final MaterialCreator material;
    private final boolean makesPiglinsNeutral;

    public ItemMekanismArmor(MaterialCreator material, ArmorItem.Type armorType, Item.Settings settings, boolean makesPiglinsNeutral) {
        super(material, armorType, settings);
        this.material = material;
        int armorConfig = switch (armorType) {
            case BOOTS -> material.getBootArmor();
            case LEGGINGS -> material.getLeggingArmor();
            case CHESTPLATE -> material.getChestplateArmor();
            case HELMET -> material.getHelmetArmor();
        };
        this.makesPiglinsNeutral = makesPiglinsNeutral;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        ToolsUtils.addDurability(tooltip, stack);
    }

    @Override
    public boolean isPiglinCalming() {
        return this.makesPiglinsNeutral;
    }

    @Override
    public boolean isDamageable() {
        return material.getDurability(getType()) > 0;
    }

    @Override
    public int getCustomLightLevel(ItemStack itemStack, int defaultLightLevel) {
        if (itemStack.getItem() == ToolsItems.REFINED_GLOWSTONE_HELMET || itemStack.getItem() == ToolsItems.REFINED_GLOWSTONE_CHESTPLATE
                || itemStack.getItem() == ToolsItems.REFINED_GLOWSTONE_LEGGINGS || itemStack.getItem() == ToolsItems.REFINED_GLOWSTONE_BOOTS) {
            return REFINED_GLOWSTONE_LIGHT_LEVEL;
        }

        return defaultLightLevel;
    }
}
