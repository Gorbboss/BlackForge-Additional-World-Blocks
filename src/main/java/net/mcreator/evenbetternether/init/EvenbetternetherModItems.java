/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.DoubleHighBlockItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.level.block.Block
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package net.mcreator.evenbetternether.init;

import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.mcreator.evenbetternether.item.DiamondPyriteArmourItem;
import net.mcreator.evenbetternether.item.DiamondPyriteAxeItem;
import net.mcreator.evenbetternether.item.DiamondPyriteExcavatorItem;
import net.mcreator.evenbetternether.item.DiamondPyriteHoeItem;
import net.mcreator.evenbetternether.item.DiamondPyritePickaxeItem;
import net.mcreator.evenbetternether.item.DiamondPyriteShovelItem;
import net.mcreator.evenbetternether.item.DiamondPyriteSwordItem;
import net.mcreator.evenbetternether.item.DiamondPyriteUpgradeSmithingTemplateItem;
import net.mcreator.evenbetternether.item.NetherRubyItem;
import net.mcreator.evenbetternether.item.PyriteArmorItem;
import net.mcreator.evenbetternether.item.PyriteAxeItem;
import net.mcreator.evenbetternether.item.PyriteHoeItem;
import net.mcreator.evenbetternether.item.PyriteIngotItem;
import net.mcreator.evenbetternether.item.PyriteNuggetItem;
import net.mcreator.evenbetternether.item.PyritePickaxeItem;
import net.mcreator.evenbetternether.item.PyriteShovelItem;
import net.mcreator.evenbetternether.item.PyriteSwordItem;
import net.mcreator.evenbetternether.item.RawPyriteItem;
import net.mcreator.evenbetternether.item.RubyArmorItem;
import net.mcreator.evenbetternether.item.RubyAxeItem;
import net.mcreator.evenbetternether.item.RubyHoeItem;
import net.mcreator.evenbetternether.item.RubyPickaxeItem;
import net.mcreator.evenbetternether.item.RubyShovelItem;
import net.mcreator.evenbetternether.item.RubySwordItem;
import net.mcreator.evenbetternether.item.SpeltItemItem;
import net.mcreator.evenbetternether.item.SpeltSeedsItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class EvenbetternetherModItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create((IForgeRegistry)ForgeRegistries.ITEMS, (String)"evenbetternether");
    public static final RegistryObject<Item> VERDANT_NYLIUM = EvenbetternetherModItems.block(EvenbetternetherModBlocks.VERDANT_NYLIUM);
    public static final RegistryObject<Item> VERDANT_ROOTS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.VERDANT_ROOTS);
    public static final RegistryObject<Item> BONE_GROWTHS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.BONE_GROWTHS);
    public static final RegistryObject<Item> FEATHER_FERN = EvenbetternetherModItems.block(EvenbetternetherModBlocks.FEATHER_FERN);
    public static final RegistryObject<Item> SMOOTH_BONE_BLOCK = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SMOOTH_BONE_BLOCK);
    public static final RegistryObject<Item> SMOOTH_BONE_STAIRS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SMOOTH_BONE_STAIRS);
    public static final RegistryObject<Item> SMOOTH_BONE_SLAB = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SMOOTH_BONE_SLAB);
    public static final RegistryObject<Item> SMOOTH_BONE_WALL = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SMOOTH_BONE_WALL);
    public static final RegistryObject<Item> NETHER_AGAVE = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHER_AGAVE);
    public static final RegistryObject<Item> VERDANT_SPROUTS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.VERDANT_SPROUTS);
    public static final RegistryObject<Item> NETHER_SAGUARO = EvenbetternetherModItems.doubleBlock(EvenbetternetherModBlocks.NETHER_SAGUARO);
    public static final RegistryObject<Item> BARREL_CACTUS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.BARREL_CACTUS);
    public static final RegistryObject<Item> SOUL_ROOTS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SOUL_ROOTS);
    public static final RegistryObject<Item> SOUL_SPROUTS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SOUL_SPROUTS);
    public static final RegistryObject<Item> BASALT_SPELEOTHEM = EvenbetternetherModItems.block(EvenbetternetherModBlocks.BASALT_SPELEOTHEM);
    public static final RegistryObject<Item> NETHERRACK_SPELEOTHEM = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHERRACK_SPELEOTHEM);
    public static final RegistryObject<Item> BLACKSTONE_SPELEOTHEM = EvenbetternetherModItems.block(EvenbetternetherModBlocks.BLACKSTONE_SPELEOTHEM);
    public static final RegistryObject<Item> GLOWSTONE_SPELEOTHEM = EvenbetternetherModItems.block(EvenbetternetherModBlocks.GLOWSTONE_SPELEOTHEM);
    public static final RegistryObject<Item> STONE_SPELEOTHEM = EvenbetternetherModItems.block(EvenbetternetherModBlocks.STONE_SPELEOTHEM);
    public static final RegistryObject<Item> DEEPSLATE_SPELEOTHEM = EvenbetternetherModItems.block(EvenbetternetherModBlocks.DEEPSLATE_SPELEOTHEM);
    public static final RegistryObject<Item> BONE_SPELEOTHEM = EvenbetternetherModItems.block(EvenbetternetherModBlocks.BONE_SPELEOTHEM);
    public static final RegistryObject<Item> NYCELIUM = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NYCELIUM);
    public static final RegistryObject<Item> WITHERED_NYLIUM = EvenbetternetherModItems.block(EvenbetternetherModBlocks.WITHERED_NYLIUM);
    public static final RegistryObject<Item> BURNING_ROOTS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.BURNING_ROOTS);
    public static final RegistryObject<Item> BURNING_SPROUTS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.BURNING_SPROUTS);
    public static final RegistryObject<Item> CHARRED_SPROUTS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.CHARRED_SPROUTS);
    public static final RegistryObject<Item> WITHER_BONE_GROWTHS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.WITHER_BONE_GROWTHS);
    public static final RegistryObject<Item> NETHER_PYRITE_ORE = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHER_PYRITE_ORE);
    public static final RegistryObject<Item> RAW_PYRITE = REGISTRY.register("raw_pyrite", () -> new RawPyriteItem());
    public static final RegistryObject<Item> PYRITE_INGOT = REGISTRY.register("pyrite_ingot", () -> new PyriteIngotItem());
    public static final RegistryObject<Item> PYRITE_NUGGET = REGISTRY.register("pyrite_nugget", () -> new PyriteNuggetItem());
    public static final RegistryObject<Item> PYRITE_BLOCK = EvenbetternetherModItems.block(EvenbetternetherModBlocks.PYRITE_BLOCK);
    public static final RegistryObject<Item> LIGNITE_ORE = EvenbetternetherModItems.block(EvenbetternetherModBlocks.LIGNITE_ORE);
    public static final RegistryObject<Item> PYRITE_PICKAXE = REGISTRY.register("pyrite_pickaxe", () -> new PyritePickaxeItem());
    public static final RegistryObject<Item> PYRITE_AXE = REGISTRY.register("pyrite_axe", () -> new PyriteAxeItem());
    public static final RegistryObject<Item> PYRITE_SWORD = REGISTRY.register("pyrite_sword", () -> new PyriteSwordItem());
    public static final RegistryObject<Item> PYRITE_SHOVEL = REGISTRY.register("pyrite_shovel", () -> new PyriteShovelItem());
    public static final RegistryObject<Item> PYRITE_HOE = REGISTRY.register("pyrite_hoe", () -> new PyriteHoeItem());
    public static final RegistryObject<Item> NETHER_RUBY_ORE = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHER_RUBY_ORE);
    public static final RegistryObject<Item> NETHER_RUBY = REGISTRY.register("nether_ruby", () -> new NetherRubyItem());
    public static final RegistryObject<Item> NETHER_RUBY_BLOCK = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHER_RUBY_BLOCK);
    public static final RegistryObject<Item> RUBY_PICKAXE = REGISTRY.register("ruby_pickaxe", () -> new RubyPickaxeItem());
    public static final RegistryObject<Item> RUBY_AXE = REGISTRY.register("ruby_axe", () -> new RubyAxeItem());
    public static final RegistryObject<Item> RUBY_SWORD = REGISTRY.register("ruby_sword", () -> new RubySwordItem());
    public static final RegistryObject<Item> RUBY_SHOVEL = REGISTRY.register("ruby_shovel", () -> new RubyShovelItem());
    public static final RegistryObject<Item> RUBY_HOE = REGISTRY.register("ruby_hoe", () -> new RubyHoeItem());
    public static final RegistryObject<Item> PYRITE_ARMOR_HELMET = REGISTRY.register("pyrite_armor_helmet", () -> new PyriteArmorItem.Helmet());
    public static final RegistryObject<Item> PYRITE_ARMOR_CHESTPLATE = REGISTRY.register("pyrite_armor_chestplate", () -> new PyriteArmorItem.Chestplate());
    public static final RegistryObject<Item> PYRITE_ARMOR_LEGGINGS = REGISTRY.register("pyrite_armor_leggings", () -> new PyriteArmorItem.Leggings());
    public static final RegistryObject<Item> PYRITE_ARMOR_BOOTS = REGISTRY.register("pyrite_armor_boots", () -> new PyriteArmorItem.Boots());
    public static final RegistryObject<Item> RUBY_ARMOR_HELMET = REGISTRY.register("ruby_armor_helmet", () -> new RubyArmorItem.Helmet());
    public static final RegistryObject<Item> RUBY_ARMOR_CHESTPLATE = REGISTRY.register("ruby_armor_chestplate", () -> new RubyArmorItem.Chestplate());
    public static final RegistryObject<Item> RUBY_ARMOR_LEGGINGS = REGISTRY.register("ruby_armor_leggings", () -> new RubyArmorItem.Leggings());
    public static final RegistryObject<Item> RUBY_ARMOR_BOOTS = REGISTRY.register("ruby_armor_boots", () -> new RubyArmorItem.Boots());
    public static final RegistryObject<Item> MUSHROOM_WOOD = EvenbetternetherModItems.block(EvenbetternetherModBlocks.MUSHROOM_WOOD);
    public static final RegistryObject<Item> MUSHROOM_LOG = EvenbetternetherModItems.block(EvenbetternetherModBlocks.MUSHROOM_LOG);
    public static final RegistryObject<Item> MUSHROOM_PLANKS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.MUSHROOM_PLANKS);
    public static final RegistryObject<Item> MUSHROOM_STAIRS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.MUSHROOM_STAIRS);
    public static final RegistryObject<Item> MUSHROOM_SLAB = EvenbetternetherModItems.block(EvenbetternetherModBlocks.MUSHROOM_SLAB);
    public static final RegistryObject<Item> MUSHROOM_FENCE = EvenbetternetherModItems.block(EvenbetternetherModBlocks.MUSHROOM_FENCE);
    public static final RegistryObject<Item> MUSHROOM_FENCE_GATE = EvenbetternetherModItems.block(EvenbetternetherModBlocks.MUSHROOM_FENCE_GATE);
    public static final RegistryObject<Item> MUSHROOM_PRESSURE_PLATE = EvenbetternetherModItems.block(EvenbetternetherModBlocks.MUSHROOM_PRESSURE_PLATE);
    public static final RegistryObject<Item> MUSHROOM_BUTTON = EvenbetternetherModItems.block(EvenbetternetherModBlocks.MUSHROOM_BUTTON);
    public static final RegistryObject<Item> MUSHROOM_DOOR = EvenbetternetherModItems.doubleBlock(EvenbetternetherModBlocks.MUSHROOM_DOOR);
    public static final RegistryObject<Item> MUSHROOM_TRAPDOOR = EvenbetternetherModItems.block(EvenbetternetherModBlocks.MUSHROOM_TRAPDOOR);
    public static final RegistryObject<Item> STRIPPED_MUSHROOM_LOG = EvenbetternetherModItems.block(EvenbetternetherModBlocks.STRIPPED_MUSHROOM_LOG);
    public static final RegistryObject<Item> STRIPPED_MUSHROOM_WOOD = EvenbetternetherModItems.block(EvenbetternetherModBlocks.STRIPPED_MUSHROOM_WOOD);
    public static final RegistryObject<Item> NETHER_MUSHROOM_CAP = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHER_MUSHROOM_CAP);
    public static final RegistryObject<Item> BROWN_NETHER_MUSHROOM_CAP = EvenbetternetherModItems.block(EvenbetternetherModBlocks.BROWN_NETHER_MUSHROOM_CAP);
    public static final RegistryObject<Item> TALL_NETHERSHROOM = EvenbetternetherModItems.doubleBlock(EvenbetternetherModBlocks.TALL_NETHERSHROOM);
    public static final RegistryObject<Item> NETHERSHROOM = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHERSHROOM);
    public static final RegistryObject<Item> FUNGAL_ROOTS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.FUNGAL_ROOTS);
    public static final RegistryObject<Item> FUNGAL_SPROUTS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.FUNGAL_SPROUTS);
    public static final RegistryObject<Item> HANGING_MYCELIUM = EvenbetternetherModItems.block(EvenbetternetherModBlocks.HANGING_MYCELIUM);
    public static final RegistryObject<Item> LONG_HANGING_MYCELIUM = EvenbetternetherModItems.block(EvenbetternetherModBlocks.LONG_HANGING_MYCELIUM);
    public static final RegistryObject<Item> BULBOUS_HANGING_MYCELIUM = EvenbetternetherModItems.block(EvenbetternetherModBlocks.BULBOUS_HANGING_MYCELIUM);
    public static final RegistryObject<Item> DIAMOND_PYRITE_PICKAXE = REGISTRY.register("diamond_pyrite_pickaxe", () -> new DiamondPyritePickaxeItem());
    public static final RegistryObject<Item> DIAMOND_PYRITE_AXE = REGISTRY.register("diamond_pyrite_axe", () -> new DiamondPyriteAxeItem());
    public static final RegistryObject<Item> DIAMOND_PYRITE_SWORD = REGISTRY.register("diamond_pyrite_sword", () -> new DiamondPyriteSwordItem());
    public static final RegistryObject<Item> DIAMOND_PYRITE_SHOVEL = REGISTRY.register("diamond_pyrite_shovel", () -> new DiamondPyriteShovelItem());
    public static final RegistryObject<Item> DIAMOND_PYRITE_HOE = REGISTRY.register("diamond_pyrite_hoe", () -> new DiamondPyriteHoeItem());
    public static final RegistryObject<Item> DIAMOND_PYRITE_ARMOUR_HELMET = REGISTRY.register("diamond_pyrite_armour_helmet", () -> new DiamondPyriteArmourItem.Helmet());
    public static final RegistryObject<Item> DIAMOND_PYRITE_ARMOUR_CHESTPLATE = REGISTRY.register("diamond_pyrite_armour_chestplate", () -> new DiamondPyriteArmourItem.Chestplate());
    public static final RegistryObject<Item> DIAMOND_PYRITE_ARMOUR_LEGGINGS = REGISTRY.register("diamond_pyrite_armour_leggings", () -> new DiamondPyriteArmourItem.Leggings());
    public static final RegistryObject<Item> DIAMOND_PYRITE_ARMOUR_BOOTS = REGISTRY.register("diamond_pyrite_armour_boots", () -> new DiamondPyriteArmourItem.Boots());
    public static final RegistryObject<Item> DIAMOND_PYRITE_UPGRADE_SMITHING_TEMPLATE = REGISTRY.register("diamond_pyrite_upgrade_smithing_template", () -> new DiamondPyriteUpgradeSmithingTemplateItem());
    public static final RegistryObject<Item> DIAMOND_PYRITE_EXCAVATOR = REGISTRY.register("diamond_pyrite_excavator", () -> new DiamondPyriteExcavatorItem());
    public static final RegistryObject<Item> PYRITE_SLAB = EvenbetternetherModItems.block(EvenbetternetherModBlocks.PYRITE_SLAB);
    public static final RegistryObject<Item> PYRITE_STAIRS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.PYRITE_STAIRS);
    public static final RegistryObject<Item> PYRITE_TILES = EvenbetternetherModItems.block(EvenbetternetherModBlocks.PYRITE_TILES);
    public static final RegistryObject<Item> PYRITE_TILE_STAIRS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.PYRITE_TILE_STAIRS);
    public static final RegistryObject<Item> PYRITE_TILE_SLAB = EvenbetternetherModItems.block(EvenbetternetherModBlocks.PYRITE_TILE_SLAB);
    public static final RegistryObject<Item> PYRITE_WALL = EvenbetternetherModItems.block(EvenbetternetherModBlocks.PYRITE_WALL);
    public static final RegistryObject<Item> PYRITE_ROOFING = EvenbetternetherModItems.block(EvenbetternetherModBlocks.PYRITE_ROOFING);
    public static final RegistryObject<Item> PYRITE_ROOFING_STAIRS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.PYRITE_ROOFING_STAIRS);
    public static final RegistryObject<Item> PYRITE_ROOFING_SLAB = EvenbetternetherModItems.block(EvenbetternetherModBlocks.PYRITE_ROOFING_SLAB);
    public static final RegistryObject<Item> CARVED_PYRITE = EvenbetternetherModItems.block(EvenbetternetherModBlocks.CARVED_PYRITE);
    public static final RegistryObject<Item> CARVED_PYRITE_STAIRS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.CARVED_PYRITE_STAIRS);
    public static final RegistryObject<Item> CARVED_PYRITE_SLAB = EvenbetternetherModItems.block(EvenbetternetherModBlocks.CARVED_PYRITE_SLAB);
    public static final RegistryObject<Item> CARVED_PYRITE_WALL = EvenbetternetherModItems.block(EvenbetternetherModBlocks.CARVED_PYRITE_WALL);
    public static final RegistryObject<Item> CHISELED_PYRITE = EvenbetternetherModItems.block(EvenbetternetherModBlocks.CHISELED_PYRITE);
    public static final RegistryObject<Item> PYRITE_LAMP = EvenbetternetherModItems.block(EvenbetternetherModBlocks.PYRITE_LAMP);
    public static final RegistryObject<Item> PYRITE_BRICKS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.PYRITE_BRICKS);
    public static final RegistryObject<Item> PYRITE_BRICK_STAIRS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.PYRITE_BRICK_STAIRS);
    public static final RegistryObject<Item> PYRITE_BRICK_SLAB = EvenbetternetherModItems.block(EvenbetternetherModBlocks.PYRITE_BRICK_SLAB);
    public static final RegistryObject<Item> PYRITE_BRICK_PILLAR = EvenbetternetherModItems.block(EvenbetternetherModBlocks.PYRITE_BRICK_PILLAR);
    public static final RegistryObject<Item> SOUL_FARMLAND = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SOUL_FARMLAND);
    public static final RegistryObject<Item> DENSE_LAVA_FLOE = EvenbetternetherModItems.block(EvenbetternetherModBlocks.DENSE_LAVA_FLOE);
    public static final RegistryObject<Item> SPARSE_LAVA_FLOE = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SPARSE_LAVA_FLOE);
    public static final RegistryObject<Item> NETHER_REED = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHER_REED);
    public static final RegistryObject<Item> NETHER_REED_BUNDLE = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHER_REED_BUNDLE);
    public static final RegistryObject<Item> NETHER_REED_PLANKS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHER_REED_PLANKS);
    public static final RegistryObject<Item> NETHER_REED_STAIRS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHER_REED_STAIRS);
    public static final RegistryObject<Item> NETHER_REED_SLAB = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHER_REED_SLAB);
    public static final RegistryObject<Item> NETHER_REED_FENCE = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHER_REED_FENCE);
    public static final RegistryObject<Item> NETHER_REED_FENCE_GATE = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHER_REED_FENCE_GATE);
    public static final RegistryObject<Item> NETHER_REED_PRESSURE_PLATE = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHER_REED_PRESSURE_PLATE);
    public static final RegistryObject<Item> NETHER_REED_BUTTON = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHER_REED_BUTTON);
    public static final RegistryObject<Item> NETHER_REED_MOSAIC = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHER_REED_MOSAIC);
    public static final RegistryObject<Item> NETHER_REED_DOOR = EvenbetternetherModItems.doubleBlock(EvenbetternetherModBlocks.NETHER_REED_DOOR);
    public static final RegistryObject<Item> NETHER_REED_TRAPDOOR = EvenbetternetherModItems.block(EvenbetternetherModBlocks.NETHER_REED_TRAPDOOR);
    public static final RegistryObject<Item> SPELT_SEEDS = REGISTRY.register("spelt_seeds", () -> new SpeltSeedsItem());
    public static final RegistryObject<Item> SPELT_STAGE_0 = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SPELT_STAGE_0);
    public static final RegistryObject<Item> SPELT_STAGE_1 = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SPELT_STAGE_1);
    public static final RegistryObject<Item> SPELT_STAGE_2 = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SPELT_STAGE_2);
    public static final RegistryObject<Item> SPELT_STAGE_3 = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SPELT_STAGE_3);
    public static final RegistryObject<Item> SPELT_STAGE_4 = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SPELT_STAGE_4);
    public static final RegistryObject<Item> SPELT_STAGE_5 = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SPELT_STAGE_5);
    public static final RegistryObject<Item> SPELT_STAGE_6 = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SPELT_STAGE_6);
    public static final RegistryObject<Item> SPELT_ITEM = REGISTRY.register("spelt_item", () -> new SpeltItemItem());
    public static final RegistryObject<Item> TALL_BROWN_NETHERSHROOM = EvenbetternetherModItems.doubleBlock(EvenbetternetherModBlocks.TALL_BROWN_NETHERSHROOM);
    public static final RegistryObject<Item> BROWN_NETHERSHROOM = EvenbetternetherModItems.block(EvenbetternetherModBlocks.BROWN_NETHERSHROOM);
    public static final RegistryObject<Item> CRIMSON_LILY = EvenbetternetherModItems.block(EvenbetternetherModBlocks.CRIMSON_LILY);
    public static final RegistryObject<Item> WARPED_LILY = EvenbetternetherModItems.block(EvenbetternetherModBlocks.WARPED_LILY);
    public static final RegistryObject<Item> POLISHED_NETHER_BRICKS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.POLISHED_NETHER_BRICKS);
    public static final RegistryObject<Item> POLISHED_NETHER_BRICK_STAIRS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.POLISHED_NETHER_BRICK_STAIRS);
    public static final RegistryObject<Item> POLISHED_NETHER_BRICK_SLAB = EvenbetternetherModItems.block(EvenbetternetherModBlocks.POLISHED_NETHER_BRICK_SLAB);
    public static final RegistryObject<Item> POLISHED_NETHER_BRICK_WALL = EvenbetternetherModItems.block(EvenbetternetherModBlocks.POLISHED_NETHER_BRICK_WALL);
    public static final RegistryObject<Item> SMOOTH_NETHERRACK = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SMOOTH_NETHERRACK);
    public static final RegistryObject<Item> SMOOTH_NETHERRACK_STAIRS = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SMOOTH_NETHERRACK_STAIRS);
    public static final RegistryObject<Item> SMOOTH_NETHERRACK_SLAB = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SMOOTH_NETHERRACK_SLAB);
    public static final RegistryObject<Item> SMOOTH_NETHERRACK_WALL = EvenbetternetherModItems.block(EvenbetternetherModBlocks.SMOOTH_NETHERRACK_WALL);

    private static RegistryObject<Item> block(RegistryObject<Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new BlockItem((Block)block.get(), new Item.Properties()));
    }

    private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem((Block)block.get(), new Item.Properties()));
    }
}

