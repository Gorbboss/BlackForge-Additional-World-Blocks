package net.mcreator.evenbetternether.block;

import java.util.List;
import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/** BetterNether Feather Fern, kept separate from Even Better Nether's fern. */
public class ImportedBetterFeatherFernBlock extends BushBlock implements BonemealableBlock {
    public static final IntegerProperty AGE=IntegerProperty.create("age",0,3);
    private final Supplier<Block> alternate;
    public ImportedBetterFeatherFernBlock(Supplier<Block> alternate){super(BlockBehaviour.Properties.copy(Blocks.CRIMSON_ROOTS).randomTicks().noCollission().offsetType(BlockBehaviour.OffsetType.XZ));this.alternate=alternate;registerDefaultState(stateDefinition.any().setValue(AGE,0));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(AGE);}
    @Override protected boolean mayPlaceOn(BlockState s,BlockGetter l,BlockPos p){return s.is(Blocks.NETHERRACK)||s.is(Blocks.GRAVEL)||s.is(Blocks.CRIMSON_NYLIUM)||s.is(Blocks.WARPED_NYLIUM)||s.is(Blocks.SOUL_SAND)||s.is(Blocks.SOUL_SOIL);}
    @Override public VoxelShape getShape(BlockState s,BlockGetter l,BlockPos p,CollisionContext c){Vec3 o=s.getOffset(l,p);return box(2,0,2,14,14,14).move(o.x,o.y,o.z);}
    @Override public boolean isValidBonemealTarget(LevelReader l,BlockPos p,BlockState s,boolean c){return s.getValue(AGE)<3;}
    @Override public boolean isBonemealSuccess(Level l,RandomSource r,BlockPos p,BlockState s){return true;}
    @Override public void performBonemeal(ServerLevel l,RandomSource r,BlockPos p,BlockState s){if(s.getValue(AGE)<3)l.setBlock(p,s.setValue(AGE,s.getValue(AGE)+1),UPDATE_ALL);}
    @Override public void randomTick(BlockState s,ServerLevel l,BlockPos p,RandomSource r){if(s.getValue(AGE)<3&&r.nextInt(16)==0)performBonemeal(l,r,p,s);}
    @Override public void setPlacedBy(Level l,BlockPos p,BlockState s,LivingEntity e,ItemStack stack){if(!l.isClientSide&&l.random.nextBoolean())l.setBlock(p,alternate.get().defaultBlockState(),UPDATE_ALL);}
    @Override public List<ItemStack> getDrops(BlockState s,LootParams.Builder b){if(s.getValue(AGE)==3)return List.of(new ItemStack(this,1+b.getLevel().random.nextInt(2)),new ItemStack(Items.FEATHER,1+b.getLevel().random.nextInt(4)));return List.of(new ItemStack(this));}
}
