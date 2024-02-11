package com.haru.first.item.custom;

import com.haru.first.item.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if (!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState((positionClicked.down(i)));
                if (isValuableBlock(state)) {
                    outputValuableCoordinate(positionClicked.down(i), player, state.getBlock());
                        break;
                }
                if (!foundBlock){
                    if(player != null){player.sendMessage(Text.literal("No Valuables Found"));
                    }
                }
            }
            context.getStack().damage(1, context.getPlayer(),
                    player1 -> player1.sendToolBreakStatus(player1.getActiveHand()));
        }
        return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinate(BlockPos BlockPos, PlayerEntity player , Block block){
        player.sendMessage(Text.literal("Found" + block.asItem().getName().getString() + " at "
        +"(" + BlockPos.getX() + "," + BlockPos.getY() + "," + BlockPos.getZ() + ")"), false);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCK);
    }
}