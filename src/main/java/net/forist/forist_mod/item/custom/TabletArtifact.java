package net.forist.forist_mod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class TabletArtifact extends Item
{
    public TabletArtifact(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected)
    {
        super.inventoryTick(stack, level, entity, slotId, isSelected);

        if (level.isClientSide) return;
        if (!(entity instanceof Player player)) return;

        //Refresh effect only when needed
        MobEffectInstance currentEffect = player.getEffect(MobEffects.REGENERATION);

        if (currentEffect == null || currentEffect.getDuration() <= 10)
        {
            player.addEffect(new MobEffectInstance(
                    MobEffects.LUCK,
                    40,
                    0,
                    true,
                    false,
                    true
            ));
        }


    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component>
            tooltipComponents, TooltipFlag tooltipFlag)
    {
        if (Screen.hasShiftDown())
        {
            tooltipComponents.add(Component.translatable("tooltips.forist_mod.tablet_artifact.tooltips.1"));
            tooltipComponents.add(Component.translatable("tooltips.forist_mod.tablet_artifact.tooltips.2"));
        }
        else
        {
            tooltipComponents.add(Component.translatable("tooltips.forist_mod.tablet_artifact.tooltips.shift"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
