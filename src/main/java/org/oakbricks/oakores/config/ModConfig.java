package org.oakbricks.oakores.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import org.oakbricks.oakores.OakOres;

@Config(name = OakOres.MOD_ID + "_config")
@Config.Gui.Background("minecraft:textures/block/oak_planks.png")
public class ModConfig implements ConfigData {

    @ConfigEntry.Gui.RequiresRestart
    public boolean enableEnderite = true;

    @ConfigEntry.Gui.RequiresRestart
    public boolean enableNetherOres = true;

    @ConfigEntry.Gui.RequiresRestart
    public int purpiAmount = 6;

    @ConfigEntry.Gui.RequiresRestart
    public int purpiMaxHeight = 28;

    @ConfigEntry.Gui.RequiresRestart
    public int purpiMinHeight = 5;

    @ConfigEntry.Gui.RequiresRestart
    public int purpiVeinSize = 10;

    @ConfigEntry.Gui.RequiresRestart
    public int leadAmount = 25;

    @ConfigEntry.Gui.RequiresRestart
    public int leadVeinSize = 16;

    @ConfigEntry.Gui.RequiresRestart
    public int leadMaxHeight = 256;

    //@ConfigEntry.Gui.RequiresRestart
    //public int minLeadGenHeight = 0;

    @ConfigEntry.Gui.RequiresRestart
    public int deepslateLeadAmount = 25;

    @ConfigEntry.Gui.RequiresRestart
    public int deepslateLeadMaxHeight = 256;

    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Gui.Excluded
    @Comment("Force enables Enderite support no matter what, false by default")
    public boolean forceEnableEnderite = false;

}
