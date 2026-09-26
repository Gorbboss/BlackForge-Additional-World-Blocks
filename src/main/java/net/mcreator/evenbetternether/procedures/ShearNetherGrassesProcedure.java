/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraftforge.event.level.BlockEvent$BreakEvent
 *  net.minecraftforge.eventbus.api.Event
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 */
package net.mcreator.evenbetternether.procedures;

import javax.annotation.Nullable;
import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ShearNetherGrassesProcedure {
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        ShearNetherGrassesProcedure.execute((Event)event, event.getLevel(), event.getPos().m_123341_(), event.getPos().m_123342_(), event.getPos().m_123343_(), (Entity)event.getPlayer());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        ShearNetherGrassesProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        LivingEntity _livEnt;
        if (entity == null) {
            return;
        }
        if ((entity instanceof LivingEntity && null != (_livEnt = (LivingEntity)entity) ? _livEnt.m_21205_() : ItemStack.f_41583_).m_41720_() == Items.f_42574_) {
            ItemEntity entityToSpawn;
            ServerLevel _level;
            ItemStack _ist;
            LivingEntity _livEnt2;
            if (EvenbetternetherModBlocks.VERDANT_ROOTS.get() == world.m_8055_(BlockPos.m_274561_((double)x, (double)y, (double)z)).m_60734_()) {
                ItemStack itemStack = entity instanceof LivingEntity && null != (_livEnt2 = (LivingEntity)entity) ? _livEnt2.m_21205_() : (_ist = ItemStack.f_41583_);
                if (_ist.m_220157_(1, RandomSource.m_216327_(), null)) {
                    _ist.m_41774_(1);
                    _ist.m_41721_(0);
                }
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)EvenbetternetherModBlocks.VERDANT_ROOTS.get()));
                    entityToSpawn.m_32010_(10);
                    _level.m_7967_((Entity)entityToSpawn);
                }
            }
            if (EvenbetternetherModBlocks.VERDANT_SPROUTS.get() == world.m_8055_(BlockPos.m_274561_((double)x, (double)y, (double)z)).m_60734_()) {
                ItemStack itemStack = entity instanceof LivingEntity && null != (_livEnt2 = (LivingEntity)entity) ? _livEnt2.m_21205_() : (_ist = ItemStack.f_41583_);
                if (_ist.m_220157_(1, RandomSource.m_216327_(), null)) {
                    _ist.m_41774_(1);
                    _ist.m_41721_(0);
                }
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)EvenbetternetherModBlocks.VERDANT_SPROUTS.get()));
                    entityToSpawn.m_32010_(10);
                    _level.m_7967_((Entity)entityToSpawn);
                }
            }
            if (EvenbetternetherModBlocks.NETHER_AGAVE.get() == world.m_8055_(BlockPos.m_274561_((double)x, (double)y, (double)z)).m_60734_()) {
                ItemStack itemStack = entity instanceof LivingEntity && null != (_livEnt2 = (LivingEntity)entity) ? _livEnt2.m_21205_() : (_ist = ItemStack.f_41583_);
                if (_ist.m_220157_(1, RandomSource.m_216327_(), null)) {
                    _ist.m_41774_(1);
                    _ist.m_41721_(0);
                }
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)EvenbetternetherModBlocks.NETHER_AGAVE.get()));
                    entityToSpawn.m_32010_(10);
                    _level.m_7967_((Entity)entityToSpawn);
                }
            }
            if (EvenbetternetherModBlocks.SOUL_ROOTS.get() == world.m_8055_(BlockPos.m_274561_((double)x, (double)y, (double)z)).m_60734_()) {
                ItemStack itemStack = entity instanceof LivingEntity && null != (_livEnt2 = (LivingEntity)entity) ? _livEnt2.m_21205_() : (_ist = ItemStack.f_41583_);
                if (_ist.m_220157_(1, RandomSource.m_216327_(), null)) {
                    _ist.m_41774_(1);
                    _ist.m_41721_(0);
                }
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)EvenbetternetherModBlocks.SOUL_ROOTS.get()));
                    entityToSpawn.m_32010_(10);
                    _level.m_7967_((Entity)entityToSpawn);
                }
            }
            if (EvenbetternetherModBlocks.SOUL_SPROUTS.get() == world.m_8055_(BlockPos.m_274561_((double)x, (double)y, (double)z)).m_60734_()) {
                ItemStack itemStack = entity instanceof LivingEntity && null != (_livEnt2 = (LivingEntity)entity) ? _livEnt2.m_21205_() : (_ist = ItemStack.f_41583_);
                if (_ist.m_220157_(1, RandomSource.m_216327_(), null)) {
                    _ist.m_41774_(1);
                    _ist.m_41721_(0);
                }
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)EvenbetternetherModBlocks.SOUL_SPROUTS.get()));
                    entityToSpawn.m_32010_(10);
                    _level.m_7967_((Entity)entityToSpawn);
                }
            }
            if (EvenbetternetherModBlocks.BURNING_ROOTS.get() == world.m_8055_(BlockPos.m_274561_((double)x, (double)y, (double)z)).m_60734_()) {
                ItemStack itemStack = entity instanceof LivingEntity && null != (_livEnt2 = (LivingEntity)entity) ? _livEnt2.m_21205_() : (_ist = ItemStack.f_41583_);
                if (_ist.m_220157_(1, RandomSource.m_216327_(), null)) {
                    _ist.m_41774_(1);
                    _ist.m_41721_(0);
                }
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)EvenbetternetherModBlocks.BURNING_ROOTS.get()));
                    entityToSpawn.m_32010_(10);
                    _level.m_7967_((Entity)entityToSpawn);
                }
            }
            if (EvenbetternetherModBlocks.BURNING_SPROUTS.get() == world.m_8055_(BlockPos.m_274561_((double)x, (double)y, (double)z)).m_60734_()) {
                ItemStack itemStack = entity instanceof LivingEntity && null != (_livEnt2 = (LivingEntity)entity) ? _livEnt2.m_21205_() : (_ist = ItemStack.f_41583_);
                if (_ist.m_220157_(1, RandomSource.m_216327_(), null)) {
                    _ist.m_41774_(1);
                    _ist.m_41721_(0);
                }
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)EvenbetternetherModBlocks.BURNING_SPROUTS.get()));
                    entityToSpawn.m_32010_(10);
                    _level.m_7967_((Entity)entityToSpawn);
                }
            }
            if (EvenbetternetherModBlocks.CHARRED_SPROUTS.get() == world.m_8055_(BlockPos.m_274561_((double)x, (double)y, (double)z)).m_60734_()) {
                ItemStack itemStack = entity instanceof LivingEntity && null != (_livEnt2 = (LivingEntity)entity) ? _livEnt2.m_21205_() : (_ist = ItemStack.f_41583_);
                if (_ist.m_220157_(1, RandomSource.m_216327_(), null)) {
                    _ist.m_41774_(1);
                    _ist.m_41721_(0);
                }
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)EvenbetternetherModBlocks.CHARRED_SPROUTS.get()));
                    entityToSpawn.m_32010_(10);
                    _level.m_7967_((Entity)entityToSpawn);
                }
            }
            if (EvenbetternetherModBlocks.FUNGAL_ROOTS.get() == world.m_8055_(BlockPos.m_274561_((double)x, (double)y, (double)z)).m_60734_()) {
                ItemStack itemStack = entity instanceof LivingEntity && null != (_livEnt2 = (LivingEntity)entity) ? _livEnt2.m_21205_() : (_ist = ItemStack.f_41583_);
                if (_ist.m_220157_(1, RandomSource.m_216327_(), null)) {
                    _ist.m_41774_(1);
                    _ist.m_41721_(0);
                }
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)EvenbetternetherModBlocks.FUNGAL_ROOTS.get()));
                    entityToSpawn.m_32010_(10);
                    _level.m_7967_((Entity)entityToSpawn);
                }
            }
            if (EvenbetternetherModBlocks.FUNGAL_SPROUTS.get() == world.m_8055_(BlockPos.m_274561_((double)x, (double)y, (double)z)).m_60734_()) {
                ItemStack itemStack = entity instanceof LivingEntity && null != (_livEnt2 = (LivingEntity)entity) ? _livEnt2.m_21205_() : (_ist = ItemStack.f_41583_);
                if (_ist.m_220157_(1, RandomSource.m_216327_(), null)) {
                    _ist.m_41774_(1);
                    _ist.m_41721_(0);
                }
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)EvenbetternetherModBlocks.FUNGAL_SPROUTS.get()));
                    entityToSpawn.m_32010_(10);
                    _level.m_7967_((Entity)entityToSpawn);
                }
            }
        }
    }
}

