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
    @Comment("Enables OakOres' Enderite support")
    public boolean enableEnderite = true;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Enables OakOres' ability to generate ores in the nether")
    public boolean enableNetherOres = true;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Amount of Purpi Ore in a world, default value is 10, maximum value of 64")
    public int purpiAmount = 6;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Maximum height for Purpi Ore to generate in a world, default value is 28, maximum value of 256.")
    public int purpiMaxHeight = 28;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Minimum height for Purpi Ore to generate in a world, default value is 5, maximum value of 256.")
    public int purpiMinHeight = 5;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Size of a Purpi Ore vein, default value is 6, maximum value of 64.")
    public int purpiVeinSize = 10;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Amount of Lead Ore in a world, default value is 25, maximum value of 64.")
    public int leadAmount = 25;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Size of Lead Ore veins, default value is 16, maximum value of 64.")
    public int leadVeinSize = 16;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Maximum height for Lead Ore to generate in a world, default value is 256, maximum value of 256.")
    public int leadMaxHeight = 256;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Amount of Deepslate Lead Ore in a world, default value is 4, maximum value of 64.")
    public int deepLeadAmount = 4;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Size of Deepslate Lead Ore veins, default value is 9, maximum value of 64.")
    public int deepLeadVeinSize = 9;

    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Gui.Excluded
    @Comment("Force enables Enderite support no matter what, false by default")
    public boolean forceEnableEnderite = false;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Amount of Enderite Ore in a world, default value is 8, maximum value of 64.")
    public int enderiteAmount = 8;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Size of Enderite Ore veins, default value is 5, maximum value of 64.")
    public int enderiteVeinSize = 5;

}
