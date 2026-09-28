package net.mcreator.evenbetternether.init;

import java.util.function.Supplier;
import java.util.LinkedHashMap;
import java.util.Map;
import net.mcreator.evenbetternether.EvenbetternetherMod;
import net.mcreator.evenbetternether.block.ImportedFragileWartBlock;
import net.mcreator.evenbetternether.block.ImportedPallidiumBlock;
import net.mcreator.evenbetternether.block.ImportedStalactiteBlock;
import net.mcreator.evenbetternether.block.ImportedEndPlantBlock;
import net.mcreator.evenbetternether.block.ImportedWallPlantBlock;
import net.mcreator.evenbetternether.block.ImportedEndShapeBlock;
import net.mcreator.evenbetternether.block.ImportedDirectionalFurBlock;
import net.mcreator.evenbetternether.block.ImportedLanceleafBlock;
import net.mcreator.evenbetternether.block.ImportedEndStructureSeedBlock;
import net.mcreator.evenbetternether.block.ImportedEndTreeSaplingBlock;
import net.mcreator.evenbetternether.block.ImportedTransitionBlock;
import net.mcreator.evenbetternether.block.ImportedEndCropBlock;
import net.mcreator.evenbetternether.block.ImportedBarbedSculkRootBlock;
import net.mcreator.evenbetternether.block.ImportedHangingVineBlock;
import net.mcreator.evenbetternether.block.ImportedStrippableLogBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.GlowLichenBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/** Selected BetterEnd content rebuilt for BlackForge without BCLib/WunderLib. */
public final class BlackForgeBetterEndBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EvenbetternetherMod.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EvenbetternetherMod.MODID);

    public static final RegistryObject<Block> FRAGILE_WART = register("fragile_wart", ImportedFragileWartBlock::new);
    public static final RegistryObject<Block> END_STONE_STALACTITE = register("end_stone_stalactite", () -> new ImportedStalactiteBlock(Blocks.END_STONE));
    public static final RegistryObject<Block> THICK_ENDSTONE_STALACTITE = register("thick_endstone_stalactite", () -> new ImportedStalactiteBlock(Blocks.END_STONE));

    public static final RegistryObject<Block> PALLIDIUM_FULL = register("pallidium_full", () -> new ImportedPallidiumBlock(null));
    public static final RegistryObject<Block> PALLIDIUM_HEAVY = register("pallidium_heavy", () -> new ImportedPallidiumBlock(PALLIDIUM_FULL));
    public static final RegistryObject<Block> PALLIDIUM_THIN = register("pallidium_thin", () -> new ImportedPallidiumBlock(PALLIDIUM_HEAVY));
    public static final RegistryObject<Block> PALLIDIUM_TINY = register("pallidium_tiny", () -> new ImportedPallidiumBlock(PALLIDIUM_THIN));

    public static final StoneSet UMBRALITH = stoneSet("umbralith");
    public static final StoneSet SULPHURIC_ROCK = stoneSet("sulphuric_rock");
    public static final StoneSet FLAVOLITE = stoneSet("flavolite");
    public static final RegistryObject<Block> FLAVOLITE_RUNED = solid("flavolite_runed", 0);
    public static final RegistryObject<Block> FLAVOLITE_RUNED_ETERNAL = solid("flavolite_runed_eternal", 13);

    public static final RegistryObject<Block> INFLEXIA = plant("inflexia", 7);
    public static final RegistryObject<Block> FLAMMALIX = plant("flammalix", 13);
    public static final RegistryObject<Block> PURPLE_POLYPORE = wallPlant("purple_polypore", 13);
    public static final RegistryObject<Block> AURANT_POLYPORE = wallPlant("aurant_polypore", 13);
    public static final RegistryObject<Block> AMBER_MOSS = solid("amber_moss", 0);
    public static final RegistryObject<Block> AMBER_GRASS = plant("amber_grass", 0);
    public static final RegistryObject<Block> BUSHY_GRASS = plant("bushy_grass", 0);
    public static final RegistryObject<Block> CRYSTAL_MOSS_COVER = register("crystal_moss_cover", () -> new GlowLichenBlock(BlockBehaviour.Properties.copy(Blocks.GLOW_LICHEN).lightLevel(state -> 10)));
    public static final RegistryObject<Block> TAIL_MOSS = wallPlant("tail_moss", 0);
    public static final RegistryObject<Block> SHADOW_PLANT = plant("shadow_plant", 0);
    public static final RegistryObject<Block> MURKWEED = plant("murkweed", 0);
    public static final RegistryObject<Block> NEEDLEGRASS = plant("needlegrass", 0);
    public static final RegistryObject<Block> CREEPING_MOSS = plant("creeping_moss", 11);
    public static final RegistryObject<Block> AERIDIUM = plant("aeridium", 0);
    public static final RegistryObject<Block> CHORUS_GRASS = plant("chorus_grass", 0);
    public static final RegistryObject<Block> SALTEAGO = plant("salteago", 0);
    public static final RegistryObject<Block> BLOOMING_COOKSONIA = plant("blooming_cooksonia", 0);
    public static final RegistryObject<Block> JUNGLE_GRASS = plant("jungle_grass", 0);
    public static final RegistryObject<Block> VAIOLUSH_FERN = plant("vaiolush_fern", 0);
    public static final RegistryObject<Block> FRACTURN = plant("fracturn", 0);
    public static final RegistryObject<Block> BLUE_CHARNIA = plant("charnia_light_blue", 8);
    public static final RegistryObject<Block> CYAN_MOSS = wallPlant("cyan_moss", 0);
    public static final RegistryObject<Block> AURORA_CRYSTAL = register("aurora_crystal", () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(state -> 15).noOcclusion()));
    public static final RegistryObject<Block> DRAGON_BONE_BLOCK = register("dragon_bone_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));
    public static final RegistryObject<Block> DRAGON_BONE_STAIRS = register("dragon_bone_stairs", () -> new StairBlock(DRAGON_BONE_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));
    public static final RegistryObject<Block> DRAGON_BONE_SLAB = register("dragon_bone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));

    public static final RegistryObject<Item> HYDRALUX_PETAL = ITEMS.register("hydralux_petal", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Block> HYDRALUX_SAPLING = register("hydralux_sapling", () -> new ImportedEndStructureSeedBlock(ImportedEndStructureSeedBlock.Kind.HYDRALUX));
    public static final RegistryObject<Block> HYDRALUX = register("hydralux", () -> new ImportedEndShapeBlock(ImportedEndShapeBlock.Shape.ROOTS, 12));
    public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK = solid("hydralux_petal_block", 10);
    public static final Map<String, RegistryObject<Block>> HYDRALUX_PETAL_COLORS = coloredHydralux();

    public static final RegistryObject<Block> GLOWING_PILLAR_SEED = register("glowing_pillar_seed", () -> new ImportedEndStructureSeedBlock(ImportedEndStructureSeedBlock.Kind.GLOWING_PILLAR));
    public static final RegistryObject<Block> GLOWING_PILLAR_ROOTS = register("glowing_pillar_roots", () -> new ImportedEndShapeBlock(ImportedEndShapeBlock.Shape.BOTTOM, 9));
    public static final RegistryObject<Block> GLOWING_PILLAR_LUMINOPHOR = solid("glowing_pillar_luminophor", 15);
    public static final RegistryObject<Block> GLOWING_PILLAR_LEAVES = register("glowing_pillar_leaves", () -> new ImportedDirectionalFurBlock(15));

    public static final RegistryObject<Block> LANCELEAF_SEED = register("lanceleaf_seed", () -> new ImportedEndStructureSeedBlock(ImportedEndStructureSeedBlock.Kind.LANCELEAF));
    public static final RegistryObject<Block> LANCELEAF = register("lanceleaf", ImportedLanceleafBlock::new);
    public static final RegistryObject<Block> BLUE_VINE_SEED = register("blue_vine_seed", () -> new ImportedEndStructureSeedBlock(ImportedEndStructureSeedBlock.Kind.BLUE_VINE));
    public static final RegistryObject<Block> BLUE_VINE = register("blue_vine", () -> new ImportedEndShapeBlock(ImportedEndShapeBlock.Shape.BOTTOM, 5));
    public static final RegistryObject<Block> BLUE_VINE_LANTERN = solid("blue_vine_lantern", 15);
    public static final RegistryObject<Block> BLUE_VINE_FUR = register("blue_vine_fur", () -> new ImportedDirectionalFurBlock(10));
    public static final RegistryObject<Block> AMARANITA_FUR = register("amaranita_fur", () -> new ImportedDirectionalFurBlock(10));
    public static final RegistryObject<Block> MOSSY_GLOWSHROOM_FUR = register("mossy_glowshroom_fur", () -> new ImportedDirectionalFurBlock(12));
    public static final RegistryObject<Block> TWISTED_VINE = register("twisted_vine", () -> new ImportedHangingVineBlock(8));

    public static final RegistryObject<Block> HELIX_TREE_LEAVES = register("helix_tree_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.AZALEA_LEAVES).lightLevel(s->8)));
    public static final RegistryObject<Block> HELIX_TREE_SAPLING = register("helix_tree_sapling", () -> new ImportedEndTreeSaplingBlock(ImportedEndTreeSaplingBlock.Kind.HELIX));
    public static final RegistryObject<Block> MOSSY_GLOWSHROOM_CAP = register("mossy_glowshroom_cap", () -> new ImportedTransitionBlock(8));
    public static final RegistryObject<Block> MOSSY_GLOWSHROOM_HYMENOPHORE = solid("mossy_glowshroom_hymenophore", 15);
    public static final RegistryObject<Block> MOSSY_GLOWSHROOM_SAPLING = register("mossy_glowshroom_sapling", () -> new ImportedEndTreeSaplingBlock(ImportedEndTreeSaplingBlock.Kind.MOSSY_GLOWSHROOM));

    public static final RegistryObject<Block> DRAGON_TREE_STRIPPED_LOG = register("dragon_tree_stripped_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_WARPED_STEM)));
    public static final RegistryObject<Block> DRAGON_TREE_STRIPPED_BARK = register("dragon_tree_stripped_bark", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_WARPED_HYPHAE)));
    public static final RegistryObject<Block> DRAGON_TREE_LOG = register("dragon_tree_log", () -> new ImportedStrippableLogBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_STEM), DRAGON_TREE_STRIPPED_LOG));
    public static final RegistryObject<Block> DRAGON_TREE_BARK = register("dragon_tree_bark", () -> new ImportedStrippableLogBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_HYPHAE), DRAGON_TREE_STRIPPED_BARK));
    public static final RegistryObject<Block> DRAGON_TREE_PLANKS = solid("dragon_tree_planks", 0);
    public static final RegistryObject<Block> DRAGON_TREE_STAIRS = register("dragon_tree_stairs", () -> new StairBlock(DRAGON_TREE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistryObject<Block> DRAGON_TREE_SLAB = register("dragon_tree_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistryObject<Block> DRAGON_TREE_FENCE = register("dragon_tree_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FENCE)));
    public static final RegistryObject<Block> DRAGON_TREE_DOOR = register("dragon_tree_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_DOOR).noOcclusion(), BlockSetType.WARPED));
    public static final RegistryObject<Block> DRAGON_TREE_TRAPDOOR = register("dragon_tree_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_TRAPDOOR).noOcclusion(), BlockSetType.WARPED));
    public static final RegistryObject<Block> DRAGON_TREE_LEAVES = register("dragon_tree_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.AZALEA_LEAVES)));
    public static final RegistryObject<Block> DRAGON_TREE_SAPLING = register("dragon_tree_sapling", () -> new ImportedEndTreeSaplingBlock(ImportedEndTreeSaplingBlock.Kind.DRAGON));
    public static final RegistryObject<Block> BARBED_SCULK_ROOT = register("barbed_sculk_root", ImportedBarbedSculkRootBlock::new);
    public static final RegistryObject<Item> BLOSSOM_BERRY = ITEMS.register("blossom_berry", () -> new Item(new Item.Properties().food(net.minecraft.world.food.Foods.APPLE)));
    public static final RegistryObject<Block> BLOSSOM_BERRY_SEED = register("blossom_berry_seed", () -> new ImportedEndCropBlock(5, BLOSSOM_BERRY));
    public static final RegistryObject<Item> SHADOW_BERRY_RAW = ITEMS.register("shadow_berry_raw", () -> new Item(new Item.Properties().food(net.minecraft.world.food.Foods.SWEET_BERRIES)));
    public static final RegistryObject<Block> SHADOW_BERRY = register("shadow_berry", () -> new ImportedEndCropBlock(3, SHADOW_BERRY_RAW));

    private BlackForgeBetterEndBlocks() {}

    private static StoneSet stoneSet(String name) {
        RegistryObject<Block> stone = solid(name, 0);
        RegistryObject<Block> polished = solid(name + "_polished", 0);
        RegistryObject<Block> tiles = solid(name + "_tiles", 0);
        RegistryObject<Block> pillar = register(name + "_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
        RegistryObject<Block> stairs = register(name + "_stairs", () -> new StairBlock(stone.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.END_STONE)));
        RegistryObject<Block> slab = register(name + "_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
        RegistryObject<Block> wall = register(name + "_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
        return new StoneSet(stone, polished, tiles, pillar, stairs, slab, wall);
    }

    private static RegistryObject<Block> solid(String name, int light) {
        return register(name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(state -> light)));
    }
    private static RegistryObject<Block> plant(String name, int light) { return register(name, () -> new ImportedEndPlantBlock(light)); }
    private static RegistryObject<Block> wallPlant(String name, int light) { return register(name, () -> new ImportedWallPlantBlock(light)); }
    private static Map<String, RegistryObject<Block>> coloredHydralux() {
        Map<String, RegistryObject<Block>> result = new LinkedHashMap<>();
        for (String color : new String[]{"white","orange","magenta","light_blue","yellow","lime","pink","gray","light_gray","cyan","purple","blue","brown","green","red","black"}) {
            result.put(color, solid("hydralux_petal_block_" + color, 8));
        }
        return result;
    }
    private static RegistryObject<Block> register(String name, Supplier<? extends Block> block) {
        RegistryObject<Block> value = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new BlockItem(value.get(), new Item.Properties()));
        return value;
    }
    public record StoneSet(RegistryObject<Block> stone, RegistryObject<Block> polished, RegistryObject<Block> tiles,
                           RegistryObject<Block> pillar, RegistryObject<Block> stairs, RegistryObject<Block> slab,
                           RegistryObject<Block> wall) {}
}
