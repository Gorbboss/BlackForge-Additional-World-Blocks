package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

/** A normal Willow Torch item that becomes the glowing vine-tip model under Willow vines. */
public class ImportedWillowTorchBlock extends Block {
    public ImportedWillowTorchBlock(){super(BlockBehaviour.Properties.copy(Blocks.TORCH).noCollission().lightLevel(s->14));}
    @Override public BlockState getStateForPlacement(BlockPlaceContext c){
        BlockPos p=c.getClickedPos();
        Block branch=ForgeRegistries.BLOCKS.getValue(new ResourceLocation("evenbetternether","willow_branch"));
        if(branch instanceof ImportedWillowBranchBlock&&c.getLevel().getBlockState(p.above()).is(branch))return branch.defaultBlockState().setValue(ImportedWillowBranchBlock.SHAPE,ImportedWillowBranchBlock.Shape.END);
        return defaultBlockState();
    }
}
