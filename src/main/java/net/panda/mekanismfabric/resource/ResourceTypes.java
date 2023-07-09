package net.panda.mekanismfabric.resource;

public enum ResourceTypes {
    SHARD("shard"),
    CRYSTAL("crystal"),
    DUST("dust"),
    DIRTY_DUST("dirty_dust"),
    CLUMP("clump"),
    INGOT("ingot"),
    RAW("raw"),
    NUGGET("nugget"),
    ENRICHED("enriched");

    private String pathPrefix;
    private String pathSuffix;
    private String path;

    ResourceTypes(String pathPrefix) {
        this(pathPrefix, pathPrefix + "s");
    }

    ResourceTypes(String pathPrefix, String pathSuffix) {
        this.pathPrefix = pathPrefix;
        this.pathSuffix = pathSuffix;
        this.path = pathPrefix + "/" + pathSuffix;
    }

    public String getPathPrefix() {
        return pathPrefix;
    }

    public String getPathSuffix() {
        return pathSuffix;
    }

    public String getPath() {
        return path;
    }

    public boolean isVanilla() {
        return this == RAW || this == INGOT || this == NUGGET;
    }
}
