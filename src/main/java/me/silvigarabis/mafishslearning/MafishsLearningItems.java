package me.silvigarabis.mafishslearning.item;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jiang.tutorialmod.item.custom.*;
import net.jiang.tutorialmod.TutorialMod;
import net.jiang.tutorialmod.item.vrcustom.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class ModItems {
   public static final Item RUBY;
   public static final Item RAW_RUBY;
   public static final Item COOL_GLASS;
   public static final Item COOL_GLASS2;
   public static final Item METAL_DETECTOR;
   public static final Item RUBY_STAFF;
   public static final Item RUBY_PICKAXE;
   public static final Item RUBY_HELMET;
   public static final Item RUBY_CHESTPLATE;
   public static final Item RUBY_LEGGINGS;
   public static final Item RUBY_BOOTS;
   public static final Item TOMATO;
   public static final Item COAL_BRIQUEITE;
   public static final Item TNT_BALL;
   public static final Item STONE_BALL;
   public static final Item APPLE_VISION_PRO;
   public static final Item BREAD_SWORD;
   public static final Item BREAD_SWORD_HOT;
   public static final Item BREAD_SWORD_VERY_HOT;
   public static final Item FU;
   public static final Item IRON_FAKE;
   public static final Item ZHUGE;
   public static final Item POISON_SWORD;
   public static final Item FIREWORK_ARROW;
   public static final Item STARGAZY_PIE;
   public static final Item TIME_STOP;
   public static final Item MATH_SWORD;
   public static final Item COLLIABLE;
   public static final Item LIGHTNING_BALL;
   public static final Item MILK_FLESH;

   public static final Item VR_PEN;
   public static final Item VR_RUBBER;
   public static final Item VR_RULER;
   public static final Item VR_COMPASSES;
   public static final Item VR_MAGIC;

   private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
      //放到材料表里
      entries.add(RUBY);
      entries.add(RAW_RUBY);
   }

   private static Item registerItem(String name, Item item){
      var identifier = MafishsLearningMod.getIdentifier(name);
      return Registry.register(Registries.ITEM, identifier, item);
   }
   protected static void registerItems(){
      ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
   }

   static {
      net.minecraft.item.Item.Settings settings;
      Item item;

      settings = new FabricItemSettings().fireproof();
      item = new Item(settings);
      RUBY = registerItem("ruby", item);

      settings = new FabricItemSettings().fireproof();
      item = new Item(settings);
      RAW_RUBY = registerItem("raw_ruby", item);
/*
      settings = new FabricItemSettings();
      item = new AppleVisionProItem(MafishsLearningArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, settings);
      COOL_GLASS = registerItem("cool_glass", item);
*/
/*
      settings = new FabricItemSettings();
      item = new AppleVisionProItem(MafishsLearningArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, settings);
      COOL_GLASS2 = registerItem("cool_glass2", item);
*/
      settings = new FabricItemSettings().maxDamage(64);
      item = new MetalDetectorItem(settings);
      METAL_DETECTOR = registerItem("metal_detector", item);

      settings = new FabricItemSettings().maxCount(1);
      item = new RubyStuffItem(settings);
      RUBY_STAFF = registerItem("ruby_staff", item);

      settings = new FabricItemSettings();
      item = new PickaxeItem(ModToolMaterial.RUBY, 2,2f, settings);
      RUBY_PICKAXE = registerItem("ruby_pickaxe", item);

      settings = new FabricItemSettings();
      item = new ModArmorItem(ModArmorMaterials.RUBY,ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item RUBY_HELMET =registerItem("ruby_helmet",
            
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item TOMATO = registerItem("tomato",new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
    public static final Item COAL_BRIQUEITE = registerItem("coal_briquette",
            new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));

    public static final Item TNT_BALL = registerItem("tnt_ball", new TNTBallItem(new FabricItemSettings()));
    public static final Item STONE_BALL = registerItem("stone_ball", new StoneBallItem(new FabricItemSettings()));

//    public static final Item APPLE_VISION_PRO = registerItem("apple_vision_pro",
//            new AppleVisionProItem(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET,new FabricItemSettings()));

    public static final Item BREAD_SWORD = registerItem("bread_sword",
            new BreadSwordItem(ToolMaterials.STONE, 3, -2.4f,
                    new FabricItemSettings().food(ModFoodComponents.BREAD_SWORD)));

    public static final Item BREAD_SWORD_HOT = registerItem("bread_sword_hot",
            new BreadSwordHotItem(ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().food(ModFoodComponents.BREAD_SWORD_HOT)));

    public static final Item BREAD_SWORD_VERY_HOT = registerItem("bread_sword_very_hot",
            new BreadSwordVeryHotItem(ToolMaterials.DIAMOND, 3, -2.4f,
                    new FabricItemSettings().food(ModFoodComponents.BREAD_SWORD_VERY_HOT)));

    public static final Item FU = registerItem("fu",
            new FuItem(ToolMaterials.IRON, 6.0F, -3.1F, new FabricItemSettings()));
    public static final Item IRON_FAKE = registerItem("iron_fake",new Item(new FabricItemSettings()));

    public static final Item ZHUGE = registerItem("zhuge",new ZhuGeItem(new FabricItemSettings().maxCount(1).maxDamage(465)));

    public static final Item POISON_SWORD = registerItem("poison_sword",
            new PoisonSwordItem(ToolMaterials.DIAMOND, 3, -2.4f,
                    new FabricItemSettings().food(ModFoodComponents.POISON_SWORD)));

    public static final Item FIREWORK_ARROW = registerItem("firework_arrow",new Item(new FabricItemSettings()));
    public static final Item STARGAZY_PIE = registerItem("stargazy_pie",
            new StargazyPieItem(new FabricItemSettings().food(ModFoodComponents.STARGAZY_PIE)));

    public static final Item TIME_STOP = registerItem("time_stop",
            new TimeStopItem(new FabricItemSettings().maxCount(1)));
    public static final Item MATH_SWORD = registerItem("math_sword",
            new MathSwordItem(ToolMaterials.NETHERITE, 7, -2.4f, new FabricItemSettings()));
    public static final Item COLLIABLE = registerItem("colliable",
            new ColliableItem(new FabricItemSettings().maxCount(1)));
    public static final Item LIGHTNING_BALL = registerItem("lightning_ball", new LightningBallItem(new FabricItemSettings()));
    public static final Item MILK_FLESH = registerItem("milk_flesh",new MilkFleshItem(new FabricItemSettings().food(ModFoodComponents.MILK_FLESH)));

    public static final Item VR_PEN = registerItem("vr_pen", new VrPenItem(new FabricItemSettings().maxCount(1)));
    public static final Item VR_RUBBER = registerItem("vr_rubber", new VrRubberItem(new FabricItemSettings().maxCount(1)));
    public static final Item VR_RULER = registerItem("vr_ruler", new VrRulerItem(new FabricItemSettings().maxCount(1)));
    public static final Item VR_COMPASSES = registerItem("vr_compasses", new VrCompassesItem(new FabricItemSettings().maxCount(1)));
    public static final Item VR_MAGIC = registerItem("vr_magic", new VrMagicItem(new FabricItemSettings().maxCount(1)));
}
