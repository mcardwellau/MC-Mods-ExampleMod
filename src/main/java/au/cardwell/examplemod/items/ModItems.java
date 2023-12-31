package au.cardwell.examplemod.items;

import au.cardwell.examplemod.ExampleMod;
import au.cardwell.examplemod.items.custom.OreFinderItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    //Simple Items
    public static final RegistryObject<Item> DILDO = ITEMS.register("dildo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DEODORANT = ITEMS.register("deodorant", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_RUBY = ITEMS.register("raw_ruby", () -> new Item(new Item.Properties()));
    //Custom Items
    public static final RegistryObject<Item> ORE_FINDER = ITEMS.register("ore_finder", () -> new OreFinderItem(new Item.Properties().durability(100)));
    //Foods
    public static final RegistryObject<Item> COCAINE = ITEMS.register("cocaine", () -> new Item(new Item.Properties().food(ModFoods.COCAINE)));
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
