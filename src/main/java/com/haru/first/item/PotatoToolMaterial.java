package com.haru.first.item;

import net.minecraft.block.BlockState;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

public class PotatoToolMaterial implements ToolMaterial{

    public static final PotatoToolMaterial INSTANCE = new PotatoToolMaterial();
        @Override
        public int getDurability(){
            return 1000000;
        }
        @Override
        public float getMiningSpeedMultiplier(){
            return 100.0F;
        }
        @Override
        public float getAttackDamage(){
            return 0.0F;
        }
        @Override
        public int getMiningLevel(){
            return 3;
        }
        @Override
        public int getEnchantability(){
            return 100;
        }
        @Override
        public Ingredient getRepairIngredient(){
            return Ingredient.ofItems(Items.SAND);
        }
        public boolean  canHarvestBlock(BlockState blockIn){
            return true;
        }

}
