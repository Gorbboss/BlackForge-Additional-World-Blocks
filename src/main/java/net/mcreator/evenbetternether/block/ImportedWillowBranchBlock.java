package net.mcreator.evenbetternether.block;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class ImportedWillowBranchBlock extends Block {
    public enum Shape implements StringRepresentable { MIDDLE("middle"),END("end");private final String n;Shape(String n){this.n=n;}public String getSerializedName(){return n;}}
    public static final EnumProperty<Shape> SHAPE=EnumProperty.create("shape",Shape.class);
    public ImportedWillowBranchBlock(){super(BlockBehaviour.Properties.copy(Blocks.WEEPING_VINES).noCollission().noOcclusion());registerDefaultState(stateDefinition.any().setValue(SHAPE,Shape.MIDDLE));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(SHAPE);}
}
