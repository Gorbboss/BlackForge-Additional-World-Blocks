/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.levelgen.feature.Feature
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package net.mcreator.evenbetternether.init;

import net.mcreator.evenbetternether.world.features.BasaltStalagmiteFeature;
import net.mcreator.evenbetternether.world.features.BasaltStalagtiteFeature;
import net.mcreator.evenbetternether.world.features.BlackstoneStalagmiteFeature;
import net.mcreator.evenbetternether.world.features.BlackstoneStalagtiteFeature;
import net.mcreator.evenbetternether.world.features.BoneStalagmiteFeature;
import net.mcreator.evenbetternether.world.features.BoneStalagtiteFeature;
import net.mcreator.evenbetternether.world.features.BulbousHangingMyceliumFeatureFeature;
import net.mcreator.evenbetternether.world.features.DeepslateStalagmiteFeature;
import net.mcreator.evenbetternether.world.features.DeepslateStalagtiteFeature;
import net.mcreator.evenbetternether.world.features.GlowstoneStalagmiteFeature;
import net.mcreator.evenbetternether.world.features.GlowstoneStalagtiteFeature;
import net.mcreator.evenbetternether.world.features.HangingMyceliumFeatureFeature;
import net.mcreator.evenbetternether.world.features.LongHangingMyceliumFeatureFeature;
import net.mcreator.evenbetternether.world.features.NetherrackStalagmiteFeature;
import net.mcreator.evenbetternether.world.features.NetherrackStalagtiteFeature;
import net.mcreator.evenbetternether.world.features.SSVBasaltStalagmiteFeature;
import net.mcreator.evenbetternether.world.features.SSVBasaltStalagtiteFeature;
import net.mcreator.evenbetternether.world.features.StoneStalagmiteFeature;
import net.mcreator.evenbetternether.world.features.StoneStalagtiteFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber
public class EvenbetternetherModFeatures {
    public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create((IForgeRegistry)ForgeRegistries.FEATURES, (String)"evenbetternether");
    public static final RegistryObject<Feature<?>> IMPORTED_CACTUS_PLANTS = REGISTRY.register("imported_cactus_plants", () -> new net.mcreator.evenbetternether.world.features.ImportedDesertPlantsFeature(true));
    public static final RegistryObject<Feature<?>> IMPORTED_DUNE_GRASS = REGISTRY.register("imported_dune_grass", () -> new net.mcreator.evenbetternether.world.features.ImportedDesertPlantsFeature(false));
    public static final RegistryObject<Feature<?>> HYDRALUX_POOL = REGISTRY.register("hydralux_pool", net.mcreator.evenbetternether.world.features.ImportedHydraluxPoolFeature::new);
    public static final RegistryObject<Feature<?>> PALLIDIUM_FORMATION = REGISTRY.register("pallidium_formation", net.mcreator.evenbetternether.world.features.ImportedPallidiumFormationFeature::new);
    public static final RegistryObject<Feature<?>> UMBRALITH_ARCH = REGISTRY.register("umbralith_arch", net.mcreator.evenbetternether.world.features.ImportedUmbralithArchFeature::new);
    public static final RegistryObject<Feature<?>> NETHERRACK_STALAGMITE = REGISTRY.register("netherrack_stalagmite", NetherrackStalagmiteFeature::new);
    public static final RegistryObject<Feature<?>> NETHERRACK_STALAGTITE = REGISTRY.register("netherrack_stalagtite", NetherrackStalagtiteFeature::new);
    public static final RegistryObject<Feature<?>> BASALT_STALAGMITE = REGISTRY.register("basalt_stalagmite", BasaltStalagmiteFeature::new);
    public static final RegistryObject<Feature<?>> BASALT_STALAGTITE = REGISTRY.register("basalt_stalagtite", BasaltStalagtiteFeature::new);
    public static final RegistryObject<Feature<?>> BLACKSTONE_STALAGMITE = REGISTRY.register("blackstone_stalagmite", BlackstoneStalagmiteFeature::new);
    public static final RegistryObject<Feature<?>> BLACKSTONE_STALAGTITE = REGISTRY.register("blackstone_stalagtite", BlackstoneStalagtiteFeature::new);
    public static final RegistryObject<Feature<?>> GLOWSTONE_STALAGMITE = REGISTRY.register("glowstone_stalagmite", GlowstoneStalagmiteFeature::new);
    public static final RegistryObject<Feature<?>> GLOWSTONE_STALAGTITE = REGISTRY.register("glowstone_stalagtite", GlowstoneStalagtiteFeature::new);
    public static final RegistryObject<Feature<?>> SSV_BASALT_STALAGMITE = REGISTRY.register("ssv_basalt_stalagmite", SSVBasaltStalagmiteFeature::new);
    public static final RegistryObject<Feature<?>> SSV_BASALT_STALAGTITE = REGISTRY.register("ssv_basalt_stalagtite", SSVBasaltStalagtiteFeature::new);
    public static final RegistryObject<Feature<?>> BONE_STALAGMITE = REGISTRY.register("bone_stalagmite", BoneStalagmiteFeature::new);
    public static final RegistryObject<Feature<?>> BONE_STALAGTITE = REGISTRY.register("bone_stalagtite", BoneStalagtiteFeature::new);
    public static final RegistryObject<Feature<?>> STONE_STALAGMITE = REGISTRY.register("stone_stalagmite", StoneStalagmiteFeature::new);
    public static final RegistryObject<Feature<?>> STONE_STALAGTITE = REGISTRY.register("stone_stalagtite", StoneStalagtiteFeature::new);
    public static final RegistryObject<Feature<?>> DEEPSLATE_STALAGMITE = REGISTRY.register("deepslate_stalagmite", DeepslateStalagmiteFeature::new);
    public static final RegistryObject<Feature<?>> DEEPSLATE_STALAGTITE = REGISTRY.register("deepslate_stalagtite", DeepslateStalagtiteFeature::new);
    public static final RegistryObject<Feature<?>> HANGING_MYCELIUM_FEATURE = REGISTRY.register("hanging_mycelium_feature", HangingMyceliumFeatureFeature::new);
    public static final RegistryObject<Feature<?>> LONG_HANGING_MYCELIUM_FEATURE = REGISTRY.register("long_hanging_mycelium_feature", LongHangingMyceliumFeatureFeature::new);
    public static final RegistryObject<Feature<?>> BULBOUS_HANGING_MYCELIUM_FEATURE = REGISTRY.register("bulbous_hanging_mycelium_feature", BulbousHangingMyceliumFeatureFeature::new);
}

