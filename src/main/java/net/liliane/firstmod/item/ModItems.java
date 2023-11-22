package net.liliane.firstmod.item;

import net.liliane.firstmod.firstMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// New class in new package for our items
public class ModItems {

    // Creates the actual list of all Items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, firstMod.MOD_ID);

    // Creating an item and its properties
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties())); // Line for its supplier

    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) { // Registers all Items properly in the firstMod file
        ITEMS.register(eventBus);
    }
}
