package mekanism.tools.item;

import mekanism.tools.IHasRepairType;
import mekanism.tools.material.MaterialCreator;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemMekanismArmor extends ArmorItem implements IHasRepairType {

    private final MaterialCreator material;

    public ItemMekanismArmor(MaterialCreator material, ArmorItem.Type armorType, Item.Settings settings) {
        super(material, armorType, settings);
        this.material = material;
        int armorConfig = switch (armorType) {
            case BOOTS -> material.getBootArmor();
            case LEGGINGS -> material.getLeggingArmor();
            case CHESTPLATE -> material.getChestplateArmor();
            case HELMET -> material.getHelmetArmor();
        };
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
    }

    @NotNull
    @Override
    public Ingredient getRepairMaterial() {
        return getMaterial().getRepairIngredient();
    }

    @Override
    public int getProtection() {
        return getMaterial().getProtection(getType());
    }

    @Override
    public float getToughness() {
        return getMaterial().getToughness();
    }

    public float getKnockbackResistance() {
        return getMaterial().getKnockbackResistance();
    }

    @Override
    public boolean isDamageable() {
        return material.getDurability(getType()) > 0;
    }
}
