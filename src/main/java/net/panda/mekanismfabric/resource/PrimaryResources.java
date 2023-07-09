package net.panda.mekanismfabric.resource;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import static net.panda.mekanismfabric.Mekanism.MODID;

public enum PrimaryResources implements IResource {
    IRON("iron", 0xFFAF8E77, TagKey.of(RegistryKeys.ITEM, new Identifier("iron_ore"))),
    GOLD("gold", 0xFFF2CD67, TagKey.of(RegistryKeys.ITEM, new Identifier("gold_ore"))),
    OSMIUM("osmium", 0xFF1E79C3, TagKey.of(RegistryKeys.ITEM, new Identifier(MODID, "osmium_ore")), BlockResourceInfo.OSMIUM, BlockResourceInfo.RAW_OSMIUM),
    COPPER("copper", 0xFFAA4B19, TagKey.of(RegistryKeys.ITEM, new Identifier("copper_ore"))),
    TIN("tin", 0xFFCCCCD9, TagKey.of(RegistryKeys.ITEM, new Identifier(MODID, "tin_ore")), BlockResourceInfo.TIN, BlockResourceInfo.RAW_TIN),
    LEAD("lead", 0xFF3A404A, TagKey.of(RegistryKeys.ITEM, new Identifier(MODID, "lead_ore")), BlockResourceInfo.LEAD, BlockResourceInfo.RAW_LEAD),
    URANIUM("uranium", 0xFF46664F, TagKey.of(RegistryKeys.ITEM, new Identifier(MODID, "uranium_ore")), BlockResourceInfo.URANIUM, BlockResourceInfo.RAW_URANIUM);

    private final String name;
    private final int tint;
    private final TagKey<Item> oreTag;
    private final boolean isVanilla;
    private final BlockResourceInfo resourceBlockInfo;
    private final BlockResourceInfo rawResourceBlockInfo;

    PrimaryResources(String name, int tint, TagKey<Item> oreTag) {
        this(name, tint, oreTag, true, null, null);
    }

    PrimaryResources(String name, int tint, TagKey<Item> oreTag, BlockResourceInfo resourceBlockInfo, BlockResourceInfo rawResourceBlockInfo) {
        this(name, tint, oreTag, false, resourceBlockInfo, rawResourceBlockInfo);
    }

    PrimaryResources(String name, int tint, TagKey<Item> oreTag, boolean isVanilla, BlockResourceInfo resourceBlockInfo, BlockResourceInfo rawResourceBlockInfo) {
        this.name = name;
        this.tint = tint;
        this.oreTag = oreTag;
        this.isVanilla = isVanilla;
        this.resourceBlockInfo = resourceBlockInfo;
        this.rawResourceBlockInfo = rawResourceBlockInfo;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getTint() {
        return tint;
    }

    public TagKey<Item> getOreTag() {
        return oreTag;
    }

    public boolean has(ResourceTypes type) {
        return type != ResourceTypes.ENRICHED && (!isVanilla() || !type.isVanilla());
    }

    public boolean isVanilla() {
        return isVanilla;
    }

    @Nullable
    public BlockResourceInfo getResourceBlockInfo() {
        return resourceBlockInfo;
    }

    @Nullable
    public BlockResourceInfo getRawResourceBlockInfo() {
        return rawResourceBlockInfo;
    }
}
