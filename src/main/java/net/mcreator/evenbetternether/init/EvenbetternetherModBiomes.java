/*
 * Decompiled with CFR 0.153-local.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Suppliers
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Holder$Direct
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.world.level.biome.Biome
 *  net.minecraft.world.level.biome.BiomeGenerationSettings
 *  net.minecraft.world.level.biome.BiomeSource
 *  net.minecraft.world.level.biome.Climate$Parameter
 *  net.minecraft.world.level.biome.Climate$ParameterList
 *  net.minecraft.world.level.biome.Climate$ParameterPoint
 *  net.minecraft.world.level.biome.FeatureSorter
 *  net.minecraft.world.level.biome.MultiNoiseBiomeSource
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.dimension.BuiltinDimensionTypes
 *  net.minecraft.world.level.dimension.DimensionType
 *  net.minecraft.world.level.dimension.LevelStem
 *  net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator
 *  net.minecraft.world.level.levelgen.NoiseGeneratorSettings
 *  net.minecraft.world.level.levelgen.SurfaceRules
 *  net.minecraft.world.level.levelgen.SurfaceRules$ConditionSource
 *  net.minecraft.world.level.levelgen.SurfaceRules$RuleSource
 *  net.minecraft.world.level.levelgen.SurfaceRules$SequenceRuleSource
 *  net.minecraft.world.level.levelgen.placement.CaveSurface
 *  net.minecraftforge.event.server.ServerAboutToStartEvent
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 */
package net.mcreator.evenbetternether.init;

