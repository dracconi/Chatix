package me.dracconi.chatix;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by dracconi on 23.05.16.
 */
public class Commands implements CommandExecutor{

    private main plugin;

    public Commands(main plugin) {
        this.plugin = plugin;
    }
    public void turnOnChat(Player p){
        if(plugin.chat_status==true){
            if(p instanceof Player){
                p.sendMessage(plugin.chat_tag+"Chat been already turned on.");}
        }else{
            plugin.chat_status = true;
            Bukkit.broadcastMessage(plugin.chat_tag+"Chat turned on!");}
    }
    public void turnOffChat(Player p){
        if(plugin.chat_status==false){
            if(p instanceof Player){
                p.sendMessage(plugin.chat_tag+"Chat been already turned off.");}
        }else{
            plugin.chat_status = false;
            Bukkit.broadcastMessage(plugin.chat_tag+"Chat turned off!");}
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(cmd.getName().equalsIgnoreCase("chatix")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                        p.sendMessage(ChatColor.YELLOW + "Chatix 1.0v by dracconi");
                } else {
                    if (args[0].equalsIgnoreCase("reload")) {
                        plugin.reloadConfig();
                        plugin.getLogger().info("Reloaded!");
                        p.sendMessage(ChatColor.GREEN + "Reloaded!");
                    } else if (args[0].equalsIgnoreCase("on")) {
                        turnOnChat(p);
                    } else if (args[0].equalsIgnoreCase("off")) {
                        turnOffChat(p);
                    } else if (args[0].equalsIgnoreCase("clear")) {
                        for (int i = 0; i < 100; i++) {
                            Bukkit.broadcastMessage("");
                        }
                        Bukkit.broadcastMessage(plugin.chat_tag + "Chat cleared by " + p.getName());
                    } else if (args[0].equalsIgnoreCase("toggle")) {
                        if (plugin.chat_status == true) {
                            turnOffChat(p);
                        } else {
                            turnOnChat(p);
                        }
                    }
                }
            }else{
                plugin.getLogger().info("Use config.yml or be player.");
            }
        }
        return false;
    }
}
