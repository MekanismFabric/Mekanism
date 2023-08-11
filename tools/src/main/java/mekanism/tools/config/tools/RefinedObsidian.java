package mekanism.tools.config.tools;

import com.electronwill.nightconfig.core.conversion.Path;
import com.electronwill.nightconfig.core.conversion.SpecFloatInRange;
import com.electronwill.nightconfig.core.conversion.SpecIntInRange;
import lombok.Getter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import mekanism.tools.material.impl.RefinedObsidianMaterialDefaults;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;
import org.jetbrains.annotations.Nullable;

public class RefinedObsidian extends AbstractMaterialConfig implements ConfigData {

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "AttackDamage")
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @Comment("Base attack damage of " + RefinedObsidianMaterialDefaults.name + " items.")
    public float attackDamage = DEFAULT.getAttackDamage();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "ShieldDurability")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + RefinedObsidianMaterialDefaults.name + " shields.")
    public int shieldDurability = DEFAULT.getShieldDurability();

    @Path(RefinedObsidianMaterialDefaults.name + "SwordDamage")
    @Comment("Attack damage modifier of " + RefinedObsidianMaterialDefaults.name + " swords.")
    public float swordDamage = DEFAULT.getSwordDamage();

    @Path(RefinedObsidianMaterialDefaults.name + "SwordAtkSpeed")
    @Comment("Attack speed of " + RefinedObsidianMaterialDefaults.name + " swords.")
    public float swordAtkSpeed = DEFAULT.getSwordAtkSpeed();

    @Path(RefinedObsidianMaterialDefaults.name + "ShovelDamage")
    @Comment("Attack damage modifier of " + RefinedObsidianMaterialDefaults.name + " shovels.")
    public float shovelDamage = DEFAULT.getShovelDamage();

    @Path(RefinedObsidianMaterialDefaults.name + "ShovelAtkSpeed")
    @Comment("Attack speed of " + RefinedObsidianMaterialDefaults.name + " shovels.")
    public float shovelAtkSpeed = DEFAULT.getShovelAtkSpeed();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "AxeDamage")
    @Comment("Attack damage modifier of " + RefinedObsidianMaterialDefaults.name + " axes.")
    public float axeDamage = DEFAULT.getAxeDamage();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "AxeAtkSpeed")
    @Comment("Attack speed of " + RefinedObsidianMaterialDefaults.name + " axes.")
    public float axeAtkSpeed = DEFAULT.getAxeAtkSpeed();

    @Path(RefinedObsidianMaterialDefaults.name + "PickaxeDamage")
    @Comment("Attack damage modifier of " + RefinedObsidianMaterialDefaults.name + " pickaxes.")
    public float pickaxeDamage = DEFAULT.getPickaxeDamage();

    @Path(RefinedObsidianMaterialDefaults.name + "PickaxeAtkSpeed")
    @Comment("Attack speed of " + RefinedObsidianMaterialDefaults.name + " pickaxes.")
    public float pickaxeAtkSpeed = DEFAULT.getPickaxeAtkSpeed();

    @Path(RefinedObsidianMaterialDefaults.name + "HoeDamage")
    @Comment("Attack damage modifier of " + RefinedObsidianMaterialDefaults.name + " hoes.")
    public float hoeDamage = DEFAULT.getPickaxeAtkSpeed();

    @Path(RefinedObsidianMaterialDefaults.name + "HoeAtkSpeed")
    @Comment("Attack speed of " + RefinedObsidianMaterialDefaults.name + " hoes.")
    public float hoeAtkSpeed = DEFAULT.getHoeAtkSpeed();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "ToolMaxUses")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + RefinedObsidianMaterialDefaults.name + " tools.")
    public int durability = DEFAULT.getDurability();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "Efficiency")
    @Comment("Efficiency of " + RefinedObsidianMaterialDefaults.name + " tools.")
    public float miningSpeedMultiplier = DEFAULT.getMiningSpeedMultiplier();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "PaxelHarvestLevel")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Harvest level of " + RefinedObsidianMaterialDefaults.name + " paxels.")
    public int paxelHarvestLevel = DEFAULT.getMiningLevel();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "PaxelDamage")
    @Comment("Attack damage modifier of " + RefinedObsidianMaterialDefaults.name + " paxels.")
    public float paxelDamage = DEFAULT.getPaxelDamage();

    @Path(RefinedObsidianMaterialDefaults.name + "PaxelAtkSpeed")
    @Comment("Attack speed of " + RefinedObsidianMaterialDefaults.name + " paxels.")
    public float paxelAtkSpeed = DEFAULT.getPaxelAtkSpeed();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "PaxelEfficiency")
    @Comment("Efficiency of " + RefinedObsidianMaterialDefaults.name + " paxels.")
    public float paxelEfficiency = DEFAULT.getPaxelEfficiency();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "PaxelEnchantability")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Natural enchantability factor of " + RefinedObsidianMaterialDefaults.name + " paxels.")
    public int paxelEnchantability = DEFAULT.getPaxelEnchantability();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "PaxelMaxUses")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + RefinedObsidianMaterialDefaults.name + " paxels.")
    public int paxelMaxUses = DEFAULT.getPaxelMaxUses();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "HarvestLevel")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Harvest level of " + RefinedObsidianMaterialDefaults.name + " tools.")
    public int miningLevel = DEFAULT.getMiningLevel();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "Enchantability")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Natural enchantability factor of " + RefinedObsidianMaterialDefaults.name + " items.")
    public int enchantability = DEFAULT.getEnchantability();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "Toughness")
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @Comment("Base armor toughness value of " + RefinedObsidianMaterialDefaults.name + " armor.")
    public float toughness = DEFAULT.getToughness();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "KnockbackResistance")
    @SpecFloatInRange(min = 0.0F, max = Float.MAX_VALUE)
    @Comment("Base armor knockback resistance value of " + RefinedObsidianMaterialDefaults.name + " armor.")
    public float knockbackResistance = DEFAULT.getKnockbackResistance();

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "BootDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + RefinedObsidianMaterialDefaults.name + " boots.")
    public int bootDurability = DEFAULT.getDurability(ArmorItem.Type.BOOTS);

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "LeggingDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + RefinedObsidianMaterialDefaults.name + " leggings.")
    public int leggingDurability = DEFAULT.getDurability(ArmorItem.Type.LEGGINGS);

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "ChestplateDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + RefinedObsidianMaterialDefaults.name + " chestplates.")
    public int chestplateDurability = DEFAULT.getDurability(ArmorItem.Type.CHESTPLATE);

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "HelmetDurability")
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @Comment("Maximum durability of " + RefinedObsidianMaterialDefaults.name + " helmets.")
    public int helmetDurability = DEFAULT.getDurability(ArmorItem.Type.HELMET);

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "BootArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + RefinedObsidianMaterialDefaults.name + " boots.")
    public int bootArmor = DEFAULT.getProtection(ArmorItem.Type.BOOTS);

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "LeggingArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + RefinedObsidianMaterialDefaults.name + " leggings.")
    public int leggingArmor = DEFAULT.getProtection(ArmorItem.Type.LEGGINGS);

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "ChestplateArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + RefinedObsidianMaterialDefaults.name + " chestplates.")
    public int chestplateArmor = DEFAULT.getProtection(ArmorItem.Type.CHESTPLATE);

    @Getter
    @Path(RefinedObsidianMaterialDefaults.name + "HelmetArmor")
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @Comment("Protection value of " + RefinedObsidianMaterialDefaults.name + " helmets.")
    public int helmetArmor = DEFAULT.getProtection(ArmorItem.Type.HELMET);

    protected RefinedObsidian() { super(new RefinedObsidianMaterialDefaults()); }

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
