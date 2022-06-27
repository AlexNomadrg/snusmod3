package alexnomad.snusmod3.item.drugs;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.EntityDamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public abstract class Drug extends Item {
    
    public float getUseSoundVolume() {
        return 1f;
    }

    public SoundEvent getUseSound() {
        return SoundEvents.ENTITY_WANDERING_TRADER_DRINK_POTION;
    }

    public float getUseSoundPitch() {
        return 1.2f;
    }

    public List<StatusEffectInstance> getUseStatusEffects() {
        return new ArrayList<>();
    }

    public int getUseDamage() {
        return 5;
    }

    public String getDamageSourceName() {
        return "placeholder_drug_overdose";
    }

    public String getDamageSourceNameForced() {
        return "placeholder_drug_forced_overdose";
    }

    public Drug(Settings settings) {
        super(settings);
    }

    private void useDrug(LivingEntity entity, DamageSource source) {
        entity.damage(source, getUseDamage());
        entity.playSound(getUseSound(), getUseSoundVolume(), getUseSoundPitch());
        getUseStatusEffects().forEach(entity::addStatusEffect);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        var stack = user.getStackInHand(hand);
        stack.setCount(0);
        EntityDamageSource source = new EntityDamageSource(getDamageSourceName(), user);
        useDrug(user, source);

        return TypedActionResult.success(stack);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity entity, LivingEntity user) {
        stack.setCount(0);
        EntityDamageSource source = new EntityDamageSource(getDamageSourceNameForced(), user);
        useDrug(entity, source);

        return true;
    }
}
