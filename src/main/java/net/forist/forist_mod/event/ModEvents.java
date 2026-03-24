package net.forist.forist_mod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.forist.forist_mod.ForistMod;
import net.forist.forist_mod.item.ModItems;
import net.forist.forist_mod.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;

@EventBusSubscriber(modid = ForistMod.MOD_ID,bus = EventBusSubscriber.Bus.GAME)
public class ModEvents
{
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(ModItems.TOMATO.get(), 8), 8, 4, 0.05f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.ENDER_PEARL, 12),
                    new ItemStack(ModItems.RAW_BLACK_OPAL.get(), 1), 1, 9, 0.05f
            ));
        }

        if (event.getType() == ModVillagers.KAUPENGER.value())
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModItems.TOTEM_OF_LIFE.get(), 1), 1, 9, 0.05f
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(ModItems.TOMATO.get(), 8), 8, 4, 0.05f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.ENDER_PEARL, 12),
                    new ItemStack(ModItems.RAW_BLACK_OPAL.get(), 1), 1, 9, 0.05f
            ));

        }

        if (event.getType() == ModVillagers.EXPLORER.value())
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModItems.TOTEM_OF_LIFE.get(), 1), 1, 9, 0.05f
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(Items.BRUSH, 8), 8, 4, 0.05f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.ENDER_PEARL, 12),
                    new ItemStack(ModItems.RAW_BLACK_OPAL.get(), 1), 1, 9, 0.05f
            ));
        }
    }
}
