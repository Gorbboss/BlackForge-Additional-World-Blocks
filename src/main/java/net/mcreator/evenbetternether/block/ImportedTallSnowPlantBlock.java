package net.mcreator.evenbetternether.block;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
/** Both snow-plant halves use the same dirt substrate rule as the short forms. */
public class ImportedTallSnowPlantBlock extends DoublePlantBlock {
    public ImportedTallSnowPlantBlock(BlockBehaviour.Properties properties) { super(properties); }
    @Override protected boolean mayPlaceOn(BlockState ground, BlockGetter level, BlockPos pos) { return ground.is(BlockTags.DIRT); }
    @Override public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) { return super.canSurvive(state, level, pos) && level.getFluidState(pos).isEmpty(); }
}
