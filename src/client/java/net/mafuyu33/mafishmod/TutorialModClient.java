package net.mafuyu33.mafishmod;

import net.fabricmc.api.ClientModInitializer;

import net.mafuyu33.mafishmod.mixinhelper.BellBlockDelayMixinHelper;
import net.mafuyu33.mafishmod.particle.StateSaverAndLoader;

import net.mafuyu33.mafishmod.particle.custom.*;
import net.mafuyu33.mafishmod.render.ALeaf;
import net.mafuyu33.mafishmod.screen.GemPolishingScreen;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

import net.mafuyu33.mafishmod.event.*;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.mafuyu33.mafishmod.particle.ParticleStorageClient;

import net.mafuyu33.mafishmod.particle.ModParticles;
import net.mafuyu33.mafishmod.entity.ModEntities;
import net.mafuyu33.mafishmod.screen.ModScreenHandlers;
import net.mafuyu33.mafishmod.networking.ModClientMessages;
import net.mafuyu33.mafishmod.item.ModItems;
import net.mafuyu33.mafishmod.block.ModBlocks;
import net.mafuyu33.mafishmod.util.ModLootTableModifiers;

import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModClientMessages.registerS2CPackets();

        ModLootTableModifiers.modifyLootTables();
            // require ModItems;

        ParticleStorageClient.init();

        addClientRegistries();
        registerClientEvents();
    }

    private static void addClientRegistries(){
        EntityRendererRegistry.register(ModEntities.TNT_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.STONE_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.FU_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.FIREWORK_ARROW, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.DIAMOND_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.LIGHTNING_PROJECTILE, FlyingItemEntityRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.CITRINE_PARTICLE, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.RUBBER_PARTICLE, RubberParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.KNOCK_BACK_PARTICLE, KnockBackParticle.Factory::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTATO_TNT_PREPARE, RenderLayer.getCutout());

        HandledScreens.register(ModScreenHandlers.GEM_POLISHING_SCREEN_HANDLER, GemPolishingScreen::new);
    }
    private static void registerClientEvents(){
        KeyInputHandler.register();
        ChatMessageHandler.register();
        AttackKeyCheckHandler.registerAttackKeyListener();
        HudRenderCallback.EVENT.register(new ALeaf());
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {//客户端已经成功连接到服务器
            // 调用您的方法
            StateSaverAndLoader.getServerState(client.getServer()).spawnAllParticles(client.world,client.getServer());
        });
        ClientPlayConnectionEvents.DISCONNECT.register((handler,client) -> {//客户端已经成功连接到服务器
            // 清空hashmap
            BellBlockDelayMixinHelper.BellBlockEntityMap.clear();
            BellBlockDelayMixinHelper.HitCoolDownMap.clear();
            BellBlockDelayMixinHelper.DirectionMap.clear();
        });
    }
}
