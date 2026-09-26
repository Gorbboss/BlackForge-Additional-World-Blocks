/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraftforge.registries.ForgeRegistries
 */
package net.mcreator.evenbetternether.procedures;

import java.text.DecimalFormat;
import java.util.Locale;
import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class SpeltStage0OnBoneMealSuccessProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        double SpeltStage = 0.0;
        String TempText = "";
        if (world.m_8055_(BlockPos.m_274561_((double)x, (double)y, (double)z)).m_60734_() != EvenbetternetherModBlocks.SPELT_STAGE_6.get()) {
            TempText = ForgeRegistries.BLOCKS.getKey((Object)world.m_8055_(BlockPos.m_274561_((double)x, (double)y, (double)z)).m_60734_()).toString();
            TempText = TempText.substring(TempText.indexOf(":") + 1, TempText.length());
            TempText = TempText.substring(12);
            SpeltStage = new Object(){

                double convert(String s) {
                    try {
                        return Double.parseDouble(s.trim());
                    } catch (Exception exception) {
                        return 0.0;
                    }
                }
            }.convert(TempText);
            if ((SpeltStage += (double)Mth.m_216271_((RandomSource)RandomSource.m_216327_(), (int)2, (int)5)) > 6.0) {
                SpeltStage = 6.0;
            }
            world.m_7731_(BlockPos.m_274561_((double)x, (double)y, (double)z), ((Block)ForgeRegistries.BLOCKS.getValue(new ResourceLocation(("evenbetternether:spelt_stage_" + new DecimalFormat("##").format(SpeltStage)).toLowerCase(Locale.ENGLISH)))).m_49966_(), 3);
        }
    }
}

