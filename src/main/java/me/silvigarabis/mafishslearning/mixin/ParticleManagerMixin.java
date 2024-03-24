package me.silvigarabis.mafishslearning.mixin;

import net.jiang.tutorialmod.mixinhelper.TripwireBlockMixinHelper;
import net.jiang.tutorialmod.particle.ParticleStorage;
import net.jiang.tutorialmod.util.EvictingLinkedHashSetQueue;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleType;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Function;

@Mixin(ParticleManager.class)
public abstract class ParticleManagerMixin {//增加粒子数量上限

//	@ModifyArg(method = "tick", at = @At(value = "INVOKE", target = "Ljava/util/Map;computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;"), index = 1)
//	private EvictingQueue<Particle> injected(EvictingQueue<Particle> originalQueue) {
//		int maxSize = 10; // 设置新的最大大小值
//		return EvictingQueue.create(maxSize);
//	}

	@ModifyArg(method = "tick", at = @At(value = "INVOKE", target = "Ljava/util/Map;computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;"), index = 1)
	private Function<ParticleTextureSheet, Queue<Particle>> madparticleUseEvictingLinkedHashSetQueueInsteadOfEvictingQueue(Function<ParticleTextureSheet, Queue<Particle>> mappingFunction) {
		return t -> new EvictingLinkedHashSetQueue<>(16384, 999999999);
	}


}