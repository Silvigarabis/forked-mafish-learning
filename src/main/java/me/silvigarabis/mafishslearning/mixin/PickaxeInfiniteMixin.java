package me.silvigarabis.mafishslearning.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;


@Mixin(PickaxeItem.class)
public abstract class PickaxeInfiniteMixin extends Item {
    public PickaxeInfiniteMixin(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        ItemStack itemStack = context.getStack();
        PlayerEntity playerEntity = context.getPlayer();
        LivingEntity user = ((LivingEntity) context.getPlayer());

        int k = EnchantmentHelper.getLevel(Enchantments.INFINITY, itemStack);
        if (k > 0) {
            world.breakBlock(blockPos,true);
            world.setBlockState(blockPos, (blockState.getBlock()).getDefaultState(), 3);
            EquipmentSlot equipmentSlot = itemStack.equals(playerEntity.getEquippedStack(EquipmentSlot.OFFHAND)) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
            itemStack.damage(1, user, (userx) -> {
                userx.sendEquipmentBreakStatus(equipmentSlot);
            });
        }
        return super.useOnBlock(context);
    }
//    @Shadow @Final private MinecraftClient client;
//
//    @Inject(method = "attackBlock", at = @At(value = "TAIL"))
//    public void init(BlockPos pos, Direction direction, CallbackInfoReturnable<Boolean> cir){
//
//        BlockState blockState = this.client.world.getBlockState(pos);
//        this.client.player.sendMessage(Text.literal((String.valueOf(blockState.calcBlockBreakingDelta(this.client.player, this.client.player.getWorld(), pos)))),false);
//
//        if (blockState.isAir() && blockState.calcBlockBreakingDelta(this.client.player, this.client.player.getWorld(), pos) >= 1.0F) {
//            World world = this.client.player.getWorld();
//            world.setBlockState(pos, (Blocks.ACACIA_LOG).getDefaultState(), 3);
//        }
//
//    }

//    protected BlockBreakMixin(ClientPlayNetworkHandler networkHandler) {
//        this.networkHandler = networkHandler;
//    }

//    @Shadow
//    protected abstract void sendSequencedPacket(ClientWorld world, SequencedPacketCreator packetCreator);
//    @Shadow private GameMode gameMode;
//    @Shadow abstract public boolean breakBlock(BlockPos pos);
//    @Shadow private int blockBreakingCooldown;
//    @Shadow private boolean breakingBlock;
//    @Shadow
//    protected abstract boolean isCurrentlyBreaking(BlockPos pos);
//    @Shadow private final ClientPlayNetworkHandler networkHandler;
//    @Shadow private BlockPos currentBreakingPos = new BlockPos(-1, -1, -1);
//    @Shadow private float currentBreakingProgress;
//    @Shadow private ItemStack selectedStack;
//    @Shadow private float blockBreakingSoundCooldown;
//    @Shadow public abstract int getBlockBreakingProgress();
//
///**
// * @author
// * Mafuyu33
// * @reason
// * rewrite
// */
//@Overwrite
//    public boolean attackBlock(BlockPos pos, Direction direction) {
//        if (this.client.player.isBlockBreakingRestricted(this.client.world, pos, this.gameMode)) {
//            return false;
//        } else if (!this.client.world.getWorldBorder().contains(pos)) {
//            return false;
//        } else {
//            BlockState blockState;
//            if (this.gameMode.isCreative()) {
//                blockState = this.client.world.getBlockState(pos);
//                this.client.getTutorialManager().onBlockBreaking(this.client.world, pos, blockState, 1.0F);
//                this.sendSequencedPacket(this.client.world, (sequence) -> {
//                    this.breakBlock(pos);
//                    return new PlayerActionC2SPacket(PlayerActionC2SPacket.Action.START_DESTROY_BLOCK, pos, direction, sequence);
//                });
//                this.blockBreakingCooldown = 5;
//            } else if (!this.breakingBlock || !this.isCurrentlyBreaking(pos)) {
//                if (this.breakingBlock) {
//                    this.networkHandler.sendPacket(new PlayerActionC2SPacket(PlayerActionC2SPacket.Action.ABORT_DESTROY_BLOCK, this.currentBreakingPos, direction));
//                }
//
//                blockState = this.client.world.getBlockState(pos);
//                this.client.getTutorialManager().onBlockBreaking(this.client.world, pos, blockState, 0.0F);
//                this.sendSequencedPacket(this.client.world, (sequence) -> {
//                    boolean bl = !blockState.isAir();
//                    if (bl && this.currentBreakingProgress == 0.0F) {
//                        blockState.onBlockBreakStart(this.client.world, pos, this.client.player);
//                    }
//
//                    if (bl && blockState.calcBlockBreakingDelta(this.client.player, this.client.player.getWorld(), pos) >= 1.0F) {
//                        this.breakBlock(pos);
//                    } else {
//                        this.breakingBlock = true;
//                        this.currentBreakingPos = pos;
//                        this.selectedStack = this.client.player.getMainHandStack();
//                        this.currentBreakingProgress = 0.0F;
//                        this.blockBreakingSoundCooldown = 0.0F;
//                        this.client.world.setBlockBreakingInfo(this.client.player.getId(), this.currentBreakingPos, this.getBlockBreakingProgress());
//                    }
//
//                    return new PlayerActionC2SPacket(PlayerActionC2SPacket.Action.START_DESTROY_BLOCK, pos, direction, sequence);
//                });
//            }
//
//            return true;
//        }
//    }

//    /**
//     * @author Mafuyu33
//     * @reason Rewrite. Let Infinite tool can generate block.
//     */
//    @Overwrite
//    public boolean breakBlock(BlockPos pos, boolean drop, @Nullable Entity breakingEntity, int maxUpdateDepth) {
//        boolean bl;
//        ItemStack stack = null;
//        int k = 0;
//
//        World world = (World) (Object) this;
//        BlockState blockState = this.getBlockState(pos);
//        if (blockState.isAir()) {
//            return false;
//        } else {
//            FluidState fluidState = this.getFluidState(pos);
//            if (!(blockState.getBlock() instanceof AbstractFireBlock)) {
//                this.syncWorldEvent(2001, pos, Block.getRawIdFromState(blockState));
//            }
//
//            if (drop) {
//                BlockEntity blockEntity = blockState.hasBlockEntity() ? this.getBlockEntity(pos) : null;
//                Block.dropStacks(blockState, world, pos, blockEntity, breakingEntity, ItemStack.EMPTY);
//            }
//            if (breakingEntity instanceof PlayerEntity) {
//                stack = ((PlayerEntity) breakingEntity).getMainHandStack();
//                k = EnchantmentHelper.getLevel(Enchantments.INFINITY, stack);
//            }
//
//
////            if(stack.getItem().canMine(blockState, world, pos, ((PlayerEntity) breakingEntity)) & k>0) {
////                bl = false;
////            }else {
//            bl = this.setBlockState(pos, fluidState.getBlockState(), 3, maxUpdateDepth);
////            }
//
//            if (bl) {
//                this.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(breakingEntity, blockState));
//            }
//
//            if (breakingEntity instanceof PlayerEntity player) {
//                player.sendMessage(Text.literal((String.valueOf(bl))), false);
//                player.sendMessage(Text.literal((String.valueOf(stack))), false);
//                player.sendMessage(Text.literal((String.valueOf(k))), false);
//                System.out.println(bl);
//                System.out.println(stack);
//                System.out.println(k);
//            }
//
//            return bl;
//        }
//    }
}


//    @Inject(at = @At("TAIL"), method = "breakBlock")
//    private void breakBlock(BlockPos pos, boolean drop, Entity breakingEntity, int maxUpdateDepth, CallbackInfoReturnable<Boolean> cir) {
//        BlockState blockState = this.getBlockState(pos);
//        World world = (World)(Object)this;
//        ItemStack stack = ((PlayerEntity) breakingEntity).getMainHandStack();
//        int k = EnchantmentHelper.getLevel(Enchantments.INFINITY, stack);
//        if(stack.getItem().canMine(blockState, world, pos, ((PlayerEntity) breakingEntity)) & k>0) {
//            FluidState fluidState = this.getFluidState(pos);
//            boolean bl = this.setBlockState(pos, fluidState.getBlockState(), 3, maxUpdateDepth);
//        }
//    }


