package org.oakbricks.oakores;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oakbricks.oakores.config.ModConfig;
import org.oakbricks.oakores.init.ModBlocks;

import static org.oakbricks.oakores.init.ModBlocks.*;
import static org.oakbricks.oakores.init.ModItems.*;
import static org.oakbricks.oakores.init.ModWorldGen.registerWorldGenFeatures;
import static org.oakbricks.oakores.tools.RegisterTools.*;

public class OakOres implements ModInitializer {

	public static final String MOD_ID = "oakores";
	public static final Logger LOGGER = LogManager.getLogger();
    public static final ModConfig CONFIG = AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new).getConfig();
	public static final Tag<Block> LEAD_POISONING_BLOCKS = TagRegistry.block(new Identifier(MOD_ID, "lead_poisoning_blocks"));
	public static final Tag<Item> LEAD_POISONING_ITEMS = TagRegistry.item(new Identifier(MOD_ID, "lead_poisoning_items"));

	public static final ItemGroup OAKORES_ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "oakores"),
			() -> new ItemStack(ModBlocks.PURPI_BLOCK));

//	public static final ItemGroup OAKORES_ITEM_GROUP = FabricItemGroupBuilder.create(
//			new Identifier(MOD_ID, "items"))
//			.icon(() -> new ItemStack(ModItems.PURPI))
//			.appendItems(stacks -> {
//				//items here
//				stacks.add(new ItemStack(ModItems.LEAD_ROCK));
//				stacks.add(new ItemStack(ModItems.PURPI));
//				stacks.add(new ItemStack(ModItems.PURPI_BOOTS));
//				stacks.add(new ItemStack(ModItems.PURPI_LEGGINGS));
//				stacks.add(new ItemStack(ModItems.PURPI_CHESTPLATE));
//				stacks.add(new ItemStack(ModItems.PURPI_HELMET));
//			})
//			.build();
//
//	public static final ItemGroup OAKORES_BLOCK_GROUP = FabricItemGroupBuilder.create(
//			new Identifier(MOD_ID, "blocks"))
//			.icon(() -> new ItemStack(ModBlocks.PURPI_BLOCK))
//			.appendItems(stacks -> {
//				//blocks here
//				stacks.add(new ItemStack(ModBlocks.LEAD_ORE));
//				stacks.add(new ItemStack(ModBlocks.DEEPSLATE_LEAD_ORE));
//				stacks.add(new ItemStack(ModBlocks.LEAD_BLOCK));
//				stacks.add(new ItemStack(ModBlocks.PURPI_BLOCK));
//				stacks.add(new ItemStack(ModBlocks.PURPI_ORE));
//			})
//			.build();
//
//	public static final ItemGroup OAKORES_TOOL_GROUP = FabricItemGroupBuilder.create(
//			new Identifier(MOD_ID, "tools"))
//			.icon(() -> new ItemStack(RegisterTools.PURPI_PICKAXE))
//			.appendItems(stacks -> {
//				//tools here
//				stacks.add(new ItemStack(RegisterTools.PURPI_AXE));
//				stacks.add(new ItemStack(RegisterTools.PURPI_PICKAXE));
//				stacks.add(new ItemStack(RegisterTools.PURPI_HOE));
//				stacks.add(new ItemStack(RegisterTools.PURPI_SWORD));
//				stacks.add(new ItemStack(RegisterTools.PURPI_SPADE));
//			})
//			.build();
//
//	public static final ItemGroup OAKORES_ARMOR_GROUP = FabricItemGroupBuilder.create(
//			new Identifier(MOD_ID, "armor"))
//			.icon(() -> new ItemStack(PURPI_HELMET))
//			.appendItems(stacks -> {
//				stacks.add(new ItemStack(ModItems.PURPI_BOOTS));
//				stacks.add(new ItemStack(ModItems.PURPI_LEGGINGS));
//				stacks.add(new ItemStack(ModItems.PURPI_CHESTPLATE));
//				stacks.add(new ItemStack(ModItems.PURPI_HELMET));
//			})
//			.build();


	@Override
	public void onInitialize() {
        //FOR CONTRIBUTORS: please make at least 90% of modified classes/voids with names that are easy to understand!
		registerWorldGenFeatures();
		registerItems();
		registerBlocks();
		registerBlockItems();
		registerArmorItems();
        registerTools();


        LOGGER.info("OakOres - Refabricated has Initialized");
	}
}
