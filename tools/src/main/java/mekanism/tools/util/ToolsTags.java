package mekanism.tools.util;

import net.fabricmc.fabric.impl.tag.convention.TagRegistration;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

import static mekanism.tools.MekanismTools.id;

public class ToolsTags {

    public static void init() {
        Blocks.init();
        Items.init();
    }

    public static class Blocks {
        private static void init() {}

        public static final TagKey<Block> MINEABLE_WITH_PAXEL = commonTag("mineable/paxel");
        public static final TagKey<Block> NEEDS_BRONZE_TOOL = tag("needs_bronze_tool");
        public static final TagKey<Block> NEEDS_LAPIS_LAZULI_TOOL = tag("needs_lapis_lazuli_tool");
        public static final TagKey<Block> NEEDS_OSMIUM_TOOL = tag("needs_osmium_tool");
        public static final TagKey<Block> NEEDS_REFINED_GLOWSTONE_TOOL = tag("needs_refined_glowstone_tool");
        public static final TagKey<Block> NEEDS_REFINED_OBSIDIAN_TOOL = tag("needs_refined_obsidian_tool");
        public static final TagKey<Block> NEEDS_STEEL_TOOL = tag("needs_steel_tool");

        private static TagKey<Block> commonTag(String name) {
            return TagRegistration.BLOCK_TAG_REGISTRATION.registerCommon(name);
        }

