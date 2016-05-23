package me.dracconi.chatix;

import org.bukkit.plugin.java.JavaPlugin;

import me.dracconi.chatix.PlayerListener;
import me.dracconi.chatix.Commands;


/**
 * Created by dracconi on 22.05.16.
 */
public class main extends JavaPlugin{
    public static boolean chat_status = true; //chat status default configuration
    public String chat_tag = "[CHATIX] ";
    public void loadConfiguration(){
//        See "Creating you're defaults"
        getConfig().options().copyDefaults(true);
//        Save the config whenever you manipulate it
        saveConfig();
        chat_tag = getConfig().getString("tag").replaceAll("&","§");
    }
    @Override
    public void onEnable(){
        loadConfiguration();
        getServer().getPluginManager().registerEvents(new PlayerListener(),this);
        getCommand("chatix").setExecutor(new Commands(this));
        getLogger().info("CHATIX launched");

    }
    @Override
    public void onDisable(){}


}
