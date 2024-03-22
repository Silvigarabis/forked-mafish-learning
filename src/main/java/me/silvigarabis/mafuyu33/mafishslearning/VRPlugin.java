package me.silvigarabis.mafuyu33.mafishslearning;

import net.blf02.vrapi.api.IVRAPI;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.EntrypointContainer;

import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.MinecraftClient;

import java.util.List;

public class VRPlugin {
   private static IVRAPI vrApi = null;
   public static IVRAPI getVRAPI(){
      return vrApi;
   }
   public static boolean init(){
      if (vrApi != null){
         return true;
      }
      List<EntrypointContainer<IVRAPI>> entrypointList = FabricLoader.getInstance()
         .getEntrypointContainers("vrapi", IVRAPI.class);
      if (entrypointList.size() != 0)
         vrApi = entrypointList.get(0).getEntrypoint();
      return vrApi != null;
   }
   public static boolean isClientInVr(){
      if (vrApi != null){
         return false;
      }
      PlayerEntity clientPlayer = MinecraftClient.getInstance().player;
      if (clientPlayer == null){
         return true; // so strange...
      }
      return vrApi.playerInVR(clientPlayer);
   }
   public static Vec3d getControllerPosition(PlayerEntity player, int controllerIndex){
      if (vrApi == null){
         return null;
      }
      if (vrApi.apiActive(player)){
         return vrApi.getVRPlayer(player).getController(controllerIndex).position();
      }
      return null;
   }
   public static Vec3d getMainhandControllerPosition(PlayerEntity player){
      return getControllerPosition(player, 0);
   }
   public static Vec3d getOffhandControllerPosition(PlayerEntity player){
      return getControllerPosition(player, 1);
   }
   public static Vec3d getHMDPosition(PlayerEntity player){
      if (vrApi == null){
         return null;
      }
      if (vrApi.apiActive(player)){
         return vrApi.getVRPlayer(player).getHMD().position();
      }
      return null;
   }
}


/*

检测是不是在VR中
if (world.isClient && VRPluginVerify.hasAPI && VRPlugin.API.playerInVR(user)) {   //有MC-VR-API并且在VR中的时候
    user.sendMessage(Text.literal("在VR里"),false);
}
or
 if (world.isClient && VRPluginVerify.clientInVR() && VRPlugin.API.apiActive(Minecraft.getInstance().player)


获取VR玩家信息
Vec3d currentPosMainController = getControllerPosition(user,0);
Vec3d currentPosOffController = getControllerPosition(user,1);
Vec3d currentPosHMD = getHMDPosition(user);

private static Vec3d getHMDPosition(PlayerEntity player) {
    IVRAPI vrApi = VRPlugin.API; // 这里假设 VRPlugin 是你的 VR 插件类
    if (vrApi != null && vrApi.apiActive(player)) {
        return vrApi.getVRPlayer(player).getHMD().position();
    }
    return null;
}
private static Vec3d getControllerPosition(PlayerEntity player, int controllerIndex) {
    IVRAPI vrApi = VRPlugin.API; // 这里假设 VRPlugin 是你的 VR 插件类
    if (vrApi != null && vrApi.apiActive(player)) {
        return vrApi.getVRPlayer(player).getController(controllerIndex).position();
    }
    return null;
}

*/

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