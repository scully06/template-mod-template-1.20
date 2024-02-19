package com.haru.first.datagen;

import com.haru.first.block.ModBlocks;
import com.haru.first.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY, ModBlocks.RUBY_ORE);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }


    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC,ModItems.RUBY,
                0.7f, 200,"ruby");
        offerBlasting(exporter,RUBY_SMELTABLES,RecipeCategory.MISC,ModItems.RUBY,
                0.7f, 100,"ruby");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,ModItems.RUBY,RecipeCategory.DECORATIONS,
                ModBlocks.RUBY_BLOCK);

        createStairsRecipe(ModBlocks.RUBY_STAIRS, Ingredient.ofItems(ModItems.RUBY));
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.RUBY_SLAB, Ingredient.ofItems(ModItems.RUBY));
        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.RUBY_PRESSURE_PLATE, Ingredient.ofItems(ModItems.RUBY));
        createFenceRecipe(ModBlocks.RUBY_STAIRS, Ingredient.ofItems(ModItems.RUBY));
        createFenceGateRecipe(ModBlocks.RUBY_STAIRS, Ingredient.ofItems(ModItems.RUBY));
        createDoorRecipe(ModBlocks.RUBY_STAIRS, Ingredient.ofItems(ModItems.RUBY));
        createTrapdoorRecipe(ModBlocks.RUBY_STAIRS, Ingredient.ofItems(ModItems.RUBY));



    }
}
