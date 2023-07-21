package mekanism.tools.config;

import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;

@Config(name = "mekanismtools")
public class MekanismToolsConfig extends PartitioningSerializer.GlobalData {

//    @ConfigEntry.Gui.Excluded
//    public static final ToolsConfig config = new ToolsConfig();

    @ConfigEntry.Gui.TransitiveObject
    public final ToolsClientConfig clientConfig = new ToolsClientConfig();
}
