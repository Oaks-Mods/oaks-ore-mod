package org.oakbricks.oakores.util;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.oakbricks.oakores.OakOres;
import org.oakbricks.oakores.registry.BlockClass;

import static org.oakbricks.oakores.OakOres.MOD_ID;

public class BlockDevAids {

    public static final void oakOresRegisterBlock(String modid, String path, Block block) {

        Registry.register(Registry.BLOCK, new Identifier(modid, path), block);
//
        //Registry.register(Registry.ITEM, new Identifier(modid, path), new BlockItem(block, new FabricItemSettings().group(OakOres.OAKORES_ITEM_GROUP)));

    }

    public static final void oakOresRegisterBlockitem(String modid, String path, Block block, ItemGroup creativeTabGroup) {

        Registry.register(Registry.ITEM, new Identifier(modid, path), new BlockItem(block, new FabricItemSettings().group(creativeTabGroup)));

    }

    public static final void oakOresRegisterBlockitemSimple(String modid, String path, Block block) {

        Registry.register(Registry.ITEM, new Identifier(modid, path), new BlockItem(block, new FabricItemSettings()));

    }

}
