package org.oakbricks.oakores.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.oakbricks.oakores.OakOres;

import static org.oakbricks.oakores.OakOres.MOD_ID;

public class ItemClass {

    public static final Item PUPRI = new Item(new FabricItemSettings().group(OakOres.MAIN_GROUP));

    public static void registerItems() {

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi"), PUPRI);

    }


    public static void registerBlockItems() {

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_block"), new BlockItem(BlockClass.PURPI_BLOCK, new FabricItemSettings().group(OakOres.MAIN_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi_ore"), new BlockItem(BlockClass.PURPI_ORE, new FabricItemSettings().group(OakOres.MAIN_GROUP)));

    }


}
