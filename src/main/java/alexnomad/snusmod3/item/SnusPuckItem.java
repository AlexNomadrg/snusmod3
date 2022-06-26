package alexnomad.snusmod3.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Random;

public class SnusPuckItem extends Item {

    public SnusPuckItem(Settings settings) {
        super(settings);
    }
    Random rng = new Random();

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        var stack = user.getStackInHand(hand);
        stack.setCount(0);
        user.playSound(SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 1f, 0.7f);
        int amount = rng.nextInt(8, 17);
        for (int i = 0; i < amount; i++) {
            user.dropItem(new ItemStack(ModItems.SNUS, 16).getItem());
        }
        return TypedActionResult.success(stack);
    }
}
