package org.oakbricks.oakores;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oakbricks.oakores.registry.BlockClass;
import org.oakbricks.oakores.registry.ItemClass;
import org.oakbricks.oakores.tools.RegisterTools;

import static net.minecraft.server.command.CommandManager.literal;
import static org.oakbricks.oakores.registry.BlockClass.registerBlocks;
import static org.oakbricks.oakores.registry.ItemClass.*;
import static org.oakbricks.oakores.tools.RegisterTools.registerTools;
//import static org.oakbricks.oakores.util.OreClass.*;

//don't remove these you'll break most of the mod

public class OakOres implements ModInitializer {

	public static final String MOD_ID = "oakores";
	public static final Logger LOGGER = LogManager.getLogger();

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
				stacks.add(new ItemStack(RegisterTools.PURPI_AXE));
				stacks.add(new ItemStack(RegisterTools.PURPI_PICKAXE));
				stacks.add(new ItemStack(RegisterTools.PURPI_HOE));
				stacks.add(new ItemStack(RegisterTools.PURPI_SWORD));
				stacks.add(new ItemStack(RegisterTools.PURPI_SPADE));
				stacks.add(new ItemStack(BlockClass.LEAD_ORE));
			})
			.build();

	private static ConfiguredFeature<?, ?> PURPI_ORE_OVERWORLD = Feature.ORE
			.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockClass.PURPI_ORE.getDefaultState(), 6)) /* TODO: Make this configurable */
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(Integer.parseInt("5")), YOffset.fixed(Integer.parseInt("28")))))) /* TODO: Make this configurable */
			.spreadHorizontally()
			.repeat(Integer.parseInt("10")); //TODO: Make this configurable

	//LEAD ORE WORLD GEN
	private static ConfiguredFeature<?, ?> LEAD_ORE_OVERWORLD = Feature.ORE
			.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockClass.LEAD_ORE.getDefaultState(), 6)) /* TODO: Make this configurable */
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(Integer.parseInt("0")), YOffset.fixed(Integer.parseInt("48")))))) /* TODO: Make this configurable */
			.spreadHorizontally()
			.repeat(Integer.parseInt("25")); //TODO: Make this configurable


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//Registers Purpi Ore world gen
		RegistryKey<ConfiguredFeature<?, ?>> purpiOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MOD_ID, "purpi_ore_overworld"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, purpiOreOverworld.getValue(), PURPI_ORE_OVERWORLD);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, purpiOreOverworld);

		RegistryKey<ConfiguredFeature<?, ?>> leadOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MOD_ID, "lead_ore_overworld"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, leadOreOverworld.getValue(), LEAD_ORE_OVERWORLD);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, leadOreOverworld);

        //FOR CONTRIBUTORS: please make at least 90% of modified classes/voids with names that are easy to understand!
		registerItems();
		registerBlocks();
		registerBlockItems();
		registerArmorItems();
        registerTools();
		System.out.println("idk what to put here - OakOres");
	};
}
