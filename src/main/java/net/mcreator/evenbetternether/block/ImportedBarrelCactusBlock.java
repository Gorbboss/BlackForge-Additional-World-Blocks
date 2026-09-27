package net.mcreator.evenbetternether.block;

import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
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
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/** Dependency-free BetterNether Barrel Cactus port. */
public class ImportedBarrelCactusBlock extends BushBlock implements BonemealableBlock {
    public static final IntegerProperty AGE=IntegerProperty.create("age",0,3);
    private static final VoxelShape[] SHAPES={box(5,0,5,11,5,11),box(3,0,3,13,9,13),box(2,0,2,14,12,14),box(1,0,1,15,14,15)};
    public ImportedBarrelCactusBlock(){super(BlockBehaviour.Properties.copy(Blocks.CACTUS).randomTicks().dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ).noOcclusion());registerDefaultState(stateDefinition.any().setValue(AGE,0));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(AGE);}
    @Override protected boolean mayPlaceOn(BlockState s,BlockGetter l,BlockPos p){return s.is(Blocks.GRAVEL)||s.is(Blocks.SOUL_SAND)||s.is(Blocks.SOUL_SOIL)||s.is(Blocks.NETHERRACK);}
    @Override public VoxelShape getShape(BlockState s,BlockGetter l,BlockPos p,CollisionContext c){Vec3 o=s.getOffset(l,p);return SHAPES[s.getValue(AGE)].move(o.x,o.y,o.z);}
    @Override public VoxelShape getCollisionShape(BlockState s,BlockGetter l,BlockPos p,CollisionContext c){if(s.getValue(AGE)<2)return Shapes.empty();return getShape(s,l,p,c);}
    @Override public void entityInside(BlockState s,Level l,BlockPos p,Entity e){if(s.getValue(AGE)>1)e.hurt(l.damageSources().cactus(),1);}
    @Override public boolean isValidBonemealTarget(LevelReader l,BlockPos p,BlockState s,boolean c){return s.getValue(AGE)<3;}
    @Override public boolean isBonemealSuccess(Level l,RandomSource r,BlockPos p,BlockState s){return true;}
    @Override public void performBonemeal(ServerLevel l,RandomSource r,BlockPos p,BlockState s){if(s.getValue(AGE)<3)l.setBlock(p,s.setValue(AGE,s.getValue(AGE)+1),UPDATE_ALL);}
    @Override public void randomTick(BlockState s,ServerLevel l,BlockPos p,RandomSource r){if(s.getValue(AGE)<3&&r.nextInt(16)==0)performBonemeal(l,r,p,s);}
    @Override public List<ItemStack> getDrops(BlockState s,LootParams.Builder b){return List.of(new ItemStack(this,s.getValue(AGE)==3?1+b.getLevel().random.nextInt(3):1));}
}
