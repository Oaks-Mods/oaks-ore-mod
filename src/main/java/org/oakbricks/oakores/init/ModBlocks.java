package org.oakbricks.oakores.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.oakbricks.oakores.OakOres;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static org.oakbricks.oakores.OakOres.CONFIG;
import static org.oakbricks.oakores.OakOres.MOD_ID;

public class ModBlocks {

    public static final Block PURPI_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.PURPLE).breakByTool(FabricToolTags.PICKAXES).strength(6.5f, 10.5f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool().sounds(BlockSoundGroup.METAL));

    public static final Block PURPI_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY).strength(3.5f, 10.25f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool().sounds(BlockSoundGroup.STONE));

    public static final Block ENDERITE_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY).strength(3.5f, 10.25f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool().sounds(BlockSoundGroup.STONE));

    public static final Block LEAD_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY).strength(4.2f, 8.3f).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().sounds(BlockSoundGroup.STONE));

    public static final Block DEEPSLATE_LEAD_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE, MapColor.DEEPSLATE_GRAY).strength(8.2f, 10.5f).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().sounds(BlockSoundGroup.DEEPSLATE), new UniformIntProvider(4, 8));

    public static final Block LEAD_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES).strength(8.5f, 17.5f).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().sounds(BlockSoundGroup.METAL));

    public static final Block ENDERITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(8.5f, 17.5f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool().sounds(BlockSoundGroup.METAL));

    public static void registerBlocks() {

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "purpi_block"), PURPI_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "purpi_ore"), PURPI_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "lead_ore"), LEAD_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "deepslate_lead_ore"), DEEPSLATE_LEAD_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "lead_block"), LEAD_BLOCK);

    }

    public static void registerOptionalBLocks() {
        if ((FabricLoader.getInstance().isModLoaded("enderitemod") || CONFIG.enableEnderite == false) && CONFIG.forceEnableEnderite != true) {
            OakOres.LOGGER.info("OakOres' Enderite module is not loading due to another mod providing enderite being loaded, or user has disabled enderite");
        } else {
            Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "enderite_block"), ENDERITE_BLOCK);
            Registry.register(Registry.ITEM, new Identifier(MOD_ID, "enderite_block"), new BlockItem(ENDERITE_BLOCK, new FabricItemSettings().group(OakOres.OAKORES_ITEM_GROUP)));
        }

    }


}
