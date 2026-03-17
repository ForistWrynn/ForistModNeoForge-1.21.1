package net.forist.forist_mod.item;

import net.forist.forist_mod.ForistMod;
import net.forist.forist_mod.item.custom.TotemOfLife;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ForistMod.MOD_ID);

    public static final DeferredItem<Item>  SCARLITE =
            ITEMS.registerSimpleItem("scarlite");
    public static final DeferredItem<Item>  RAW_SCARLITE =
            ITEMS.registerItem("raw_scarlite", Item::new, new Item.Properties());

    public static final DeferredItem<Item>  BLACK_OPAL =
            ITEMS.registerSimpleItem("black_opal");

    public static final DeferredItem<Item>  RAW_BLACK_OPAL =
            ITEMS.registerSimpleItem("raw_black_opal");

    public static final DeferredItem<Item>  TOMATO =
            ITEMS.registerItem("tomato", Item::new, new Item.Properties().food(ModFoodProperties.TOMATO));

    //CUSTOM ITEM
    public static final DeferredItem<Item> TOTEM_OF_LIFE = ITEMS.register("totem_of_life",
            () -> new TotemOfLife(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
