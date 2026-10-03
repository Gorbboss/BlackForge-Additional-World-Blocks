package net.mcreator.evenbetternether.init;

import java.util.function.Supplier;
import net.mcreator.evenbetternether.EvenbetternetherMod;
import net.mcreator.evenbetternether.block.ImportedStalactiteBlock;
import net.mcreator.evenbetternether.block.ImportedNetherPlantBlock;
import net.mcreator.evenbetternether.block.ImportedHangingVineBlock;
import net.mcreator.evenbetternether.block.ImportedWillowSaplingBlock;
import net.mcreator.evenbetternether.block.ImportedHookMushroomBlock;
import net.mcreator.evenbetternether.block.ImportedMossCoverBlock;
import net.mcreator.evenbetternether.block.ImportedWallPlantBlock;
import net.mcreator.evenbetternether.block.ImportedNetherCactusBlock;
import net.mcreator.evenbetternether.block.ImportedGiantMoldBlock;
import net.mcreator.evenbetternether.block.ImportedGiantMoldSaplingBlock;
import net.mcreator.evenbetternether.block.ImportedLumabusVineBlock;
import net.mcreator.evenbetternether.block.ImportedLumabusSeedBlock;
import net.mcreator.evenbetternether.block.ImportedWillowLeavesBlock;
import net.mcreator.evenbetternether.block.ImportedWillowBranchBlock;
import net.mcreator.evenbetternether.block.ImportedAgaveBlock;
import net.mcreator.evenbetternether.block.ImportedStalagnateBlock;
import net.mcreator.evenbetternether.block.ImportedStalagnateSeedBlock;
import net.mcreator.evenbetternether.block.ImportedWartSeedBlock;
import net.mcreator.evenbetternether.block.ImportedPallidiumBlock;
import net.mcreator.evenbetternether.block.ImportedEndPlantBlock;
import net.mcreator.evenbetternether.block.ImportedDirectionalFurBlock;
import net.mcreator.evenbetternether.block.ImportedBarbedSculkRootBlock;
import net.mcreator.evenbetternether.block.ImportedEndCropBlock;
import net.mcreator.evenbetternether.block.ImportedEndTreeSaplingBlock;
import net.mcreator.evenbetternether.block.ImportedEndStructureSeedBlock;
import net.mcreator.evenbetternether.block.ImportedEndShapeBlock;
import net.mcreator.evenbetternether.block.ImportedLanceleafBlock;
import net.mcreator.evenbetternether.block.ImportedStrippableLogBlock;
import net.mcreator.evenbetternether.block.ImportedTransitionBlock;
import net.mcreator.evenbetternether.block.ImportedFragileWartBlock;
import net.mcreator.evenbetternether.block.ImportedStalagnateStemBlock;
import net.mcreator.evenbetternether.block.ImportedBetterFeatherFernBlock;
import net.mcreator.evenbetternether.block.ImportedBoneMushroomBlock;
import net.mcreator.evenbetternether.block.ImportedSepiaBoneGrassBlock;
import net.mcreator.evenbetternether.block.ImportedWillowTorchBlock;
import net.mcreator.evenbetternether.block.ImportedDesertPlantBlock;
import net.mcreator.evenbetternether.block.ImportedSnowPlantBlock;
import net.mcreator.evenbetternether.block.ImportedCloverBlock;
import net.mcreator.evenbetternether.block.ImportedMushroomColonyBlock;
import net.mcreator.evenbetternether.block.ImportedTallMushroomColonyBlock;
import net.mcreator.evenbetternether.block.ImportedLuminousFlowerBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.mcreator.evenbetternether.block.ImportedCattailBlock;
import net.mcreator.evenbetternether.block.ImportedTallDesertPlantBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.GlowLichenBlock;
import net.minecraft.world.level.block.DirtPathBlock;
import net.mcreator.evenbetternether.block.ImportedNeonCactusBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Selective, dependency-free BetterNether imports.
 *
 * <p>This registry deliberately lives beside the reconstructed MCreator
 * registries so imported content can be added incrementally without pulling
 * BCLib or WunderLib into the finished mod.</p>
 */
