package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/** Dependency-free port of BetterNether's three-block-tall Nether cactus. */
public class ImportedNetherCactusBlock extends Block {
    public static final BooleanProperty TOP = BooleanProperty.create("top");
    private static final VoxelShape TOP_SHAPE = box(4, 0, 4, 12, 8, 12);
    private static final VoxelShape SIDE_SHAPE = box(5, 0, 5, 11, 16, 11);

    public ImportedNetherCactusBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.CACTUS).randomTicks().noOcclusion());
        registerDefaultState(stateDefinition.any().setValue(TOP, true));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) { b.add(TOP); }
    @Override public VoxelShape getShape(BlockState s, BlockGetter l, BlockPos p, CollisionContext c) { return s.getValue(TOP) ? TOP_SHAPE : SIDE_SHAPE; }
    @Override public boolean canSurvive(BlockState s, LevelReader l, BlockPos p) {
        BlockState down = l.getBlockState(p.below());
        return down.is(this) || down.is(Blocks.GRAVEL) || down.is(Blocks.SOUL_SAND) || down.is(Blocks.NETHERRACK);
    }
    @Override public BlockState updateShape(BlockState s, Direction d, BlockState n, LevelAccessor l, BlockPos p, BlockPos np) {
        if (!canSurvive(s, l, p)) return Blocks.AIR.defaultBlockState();
        return s.setValue(TOP, !l.getBlockState(p.above()).is(this));
    }
    @Override public void randomTick(BlockState s, ServerLevel l, BlockPos p, RandomSource r) {
        if (!canSurvive(s, l, p)) { l.destroyBlock(p, true); return; }
        if (s.getValue(TOP) && r.nextInt(16) == 0 && l.isEmptyBlock(p.above())) {
            int length = 1;
            while (length < 4 && l.getBlockState(p.below(length)).is(this)) length++;
            if (length < 3) {
                l.setBlock(p, s.setValue(TOP, false), UPDATE_ALL);
                l.setBlock(p.above(), defaultBlockState(), UPDATE_ALL);
            }
        }
    }
    @Override public void entityInside(BlockState s, Level l, BlockPos p, Entity e) { e.hurt(l.damageSources().cactus(), 1.0F); }
}
