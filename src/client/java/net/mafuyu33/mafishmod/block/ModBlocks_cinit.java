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
import net.mafuyu33.mafishmod.block.ModBlocks;
import static net.mafuyu33.mafishmod.block.ModBlocks.registerBlock;

public class ModBlocks_cinit {
    //这里添加新的block
    static {
        ModBlocks.POTATO_TNT = registerBlock("potato_tnt",
            new PotatoTNTBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN).
                    instrument(Instrument.BASS).strength(5.0F, 1.0F).sounds(BlockSoundGroup.STONE)));
    }

    public static void registerModBlocks(){
    }
}
