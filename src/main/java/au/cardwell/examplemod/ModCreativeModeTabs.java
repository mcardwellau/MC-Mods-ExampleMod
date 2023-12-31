package au.cardwell.examplemod;

import au.cardwell.examplemod.ExampleMod;
import au.cardwell.examplemod.blocks.ModBlocks;
import au.cardwell.examplemod.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MOD_ID);
    //Create new creative mode tab
    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab",
            //Set creative mode tab icon
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DILDO.get()))
                    //Set creative mode tab title key (For translation in lang files)
                    .title(Component.translatable("creativetab.example_tab"))
                    //Add items/blocks to creative mode tab
                    .displayItems((pParameters, pOutput) ->
                    {
                        //Items
                        pOutput.accept(ModItems.DILDO.get());
                        pOutput.accept(ModItems.DEODORANT.get());
                        pOutput.accept(ModItems.RUBY.get());
                        pOutput.accept(ModItems.RAW_RUBY.get());
                        pOutput.accept(ModItems.ORE_FINDER.get());
                        //Blocks
                        pOutput.accept(ModBlocks.RUBY_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_RUBY_BLOCK.get());
                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                        //Ores
                        pOutput.accept(ModBlocks.RUBY_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_RUBY_ORE.get());
                        pOutput.accept(ModBlocks.END_STONE_RUBY_ORE.get());
                    })
                    //Finalise creative mode tab
                    .build());
    //Register event for custom tabs
    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
