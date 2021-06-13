package org.oakbricks.oakores;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oakbricks.oakores.config.ModConfig;
import org.oakbricks.oakores.registry.BlockClass;
import org.oakbricks.oakores.registry.ItemClass;

//don't remove these you'll break most of the mod
import static org.oakbricks.oakores.registry.BlockClass.registerBlocks;
import static org.oakbricks.oakores.registry.ItemClass.*;

public class OakOres implements ModInitializer {

	public static final String MOD_ID = "oakores";
	public static final Logger LOGGER = LogManager.getLogger();
    public static final ModConfig CONFIG = AutoConfig.register(ModConfig.class, GsonConfigSerializer::new).getConfig();

    public static final ItemGroup MAIN_GROUP = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID, "main"))
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

    //TODO: figure out what the hell is causing this 1.17-only issue
	//TODO: delete this
	/*public static ConfiguredFeature<?, ?> ORE_PURPI_OVERWORLD = Feature.ORE
			.configure(new OreFeatureConfig(
					OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					BlockClass.PURPI_ORE.getDefaultState(),
					9)) // vein size
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 64)))
			.spreadHorizontally()
			.repeat(12); // number of veins per chunk */


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

        //FOR CONTRIBUTORS: please make atleast 90% of modified classes/voids with names that are easy to understand!
		registerItems();
		registerBlocks();
		registerBlockItems();
		registerArmorItems();
		System.out.println(new TranslatableText("oakbricks.oakores.console.init"));
	}
}
