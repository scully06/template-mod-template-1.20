package com.haru.first.datagen;

import com.haru.first.block.ModBlocks;
import com.haru.first.item.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture){
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg){
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCK)
                .add(ModBlocks.RUBY_BLOCK)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.COAL_ORES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.RUBY_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RUBY_BLOCK);

        getOrCreateTagBuilder(BlockTags.STAIRS).add(ModBlocks.RUBY_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(ModBlocks.RUBY_SLAB);
        getOrCreateTagBuilder(BlockTags.BUTTONS).add(ModBlocks.RUBY_BUTTON);
        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES).add(ModBlocks.RUBY_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.RUBY_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.RUBY_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.RUBY_WALL);
        getOrCreateTagBuilder(BlockTags.DOORS).add(ModBlocks.RUBY_DOOR);
        getOrCreateTagBuilder(BlockTags.TRAPDOORS).add(ModBlocks.RUBY_TRAP_DOOR);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric"
        ,"need_tool_level_4"))).add(ModBlocks.RUBY_ORE);
    }
}
