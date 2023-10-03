package panda.mekanismfabric.resource;

public enum ResourceType {
    SHARD("shard"),
    CRYSTAL("crystal"),
    DUST("dust"),
    DIRTY_DUST("dirty_dust"),
    CLUMP("clump"),
    INGOT("ingot"),
    RAW("raw"),
    NUGGET("nugget"),
    ENRICHED("enriched");

    private final String pathPrefix;
    private final String pathSuffix;

    ResourceType(String pathPrefix) {
        this(pathPrefix, pathPrefix + "s");
    }

    ResourceType(String pathPrefix, String pathSuffix) {
        this.pathPrefix = pathPrefix;
        this.pathSuffix = pathSuffix;
    }

    public String getPathPrefix() {
        return pathPrefix;
    }

    public String getPathSuffix() {
        return pathSuffix;
    }

    public String getPath() {
        return pathPrefix + "/" + pathSuffix;
    }

    public boolean isVanilla() {
        return this == RAW || this == INGOT || this == NUGGET;
    }
}
