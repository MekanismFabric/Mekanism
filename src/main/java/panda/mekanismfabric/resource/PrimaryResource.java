package panda.mekanismfabric.resource;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;

public enum PrimaryResource implements IResource {
    IRON("iron", 0xFFAF8E77, TagKey.of(Registry.ITEM_KEY, new Identifier("iron_ore"))),
    GOLD("gold", 0xFFF2CD67, TagKey.of(Registry.ITEM_KEY, new Identifier("gold_ore"))),
    OSMIUM("osmium", 0xFF1E79C3, TagKey.of(Registry.ITEM_KEY, new Identifier("osmium_ore")), BlockResourceInfo.OSMIUM, BlockResourceInfo.RAW_OSMIUM),
    COPPER("copper", 0xFFAA4B19, TagKey.of(Registry.ITEM_KEY, new Identifier("copper_ore"))),
    TIN("tin", 0xFFCCCCD9, TagKey.of(Registry.ITEM_KEY, new Identifier("tin_ore")), BlockResourceInfo.TIN, BlockResourceInfo.RAW_TIN),
    LEAD("lead", 0xFF3A404A, TagKey.of(Registry.ITEM_KEY, new Identifier("lead_ore")), BlockResourceInfo.LEAD, BlockResourceInfo.RAW_LEAD),
    URANIUM("uranium", 0xFF46664F, TagKey.of(Registry.ITEM_KEY, new Identifier("uranium_ore")), BlockResourceInfo.URANIUM, BlockResourceInfo.RAW_URANIUM);

    private final String name;
    private final int tint;
    private final TagKey<Item> oreTag;
    private final boolean isVanilla;
    private final BlockResourceInfo resourceInfo;
    private final BlockResourceInfo rawResourceInfo;

    PrimaryResource(String name, int tint, TagKey<Item> oreTag) {
        this(name, tint, oreTag, true, null, null);
    }

    PrimaryResource(String name, int tint, TagKey<Item> oreTag, BlockResourceInfo resourceInfo, BlockResourceInfo rawResourceInfo) {
        this(name, tint, oreTag, false, resourceInfo, rawResourceInfo);
    }

    PrimaryResource(String name, int tint, TagKey<Item> oreTag, boolean isVanilla, BlockResourceInfo resourceInfo, BlockResourceInfo rawResourceInfo) {
        this.name = name;
        this.tint = tint;
        this.oreTag = oreTag;
        this.isVanilla = isVanilla;
        this.resourceInfo = resourceInfo;
        this.rawResourceInfo = rawResourceInfo;
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

    public boolean has(ResourceType type) {
        return type != ResourceType.ENRICHED && (!isVanilla() || !type.isVanilla());
    }

    public boolean isVanilla() {
        return isVanilla;
    }

    @Nullable
    public BlockResourceInfo getResourceInfo() {
        return resourceInfo;
    }

    @Nullable
    public BlockResourceInfo getRawResourceInfo() {
        return rawResourceInfo;
    }
}
