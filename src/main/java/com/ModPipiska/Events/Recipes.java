package com.ModPipiska.Events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.network.play.server.S2FPacketSetSlot;
import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;

import java.util.HashMap;

public class Recipes {
    public static void register()
    {
        GameRegistry.addRecipe(new ItemStack(Item.getItemById(4229)),  " A ", " A ", " A ", 'A', new ItemStack(Items.iron_ingot));
    }
}
