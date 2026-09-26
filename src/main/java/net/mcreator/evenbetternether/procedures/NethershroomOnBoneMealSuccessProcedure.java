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

public class NethershroomOnBoneMealSuccessProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        EnumProperty _enumProp;
        world.m_7731_(BlockPos.m_274561_((double)x, (double)y, (double)z), Blocks.f_50016_.m_49966_(), 3);
        world.m_7731_(BlockPos.m_274561_((double)x, (double)y, (double)z), ((Block)EvenbetternetherModBlocks.TALL_NETHERSHROOM.get()).m_49966_(), 3);
        String _value = "lower";
        BlockPos _pos = BlockPos.m_274561_((double)x, (double)y, (double)z);
        BlockState _bs = world.m_8055_(_pos);
        Property property = _bs.m_60734_().m_49965_().m_61081_("half");
        if (property instanceof EnumProperty && (_enumProp = (EnumProperty)property).m_6215_(_value).isPresent()) {
            world.m_7731_(_pos, (BlockState)_bs.m_61124_((Property)_enumProp, (Comparable)((Object)((Enum)_enumProp.m_6215_(_value).get()))), 3);
        }
        world.m_7731_(BlockPos.m_274561_((double)x, (double)(y + 1.0), (double)z), ((Block)EvenbetternetherModBlocks.TALL_NETHERSHROOM.get()).m_49966_(), 3);
        _value = "upper";
        _pos = BlockPos.m_274561_((double)x, (double)(y + 1.0), (double)z);
        _bs = world.m_8055_(_pos);
        property = _bs.m_60734_().m_49965_().m_61081_("half");
        if (property instanceof EnumProperty && (_enumProp = (EnumProperty)property).m_6215_(_value).isPresent()) {
            world.m_7731_(_pos, (BlockState)_bs.m_61124_((Property)_enumProp, (Comparable)((Object)((Enum)_enumProp.m_6215_(_value).get()))), 3);
        }
    }
}

