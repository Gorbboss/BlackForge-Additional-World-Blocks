package net.mcreator.evenbetternether.world.features;
import net.mcreator.evenbetternether.block.ImportedBigLilyPadBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Fluids;
public class ImportedBigLilyPadFeature extends Feature<NoneFeatureConfiguration> {
    public ImportedBigLilyPadFeature() { super(NoneFeatureConfiguration.CODEC); }
    @Override public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        Direction facing = Direction.Plane.HORIZONTAL.getRandomDirection(context.random());
        for (BlockPos part : new BlockPos[]{pos, pos.relative(facing), pos.relative(facing.getClockWise()), pos.relative(facing).relative(facing.getClockWise())}) {
            if (!context.level().isEmptyBlock(part) || !validWater(context.level(), part.below())) return false;
        }
        ImportedBigLilyPadBlock.placeAt(context.level(), facing, pos, 3);
        return true;
    }
    private boolean validWater(WorldGenLevel level, BlockPos pos) {
        return level.getBlockState(pos).is(Blocks.ICE) || level.getFluidState(pos).is(Fluids.WATER) && level.getFluidState(pos).isSource();
    }
}
