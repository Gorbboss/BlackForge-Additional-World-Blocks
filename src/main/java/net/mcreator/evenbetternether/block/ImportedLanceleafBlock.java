package net.mcreator.evenbetternether.block;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ImportedLanceleafBlock extends Block {
    public enum Shape implements StringRepresentable { TOP("top"),PRE_TOP("pre_top"),MIDDLE("middle"),PRE_BOTTOM("pre_bottom"),BOTTOM("bottom"); private final String n; Shape(String n){this.n=n;} public String getSerializedName(){return n;} }
    public static final EnumProperty<Shape> SHAPE=EnumProperty.create("shape",Shape.class);
    public static final IntegerProperty ROTATION=IntegerProperty.create("rotation",0,3);
    public ImportedLanceleafBlock(){super(BlockBehaviour.Properties.copy(Blocks.CHORUS_PLANT).noCollission().noOcclusion());registerDefaultState(stateDefinition.any().setValue(SHAPE,Shape.BOTTOM).setValue(ROTATION,0));}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState>b){b.add(SHAPE,ROTATION);}
}
