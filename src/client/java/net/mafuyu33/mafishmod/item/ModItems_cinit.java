package net.mafuyu33.mafishmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import net.mafuyu33.mafishmod.TutorialMod;
import net.mafuyu33.mafishmod.item.custom.*;
import net.mafuyu33.mafishmod.item.vrcustom.*;
import static net.mafuyu33.mafishmod.item.ModItems.registerItem;

public class ModItems_cinit {
    static {
        ModItems.RUBY = registerItem("ruby",new Item(new FabricItemSettings().fireproof()));
        ModItems.RAW_RUBY=registerItem("raw_ruby",new Item(new FabricItemSettings().fireproof()));
//        ModItems.COOL_GLASS=registerItem("cool_glass",
//            new AppleVisionProItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
//        ModItems.COOL_GLASS2=registerItem("cool_glass2",
//            new AppleVisionProItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
        ModItems.METAL_DETECTOR=registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));

        ModItems.RUBY_STAFF=registerItem("ruby_staff",
            new RubyStuffItem(new FabricItemSettings().maxCount(1)));
        ModItems.RUBY_PICKAXE =registerItem("ruby_pickaxe",
            new PickaxeItem(ModToolMaterial.RUBY,2,2f, new FabricItemSettings()));

        ModItems.RUBY_HELMET =registerItem("ruby_helmet",
            new ModArmorItem(ModArmorMaterials.RUBY,ArmorItem.Type.HELMET, new FabricItemSettings()));
        ModItems.RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
        ModItems.RUBY_LEGGINGS = registerItem("ruby_leggings",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
        ModItems.RUBY_BOOTS = registerItem("ruby_boots",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new FabricItemSettings()));

        ModItems.TOMATO = registerItem("tomato",new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
        ModItems.COAL_BRIQUEITE = registerItem("coal_briquette",
            new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));

        ModItems.TNT_BALL = registerItem("tnt_ball", new TNTBallItem(new FabricItemSettings()));
        ModItems.STONE_BALL = registerItem("stone_ball", new StoneBallItem(new FabricItemSettings()));

//        ModItems.APPLE_VISION_PRO = registerItem("apple_vision_pro",
//            new AppleVisionProItem(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET,new FabricItemSettings()));

        ModItems.BREAD_SWORD = registerItem("bread_sword",
            new BreadSwordItem(ToolMaterials.STONE, 3, -2.4f,
                    new FabricItemSettings().food(ModFoodComponents.BREAD_SWORD)));

        ModItems.BREAD_SWORD_HOT = registerItem("bread_sword_hot",
            new BreadSwordHotItem(ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().food(ModFoodComponents.BREAD_SWORD_HOT)));

        ModItems.BREAD_SWORD_VERY_HOT = registerItem("bread_sword_very_hot",
            new BreadSwordVeryHotItem(ToolMaterials.DIAMOND, 3, -2.4f,
                    new FabricItemSettings().food(ModFoodComponents.BREAD_SWORD_VERY_HOT)));

        ModItems.FU = registerItem("fu",
            new FuItem(ToolMaterials.IRON, 6.0F, -3.1F, new FabricItemSettings()));
        ModItems.IRON_FAKE = registerItem("iron_fake",new Item(new FabricItemSettings()));

        ModItems.ZHUGE = registerItem("zhuge",new ZhuGeItem(new FabricItemSettings().maxCount(1).maxDamage(465)));

        ModItems.POISON_SWORD = registerItem("poison_sword",
            new PoisonSwordItem(ToolMaterials.DIAMOND, 3, -2.4f,
                    new FabricItemSettings().food(ModFoodComponents.POISON_SWORD)));

        ModItems.FIREWORK_ARROW = registerItem("firework_arrow",new Item(new FabricItemSettings()));
        ModItems.STARGAZY_PIE = registerItem("stargazy_pie",
            new StargazyPieItem(new FabricItemSettings().food(ModFoodComponents.STARGAZY_PIE)));

        ModItems.TIME_STOP = registerItem("time_stop",
            new TimeStopItem(new FabricItemSettings().maxCount(1)));
        ModItems.MATH_SWORD = registerItem("math_sword",
            new MathSwordItem(ToolMaterials.NETHERITE, 7, -2.4f, new FabricItemSettings()));
        ModItems.COLLIABLE = registerItem("colliable",
            new ColliableItem(new FabricItemSettings().maxCount(1)));
        ModItems.LIGHTNING_BALL = registerItem("lightning_ball", new LightningBallItem(new FabricItemSettings()));
        ModItems.MILK_FLESH = registerItem("milk_flesh",new MilkFleshItem(new FabricItemSettings().food(ModFoodComponents.MILK_FLESH)));

        ModItems.CHEESE_BERGER = registerItem("cheese_berger",
            new CheeseBergerItem(new FabricItemSettings().food(ModFoodComponents.CHEESE_BERGER)));
        ModItems.VR_PEN = registerItem("vr_pen", new VrPenItem(new FabricItemSettings().maxCount(1)));
        ModItems.VR_RUBBER = registerItem("vr_rubber", new VrRubberItem(new FabricItemSettings().maxCount(1)));
        ModItems.VR_RULER = registerItem("vr_ruler", new VrRulerItem(new FabricItemSettings().maxCount(1)));
        ModItems.VR_COMPASSES = registerItem("vr_compasses", new VrCompassesItem(new FabricItemSettings().maxCount(1)));
        ModItems.VR_MAGIC = registerItem("vr_magic", new VrMagicItem(new FabricItemSettings().maxCount(1)));
        ModItems.RTX4090 = registerItem("rtx4090",new RTX4090Item(ToolMaterials.NETHERITE,2,2f, new FabricItemSettings()));
        ModItems.VR_GETTING_OVER_IT = registerItem("vr_getting_over_it", new VrGettingOverItItem(new FabricItemSettings().maxCount(1)));

        ModItems.cinit();
    }

    public static void registerModItems(){
    }
}
