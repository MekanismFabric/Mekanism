package mekanism.tools.item;

import mekanism.tools.IHasRepairType;
import mekanism.tools.material.BaseMekanismMaterial;
import mekanism.tools.util.ToolsUtils;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static mekanism.tools.registries.ToolsItems.PAXEL_MINEABLE;

public class ItemMekanismPaxel extends MiningToolItem implements IHasRepairType {

    private static final float DEFAULT_ATTACK_DAMAGE = 4.0F;
    private static final Item[] VALID_TOOLS = {
            Items.NETHERITE_AXE,
            Items.NETHERITE_SHOVEL,
            Items.NETHERITE_PICKAXE
    };

    public ItemMekanismPaxel(ToolMaterials material, Item.Settings settings) {
        super(DEFAULT_ATTACK_DAMAGE, -2.4F, material, PAXEL_MINEABLE, settings.maxDamage(material.getDurability()));
    }

    public ItemMekanismPaxel(BaseMekanismMaterial material, Item.Settings settings) {
        super(material.getPaxelDamage(), material.getPaxelAtkSpeed(), material, PAXEL_MINEABLE, settings.maxDamage(material.getPaxelMaxUses()));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        ToolsUtils.addDurability(tooltip, stack);
    }

    @Override
    public float getAttackDamage() {
        ToolMaterial material = this.getMaterial();

        float damage = DEFAULT_ATTACK_DAMAGE;

        if (material instanceof BaseMekanismMaterial) {
            damage = ((BaseMekanismMaterial) material).getPaxelDamage();
        }

        return damage + getMaterial().getAttackDamage();
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        ToolMaterial material = this.getMaterial();

        float efficiency = material.getMiningSpeedMultiplier();

        if (material instanceof BaseMekanismMaterial) {
            efficiency = ((BaseMekanismMaterial) material).getPaxelEfficiency();
        }


        return super.getMiningSpeedMultiplier(stack, state) == 1 ? 1 : efficiency;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ActionResult result = ActionResult.PASS;

        for (Item validTool : VALID_TOOLS) {
            result = validTool.useOnBlock(context);
            if (ActionResult.PASS != result) break;
        }

        if (ActionResult.PASS != result) return result;
        return super.useOnBlock(context);
    }

    @Override
    public int getEnchantability() {
        ToolMaterial material = this.getMaterial();

        int enchantability = material.getEnchantability();
        if (material instanceof BaseMekanismMaterial) {
            enchantability = ((BaseMekanismMaterial) material).getPaxelEnchantability();
        }

        return enchantability;
    }

    @Override
    public @NotNull Ingredient getRepairMaterial() {
        return getMaterial().getRepairIngredient();
    }

    @Override
    public boolean isDamageable() {
        ToolMaterial material = this.getMaterial();

        if (material instanceof BaseMekanismMaterial) {
            return ((BaseMekanismMaterial) material).getPaxelMaxUses() > 0;
        } else {
            return super.isDamageable();
        }
    }
}
