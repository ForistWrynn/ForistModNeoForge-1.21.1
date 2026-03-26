package net.forist.forist_mod.datagen;

import net.forist.forist_mod.ForistMod;
import net.forist.forist_mod.item.ModItems;
import net.forist.forist_mod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                              CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, ForistMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.DIAMOND);

        tag(ModTags.Items.EXPLORER_TRADE_POTTERY)
                .add(Items.PLENTY_POTTERY_SHERD)
                .add(Items.ANGLER_POTTERY_SHERD)
                .add(Items.PRIZE_POTTERY_SHERD)
                .add(Items.ARCHER_POTTERY_SHERD)
                .add(Items.BLADE_POTTERY_SHERD);
    }
}
