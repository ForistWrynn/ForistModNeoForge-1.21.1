package net.forist.forist_mod.villager;

import com.google.common.collect.ImmutableSet;
import net.forist.forist_mod.ForistMod;
import net.forist.forist_mod.block.ModBlocks;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, ForistMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, ForistMod.MOD_ID);

    public static final Holder<PoiType> MAGIC_POI = POI_TYPES.register("magic_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.MAGIC_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final Holder<PoiType> EXPLORE_POI = POI_TYPES.register("explore_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.BLACK_OPAL_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1,1));

    public static final Holder<VillagerProfession> KAUPENGER = VILLAGER_PROFESSIONS.register("kaupenger",
            () -> new VillagerProfession("kaupenger", holder -> holder.value() == MAGIC_POI.value(),
                    holder -> holder.value() == MAGIC_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_CARTOGRAPHER));

    public static final Holder<VillagerProfession> EXPLORER = VILLAGER_PROFESSIONS.register("explorer",
            () -> new VillagerProfession("explorer", holder -> holder.value() == EXPLORE_POI.value(),
                    holder -> holder.value() == EXPLORE_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_CARTOGRAPHER));



    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}