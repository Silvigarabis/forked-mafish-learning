package me.silvigarabis.mafuyu33.mafishslearning.particle;

import static me.silvigarabis.mafuyu33.mafishslearning.MafishsLearningMod.MOD_ID;
import static me.silvigarabis.mafuyu33.mafishslearning.MafishsLearningMod.LOGGER;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import me.silvigarabis.mafuyu33.mafishslearning.particle.custom.RubberParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final DefaultParticleType CITRINE_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType RUBBER_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE,
                new Identifier(MOD_ID, "citrine_particle"), CITRINE_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE,
                new Identifier(MOD_ID, "rubber_particle"), RUBBER_PARTICLE);
    }
}
