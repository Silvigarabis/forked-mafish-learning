package me.silvigarabis.mafishslearning;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.registry.FuelRegistry;

import net.jiang.tutorialmod.block.entity.ModBlockEntities;
import net.jiang.tutorialmod.effect.ModStatusEffects;
import net.jiang.tutorialmod.enchantment.ModEnchantments;
import net.jiang.tutorialmod.event.AttackEntityHandler;
import net.jiang.tutorialmod.item.ModItemGroups;
import net.jiang.tutorialmod.item.ModItems;
import net.jiang.tutorialmod.block.ModBlocks;
import net.jiang.tutorialmod.networking.ModMessages;
import net.jiang.tutorialmod.particle.ModParticles;
import net.jiang.tutorialmod.potion.ModPotions;
import net.jiang.tutorialmod.sound.ModSounds;
import net.jiang.tutorialmod.util.ModCustomTrades;
import net.jiang.tutorialmod.util.ModLootTableModifiers;
import net.jiang.tutorialmod.villager.ModVillagers;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MafishsLearningMod implements ModInitializer {
   public static final String MOD_ID = "forked-mafishs-learning";
   public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
   public static Identifier getIdentifier(String name){
      return new Identifier(MOD_ID, name);
   }

   @Override
   public void onInitialize() {
      MafishsLearningItems.registerModItems();
      ModItemGroups.registerItemGroups();
      MafishsLearningBlockEntities.registerBlockEntities();
      MafishsLearningStatusEffects.registerModEffect();
      MafishsLearningPotions.registerPotions();
      MafishsLearningLootTableModifiers.modifyLootTables();
      ModVillagers.registerVillagers();
      ModSounds.registerSounds();
      ModCustomTrades.registerCustomTrades();
      ModEnchantments.registerModEnchantments();
      ModPotions.registerBrewingRecipes();
      AttackEntityCallback.EVENT.register(new AttackEntityHandler());
      ModMessages.registerC2SPackets();
      
      VRPlugin.init();
   }
}


//   private int tickCounter = 0;
//   private final int delayTicks = 10; // 延迟的 tick 数，可以根据需要调整
//   private boolean shouldExecuteDelayedAction = false;

//   private void onClientTick(net.minecraft.client.MinecraftClient minecraftClient) {
//      // 在客户端每次 tick 开始时触发的逻辑
//      tickCounter++;
//      // 检查是否达到了延迟的 tick 数
//      if (tickCounter >= delayTicks) {
//         shouldExecuteDelayedAction = true;
//         tickCounter = 0; // 重置计时器
//      }
//
//      // 在达到延迟后执行操作
//      if (shouldExecuteDelayedAction) {
//         // 在这里执行你的延时操作
//         // 例如，修改渲染效果、创建自定义 HUD 元素等
//         executeDelayedAction();
//         shouldExecuteDelayedAction = false; // 确保操作只执行一次
//      }
//   }
//   private void executeDelayedAction() {
//      // 在这里执行延时操作的逻辑
//      // 例如，修改渲染效果、创建自定义 HUD 元素等
//   }

/*
重置gradle
./gradlew clean
./gradlew --refresh-dependencies

调试
System.out.println(123);

发送信息给玩家
player.sendMessage(Text.literal((String.valueOf(123))),false);

附魔查看
int k = EnchantmentHelper.getLevel(Enchantments, itemStack);
if (k > 0) {
}
方块附魔查看
int k = BlockEnchantmentHelper.getLevel(Enchantments.INFINITY,pos);
if(k>0){
}

给奇怪的方块实体添加onPlace
if (!world.isClient) {
    System.out.println(itemStack.getEnchantments());
    if (!Objects.equals(itemStack.getEnchantments(), new NbtList())) {
        NbtList enchantments = itemStack.getEnchantments(); // 获取物品栈上的附魔信息列表
        BlockEnchantmentHelper.storeEnchantment(pos,enchantments);// 将附魔信息列表存储
    }
}


对某个实体造成伤害
this.damage(getDamageSources().playerAttack(closestPlayer), 10f+level*2);


Mixin Helper
// 创建一个静态Map来存储实体ID和值
private static final Map<Integer, Integer> entityValueMap = new HashMap<>();

// 在适当的时候将实体ID和值添加到Map中
public static void storeEntityValue(int entityID, int value) {
    entityValueMap.put(entityID, value);
}
// 在需要时从Map中检索值
public static int getEntityValue(int entityID) {
    return entityValueMap.getOrDefault(entityID, 0); // 默认值为0，如果未找到实体ID
}



检测双手物品的附魔
Hand hand = this.getActiveHand();
ItemStack itemStack = this.getStackInHand(hand);

PlayerEntity playerEntity = getPlayerOwner();
if (playerEntity != null) {
    Hand hand = playerEntity.getActiveHand();
    if (hand != null) {
        ItemStack itemStack = playerEntity.getStackInHand(hand);
        if (itemStack.getItem() == Items.123) {
            int k = EnchantmentHelper.getLevel(ModEnchantments.123, itemStack);
            if (k > 0) {
            }
        }
    }
}

引雷
LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(this.getWorld());
if (lightningEntity != null) {
    lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(blockPos));
    lightningEntity.setChanneler(user instanceof ServerPlayerEntity ? (ServerPlayerEntity) user : null);
    this.getWorld().spawnEntity(lightningEntity);
    SoundEvent soundEvent = SoundEvents.ITEM_TRIDENT_THUNDER;
    this.playSound(soundEvent, 5, 1.0F);
}

不显示指令
dispatcher.parse("gamerule sendCommandFeedback false", server.getCommandSource());
使用某个指令
if (user instanceof ServerPlayerEntity) {
    MinecraftServer server = user.getServer();
    // 获取服务器命令调度程序
    CommandDispatcher<ServerCommandSource> dispatcher = server.getCommandManager().getDispatcher();
    try {
        // 解析指令并获取命令源
        ParseResults<ServerCommandSource> parseResults
                = dispatcher.parse("tick freeze", server.getCommandSource());
        // 执行指令
        dispatcher.execute(parseResults);

        // 在控制台输出提示信息
    } catch (CommandSyntaxException e) {
        // 指令语法异常处理
        e.printStackTrace();
    }
}

计时器
private void startDelayedOperation(World world) {
    java.util.Timer timer = new Timer(); // 创建一个新的计时器
    timer.schedule(new TimerTask() {
        @Override
        public void run() {

        }
    }, 5000); // 延迟5秒执行，单位为毫秒
}

生成动物
EntityType.COW.spawn(((ServerWorld) user.getWorld()),user.getBlockPos(), SpawnReason.TRIGGERED);

Mixin中强制转换this为原类
PlayerEntity user = (PlayerEntity) (Object) this;

播放声音
getWorld().playSound(closestPlayer,closestPlayer.getBlockPos(),
        SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK, SoundCategory.PLAYERS,1f,1f);

网络传输
PacketByteBuf buf = PacketByteBufs.create();//传输到服务端
buf.writeInt(shieldDashCoolDown);
ClientPlayNetworking.send(ModMessages.Shield_Dash_ID, buf);

*玩家添加速度在客户端，其他生物添加速度在服务端*
*/