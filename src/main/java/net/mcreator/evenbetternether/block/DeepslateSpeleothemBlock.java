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

public class DeepslateSpeleothemBlock
extends Block
implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.f_54117_;
    public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.f_53179_;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.f_61362_;

    public DeepslateSpeleothemBlock() {
        super(BlockBehaviour.Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_284180_(MapColor.f_283875_).m_60918_(SoundType.f_154677_).m_60913_(2.0f, 10.0f).m_60999_().m_60955_().m_60924_((bs, br, bp) -> false).m_60988_().m_222979_(BlockBehaviour.OffsetType.XZ));
        this.m_49959_((BlockState)((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)FACING, (Comparable)Direction.NORTH)).m_61124_(FACE, (Comparable)AttachFace.WALL)).m_61124_((Property)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    public boolean m_7420_(BlockState state, BlockGetter reader, BlockPos pos) {
        return state.m_60819_().m_76178_();
    }

    public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }

    public VoxelShape m_5909_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.m_83040_();
    }

    public VoxelShape m_5940_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.m_60824_(world, pos);
        return (switch ((Direction)state.m_61143_((Property)FACING)) {
            default -> {
                switch ((AttachFace)state.m_61143_(FACE)) {
                    default: {
                        throw new IncompatibleClassChangeError();
                    }
                    case FLOOR: {
                        yield Shapes.m_83124_((VoxelShape)DeepslateSpeleothemBlock.m_49796_((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)7.0, (double)13.0), (VoxelShape[])new VoxelShape[]{DeepslateSpeleothemBlock.m_49796_((double)4.0, (double)7.0, (double)4.0, (double)12.0, (double)13.0, (double)12.0), DeepslateSpeleothemBlock.m_49796_((double)5.0, (double)13.0, (double)5.0, (double)11.0, (double)19.0, (double)11.0), DeepslateSpeleothemBlock.m_49796_((double)7.0, (double)25.0, (double)7.0, (double)9.0, (double)32.0, (double)9.0), DeepslateSpeleothemBlock.m_49796_((double)6.0, (double)19.0, (double)6.0, (double)10.0, (double)25.0, (double)10.0)});
                    }
                    case WALL: {
                        yield Shapes.m_83124_((VoxelShape)DeepslateSpeleothemBlock.m_49796_((double)3.0, (double)3.0, (double)0.0, (double)13.0, (double)13.0, (double)7.0), (VoxelShape[])new VoxelShape[]{DeepslateSpeleothemBlock.m_49796_((double)4.0, (double)4.0, (double)7.0, (double)12.0, (double)12.0, (double)13.0), DeepslateSpeleothemBlock.m_49796_((double)5.0, (double)5.0, (double)13.0, (double)11.0, (double)11.0, (double)19.0), DeepslateSpeleothemBlock.m_49796_((double)7.0, (double)7.0, (double)25.0, (double)9.0, (double)9.0, (double)32.0), DeepslateSpeleothemBlock.m_49796_((double)6.0, (double)6.0, (double)19.0, (double)10.0, (double)10.0, (double)25.0)});
                    }
                    case CEILING: 
                }
                yield Shapes.m_83124_((VoxelShape)DeepslateSpeleothemBlock.m_49796_((double)3.0, (double)9.0, (double)3.0, (double)13.0, (double)16.0, (double)13.0), (VoxelShape[])new VoxelShape[]{DeepslateSpeleothemBlock.m_49796_((double)4.0, (double)3.0, (double)4.0, (double)12.0, (double)9.0, (double)12.0), DeepslateSpeleothemBlock.m_49796_((double)5.0, (double)-3.0, (double)5.0, (double)11.0, (double)3.0, (double)11.0), DeepslateSpeleothemBlock.m_49796_((double)7.0, (double)-16.0, (double)7.0, (double)9.0, (double)-9.0, (double)9.0), DeepslateSpeleothemBlock.m_49796_((double)6.0, (double)-9.0, (double)6.0, (double)10.0, (double)-3.0, (double)10.0)});
            }
            case Direction.NORTH -> {
                switch ((AttachFace)state.m_61143_(FACE)) {
                    default: {
                        throw new IncompatibleClassChangeError();
                    }
                    case FLOOR: {
                        yield Shapes.m_83124_((VoxelShape)DeepslateSpeleothemBlock.m_49796_((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)7.0, (double)13.0), (VoxelShape[])new VoxelShape[]{DeepslateSpeleothemBlock.m_49796_((double)4.0, (double)7.0, (double)4.0, (double)12.0, (double)13.0, (double)12.0), DeepslateSpeleothemBlock.m_49796_((double)5.0, (double)13.0, (double)5.0, (double)11.0, (double)19.0, (double)11.0), DeepslateSpeleothemBlock.m_49796_((double)7.0, (double)25.0, (double)7.0, (double)9.0, (double)32.0, (double)9.0), DeepslateSpeleothemBlock.m_49796_((double)6.0, (double)19.0, (double)6.0, (double)10.0, (double)25.0, (double)10.0)});
                    }
                    case WALL: {
                        yield Shapes.m_83124_((VoxelShape)DeepslateSpeleothemBlock.m_49796_((double)3.0, (double)3.0, (double)9.0, (double)13.0, (double)13.0, (double)16.0), (VoxelShape[])new VoxelShape[]{DeepslateSpeleothemBlock.m_49796_((double)4.0, (double)4.0, (double)3.0, (double)12.0, (double)12.0, (double)9.0), DeepslateSpeleothemBlock.m_49796_((double)5.0, (double)5.0, (double)-3.0, (double)11.0, (double)11.0, (double)3.0), DeepslateSpeleothemBlock.m_49796_((double)7.0, (double)7.0, (double)-16.0, (double)9.0, (double)9.0, (double)-9.0), DeepslateSpeleothemBlock.m_49796_((double)6.0, (double)6.0, (double)-9.0, (double)10.0, (double)10.0, (double)-3.0)});
                    }
                    case CEILING: 
                }
                yield Shapes.m_83124_((VoxelShape)DeepslateSpeleothemBlock.m_49796_((double)3.0, (double)9.0, (double)3.0, (double)13.0, (double)16.0, (double)13.0), (VoxelShape[])new VoxelShape[]{DeepslateSpeleothemBlock.m_49796_((double)4.0, (double)3.0, (double)4.0, (double)12.0, (double)9.0, (double)12.0), DeepslateSpeleothemBlock.m_49796_((double)5.0, (double)-3.0, (double)5.0, (double)11.0, (double)3.0, (double)11.0), DeepslateSpeleothemBlock.m_49796_((double)7.0, (double)-16.0, (double)7.0, (double)9.0, (double)-9.0, (double)9.0), DeepslateSpeleothemBlock.m_49796_((double)6.0, (double)-9.0, (double)6.0, (double)10.0, (double)-3.0, (double)10.0)});
            }
            case Direction.EAST -> {
                switch ((AttachFace)state.m_61143_(FACE)) {
                    default: {
                        throw new IncompatibleClassChangeError();
                    }
                    case FLOOR: {
                        yield Shapes.m_83124_((VoxelShape)DeepslateSpeleothemBlock.m_49796_((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)7.0, (double)13.0), (VoxelShape[])new VoxelShape[]{DeepslateSpeleothemBlock.m_49796_((double)4.0, (double)7.0, (double)4.0, (double)12.0, (double)13.0, (double)12.0), DeepslateSpeleothemBlock.m_49796_((double)5.0, (double)13.0, (double)5.0, (double)11.0, (double)19.0, (double)11.0), DeepslateSpeleothemBlock.m_49796_((double)7.0, (double)25.0, (double)7.0, (double)9.0, (double)32.0, (double)9.0), DeepslateSpeleothemBlock.m_49796_((double)6.0, (double)19.0, (double)6.0, (double)10.0, (double)25.0, (double)10.0)});
                    }
                    case WALL: {
                        yield Shapes.m_83124_((VoxelShape)DeepslateSpeleothemBlock.m_49796_((double)0.0, (double)3.0, (double)3.0, (double)7.0, (double)13.0, (double)13.0), (VoxelShape[])new VoxelShape[]{DeepslateSpeleothemBlock.m_49796_((double)7.0, (double)4.0, (double)4.0, (double)13.0, (double)12.0, (double)12.0), DeepslateSpeleothemBlock.m_49796_((double)13.0, (double)5.0, (double)5.0, (double)19.0, (double)11.0, (double)11.0), DeepslateSpeleothemBlock.m_49796_((double)25.0, (double)7.0, (double)7.0, (double)32.0, (double)9.0, (double)9.0), DeepslateSpeleothemBlock.m_49796_((double)19.0, (double)6.0, (double)6.0, (double)25.0, (double)10.0, (double)10.0)});
                    }
                    case CEILING: 
                }
                yield Shapes.m_83124_((VoxelShape)DeepslateSpeleothemBlock.m_49796_((double)3.0, (double)9.0, (double)3.0, (double)13.0, (double)16.0, (double)13.0), (VoxelShape[])new VoxelShape[]{DeepslateSpeleothemBlock.m_49796_((double)4.0, (double)3.0, (double)4.0, (double)12.0, (double)9.0, (double)12.0), DeepslateSpeleothemBlock.m_49796_((double)5.0, (double)-3.0, (double)5.0, (double)11.0, (double)3.0, (double)11.0), DeepslateSpeleothemBlock.m_49796_((double)7.0, (double)-16.0, (double)7.0, (double)9.0, (double)-9.0, (double)9.0), DeepslateSpeleothemBlock.m_49796_((double)6.0, (double)-9.0, (double)6.0, (double)10.0, (double)-3.0, (double)10.0)});
            }
            case Direction.WEST -> {
                switch ((AttachFace)state.m_61143_(FACE)) {
                    default: {
                        throw new IncompatibleClassChangeError();
                    }
                    case FLOOR: {
                        yield Shapes.m_83124_((VoxelShape)DeepslateSpeleothemBlock.m_49796_((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)7.0, (double)13.0), (VoxelShape[])new VoxelShape[]{DeepslateSpeleothemBlock.m_49796_((double)4.0, (double)7.0, (double)4.0, (double)12.0, (double)13.0, (double)12.0), DeepslateSpeleothemBlock.m_49796_((double)5.0, (double)13.0, (double)5.0, (double)11.0, (double)19.0, (double)11.0), DeepslateSpeleothemBlock.m_49796_((double)7.0, (double)25.0, (double)7.0, (double)9.0, (double)32.0, (double)9.0), DeepslateSpeleothemBlock.m_49796_((double)6.0, (double)19.0, (double)6.0, (double)10.0, (double)25.0, (double)10.0)});
                    }
                    case WALL: {
                        yield Shapes.m_83124_((VoxelShape)DeepslateSpeleothemBlock.m_49796_((double)9.0, (double)3.0, (double)3.0, (double)16.0, (double)13.0, (double)13.0), (VoxelShape[])new VoxelShape[]{DeepslateSpeleothemBlock.m_49796_((double)3.0, (double)4.0, (double)4.0, (double)9.0, (double)12.0, (double)12.0), DeepslateSpeleothemBlock.m_49796_((double)-3.0, (double)5.0, (double)5.0, (double)3.0, (double)11.0, (double)11.0), DeepslateSpeleothemBlock.m_49796_((double)-16.0, (double)7.0, (double)7.0, (double)-9.0, (double)9.0, (double)9.0), DeepslateSpeleothemBlock.m_49796_((double)-9.0, (double)6.0, (double)6.0, (double)-3.0, (double)10.0, (double)10.0)});
                    }
                    case CEILING: 
                }
                yield Shapes.m_83124_((VoxelShape)DeepslateSpeleothemBlock.m_49796_((double)3.0, (double)9.0, (double)3.0, (double)13.0, (double)16.0, (double)13.0), (VoxelShape[])new VoxelShape[]{DeepslateSpeleothemBlock.m_49796_((double)4.0, (double)3.0, (double)4.0, (double)12.0, (double)9.0, (double)12.0), DeepslateSpeleothemBlock.m_49796_((double)5.0, (double)-3.0, (double)5.0, (double)11.0, (double)3.0, (double)11.0), DeepslateSpeleothemBlock.m_49796_((double)7.0, (double)-16.0, (double)7.0, (double)9.0, (double)-9.0, (double)9.0), DeepslateSpeleothemBlock.m_49796_((double)6.0, (double)-9.0, (double)6.0, (double)10.0, (double)-3.0, (double)10.0)});
            }
        }).m_83216_(offset.f_82479_, offset.f_82480_, offset.f_82481_);
    }

    protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_(builder);
        builder.m_61104_(new Property[]{FACING, FACE, WATERLOGGED});
    }

    public BlockState m_5573_(BlockPlaceContext context) {
        boolean flag = context.m_43725_().m_6425_(context.m_8083_()).m_76152_() == Fluids.f_76193_;
        return (BlockState)((BlockState)((BlockState)super.m_5573_(context).m_61124_(FACE, (Comparable)this.faceForDirection(context.m_7820_()))).m_61124_((Property)FACING, (Comparable)context.m_8125_().m_122424_())).m_61124_((Property)WATERLOGGED, (Comparable)Boolean.valueOf(flag));
    }

    public BlockState m_6843_(BlockState state, Rotation rot) {
        return (BlockState)state.m_61124_((Property)FACING, (Comparable)rot.m_55954_((Direction)state.m_61143_((Property)FACING)));
    }

    public BlockState m_6943_(BlockState state, Mirror mirrorIn) {
        return state.m_60717_(mirrorIn.m_54846_((Direction)state.m_61143_((Property)FACING)));
    }

    private AttachFace faceForDirection(Direction direction) {
        if (direction.m_122434_() == Direction.Axis.Y) {
            return direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR;
        }
        return AttachFace.WALL;
    }

    public FluidState m_5888_(BlockState state) {
        return (Boolean)state.m_61143_((Property)WATERLOGGED) != false ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }

    public BlockState m_7417_(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        if (((Boolean)state.m_61143_((Property)WATERLOGGED)).booleanValue()) {
            world.m_186469_(currentPos, (Fluid)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)world));
        }
        return super.m_7417_(state, facing, facingState, world, currentPos, facingPos);
    }
}

