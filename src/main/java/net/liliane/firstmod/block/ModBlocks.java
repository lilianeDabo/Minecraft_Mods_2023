package net.liliane.firstmod.block;

import net.liliane.firstmod.firstMod;
import net.liliane.firstmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, firstMod.MOD_ID);

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registryBlock("sapphire_block",
            // Creating a new block and copying the behaviours of the iron block but changing the sound to the amethyst
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registryBlock("raw_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

            // Registering ore blocks ( slightly harder than regular stone )
    public static final RegistryObject<Block> SAPPHIRE_ORE = registryBlock("sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(33, 66))); // UniformInt = exp orbs
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registryBlock("deepslate_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> NETHER_SAPPHIRE_ORE = registryBlock("nether_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(1f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> END_STONE_SAPPHIRE_ORE = registryBlock("end_stone_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    // Using a method to get our block
    private static < T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        // Registers block
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        // Registers block item
        registryBlockItem(name, toReturn);
        // Returns block for this method
        return toReturn;
    }

    // To associate an item to the block we are going to create ( does not come with one )
    public static < T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
