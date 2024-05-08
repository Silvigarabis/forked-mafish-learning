package net.mafuyu33.mafishmod.mixin.enchantmentblockmixin.custom.bellknockbackandhurt;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.mafuyu33.mafishmod.enchantmentblock.BlockEnchantmentStorage;
import net.mafuyu33.mafishmod.networking.ModMessages;
import net.mafuyu33.mafishmod.networking.packet.GameOptionsC2SPacket;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BellBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(BellBlockEntity.class)
public abstract class BellBlockEntityMixin extends BlockEntity {
	public BellBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
	}

	@Shadow private List<LivingEntity> hearingEntities;

	@Inject(at = @At("TAIL"), method = "notifyMemoriesOfBell")
	private void init1(CallbackInfo ci) {
		int k = BlockEnchantmentStorage.getLevel(Enchantments.IMPALING,pos);
		int j = BlockEnchantmentStorage.getLevel(Enchantments.KNOCKBACK,pos);

		if (!this.world.isClient && k > 0) {//穿刺
			for (LivingEntity livingEntity : this.hearingEntities) {
				if(!livingEntity.isPlayer()) {
					if (livingEntity.isAlive() && !livingEntity.isRemoved() && pos.isWithinDistance(livingEntity.getPos(), 32.0)) {
						livingEntity.damage(livingEntity.getDamageSources().magic(), k);
					}
				}
			}
		}
		if ( j > 0) {//击退
			for (LivingEntity livingEntity : this.hearingEntities) {
				if(!livingEntity.isPlayer() && !this.world.isClient) {
					if (livingEntity.isAlive() && !livingEntity.isRemoved() && pos.isWithinDistance(livingEntity.getPos(), 32.0)) {
						// 获取 pos 指向 livingEntity 的方向向量
						Vec3d direction = livingEntity.getPos().subtract(pos.getX(), pos.getY(), pos.getZ()).normalize();
						// 施加一个击退效果
						livingEntity.addVelocity(direction.x * j, 0.5, direction.z * j);
					}
				}
			}
		}
	}
}