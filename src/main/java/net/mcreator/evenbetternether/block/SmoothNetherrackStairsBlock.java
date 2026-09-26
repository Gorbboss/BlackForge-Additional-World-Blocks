/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.StairBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.NoteBlockInstrument
 *  net.minecraft.world.level.material.MapColor
 */
package net.mcreator.evenbetternether.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class SmoothNetherrackStairsBlock
extends StairBlock {
    public SmoothNetherrackStairsBlock() {
        super(() -> Blocks.f_50016_.m_49966_(), BlockBehaviour.Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_284180_(MapColor.f_283820_).m_60918_(SoundType.f_56720_).m_60913_(1.0f, 10.0f).m_60999_().m_60988_());
    }

    public float m_7325_() {
        return 10.0f;
    }

    public boolean m_6724_(BlockState state) {
        return false;
    }
}

