package mekanism.tools.item;

import mekanism.tools.IHasRepairType;
import mekanism.tools.material.MaterialCreator;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemMekanismPickaxe extends PickaxeItem implements IHasRepairType {

    private final MaterialCreator material;

    public ItemMekanismPickaxe(MaterialCreator material, Settings settings) {
        super(material, (int) material.getPickaxeDamage(), material.getPickaxeAtkSpeed(), settings);
        this.material = material;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public float getAttackDamage() {
        return material.getPickaxeDamage() + getMaterial().getAttackDamage();
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return super.getMiningSpeedMultiplier(stack, state) == 1 ? 1 : getMaterial().getMiningSpeedMultiplier();
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