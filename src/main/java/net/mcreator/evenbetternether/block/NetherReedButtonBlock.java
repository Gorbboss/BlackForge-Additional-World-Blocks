/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.block.ButtonBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.properties.BlockSetType
 *  net.minecraft.world.level.material.MapColor
 */
package net.mcreator.evenbetternether.block;

import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;

public class NetherReedButtonBlock
extends ButtonBlock {
    public NetherReedButtonBlock() {
        super(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283743_).m_60918_(SoundType.f_243772_).m_60913_(2.0f, 1.0f).m_60988_(), BlockSetType.f_271479_, 20, false);
    }
}

