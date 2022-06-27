package alexnomad.snusmod3.item.drugs;

import alexnomad.snusmod3.item.drugs.Drug;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.ArrayList;
import java.util.List;

public class PowderMethItem extends Drug {
    public PowderMethItem(Settings settings) {
        super(settings);
    }

    @Override
    public SoundEvent getUseSound() {
        return SoundEvents.BLOCK_SAND_BREAK;
    }

    @Override
    public float getUseSoundPitch() {
        return 0.01f;
    }

    @Override
    public String getDamageSourceName() {
        return "meth_overdose";
    }

    @Override
    public List<StatusEffectInstance> getUseStatusEffects() {
        List<StatusEffectInstance> list = new ArrayList<>();
        list.add(new StatusEffectInstance(StatusEffects.SPEED, 600, 1));
        return list;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity entity, LivingEntity user) {
        // meth shouldn't be used on another entity lol
        // how tf would that work??
        return true;
    }
}
