package net.mafuyu33.mafishmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

import net.mafuyu33.mafishmod.item.ModItemGroups;
import net.mafuyu33.mafishmod.item.ModItems;
import net.mafuyu33.mafishmod.block.ModBlocks;
import net.mafuyu33.mafishmod.block.entity.ModBlockEntities;
import net.mafuyu33.mafishmod.networking.ModMessages;
import net.mafuyu33.mafishmod.effect.ModStatusEffects;
import net.mafuyu33.mafishmod.potion.ModPotions;
import net.mafuyu33.mafishmod.particle.ModParticles;
import net.mafuyu33.mafishmod.villager.ModVillagers;
import net.mafuyu33.mafishmod.sound.ModSounds;
import net.mafuyu33.mafishmod.enchantment.ModEnchantments;
import net.mafuyu33.mafishmod.util.ModCustomTrades;
import net.mafuyu33.mafishmod.util.ModLootTableModifiers;

import net.fabricmc.fabric.api.registry.FuelRegistry;

import net.mafuyu33.mafishmod.event.*;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
    public static final String MOD_ID = "mafishmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModSounds.registerSounds();
        ModMessages.registerC2SPackets();
        //获取服务器实例
        ServerLifecycleEvents.SERVER_STARTING.register(ServerManager::setServerInstance);

        //添加东西
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();

        ModBlocks.registerModBlocks();
        ModBlockEntities.registerBlockEntities();

        ModParticles.registerParticles();
        ModStatusEffects.registerModEffects();
        ModPotions.registerPotions();
        ModPotions.registerBrewingRecipes();

        ModEnchantments.registerModEnchantments();

        ModCustomTrades.registerCustomTrades();
            // partially require ModBlocks (ModBlocks.GOLD_MELON)

        ModVillagers.registerVillagers();
            // partially require ModBlocks (ModBlocks.WHATE_CAT_BLOCK)

        addRegistries();

        //VR
        VRPlugin.init();

    }
    private void addRegistries(){
        FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUEITE,200);
    }
    private void addEvents(){
        AttackEntityCallback.EVENT.register(new AttackEntityHandler());
        PlayerBlockBreakEvents.BEFORE.register(new BeforeBlockBreakHandler());
        PlayerBlockBreakEvents.AFTER.register(new AfterBlockBreakHandler());
        ExplosionHandler.init();
        ServerChatMessageHandler.register();
    }
}