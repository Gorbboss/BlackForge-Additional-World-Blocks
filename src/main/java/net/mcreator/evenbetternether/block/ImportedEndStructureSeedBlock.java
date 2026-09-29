package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.ForgeRegistries;

/** Bonemeal growth implementations for the four BetterEnd seed families. */
public class ImportedEndStructureSeedBlock extends Block implements BonemealableBlock, SimpleWaterloggedBlock {
    public enum Kind { BLUE_VINE, LANCELEAF, GLOWING_PILLAR, HYDRALUX }
    public static final IntegerProperty AGE=IntegerProperty.create("age",0,3);
    public static final BooleanProperty WATERLOGGED=BlockStateProperties.WATERLOGGED;
    private final Kind kind;
    public ImportedEndStructureSeedBlock(Kind kind){super(BlockBehaviour.Properties.copy(Blocks.CHORUS_FLOWER).randomTicks().noCollission().noOcclusion());this.kind=kind;registerDefaultState(stateDefinition.any().setValue(AGE,0).setValue(WATERLOGGED,false));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(AGE,WATERLOGGED);}
    @Override public BlockState getStateForPlacement(BlockPlaceContext c){
        boolean water=c.getLevel().getFluidState(c.getClickedPos()).is(Fluids.WATER);
        if (water != (kind == Kind.HYDRALUX)) return null;
        BlockState state=defaultBlockState().setValue(WATERLOGGED,water);
        return state.canSurvive(c.getLevel(),c.getClickedPos()) ? state : null;
    }
    @Override public boolean canSurvive(BlockState state,LevelReader level,BlockPos pos){
        return ImportedEndSoil.supports(level.getBlockState(pos.below()))
                && state.getValue(WATERLOGGED) == (kind == Kind.HYDRALUX);
    }
    @Override public BlockState updateShape(BlockState state,Direction direction,BlockState neighbor,LevelAccessor level,BlockPos pos,BlockPos neighborPos){
        if(state.getValue(WATERLOGGED)) level.scheduleTick(pos,Fluids.WATER,Fluids.WATER.getTickDelay(level));
        return state.canSurvive(level,pos) ? state : Blocks.AIR.defaultBlockState();
    }
    @Override public FluidState getFluidState(BlockState s){return s.getValue(WATERLOGGED)?Fluids.WATER.getSource(false):super.getFluidState(s);}
    @Override public boolean isValidBonemealTarget(LevelReader l,BlockPos p,BlockState s,boolean c){return true;}
    @Override public boolean isBonemealSuccess(Level l,RandomSource r,BlockPos p,BlockState s){return true;}
    @Override public void performBonemeal(ServerLevel l,RandomSource r,BlockPos p,BlockState s){if(s.getValue(AGE)<3){l.setBlock(p,s.setValue(AGE,s.getValue(AGE)+1),UPDATE_ALL);return;}grow(l,r,p);}
    @Override public void randomTick(BlockState s,ServerLevel l,BlockPos p,RandomSource r){if(r.nextInt(16)==0)performBonemeal(l,r,p,s);}
    private Block block(String id){return ForgeRegistries.BLOCKS.getValue(new ResourceLocation("evenbetternether",id));}
    private void grow(ServerLevel l,RandomSource r,BlockPos p){switch(kind){case BLUE_VINE->blue(l,r,p);case LANCELEAF->lance(l,r,p);case GLOWING_PILLAR->pillar(l,r,p);case HYDRALUX->hydralux(l,r,p);}}
    private boolean clear(ServerLevel l,BlockPos p,int h){for(int i=1;i<=h;i++)if(!l.getBlockState(p.above(i)).canBeReplaced())return false;return true;}
    private void blue(ServerLevel l,RandomSource r,BlockPos p){int h=2+r.nextInt(4);if(!clear(l,p,h+1))return;Block vine=block("blue_vine");l.setBlock(p,vine.defaultBlockState().setValue(ImportedEndShapeBlock.SHAPE,ImportedEndShapeBlock.Shape.BOTTOM),2);for(int i=1;i<h;i++)l.setBlock(p.above(i),vine.defaultBlockState().setValue(ImportedEndShapeBlock.SHAPE,ImportedEndShapeBlock.Shape.MIDDLE),2);l.setBlock(p.above(h),vine.defaultBlockState().setValue(ImportedEndShapeBlock.SHAPE,ImportedEndShapeBlock.Shape.TOP),2);BlockPos cap=p.above(h+1);l.setBlock(cap,block("blue_vine_lantern").defaultBlockState(),2);fur(l,cap,block("blue_vine_fur"));}
    private void lance(ServerLevel l,RandomSource r,BlockPos p){int h=4+r.nextInt(3);if(!clear(l,p,h))return;Block b=block("lanceleaf");int rot=r.nextInt(4);ImportedLanceleafBlock.Shape[] shapes={ImportedLanceleafBlock.Shape.BOTTOM,ImportedLanceleafBlock.Shape.PRE_BOTTOM,ImportedLanceleafBlock.Shape.MIDDLE,ImportedLanceleafBlock.Shape.PRE_TOP,ImportedLanceleafBlock.Shape.TOP};for(int i=0;i<h;i++){ImportedLanceleafBlock.Shape shape=i==0?shapes[0]:i==1?shapes[1]:i==h-2?shapes[3]:i==h-1?shapes[4]:shapes[2];l.setBlock(p.above(i),b.defaultBlockState().setValue(ImportedLanceleafBlock.SHAPE,shape).setValue(ImportedLanceleafBlock.ROTATION,rot),2);}}
    private void pillar(ServerLevel l,RandomSource r,BlockPos p){int h=1+r.nextInt(2);if(!clear(l,p,h+1))return;Block roots=block("glowing_pillar_roots");if(h==1)l.setBlock(p,roots.defaultBlockState().setValue(ImportedEndShapeBlock.SHAPE,ImportedEndShapeBlock.Shape.MIDDLE),2);else{l.setBlock(p,roots.defaultBlockState().setValue(ImportedEndShapeBlock.SHAPE,ImportedEndShapeBlock.Shape.BOTTOM),2);l.setBlock(p.above(),roots.defaultBlockState().setValue(ImportedEndShapeBlock.SHAPE,ImportedEndShapeBlock.Shape.TOP),2);}BlockPos cap=p.above(h);l.setBlock(cap,block("glowing_pillar_luminophor").defaultBlockState(),2);fur(l,cap,block("glowing_pillar_leaves"));}
    private void hydralux(ServerLevel l,RandomSource r,BlockPos p){int h=4+r.nextInt(5);for(int i=1;i<h;i++)if(!l.getFluidState(p.above(i)).is(Fluids.WATER))return;Block b=block("hydralux");l.setBlock(p,b.defaultBlockState().setValue(ImportedEndShapeBlock.SHAPE,ImportedEndShapeBlock.Shape.ROOTS),2);for(int i=1;i<h-2;i++)l.setBlock(p.above(i),b.defaultBlockState().setValue(ImportedEndShapeBlock.SHAPE,ImportedEndShapeBlock.Shape.VINE),2);boolean big=r.nextBoolean();l.setBlock(p.above(h-2),b.defaultBlockState().setValue(ImportedEndShapeBlock.SHAPE,big?ImportedEndShapeBlock.Shape.FLOWER_BIG_BOTTOM:ImportedEndShapeBlock.Shape.FLOWER_SMALL_BOTTOM),2);l.setBlock(p.above(h-1),b.defaultBlockState().setValue(ImportedEndShapeBlock.SHAPE,big?ImportedEndShapeBlock.Shape.FLOWER_BIG_TOP:ImportedEndShapeBlock.Shape.FLOWER_SMALL_TOP),2);}
    private void fur(ServerLevel l,BlockPos p,Block fur){for(Direction d:Direction.values()){BlockPos q=p.relative(d);if(l.isEmptyBlock(q))l.setBlock(q,fur.defaultBlockState().setValue(ImportedDirectionalFurBlock.FACING,d),2);}}
}
