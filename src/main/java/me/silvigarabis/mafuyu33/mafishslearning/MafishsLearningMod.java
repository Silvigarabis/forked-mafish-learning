package me.silvigarabis.mafuyu33.mafishslearning;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.registry.FuelRegistry;

import me.silvigarabis.mafuyu33.mafishslearning.block.entity.ModBlockEntities;
import me.silvigarabis.mafuyu33.mafishslearning.effect.ModStatusEffects;
import me.silvigarabis.mafuyu33.mafishslearning.enchantment.ModEnchantments;
import me.silvigarabis.mafuyu33.mafishslearning.event.AttackEntityHandler;
import me.silvigarabis.mafuyu33.mafishslearning.item.ModItemGroups;
import me.silvigarabis.mafuyu33.mafishslearning.item.ModItems;
import me.silvigarabis.mafuyu33.mafishslearning.block.ModBlocks;
import me.silvigarabis.mafuyu33.mafishslearning.networking.ModMessages;
import me.silvigarabis.mafuyu33.mafishslearning.particle.ModParticles;
import me.silvigarabis.mafuyu33.mafishslearning.potion.ModPotions;
import me.silvigarabis.mafuyu33.mafishslearning.sound.ModSounds;
import me.silvigarabis.mafuyu33.mafishslearning.util.ModCustomTrades;
import me.silvigarabis.mafuyu33.mafishslearning.util.ModLootTableModifiers;
import me.silvigarabis.mafuyu33.mafishslearning.villager.ModVillagers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MafishsLearningMod implements ModInitializer {
   public static final String MOD_ID = "tutorialmod";
   public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

   private static boolean vrSupported = false;
   public static boolean isVrSupported(){
      return vrSupported;
   }

   @Override
   public void onInitialize() {
      ModItems.registerModItems();
      ModItemGroups.registerItemGroups();
      ModBlocks.registerModBlocks();
      ModBlockEntities.registerBlockEntities();
      FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUEITE,200);
      ModStatusEffects.registerModEffect();
      ModPotions.registerPotions();
      ModLootTableModifiers.modifyLootTables();
      ModVillagers.registerVillagers();
      ModSounds.registerSounds();
      ModCustomTrades.registerCustomTrades();
      ModEnchantments.registerModEnchantments();
      ModPotions.registerBrewingRecipes();
      AttackEntityCallback.EVENT.register(new AttackEntityHandler());
      ModMessages.registerC2SPackets();
      ModParticles.registerParticles();
      vrSupported = VRPlugin.init();
   }
}