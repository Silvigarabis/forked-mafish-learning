package net.mafuyu33.mafishmod.drawing;

public interface ChunkDrawParticlePainter {
    void addDrawParticle(DrawParticle particle);
    boolean removeDrawParticle(DrawParticle particle);
    List<DrawParticle> getDrawParticles(){
    }
}
