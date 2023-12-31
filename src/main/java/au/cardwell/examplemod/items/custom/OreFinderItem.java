package au.cardwell.examplemod.items.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class OreFinderItem extends Item
{
    public OreFinderItem(Properties pProperties)
    {
        super(pProperties);
    }
    @Override
    public InteractionResult useOn(UseOnContext pContext)
    {
        if (!pContext.getLevel().isClientSide())
        {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;
            for (int i = 0; i <= positionClicked.getY() + 64; i++)
            {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));
                if (isValuableBlock(state))
                {
                    outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;
                    break;
                }
            }
            if (!foundBlock)
            {
                player.sendSystemMessage(Component.literal("Could not find any ores!"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block)
    {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " + "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState state)
    {
        return state.is(Blocks.GOLD_ORE) || state.is(Blocks.COAL_ORE) || state.is(Blocks.REDSTONE_ORE) || state.is(Blocks.IRON_ORE) || state.is(Blocks.DIAMOND_ORE) || state.is(Blocks.COPPER_ORE) || state.is(Blocks.EMERALD_ORE) || state.is(Blocks.LAPIS_ORE) || state.is(Blocks.DEEPSLATE_COAL_ORE) || state.is(Blocks.DEEPSLATE_IRON_ORE) || state.is(Blocks.DEEPSLATE_COPPER_ORE) || state.is(Blocks.DEEPSLATE_GOLD_ORE) || state.is(Blocks.DEEPSLATE_REDSTONE_ORE) || state.is(Blocks.DEEPSLATE_EMERALD_ORE) || state.is(Blocks.DEEPSLATE_LAPIS_ORE) || state.is(Blocks.DEEPSLATE_DIAMOND_ORE) || state.is(Blocks.NETHER_GOLD_ORE) || state.is(Blocks.NETHER_QUARTZ_ORE) || state.is(Blocks.ANCIENT_DEBRIS);
    }
}
