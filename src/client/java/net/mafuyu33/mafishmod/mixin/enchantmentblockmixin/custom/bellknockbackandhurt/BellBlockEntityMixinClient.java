package net.mafuyu33.mafishmod.mixin.enchantmentblockmixin.custom.bellknockbackandhurt;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.mafuyu33.mafishmod.enchantmentblock.BlockEnchantmentStorage;
import net.mafuyu33.mafishmod.networking.ModMessages;
import net.mafuyu33.mafishmod.networking.packet.GameOptionsC2SPacket;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BellBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
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
public abstract class BellBlockEntityMixinClient extends BlockEntity {
	public BellBlockEntityMixinClient(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
	}

	@Shadow private List<LivingEntity> hearingEntities;

	@Inject(at = @At("TAIL"), method = "notifyMemoriesOfBell")
	private void init1(CallbackInfo ci) {
		int k = BlockEnchantmentStorage.getLevel(Enchantments.IMPALING,pos);
		int j = BlockEnchantmentStorage.getLevel(Enchantments.KNOCKBACK,pos);
		if(world!=null && this.world.isClient) {
			sendC2S();
		}
		if ( j > 0) {//击退
			for (LivingEntity livingEntity : this.hearingEntities) {
				if(!livingEntity.isPlayer() && !this.world.isClient) {
				}else if(GameOptionsC2SPacket.master > 0.0f && GameOptionsC2SPacket.blocks > 0.0f && livingEntity.isAlive()
						&& !livingEntity.isRemoved() && pos.isWithinDistance(livingEntity.getPos(), 32.0)){
					// 获取 pos 指向 livingEntity 的方向向量
					Vec3d direction = livingEntity.getPos().subtract(pos.getX(), pos.getY(), pos.getZ()).normalize();
					// 施加一个击退效果
					livingEntity.addVelocity(direction.x * j, 0.5, direction.z * j);
				}
			}
		}
	}

	@Unique
	@Environment(EnvType.CLIENT)
	private void sendC2S(){
		GameOptions gameOptions =MinecraftClient.getInstance().options;
		float blocks = gameOptions.getSoundVolume(SoundCategory.BLOCKS);
		float master = gameOptions.getSoundVolume(SoundCategory.MASTER);
		PacketByteBuf buf = PacketByteBufs.create();//传输到服务端

		buf.writeFloat(blocks);
		buf.writeFloat(master);
		ClientPlayNetworking.send(ModMessages.GAME_OPTIONS_ID, buf);
	}
}