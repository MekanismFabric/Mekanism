package mekanism.tools.config;

import com.electronwill.nightconfig.core.conversion.Path;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import mekanism.tools.config.tools.Tools;

@Config(name = "tools")
@Path("Mekanism")
public class ToolsConfig implements ConfigData {

    @Path("tools")
    @ConfigEntry.Gui.TransitiveObject
    @Comment("Mekanism Tools Config. This config is synced from server to client.")
    public Tools config = new Tools();
}
