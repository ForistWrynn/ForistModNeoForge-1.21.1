package net.forist.forist_mod.block.custom;

import net.forist.forist_mod.block.ModBlocks;
import net.forist.forist_mod.item.ModItems;
import net.forist.forist_mod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class PharoahKeystone extends Block {
    public PharoahKeystone(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos,
                                               Player pPlayer, BlockHitResult pHitResult) {
        pLevel.playSound(pPlayer, pPos, SoundEvents.BLAZE_BURN, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity)
    {
        if (entity instanceof ItemEntity itemEntity)
        {
            if(isValidItem(itemEntity.getItem()))
            {
                itemEntity.setItem(new ItemStack(ModItems.TOTEM_OF_LIFE.get(), itemEntity.getItem().getCount()));


            }
        }
        super.stepOn(level, pos, state, entity);
    }

    private boolean isValidItem(ItemStack item)
    {
        return item.is(ModItems.TABLET_ARTIFACT);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random)
    {
        double xPos = pos.getX() + 0.5f;
        double yPos = pos.getY() + 1.25f;
        double zPos = pos.getZ() + 0.5f;
        double offset = random.nextDouble() * 0.6 - 0.3;

        level.addParticle(ParticleTypes.SMOKE, xPos + offset, yPos, zPos + offset, 0.0, 0.0, 0.0);
        level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.MAGMA_BLOCK.defaultBlockState()),
                xPos + offset, yPos, zPos + offset, 0.0, 0.0, 0.0);
        super.animateTick(state, level, pos, random);
    }
}
