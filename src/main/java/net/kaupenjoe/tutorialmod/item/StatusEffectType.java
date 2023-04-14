package net.kaupenjoe.tutorialmod.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class CustomStatusEffect extends StatusEffect {

    public CustomStatusEffect(int color) {
        super(StatusEffectType.BENEFICIAL, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        // Custom behavior for the effect
        // This method is called periodically while the effect is active
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // Custom logic for determining whether the effect should be applied or not
        // This method is called periodically to check whether the effect should continue
        // to be applied
        return true; // Always apply the effect in this example
    }
}