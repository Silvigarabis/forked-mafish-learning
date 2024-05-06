package net.mafuyu33.mafishmod.item;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.mafuyu33.mafishmod.TutorialMod;
import net.mafuyu33.mafishmod.item.custom.*;
import net.mafuyu33.mafishmod.item.vrcustom.*;

public class ModItems {
    public static Item RUBY;
    public static Item RAW_RUBY;
    // currently not initially
    public static Item COOL_GLASS;
    // currently not initially
    public static Item COOL_GLASS2;
    public static Item METAL_DETECTOR;

    public static Item RUBY_STAFF;
    public static Item RUBY_PICKAXE;

    public static Item RUBY_HELMET;
    public static Item RUBY_CHESTPLATE;
    public static Item RUBY_LEGGINGS;
    public static Item RUBY_BOOTS;

    public static Item TOMATO;
    public static Item COAL_BRIQUEITE;

    public static Item TNT_BALL;
    public static Item STONE_BALL;

    // currently not initially
    public static Item APPLE_VISION_PRO;

    public static Item BREAD_SWORD;

    public static Item BREAD_SWORD_HOT;

    public static Item BREAD_SWORD_VERY_HOT;

    public static Item FU;
    public static Item IRON_FAKE;

    public static Item ZHUGE;

    public static Item POISON_SWORD;

    public static Item FIREWORK_ARROW;
    public static Item STARGAZY_PIE;

    public static Item TIME_STOP;
    public static Item MATH_SWORD;
    public static Item COLLIABLE;
    public static Item LIGHTNING_BALL;
    public static Item MILK_FLESH;

    public static Item CHEESE_BERGER;
    public static Item VR_PEN;
    public static Item VR_RUBBER;
    public static Item VR_RULER;
    public static Item VR_COMPASSES;
    public static Item VR_MAGIC;
    public static Item RTX4090;
    public static Item VR_GETTING_OVER_IT;

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        //放到材料表里
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }

    protected static void cinit(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }

    protected static Item registerItem(String name,Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        TutorialMod.LOGGER.info("注册MOD物品 {}", TutorialMod.MOD_ID);
    }
}
