package mekanism.tools;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import mekanism.itemgroup.MekanismItemGroup;
import mekanism.tools.config.MekanismToolsConfig;
import mekanism.tools.config.ToolsConfig;
import mekanism.tools.registries.ToolsEvents;
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

    public static MekanismItemGroup MEKANISM_TOOLS;

    @Override
    public void onInitialize() {
        LOGGER.info("Loading {}", MODID);

        AutoConfig.register(MekanismToolsConfig.class, PartitioningSerializer.wrap(Toml4jConfigSerializer::new));

        MEKANISM_TOOLS = new MekanismItemGroup(() -> ToolsItems.DIAMOND_PAXEL,
                id("mekanismtools"), String.format("itemgroup.%s.items", MODID), ToolsItems.ALL_TOOLS);

        ToolsItems.registerTools();
        MEKANISM_TOOLS.register();
        ToolsEvents.register();
    }

    public static ToolsConfig config() {
        return AutoConfig.getConfigHolder(MekanismToolsConfig.class).getConfig().config;
    }
}