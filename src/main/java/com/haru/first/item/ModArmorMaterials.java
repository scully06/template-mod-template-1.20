package com.haru.first.item;

import com.haru.first.TutorialMod;
import com.haru.first.item.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public enum ModArmorMaterials implements ArmorMaterial {
    RUBY(100,1,100, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,Ingredient.ofItems(ModItems.RUBY),"ruby",100f,100f);

    private final int durability;
    private final int protection;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final Ingredient repairIngredient;

    private final String Name;
    private final float Toughness;
    private final float knockbackResistance;

    private static final int[] BASE_DURABILITY = {30,50,40,20};

    ModArmorMaterials(int durability, int protection, int enchantability, SoundEvent equipSound,
                      Ingredient repairIngredient, String Name, float Toughness,
                      float knockbackResistance){
        this.durability = durability;
        this.protection = protection;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.repairIngredient = repairIngredient;
        this.Name = Name;
        this.Toughness = Toughness;
        this.knockbackResistance = knockbackResistance;

    }
    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durability;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.protection;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }

    @Override
    public String getName() {
        return TutorialMod.MOD_ID + ":" + this.Name;
    }

    @Override
    public float getToughness() {
        return this.Toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
