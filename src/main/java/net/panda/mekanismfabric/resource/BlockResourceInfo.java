package net.panda.mekanismfabric.resource;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import org.jetbrains.annotations.Nullable;

public enum BlockResourceInfo implements IResource {
    OSMIUM("osmium", 7.5F, 12, MapColor.CYAN),
    RAW_OSMIUM("raw_osmium", 7.5F, 12, MapColor.CYAN, Instrument.BASEDRUM),
    TIN("tin", 5, 6, MapColor.TERRACOTTA_WHITE),
    RAW_TIN("raw_tin", 5, 6, MapColor.TERRACOTTA_WHITE, Instrument.BASEDRUM),
    LEAD("lead", 5, 9, MapColor.LIGHT_GRAY),
    RAW_LEAD("raw_lead", 5, 9, MapColor.LIGHT_GRAY, Instrument.BASEDRUM),
    URANIUM("uranium", 5, 9, MapColor.PALE_GREEN),
    RAW_URANIUM("raw_uranium", 5, 9, MapColor.PALE_GREEN, Instrument.BASEDRUM),
    CHARCOAL("charcoal", 5, 6, MapColor.BLACK, Instrument.BASEDRUM, 16_000),
    FLUORITE("fluorite", 5, 9, MapColor.WHITE),
    BRONZE("bronze", 5, 9, MapColor.ORANGE),
    STEEL("steel", 5, 9, MapColor.STONE_GRAY),
    REFINED_OBSIDIAN("refined_obsidian", 50, 2_400, MapColor.PURPLE, Instrument.BASEDRUM, -1, 8, false, true, PistonBehavior.BLOCK),
    REFINED_GLOWSTONE("refined_glowstone", 5, 6, MapColor.YELLOW, Instrument.BASEDRUM, -1, 15);

    private final String name;
    private final MapColor mapColor;
    private final PistonBehavior pistonBehavior;
    private final boolean portalFrame;
    private final boolean burnsInFire;
    private final Instrument instrument;
    private final float resistance;
    private final float hardness;
    private final int burnTime;
    private final int luminance;

    BlockResourceInfo(String name, float hardness, float resistance, MapColor mapColor) {
        this(name, hardness, resistance, mapColor, null);
    }

    BlockResourceInfo(String name, float hardness, float resistance, MapColor mapColor, @Nullable Instrument instrument) {
        this(name, hardness, resistance, mapColor, instrument, -1);
    }

    BlockResourceInfo(String name, float hardness, float resistance, MapColor mapColor, @Nullable Instrument instrument, int burnTime) {
        this(name, hardness, resistance, mapColor, instrument, burnTime, 0);
    }

    BlockResourceInfo(String name, float hardness, float resistance, MapColor mapColor, @Nullable Instrument instrument, int burnTime, int luminance) {
        this(name, hardness, resistance, mapColor, instrument, burnTime, luminance, true, false, PistonBehavior.NORMAL);
    }

    BlockResourceInfo(String name, float hardness, float resistance, MapColor mapColor, @Nullable Instrument instrument, int burnTime, int luminance,
                      boolean burnsInFire, boolean portalFrame, PistonBehavior pistonBehavior) {
        this.name = name;
        this.pistonBehavior = pistonBehavior;
        this.portalFrame = portalFrame;
        this.burnsInFire = burnsInFire;
        this.burnTime = burnTime;
        this.luminance = luminance;
        this.resistance = resistance;
        this.hardness = hardness;
        this.instrument = instrument;
        this.mapColor = mapColor;
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean isPortalFrame() {
        return portalFrame;
    }

    public int getBurnTime() {
        return burnTime;
    }

    public boolean burnsInFire() {
        return burnsInFire;
    }

    public AbstractBlock.Settings modifyProperties(AbstractBlock.Settings settings) {
        if (instrument != null) {
            settings.instrument(instrument);
        }
        if (burnsInFire) {
            settings.burnable();
        }
        return settings.mapColor(mapColor).strength(hardness, resistance).luminance(state -> luminance).pistonBehavior(pistonBehavior);
    }
}
