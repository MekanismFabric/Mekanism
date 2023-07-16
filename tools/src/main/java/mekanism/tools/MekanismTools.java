package mekanism.tools;

import mekanism.itemgroup.MekanismItemGroup;
import mekanism.tools.registries.ToolsItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MekanismTools implements ModInitializer {

    public static final String MODID = "mekanismtools";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public static Identifier id(String path) {
        return new Identifier(MODID, path);
    }

    public static final MekanismItemGroup MEKANISM_TOOLS = new MekanismItemGroup(() -> ToolsItems.DIAMOND_PAXEL,
            id("mekanismtools"), String.format("itemgroup.%s.items", MODID));

    @Override
    public void onInitialize() {
        LOGGER.info("Loading {}", MODID);
        ToolsItems.registerTools();
        MEKANISM_TOOLS.register();
    }
}