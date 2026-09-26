/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.AxeItem
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$RightClickBlock
 *  net.minecraftforge.eventbus.api.Event
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.registries.ForgeRegistries
 */
package net.mcreator.evenbetternether.procedures;

import java.util.Map;
import javax.annotation.Nullable;
import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber
public class LogStrippingProcedure {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() != event.getEntity().m_7655_()) {
            return;
        }
        LogStrippingProcedure.execute((Event)event, (LevelAccessor)event.getLevel(), event.getPos().m_123341_(), event.getPos().m_123342_(), event.getPos().m_123343_(), (Entity)event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        LogStrippingProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        Level _level;
        LivingEntity _entity;
        CompoundTag _bnbt;
        BlockEntity _be;
        Property _property2;
        BlockState _bso;
        BlockState _bs;
        BlockPos _bp;
        ItemStack _ist;
        LivingEntity _livEnt;
        LivingEntity _livEnt2;
        if (entity == null) {
            return;
        }
        if ((entity instanceof LivingEntity && null != (_livEnt2 = (LivingEntity)entity) ? _livEnt2.m_21205_() : ItemStack.f_41583_).m_41720_() instanceof AxeItem && EvenbetternetherModBlocks.MUSHROOM_LOG.get() == world.m_8055_(BlockPos.m_274561_((double)x, (double)y, (double)z)).m_60734_()) {
            ItemStack itemStack = entity instanceof LivingEntity && null != (_livEnt = (LivingEntity)entity) ? _livEnt.m_21205_() : (_ist = ItemStack.f_41583_);
            if (_ist.m_220157_(1, RandomSource.m_216327_(), null)) {
                _ist.m_41774_(1);
                _ist.m_41721_(0);
            }
            _bp = BlockPos.m_274561_((double)x, (double)y, (double)z);
            _bs = ((Block)EvenbetternetherModBlocks.STRIPPED_MUSHROOM_LOG.get()).m_49966_();
            _bso = world.m_8055_(_bp);
            for (Map.Entry entry : _bso.m_61148_().entrySet()) {
                _property2 = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                if (_property2 == null || _bs.m_61143_(_property2) == null) continue;
                try {
                    _bs = (BlockState)_bs.m_61124_(_property2, (Comparable)entry.getValue());
                } catch (Exception exception) {}
            }
            _be = world.m_7702_(_bp);
            _bnbt = null;
            if (_be != null) {
                _bnbt = _be.m_187480_();
                _be.m_7651_();
            }
            world.m_7731_(_bp, _bs, 3);
            if (_bnbt != null && (_be = world.m_7702_(_bp)) != null) {
                try {
                    _be.m_142466_(_bnbt);
                } catch (Exception _property2) {
                    // empty catch block
                }
            }
            if (entity instanceof LivingEntity) {
                _entity = (LivingEntity)entity;
                _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }
            if (world instanceof Level) {
                _level = (Level)world;
                if (!_level.m_5776_()) {
                    _level.m_5594_(null, BlockPos.m_274561_((double)x, (double)y, (double)z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.strip")), SoundSource.BLOCKS, 1.0f, 1.0f);
                } else {
                    _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.strip")), SoundSource.BLOCKS, 1.0f, 1.0f, false);
                }
            }
        }
        if ((entity instanceof LivingEntity && null != (_livEnt2 = (LivingEntity)entity) ? _livEnt2.m_21205_() : ItemStack.f_41583_).m_41720_() instanceof AxeItem && EvenbetternetherModBlocks.MUSHROOM_WOOD.get() == world.m_8055_(BlockPos.m_274561_((double)x, (double)y, (double)z)).m_60734_()) {
            ItemStack itemStack = entity instanceof LivingEntity && null != (_livEnt = (LivingEntity)entity) ? _livEnt.m_21205_() : (_ist = ItemStack.f_41583_);
            if (_ist.m_220157_(1, RandomSource.m_216327_(), null)) {
                _ist.m_41774_(1);
                _ist.m_41721_(0);
            }
            _bp = BlockPos.m_274561_((double)x, (double)y, (double)z);
            _bs = ((Block)EvenbetternetherModBlocks.STRIPPED_MUSHROOM_WOOD.get()).m_49966_();
            _bso = world.m_8055_(_bp);
            for (Map.Entry entry : _bso.m_61148_().entrySet()) {
                _property2 = _bs.m_60734_().m_49965_().m_61081_(((Property)entry.getKey()).m_61708_());
                if (_property2 == null || _bs.m_61143_(_property2) == null) continue;
                try {
                    _bs = (BlockState)_bs.m_61124_(_property2, (Comparable)entry.getValue());
                } catch (Exception exception) {}
            }
            _be = world.m_7702_(_bp);
            _bnbt = null;
            if (_be != null) {
                _bnbt = _be.m_187480_();
                _be.m_7651_();
            }
            world.m_7731_(_bp, _bs, 3);
            if (_bnbt != null && (_be = world.m_7702_(_bp)) != null) {
                try {
                    _be.m_142466_(_bnbt);
                } catch (Exception exception) {
                    // empty catch block
                }
            }
            if (entity instanceof LivingEntity) {
                _entity = (LivingEntity)entity;
                _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }
            if (world instanceof Level) {
                _level = (Level)world;
                if (!_level.m_5776_()) {
                    _level.m_5594_(null, BlockPos.m_274561_((double)x, (double)y, (double)z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.strip")), SoundSource.BLOCKS, 1.0f, 1.0f);
                } else {
                    _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.strip")), SoundSource.BLOCKS, 1.0f, 1.0f, false);
                }
            }
        }
    }
}

