package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class ImportedTallMushroomColonyBlock extends DoublePlantBlock {
    public ImportedTallMushroomColonyBlock(BlockBehaviour.Properties properties) { super(properties); }
    @Override protected boolean mayPlaceOn(BlockState ground, BlockGetter level, BlockPos pos) {
        return ground.is(ImportedMushroomColonyBlock.GROUND);
    }
    @Override public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return super.canSurvive(state, level, pos) && level.getFluidState(pos).isEmpty()
                && (state.getValue(HALF) == DoubleBlockHalf.UPPER || level.getFluidState(pos.above()).isEmpty());
    }
}
