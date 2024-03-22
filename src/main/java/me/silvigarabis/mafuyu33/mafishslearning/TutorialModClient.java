package me.silvigarabis.mafuyu33.mafishslearning;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import me.silvigarabis.mafuyu33.mafishslearning.block.ModBlocks;
import me.silvigarabis.mafuyu33.mafishslearning.entity.ModEntities;
//import me.silvigarabis.mafuyu33.mafishslearning.util.ModModelPredicateProvider;
import me.silvigarabis.mafuyu33.mafishslearning.event.AttackKeyCheckHandler;
import me.silvigarabis.mafuyu33.mafishslearning.event.ChatMessageHandler;
import me.silvigarabis.mafuyu33.mafishslearning.event.KeyInputHandler;
import me.silvigarabis.mafuyu33.mafishslearning.networking.ModMessages;
import me.silvigarabis.mafuyu33.mafishslearning.particle.ModParticles;
import me.silvigarabis.mafuyu33.mafishslearning.particle.ParticleStorage;
import me.silvigarabis.mafuyu33.mafishslearning.particle.custom.CitrineParticle;
import me.silvigarabis.mafuyu33.mafishslearning.particle.custom.RubberParticle;
import me.silvigarabis.mafuyu33.mafishslearning.screen.GemPolishingScreen;
import me.silvigarabis.mafuyu33.mafishslearning.screen.ModScreenHandlers;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialModClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("tutorialmod");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.TNT_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.STONE_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.FU_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.FIREWORK_ARROW, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.DIAMOND_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.LIGHTNING_PROJECTILE, FlyingItemEntityRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTATO_TNT_PREPARE, RenderLayer.getCutout());

        KeyInputHandler.register();
        ChatMessageHandler.register();
        AttackKeyCheckHandler.registerAttackKeyListener();

        HandledScreens.register(ModScreenHandlers.GEM_POLISHING_SCREEN_HANDLER, GemPolishingScreen::new);
        ModMessages.registerS2CPackets();

        ParticleFactoryRegistry.getInstance().register(ModParticles.CITRINE_PARTICLE, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.RUBBER_PARTICLE, RubberParticle.Factory::new);

//        ModModelPredicateProvider.registerModModels();

        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {//客户端已经成功连接到服务器
                LOGGER.info("加载粒子数据");
                // 调用您的方法
                ParticleStorage.getOrCreateForWorld().spawnAllParticles(MinecraftClient.getInstance().world);
        });
    }
}
