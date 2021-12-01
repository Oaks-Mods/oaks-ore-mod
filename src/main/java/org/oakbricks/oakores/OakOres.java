package org.oakbricks.oakores;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oakbricks.oakores.init.ModBlocks;

import static org.oakbricks.oakores.init.ModBlocks.*;
import static org.oakbricks.oakores.init.ModItems.*;
import static org.oakbricks.oakores.init.ModConfiguredFeatures.registerConfiguredFeatures;
import static org.oakbricks.oakores.init.ModPlacedFeatures.registerPlacedFeatures;
import static org.oakbricks.oakores.tools.RegisterTools.*;

public class OakOres implements ModInitializer {

	public static final String MOD_ID = "oakores";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final Tag<Block> LEAD_POISONING_BLOCKS = TagFactory.BLOCK.create(new Identifier("c", "lead_poisoning_blocks"));
	public static final Tag<Item> LEAD_POISONING_ITEMS = TagFactory.ITEM.create(new Identifier("c", "lead_poisoning_items"));

	public static final ItemGroup OAKORES_ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "oakores"),
			() -> new ItemStack(ModBlocks.PURPI_BLOCK));

	@Override
	public void onInitialize() {
        //FOR CONTRIBUTORS: please make at least 90% of modified classes/voids with names that are easy to understand!
		registerConfiguredFeatures();
		registerPlacedFeatures();
		registerItems();
		registerBlocks();
		registerBlockItems();
		registerArmorItems();
        registerTools();
        LOGGER.info("Oak's Ore Mode has Initialized");
	}
}
