package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import java.util.List;

/** Small Nether plant with BetterNether-style permissive ground and bonemeal spreading. */
public class ImportedNetherPlantBlock extends BushBlock implements BonemealableBlock {
    private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 13, 14);

    public ImportedNetherPlantBlock(int light) {
        super(BlockBehaviour.Properties.copy(Blocks.WARPED_ROOTS)
                .noCollission()
                .noOcclusion()
                .lightLevel(state -> light));
    }

    @Override
    protected boolean mayPlaceOn(BlockState ground, BlockGetter level, BlockPos pos) {
        return ground.is(Blocks.NETHERRACK)
                || ground.is(Blocks.SOUL_SAND)
                || ground.is(Blocks.SOUL_SOIL)
                || ground.is(Blocks.CRIMSON_NYLIUM)
                || ground.is(Blocks.WARPED_NYLIUM)
                || ground.is(Blocks.GRAVEL)
                || ground.isFaceSturdy(level, pos, Direction.UP);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean client) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        level.addFreshEntity(new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5,
                pos.getZ() + 0.5, new ItemStack(asItem())));
    }
    @Override public List<ItemStack> getDrops(BlockState s,LootParams.Builder b){ItemStack tool=b.getOptionalParameter(LootContextParams.TOOL);return tool!=null&&tool.is(Items.SHEARS)?List.of(new ItemStack(this)):List.of();}
}
