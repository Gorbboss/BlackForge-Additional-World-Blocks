/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.EnumProperty
 *  net.minecraft.world.level.block.state.properties.Property
 */
package net.mcreator.evenbetternether.procedures;

import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class BrownNethershroomOnBoneMealSuccessProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        EnumProperty _enumProp;
        world.setBlock(BlockPos.containing((double)x, (double)y, (double)z), Blocks.AIR.defaultBlockState(), 3);
        world.setBlock(BlockPos.containing((double)x, (double)y, (double)z), ((Block)EvenbetternetherModBlocks.TALL_BROWN_NETHERSHROOM.get()).defaultBlockState(), 3);
        String _value = "lower";
        BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
        BlockState _bs = world.getBlockState(_pos);
        Property property = _bs.getBlock().getStateDefinition().getProperty("half");
        if (property instanceof EnumProperty && (_enumProp = (EnumProperty)property).getValue(_value).isPresent()) {
            world.setBlock(_pos, (BlockState)_bs.setValue((Property)_enumProp, (Comparable)((Object)((Enum)_enumProp.getValue(_value).get()))), 3);
        }
        world.setBlock(BlockPos.containing((double)x, (double)(y + 1.0), (double)z), ((Block)EvenbetternetherModBlocks.TALL_BROWN_NETHERSHROOM.get()).defaultBlockState(), 3);
        _value = "upper";
        _pos = BlockPos.containing((double)x, (double)(y + 1.0), (double)z);
        _bs = world.getBlockState(_pos);
        property = _bs.getBlock().getStateDefinition().getProperty("half");
        if (property instanceof EnumProperty && (_enumProp = (EnumProperty)property).getValue(_value).isPresent()) {
            world.setBlock(_pos, (BlockState)_bs.setValue((Property)_enumProp, (Comparable)((Object)((Enum)_enumProp.getValue(_value).get()))), 3);
        }
    }
}

