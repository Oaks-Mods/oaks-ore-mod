package org.oakbricks.oakores;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.text.LiteralText;
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
import org.oakbricks.oakores.config.ModConfig;
import org.oakbricks.oakores.registry.BlockClass;
import org.oakbricks.oakores.registry.ItemClass;
import org.oakbricks.oakores.tools.RegisterTools;

import static net.minecraft.server.command.CommandManager.literal;
import static org.oakbricks.oakores.registry.BlockClass.registerBlocks;
import static org.oakbricks.oakores.registry.ItemClass.*;
import static org.oakbricks.oakores.registry.ModWorldGen.registerWorldGenFeatures;
import static org.oakbricks.oakores.tools.RegisterTools.registerTools;
//import static org.oakbricks.oakores.util.OreClass.*;

//don't remove these you'll break most of the mod

public class OakOres implements ModInitializer {

	public static final String MOD_ID = "oakores";
	public static final Logger LOGGER = LogManager.getLogger();
    public static final ModConfig CONFIG = AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new).getConfig();

	public static final ItemGroup OAKORES_ITEM_GROUP = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID, "items"))
			.icon(() -> new ItemStack(ItemClass.PURPI))
			.appendItems(stacks -> {
				//items here
				stacks.add(new ItemStack(LEAD_ROCK));
				stacks.add(new ItemStack(ItemClass.PURPI));
				stacks.add(new ItemStack(ItemClass.PURPI_BOOTS));
				stacks.add(new ItemStack(ItemClass.PURPI_LEGGINGS));
				stacks.add(new ItemStack(ItemClass.PURPI_CHESTPLATE));
				stacks.add(new ItemStack(ItemClass.PURPI_HELMET));
			})
			.build();

	public static final ItemGroup OAKORES_BLOCK_GROUP = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID, "blocks"))
			.icon(() -> new ItemStack(BlockClass.PURPI_BLOCK))
			.appendItems(stacks -> {
				//blocks here
				stacks.add(new ItemStack(BlockClass.LEAD_ORE));
				stacks.add(new ItemStack(BlockClass.DEEPSLATE_LEAD_ORE));
				stacks.add(new ItemStack(BlockClass.LEAD_BLOCK));
				stacks.add(new ItemStack(BlockClass.PURPI_BLOCK));
				stacks.add(new ItemStack(BlockClass.PURPI_ORE));
			})
			.build();

	public static final ItemGroup OAKORES_TOOL_GROUP = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID, "tools"))
			.icon(() -> new ItemStack(RegisterTools.PURPI_PICKAXE))
			.appendItems(stacks -> {
				//tools here
				stacks.add(new ItemStack(RegisterTools.PURPI_AXE));
				stacks.add(new ItemStack(RegisterTools.PURPI_PICKAXE));
				stacks.add(new ItemStack(RegisterTools.PURPI_HOE));
				stacks.add(new ItemStack(RegisterTools.PURPI_SWORD));
				stacks.add(new ItemStack(RegisterTools.PURPI_SPADE));
			})
			.build();

	public static final ItemGroup OAKORES_ARMOR_GROUP = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID, "armor"))
			.icon(() -> new ItemStack(PURPI_HELMET))
			.appendItems(stacks -> {
				stacks.add(new ItemStack(ItemClass.PURPI_BOOTS));
				stacks.add(new ItemStack(ItemClass.PURPI_LEGGINGS));
				stacks.add(new ItemStack(ItemClass.PURPI_CHESTPLATE));
				stacks.add(new ItemStack(ItemClass.PURPI_HELMET));
			})
			.build();


	@SuppressWarnings("deprecation")
	@Override
	public void onInitialize() {

		if (CONFIG.enableDebugFeatures) {
			CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
				dispatcher.register(literal("oakores_info_purpi_configs").executes(ctx -> {
                    ctx.getSource().sendFeedback(new LiteralText(CONFIG.maxPurpiGenHeight + "," + CONFIG.purpiMinHeight + "," + CONFIG.purpiOreGenRetries), false);
					return 1;
				}));
			});
		} else {
			CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
				dispatcher.register(literal("oakores_info_purpi_configs").executes(ctx -> {
                    ctx.getSource().sendFeedback(new LiteralText("For Debug Commands Please Enable 'enableDebugFeatures' in the OakOres config"), false);
					return 1;
				}));
			});
		}

		if (CONFIG.enableDebugFeatures) {
			CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
				dispatcher.register(literal("oakores_debug_info_lead_configs").executes(ctx -> {
					//System.out.println(CONFIG.maxLeadGenHeight + "," + CONFIG.minLeadGenHeight + "," + CONFIG.leadOreGenRetries);
					ctx.getSource().sendFeedback(new LiteralText(CONFIG.maxLeadGenHeight + "," + CONFIG.minLeadGenHeight + "," + CONFIG.leadOreGenRetries), false);
					return 1;
				}));
			});
		} else {
			CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
				dispatcher.register(literal("oakores_debug_info_lead_configs").executes(ctx -> {
                    ctx.getSource().sendFeedback(new LiteralText("For Debug Commands Please Enable 'enableDebugFeatures' in the OakOres config"), false);
					return 1;
				}));
			});
		}

		if (CONFIG.enableUnsupportedFeatures) {
			CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
				dispatcher.register(literal("oakores_dont_use_yet_config").executes(context -> {
					if (!dedicated) {
						AutoConfig.getGuiRegistry(ModConfig.class);
					}
					return 1;
				}));
			});
		} else {
			CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
				dispatcher.register(literal("oakores_dont_use_yet_config").executes(ctx -> {
					if (!dedicated) {
						ctx.getSource().sendFeedback(new LiteralText("Please enable Exirimental Features in config"), false);
					}
					return 1;
				}));
			});
		}



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
