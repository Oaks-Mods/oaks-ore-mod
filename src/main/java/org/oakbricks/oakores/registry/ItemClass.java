package org.oakbricks.oakores.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static org.oakbricks.oakores.OakOres.MOD_ID;

public class ItemClass {

    public static final Item PUPRI = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    public static void registerItems() {

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpi"), PUPRI);

    }

}
