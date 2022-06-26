package alexnomad.snusmod3.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.EntityDamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HeroinSyringeItem extends Item {
    public HeroinSyringeItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        var stack = user.getStackInHand(hand);
        stack.setCount(0);

        user.playSound(SoundEvents.ENTITY_WANDERING_TRADER_DRINK_POTION, SoundCategory.PLAYERS, 1f,1.2f);

        EntityDamageSource source = new EntityDamageSource("heroin_overdose", user);
        user.damage(source, 10);

        user.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 200));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 600, 1));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 600));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 1));

        return TypedActionResult.success(stack);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        stack.setCount(0);

        user.playSound(SoundEvents.ENTITY_WANDERING_TRADER_DRINK_POTION, SoundCategory.PLAYERS, 1f,1.2f);

        EntityDamageSource source = new EntityDamageSource("heroin_forced_overdose", user);
        entity.damage(source, 10);

        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 200));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 600, 1));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 600));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 1));

        return ActionResult.success(true);
    }
}
