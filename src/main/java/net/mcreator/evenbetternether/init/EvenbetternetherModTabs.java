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
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create((ResourceKey)Registries.CREATIVE_MODE_TAB, (String)"evenbetternether");
    public static final RegistryObject<CreativeModeTab> EVEN_BETTER_NETHER_TAB = REGISTRY.register("even_better_nether_tab", () -> CreativeModeTab.builder().title((Component)Component.translatable((String)"item_group.evenbetternether.even_better_nether_tab")).icon(() -> new ItemStack((ItemLike)EvenbetternetherModBlocks.VERDANT_NYLIUM.get())).displayItems((parameters, tabData) -> {
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.VERDANT_NYLIUM.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.VERDANT_ROOTS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.VERDANT_SPROUTS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.BONE_GROWTHS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.SMOOTH_BONE_BLOCK.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.SMOOTH_BONE_STAIRS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.SMOOTH_BONE_SLAB.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.SMOOTH_BONE_WALL.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.BONE_SPELEOTHEM.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.WITHERED_NYLIUM.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.BURNING_ROOTS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.BURNING_SPROUTS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.CHARRED_SPROUTS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.WITHER_BONE_GROWTHS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NYCELIUM.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_WOOD.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_LOG.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.STRIPPED_MUSHROOM_LOG.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.STRIPPED_MUSHROOM_WOOD.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_PLANKS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_STAIRS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_SLAB.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_FENCE.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_FENCE_GATE.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_PRESSURE_PLATE.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_BUTTON.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_DOOR.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.MUSHROOM_TRAPDOOR.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_MUSHROOM_CAP.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHERSHROOM.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.TALL_NETHERSHROOM.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.BROWN_NETHER_MUSHROOM_CAP.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.BROWN_NETHERSHROOM.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.TALL_BROWN_NETHERSHROOM.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.FUNGAL_ROOTS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.FUNGAL_SPROUTS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.HANGING_MYCELIUM.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.BARREL_CACTUS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_SAGUARO.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.FEATHER_FERN.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_AGAVE.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.SOUL_ROOTS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.SOUL_SPROUTS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.CRIMSON_LILY.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.WARPED_LILY.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_BUNDLE.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_MOSAIC.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_PLANKS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_STAIRS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_SLAB.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_FENCE.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_FENCE_GATE.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_PRESSURE_PLATE.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_BUTTON.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_DOOR.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_REED_TRAPDOOR.get()).asItem());
        tabData.accept((ItemLike)EvenbetternetherModItems.SPELT_SEEDS.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.SPELT_ITEM.get());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHERRACK_SPELEOTHEM.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.BASALT_SPELEOTHEM.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.BLACKSTONE_SPELEOTHEM.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.GLOWSTONE_SPELEOTHEM.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.STONE_SPELEOTHEM.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.DEEPSLATE_SPELEOTHEM.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.DENSE_LAVA_FLOE.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.SPARSE_LAVA_FLOE.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.LIGNITE_ORE.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_RUBY_ORE.get()).asItem());
        tabData.accept((ItemLike)EvenbetternetherModItems.NETHER_RUBY.get());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_RUBY_BLOCK.get()).asItem());
        tabData.accept((ItemLike)EvenbetternetherModItems.RUBY_PICKAXE.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.RUBY_AXE.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.RUBY_SWORD.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.RUBY_SHOVEL.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.RUBY_HOE.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.RUBY_ARMOR_HELMET.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.RUBY_ARMOR_CHESTPLATE.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.RUBY_ARMOR_LEGGINGS.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.RUBY_ARMOR_BOOTS.get());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.NETHER_PYRITE_ORE.get()).asItem());
        tabData.accept((ItemLike)EvenbetternetherModItems.RAW_PYRITE.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.PYRITE_NUGGET.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.PYRITE_INGOT.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.PYRITE_PICKAXE.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.PYRITE_AXE.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.PYRITE_SWORD.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.PYRITE_SHOVEL.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.PYRITE_HOE.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.PYRITE_ARMOR_HELMET.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.PYRITE_ARMOR_CHESTPLATE.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.PYRITE_ARMOR_LEGGINGS.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.PYRITE_ARMOR_BOOTS.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_UPGRADE_SMITHING_TEMPLATE.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_PICKAXE.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_AXE.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_SWORD.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_SHOVEL.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_HOE.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_EXCAVATOR.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_ARMOUR_HELMET.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_ARMOUR_CHESTPLATE.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_ARMOUR_LEGGINGS.get());
        tabData.accept((ItemLike)EvenbetternetherModItems.DIAMOND_PYRITE_ARMOUR_BOOTS.get());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_BLOCK.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_STAIRS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_SLAB.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_WALL.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_TILES.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_TILE_STAIRS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_TILE_SLAB.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_ROOFING.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_ROOFING_STAIRS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_ROOFING_SLAB.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.CARVED_PYRITE.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.CARVED_PYRITE_STAIRS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.CARVED_PYRITE_SLAB.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.CARVED_PYRITE_WALL.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.CHISELED_PYRITE.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_LAMP.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_BRICKS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_BRICK_STAIRS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_BRICK_SLAB.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.PYRITE_BRICK_PILLAR.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.POLISHED_NETHER_BRICKS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.POLISHED_NETHER_BRICK_STAIRS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.POLISHED_NETHER_BRICK_SLAB.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.POLISHED_NETHER_BRICK_WALL.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.SMOOTH_NETHERRACK.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.SMOOTH_NETHERRACK_STAIRS.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.SMOOTH_NETHERRACK_SLAB.get()).asItem());
        tabData.accept((ItemLike)((Block)EvenbetternetherModBlocks.SMOOTH_NETHERRACK_WALL.get()).asItem());
        // Imported content uses its own dependency-free item registry. Iterating
        // that registry directly guarantees every imported BlockItem appears.
        BlackForgeImportedBlocks.ITEMS.getEntries().stream()
                .filter(item -> item != BlackForgeImportedBlocks.AGAVE_LEAF)
                .forEach(item -> tabData.accept(item.get()));
    }).build());
}