        private static TagKey<Block> tag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, id(name));
        }
    }

    public static class Items {
        private static void init() {}

        public static final TagKey<Item> TOOLS_PAXELS = tag("tools/paxels");

        public static final TagKey<Item> TOOLS_PAXELS_WOOD = tag("tools/paxels/wood");
        public static final TagKey<Item> TOOLS_PAXELS_STONE = tag("tools/paxels/stone");
        public static final TagKey<Item> TOOLS_PAXELS_GOLD = tag("tools/paxels/gold");
        public static final TagKey<Item> TOOLS_PAXELS_IRON = tag("tools/paxels/iron");
        public static final TagKey<Item> TOOLS_PAXELS_DIAMOND = tag("tools/paxels/diamond");
        public static final TagKey<Item> TOOLS_PAXELS_NETHERITE = tag("tools/paxels/netherite");

        public static final TagKey<Item> TOOLS_PAXELS_BRONZE = tag("tools/paxels/bronze");
        public static final TagKey<Item> TOOLS_PAXELS_LAPIS_LAZULI = tag("tools/paxels/lapis_lazuli");
        public static final TagKey<Item> TOOLS_PAXELS_OSMIUM = tag("tools/paxels/osmium");
        public static final TagKey<Item> TOOLS_PAXELS_REFINED_GLOWSTONE = tag("tools/paxels/refined_glowstone");
        public static final TagKey<Item> TOOLS_PAXELS_REFINED_OBSIDIAN = tag("tools/paxels/refined_obsidian");
        public static final TagKey<Item> TOOLS_PAXELS_STEEL = tag("tools/paxels/steel");

        public static final TagKey<Item> TOOLS_SWORDS_BRONZE = tag("tools/swords/bronze");
        public static final TagKey<Item> TOOLS_SWORDS_LAPIS_LAZULI = tag("tools/swords/lapis_lazuli");
        public static final TagKey<Item> TOOLS_SWORDS_OSMIUM = tag("tools/swords/osmium");
        public static final TagKey<Item> TOOLS_SWORDS_REFINED_GLOWSTONE = tag("tools/swords/refined_glowstone");
        public static final TagKey<Item> TOOLS_SWORDS_REFINED_OBSIDIAN = tag("tools/swords/refined_obsidian");
        public static final TagKey<Item> TOOLS_SWORDS_STEEL = tag("tools/swords/steel");

        public static final TagKey<Item> TOOLS_AXES_BRONZE = tag("tools/axes/bronze");
        public static final TagKey<Item> TOOLS_AXES_LAPIS_LAZULI = tag("tools/axes/lapis_lazuli");
        public static final TagKey<Item> TOOLS_AXES_OSMIUM = tag("tools/axes/osmium");
        public static final TagKey<Item> TOOLS_AXES_REFINED_GLOWSTONE = tag("tools/axes/refined_glowstone");
        public static final TagKey<Item> TOOLS_AXES_REFINED_OBSIDIAN = tag("tools/axes/refined_obsidian");
        public static final TagKey<Item> TOOLS_AXES_STEEL = tag("tools/axes/steel");

        public static final TagKey<Item> TOOLS_PICKAXES_BRONZE = tag("tools/pickaxes/bronze");
        public static final TagKey<Item> TOOLS_PICKAXES_LAPIS_LAZULI = tag("tools/pickaxes/lapis_lazuli");
        public static final TagKey<Item> TOOLS_PICKAXES_OSMIUM = tag("tools/pickaxes/osmium");
        public static final TagKey<Item> TOOLS_PICKAXES_REFINED_GLOWSTONE = tag("tools/pickaxes/refined_glowstone");
        public static final TagKey<Item> TOOLS_PICKAXES_REFINED_OBSIDIAN = tag("tools/pickaxes/refined_obsidian");
        public static final TagKey<Item> TOOLS_PICKAXES_STEEL = tag("tools/pickaxes/steel");

        public static final TagKey<Item> TOOLS_SHOVELS_BRONZE = tag("tools/shovels/bronze");
        public static final TagKey<Item> TOOLS_SHOVELS_LAPIS_LAZULI = tag("tools/shovels/lapis_lazuli");
        public static final TagKey<Item> TOOLS_SHOVELS_OSMIUM = tag("tools/shovels/osmium");
        public static final TagKey<Item> TOOLS_SHOVELS_REFINED_GLOWSTONE = tag("tools/shovels/refined_glowstone");
        public static final TagKey<Item> TOOLS_SHOVELS_REFINED_OBSIDIAN = tag("tools/shovels/refined_obsidian");
        public static final TagKey<Item> TOOLS_SHOVELS_STEEL = tag("tools/shovels/steel");

        public static final TagKey<Item> TOOLS_HOES_BRONZE = tag("tools/hoes/bronze");
        public static final TagKey<Item> TOOLS_HOES_LAPIS_LAZULI = tag("tools/hoes/lapis_lazuli");
        public static final TagKey<Item> TOOLS_HOES_OSMIUM = tag("tools/hoes/osmium");
        public static final TagKey<Item> TOOLS_HOES_REFINED_GLOWSTONE = tag("tools/hoes/refined_glowstone");
        public static final TagKey<Item> TOOLS_HOES_REFINED_OBSIDIAN = tag("tools/hoes/refined_obsidian");
        public static final TagKey<Item> TOOLS_HOES_STEEL = tag("tools/hoes/steel");

        public static final TagKey<Item> TOOLS_SHIELDS_BRONZE = tag("tools/shields/bronze");
        public static final TagKey<Item> TOOLS_SHIELDS_LAPIS_LAZULI = tag("tools/shields/lapis_lazuli");
        public static final TagKey<Item> TOOLS_SHIELDS_OSMIUM = tag("tools/shields/osmium");
        public static final TagKey<Item> TOOLS_SHIELDS_REFINED_GLOWSTONE = tag("tools/shields/refined_glowstone");
        public static final TagKey<Item> TOOLS_SHIELDS_REFINED_OBSIDIAN = tag("tools/shields/refined_obsidian");
        public static final TagKey<Item> TOOLS_SHIELDS_STEEL = tag("tools/shields/steel");

        public static final TagKey<Item> ARMORS_HELMETS_BRONZE = tag("armors/helmets/bronze");
        public static final TagKey<Item> ARMORS_HELMETS_LAPIS_LAZULI = tag("armors/helmets/lapis_lazuli");
        public static final TagKey<Item> ARMORS_HELMETS_OSMIUM = tag("armors/helmets/osmium");
        public static final TagKey<Item> ARMORS_HELMETS_REFINED_GLOWSTONE = tag("armors/helmets/refined_glowstone");
        public static final TagKey<Item> ARMORS_HELMETS_REFINED_OBSIDIAN = tag("armors/helmets/refined_obsidian");
        public static final TagKey<Item> ARMORS_HELMETS_STEEL = tag("armors/helmets/steel");

        public static final TagKey<Item> ARMORS_CHESTPLATES_BRONZE = tag("armors/chestplates/bronze");
        public static final TagKey<Item> ARMORS_CHESTPLATES_LAPIS_LAZULI = tag("armors/chestplates/lapis_lazuli");
        public static final TagKey<Item> ARMORS_CHESTPLATES_OSMIUM = tag("armors/chestplates/osmium");
        public static final TagKey<Item> ARMORS_CHESTPLATES_REFINED_GLOWSTONE = tag("armors/chestplates/refined_glowstone");
        public static final TagKey<Item> ARMORS_CHESTPLATES_REFINED_OBSIDIAN = tag("armors/chestplates/refined_obsidian");
        public static final TagKey<Item> ARMORS_CHESTPLATES_STEEL = tag("armors/chestplates/steel");

        public static final TagKey<Item> ARMORS_LEGGINGS_BRONZE = tag("armors/leggings/bronze");
        public static final TagKey<Item> ARMORS_LEGGINGS_LAPIS_LAZULI = tag("armors/leggings/lapis_lazuli");
        public static final TagKey<Item> ARMORS_LEGGINGS_OSMIUM = tag("armors/leggings/osmium");
        public static final TagKey<Item> ARMORS_LEGGINGS_REFINED_GLOWSTONE = tag("armors/leggings/refined_glowstone");
        public static final TagKey<Item> ARMORS_LEGGINGS_REFINED_OBSIDIAN = tag("armors/leggings/refined_obsidian");
        public static final TagKey<Item> ARMORS_LEGGINGS_STEEL = tag("armors/leggings/steel");

        public static final TagKey<Item> ARMORS_BOOTS_BRONZE = tag("armors/boots/bronze");
        public static final TagKey<Item> ARMORS_BOOTS_LAPIS_LAZULI = tag("armors/boots/lapis_lazuli");
        public static final TagKey<Item> ARMORS_BOOTS_OSMIUM = tag("armors/boots/osmium");
        public static final TagKey<Item> ARMORS_BOOTS_REFINED_GLOWSTONE = tag("armors/boots/refined_glowstone");
        public static final TagKey<Item> ARMORS_BOOTS_REFINED_OBSIDIAN = tag("armors/boots/refined_obsidian");
        public static final TagKey<Item> ARMORS_BOOTS_STEEL = tag("armors/boots/steel");

        private static TagKey<Item> tag(String name) {
            return TagKey.of(RegistryKeys.ITEM, id(name));
        }
    }
}
