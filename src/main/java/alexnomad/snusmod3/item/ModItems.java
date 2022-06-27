package alexnomad.snusmod3.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static alexnomad.snusmod3.Snusmod3.MOD_ID;
import static alexnomad.snusmod3.Snusmod3.MOD_ITEM_GROUP;

public class ModItems {
    public static void RegisterItems() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "snus_puck"), SNUS_PUCK);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "snus"), SNUS);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "heroin_syringe"), HEROIN_SYRINGE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "powder_meth"), POWDER_METH);
    }

    private static final FabricItemSettings drugItemSettings = new FabricItemSettings().group(MOD_ITEM_GROUP).maxCount(1);

    public static final Item SNUS_PUCK = new SnusPuckItem(new FabricItemSettings().group(MOD_ITEM_GROUP).maxCount(1));
    public static final Item SNUS = new Item(new FabricItemSettings().group(MOD_ITEM_GROUP)
            .food(new FoodComponent.Builder()
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200, 0), 1.0f)
                    .alwaysEdible().snack().hunger(2).saturationModifier(0.2f).build()));

    public static final Item HEROIN_SYRINGE = new HeroinSyringeItem(drugItemSettings);

    public static final Item POWDER_METH = new PowderMethItem(drugItemSettings);
}