public final class BlackForgeImportedBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EvenbetternetherMod.MODID);
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EvenbetternetherMod.MODID);

    private static final BlockBehaviour.Properties OBSIDIAN = BlockBehaviour.Properties.copy(Blocks.OBSIDIAN);
    private static final BlockBehaviour.Properties OBSIDIAN_GLASS_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.TINTED_GLASS)
            .strength(50.0F, 1200.0F)
            .noOcclusion();

    public static final RegistryObject<Block> BASALT_BRICK_WALL = wall("basalt_brick_wall", Blocks.POLISHED_BASALT);
    public static final RegistryObject<Block> SOUL_SANDSTONE_WALL = wall("soul_sandstone_wall", Blocks.SANDSTONE);

    public static final RegistryObject<Block> NETHERRACK_STALACTITE = stalactite("netherrack_stalactite", Blocks.NETHERRACK);
    public static final RegistryObject<Block> GLOWSTONE_STALACTITE = stalactite("glowstone_stalactite", Blocks.GLOWSTONE);
    public static final RegistryObject<Block> BLACKSTONE_STALACTITE = stalactite("blackstone_stalactite", Blocks.BLACKSTONE);
    public static final RegistryObject<Block> BASALT_STALACTITE = stalactite("basalt_stalactite", Blocks.BASALT);
    public static final RegistryObject<Block> BONE_STALACTITE = stalactite("bone_stalactite", Blocks.BONE_BLOCK);

    public static final RegistryObject<Block> HOOK_MUSHROOM = register("hook_mushroom", ImportedHookMushroomBlock::new);
    public static final RegistryObject<Block> MOSS_COVER = register("moss_cover", ImportedMossCoverBlock::new);
    public static final RegistryObject<Block> JUNGLE_MOSS = register("jungle_moss", ImportedWallPlantBlock::new);
    public static final RegistryObject<Block> SCULK_MOSS = register("sculk_moss", ImportedWallPlantBlock::new);
    public static final RegistryObject<Block> WALL_MOSS = register("wall_moss", ImportedWallPlantBlock::new);
    public static final RegistryObject<Block> LUMINOUS_MOSS = register("luminous_moss", () -> new ImportedWallPlantBlock(12));
    public static final RegistryObject<Block> ROTTEN_MUTATED_MOSS = register("rotten_mutated_moss", ImportedWallPlantBlock::new);
    public static final RegistryObject<Block> NETHER_CACTUS = register("nether_cactus", ImportedNetherCactusBlock::new);
    public static final RegistryObject<Block> NETHER_GRASS = plant("nether_grass", 0);
    public static final RegistryObject<Block> GLOOMGRASS = plant("gloomgrass", 2);
    public static final RegistryObject<Block> PALE_GLOOMGRASS = plant("pale_gloomgrass", 1);
    public static final RegistryObject<Item> AGAVE_LEAF = ITEMS.register("agave_leaf", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Block> AGAVE = register("agave", () -> new ImportedAgaveBlock().leaf(AGAVE_LEAF));
    public static final RegistryObject<Block> BETTER_NETHER_FEATHER_FERN = register("better_nether_feather_fern", ImportedBetterFeatherFernBlock::new);
    public static final RegistryObject<Block> BONE_MUSHROOM = register("bone_mushroom", () -> new ImportedBoneMushroomBlock(EvenbetternetherModBlocks.SMOOTH_BONE_BLOCK));
    public static final RegistryObject<Block> SEPIA_BONE_GRASS = register("sepia_bone_grass", ImportedSepiaBoneGrassBlock::new);
    public static final RegistryObject<Block> NETHER_MUSHROOM_STEM = register("nether_mushroom_stem", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.MUSHROOM_STEM)));
    public static final RegistryObject<Block> NETHER_MUSHROOM_PLANKS = register("nether_mushroom_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryObject<Block> NETHER_MUSHROOM_STAIRS = register("nether_mushroom_stairs", () -> new StairBlock(() -> NETHER_MUSHROOM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryObject<Block> NETHER_MUSHROOM_SLAB = register("nether_mushroom_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryObject<Block> GIANT_MOLD = registerNoItem("giant_mold", () -> new ImportedGiantMoldBlock(NETHER_MUSHROOM_STEM));
    public static final RegistryObject<Block> GIANT_MOLD_SAPLING = register("giant_mold_sapling", () -> new ImportedGiantMoldSaplingBlock(GIANT_MOLD));
    public static final RegistryObject<Block> STALAGNATE_STEM = register("stalagnate_stem", ImportedStalagnateStemBlock::new);
    public static final RegistryObject<Block> STALAGNATE_TRUNK = registerNoItem("stalagnate_trunk", () -> new ImportedStalagnateBlock(STALAGNATE_STEM));
    public static final RegistryObject<Block> STALAGNATE_SEED = register("stalagnate_seed", () -> new ImportedStalagnateSeedBlock(STALAGNATE_TRUNK));
    public static final RegistryObject<Block> FRAGILE_WART = register("fragile_wart", ImportedFragileWartBlock::new);
    public static final RegistryObject<Block> WART_SEED = register("wart_seed", ImportedWartSeedBlock::new);
    public static final RegistryObject<Block> BLACK_VINE = vine("black_vine", 0);
    public static final RegistryObject<Block> BLOOMING_VINE = vine("blooming_vine", 4);
    public static final RegistryObject<Block> GOLDEN_VINE = vine("golden_vine", 15);
    public static final RegistryObject<Block> GLOOMSCULK_VINE = vine("gloomsculk_vine", 3);
    public static final RegistryObject<Block> LUMABUS_VINE = registerNoItem("lumabus_vine", ImportedLumabusVineBlock::new);
    public static final RegistryObject<Block> GOLDEN_LUMABUS_VINE = registerNoItem("golden_lumabus_vine", ImportedLumabusVineBlock::new);
    public static final RegistryObject<Block> LUMABUS_SEED = register("lumabus_seed", () -> new ImportedLumabusSeedBlock(LUMABUS_VINE, 10, 21));
    public static final RegistryObject<Block> GOLDEN_LUMABUS_SEED = register("golden_lumabus_seed", () -> new ImportedLumabusSeedBlock(GOLDEN_LUMABUS_VINE, 12, 23));

    public static final RegistryObject<Block> WILLOW_LOG = register("willow_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_STEM)));
    public static final RegistryObject<Block> WILLOW_BARK = register("willow_bark", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_HYPHAE)));
    public static final RegistryObject<Block> WILLOW_STRIPPED_LOG = register("willow_stripped_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_CRIMSON_STEM)));
    public static final RegistryObject<Block> WILLOW_STRIPPED_BARK = register("willow_stripped_bark", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_CRIMSON_HYPHAE)));
    public static final RegistryObject<Block> WILLOW_PLANKS = register("willow_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryObject<Block> WILLOW_DOOR = register("willow_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_DOOR).noOcclusion(), BlockSetType.CRIMSON));
    public static final RegistryObject<Block> WILLOW_FENCE = register("willow_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FENCE)));
    public static final RegistryObject<Block> WILLOW_LEAVES = register("willow_leaves", ImportedWillowLeavesBlock::new);
    public static final RegistryObject<Block> WILLOW_BRANCH = register("willow_branch", ImportedWillowBranchBlock::new);
    public static final RegistryObject<Block> WILLOW_TORCH = register("willow_torch", ImportedWillowTorchBlock::new);
    public static final RegistryObject<Block> WILLOW_SAPLING = register("willow_sapling", () -> new ImportedWillowSaplingBlock(WILLOW_LOG, WILLOW_LEAVES, WILLOW_BRANCH));

    public static final RegistryObject<Block> WEEPING_OBSIDIAN = solid("weeping_obsidian");
    public static final RegistryObject<Block> OBSIDIAN_BRICKS = solid("obsidian_bricks");
    public static final RegistryObject<Block> OBSIDIAN_BRICKS_STAIRS = stairs("obsidian_bricks_stairs", OBSIDIAN_BRICKS);
    public static final RegistryObject<Block> OBSIDIAN_BRICKS_SLAB = slab("obsidian_bricks_slab");
    public static final RegistryObject<Block> OBSIDIAN_TILE = solid("obsidian_tile");
    public static final RegistryObject<Block> OBSIDIAN_TILE_SMALL = solid("obsidian_tile_small");
    public static final RegistryObject<Block> OBSIDIAN_TILE_STAIRS = stairs("obsidian_tile_stairs", OBSIDIAN_TILE);
    public static final RegistryObject<Block> OBSIDIAN_TILE_SLAB = slab("obsidian_tile_slab");
    public static final RegistryObject<Block> OBSIDIAN_ROD_TILES = solid("obsidian_rod_tiles");
    public static final RegistryObject<Block> OBSIDIAN_GLASS = glass("obsidian_glass");
    public static final RegistryObject<Block> OBSIDIAN_GLASS_PANE = pane("obsidian_glass_pane");

    public static final RegistryObject<Block> UMBRALITH = register("umbralith", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));

    public static final RegistryObject<Block> UMBRALITH_POLISHED = register("umbralith_polished", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> UMBRALITH_TILES = register("umbralith_tiles", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> UMBRALITH_PILLAR = register("umbralith_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> UMBRALITH_STAIRS = register("umbralith_stairs", () -> new StairBlock(UMBRALITH.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> UMBRALITH_SLAB = register("umbralith_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> UMBRALITH_WALL = register("umbralith_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)));

    public static final RegistryObject<Block> FLAVOLITE = register("flavolite", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> FLAVOLITE_POLISHED = register("flavolite_polished", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> FLAVOLITE_TILES = register("flavolite_tiles", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> FLAVOLITE_PILLAR = register("flavolite_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> FLAVOLITE_STAIRS = register("flavolite_stairs", () -> new StairBlock(FLAVOLITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> FLAVOLITE_SLAB = register("flavolite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> FLAVOLITE_WALL = register("flavolite_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> FLAVOLITE_RUNED = register("flavolite_runed", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> FLAVOLITE_RUNED_ETERNAL = register("flavolite_runed_eternal", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 13)));

    public static final RegistryObject<Block> PALLIDIUM_FULL = register("pallidium_full", () -> new ImportedPallidiumBlock(null));
    public static final RegistryObject<Block> PALLIDIUM_HEAVY = register("pallidium_heavy", () -> new ImportedPallidiumBlock(PALLIDIUM_FULL));
    public static final RegistryObject<Block> PALLIDIUM_THIN = register("pallidium_thin", () -> new ImportedPallidiumBlock(PALLIDIUM_HEAVY));
    public static final RegistryObject<Block> PALLIDIUM_TINY = register("pallidium_tiny", () -> new ImportedPallidiumBlock(PALLIDIUM_THIN));

    public static final RegistryObject<Block> END_STONE_STALACTITE = register("end_stone_stalactite", () -> new ImportedStalactiteBlock(Blocks.END_STONE));
    public static final RegistryObject<Block> THICK_ENDSTONE_STALACTITE = register("thick_endstone_stalactite", () -> new ImportedStalactiteBlock(Blocks.END_STONE));
    public static final RegistryObject<Block> AURORA_CRYSTAL = register("aurora_crystal", () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(state -> 15).noOcclusion()));

    public static final RegistryObject<Block> DRAGON_BONE_BLOCK = register("dragon_bone_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));
    public static final RegistryObject<Block> DRAGON_BONE_STAIRS = register("dragon_bone_stairs", () -> new StairBlock(DRAGON_BONE_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));
    public static final RegistryObject<Block> DRAGON_BONE_SLAB = register("dragon_bone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));
    public static final RegistryObject<Block> AMBER_MOSS = register("amber_moss", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));

    public static final RegistryObject<Block> AMBER_GRASS = register("amber_grass", ImportedEndPlantBlock::new);
    public static final RegistryObject<Block> BUSHY_GRASS = register("bushy_grass", ImportedEndPlantBlock::new);

    public static final RegistryObject<Block> INFLEXIA = register("inflexia", () -> new ImportedEndPlantBlock(7));
    public static final RegistryObject<Block> FLAMMALIX = register("flammalix", () -> new ImportedEndPlantBlock(13));

    public static final RegistryObject<Block> PURPLE_POLYPORE = register("purple_polypore", () -> new ImportedWallPlantBlock(13));
    public static final RegistryObject<Block> AURANT_POLYPORE = register("aurant_polypore", () -> new ImportedWallPlantBlock(13));

    public static final RegistryObject<Block> SHADOW_PLANT = register("shadow_plant", ImportedEndPlantBlock::new);
    public static final RegistryObject<Block> MURKWEED = register("murkweed", ImportedEndPlantBlock::new);

    public static final RegistryObject<Block> SULPHURIC_ROCK = register("sulphuric_rock", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> SULPHURIC_ROCK_POLISHED = register("sulphuric_rock_polished", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> SULPHURIC_ROCK_TILES = register("sulphuric_rock_tiles", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> SULPHURIC_ROCK_PILLAR = register("sulphuric_rock_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> SULPHURIC_ROCK_STAIRS = register("sulphuric_rock_stairs", () -> new StairBlock(SULPHURIC_ROCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> SULPHURIC_ROCK_SLAB = register("sulphuric_rock_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> SULPHURIC_ROCK_WALL = register("sulphuric_rock_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)));

    public static final RegistryObject<Block> AMARANITA_FUR = register("amaranita_fur", () -> new ImportedDirectionalFurBlock(10));
    public static final RegistryObject<Block> BARBED_SCULK_ROOT = register("barbed_sculk_root", ImportedBarbedSculkRootBlock::new);
    public static final RegistryObject<Item> BLOSSOM_BERRY = ITEMS.register("blossom_berry", () -> new Item(new Item.Properties().food(net.minecraft.world.food.Foods.APPLE)));
    public static final RegistryObject<Block> BLOSSOM_BERRY_SEED = register("blossom_berry_seed", () -> new ImportedEndCropBlock(5, BLOSSOM_BERRY));
    public static final RegistryObject<Item> SHADOW_BERRY_RAW = ITEMS.register("shadow_berry_raw", () -> new Item(new Item.Properties().food(net.minecraft.world.food.Foods.SWEET_BERRIES)));
    public static final RegistryObject<Block> SHADOW_BERRY = register("shadow_berry", () -> new ImportedEndCropBlock(3, SHADOW_BERRY_RAW));

    public static final RegistryObject<Block> HELIX_TREE_LOG = register("helix_tree_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_STEM)));
    public static final RegistryObject<Block> HELIX_TREE_LEAVES = register("helix_tree_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.AZALEA_LEAVES).lightLevel(state -> 8)));
    public static final RegistryObject<Block> HELIX_TREE_SAPLING = register("helix_tree_sapling", () -> new ImportedEndTreeSaplingBlock(ImportedEndTreeSaplingBlock.Kind.HELIX));
    public static final RegistryObject<Block> MOSSY_GLOWSHROOM_LOG = register("mossy_glowshroom_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.MUSHROOM_STEM)));
    public static final RegistryObject<Block> MOSSY_GLOWSHROOM_CAP = register("mossy_glowshroom_cap", () -> new ImportedTransitionBlock(8));
    public static final RegistryObject<Block> MOSSY_GLOWSHROOM_HYMENOPHORE = register("mossy_glowshroom_hymenophore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.MUSHROOM_STEM).lightLevel(state -> 15)));
    public static final RegistryObject<Block> MOSSY_GLOWSHROOM_FUR = register("mossy_glowshroom_fur", () -> new ImportedDirectionalFurBlock(12));
    public static final RegistryObject<Block> MOSSY_GLOWSHROOM_SAPLING = register("mossy_glowshroom_sapling", () -> new ImportedEndTreeSaplingBlock(ImportedEndTreeSaplingBlock.Kind.MOSSY_GLOWSHROOM));

    public static final RegistryObject<Block> DRAGON_TREE_STRIPPED_LOG = register("dragon_tree_stripped_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_WARPED_STEM)));
    public static final RegistryObject<Block> DRAGON_TREE_STRIPPED_BARK = register("dragon_tree_stripped_bark", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_WARPED_HYPHAE)));
    public static final RegistryObject<Block> DRAGON_TREE_LOG = register("dragon_tree_log", () -> new ImportedStrippableLogBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_STEM), DRAGON_TREE_STRIPPED_LOG));
    public static final RegistryObject<Block> DRAGON_TREE_BARK = register("dragon_tree_bark", () -> new ImportedStrippableLogBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_HYPHAE), DRAGON_TREE_STRIPPED_BARK));
    public static final RegistryObject<Block> DRAGON_TREE_PLANKS = register("dragon_tree_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistryObject<Block> DRAGON_TREE_STAIRS = register("dragon_tree_stairs", () -> new StairBlock(DRAGON_TREE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistryObject<Block> DRAGON_TREE_SLAB = register("dragon_tree_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistryObject<Block> DRAGON_TREE_FENCE = register("dragon_tree_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FENCE)));
    public static final RegistryObject<Block> DRAGON_TREE_DOOR = register("dragon_tree_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_DOOR).noOcclusion(), BlockSetType.WARPED));
    public static final RegistryObject<Block> DRAGON_TREE_TRAPDOOR = register("dragon_tree_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_TRAPDOOR).noOcclusion(), BlockSetType.WARPED));
    public static final RegistryObject<Block> DRAGON_TREE_LEAVES = register("dragon_tree_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.AZALEA_LEAVES)));
    public static final RegistryObject<Block> DRAGON_TREE_SAPLING = register("dragon_tree_sapling", () -> new ImportedEndTreeSaplingBlock(ImportedEndTreeSaplingBlock.Kind.DRAGON));

    public static final RegistryObject<Item> HYDRALUX_PETAL = ITEMS.register("hydralux_petal", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Block> HYDRALUX_SAPLING = register("hydralux_sapling", () -> new ImportedEndStructureSeedBlock(ImportedEndStructureSeedBlock.Kind.HYDRALUX));
    public static final RegistryObject<Block> HYDRALUX = registerNoItem("hydralux", () -> new ImportedEndShapeBlock(ImportedEndShapeBlock.Shape.ROOTS, 12));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK = register("hydralux_petal_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 10)));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK_WHITE = register("hydralux_petal_block_white", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 8)));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK_ORANGE = register("hydralux_petal_block_orange", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 8)));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK_MAGENTA = register("hydralux_petal_block_magenta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 8)));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK_LIGHT_BLUE = register("hydralux_petal_block_light_blue", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 8)));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK_YELLOW = register("hydralux_petal_block_yellow", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 8)));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK_LIME = register("hydralux_petal_block_lime", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 8)));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK_PINK = register("hydralux_petal_block_pink", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 8)));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK_GRAY = register("hydralux_petal_block_gray", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 8)));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK_LIGHT_GRAY = register("hydralux_petal_block_light_gray", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 8)));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK_CYAN = register("hydralux_petal_block_cyan", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 8)));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK_PURPLE = register("hydralux_petal_block_purple", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 8)));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK_BLUE = register("hydralux_petal_block_blue", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 8)));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK_BROWN = register("hydralux_petal_block_brown", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 8)));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK_GREEN = register("hydralux_petal_block_green", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 8)));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK_RED = register("hydralux_petal_block_red", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 8)));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK_BLACK = register("hydralux_petal_block_black", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 8)));
    public static final RegistryObject<Block> GLOWING_PILLAR_SEED = register("glowing_pillar_seed", () -> new ImportedEndStructureSeedBlock(ImportedEndStructureSeedBlock.Kind.GLOWING_PILLAR));
    public static final RegistryObject<Block> GLOWING_PILLAR_ROOTS = registerNoItem("glowing_pillar_roots", () -> new ImportedEndShapeBlock(ImportedEndShapeBlock.Shape.BOTTOM, 9));
    public static final RegistryObject<Block> GLOWING_PILLAR_LUMINOPHOR = register("glowing_pillar_luminophor", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 15)));
    public static final RegistryObject<Block> GLOWING_PILLAR_LEAVES = register("glowing_pillar_leaves", () -> new ImportedDirectionalFurBlock(15));
    public static final RegistryObject<Block> LANCELEAF_SEED = register("lanceleaf_seed", () -> new ImportedEndStructureSeedBlock(ImportedEndStructureSeedBlock.Kind.LANCELEAF));
    public static final RegistryObject<Block> LANCELEAF = registerNoItem("lanceleaf", ImportedLanceleafBlock::new);
    public static final RegistryObject<Block> BLUE_VINE_SEED = register("blue_vine_seed", () -> new ImportedEndStructureSeedBlock(ImportedEndStructureSeedBlock.Kind.BLUE_VINE));
    public static final RegistryObject<Block> BLUE_VINE = register("blue_vine", () -> new ImportedEndShapeBlock(ImportedEndShapeBlock.Shape.BOTTOM, 5));
    public static final RegistryObject<Block> BLUE_VINE_LANTERN = register("blue_vine_lantern", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> 15)));
    public static final RegistryObject<Block> BLUE_VINE_FUR = register("blue_vine_fur", () -> new ImportedDirectionalFurBlock(10));
    public static final RegistryObject<Block> TWISTED_VINE = register("twisted_vine", () -> new ImportedHangingVineBlock(8));

    public static final RegistryObject<Block> NEEDLEGRASS = register("needlegrass", () -> new ImportedEndPlantBlock(0));
    public static final RegistryObject<Block> CREEPING_MOSS = register("creeping_moss", () -> new ImportedEndPlantBlock(11));
    public static final RegistryObject<Block> AERIDIUM = register("aeridium", () -> new ImportedEndPlantBlock(0));
    public static final RegistryObject<Block> CHORUS_GRASS = register("chorus_grass", () -> new ImportedEndPlantBlock(0));
    public static final RegistryObject<Block> SALTEAGO = register("salteago", () -> new ImportedEndPlantBlock(0));
    public static final RegistryObject<Block> BLOOMING_COOKSONIA = register("blooming_cooksonia", () -> new ImportedEndPlantBlock(0));
    public static final RegistryObject<Block> JUNGLE_GRASS = register("jungle_grass", () -> new ImportedEndPlantBlock(0));
    public static final RegistryObject<Block> VAIOLUSH_FERN = register("vaiolush_fern", () -> new ImportedEndPlantBlock(0));
    public static final RegistryObject<Block> FRACTURN = register("fracturn", () -> new ImportedEndPlantBlock(0));
    public static final RegistryObject<Block> BLUE_CHARNIA = register("charnia_light_blue", () -> new ImportedEndPlantBlock(8));
    public static final RegistryObject<Block> CRYSTAL_MOSS_COVER = register("crystal_moss_cover", () -> new GlowLichenBlock(BlockBehaviour.Properties.copy(Blocks.GLOW_LICHEN).lightLevel(state -> 10)));
    public static final RegistryObject<Block> TAIL_MOSS = register("tail_moss", () -> new ImportedWallPlantBlock(0));
    public static final RegistryObject<Block> CYAN_MOSS = register("cyan_moss", () -> new ImportedWallPlantBlock(0));
    public static final RegistryObject<Block> AMBER_MOSS_PATH = register("amber_moss_path", () -> new DirtPathBlock(BlockBehaviour.Properties.copy(Blocks.DIRT_PATH)));
    public static final RegistryObject<Block> BARBED_SCULK_ROOT_STAIRS = register("barbed_sculk_root_stairs", () -> new StairBlock(BARBED_SCULK_ROOT.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SCULK)));
    public static final RegistryObject<Block> BARBED_SCULK_ROOT_SLAB = register("barbed_sculk_root_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SCULK)));
    public static final RegistryObject<Block> NEON_CACTUS = register("neon_cactus", ImportedNeonCactusBlock::new);

    public static final RegistryObject<Block> TALL_CACTUS = register("tall_cactus", () -> new ImportedTallDesertPlantBlock(true));
    public static final RegistryObject<Block> TINY_CACTUS = register("tiny_cactus", () -> new ImportedDesertPlantBlock(TALL_CACTUS, true));
    public static final RegistryObject<Block> TALL_DUNE_GRASS = register("tall_dune_grass", () -> new ImportedTallDesertPlantBlock(false));
    public static final RegistryObject<Block> DUNE_GRASS = register("dune_grass", () -> new ImportedDesertPlantBlock(TALL_DUNE_GRASS, false));

    public static final RegistryObject<Block> TALL_SNOW_GRASS = register("tall_snow_grass", () -> new net.mcreator.evenbetternether.block.ImportedTallSnowPlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> SHORT_SNOW_GRASS = register("short_snow_grass", () -> new ImportedSnowPlantBlock(TALL_SNOW_GRASS, false));
    public static final RegistryObject<Block> LARGE_SNOW_FERN = register("large_snow_fern", () -> new net.mcreator.evenbetternether.block.ImportedTallSnowPlantBlock(BlockBehaviour.Properties.copy(Blocks.LARGE_FERN)));
    public static final RegistryObject<Block> SNOW_FERN = register("snow_fern", () -> new ImportedSnowPlantBlock(LARGE_SNOW_FERN, true));

    public static final RegistryObject<Block> CLOVER = register("clover", () -> new ImportedCloverBlock(BlockBehaviour.Properties.copy(Blocks.PINK_PETALS).replaceable().noCollission()));
    public static final RegistryObject<Block> NETHER_CLOVER = register("nether_clover", () -> new ImportedCloverBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_WART).replaceable().noCollission()));
    public static final RegistryObject<Block> LUMINOUS_FLOWER = register("luminous_flower", () -> new ImportedLuminousFlowerBlock(BlockBehaviour.Properties.copy(Blocks.DANDELION).lightLevel(state -> 10)));

    public static final RegistryObject<Block> TALL_CRIMSON_FUNGUS_COLONY = register("tall_crimson_fungus_colony", () -> new ImportedTallMushroomColonyBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FUNGUS)));
    public static final RegistryObject<Block> CRIMSON_FUNGUS_COLONY_WALL = registerNoItem("crimson_fungus_colony_wall", () -> new net.mcreator.evenbetternether.block.ImportedWallMushroomColonyBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FUNGUS)));
    public static final RegistryObject<Block> CRIMSON_FUNGUS_COLONY = registerColony("crimson_fungus_colony", CRIMSON_FUNGUS_COLONY_WALL, () -> new ImportedMushroomColonyBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FUNGUS), TALL_CRIMSON_FUNGUS_COLONY));
    public static final RegistryObject<Block> TALL_WARPED_FUNGUS_COLONY = register("tall_warped_fungus_colony", () -> new ImportedTallMushroomColonyBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FUNGUS)));
    public static final RegistryObject<Block> WARPED_FUNGUS_COLONY_WALL = registerNoItem("warped_fungus_colony_wall", () -> new net.mcreator.evenbetternether.block.ImportedWallMushroomColonyBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FUNGUS)));
    public static final RegistryObject<Block> WARPED_FUNGUS_COLONY = registerColony("warped_fungus_colony", WARPED_FUNGUS_COLONY_WALL, () -> new ImportedMushroomColonyBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FUNGUS), TALL_WARPED_FUNGUS_COLONY));
    public static final RegistryObject<Block> TALL_PALE_MUSHROOM_COLONY = register("tall_pale_mushroom_colony", () -> new ImportedTallMushroomColonyBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM)));
    public static final RegistryObject<Block> PALE_MUSHROOM_COLONY_WALL = registerNoItem("pale_mushroom_colony_wall", () -> new net.mcreator.evenbetternether.block.ImportedWallMushroomColonyBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM)));
    public static final RegistryObject<Block> PALE_MUSHROOM_COLONY = registerColony("pale_mushroom_colony", PALE_MUSHROOM_COLONY_WALL, () -> new ImportedMushroomColonyBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM), TALL_PALE_MUSHROOM_COLONY));
    public static final RegistryObject<Block> PALE_MUSHROOM = register("pale_mushroom", net.mcreator.evenbetternether.block.ImportedPaleMushroomBlock::new);
    public static final RegistryObject<Block> PALE_ROSE_BUSH = register("pale_rose_bush", () -> new net.minecraft.world.level.block.TallFlowerBlock(BlockBehaviour.Properties.copy(Blocks.ROSE_BUSH)));
    public static final RegistryObject<Block> POLISHED_RESIN = register("polished_resin", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> POLISHED_RESIN_STAIRS = register("polished_resin_stairs", () -> new StairBlock(() -> POLISHED_RESIN.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> POLISHED_RESIN_SLAB = register("polished_resin_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS)));

    public static final RegistryObject<Block> SNOW_BUSH = register("snow_bush", () -> new net.mcreator.evenbetternether.block.ImportedSnowBushBlock(false));
    public static final RegistryObject<Block> SNOW_FIREFLY_BUSH = register("snow_firefly_bush", () -> new net.mcreator.evenbetternether.block.ImportedSnowBushBlock(true));

    public static final RegistryObject<Block> SMALL_LILY_PADS = registerWaterPlant("small_lily_pads", () -> new net.minecraft.world.level.block.WaterlilyBlock(BlockBehaviour.Properties.copy(Blocks.LILY_PAD).noCollission()));
    public static final RegistryObject<Block> BIG_LILY_PAD = registerWaterPlant("big_lily_pad", () -> new net.mcreator.evenbetternether.block.ImportedBigLilyPadBlock(BlockBehaviour.Properties.copy(Blocks.LILY_PAD)));

    public static final RegistryObject<Block> CATTAIL = register("cattail", () -> new ImportedCattailBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> REEDS = register("reeds", () -> new ImportedCattailBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));

    public static final RegistryObject<Block> TALL_BROWN_MUSHROOM_COLONY = register("tall_brown_mushroom_colony", () -> new ImportedTallMushroomColonyBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM)));
    public static final RegistryObject<Block> BROWN_MUSHROOM_COLONY_WALL = registerNoItem("brown_mushroom_colony_wall", () -> new net.mcreator.evenbetternether.block.ImportedWallMushroomColonyBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM)));
    public static final RegistryObject<Block> BROWN_MUSHROOM_COLONY = registerColony("brown_mushroom_colony", BROWN_MUSHROOM_COLONY_WALL, () -> new ImportedMushroomColonyBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM), TALL_BROWN_MUSHROOM_COLONY));
    public static final RegistryObject<Block> TALL_RED_MUSHROOM_COLONY = register("tall_red_mushroom_colony", () -> new ImportedTallMushroomColonyBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM)));
    public static final RegistryObject<Block> RED_MUSHROOM_COLONY_WALL = registerNoItem("red_mushroom_colony_wall", () -> new net.mcreator.evenbetternether.block.ImportedWallMushroomColonyBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM)));
    public static final RegistryObject<Block> RED_MUSHROOM_COLONY = registerColony("red_mushroom_colony", RED_MUSHROOM_COLONY_WALL, () -> new ImportedMushroomColonyBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM), TALL_RED_MUSHROOM_COLONY));

    public static final RegistryObject<Block> BLUE_OBSIDIAN = solid("blue_obsidian");
    public static final RegistryObject<Block> BLUE_CRYING_OBSIDIAN = solid("blue_crying_obsidian");
    public static final RegistryObject<Block> BLUE_WEEPING_OBSIDIAN = solid("blue_weeping_obsidian");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_BRICKS = solid("blue_obsidian_bricks");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_BRICKS_STAIRS = stairs("blue_obsidian_bricks_stairs", BLUE_OBSIDIAN_BRICKS);
    public static final RegistryObject<Block> BLUE_OBSIDIAN_BRICKS_SLAB = slab("blue_obsidian_bricks_slab");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_TILE = solid("blue_obsidian_tile");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_TILE_SMALL = solid("blue_obsidian_tile_small");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_TILE_STAIRS = stairs("blue_obsidian_tile_stairs", BLUE_OBSIDIAN_TILE);
    public static final RegistryObject<Block> BLUE_OBSIDIAN_TILE_SLAB = slab("blue_obsidian_tile_slab");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_ROD_TILES = solid("blue_obsidian_rod_tiles");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_GLASS = glass("blue_obsidian_glass");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_GLASS_PANE = pane("blue_obsidian_glass_pane");

    private BlackForgeImportedBlocks() {
    }

    private static RegistryObject<Block> solid(String name) {
        return register(name, () -> new Block(OBSIDIAN));
    }

    private static RegistryObject<Block> slab(String name) {
        return register(name, () -> new SlabBlock(OBSIDIAN));
    }

    private static RegistryObject<Block> stairs(String name, RegistryObject<Block> base) {
        return register(name, () -> new StairBlock(base.get().defaultBlockState(), OBSIDIAN));
    }

    private static RegistryObject<Block> glass(String name) {
        return register(name, () -> new GlassBlock(OBSIDIAN_GLASS_PROPERTIES));
    }

    private static RegistryObject<Block> pane(String name) {
        return register(name, () -> new IronBarsBlock(OBSIDIAN_GLASS_PROPERTIES));
    }

    private static RegistryObject<Block> wall(String name, Block source) {
        return register(name, () -> new WallBlock(BlockBehaviour.Properties.copy(source)));
    }

    private static RegistryObject<Block> stalactite(String name, Block source) {
        return register(name, () -> new ImportedStalactiteBlock(source));
    }

    private static RegistryObject<Block> plant(String name, int light) {
        return register(name, () -> new ImportedNetherPlantBlock(light));
    }

    private static RegistryObject<Block> vine(String name, int light) {
        return register(name, () -> new ImportedHangingVineBlock(light));
    }

    private static RegistryObject<Block> register(String name, Supplier<? extends Block> factory) {
        RegistryObject<Block> block = BLOCKS.register(name, factory);
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    private static RegistryObject<Block> registerWaterPlant(String name, Supplier<? extends Block> factory) {
        RegistryObject<Block> block = BLOCKS.register(name, factory);
        ITEMS.register(name, () -> new net.minecraft.world.item.PlaceOnWaterBlockItem(block.get(), new Item.Properties()));
        return block;
    }

    private static RegistryObject<Block> registerColony(String name, Supplier<Block> wall, Supplier<? extends Block> factory) {
        RegistryObject<Block> block = BLOCKS.register(name, factory);
        ITEMS.register(name, () -> new net.minecraft.world.item.StandingAndWallBlockItem(block.get(), wall.get(), new Item.Properties(), net.minecraft.core.Direction.DOWN));
        return block;
    }

    private static RegistryObject<Block> registerNoItem(String name, Supplier<? extends Block> factory) {
        return BLOCKS.register(name, factory);
    }
}
