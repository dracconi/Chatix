package me.dracconi.chatix;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
//import net.milkbowl.vault.permission.Permission;
import net.milkbowl.vault.chat.Chat;
/**
 * Created by dracconi on 22.05.16.
 */
public class Chatix extends JavaPlugin{
    private static Chatix instance;
//    public static Permission permission;
    public static Chat chat;
    public static Chatix getInstance(){
        return instance;
    }
    public static boolean chat_status = true; //chat status default configuration
    public String chat_tag = "[CHATIX] ";
    public void loadConfiguration(){
        saveDefaultConfig();
        chat_tag = getConfig().getString("tag").replaceAll("&","§");
    }
    @Override
    public void onLoad(){
        instance = this;
    }
    @Override
    public void onEnable(){
        loadConfiguration();
        getServer().getPluginManager().registerEvents(new PlayerListener(),this);
        getCommand("chatix").setExecutor(new Commands(this));
        getLogger().info("CHATIX launched");
        Bukkit.broadcastMessage(ChatColor.YELLOW + "Chatix 1.0v by dracconi");


    }
    public String fixColors(String text){
        return ChatColor.translateAlternateColorCodes('&',text);
    }
    public String getConfigS(String path){
        return getConfig().getString(path);
    }
    public String getPlayerPrefix(Player player){
        getLogger().info(chat.getPlayerPrefix(player));
        return "hi";
    }
//    @Override
//    public void onDisable(){}


}
