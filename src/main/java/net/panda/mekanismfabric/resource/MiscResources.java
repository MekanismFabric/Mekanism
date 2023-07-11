package net.panda.mekanismfabric.resource;

public enum MiscResources implements IResource {
    BRONZE("bronze"),
    CARBON("carbon"),
    CHARCOAL("charcoal"),
    COAL("coal"),
    DIAMOND("diamond"),
    EMERALD("emerald"),
    NETHERITE("netherite"),
    LAPIS_LAZULI("lapis_lazuli"),
    LITHIUM("lithium"),
    OBSIDIAN("obsidian"),
    QUARTZ("quartz"),
    REDSTONE("redstone"),
    REFINED_GLOWSTONE("refined_glowstone"),
    REFINED_OBSIDIAN("refined_obsidian"),
    STEEL("steel"),
    SULFUR("sulfur"),
    FLUORITE("fluorite");

    private final String name;

    MiscResources(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
