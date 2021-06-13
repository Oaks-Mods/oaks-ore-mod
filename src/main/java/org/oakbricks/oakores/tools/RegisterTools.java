package org.oakbricks.oakores.tools;

import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.oakbricks.oakores.OakOres;

import static org.oakbricks.oakores.OakOres.MOD_ID;

public class RegisterTools {

    public static ToolItem PURPI_SWORD = new SwordItem(PurpiToolMaterial.INSTANCE, 9, -7.8f, new Item.Settings().group(OakOres.MAIN_GROUP));

    public static ToolItem PURPI_SPADE = new ShovelItem(PurpiToolMaterial.INSTANCE, 2, -2.4f, new Item.Settings().group(OakOres.MAIN_GROUP));

    //Axes, Hoes, and Pickaxes have to be a custom class because Mojang protected the unmodded classes
    public static ToolItem PURPI_HOE = new CustomHoeItem(PurpiToolMaterial.INSTANCE, 7, -5.2F, new Item.Settings().group(OakOres.MAIN_GROUP));

    public static ToolItem PURPI_AXE = new CustomHoeItem(PurpiToolMaterial.INSTANCE, 13, 3, new Item.Settings().group(OakOres.MAIN_GROUP));

    public static ToolItem PURPI_PICKAXE = new CustomPickaxeItem(PurpiToolMaterial.INSTANCE, 6, -5, new Item.Settings().group(OakOres.MAIN_GROUP));


    public static void registerTools() {

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_sword"), PURPI_SWORD);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_shovel"), PURPI_SPADE);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_hoe"), PURPI_HOE);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_axe"), PURPI_AXE);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_pickaxe"), PURPI_PICKAXE);

    }
}
