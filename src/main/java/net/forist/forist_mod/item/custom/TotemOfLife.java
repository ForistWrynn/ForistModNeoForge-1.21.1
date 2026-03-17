package net.forist.forist_mod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TotemOfLife extends Item
{
    public TotemOfLife(Properties properties) {
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
                    MobEffects.REGENERATION,
                    40,
                    0,
                    true,
                    false,
                    true
            ));
        }
    }
}
