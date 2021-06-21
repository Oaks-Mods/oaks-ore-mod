package org.oakbricks.oakores.tools;

import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.oakbricks.oakores.OakOres;

import static org.oakbricks.oakores.OakOres.MOD_ID;

public class RegisterTools {

    public static ToolItem PURPI_SWORD = new SwordItem(PurpiToolMaterial.INSTANCE, 1, 4f, new Item.Settings().group(OakOres.OAKORES_ITEM_GROUP));

    public static ToolItem PURPI_SPADE = new ShovelItem(PurpiToolMaterial.INSTANCE, -5f, 2f, new Item.Settings().group(OakOres.OAKORES_ITEM_GROUP));

    //Axes, Hoes, and Pickaxes have to be a custom class because Mojang protected the vanilla classes
    public static ToolItem PURPI_HOE = new CustomHoeItem(PurpiToolMaterial.INSTANCE, -4f, -2F, new Item.Settings().group(OakOres.OAKORES_ITEM_GROUP));

    public static ToolItem PURPI_AXE = new CustomAxeItem(PurpiToolMaterial.INSTANCE, 2f, -1f, new Item.Settings().group(OakOres.OAKORES_ITEM_GROUP));

    public static ToolItem PURPI_PICKAXE = new CustomPickaxeItem(PurpiToolMaterial.INSTANCE, -2, 5f, new Item.Settings().group(OakOres.OAKORES_ITEM_GROUP));


    public static void registerTools() {

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_sword"), PURPI_SWORD);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_shovel"), PURPI_SPADE);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_hoe"), PURPI_HOE);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_axe"), PURPI_AXE);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_pickaxe"), PURPI_PICKAXE);

    }
}
