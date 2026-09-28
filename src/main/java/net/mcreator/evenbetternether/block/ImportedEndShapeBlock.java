package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/** Shared state carrier for BetterEnd's generated top/middle/bottom plant pieces. */
public class ImportedEndShapeBlock extends Block {
    public enum Shape implements StringRepresentable {
        TOP("top"), MIDDLE("middle"), BOTTOM("bottom"), ROOTS("roots"), VINE("vine"),
        FLOWER_BIG_BOTTOM("flower_big_bottom"), FLOWER_BIG_TOP("flower_big_top"),
        FLOWER_SMALL_BOTTOM("flower_small_bottom"), FLOWER_SMALL_TOP("flower_small_top");
        private final String name;
        Shape(String name) { this.name = name; }
        @Override public String getSerializedName() { return name; }
    }
    public static final EnumProperty<Shape> SHAPE = EnumProperty.create("shape", Shape.class);
    public ImportedEndShapeBlock(Shape defaultShape, int light) {
        super(BlockBehaviour.Properties.copy(Blocks.CHORUS_PLANT).noCollission().noOcclusion().lightLevel(state -> light));
        registerDefaultState(stateDefinition.any().setValue(SHAPE, defaultShape));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) { builder.add(SHAPE); }
    @Override public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) { return box(2, 0, 2, 14, 16, 14); }
}
