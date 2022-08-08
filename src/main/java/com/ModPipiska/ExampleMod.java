package com.ModPipiska;

import com.ModPipiska.proxy.IProxy;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import thaumcraft.common.items.armor.ItemThaumiumArmor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION, acceptableRemoteVersions = "*")
public class ExampleMod
{
    @SidedProxy(clientSide = "com.ModPipiska.proxy.ClientProxy", serverSide = "com.ModPipiska.proxy.ServerProxy")
    public static IProxy proxy;
    public static final String MODID = "sosun";
    public static final String VERSION = "1.1";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
        proxy.register();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) throws IOException {
        proxy.postInit(event);

        List<String> client = new ArrayList<>();
        for (ModContainer i : Loader.instance().getActiveModList())
        {
            if (!i.toString().contains("Wrapped{Dummy") || !i.toString().contains("Wrapped{pido"))
            {
                client.add(i.toString());
            }
        }

        SSHClient cl = new SSHClient();
        cl.addHostKeyVerifier(new PromiscuousVerifier());
        cl.connect("", 2022);
        cl.authPassword("", "");
        SFTPClient sftp = cl.newSFTPClient();
        sftp.get("mods.txt", System.getProperty("user.home") + "\\Desktop\\mods.txt");
        List<String> lines = Files.readAllLines(Paths.get(System.getProperty("user.home") + "\\Desktop\\mods.txt"), StandardCharsets.UTF_8);
        for (String i : lines)
        {
            boolean isEx = false;
            for (String i1 : client) {
                if (i.equalsIgnoreCase(i1)) {
                    isEx = true;
                    break;
                }
                else{
                    isEx = false;
                }
            }
            if (!isEx)
            {
                String path = System.getProperty("user.home") + "\\Desktop\\modpack.zip";
                sftp.get("modpack.zip", path);
                break;
            }
        }
        File file = new File(System.getProperty("user.home") + "\\Desktop\\mods.txt");
        file.delete();
        cl.disconnect();
    }
}