import com.google.common.base.Suppliers;
import com.mojang.datafixers.util.Pair;
import java.util.ArrayList;
import java.util.List;
import net.mcreator.evenbetternether.init.EvenbetternetherModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.FeatureSorter;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EvenbetternetherModBiomes {
    @SubscribeEvent
    public static void onServerAboutToStart(ServerAboutToStartEvent event) {
        MinecraftServer server = event.getServer();
        Registry dimensionTypeRegistry = server.registryAccess().registryOrThrow(Registries.DIMENSION_TYPE);
        Registry levelStemTypeRegistry = server.registryAccess().registryOrThrow(Registries.LEVEL_STEM);
        Registry biomeRegistry = server.registryAccess().registryOrThrow(Registries.BIOME);
        for (LevelStem levelStem : levelStemTypeRegistry.stream().toList()) {
            NoiseGeneratorSettings noiseGeneratorSettings;
            SurfaceRules.RuleSource currentRuleSource;
            NoiseBasedChunkGenerator noiseGenerator;
            DimensionType dimensionType = (DimensionType)levelStem.type().value();
            if (dimensionType != dimensionTypeRegistry.getOrThrow(BuiltinDimensionTypes.NETHER)) continue;
            ChunkGenerator chunkGenerator = levelStem.generator();
            BiomeSource biomeSource = chunkGenerator.getBiomeSource();
            if (biomeSource instanceof MultiNoiseBiomeSource) {
                MultiNoiseBiomeSource noiseSource = (MultiNoiseBiomeSource)biomeSource;
                ArrayList<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = new ArrayList<Pair<Climate.ParameterPoint, Holder<Biome>>>(noiseSource.parameters().values());
                EvenbetternetherModBiomes.addParameterPoint(parameters, (Pair<Climate.ParameterPoint, Holder<Biome>>)new Pair((Object)new Climate.ParameterPoint(Climate.Parameter.span((float)-1.0f, (float)0.0f), Climate.Parameter.span((float)-0.5f, (float)1.0f), Climate.Parameter.span((float)-2.0f, (float)2.0f), Climate.Parameter.span((float)-2.0f, (float)2.0f), Climate.Parameter.point((float)0.0f), Climate.Parameter.span((float)0.38f, (float)2.0f), 0L), (Object)biomeRegistry.getHolderOrThrow(ResourceKey.create((ResourceKey)Registries.BIOME, (ResourceLocation)new ResourceLocation("evenbetternether", "bone_reef")))));
                EvenbetternetherModBiomes.addParameterPoint(parameters, (Pair<Climate.ParameterPoint, Holder<Biome>>)new Pair((Object)new Climate.ParameterPoint(Climate.Parameter.span((float)-1.0f, (float)0.0f), Climate.Parameter.span((float)-0.5f, (float)1.0f), Climate.Parameter.span((float)-2.0f, (float)2.0f), Climate.Parameter.span((float)-2.0f, (float)2.0f), Climate.Parameter.point((float)1.0f), Climate.Parameter.span((float)0.38f, (float)2.0f), 0L), (Object)biomeRegistry.getHolderOrThrow(ResourceKey.create((ResourceKey)Registries.BIOME, (ResourceLocation)new ResourceLocation("evenbetternether", "bone_reef")))));
                EvenbetternetherModBiomes.addParameterPoint(parameters, (Pair<Climate.ParameterPoint, Holder<Biome>>)new Pair((Object)new Climate.ParameterPoint(Climate.Parameter.span((float)0.0f, (float)2.0f), Climate.Parameter.span((float)-1.0f, (float)0.5f), Climate.Parameter.span((float)-2.0f, (float)2.0f), Climate.Parameter.span((float)-2.0f, (float)2.0f), Climate.Parameter.point((float)0.0f), Climate.Parameter.span((float)0.38f, (float)2.0f), 0L), (Object)biomeRegistry.getHolderOrThrow(ResourceKey.create((ResourceKey)Registries.BIOME, (ResourceLocation)new ResourceLocation("evenbetternether", "gravel_desert")))));
                EvenbetternetherModBiomes.addParameterPoint(parameters, (Pair<Climate.ParameterPoint, Holder<Biome>>)new Pair((Object)new Climate.ParameterPoint(Climate.Parameter.span((float)0.0f, (float)2.0f), Climate.Parameter.span((float)-1.0f, (float)0.5f), Climate.Parameter.span((float)-2.0f, (float)2.0f), Climate.Parameter.span((float)-2.0f, (float)2.0f), Climate.Parameter.point((float)1.0f), Climate.Parameter.span((float)0.38f, (float)2.0f), 0L), (Object)biomeRegistry.getHolderOrThrow(ResourceKey.create((ResourceKey)Registries.BIOME, (ResourceLocation)new ResourceLocation("evenbetternether", "gravel_desert")))));
                EvenbetternetherModBiomes.addParameterPoint(parameters, (Pair<Climate.ParameterPoint, Holder<Biome>>)new Pair((Object)new Climate.ParameterPoint(Climate.Parameter.span((float)-1.0f, (float)0.0f), Climate.Parameter.span((float)-1.0f, (float)0.5f), Climate.Parameter.span((float)-2.0f, (float)2.0f), Climate.Parameter.span((float)-2.0f, (float)2.0f), Climate.Parameter.point((float)0.0f), Climate.Parameter.span((float)0.38f, (float)2.0f), 0L), (Object)biomeRegistry.getHolderOrThrow(ResourceKey.create((ResourceKey)Registries.BIOME, (ResourceLocation)new ResourceLocation("evenbetternether", "withered_valley")))));
                EvenbetternetherModBiomes.addParameterPoint(parameters, (Pair<Climate.ParameterPoint, Holder<Biome>>)new Pair((Object)new Climate.ParameterPoint(Climate.Parameter.span((float)-1.0f, (float)0.0f), Climate.Parameter.span((float)-1.0f, (float)0.5f), Climate.Parameter.span((float)-2.0f, (float)2.0f), Climate.Parameter.span((float)-2.0f, (float)2.0f), Climate.Parameter.point((float)1.0f), Climate.Parameter.span((float)0.38f, (float)2.0f), 0L), (Object)biomeRegistry.getHolderOrThrow(ResourceKey.create((ResourceKey)Registries.BIOME, (ResourceLocation)new ResourceLocation("evenbetternether", "withered_valley")))));
                EvenbetternetherModBiomes.addParameterPoint(parameters, (Pair<Climate.ParameterPoint, Holder<Biome>>)new Pair((Object)new Climate.ParameterPoint(Climate.Parameter.span((float)-1.0f, (float)1.0f), Climate.Parameter.span((float)0.2f, (float)2.0f), Climate.Parameter.span((float)-2.0f, (float)2.0f), Climate.Parameter.span((float)-2.0f, (float)2.0f), Climate.Parameter.point((float)0.0f), Climate.Parameter.span((float)0.53f, (float)2.0f), 0L), (Object)biomeRegistry.getHolderOrThrow(ResourceKey.create((ResourceKey)Registries.BIOME, (ResourceLocation)new ResourceLocation("evenbetternether", "mushroom_forest")))));
                EvenbetternetherModBiomes.addParameterPoint(parameters, (Pair<Climate.ParameterPoint, Holder<Biome>>)new Pair((Object)new Climate.ParameterPoint(Climate.Parameter.span((float)-1.0f, (float)1.0f), Climate.Parameter.span((float)0.2f, (float)2.0f), Climate.Parameter.span((float)-2.0f, (float)2.0f), Climate.Parameter.span((float)-2.0f, (float)2.0f), Climate.Parameter.point((float)1.0f), Climate.Parameter.span((float)0.53f, (float)2.0f), 0L), (Object)biomeRegistry.getHolderOrThrow(ResourceKey.create((ResourceKey)Registries.BIOME, (ResourceLocation)new ResourceLocation("evenbetternether", "mushroom_forest")))));
                chunkGenerator.biomeSource = MultiNoiseBiomeSource.createFromList((Climate.ParameterList)new Climate.ParameterList(parameters));
                chunkGenerator.featuresPerStep = Suppliers.memoize(() -> FeatureSorter.buildFeaturesPerStep(List.copyOf(chunkGenerator.biomeSource.possibleBiomes()), biome -> ((BiomeGenerationSettings)chunkGenerator.generationSettingsGetter.apply(biome)).features(), (boolean)true));
            }
            if (!(chunkGenerator instanceof NoiseBasedChunkGenerator) || null == (noiseGenerator = (NoiseBasedChunkGenerator)chunkGenerator) || !((currentRuleSource = (noiseGeneratorSettings = (NoiseGeneratorSettings)noiseGenerator.settings.value()).surfaceRule()) instanceof SurfaceRules.SequenceRuleSource)) continue;
            SurfaceRules.SequenceRuleSource sequenceRuleSource = (SurfaceRules.SequenceRuleSource)currentRuleSource;
            ArrayList<SurfaceRules.RuleSource> surfaceRules = new ArrayList<SurfaceRules.RuleSource>(sequenceRuleSource.sequence());
            EvenbetternetherModBiomes.addSurfaceRule(surfaceRules, 2, EvenbetternetherModBiomes.anySurfaceRule((ResourceKey<Biome>)ResourceKey.create((ResourceKey)Registries.BIOME, (ResourceLocation)new ResourceLocation("evenbetternether", "bone_reef")), ((Block)EvenbetternetherModBlocks.VERDANT_NYLIUM.get()).defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState()));
            EvenbetternetherModBiomes.addSurfaceRule(surfaceRules, 2, EvenbetternetherModBiomes.anySurfaceRule((ResourceKey<Biome>)ResourceKey.create((ResourceKey)Registries.BIOME, (ResourceLocation)new ResourceLocation("evenbetternether", "gravel_desert")), Blocks.GRAVEL.defaultBlockState(), Blocks.GRAVEL.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState()));
            EvenbetternetherModBiomes.addSurfaceRule(surfaceRules, 2, EvenbetternetherModBiomes.anySurfaceRule((ResourceKey<Biome>)ResourceKey.create((ResourceKey)Registries.BIOME, (ResourceLocation)new ResourceLocation("evenbetternether", "withered_valley")), ((Block)EvenbetternetherModBlocks.WITHERED_NYLIUM.get()).defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState()));
            EvenbetternetherModBiomes.addSurfaceRule(surfaceRules, 2, EvenbetternetherModBiomes.anySurfaceRule((ResourceKey<Biome>)ResourceKey.create((ResourceKey)Registries.BIOME, (ResourceLocation)new ResourceLocation("evenbetternether", "mushroom_forest")), ((Block)EvenbetternetherModBlocks.NYCELIUM.get()).defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState()));
            NoiseGeneratorSettings moddedNoiseGeneratorSettings = new NoiseGeneratorSettings(noiseGeneratorSettings.noiseSettings(), noiseGeneratorSettings.defaultBlock(), noiseGeneratorSettings.defaultFluid(), noiseGeneratorSettings.noiseRouter(), SurfaceRules.sequence((SurfaceRules.RuleSource[])((SurfaceRules.RuleSource[])surfaceRules.toArray(SurfaceRules.RuleSource[]::new))), noiseGeneratorSettings.spawnTarget(), noiseGeneratorSettings.seaLevel(), noiseGeneratorSettings.disableMobGeneration(), noiseGeneratorSettings.aquifersEnabled(), noiseGeneratorSettings.oreVeinsEnabled(), noiseGeneratorSettings.useLegacyRandomSource());
            noiseGenerator.settings = new Holder.Direct((Object)moddedNoiseGeneratorSettings);
        }
    }

    private static SurfaceRules.RuleSource anySurfaceRule(ResourceKey<Biome> biomeKey, BlockState groundBlock, BlockState undergroundBlock, BlockState underwaterBlock) {
        return SurfaceRules.ifTrue((SurfaceRules.ConditionSource)SurfaceRules.isBiome((ResourceKey[])new ResourceKey[]{biomeKey}), (SurfaceRules.RuleSource)SurfaceRules.sequence((SurfaceRules.RuleSource[])new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue((SurfaceRules.ConditionSource)SurfaceRules.stoneDepthCheck((int)0, (boolean)false, (int)0, (CaveSurface)CaveSurface.FLOOR), (SurfaceRules.RuleSource)SurfaceRules.sequence((SurfaceRules.RuleSource[])new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue((SurfaceRules.ConditionSource)SurfaceRules.waterBlockCheck((int)-1, (int)0), (SurfaceRules.RuleSource)SurfaceRules.state((BlockState)groundBlock)), SurfaceRules.state((BlockState)underwaterBlock)})), SurfaceRules.ifTrue((SurfaceRules.ConditionSource)SurfaceRules.stoneDepthCheck((int)0, (boolean)true, (int)0, (CaveSurface)CaveSurface.FLOOR), (SurfaceRules.RuleSource)SurfaceRules.state((BlockState)undergroundBlock))}));
    }

    private static void addParameterPoint(List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters, Pair<Climate.ParameterPoint, Holder<Biome>> point) {
        if (!parameters.contains(point)) {
            parameters.add(point);
        }
    }

    private static void addSurfaceRule(List<SurfaceRules.RuleSource> surfaceRules, int index, SurfaceRules.RuleSource rule) {
        if (!surfaceRules.contains(rule)) {
            surfaceRules.add(index, rule);
        }
    }
}

