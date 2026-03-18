package net.forist.forist_mod.item;

import net.forist.forist_mod.ForistMod;
import net.forist.forist_mod.block.ModBlocks;
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
                       pOutput.accept(ModItems.RAW_BLACK_OPAL);
                       pOutput.accept(ModItems.BLACK_OPAL);

                       pOutput.accept(ModItems.TOMATO);

                       pOutput.accept(ModItems.TOTEM_OF_LIFE);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> FORIST_MOD_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("forist_mod_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.forist_mod.forist_mod_blocks_tab"))
                    .icon(()-> new ItemStack(ModBlocks.BLACK_OPAL_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ForistMod.MOD_ID,"forist_mod_item_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModBlocks.BLACK_OPAL_BLOCK);
                        pOutput.accept(ModBlocks.RAW_BLACK_OPAL_BLOCK);
                        pOutput.accept(ModBlocks.BLACK_OPAL_ORE);
                        pOutput.accept(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE);
                        pOutput.accept(ModBlocks.BLACK_OPAL_NETHER_ORE);
                        pOutput.accept(ModBlocks.BLACK_OPAL_END_ORE);

                        pOutput.accept(ModBlocks.MAGIC_BLOCK);

                        pOutput.accept(ModBlocks.SANDSTONE_BRICK);
                        pOutput.accept(ModBlocks.SANDSTONE_BIG_BRICK);

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
