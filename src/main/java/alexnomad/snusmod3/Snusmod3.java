package alexnomad.snusmod3;

import alexnomad.snusmod3.item.ModItems;
import alexnomad.snusmod3.item.SnusPuckItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Snusmod3 implements ModInitializer {

    public static String MOD_ID = "snusmod3";

    public static final ItemGroup DrugsGroup = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "drugs"),
            () -> new ItemStack(ModItems.SNUS)
    );
    public static final ItemGroup MOD_ITEM_GROUP = DrugsGroup;

    @Override
    public void onInitialize() {
        ModItems.RegisterItems();
    }
}
