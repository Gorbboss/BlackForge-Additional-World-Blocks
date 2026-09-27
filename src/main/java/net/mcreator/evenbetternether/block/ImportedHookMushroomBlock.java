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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootParams;
import java.util.List;

/** BetterNether Hook Mushroom: a ceiling plant, not a ground bush. */
public class ImportedHookMushroomBlock extends Block {
    private static final VoxelShape SHAPE = box(2, 2, 2, 14, 16, 14);
    public ImportedHookMushroomBlock() { super(BlockBehaviour.Properties.copy(Blocks.WARPED_ROOTS).noCollission().noOcclusion().randomTicks().lightLevel(s -> 13)); }
    @Override public VoxelShape getShape(BlockState s, BlockGetter l, BlockPos p, CollisionContext c) { return SHAPE; }
    @Override public boolean canSurvive(BlockState s, LevelReader l, BlockPos p) {
        BlockState above = l.getBlockState(p.above());
        return above.is(Blocks.NETHERRACK) || above.is(Blocks.CRIMSON_NYLIUM) || above.is(Blocks.WARPED_NYLIUM) || above.isFaceSturdy(l, p.above(), Direction.DOWN);
    }
    @Override public BlockState updateShape(BlockState s, Direction d, BlockState n, LevelAccessor l, BlockPos p, BlockPos np) { return canSurvive(s,l,p) ? s : Blocks.AIR.defaultBlockState(); }
    @Override public void randomTick(BlockState s,ServerLevel l,BlockPos p,RandomSource r){if(r.nextInt(16)!=0)return;int adjacent=0;for(Direction d:Direction.Plane.HORIZONTAL)if(l.getBlockState(p.relative(d)).is(this))adjacent++;if(adjacent>=2)return;Direction d=Direction.Plane.HORIZONTAL.getRandomDirection(r);BlockPos q=p.relative(d);if(l.isEmptyBlock(q)&&canSurvive(s,l,q))l.setBlock(q,defaultBlockState(),UPDATE_ALL);}
    @Override public List<ItemStack> getDrops(BlockState s,LootParams.Builder b){return List.of(new ItemStack(this));}
}
