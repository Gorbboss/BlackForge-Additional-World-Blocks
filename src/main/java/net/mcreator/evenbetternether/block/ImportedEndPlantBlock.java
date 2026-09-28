package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

/** Shared dependency-free placement behavior for BetterEnd ground vegetation. */
public class ImportedEndPlantBlock extends BushBlock {
    public ImportedEndPlantBlock() { this(0); }
    public ImportedEndPlantBlock(int light) {
        super(BlockBehaviour.Properties.copy(Blocks.CHORUS_FLOWER).noCollission().noOcclusion()
                .offsetType(BlockBehaviour.OffsetType.XZ).lightLevel(state -> light));
    }
    @Override protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.isFaceSturdy(level, pos, net.minecraft.core.Direction.UP);
    }
}
