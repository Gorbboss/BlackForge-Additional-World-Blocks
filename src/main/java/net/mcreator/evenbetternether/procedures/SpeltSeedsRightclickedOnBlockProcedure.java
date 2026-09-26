/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.IntegerProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraftforge.registries.ForgeRegistries
 */
package net.mcreator.evenbetternether.procedures;

import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class SpeltSeedsRightclickedOnBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
        if (world.m_8055_(BlockPos.m_274561_((double)x, (double)y, (double)z)).m_60734_() == EvenbetternetherModBlocks.SOUL_FARMLAND.get() && world.m_8055_(BlockPos.m_274561_((double)x, (double)(y + 1.0), (double)z)).m_247087_()) {
            world.m_7731_(BlockPos.m_274561_((double)x, (double)(y + 1.0), (double)z), ((Block)EvenbetternetherModBlocks.SPELT_STAGE_0.get()).m_49966_(), 3);
            int _value = 1;
            BlockPos _pos = BlockPos.m_274561_((double)x, (double)(y + 1.0), (double)z);
            BlockState _bs = world.m_8055_(_pos);
            Property property = _bs.m_60734_().m_49965_().m_61081_("blockstate");
            if (property instanceof IntegerProperty _integerProp && _integerProp.m_6908_().contains(_value)) {
                world.m_7731_(_pos, (BlockState)_bs.m_61124_((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
            }
            itemstack.m_41774_(1);
            if (world instanceof Level) {
                Level _level = (Level)world;
                if (!_level.m_5776_()) {
                    _level.m_5594_(null, BlockPos.m_274561_((double)x, (double)y, (double)z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crop.plant")), SoundSource.BLOCKS, 1.0f, 1.0f);
                } else {
                    _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crop.plant")), SoundSource.BLOCKS, 1.0f, 1.0f, false);
                }
            }
        }
    }
}

