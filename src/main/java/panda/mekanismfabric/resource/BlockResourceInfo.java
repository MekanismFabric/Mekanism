package panda.mekanismfabric.resource;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MapColor;

public enum BlockResourceInfo implements IResource {

    OSMIUM("osmium", 7.5F, 12,MapColor.CYAN),
    RAW_OSMIUM("raw_osmium", 7.5F, 12,MapColor.CYAN),
    TIN("tin", 5, 6, MapColor.TERRACOTTA_WHITE),
    RAW_TIN("raw_tin", 5, 6, MapColor.TERRACOTTA_WHITE),
    LEAD("lead", 5, 9, MapColor.LIGHT_GRAY),
    RAW_LEAD("raw_lead", 5, 9, MapColor.LIGHT_GRAY),
    URANIUM("uranium", 5, 9, MapColor.PALE_GREEN),
    RAW_URANIUM("raw_uranium", 5, 9, MapColor.PALE_GREEN),
    CHARCOAL("charcoal", 5, 6, MapColor.BLACK, 16_000),
    FLUORITE("fluorite", 5, 9, MapColor.WHITE),
    BRONZE("bronze", 5, 9, MapColor.ORANGE),
    STEEL("steel", 5, 9, MapColor.STONE_GRAY),
    REFINED_OBSIDIAN("refined_obsidian", 50, 2_400, MapColor.PURPLE, -1, 8, true),
    REFINED_GLOWSTONE("refined_glowstone", 5, 6, MapColor.YELLOW, -1, 15);

    private final String name;
    private final MapColor mapColor;
    private final boolean portalFrame;
    private final float resistance;
    private final float hardness;
    private final int burnTime;
    private final int luminance;

    BlockResourceInfo(String name, float hardness, float resistance, MapColor mapColor) {
        this(name, hardness, resistance, mapColor, -1);
    }

    BlockResourceInfo(String name, float hardness, float resistance, MapColor mapColor, int burnTime) {
        this(name, hardness, resistance, mapColor, burnTime, 0);
    }

    BlockResourceInfo(String name, float hardness, float resistance, MapColor mapColor, int burnTime, int luminance) {
        this(name, hardness, resistance, mapColor, burnTime, luminance, false);
    }

    BlockResourceInfo(String name, float hardness, float resistance, MapColor mapColor, int burnTime, int luminance,
                      boolean portalFrame) {
        this.name = name;
        this.portalFrame = portalFrame;
        this.burnTime = burnTime;
        this.luminance = luminance;
        this.resistance = resistance;
        this.hardness = hardness;
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

    public AbstractBlock.Settings modifyProperties(AbstractBlock.Settings settings) {
        return settings.mapColor(mapColor).strength(hardness, resistance).luminance(state -> luminance);
    }
}
