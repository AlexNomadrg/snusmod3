package alexnomad.snusmod3.item.drugs;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.ArrayList;
import java.util.List;

public class CocaineItem extends Drug {
    public CocaineItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getUseDamage() {
        return 10;
    }

    @Override
    public List<StatusEffectInstance> getUseStatusEffects() {
        List<StatusEffectInstance> list = new ArrayList<>();
        list.add(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 9));
        list.add(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 9));
        list.add(new StatusEffectInstance(StatusEffects.SPEED, 100, 1));
        return list;
    }
}
