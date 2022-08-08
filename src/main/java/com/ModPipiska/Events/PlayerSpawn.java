package com.ModPipiska.Events;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class PlayerSpawn{
    public PlayerSpawn(){};

    @SubscribeEvent
    public void onLogin(EntityJoinWorldEvent e)
    {
        if (e.entity instanceof EntityPlayer) {
            EntityPlayer pl = (EntityPlayer) (e.entity);
            for (ModContainer i : Loader.instance().getActiveModList())
            {
                pl.addChatComponentMessage(new ChatComponentText(i.toString()));
            }
        }
    }
}
