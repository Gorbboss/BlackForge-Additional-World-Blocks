package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/** BetterNether Hook Mushroom: a ceiling plant, not a ground bush. */
public class ImportedHookMushroomBlock extends Block {
    private static final VoxelShape SHAPE = box(2, 2, 2, 14, 16, 14);
    public ImportedHookMushroomBlock() { super(BlockBehaviour.Properties.copy(Blocks.WARPED_ROOTS).noCollission().noOcclusion().lightLevel(s -> 13)); }
    @Override public VoxelShape getShape(BlockState s, BlockGetter l, BlockPos p, CollisionContext c) { return SHAPE; }
    @Override public boolean canSurvive(BlockState s, LevelReader l, BlockPos p) {
        BlockState above = l.getBlockState(p.above());
        return above.is(Blocks.NETHERRACK) || above.is(Blocks.CRIMSON_NYLIUM) || above.is(Blocks.WARPED_NYLIUM) || above.isFaceSturdy(l, p.above(), Direction.DOWN);
    }
    @Override public BlockState updateShape(BlockState s, Direction d, BlockState n, LevelAccessor l, BlockPos p, BlockPos np) { return canSurvive(s,l,p) ? s : Blocks.AIR.defaultBlockState(); }
}
