package mekanism.tools.config.tools;

import com.electronwill.nightconfig.core.conversion.Path;
import com.electronwill.nightconfig.core.conversion.SpecFloatInRange;
import com.electronwill.nightconfig.core.conversion.SpecIntInRange;
import lombok.Getter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import mekanism.tools.material.impl.SteelMaterialDefaults;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;
import org.jetbrains.annotations.Nullable;

public class Steel extends AbstractMaterialConfig implements ConfigData {

    @Getter
    @Path(SteelMaterialDefaults.name + "AttackDamage")
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @Comment("Base attack damage of " + SteelMaterialDefaults.name + " items.")
    public float attackDamage = DEFAULT.getAttackDamage();

    @Getter
    @Path(SteelMaterialDefaults.name + "ShieldDurability")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + SteelMaterialDefaults.name + " shields.")
    public int shieldDurability = DEFAULT.getShieldDurability();

    @Path(SteelMaterialDefaults.name + "SwordDamage")
    @Comment("Attack damage modifier of " + SteelMaterialDefaults.name + " swords.")
    public float swordDamage = DEFAULT.getSwordDamage();

    @Path(SteelMaterialDefaults.name + "SwordAtkSpeed")
    @Comment("Attack speed of " + SteelMaterialDefaults.name + " swords.")
    public float swordAtkSpeed = DEFAULT.getSwordAtkSpeed();

    @Path(SteelMaterialDefaults.name + "ShovelDamage")
    @Comment("Attack damage modifier of " + SteelMaterialDefaults.name + " shovels.")
    public float shovelDamage = DEFAULT.getShovelDamage();

    @Path(SteelMaterialDefaults.name + "ShovelAtkSpeed")
    @Comment("Attack speed of " + SteelMaterialDefaults.name + " shovels.")
    public float shovelAtkSpeed = DEFAULT.getShovelAtkSpeed();

    @Getter
    @Path(SteelMaterialDefaults.name + "AxeDamage")
    @Comment("Attack damage modifier of " + SteelMaterialDefaults.name + " axes.")
    public float axeDamage = DEFAULT.getAxeDamage();

    @Getter
    @Path(SteelMaterialDefaults.name + "AxeAtkSpeed")
    @Comment("Attack speed of " + SteelMaterialDefaults.name + " axes.")
    public float axeAtkSpeed = DEFAULT.getAxeAtkSpeed();

    @Path(SteelMaterialDefaults.name + "PickaxeDamage")
    @Comment("Attack damage modifier of " + SteelMaterialDefaults.name + " pickaxes.")
    public float pickaxeDamage = DEFAULT.getPickaxeDamage();

    @Path(SteelMaterialDefaults.name + "PickaxeAtkSpeed")
    @Comment("Attack speed of " + SteelMaterialDefaults.name + " pickaxes.")
    public float pickaxeAtkSpeed = DEFAULT.getPickaxeAtkSpeed();

    @Path(SteelMaterialDefaults.name + "HoeDamage")
    @Comment("Attack damage modifier of " + SteelMaterialDefaults.name + " hoes.")
    public float hoeDamage = DEFAULT.getPickaxeAtkSpeed();

    @Path(SteelMaterialDefaults.name + "HoeAtkSpeed")
    @Comment("Attack speed of " + SteelMaterialDefaults.name + " hoes.")
    public float hoeAtkSpeed = DEFAULT.getHoeAtkSpeed();

    @Getter
    @Path(SteelMaterialDefaults.name + "ToolMaxUses")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + SteelMaterialDefaults.name + " tools.")
    public int durability = DEFAULT.getDurability();

    @Getter
    @Path(SteelMaterialDefaults.name + "Efficiency")
    @Comment("Efficiency of " + SteelMaterialDefaults.name + " tools.")
    public float miningSpeedMultiplier = DEFAULT.getMiningSpeedMultiplier();

    @Getter
    @Path(SteelMaterialDefaults.name + "PaxelHarvestLevel")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Harvest level of " + SteelMaterialDefaults.name + " paxels.")
    public int paxelHarvestLevel = DEFAULT.getMiningLevel();

    @Getter
    @Path(SteelMaterialDefaults.name + "PaxelDamage")
    @Comment("Attack damage modifier of " + SteelMaterialDefaults.name + " paxels.")
    public float paxelDamage = DEFAULT.getPaxelDamage();

    @Path(SteelMaterialDefaults.name + "PaxelAtkSpeed")
    @Comment("Attack speed of " + SteelMaterialDefaults.name + " paxels.")
    public float paxelAtkSpeed = DEFAULT.getPaxelAtkSpeed();

    @Getter
    @Path(SteelMaterialDefaults.name + "PaxelEfficiency")
    @Comment("Efficiency of " + SteelMaterialDefaults.name + " paxels.")
    public float paxelEfficiency = DEFAULT.getPaxelEfficiency();

    @Getter
    @Path(SteelMaterialDefaults.name + "PaxelEnchantability")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Natural enchantability factor of " + SteelMaterialDefaults.name + " paxels.")
    public int paxelEnchantability = DEFAULT.getPaxelEnchantability();

    @Getter
    @Path(SteelMaterialDefaults.name + "PaxelMaxUses")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + SteelMaterialDefaults.name + " paxels.")
    public int paxelMaxUses = DEFAULT.getPaxelMaxUses();

    @Getter
    @Path(SteelMaterialDefaults.name + "HarvestLevel")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Harvest level of " + SteelMaterialDefaults.name + " tools.")
    public int miningLevel = DEFAULT.getMiningLevel();

    @Getter
    @Path(SteelMaterialDefaults.name + "Enchantability")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Natural enchantability factor of " + SteelMaterialDefaults.name + " items.")
    public int enchantability = DEFAULT.getEnchantability();

    @Getter
    @Path(SteelMaterialDefaults.name + "Toughness")
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @Comment("Base armor toughness value of " + SteelMaterialDefaults.name + " armor.")
    public float toughness = DEFAULT.getToughness();

    @Getter
    @Path(SteelMaterialDefaults.name + "KnockbackResistance")
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @Comment("Base armor knockback resistance value of " + SteelMaterialDefaults.name + " armor.")
    public float knockbackResistance = DEFAULT.getKnockbackResistance();

    @Getter
    @Path(SteelMaterialDefaults.name + "BootDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + SteelMaterialDefaults.name + " boots.")
    public int bootDurability = DEFAULT.getDurability(ArmorItem.Type.BOOTS);

    @Getter
    @Path(SteelMaterialDefaults.name + "LeggingDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + SteelMaterialDefaults.name + " leggings.")
    public int leggingDurability = DEFAULT.getDurability(ArmorItem.Type.LEGGINGS);

    @Getter
    @Path(SteelMaterialDefaults.name + "ChestplateDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + SteelMaterialDefaults.name + " chestplates.")
    public int chestplateDurability = DEFAULT.getDurability(ArmorItem.Type.CHESTPLATE);

    @Getter
    @Path(SteelMaterialDefaults.name + "HelmetDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + SteelMaterialDefaults.name + " helmets.")
    public int helmetDurability = DEFAULT.getDurability(ArmorItem.Type.HELMET);

    @Getter
    @Path(SteelMaterialDefaults.name + "BootArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + SteelMaterialDefaults.name + " boots.")
    public int bootArmor = DEFAULT.getProtection(ArmorItem.Type.BOOTS);

    @Getter
    @Path(SteelMaterialDefaults.name + "LeggingArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + SteelMaterialDefaults.name + " leggings.")
    public int leggingArmor = DEFAULT.getProtection(ArmorItem.Type.LEGGINGS);

    @Getter
    @Path(SteelMaterialDefaults.name + "ChestplateArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + SteelMaterialDefaults.name + " chestplates.")
    public int chestplateArmor = DEFAULT.getProtection(ArmorItem.Type.CHESTPLATE);

    @Getter
    @Path(SteelMaterialDefaults.name + "HelmetArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + SteelMaterialDefaults.name + " helmets.")
    public int helmetArmor = DEFAULT.getProtection(ArmorItem.Type.HELMET);

    protected Steel() { super(new SteelMaterialDefaults()); }

    @Override
    public @Nullable TagKey<Block> getTag() { return null; }

    @Override
    public int getPaxelMiningLevel() { return 0; }

    @Override
    public int getCommonEnchantability() { return 0; }

    @Override
    public Ingredient getCommonRepairMaterial() { return null; }

    @Override
    public String getConfigCommentName() { return null; }
}
