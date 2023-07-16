package mekanism.tools.item;

import mekanism.tools.IHasRepairType;
import mekanism.tools.material.MaterialCreator;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemMekanismSword extends SwordItem implements IHasRepairType {

    private final MaterialCreator material;

    public ItemMekanismSword(MaterialCreator material, Item.Settings settings) {
        super(material, (int) material.getSwordDamage(), material.getSwordAtkSpeed(), settings);
        this.material = material;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public float getAttackDamage() {
        return material.getSwordDamage() + getMaterial().getAttackDamage();
    }

    @NotNull
    @Override
    public Ingredient getRepairMaterial() {
        return getMaterial().getRepairIngredient();
    }

    @Override
    public boolean isDamageable() {
        return getMaterial().getDurability() > 0;
    }
}
