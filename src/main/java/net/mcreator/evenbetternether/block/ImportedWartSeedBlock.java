package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ImportedWartSeedBlock extends Block implements BonemealableBlock {
    public static final DirectionProperty FACING=BlockStateProperties.FACING;
    public ImportedWartSeedBlock(){super(BlockBehaviour.Properties.copy(Blocks.NETHER_WART).noCollission());registerDefaultState(stateDefinition.any().setValue(FACING,Direction.UP));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(FACING);}
    @Override public VoxelShape getShape(BlockState s,BlockGetter l,BlockPos p,CollisionContext c){return switch(s.getValue(FACING)){case UP->box(4,0,4,12,8,12);case DOWN->box(4,8,4,12,16,12);case NORTH->box(4,4,8,12,12,16);case SOUTH->box(4,4,0,12,12,8);case WEST->box(8,4,4,16,12,12);case EAST->box(0,4,4,8,12,12);};}
    @Override public BlockState getStateForPlacement(BlockPlaceContext c){for(Direction d:c.getNearestLookingDirections()){BlockState s=defaultBlockState().setValue(FACING,d.getOpposite());if(s.canSurvive(c.getLevel(),c.getClickedPos()))return s;}return null;}
    @Override public boolean canSurvive(BlockState s,LevelReader l,BlockPos p){
        Direction d=s.getValue(FACING);
        BlockPos q=p.relative(d.getOpposite());
        BlockState support=l.getBlockState(q);
        return (support.is(Blocks.SOUL_SAND)||support.is(Blocks.SOUL_SOIL)||support.is(Blocks.NETHERRACK)
                ||support.is(Blocks.CRIMSON_NYLIUM)||support.is(Blocks.WARPED_NYLIUM)
                ||support.is(Blocks.NETHER_WART_BLOCK)) && Block.canSupportCenter(l,q,d);
    }
    @Override public BlockState updateShape(BlockState state,Direction direction,BlockState neighbor,LevelAccessor level,BlockPos pos,BlockPos neighborPos){
        return state.canSurvive(level,pos) ? state : Blocks.AIR.defaultBlockState();
    }
    @Override public boolean isValidBonemealTarget(LevelReader l,BlockPos p,BlockState s,boolean c){return s.getValue(FACING)==Direction.UP&&l.getBlockState(p.below()).is(Blocks.SOUL_SAND);}
    @Override public boolean isBonemealSuccess(Level l,RandomSource r,BlockPos p,BlockState s){return r.nextInt(8)==0;}
    @Override public void performBonemeal(ServerLevel l,RandomSource r,BlockPos p,BlockState s){grow(l,r,p);}
    private void grow(ServerLevel l,RandomSource r,BlockPos p){
        int height=5+r.nextInt(5),width=(height>>>2)+1,offset=width>>>1;
        for(int x=0;x<width;x++)for(int z=0;z<width;z++)for(int y=0;y<height;y++){BlockPos q=p.offset(x-offset,y,z-offset);if(l.getBlockState(q).canBeReplaced())l.setBlock(q,y<height-1?Blocks.CRIMSON_STEM.defaultBlockState():Blocks.NETHER_WART_BLOCK.defaultBlockState(),Block.UPDATE_ALL);}
        int head=width+2;offset++;int baseY=height-width-1;
        for(int x=0;x<head;x++)for(int z=0;z<head;z++)if(x!=z&&x!=head-z-1)for(int y=0;y<width;y++){BlockPos q=p.offset(x-offset,baseY+y,z-offset);if(l.getBlockState(q).canBeReplaced()){l.setBlock(q,Blocks.NETHER_WART_BLOCK.defaultBlockState(),Block.UPDATE_ALL);if(r.nextInt(4)==0)placeSeed(l,r,q);}}
    }
    private void placeSeed(ServerLevel l,RandomSource r,BlockPos wart){Direction d=Direction.values()[r.nextInt(6)];BlockPos q=wart.relative(d);if(l.getBlockState(q).canBeReplaced())l.setBlock(q,defaultBlockState().setValue(FACING,d),Block.UPDATE_ALL);}
    @Override public BlockState rotate(BlockState s,Rotation r){return s.setValue(FACING,r.rotate(s.getValue(FACING)));}
    @Override public BlockState mirror(BlockState s,Mirror m){return s.rotate(m.getRotation(s.getValue(FACING)));}
}
