package net.mafuyu33.mafishmod.block;

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

import net.mafuyu33.mafishmod.TutorialMod;
import net.mafuyu33.mafishmod.block.custom.*;
import net.mafuyu33.mafishmod.sound.ModSounds;

public class ModBlocks {
    //这里记录了已经添加的方块
    public static final Block RUBY_BLOCK;
    public static final Block RAW_RUBY_BLOCK;
    public static final Block WHATE_CAT_BLOCK;
    public static final Block GOLD_MELON;
    public static Block POTATO_TNT;
    public static final Block POTATO_TNT_PREPARE;
    public static final Block GEM_POLISHING_STATION;

    static {
        ModBlocks.RUBY_BLOCK=registerBlock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

        ModBlocks.RAW_RUBY_BLOCK=registerBlock("raw_ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));


        ModBlocks.WHATE_CAT_BLOCK=registerBlock("white_cat_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(ModSounds.SOUND_BLOCK_SOUNDS)));

        ModBlocks.GOLD_MELON=registerBlock("gold_melon",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));

        ModBlocks.POTATO_TNT_PREPARE = registerBlock("potato_tnt_prepare",
            new PotatoTNTPrepareBlock(StatusEffects.FIRE_RESISTANCE, 10,
                FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));

        ModBlocks.GEM_POLISHING_STATION=registerBlock("gem_polishing_station",
            new GemPolishingStationBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));
    }

    protected static Block registerBlock(String name,Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name),
                new BlockItem(block,new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        //TutorialMod.LOGGER.info("注册一个方块"+ TutorialMod.MOD_ID);
    }
}
