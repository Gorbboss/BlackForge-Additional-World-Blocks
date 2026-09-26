/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock
 *  net.minecraft.world.level.block.HorizontalDirectionalBlock
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.SimpleWaterloggedBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$OffsetType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.AttachFace
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.DirectionProperty
 *  net.minecraft.world.level.block.state.properties.EnumProperty
 *  net.minecraft.world.level.block.state.properties.NoteBlockInstrument
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.material.Fluids
 *  net.minecraft.world.level.material.MapColor
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BoneSpeleothemBlock
extends Block
implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public BoneSpeleothemBlock() {
        super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.METAL).sound(SoundType.BONE_BLOCK).strength(1.0f, 10.0f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ));
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, (Comparable)Direction.NORTH)).setValue(FACE, (Comparable)AttachFace.WALL)).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }

    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(world, pos);
        return (switch ((Direction)state.getValue((Property)FACING)) {
            default -> {
                switch ((AttachFace)state.getValue(FACE)) {
                    default: {
                        throw new IncompatibleClassChangeError();
                    }
                    case FLOOR: {
                        yield Shapes.or((VoxelShape)BoneSpeleothemBlock.box((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)7.0, (double)13.0), (VoxelShape[])new VoxelShape[]{BoneSpeleothemBlock.box((double)4.0, (double)7.0, (double)4.0, (double)12.0, (double)13.0, (double)12.0), BoneSpeleothemBlock.box((double)5.0, (double)13.0, (double)5.0, (double)11.0, (double)19.0, (double)11.0), BoneSpeleothemBlock.box((double)7.0, (double)25.0, (double)7.0, (double)9.0, (double)32.0, (double)9.0), BoneSpeleothemBlock.box((double)6.0, (double)19.0, (double)6.0, (double)10.0, (double)25.0, (double)10.0)});
                    }
                    case WALL: {
                        yield Shapes.or((VoxelShape)BoneSpeleothemBlock.box((double)3.0, (double)3.0, (double)0.0, (double)13.0, (double)13.0, (double)7.0), (VoxelShape[])new VoxelShape[]{BoneSpeleothemBlock.box((double)4.0, (double)4.0, (double)7.0, (double)12.0, (double)12.0, (double)13.0), BoneSpeleothemBlock.box((double)5.0, (double)5.0, (double)13.0, (double)11.0, (double)11.0, (double)19.0), BoneSpeleothemBlock.box((double)7.0, (double)7.0, (double)25.0, (double)9.0, (double)9.0, (double)32.0), BoneSpeleothemBlock.box((double)6.0, (double)6.0, (double)19.0, (double)10.0, (double)10.0, (double)25.0)});
                    }
                    case CEILING: 
                }
                yield Shapes.or((VoxelShape)BoneSpeleothemBlock.box((double)3.0, (double)9.0, (double)3.0, (double)13.0, (double)16.0, (double)13.0), (VoxelShape[])new VoxelShape[]{BoneSpeleothemBlock.box((double)4.0, (double)3.0, (double)4.0, (double)12.0, (double)9.0, (double)12.0), BoneSpeleothemBlock.box((double)5.0, (double)-3.0, (double)5.0, (double)11.0, (double)3.0, (double)11.0), BoneSpeleothemBlock.box((double)7.0, (double)-16.0, (double)7.0, (double)9.0, (double)-9.0, (double)9.0), BoneSpeleothemBlock.box((double)6.0, (double)-9.0, (double)6.0, (double)10.0, (double)-3.0, (double)10.0)});
            }
            case Direction.NORTH -> {
                switch ((AttachFace)state.getValue(FACE)) {
                    default: {
                        throw new IncompatibleClassChangeError();
                    }
                    case FLOOR: {
                        yield Shapes.or((VoxelShape)BoneSpeleothemBlock.box((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)7.0, (double)13.0), (VoxelShape[])new VoxelShape[]{BoneSpeleothemBlock.box((double)4.0, (double)7.0, (double)4.0, (double)12.0, (double)13.0, (double)12.0), BoneSpeleothemBlock.box((double)5.0, (double)13.0, (double)5.0, (double)11.0, (double)19.0, (double)11.0), BoneSpeleothemBlock.box((double)7.0, (double)25.0, (double)7.0, (double)9.0, (double)32.0, (double)9.0), BoneSpeleothemBlock.box((double)6.0, (double)19.0, (double)6.0, (double)10.0, (double)25.0, (double)10.0)});
                    }
                    case WALL: {
                        yield Shapes.or((VoxelShape)BoneSpeleothemBlock.box((double)3.0, (double)3.0, (double)9.0, (double)13.0, (double)13.0, (double)16.0), (VoxelShape[])new VoxelShape[]{BoneSpeleothemBlock.box((double)4.0, (double)4.0, (double)3.0, (double)12.0, (double)12.0, (double)9.0), BoneSpeleothemBlock.box((double)5.0, (double)5.0, (double)-3.0, (double)11.0, (double)11.0, (double)3.0), BoneSpeleothemBlock.box((double)7.0, (double)7.0, (double)-16.0, (double)9.0, (double)9.0, (double)-9.0), BoneSpeleothemBlock.box((double)6.0, (double)6.0, (double)-9.0, (double)10.0, (double)10.0, (double)-3.0)});
                    }
                    case CEILING: 
                }
                yield Shapes.or((VoxelShape)BoneSpeleothemBlock.box((double)3.0, (double)9.0, (double)3.0, (double)13.0, (double)16.0, (double)13.0), (VoxelShape[])new VoxelShape[]{BoneSpeleothemBlock.box((double)4.0, (double)3.0, (double)4.0, (double)12.0, (double)9.0, (double)12.0), BoneSpeleothemBlock.box((double)5.0, (double)-3.0, (double)5.0, (double)11.0, (double)3.0, (double)11.0), BoneSpeleothemBlock.box((double)7.0, (double)-16.0, (double)7.0, (double)9.0, (double)-9.0, (double)9.0), BoneSpeleothemBlock.box((double)6.0, (double)-9.0, (double)6.0, (double)10.0, (double)-3.0, (double)10.0)});
            }
            case Direction.EAST -> {
                switch ((AttachFace)state.getValue(FACE)) {
                    default: {
                        throw new IncompatibleClassChangeError();
                    }
                    case FLOOR: {
                        yield Shapes.or((VoxelShape)BoneSpeleothemBlock.box((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)7.0, (double)13.0), (VoxelShape[])new VoxelShape[]{BoneSpeleothemBlock.box((double)4.0, (double)7.0, (double)4.0, (double)12.0, (double)13.0, (double)12.0), BoneSpeleothemBlock.box((double)5.0, (double)13.0, (double)5.0, (double)11.0, (double)19.0, (double)11.0), BoneSpeleothemBlock.box((double)7.0, (double)25.0, (double)7.0, (double)9.0, (double)32.0, (double)9.0), BoneSpeleothemBlock.box((double)6.0, (double)19.0, (double)6.0, (double)10.0, (double)25.0, (double)10.0)});
                    }
                    case WALL: {
                        yield Shapes.or((VoxelShape)BoneSpeleothemBlock.box((double)0.0, (double)3.0, (double)3.0, (double)7.0, (double)13.0, (double)13.0), (VoxelShape[])new VoxelShape[]{BoneSpeleothemBlock.box((double)7.0, (double)4.0, (double)4.0, (double)13.0, (double)12.0, (double)12.0), BoneSpeleothemBlock.box((double)13.0, (double)5.0, (double)5.0, (double)19.0, (double)11.0, (double)11.0), BoneSpeleothemBlock.box((double)25.0, (double)7.0, (double)7.0, (double)32.0, (double)9.0, (double)9.0), BoneSpeleothemBlock.box((double)19.0, (double)6.0, (double)6.0, (double)25.0, (double)10.0, (double)10.0)});
                    }
                    case CEILING: 
                }
                yield Shapes.or((VoxelShape)BoneSpeleothemBlock.box((double)3.0, (double)9.0, (double)3.0, (double)13.0, (double)16.0, (double)13.0), (VoxelShape[])new VoxelShape[]{BoneSpeleothemBlock.box((double)4.0, (double)3.0, (double)4.0, (double)12.0, (double)9.0, (double)12.0), BoneSpeleothemBlock.box((double)5.0, (double)-3.0, (double)5.0, (double)11.0, (double)3.0, (double)11.0), BoneSpeleothemBlock.box((double)7.0, (double)-16.0, (double)7.0, (double)9.0, (double)-9.0, (double)9.0), BoneSpeleothemBlock.box((double)6.0, (double)-9.0, (double)6.0, (double)10.0, (double)-3.0, (double)10.0)});
            }
            case Direction.WEST -> {
                switch ((AttachFace)state.getValue(FACE)) {
                    default: {
                        throw new IncompatibleClassChangeError();
                    }
                    case FLOOR: {
                        yield Shapes.or((VoxelShape)BoneSpeleothemBlock.box((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)7.0, (double)13.0), (VoxelShape[])new VoxelShape[]{BoneSpeleothemBlock.box((double)4.0, (double)7.0, (double)4.0, (double)12.0, (double)13.0, (double)12.0), BoneSpeleothemBlock.box((double)5.0, (double)13.0, (double)5.0, (double)11.0, (double)19.0, (double)11.0), BoneSpeleothemBlock.box((double)7.0, (double)25.0, (double)7.0, (double)9.0, (double)32.0, (double)9.0), BoneSpeleothemBlock.box((double)6.0, (double)19.0, (double)6.0, (double)10.0, (double)25.0, (double)10.0)});
                    }
                    case WALL: {
                        yield Shapes.or((VoxelShape)BoneSpeleothemBlock.box((double)9.0, (double)3.0, (double)3.0, (double)16.0, (double)13.0, (double)13.0), (VoxelShape[])new VoxelShape[]{BoneSpeleothemBlock.box((double)3.0, (double)4.0, (double)4.0, (double)9.0, (double)12.0, (double)12.0), BoneSpeleothemBlock.box((double)-3.0, (double)5.0, (double)5.0, (double)3.0, (double)11.0, (double)11.0), BoneSpeleothemBlock.box((double)-16.0, (double)7.0, (double)7.0, (double)-9.0, (double)9.0, (double)9.0), BoneSpeleothemBlock.box((double)-9.0, (double)6.0, (double)6.0, (double)-3.0, (double)10.0, (double)10.0)});
                    }
                    case CEILING: 
                }
                yield Shapes.or((VoxelShape)BoneSpeleothemBlock.box((double)3.0, (double)9.0, (double)3.0, (double)13.0, (double)16.0, (double)13.0), (VoxelShape[])new VoxelShape[]{BoneSpeleothemBlock.box((double)4.0, (double)3.0, (double)4.0, (double)12.0, (double)9.0, (double)12.0), BoneSpeleothemBlock.box((double)5.0, (double)-3.0, (double)5.0, (double)11.0, (double)3.0, (double)11.0), BoneSpeleothemBlock.box((double)7.0, (double)-16.0, (double)7.0, (double)9.0, (double)-9.0, (double)9.0), BoneSpeleothemBlock.box((double)6.0, (double)-9.0, (double)6.0, (double)10.0, (double)-3.0, (double)10.0)});
            }
        }).move(offset.x, offset.y, offset.z);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{FACING, FACE, WATERLOGGED});
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        return (BlockState)((BlockState)((BlockState)super.getStateForPlacement(context).setValue(FACE, (Comparable)this.faceForDirection(context.getNearestLookingDirection()))).setValue((Property)FACING, (Comparable)context.getHorizontalDirection().getOpposite())).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(flag));
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return (BlockState)state.setValue((Property)FACING, (Comparable)rot.rotate((Direction)state.getValue((Property)FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation((Direction)state.getValue((Property)FACING)));
    }

    private AttachFace faceForDirection(Direction direction) {
        if (direction.getAxis() == Direction.Axis.Y) {
            return direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR;
        }
        return AttachFace.WALL;
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue((Property)WATERLOGGED) != false ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        if (((Boolean)state.getValue((Property)WATERLOGGED)).booleanValue()) {
            world.scheduleTick(currentPos, (Fluid)Fluids.WATER, Fluids.WATER.getTickDelay((LevelReader)world));
        }
        return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }
}

