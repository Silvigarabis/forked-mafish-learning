package net.jiang.tutorialmod.enchantment;

import net.jiang.tutorialmod.TutorialMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {

    public static Enchantment BAD_LUCK_OF_SEA = register("bad_luck_of_sea",
            new BadLuckOfSeaEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.ARMOR_FEET, EquipmentSlot.FEET));

    public static Enchantment EIGHT_GODS_PASS_SEA = register("eight_gods_pass_sea",
            new EightGodsPassSeaEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.ARMOR_FEET, EquipmentSlot.FEET));

    public static Enchantment KILL_CHICKEN_GET_EGG = register("kill_chicken_get_egg",
            new KillChickenGetEggEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));
    public static Enchantment GO_TO_SKY = register("go_to_sky",
            new GoToSkyEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static Enchantment GONG_XI_FA_CAI = register("gong_xi_fa_cai",
            new GongXiFaCaiEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static Enchantment MERCY = register("mercy",
            new MercyEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static Enchantment KILL_MY_HORSE = register("kill_my_horse",
            new MercyEnchantment(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.VANISHABLE));
    public static Enchantment KILL_MY_HORSE_PLUS = register("kill_my_horse_plus",
            new NormalEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.ARMOR, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static Enchantment HOT_POTATO = register("hot_potato",
            new NormalCursedEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static Enchantment VERY_EASY = register("very_easy",
            new VeryEasyEnchantment(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static Enchantment REVERSE = register("reverse",
            new NormalCursedEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static Enchantment PAY_TO_PLAY = register("pay_to_play",
            new LEVEL5Enchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static Enchantment FEAR = register("fear",
            new LEVEL5Enchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));







    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(TutorialMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments(){
        System.out.println("注册附魔");
    }
}
