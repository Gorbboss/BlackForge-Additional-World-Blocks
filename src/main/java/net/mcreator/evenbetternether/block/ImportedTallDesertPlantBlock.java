package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

/** Two-block cactus or dune grass, with the same ground rule as its short form. */
public class ImportedTallDesertPlantBlock extends DoublePlantBlock {
    private final boolean cactus;

    public ImportedTallDesertPlantBlock(boolean cactus) {
        super(BlockBehaviour.Properties.copy(cactus ? Blocks.ALLIUM : Blocks.TALL_GRASS));
        this.cactus = cactus;
    }

    @Override protected boolean mayPlaceOn(BlockState ground, BlockGetter level, BlockPos pos) {
        return ImportedDesertPlantBlock.supports(ground, cactus);
    }

    @Override public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (cactus && entity instanceof LivingEntity) entity.hurt(level.damageSources().cactus(), 1.0F);
    }
}
