package net.forist.forist_mod.datagen;

import net.forist.forist_mod.ForistMod;
import net.forist.forist_mod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ForistMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BLACK_OPAL.get());
        basicItem(ModItems.RAW_BLACK_OPAL.get());
        basicItem(ModItems.TOMATO.get());
        basicItem(ModItems.SCARLITE.get());
        basicItem(ModItems.RAW_SCARLITE.get());
        basicItem(ModItems.TOTEM_OF_LIFE.get());
    }
}
