package com.kesselot.ancientearth;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = PrehistoricSpawns.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PrehistoricSpawnsData {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Server-side data: Custom provider for Biome Modifiers (JSONs)
        generator.addProvider(event.includeServer(), new PrehistoricBiomeModifiers(output, lookupProvider));

        // Server-side data: Datapack entries provider (Required to initialize lookup for tags)
        generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(output, lookupProvider, new RegistrySetBuilder(), Set.of(PrehistoricSpawns.MODID)));

        // Tags
        generator.addProvider(event.includeServer(), new PrehistoricBiomeTags(output, lookupProvider, existingFileHelper));
    }

    public static class PrehistoricBiomeTags extends TagsProvider<Biome> {

        public PrehistoricBiomeTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
            super(output, Registries.BIOME, lookupProvider, PrehistoricSpawns.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag("badlands").add(getRLs(PrehistoricSpawns.getBadlandsBiomes()));
            tag("wooded_badlands").add(getRLs(PrehistoricSpawns.getWoodedBadlandsBiomes()));
            tag("beach").add(getRLs(PrehistoricSpawns.getBeachBiomes()));
            tag("rocky_beach").add(getRLs(PrehistoricSpawns.getRockyBeachBiomes()));
            tag("desert").add(getRLs(PrehistoricSpawns.getDesertBiomes()));
            tag("red_desert").add(getRLs(PrehistoricSpawns.getRedDesertBiomes()));
            tag("forest").add(getRLs(PrehistoricSpawns.getForestBiomes()));
            tag("autumnal_forest").add(getRLs(PrehistoricSpawns.getAutumnalForestBiomes()));
            tag("birch_forest").add(getRLs(PrehistoricSpawns.getBirchForestBiomes()));
            tag("cherry_forest").add(getRLs(PrehistoricSpawns.getCherryForestBiomes()));
            tag("dark_forest").add(getRLs(PrehistoricSpawns.getDarkForestBiomes()));
            tag("sparse_forest").add(getRLs(PrehistoricSpawns.getSparseForestBiomes()));
            tag("frozen").add(getRLs(PrehistoricSpawns.getFrozenBiomes()));
            tag("tundra").add(getRLs(PrehistoricSpawns.getTundraBiomes()));
            tag("mountain").add(getRLs(PrehistoricSpawns.getMountainBiomes()));
            tag("snowy_mountain").add(getRLs(PrehistoricSpawns.getSnowyMountainBiomes()));
            tag("plains").add(getRLs(PrehistoricSpawns.getPlainsBiomes()));
            tag("floral_fields").add(getRLs(PrehistoricSpawns.getFloralFieldsBiomes()));
            tag("highlands").add(getRLs(PrehistoricSpawns.getHighlandsBiomes()));
            tag("prairie").add(getRLs(PrehistoricSpawns.getPrairieBiomes()));
            tag("savanna").add(getRLs(PrehistoricSpawns.getSavannaBiomes()));
            tag("sparse_savanna").add(getRLs(PrehistoricSpawns.getSparseSavannaBiomes()));
            tag("dense_savanna").add(getRLs(PrehistoricSpawns.getDenseSavannaBiomes()));
            tag("seasonal").add(getRLs(PrehistoricSpawns.getSeasonalBiomes()));
            tag("dense_seasonal").add(getRLs(PrehistoricSpawns.getDenseSeasonalBiomes()));
            tag("dense_semi_arid").add(getRLs(PrehistoricSpawns.getDenseSemiAridBiomes()));
            tag("sparse_semi_arid").add(getRLs(PrehistoricSpawns.getSparseSemiAridBiomes()));
            tag("swamp").add(getRLs(PrehistoricSpawns.getSwampBiomes()));
            tag("marsh").add(getRLs(PrehistoricSpawns.getMarshBiomes()));
            tag("waterlogged_swamp").add(getRLs(PrehistoricSpawns.getWaterloggedSwampBiomes()));
            tag("taiga").add(getRLs(PrehistoricSpawns.getTaigaBiomes()));
            tag("mega_taiga").add(getRLs(PrehistoricSpawns.getMegaTaigaBiomes()));
            tag("snowy_taiga").add(getRLs(PrehistoricSpawns.getSnowyTaigaBiomes()));
            tag("sparse_taiga").add(getRLs(PrehistoricSpawns.getSparseTaigaBiomes()));
            tag("redwood").add(getRLs(PrehistoricSpawns.getRedwoodBiomes()));
            tag("tropical").add(getRLs(PrehistoricSpawns.getTropicalBiomes()));
            tag("sparse_tropical").add(getRLs(PrehistoricSpawns.getSparseTropicalBiomes()));
            tag("dense_tropical").add(getRLs(PrehistoricSpawns.getDenseTropicalBiomes()));
            tag("ocean").add(getRLs(PrehistoricSpawns.getOceanBiomes()));
            tag("deep_ocean").add(getRLs(PrehistoricSpawns.getDeepOceanBiomes()));
            tag("cold_ocean").add(getRLs(PrehistoricSpawns.getColdOceanBiomes()));
            tag("deep_cold_ocean").add(getRLs(PrehistoricSpawns.getDeepColdOceanBiomes()));
            tag("warm_ocean").add(getRLs(PrehistoricSpawns.getWarmOceanBiomes()));
            tag("deep_warm_ocean").add(getRLs(PrehistoricSpawns.getDeepWarmOceanBiomes()));
            tag("frozen_ocean").add(getRLs(PrehistoricSpawns.getFrozenOceanBiomes()));
            tag("deep_frozen_ocean").add(getRLs(PrehistoricSpawns.getDeepFrozenOceanBiomes()));
            tag("river").add(getRLs(PrehistoricSpawns.getRiverBiomes()));
        }

        private TagAppender<Biome> tag(String name) {
            return this.tag(TagKey.create(Registries.BIOME, new ResourceLocation(PrehistoricSpawns.MODID, name)));
        }

        private ResourceKey<Biome>[] getRLs(ResourceLocation[] locs) {
            return java.util.Arrays.stream(locs)
                    .map(rl -> ResourceKey.create(Registries.BIOME, rl))
                    .toArray(ResourceKey[]::new);
        }
    }

    public static class PrehistoricBiomeModifiers implements DataProvider {

        private final PackOutput output;
        private final CompletableFuture<HolderLookup.Provider> lookupProvider;

        public PrehistoricBiomeModifiers(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            this.output = output;
            this.lookupProvider = lookupProvider;
        }

        @Override
        public CompletableFuture<?> run(CachedOutput cachedOutput) {
            return lookupProvider.thenAccept(provider -> {
                Map<String, List<PrehistoricSpawns.SpawnerData>> spawns = PrehistoricSpawns.createSpawnerMap();

                for (Map.Entry<String, List<PrehistoricSpawns.SpawnerData>> entry : spawns.entrySet()) {
                    String biomeTagName = entry.getKey();
                    for (PrehistoricSpawns.SpawnerData data : entry.getValue()) {
                        buildModifier(cachedOutput, biomeTagName, data);
                    }
                }
            });
        }

        private void buildModifier(CachedOutput cachedOutput, String biomeTagName, PrehistoricSpawns.SpawnerData data) {
            String entityName = ForgeRegistries.ENTITY_TYPES.getKey(data.type).getPath();
            String fileName = entityName + "_in_" + biomeTagName;

            JsonObject json = new JsonObject();
            json.addProperty("__comment", "Generated by PrehistoricSpawns");

            json.addProperty("type", "forge:add_spawns");

            JsonObject biomesObj = new JsonObject();
            biomesObj.addProperty("tag", PrehistoricSpawns.MODID + ":" + biomeTagName);
            json.add("biomes", biomesObj);

            JsonArray spawnersArray = new JsonArray();
            JsonObject spawnerEntry = new JsonObject();
            spawnerEntry.addProperty("type", ForgeRegistries.ENTITY_TYPES.getKey(data.type).toString());
            spawnerEntry.addProperty("weight", data.weight);
            spawnerEntry.addProperty("minCount", data.minCount);
            spawnerEntry.addProperty("maxCount", data.maxCount);
            spawnersArray.add(spawnerEntry);
            json.add("spawners", spawnersArray);

            Path path = this.output.getOutputFolder().resolve("data/" + PrehistoricSpawns.MODID + "/forge/biome_modifier/" + fileName + ".json");
            DataProvider.saveStable(cachedOutput, json, path);
        }

        @Override
        public String getName() {
            return "Prehistoric Spawns Biome Modifiers";
        }
    }
}