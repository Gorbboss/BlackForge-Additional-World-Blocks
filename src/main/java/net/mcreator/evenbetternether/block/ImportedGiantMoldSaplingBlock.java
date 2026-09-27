package net.mcreator.evenbetternether.block;

import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class ImportedGiantMoldSaplingBlock extends BushBlock implements BonemealableBlock {
    private final Supplier<Block> mold;
    public ImportedGiantMoldSaplingBlock(Supplier<Block> mold) {
        super(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FUNGUS).noCollission().randomTicks());
        this.mold = mold;
    }
    @Override protected boolean mayPlaceOn(BlockState s, net.minecraft.world.level.BlockGetter l, BlockPos p) {
        return s.is(Blocks.MYCELIUM) || s.is(Blocks.CRIMSON_NYLIUM) || s.is(Blocks.WARPED_NYLIUM);
    }
    @Override public boolean isValidBonemealTarget(LevelReader l, BlockPos p, BlockState s, boolean c) { return true; }
    @Override public boolean isBonemealSuccess(Level l, RandomSource r, BlockPos p, BlockState s) { return r.nextInt(8) == 0; }
    @Override public void performBonemeal(ServerLevel l, RandomSource r, BlockPos p, BlockState s) { grow(l, r, p); }
    @Override public void randomTick(BlockState s, ServerLevel l, BlockPos p, RandomSource r) { if (isBonemealSuccess(l, r, p, s)) grow(l, r, p); }
    private void grow(ServerLevel l, RandomSource r, BlockPos p) {
        int height = Mth.clamp((int)Math.round(5 + r.nextGaussian() * 1.3), 3, 8);
        for (int y=0; y<height; y++) if (y > 0 && !l.getBlockState(p.above(y)).canBeReplaced()) return;
        Block block = mold.get();
        for (int y=0; y<height; y++) {
            ImportedTripleShape shape = y == 0 ? ImportedTripleShape.BOTTOM : y == height-1 ? ImportedTripleShape.TOP : ImportedTripleShape.MIDDLE;
            l.setBlock(p.above(y), block.defaultBlockState().setValue(ImportedGiantMoldBlock.SHAPE, shape), Block.UPDATE_ALL);
        }
    }
}
