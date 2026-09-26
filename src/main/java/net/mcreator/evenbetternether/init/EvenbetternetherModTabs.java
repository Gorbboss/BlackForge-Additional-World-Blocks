/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.item.CreativeModeTab
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.block.Block
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.RegistryObject
 */
package net.mcreator.evenbetternether.init;

import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.mcreator.evenbetternether.init.EvenbetternetherModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EvenbetternetherModTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create((ResourceKey)Registries.f_279569_, (String)"evenbetternether");
    public static final RegistryObject<CreativeModeTab> EVEN_BETTER_NETHER_TAB = REGISTRY.register("even_better_nether_tab", () -> CreativeModeTab.builder().m_257941_((Component)Component.m_237115_((String)"item_group.evenbetternether.even_better_nether_tab")).m_257737_(() -> new ItemStack((ItemLike)EvenbetternetherModBlocks.VERDANT_NYLIUM.get())).m_257501_((parameters, tabData) -> {
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.VERDANT_NYLIUM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.VERDANT_ROOTS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.VERDANT_SPROUTS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.BONE_GROWTHS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.SMOOTH_BONE_BLOCK.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.SMOOTH_BONE_STAIRS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.SMOOTH_BONE_SLAB.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.SMOOTH_BONE_WALL.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.BONE_SPELEOTHEM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.WITHERED_NYLIUM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.BURNING_ROOTS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.BURNING_SPROUTS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.CHARRED_SPROUTS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.WITHER_BONE_GROWTHS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NYCELIUM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_WOOD.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_LOG.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.STRIPPED_MUSHROOM_LOG.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.STRIPPED_MUSHROOM_WOOD.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_PLANKS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_STAIRS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_SLAB.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_FENCE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_FENCE_GATE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_PRESSURE_PLATE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_BUTTON.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_DOOR.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_TRAPDOOR.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_MUSHROOM_CAP.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHERSHROOM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.TALL_NETHERSHROOM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.BROWN_NETHER_MUSHROOM_CAP.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.BROWN_NETHERSHROOM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.TALL_BROWN_NETHERSHROOM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.FUNGAL_ROOTS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.FUNGAL_SPROUTS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.HANGING_MYCELIUM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.LONG_HANGING_MYCELIUM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.BULBOUS_HANGING_MYCELIUM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.BARREL_CACTUS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_SAGUARO.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.FEATHER_FERN.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_AGAVE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.SOUL_ROOTS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.SOUL_SPROUTS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.CRIMSON_LILY.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.WARPED_LILY.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_BUNDLE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_MOSAIC.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_PLANKS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_STAIRS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_SLAB.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_FENCE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_FENCE_GATE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_PRESSURE_PLATE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_BUTTON.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_DOOR.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_TRAPDOOR.get()).m_5456_());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.SPELT_SEEDS.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.SPELT_ITEM.get());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHERRACK_SPELEOTHEM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.BASALT_SPELEOTHEM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.BLACKSTONE_SPELEOTHEM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.GLOWSTONE_SPELEOTHEM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.STONE_SPELEOTHEM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.DEEPSLATE_SPELEOTHEM.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.DENSE_LAVA_FLOE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.SPARSE_LAVA_FLOE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.LIGNITE_ORE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_RUBY_ORE.get()).m_5456_());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.NETHER_RUBY.get());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_RUBY_BLOCK.get()).m_5456_());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.RUBY_PICKAXE.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.RUBY_AXE.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.RUBY_SWORD.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.RUBY_SHOVEL.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.RUBY_HOE.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.RUBY_ARMOR_HELMET.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.RUBY_ARMOR_CHESTPLATE.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.RUBY_ARMOR_LEGGINGS.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.RUBY_ARMOR_BOOTS.get());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_PYRITE_ORE.get()).m_5456_());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.RAW_PYRITE.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.PYRITE_NUGGET.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.PYRITE_INGOT.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.PYRITE_PICKAXE.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.PYRITE_AXE.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.PYRITE_SWORD.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.PYRITE_SHOVEL.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.PYRITE_HOE.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.PYRITE_ARMOR_HELMET.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.PYRITE_ARMOR_CHESTPLATE.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.PYRITE_ARMOR_LEGGINGS.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.PYRITE_ARMOR_BOOTS.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_UPGRADE_SMITHING_TEMPLATE.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_PICKAXE.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_AXE.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_SWORD.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_SHOVEL.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_HOE.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_EXCAVATOR.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_ARMOUR_HELMET.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_ARMOUR_CHESTPLATE.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_ARMOUR_LEGGINGS.get());
        tabData.m_246326_((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_ARMOUR_BOOTS.get());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_BLOCK.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_STAIRS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_SLAB.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_WALL.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_TILES.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_TILE_STAIRS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_TILE_SLAB.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_ROOFING.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_ROOFING_STAIRS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_ROOFING_SLAB.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.CARVED_PYRITE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.CARVED_PYRITE_STAIRS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.CARVED_PYRITE_SLAB.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.CARVED_PYRITE_WALL.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.CHISELED_PYRITE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_LAMP.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_BRICKS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_BRICK_STAIRS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_BRICK_SLAB.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_BRICK_PILLAR.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.POLISHED_NETHER_BRICKS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.POLISHED_NETHER_BRICK_STAIRS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.POLISHED_NETHER_BRICK_SLAB.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.POLISHED_NETHER_BRICK_WALL.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.SMOOTH_NETHERRACK.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.SMOOTH_NETHERRACK_STAIRS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.SMOOTH_NETHERRACK_SLAB.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)EvenbetternetherModBlocks.SMOOTH_NETHERRACK_WALL.get()).m_5456_());
    }).m_257652_());
}

