package net.forist.forist_mod.item;

import net.forist.forist_mod.ForistMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ForistMod.MOD_ID);

    public static final Supplier<CreativeModeTab> FORIST_MOD_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("forist_mod_item_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.forist_mod.forist_mod_item_tab"))
                    .icon(()-> new ItemStack(ModItems.SCARLITE.get()))
                    .displayItems((pParameters, pOutput) -> {
                       pOutput.accept(ModItems.RAW_SCARLITE);
                       pOutput.accept(ModItems.SCARLITE);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> FORIST_MOD_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("forist_mod_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.forist_mod.forist_mod_blocks_tab"))
                    .icon(()-> new ItemStack(ModItems.RAW_SCARLITE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ForistMod.MOD_ID,"forist_mod_item_tab"))

                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Blocks.BAMBOO_FENCE);
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
