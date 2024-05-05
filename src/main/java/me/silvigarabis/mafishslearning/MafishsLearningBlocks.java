package me.silvigarabis.mafishslearning;

import me.silvigarabis.mafishslearning.block.*;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class MafishsLearningBlocks {
   public static final Block RUBY_BLOCK;
   public static final Block RAW_RUBY_BLOCK;
   public static final Block WHATE_CAT_BLOCK;
   public static final Block GOLD_MELON;
   public static final Block POTATO_TNT;
   public static final Block POTATO_TNT_PREPARE;
   public static final Block GEM_POLISHING_STATION;

   private static Block registerBlock(String name, Block block){
      registerBlockItem(name, block);
      var identifier = MafishsLearningMod.getIdentifier(name);
      return Registry.register(Registries.BLOCK, identifier, block);
   }
   private static Item registerBlockItem(String name, Block block){
      var item = new BlockItem(block, new FabricItemSettings());
      var identifier = MafishsLearningMod.getIdentifier(name);
      return Registry.register(Registries.ITEM, identifier, item);
   }

   private static AbstractBlock.Setting copySettingFrom(Block block){
      return FabricBlockSettings.copyOf(block);
   }

   static {
      var rubyBlockSetting = copySettingFrom(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK);
      var rubyBlock = new Block(rubyBlockSetting);
      RUBY_BLOCK = registerBlock("ruby_block", rubyBlock);

      var rawRubyBlockSetting = copySettingFrom(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK);
      var rawRubyBlock = new Block(rawRubyBlockSetting);
      RAW_RUBY_BLOCK = registerBlock("raw_ruby_block", rawRubyBlock);

      var whiteCatBlockSetting = copySettingFrom(Blocks.IRON_BLOCK).sounds(MafishsLearningSounds.SOUND_BLOCK_SOUNDS);
      var whiteCatBlock = new Block(whiteCatBlockSetting);
      WHATE_CAT_BLOCK = registerBlock("white_cat_block", whiteCatBlock);

      var goldMelonSetting = copySettingFrom(Blocks.GOLD_BLOCK);
      var goldMelon = new Block(goldMelonSetting);
      GOLD_MELON = registerBlock("gold_melon", goldMelon);

      var potatoTntBlockSetting = AbstractBlock.Settings.create()
         .mapColor(MapColor.BROWN)
         .instrument(Instrument.BASS)
         .strength(5.0F, 1.0F)
         .sounds(BlockSoundGroup.STONE);
      var potatoTntBlock = new PotatoTNTBlock(potatoTntBlockSetting);
      POTATO_TNT = registerBlock("potato_tnt", potatoTntBlock);

      var potatoTntPrepareBlockSetting = copySettingFrom(Blocks.ALLIUM)
         .nonOpaque()
         .noCollision();
      var potatoTntPrepareBlock = new PotatoTNTPrepareBlock(StatusEffects.FIRE_RESISTANCE, 10, potatoTntPrepareBlockSetting);
      POTATO_TNT_PREPARE = registerBlock("potato_tnt_prepare", potatoTntPrepare);

      var gemPolishingStationBlockSetting = copySettingFrom(Blocks.IRON_BLOCK).nonOpaque();
      var gemPolishingStationBlock = new GemPolishingStationBlock(gemPolishingStationBlockSetting);
      GEM_POLISHING_STATION = registerBlock("gem_polishing_station", gemPolishingStationBlock);
   }
}
