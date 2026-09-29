package net.mcreator.evenbetternether.world.features;

import net.mcreator.evenbetternether.block.ImportedEndStructureSeedBlock;
import net.mcreator.evenbetternether.init.BlackForgeImportedBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

/** Makes a sheltered End-stone water pocket deep enough for Hydralux to mature. */
public class ImportedHydraluxPoolFeature extends Feature<NoneFeatureConfiguration> {
    public ImportedHydraluxPoolFeature() { super(NoneFeatureConfiguration.CODEC); }

    @Override public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos surface = context.origin();
        BlockPos bottom = surface.below(8);
        if (!level.isEmptyBlock(surface)) return false;
        for (int y = 0; y < 8; y++) {
            BlockPos center = bottom.above(y);
            if (!level.getBlockState(center).is(Blocks.END_STONE)) return false;
            for (int dx = -1; dx <= 1; dx++) for (int dz = -1; dz <= 1; dz++) {
                if (dx == 0 && dz == 0) continue;
                if (!level.getBlockState(center.offset(dx, 0, dz)).is(Blocks.END_STONE)) return false;
            }
        }
        if (!level.getBlockState(bottom.below()).is(Blocks.END_STONE)) return false;
        for (int y = 0; y < 8; y++) level.setBlock(bottom.above(y), Blocks.WATER.defaultBlockState(), 2);
        level.setBlock(bottom, BlackForgeImportedBlocks.HYDRALUX_SAPLING.get().defaultBlockState()
                .setValue(ImportedEndStructureSeedBlock.WATERLOGGED, true), 2);
        return true;
    }
}
