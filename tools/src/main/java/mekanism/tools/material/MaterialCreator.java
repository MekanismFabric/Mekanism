package mekanism.tools.material;

import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import org.jetbrains.annotations.Nullable;

public class MaterialCreator extends BaseMekanismMaterial {

    private final BaseMekanismMaterial fallback;

    private final int shieldDurability;
    private final float swordDamage;
    private final float swordAtkSpeed;
    private final float shovelDamage;
    private final float shovelAtkSpeed;
    private final float axeDamage;
    private final float axeAtkSpeed;
    private final float pickaxeDamage;
    private final float pickaxeAtkSpeed;
    private final float hoeDamage;
    private final float hoeAtkSpeed;
    private final float paxelDamage;
    private final float paxelAtkSpeed;
    private final float paxelEfficiency;
    private final int paxelMiningLevel;
    private final int paxelEnchantability;
    private final int paxelMaxUses;
    private final int toolMaxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final float toughness;
    private final float knockbackResistance;
    private final int bootDurability;
    private final int leggingDurability;
    private final int chestplateDurability;
    private final int helmetDurability;
    private final int bootArmor;
    private final int leggingArmor;
    private final int chestplateArmor;
    private final int helmetArmor;

    public MaterialCreator(BaseMekanismMaterial materialDefaults) {
        fallback = materialDefaults;
        // TODO: Define configurations.
        attackDamage = materialDefaults.getAttackDamage();
        shieldDurability = materialDefaults.getShieldDurability();
        swordDamage = materialDefaults.getSwordDamage();
        swordAtkSpeed = materialDefaults.getSwordAtkSpeed();
        shovelDamage = materialDefaults.getShovelDamage();
        shovelAtkSpeed = materialDefaults.getShovelAtkSpeed();
        axeDamage = materialDefaults.getAxeDamage();
        axeAtkSpeed = materialDefaults.getAxeAtkSpeed();
        pickaxeDamage = materialDefaults.getPickaxeDamage();
        pickaxeAtkSpeed = materialDefaults.getPickaxeAtkSpeed();
        hoeDamage = materialDefaults.getHoeDamage();
        hoeAtkSpeed = materialDefaults.getHoeAtkSpeed();
        toolMaxUses = materialDefaults.getDurability();
        efficiency = materialDefaults.getMiningSpeedMultiplier();
        paxelDamage = materialDefaults.getPaxelDamage();
        paxelAtkSpeed = materialDefaults.getPaxelAtkSpeed();
        paxelEfficiency = materialDefaults.getPaxelEfficiency();
        paxelEnchantability = materialDefaults.getPaxelEnchantability();
        paxelMaxUses = materialDefaults.getPaxelMaxUses();
        paxelMiningLevel = materialDefaults.getPaxelMiningLevel();
        enchantability = materialDefaults.getEnchantability();
        toughness = materialDefaults.getToughness();
        knockbackResistance = materialDefaults.getKnockbackResistance();
        bootDurability = materialDefaults.getDurability(ArmorItem.Type.BOOTS);
        leggingDurability = materialDefaults.getDurability(ArmorItem.Type.LEGGINGS);
        chestplateDurability = materialDefaults.getDurability(ArmorItem.Type.CHESTPLATE);
        helmetDurability = materialDefaults.getDurability(ArmorItem.Type.HELMET);
        bootArmor = materialDefaults.getProtection(ArmorItem.Type.BOOTS);
        leggingArmor = materialDefaults.getProtection(ArmorItem.Type.LEGGINGS);
        chestplateArmor = materialDefaults.getProtection(ArmorItem.Type.CHESTPLATE);
        helmetArmor = materialDefaults.getProtection(ArmorItem.Type.HELMET);
    }

    @Override
    public int getShieldDurability() {
        return shieldDurability;
    }

    @Override
    public float getSwordDamage() {
        return swordDamage;
    }

    @Override
    public float getSwordAtkSpeed() {
        return swordAtkSpeed;
    }

    @Override
    public float getShovelDamage() {
        return shovelDamage;
    }

    @Override
    public float getShovelAtkSpeed() {
        return shovelAtkSpeed;
    }

    @Override
    public float getAxeDamage() {
        return axeDamage;
    }

    @Override
    public float getAxeAtkSpeed() {
        return axeAtkSpeed;
    }

    @Override
    public float getPickaxeDamage() {
        return pickaxeDamage;
    }

    @Override
    public float getPickaxeAtkSpeed() {
        return pickaxeAtkSpeed;
    }

    @Override
    public float getHoeDamage() {
        return hoeDamage;
    }

    @Override
    public float getHoeAtkSpeed() {
        return hoeAtkSpeed;
    }

    @Override
    public int getPaxelMaxUses() {
        return paxelMaxUses;
    }

    @Override
    public float getPaxelEfficiency() {
        return paxelEfficiency;
    }

    @Override
    public float getPaxelDamage() {
        return paxelDamage;
    }

    @Override
    public float getPaxelAtkSpeed() {
        return paxelAtkSpeed;
    }

    @Override
    public int getPaxelMiningLevel() {
        return paxelMiningLevel;
    }

    @Override
    public int getDurability() {
        return toolMaxUses;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    @Deprecated
    public int getMiningLevel() {
        return fallback.getMiningLevel();
    }

    @Nullable
    @Override
    public TagKey<Block> getTag() {
        return fallback.getTag();
    }

    @Override
    public int getDurability(ArmorItem.Type armorType) {
        return switch (armorType) {
            case BOOTS -> bootDurability;
            case LEGGINGS -> leggingDurability;
            case CHESTPLATE -> chestplateDurability;
            case HELMET -> helmetDurability;
        };
    }

    @Override
    public int getProtection(ArmorItem.Type armorType) {
        return switch (armorType) {
            case BOOTS -> bootArmor;
            case LEGGINGS -> leggingArmor;
            case CHESTPLATE -> chestplateArmor;
            case HELMET -> helmetArmor;
        };
    }

    @Override
    public int getCommonEnchantability() {
        return enchantability;
    }

    @Override
    public boolean burnsInFire() {
        return fallback.burnsInFire();
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public SoundEvent getEquipSound() {
        return fallback.getEquipSound();
    }

    @Override
    public Ingredient getCommonRepairMaterial() {
        return fallback.getCommonRepairMaterial();
    }

    @Override
    public String getConfigCommentName() {
        return fallback.getConfigCommentName();
    }

    /**
     * Only used on the client in vanilla
     */
    @Override
    public String getName() {
        return fallback.getName();
    }

    @Override
    public String getRegistryPrefix() {
        return fallback.getRegistryPrefix();
    }

    @Override
    public int getPaxelEnchantability() {
        return paxelEnchantability;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }

    public int getBootArmor() {
        return bootArmor;
    }

    public int getLeggingArmor() {
        return leggingArmor;
    }

    public int getChestplateArmor() {
        return chestplateArmor;
    }

    public int getHelmetArmor() {
        return helmetArmor;
    }
}
