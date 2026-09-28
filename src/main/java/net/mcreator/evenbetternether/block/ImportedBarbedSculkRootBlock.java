package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
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
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/** Directional, branching BetterEnd Neon Cactus port, renamed Barbed Sculk Root. */
public class ImportedBarbedSculkRootBlock extends Block implements BonemealableBlock {
    public enum Shape implements StringRepresentable { TOP, MIDDLE, BOTTOM; public String getSerializedName(){return name().toLowerCase();} }
    public enum Bottom implements StringRepresentable { EMPTY, SAND, MOSS; public String getSerializedName(){return name().toLowerCase();} }
    public static final EnumProperty<Shape> SHAPE=EnumProperty.create("shape",Shape.class);
    public static final EnumProperty<Bottom> BOTTOM=EnumProperty.create("bottom",Bottom.class);
    public static final DirectionProperty FACING=net.minecraft.world.level.block.state.properties.BlockStateProperties.FACING;
    public ImportedBarbedSculkRootBlock(){super(BlockBehaviour.Properties.copy(Blocks.CACTUS).randomTicks().noOcclusion().lightLevel(s->15));registerDefaultState(stateDefinition.any().setValue(SHAPE,Shape.TOP).setValue(BOTTOM,Bottom.EMPTY).setValue(FACING,Direction.UP));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(SHAPE,BOTTOM,FACING);}
    @Override public BlockState getStateForPlacement(BlockPlaceContext c){Direction d=c.getClickedFace();return defaultBlockState().setValue(FACING,d).setValue(BOTTOM,bottom(c.getLevel(),c.getClickedPos().relative(d.getOpposite())));}
    private Bottom bottom(LevelReader l,BlockPos p){BlockState s=l.getBlockState(p);if(s.is(Blocks.END_STONE)||s.is(Blocks.SAND))return Bottom.SAND;if(s.is(Blocks.MOSS_BLOCK)||s.is(Blocks.SCULK)||s.is(Blocks.MYCELIUM))return Bottom.MOSS;return Bottom.EMPTY;}
    @Override public boolean canSurvive(BlockState s,LevelReader l,BlockPos p){Direction d=s.getValue(FACING);BlockPos q=p.relative(d.getOpposite());BlockState support=l.getBlockState(q);return support.is(this)||support.isFaceSturdy(l,q,d);}
    @Override public BlockState updateShape(BlockState s,Direction d,BlockState n,LevelAccessor l,BlockPos p,BlockPos q){if(!canSurvive(s,l,p))l.scheduleTick(p,this,1);return s.setValue(BOTTOM,bottom(l,p.relative(s.getValue(FACING).getOpposite())));}
    @Override public void tick(BlockState s,ServerLevel l,BlockPos p,RandomSource r){if(!canSurvive(s,l,p))l.destroyBlock(p,true);}
    @Override public void randomTick(BlockState s,ServerLevel l,BlockPos p,RandomSource r){if(r.nextInt(8)==0)grow(l,r,p,s);}
    private void grow(ServerLevel l,RandomSource r,BlockPos p,BlockState s){Direction d=s.getValue(FACING);BlockPos q=p.relative(d);if(!l.isEmptyBlock(q)||length(l,p,s)>11)return;l.setBlock(q,defaultBlockState().setValue(FACING,d),UPDATE_ALL);mutateBack(l,p,s);if(d.getAxis().isVertical()&&length(l,p,s)>2&&r.nextInt(3)==0){Direction side=Direction.Plane.HORIZONTAL.getRandomDirection(r);BlockPos branch=p.relative(side);if(l.isEmptyBlock(branch))l.setBlock(branch,defaultBlockState().setValue(FACING,side),UPDATE_ALL);}}
    private int length(LevelReader l,BlockPos p,BlockState s){int n=0;Direction back=s.getValue(FACING).getOpposite();while(n<12){p=p.relative(back);s=l.getBlockState(p);if(!s.is(this))break;back=s.getValue(FACING).getOpposite();n++;}return n;}
    private void mutateBack(ServerLevel l,BlockPos p,BlockState s){int i=0;while(i++<12){s=l.getBlockState(p);if(!s.is(this))break;Shape shape=i<4?Shape.MIDDLE:Shape.BOTTOM;l.setBlock(p,s.setValue(SHAPE,shape),2);p=p.relative(s.getValue(FACING).getOpposite());}}
    @Override public boolean isValidBonemealTarget(LevelReader l,BlockPos p,BlockState s,boolean c){return l.isEmptyBlock(p.relative(s.getValue(FACING)));}
    @Override public boolean isBonemealSuccess(Level l,RandomSource r,BlockPos p,BlockState s){return true;}
    @Override public void performBonemeal(ServerLevel l,RandomSource r,BlockPos p,BlockState s){grow(l,r,p,s);}
    @Override public VoxelShape getShape(BlockState s,BlockGetter l,BlockPos p,CollisionContext c){int inset=s.getValue(SHAPE)==Shape.BOTTOM?2:s.getValue(SHAPE)==Shape.MIDDLE?3:4;return box(inset,0,inset,16-inset,16,16-inset);}
    @Override public void entityInside(BlockState s,Level l,BlockPos p,Entity e){e.hurt(l.damageSources().cactus(),1.0F);}
}
