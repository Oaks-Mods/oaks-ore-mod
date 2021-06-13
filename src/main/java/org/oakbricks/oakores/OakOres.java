package org.oakbricks.oakores;

import me.lortseam.completeconfig.gui.ConfigScreenBuilder;
import me.lortseam.completeconfig.gui.cloth.ClothConfigScreenBuilder;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oakbricks.oakores.config.ModConfig;
import org.oakbricks.oakores.registry.BlockClass;
import org.oakbricks.oakores.registry.ItemClass;

import static org.oakbricks.oakores.registry.BlockClass.registerBlocks;
import static org.oakbricks.oakores.registry.ItemClass.*;

public class OakOres implements ModInitializer {

	public static final String MOD_ID = "oakores";
	public static final Logger LOGGER = LogManager.getLogger();
    public static final ModConfig CONFIG = AutoConfig.register(ModConfig.class, GsonConfigSerializer::new).getConfig();

    public static final ItemGroup MAIN_GROUP = FabricItemGroupBuilder.create(
			new Identifier("tutorial", "other"))
			.icon(() -> new ItemStack(BlockClass.PURPI_BLOCK))
			.appendItems(stacks -> {
				stacks.add(new ItemStack(BlockClass.PURPI_BLOCK));
				stacks.add(new ItemStack(BlockClass.PURPI_ORE));
				stacks.add(new ItemStack(ItemClass.PURPI));
				stacks.add(new ItemStack(ItemClass.PURPI_BOOTS));
				stacks.add(new ItemStack(ItemClass.PURPI_LEGGINGS));
				stacks.add(new ItemStack(ItemClass.PURPI_CHESTPLATE));
				stacks.add(new ItemStack(ItemClass.PURPI_HELMET));
			})
			.build();

//	AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		registerItems();
		registerBlocks();
		registerBlockItems();
		registerArmorItems();
		System.out.println("Oak's Ore Mod has been Initialized!");
	}
}
