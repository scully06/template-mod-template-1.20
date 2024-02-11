package com.haru.first.item.util;

import com.haru.first.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> METAL_DETECTOR_DETECTABLE_BLOCK =
                createTag("metal_detector_detectable_blocks");






        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(TutorialMod.MOD_ID,name));
        }
    }
}
