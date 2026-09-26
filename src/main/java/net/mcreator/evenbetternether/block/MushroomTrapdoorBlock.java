/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.TrapDoorBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.properties.BlockSetType
 *  net.minecraft.world.level.block.state.properties.NoteBlockInstrument
 *  net.minecraft.world.level.material.MapColor
 */
package net.mcreator.evenbetternether.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class MushroomTrapdoorBlock
extends TrapDoorBlock {
    public MushroomTrapdoorBlock() {
        super(BlockBehaviour.Properties.m_284310_().m_278183_().m_280658_(NoteBlockInstrument.BASS).m_284180_(MapColor.f_283832_).m_60918_(SoundType.f_244244_).m_60913_(2.0f, 3.0f).m_60955_().m_60924_((bs, br, bp) -> false).m_60988_(), BlockSetType.f_271198_);
    }
}

