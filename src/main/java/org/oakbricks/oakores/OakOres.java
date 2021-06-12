package org.oakbricks.oakores;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.oakbricks.oakores.registry.BlockClass;
import org.oakbricks.oakores.registry.ItemClass;

import static org.oakbricks.oakores.registry.ItemClass.registerBlockItems;
import static org.oakbricks.oakores.registry.ItemClass.registerItems;
import static org.oakbricks.oakores.registry.BlockClass.registerBlocks;

public class OakOres implements ModInitializer {

	public static final String MOD_ID = "oakores";


	public static final ItemGroup MAIN_GROUP = FabricItemGroupBuilder.create(
			new Identifier("tutorial", "other"))
			.icon(() -> new ItemStack(BlockClass.PURPI_BLOCK))
			.appendItems(stacks -> {
				stacks.add(new ItemStack(BlockClass.PURPI_BLOCK));
				stacks.add(new ItemStack(BlockClass.PURPI_ORE));
				stacks.add(new ItemStack(ItemClass.PUPRI));
			})
			.build();


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		registerItems();
		registerBlocks();
		registerBlockItems();
		System.out.println("Oak's Ore Mod Initalized!");
	}
}
