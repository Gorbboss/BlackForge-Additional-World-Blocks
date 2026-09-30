package net.mcreator.evenbetternether.world.features;

import net.mcreator.evenbetternether.block.ImportedCattailBlock;
import net.mcreator.evenbetternether.init.BlackForgeImportedBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Fluids;

/** Shallow water and bank patches; never creates submerged upper halves. */
public class ImportedWetlandPlantsFeature extends Feature<NoneFeatureConfiguration> {
    public ImportedWetlandPlantsFeature() { super(NoneFeatureConfiguration.CODEC); }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        var level = context.level();
        var random = context.random();
        boolean placed = false;
        for (int attempt = 0; attempt < 12; attempt++) {
            int x = context.origin().getX() + random.nextInt(7) - 3;
            int z = context.origin().getZ() + random.nextInt(7) - 3;
            BlockPos pos = new BlockPos(x, level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z), z);
            if (level.getBlockState(pos.below()).is(Blocks.WATER)) pos = pos.below();
            boolean wet = level.getBlockState(pos).is(Blocks.WATER) && level.getFluidState(pos).isSource();
            if ((!wet && !level.isEmptyBlock(pos)) || !level.isEmptyBlock(pos.above())) continue;
            if (!wet) {
                boolean nearWater = false;
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    if (level.getFluidState(pos.below().relative(direction)).is(Fluids.WATER)) nearWater = true;
                }
                if (!nearWater) continue;
            }
            Block plant = random.nextBoolean() ? BlackForgeImportedBlocks.CATTAIL.get() : BlackForgeImportedBlocks.REEDS.get();
            BlockState state = plant.defaultBlockState().setValue(ImportedCattailBlock.WATERLOGGED, wet);
            if (!state.canSurvive(level, pos)) continue;
            DoublePlantBlock.placeAt(level, state, pos, Block.UPDATE_ALL);
            placed = true;
        }
        return placed;
    }
}
