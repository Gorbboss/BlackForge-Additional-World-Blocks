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
public class ImportedMushroomColoniesFeature extends Feature<NoneFeatureConfiguration> {
    private final boolean red;

    public ImportedMushroomColoniesFeature(boolean red) {
        super(NoneFeatureConfiguration.CODEC);
        this.red = red;
    }

    @Override public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos origin = context.origin();
        boolean placed = false;
        int tries = 24;
        for (int i = 0; i < tries; i++) {
            int x = origin.getX() + random.nextInt(7) - 3;
            int z = origin.getZ() + random.nextInt(7) - 3;
            int y = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z);
            BlockPos pos = new BlockPos(x, y, z);
            if (!level.isEmptyBlock(pos) || !level.isEmptyBlock(pos.above())) continue;
            Block small = (red ? BlackForgeImportedBlocks.RED_MUSHROOM_COLONY : BlackForgeImportedBlocks.BROWN_MUSHROOM_COLONY).get();
            Block tall = (red ? BlackForgeImportedBlocks.TALL_RED_MUSHROOM_COLONY : BlackForgeImportedBlocks.TALL_BROWN_MUSHROOM_COLONY).get();
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
