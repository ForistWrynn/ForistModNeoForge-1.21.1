package net.forist.forist_mod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class DarknessBlock extends Block {
    public DarknessBlock(Properties properties) {super(properties);}

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity)
    {
        if (!level.isClientSide && entity instanceof Player player)
        {

            if (!player.hasEffect(MobEffects.DARKNESS))
            {
                level.playSound(player, pos, SoundEvents.WARDEN_HEARTBEAT, SoundSource.BLOCKS, 1f, 1f);
                player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 300, 0));
            }
        super.stepOn(level, pos, state, entity);
        }
    }
}
