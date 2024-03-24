package me.silvigarabis.mafishslearning.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FireworkArrowEntity extends PersistentProjectileEntity {
    int duration=200;

    protected FireworkArrowEntity(EntityType<? extends PersistentProjectileEntity> type, World world, ItemStack stack) {
        super(type, world, stack);
    }

    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.GLOWING, this.duration, 0);
        target.addStatusEffect(statusEffectInstance, this.getEffectCause());
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        entity.addVelocity(0, 5, 0);
        for(int i=1;i<20;i++) {
            if (i > 16) {
                explode();
            }
        }
    }

    @Override
    protected ItemStack asItemStack() {
        return null;
    }

    private void explode() {
        float f = 4.0F;
        this.getWorld().createExplosion(this, this.getX(), this.getBodyY(0.0625), this.getZ(), f, World.ExplosionSourceType.TNT);
    }

    @Override
    public boolean cannotBeSilenced() {
        return super.cannotBeSilenced();
    }
}