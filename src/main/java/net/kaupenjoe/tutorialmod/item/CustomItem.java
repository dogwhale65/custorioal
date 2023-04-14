package net.kaupenjoe.tutorialmod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CustomItem extends Item {

    public CustomItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, net.minecraft.world.World world, net.minecraft.entity.LivingEntity user) {
        user.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.SPEED, 600, 1));
        return super.finishUsing(stack, world, user);
    }
}
