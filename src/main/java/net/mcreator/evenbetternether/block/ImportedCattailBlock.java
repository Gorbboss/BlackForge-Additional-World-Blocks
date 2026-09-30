package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.tags.TagKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class ImportedCattailBlock extends DoublePlantBlock implements SimpleWaterloggedBlock {
  private static final TagKey<Block> DRY_GROUND = TagKey.create(Registries.BLOCK, new ResourceLocation("evenbetternether", "cattail_placeable"));
  private static final TagKey<Block> WET_GROUND = TagKey.create(Registries.BLOCK, new ResourceLocation("evenbetternether", "cattail_on_water_placeable"));
  public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

  public ImportedCattailBlock(Properties properties) {
    super(properties);
    this.registerDefaultState(this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, false));
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    BlockState blockBelow = level.getBlockState(pos.below());

    if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
      return (blockBelow.is(DRY_GROUND) && !state.getValue(WATERLOGGED) ||
        blockBelow.is(WET_GROUND) && state.getValue(WATERLOGGED)) &&
        !level.getBlockState(pos.above()).liquid();
    }

    return blockBelow.is(this) && blockBelow.getValue(HALF) == DoubleBlockHalf.LOWER;
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
    stateBuilder.add(HALF, WATERLOGGED);
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    Level level = context.getLevel();
    BlockPos pos = context.getClickedPos();
    FluidState fluidState = level.getFluidState(pos);

    BlockState state = super.getStateForPlacement(context);
    return state == null ? null : state.setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
  }

  @Override
  public BlockState updateShape(BlockState state, Direction direction, BlockState neighbor, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
    if (state.getValue(WATERLOGGED)) level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
    return super.updateShape(state, direction, neighbor, level, pos, neighborPos);
  }

  @NotNull
  @Override
  public FluidState getFluidState(BlockState state) {
    return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
  }
}
