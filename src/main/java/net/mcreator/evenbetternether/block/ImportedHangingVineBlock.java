package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import java.util.List;

/** Hanging, climbable vine which extends downward with bonemeal. */
public class ImportedHangingVineBlock extends Block implements BonemealableBlock {
    public static final BooleanProperty BOTTOM = BooleanProperty.create("bottom");
    private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 16, 14);

    public ImportedHangingVineBlock(int light) {
        super(BlockBehaviour.Properties.copy(Blocks.WEEPING_VINES)
                .noCollission()
                .noOcclusion()
                .emissiveRendering((state, level, pos) -> light > 0)
                .lightLevel(state -> light));
        registerDefaultState(stateDefinition.any().setValue(BOTTOM, true));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BOTTOM);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState above = level.getBlockState(pos.above());
        return above.is(this) || above.isFaceSturdy(level, pos.above(), Direction.DOWN);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighbor, LevelAccessor level,
                                  BlockPos pos, BlockPos neighborPos) {
        if (!canSurvive(state, level, pos)) return Blocks.AIR.defaultBlockState();
        return state.setValue(BOTTOM, !level.getBlockState(pos.below()).is(this));
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean client) {
        BlockPos cursor = pos;
        while (level.getBlockState(cursor.below()).is(this)) cursor = cursor.below();
        return level.isEmptyBlock(cursor.below());
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos cursor = pos;
        while (level.getBlockState(cursor.below()).is(this)) cursor = cursor.below();
        BlockPos next = cursor.below();
        if (level.isEmptyBlock(next)) {
            level.setBlock(cursor, level.getBlockState(cursor).setValue(BOTTOM, false), Block.UPDATE_ALL);
            level.setBlock(next, defaultBlockState(), Block.UPDATE_ALL);
        }
    }

    @Override
    public boolean isLadder(BlockState state, LevelReader level, BlockPos pos, net.minecraft.world.entity.LivingEntity entity) {
        return true;
    }
    @Override public List<ItemStack> getDrops(BlockState s,LootParams.Builder b){ItemStack tool=b.getOptionalParameter(LootContextParams.TOOL);return tool!=null&&(tool.is(Items.SHEARS)||EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH,tool)>0)?List.of(new ItemStack(this)):List.of();}
}
