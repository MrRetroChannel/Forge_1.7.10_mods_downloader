package com.ModPipiska.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ClientProxy implements IProxy{

    public void preInit(FMLPreInitializationEvent e)
    {

    }

    public void init(FMLInitializationEvent e)
    {

    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }

    public void register()
    {
        GameRegistry.addRecipe(new ItemStack(Item.getItemById(4303), 1, 12),  "ABA", "A A", "ABA", 'A', new ItemStack(Item.getItemById(4303), 1, 5), 'B', new ItemStack(Item.getItemById(4229), 1, 1));
    }
}
