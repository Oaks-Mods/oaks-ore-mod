package org.oakbricks.oakores.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.oakbricks.oakores.blocks.PurpiOreRealOre;
import org.oakbricks.oakores.config.ModConfig;

import static org.oakbricks.oakores.OakOres.CONFIG;
import static org.oakbricks.oakores.OakOres.MOD_ID;

public class BlockClass {

    public static final Block PURPI_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES).strength(3.5f, 20.5f).requiresTool().sounds(BlockSoundGroup.METAL));

    //public static final Block PURPI_ORE = new PurpiOreRealOre(FabricBlockSettings.copy(Blocks.STONE));

    public static final Block PURPI_ORE = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).strength(2.5f, 10.5f).requiresTool().sounds(BlockSoundGroup.STONE));

    //public static final Block PURPI_ORE = OreBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).requiresTool().breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).strength(3.0f, 3.0f));

    public static void registerBlocks() {

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "purpi_block"), PURPI_BLOCK);
        if (CONFIG.enableUnsupportedFeatures) {
            Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "purpi_ore"), PURPI_ORE);
        }
    }


}
