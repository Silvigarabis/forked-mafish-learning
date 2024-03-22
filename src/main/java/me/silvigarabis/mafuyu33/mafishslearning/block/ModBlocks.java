package me.silvigarabis.mafuyu33.mafishslearning.block;

import static me.silvigarabis.mafuyu33.mafishslearning.MafishsLearningMod.MOD_ID;
import static me.silvigarabis.mafuyu33.mafishslearning.MafishsLearningMod.LOGGER;

import me.silvigarabis.mafuyu33.mafishslearning.block.custom.GemPolishingStationBlock;
import me.silvigarabis.mafuyu33.mafishslearning.block.custom.PotatoTNTBlock;
import me.silvigarabis.mafuyu33.mafishslearning.block.custom.PotatoTNTPrepareBlock;
import me.silvigarabis.mafuyu33.mafishslearning.block.custom.SoundBlock;
import me.silvigarabis.mafuyu33.mafishslearning.sound.ModSounds;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block WHATE_CAT_BLOCK = registerBlock("white_cat_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(ModSounds.SOUND_BLOCK_SOUNDS)));

    public static final Block GOLD_MELON = registerBlock("gold_melon",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));

    public static final Block POTATO_TNT = registerBlock("potato_tnt",
            new PotatoTNTBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN).
                    instrument(Instrument.BASS).strength(5.0F, 1.0F).sounds(BlockSoundGroup.STONE)));

    public static final Block POTATO_TNT_PREPARE = registerBlock("potato_tnt_prepare",
            new PotatoTNTPrepareBlock(StatusEffects.FIRE_RESISTANCE, 10,
                FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));

    public static final Block GEM_POLISHING_STATION = registerBlock("gem_polishing_station",
            new GemPolishingStationBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

    private static Block registerBlock(String name,Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID,name),
                new BlockItem(block,new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        LOGGER.info("Registering Blocks for " + MOD_ID);
    }
}
