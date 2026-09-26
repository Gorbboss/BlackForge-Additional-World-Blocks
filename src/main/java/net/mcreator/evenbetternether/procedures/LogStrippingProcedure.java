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
        if (event.getHand() != event.getEntity().getUsedItemHand()) {
            return;
        }
        LogStrippingProcedure.execute((Event)event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
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
        if ((entity instanceof LivingEntity && null != (_livEnt2 = (LivingEntity)entity) ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem && EvenbetternetherModBlocks.MUSHROOM_LOG.get() == world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock()) {
            ItemStack itemStack = entity instanceof LivingEntity && null != (_livEnt = (LivingEntity)entity) ? _livEnt.getMainHandItem() : (_ist = ItemStack.EMPTY);
            if (_ist.hurt(1, RandomSource.create(), null)) {
                _ist.shrink(1);
                _ist.setDamageValue(0);
            }
            _bp = BlockPos.containing((double)x, (double)y, (double)z);
            _bs = ((Block)EvenbetternetherModBlocks.STRIPPED_MUSHROOM_LOG.get()).defaultBlockState();
            _bso = world.getBlockState(_bp);
            for (Map.Entry entry : _bso.C().entrySet()) {
                _property2 = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                if (_property2 == null || _bs.getValue(_property2) == null) continue;
                try {
                    _bs = (BlockState)_bs.setValue(_property2, (Comparable)entry.getValue());
                } catch (Exception exception) {}
            }
            _be = world.getBlockEntity(_bp);
            _bnbt = null;
            if (_be != null) {
                _bnbt = _be.saveWithFullMetadata();
                _be.setRemoved();
            }
            world.setBlock(_bp, _bs, 3);
            if (_bnbt != null && (_be = world.getBlockEntity(_bp)) != null) {
                try {
                    _be.load(_bnbt);
                } catch (Exception _property2) {
                    // empty catch block
                }
            }
            if (entity instanceof LivingEntity) {
                _entity = (LivingEntity)entity;
                _entity.swing(InteractionHand.MAIN_HAND, true);
            }
            if (world instanceof Level) {
                _level = (Level)world;
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.strip")), SoundSource.BLOCKS, 1.0f, 1.0f);
                } else {
                    _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.strip")), SoundSource.BLOCKS, 1.0f, 1.0f, false);
                }
            }
        }
        if ((entity instanceof LivingEntity && null != (_livEnt2 = (LivingEntity)entity) ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem && EvenbetternetherModBlocks.MUSHROOM_WOOD.get() == world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock()) {
            ItemStack itemStack = entity instanceof LivingEntity && null != (_livEnt = (LivingEntity)entity) ? _livEnt.getMainHandItem() : (_ist = ItemStack.EMPTY);
            if (_ist.hurt(1, RandomSource.create(), null)) {
                _ist.shrink(1);
                _ist.setDamageValue(0);
            }
            _bp = BlockPos.containing((double)x, (double)y, (double)z);
            _bs = ((Block)EvenbetternetherModBlocks.STRIPPED_MUSHROOM_WOOD.get()).defaultBlockState();
            _bso = world.getBlockState(_bp);
            for (Map.Entry entry : _bso.C().entrySet()) {
                _property2 = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                if (_property2 == null || _bs.getValue(_property2) == null) continue;
                try {
                    _bs = (BlockState)_bs.setValue(_property2, (Comparable)entry.getValue());
                } catch (Exception exception) {}
            }
            _be = world.getBlockEntity(_bp);
            _bnbt = null;
            if (_be != null) {
                _bnbt = _be.saveWithFullMetadata();
                _be.setRemoved();
            }
            world.setBlock(_bp, _bs, 3);
            if (_bnbt != null && (_be = world.getBlockEntity(_bp)) != null) {
                try {
                    _be.load(_bnbt);
                } catch (Exception exception) {
                    // empty catch block
                }
            }
            if (entity instanceof LivingEntity) {
                _entity = (LivingEntity)entity;
                _entity.swing(InteractionHand.MAIN_HAND, true);
            }
            if (world instanceof Level) {
                _level = (Level)world;
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.strip")), SoundSource.BLOCKS, 1.0f, 1.0f);
                } else {
                    _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.strip")), SoundSource.BLOCKS, 1.0f, 1.0f, false);
                }
            }
        }
    }
}

