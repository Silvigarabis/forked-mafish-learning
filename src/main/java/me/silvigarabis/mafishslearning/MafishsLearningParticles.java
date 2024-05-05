package me.silvigarabis.mafishslearning;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import me.silvigarabis.mafishslearning.particle.RubberParticle;

import net.minecraft.particle.ParticleType;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class MafishsLearningParticles {
   public static final ParticleType CITRINE_PARTICLE = FabricParticleTypes.simple();
   public static final ParticleType RUBBER_PARTICLE = FabricParticleTypes.simple();
   public static final ParticleType KNOCK_BACK_PARTICLE = FabricParticleTypes.simple();

   private static void register(String name, ParticleType<?> particleType){
      var identifier = MafishsLearningMod.getIdentifier(name);
      Registry.register(Registries.PARTICLE_TYPE, identifier, particleType);
   }

   static {
      register("citrine_particle", CITRINE_PARTICLE);
      register("rubber_particle", RUBBER_PARTICLE);
      register("knock_back_particle", KNOCK_BACK_PARTICLE);
   }
}
