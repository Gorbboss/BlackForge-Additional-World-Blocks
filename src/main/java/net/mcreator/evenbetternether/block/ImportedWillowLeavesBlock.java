package net.mcreator.evenbetternether.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class ImportedWillowLeavesBlock extends Block {
    public static final DirectionProperty FACING=DirectionProperty.create("facing");
    public static final BooleanProperty NATURAL=BooleanProperty.create("natural");
    public ImportedWillowLeavesBlock(){super(BlockBehaviour.Properties.copy(Blocks.AZALEA_LEAVES).noOcclusion());registerDefaultState(stateDefinition.any().setValue(FACING,Direction.UP).setValue(NATURAL,false));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(FACING,NATURAL);}
}
