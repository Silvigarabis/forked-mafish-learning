package net.mafuyu33.mafishmod.mixin.enchantmentitemmixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mafuyu33.mafishmod.enchantment.ModEnchantments;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FrostedIceBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mixin(LivingEntity.class)
public abstract class ArmorEnchantmentMixinClient extends Entity implements Attackable {
	@Shadow public abstract Iterable<ItemStack> getArmorItems();

	@Shadow public abstract boolean hurtByWater();

	@Shadow public abstract void onDamaged(DamageSource damageSource);

	@Shadow @Nullable public abstract DamageSource getRecentDamageSource();

	@Shadow public abstract void kill();

	protected ArmorEnchantmentMixinClient(EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}

	@Unique
	private Random getRandom() {
		return this.random;
	}

	@Inject(at = @At("HEAD"), method = "tick")
	private void init1(CallbackInfo info) {
		Iterable<ItemStack> armorItems = this.getArmorItems();


		for (ItemStack armorItem : armorItems) {
			if (getWorld().isClient && armorItem.getItem() instanceof ArmorItem
					&& ((ArmorItem) armorItem.getItem()).getType() == ArmorItem.Type.HELMET) {//帽子
				int o = EnchantmentHelper.getLevel(ModEnchantments.MUTE, armorItem);//静音
				if (o > 0 && this.isPlayer()) {
					mute();
				}
			}
		}
	}

	@Unique
	@Environment(EnvType.CLIENT)
	private void mute(){
		GameOptions gameOptions = MinecraftClient.getInstance().options;
		gameOptions.getSoundVolumeOption(SoundCategory.MASTER).setValue((double) 0);
	}
	@Unique
	private static void freezeWater(ArmorEnchantmentMixinClient entity, World world, BlockPos blockPos, int level) {
		if (entity.isOnGround()) {
			BlockState blockState = Blocks.FROSTED_ICE.getDefaultState();
			int i = Math.min(16, 2 + level);
			BlockPos.Mutable mutable = new BlockPos.Mutable();
			Iterator var7 = BlockPos.iterate(blockPos.add(-i, -1, -i), blockPos.add(i, -1, i)).iterator();

			while(var7.hasNext()) {
				BlockPos blockPos2 = (BlockPos)var7.next();
				if (blockPos2.isWithinDistance(entity.getPos(), (double)i)) {
					mutable.set(blockPos2.getX(), blockPos2.getY() + 1, blockPos2.getZ());
					BlockState blockState2 = world.getBlockState(mutable);
					if (blockState2.isAir()) {
						BlockState blockState3 = world.getBlockState(blockPos2);
						if (blockState3 == FrostedIceBlock.getMeltedState() && blockState.canPlaceAt(world, blockPos2) && world.canPlace(blockState, blockPos2, ShapeContext.absent())) {
							world.setBlockState(blockPos2, blockState);
							world.scheduleBlockTick(blockPos2, Blocks.FROSTED_ICE, MathHelper.nextInt(entity.getRandom(), 60, 120));
						}
					}
				}
			}
		}
	}
	@Unique
	private List<BlockPos> replacedWaterBlocks = new ArrayList<>();

	@Unique
	public void restoreReplacedWaterBlocks(World world) {
		for (BlockPos pos : replacedWaterBlocks) {
			world.setBlockState(pos, Blocks.WATER.getDefaultState(), 3);
		}
		// 清空替换过的水方块列表
		replacedWaterBlocks.clear();
	}

	@Unique
	public void checkAndReplaceWaterBlocks(World world, BlockPos playerPos) {
		int radius = 4; // 3×3范围检索

		for (int yOffset = -3; yOffset <= 30; yOffset++) {
			for (int xOffset = -radius; xOffset <= radius; xOffset++) {
				for (int zOffset = -radius; zOffset <= radius; zOffset++) {
					BlockPos targetPos = playerPos.add(xOffset, yOffset, zOffset);

					if (isWithin3x3(playerPos, targetPos) && world.getBlockState(targetPos).getBlock() == Blocks.WATER) {
						// 如果方块在2x2范围内且是水方块，替换为空气方块
						replacedWaterBlocks.add(targetPos);
						world.setBlockState(targetPos, Blocks.STRUCTURE_VOID.getDefaultState(), 3);
					}

					if (!isWithin3x3(playerPos, targetPos) & replacedWaterBlocks.contains(targetPos)) {
						restoreReplacedWaterBlocks(world);
					}
				}
			}
		}
	}


	@Unique
	private boolean isWithin3x3(BlockPos playerPos, BlockPos targetPos) {
		int deltaX = Math.abs(playerPos.getX() - targetPos.getX());
		int deltaY = Math.abs(playerPos.getY() - targetPos.getY());
		int deltaZ = Math.abs(playerPos.getZ() - targetPos.getZ());

		return deltaX <= 3 && deltaY <= 30 && deltaZ <= 3;
	}
}