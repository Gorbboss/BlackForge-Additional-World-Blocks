package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

/** Self-shaping, downward-growing vine used by BetterEnd's Twisted Vine. */
public class ImportedHangingVineBlock extends Block implements BonemealableBlock {
    public enum Shape implements StringRepresentable { TOP, MIDDLE, BOTTOM; public String getSerializedName(){ return name().toLowerCase(); } }
    public static final EnumProperty<Shape> SHAPE = EnumProperty.create("shape", Shape.class);
    public ImportedHangingVineBlock(int light) {
        super(BlockBehaviour.Properties.copy(Blocks.WEEPING_VINES).randomTicks().noCollission().noOcclusion().lightLevel(s -> light));
        registerDefaultState(stateDefinition.any().setValue(SHAPE, Shape.BOTTOM));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) { b.add(SHAPE); }
    @Override public BlockState getStateForPlacement(BlockPlaceContext c) { return shaped(c.getLevel(), c.getClickedPos()); }
    private BlockState shaped(LevelReader level, BlockPos pos) {
        boolean above = level.getBlockState(pos.above()).is(this), below = level.getBlockState(pos.below()).is(this);
        return defaultBlockState().setValue(SHAPE, above ? (below ? Shape.MIDDLE : Shape.BOTTOM) : Shape.TOP);
    }
    @Override public boolean canSurvive(BlockState s, LevelReader level, BlockPos pos) { BlockState a=level.getBlockState(pos.above()); return a.is(this) || a.isFaceSturdy(level,pos.above(),Direction.DOWN); }
    @Override public BlockState updateShape(BlockState s, Direction d, BlockState n, LevelAccessor level, BlockPos p, BlockPos q) {
        if (!canSurvive(s, level, p)) level.scheduleTick(p, this, 1);
        return shaped(level, p);
    }
    @Override public void tick(BlockState s, ServerLevel level, BlockPos p, RandomSource r) { if (!canSurvive(s,level,p)) level.destroyBlock(p,true); }
    @Override public void randomTick(BlockState s, ServerLevel level, BlockPos p, RandomSource r) { if (s.getValue(SHAPE)==Shape.BOTTOM && r.nextInt(7)==0) grow(level,p); }
    private void grow(ServerLevel level, BlockPos p) { if (level.isEmptyBlock(p.below())) { level.setBlock(p.below(), defaultBlockState(), UPDATE_ALL); level.setBlock(p, shaped(level,p), UPDATE_ALL); } }
    @Override public boolean isValidBonemealTarget(LevelReader l,BlockPos p,BlockState s,boolean c){ return l.isEmptyBlock(findBottom(l,p).below()); }
    @Override public boolean isBonemealSuccess(Level l,RandomSource r,BlockPos p,BlockState s){ return true; }
    @Override public void performBonemeal(ServerLevel l,RandomSource r,BlockPos p,BlockState s){ BlockPos b=findBottom(l,p); if(l.isEmptyBlock(b.below())) grow(l,b); }
    private BlockPos findBottom(LevelReader l,BlockPos p){ while(l.getBlockState(p.below()).is(this)) p=p.below(); return p; }
}
