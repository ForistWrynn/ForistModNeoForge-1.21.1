package net.forist.forist_mod.item;

import net.forist.forist_mod.ForistMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ForistMod.MOD_ID);

    public static final DeferredItem<Item>  SCARLITE = ITEMS.registerSimpleItem("scarlite");
    public static final DeferredItem<Item>  RAW_SCARLITE =
            ITEMS.registerItem("raw_scarlite", Item::new, new Item.Properties());

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
