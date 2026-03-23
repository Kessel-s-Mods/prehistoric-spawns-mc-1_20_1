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

@Mod.EventBusSubscriber(modid = AncientEarth.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpawnsData {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Server-side data: Custom provider for Biome Modifiers (JSONs)
        generator.addProvider(event.includeServer(), new PrehistoricBiomeModifiers(output, lookupProvider));

        // Server-side data: Datapack entries provider (Required to initialize lookup for tags)
        generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(output, lookupProvider, new RegistrySetBuilder(), Set.of(AncientEarth.MODID)));

        // Tags
        generator.addProvider(event.includeServer(), new PrehistoricBiomeTags(output, lookupProvider, existingFileHelper));
    }

    public static class PrehistoricBiomeTags extends TagsProvider<Biome> {

        public PrehistoricBiomeTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
            super(output, Registries.BIOME, lookupProvider, AncientEarth.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag("badlands").add(getRLs(AncientEarth.getBadlandsBiomes()));
            tag("wooded_badlands").add(getRLs(AncientEarth.getWoodedBadlandsBiomes()));
            tag("beach").add(getRLs(AncientEarth.getBeachBiomes()));
            tag("rocky_beach").add(getRLs(AncientEarth.getRockyBeachBiomes()));
            tag("desert").add(getRLs(AncientEarth.getDesertBiomes()));
            tag("red_desert").add(getRLs(AncientEarth.getRedDesertBiomes()));
            tag("forest").add(getRLs(AncientEarth.getForestBiomes()));
            tag("autumnal_forest").add(getRLs(AncientEarth.getAutumnalForestBiomes()));
            tag("birch_forest").add(getRLs(AncientEarth.getBirchForestBiomes()));
            tag("cherry_forest").add(getRLs(AncientEarth.getCherryForestBiomes()));
            tag("dark_forest").add(getRLs(AncientEarth.getDarkForestBiomes()));
            tag("sparse_forest").add(getRLs(AncientEarth.getSparseForestBiomes()));
            tag("frozen").add(getRLs(AncientEarth.getFrozenBiomes()));
            tag("tundra").add(getRLs(AncientEarth.getTundraBiomes()));
            tag("mountain").add(getRLs(AncientEarth.getMountainBiomes()));
            tag("snowy_mountain").add(getRLs(AncientEarth.getSnowyMountainBiomes()));
            tag("plains").add(getRLs(AncientEarth.getPlainsBiomes()));
            tag("floral_fields").add(getRLs(AncientEarth.getFloralFieldsBiomes()));
            tag("highlands").add(getRLs(AncientEarth.getHighlandsBiomes()));
            tag("prairie").add(getRLs(AncientEarth.getPrairieBiomes()));
            tag("savanna").add(getRLs(AncientEarth.getSavannaBiomes()));
            tag("sparse_savanna").add(getRLs(AncientEarth.getSparseSavannaBiomes()));
            tag("dense_savanna").add(getRLs(AncientEarth.getDenseSavannaBiomes()));
            tag("seasonal").add(getRLs(AncientEarth.getSeasonalBiomes()));
            tag("dense_seasonal").add(getRLs(AncientEarth.getDenseSeasonalBiomes()));
            tag("dense_semi_arid").add(getRLs(AncientEarth.getDenseSemiAridBiomes()));
            tag("sparse_semi_arid").add(getRLs(AncientEarth.getSparseSemiAridBiomes()));
            tag("swamp").add(getRLs(AncientEarth.getSwampBiomes()));
            tag("marsh").add(getRLs(AncientEarth.getMarshBiomes()));
            tag("waterlogged_swamp").add(getRLs(AncientEarth.getWaterloggedSwampBiomes()));
            tag("taiga").add(getRLs(AncientEarth.getTaigaBiomes()));
            tag("mega_taiga").add(getRLs(AncientEarth.getMegaTaigaBiomes()));
            tag("snowy_taiga").add(getRLs(AncientEarth.getSnowyTaigaBiomes()));
            tag("sparse_taiga").add(getRLs(AncientEarth.getSparseTaigaBiomes()));
            tag("redwood").add(getRLs(AncientEarth.getRedwoodBiomes()));
            tag("tropical").add(getRLs(AncientEarth.getTropicalBiomes()));
            tag("sparse_tropical").add(getRLs(AncientEarth.getSparseTropicalBiomes()));
            tag("dense_tropical").add(getRLs(AncientEarth.getDenseTropicalBiomes()));
            tag("ocean").add(getRLs(AncientEarth.getOceanBiomes()));
            tag("deep_ocean").add(getRLs(AncientEarth.getDeepOceanBiomes()));
            tag("cold_ocean").add(getRLs(AncientEarth.getColdOceanBiomes()));
            tag("deep_cold_ocean").add(getRLs(AncientEarth.getDeepColdOceanBiomes()));
            tag("warm_ocean").add(getRLs(AncientEarth.getWarmOceanBiomes()));
            tag("deep_warm_ocean").add(getRLs(AncientEarth.getDeepWarmOceanBiomes()));
            tag("frozen_ocean").add(getRLs(AncientEarth.getFrozenOceanBiomes()));
            tag("deep_frozen_ocean").add(getRLs(AncientEarth.getDeepFrozenOceanBiomes()));
            tag("river").add(getRLs(AncientEarth.getRiverBiomes()));
        }

        private TagAppender<Biome> tag(String name) {
            return this.tag(TagKey.create(Registries.BIOME, new ResourceLocation(AncientEarth.MODID, name)));
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
                Map<String, List<AncientEarth.SpawnerData>> spawns = AncientEarth.createSpawnerMap();

                for (Map.Entry<String, List<AncientEarth.SpawnerData>> entry : spawns.entrySet()) {
                    String biomeTagName = entry.getKey();
                    for (AncientEarth.SpawnerData data : entry.getValue()) {
                        buildModifier(cachedOutput, biomeTagName, data);
                    }
                }
            });
        }


        private void buildModifier(CachedOutput cachedOutput, String biomeTagName, AncientEarth.SpawnerData data) {
            String entityName = ForgeRegistries.ENTITY_TYPES.getKey(data.type).getPath();
            String fileName = entityName + "_in_" + biomeTagName;

            JsonObject json = new JsonObject();
            json.addProperty("__comment", "Generated by Ancient Earth");
            
            //Tipo correcto del serializer registrado por Forge
            json.addProperty("type", "forge:add_spawns");

            //Formato correcto para tags: "#modid:tag_name"
            json.addProperty("biomes", "#" + AncientEarth.MODID + ":" + biomeTagName);

            JsonArray spawnersArray = new JsonArray();
            JsonObject spawnerEntry = new JsonObject();
            spawnerEntry.addProperty("type", ForgeRegistries.ENTITY_TYPES.getKey(data.type).toString());
            spawnerEntry.addProperty("weight", data.weight);
            spawnerEntry.addProperty("minCount", data.minCount);
            spawnerEntry.addProperty("maxCount", data.maxCount);
            spawnersArray.add(spawnerEntry);
            json.add("spawners", spawnersArray);

            Path path = this.output.getOutputFolder()
                .resolve("data/" + AncientEarth.MODID + "/forge/biome_modifier/" + fileName + ".json");
            DataProvider.saveStable(cachedOutput, json, path);
        }

        @Override
        public String getName() {
            return "Prehistoric Spawns Biome Modifiers";
        }
    }
}