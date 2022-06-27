package alexnomad.snusmod3.item.drugs;

import alexnomad.snusmod3.item.drugs.Drug;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.ArrayList;
import java.util.List;

public class HeroinSyringeItem extends Drug {
    public HeroinSyringeItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getUseDamage() {
        return 19;
    }

    @Override
    public String getDamageSourceName() {
        return "heroin_overdose";
    }

    @Override
    public String getDamageSourceNameForced() {
        return "heroin_overdose_forced";
    }

    @Override
    public List<StatusEffectInstance> getUseStatusEffects() {
        List<StatusEffectInstance> list = new ArrayList<>();
        list.add(new StatusEffectInstance(StatusEffects.BLINDNESS, 100));
        list.add(new StatusEffectInstance(StatusEffects.LEVITATION, 100));
        list.add(new StatusEffectInstance(StatusEffects.NAUSEA, 200));
        list.add(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1));
        list.add(new StatusEffectInstance(StatusEffects.GLOWING, 200));
        list.add(new StatusEffectInstance(StatusEffects.HUNGER, 600, 2));

        return list;
    }
}
