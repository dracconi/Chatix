package me.dracconi.chatix;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by dracconi on 23.05.16.
 */
public class PlayerListener implements Listener {
    private Main plugin;


    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        if(!plugin.chat_status){
            if(!p.hasPermission("chatix.bypass")){
                e.setCancelled(true);
            }
            e.setFormat(plugin.fixColors(plugin.getConfig().getString("bypassuser-tag")) + " <" + p.getDisplayName() + "> " + e.getMessage());
        }

    }
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage(plugin.getConfig().getString("join-msg").replaceAll("%player%",p.getDisplayName()));
    }
}
