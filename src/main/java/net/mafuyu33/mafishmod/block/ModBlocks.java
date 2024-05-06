package net.mafuyu33.mafishmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.mafuyu33.mafishmod.TutorialMod;
import net.mafuyu33.mafishmod.sound.ModSounds;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    //这里记录了已经添加的方块
    public static Block RUBY_BLOCK;
    public static Block RAW_RUBY_BLOCK;
    public static Block WHATE_CAT_BLOCK;
    public static Block GOLD_MELON;
    public static Block POTATO_TNT;
    public static Block POTATO_TNT_PREPARE;
    public static Block GEM_POLISHING_STATION;

    protected static Block registerBlock(String name,Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name),
                new BlockItem(block,new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("注册一个方块"+ TutorialMod.MOD_ID);
    }
}
