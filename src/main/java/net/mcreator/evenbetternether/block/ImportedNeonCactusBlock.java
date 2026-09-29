package net.mcreator.evenbetternether.block;

import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

/** Properties matching the imported Neon Cactus blockstate variants. */
public class ImportedNeonCactusBlock extends Block {
    public enum Shape implements StringRepresentable { BOTTOM, MIDDLE, TOP; public String getSerializedName() { return name().toLowerCase(); } }
    public enum Base implements StringRepresentable { EMPTY, MOSS, SAND; public String getSerializedName() { return name().toLowerCase(); } }
    public static final EnumProperty<Shape> SHAPE = EnumProperty.create("shape", Shape.class);
    public static final EnumProperty<Base> BOTTOM = EnumProperty.create("bottom", Base.class);
    public static final DirectionProperty FACING = net.minecraft.world.level.block.state.properties.BlockStateProperties.FACING;
    public ImportedNeonCactusBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.CACTUS).noOcclusion().lightLevel(state -> 10));
        registerDefaultState(stateDefinition.any().setValue(SHAPE, Shape.TOP).setValue(BOTTOM, Base.EMPTY).setValue(FACING, Direction.UP));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SHAPE, BOTTOM, FACING);
    }
}
