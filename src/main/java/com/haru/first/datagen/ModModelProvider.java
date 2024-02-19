package com.haru.first.datagen;

import com.haru.first.block.ModBlocks;
import com.haru.first.block.custom.CornCropBrock;
import com.haru.first.block.custom.TomatoCropBlock;
import com.haru.first.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool rubyPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);

        rubyPool.stairs(ModBlocks.RUBY_STAIRS);
        rubyPool.slab(ModBlocks.RUBY_SLAB);
        rubyPool.button(ModBlocks.RUBY_BUTTON);
        rubyPool.pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE);
        rubyPool.fence(ModBlocks.RUBY_FENCE);
        rubyPool.fenceGate(ModBlocks.RUBY_FENCE_GATE);
        rubyPool.wall(ModBlocks.RUBY_WALL);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.DAHLIA,ModBlocks.POTTED_DAHLIA, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoor(ModBlocks.RUBY_DOOR);
        blockStateModelGenerator.registerCrop(ModBlocks.TOMATO_CROPS, TomatoCropBlock.AGE,0,1,2,3,4,5);
        blockStateModelGenerator.registerCrop(ModBlocks.CORN_CROPS, CornCropBrock.AGE,0,1,2,3,4,5,6,7,8);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.RUBY_TRAP_DOOR);
    }
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.COAL_BRIQUETTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BAR_BRAWL_MUSIC_DISC,Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN_SEED, Models.GENERATED);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.RUBY_HELMET);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.RUBY_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.RUBY_LEGGIGNGS);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.RUBY_BOOTS);
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);

            itemModelGenerator.register(ModItems.PORCUPINE_SPAWN_EGG,
                    new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    }
}
