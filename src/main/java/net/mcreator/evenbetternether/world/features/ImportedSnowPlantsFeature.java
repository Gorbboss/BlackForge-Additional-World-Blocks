package net.mcreator.evenbetternether.world.features;

import net.mcreator.evenbetternether.init.BlackForgeImportedBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

/** Small mixed patches; tall plants are always placed with both halves. */
public class ImportedSnowPlantsFeature extends Feature<NoneFeatureConfiguration> {
    private final boolean fern;

    public ImportedSnowPlantsFeature(boolean fern) {
        super(NoneFeatureConfiguration.CODEC);
        this.fern = fern;
    }

    @Override public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos origin = context.origin();
        boolean placed = false;
        int tries = fern ? 12 : 32;
        for (int i = 0; i < tries; i++) {
            int x = origin.getX() + random.nextInt(7) - 3;
            int z = origin.getZ() + random.nextInt(7) - 3;
            int y = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z);
            BlockPos pos = new BlockPos(x, y, z);
            if (level.getBlockState(pos.below()).is(net.minecraft.world.level.block.Blocks.SNOW)) pos = pos.below();
            if ((!level.isEmptyBlock(pos) && !level.getBlockState(pos).is(net.minecraft.world.level.block.Blocks.SNOW))
                    || !level.isEmptyBlock(pos.above())) continue;
            Block small = (fern ? BlackForgeImportedBlocks.SNOW_FERN : BlackForgeImportedBlocks.SHORT_SNOW_GRASS).get();
            Block tall = (fern ? BlackForgeImportedBlocks.LARGE_SNOW_FERN : BlackForgeImportedBlocks.TALL_SNOW_GRASS).get();
            if (!small.defaultBlockState().canSurvive(level, pos)) continue;
            if (random.nextInt(4) == 0) {
                DoublePlantBlock.placeAt(level, tall.defaultBlockState(), pos, Block.UPDATE_ALL);
            } else {
                level.setBlock(pos, small.defaultBlockState(), Block.UPDATE_ALL);
            }
            placed = true;
        }
        return placed;
    }
}
