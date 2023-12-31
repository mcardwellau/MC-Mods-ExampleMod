package au.cardwell.examplemod.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods
{
    public static final FoodProperties COCAINE = new FoodProperties.Builder().nutrition(2).fast().saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200), 1.0f).build();
}
