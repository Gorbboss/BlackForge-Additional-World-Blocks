package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ImportedWallPlantBlock extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public ImportedWallPlantBlock() { super(BlockBehaviour.Properties.copy(Blocks.GLOW_LICHEN).noCollission().noOcclusion()); registerDefaultState(stateDefinition.any().setValue(FACING,Direction.NORTH)); }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(FACING);}
    @Override public VoxelShape getShape(BlockState s, BlockGetter l, BlockPos p, CollisionContext c){return switch(s.getValue(FACING)){case NORTH->box(2,2,10,14,14,16);case SOUTH->box(2,2,0,14,14,6);case WEST->box(10,2,2,16,14,14);default->box(0,2,2,6,14,14);};}
    @Override public boolean canSurvive(BlockState s, LevelReader l, BlockPos p){Direction d=s.getValue(FACING);BlockPos q=p.relative(d.getOpposite());return l.getBlockState(q).isFaceSturdy(l,q,d);}
    @Override public BlockState updateShape(BlockState s,Direction d,BlockState n,LevelAccessor l,BlockPos p,BlockPos np){return canSurvive(s,l,p)?s:Blocks.AIR.defaultBlockState();}
    @Override public BlockState getStateForPlacement(BlockPlaceContext c){for(Direction d:c.getNearestLookingDirections())if(d.getAxis().isHorizontal()){BlockState s=defaultBlockState().setValue(FACING,d.getOpposite());if(s.canSurvive(c.getLevel(),c.getClickedPos()))return s;}return null;}
    @Override public BlockState rotate(BlockState s,Rotation r){return s.setValue(FACING,r.rotate(s.getValue(FACING)));}
    @Override public BlockState mirror(BlockState s,Mirror m){return s.rotate(m.getRotation(s.getValue(FACING)));}
}
