package net.mafuyu33.mafishmod.mixin.itemmixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.mafuyu33.mafishmod.entity.DiamondProjectileEntity;
import net.mafuyu33.mafishmod.event.KeyInputHandler;
import net.mafuyu33.mafishmod.networking.ModMessages;
import net.mafuyu33.mafishmod.networking.packet.ThrowPowerC2SPacket;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ThrowableDiamondMixinClient implements FabricItem{
	@Inject(at = @At("HEAD"), method = "use")
	private void init(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {

		ItemStack itemStack = user.getStackInHand(hand);
		if (itemStack.getItem() == Items.DIAMOND) {
			if(world.isClient) {
				sendC2S();
			}
		}
	}
	@Unique
	@Environment(EnvType.CLIENT)
	private void sendC2S(){
		float throwPower = KeyInputHandler.getThrowPower();//获取当前的投掷力度
		PacketByteBuf buf = PacketByteBufs.create();//传输到服务端
		buf.writeFloat(throwPower);
		ClientPlayNetworking.send(ModMessages.THROW_POWER_ID, buf);
	}
}

