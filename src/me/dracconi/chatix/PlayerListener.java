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
    private Chatix main = Chatix.getInstance();
    private String bypassuser = main.getConfigS("bypassuser-tag");
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        p.setDisplayName(main.fixColors(String.format("&c[&c&ldefault&c]&d %s &f",p.getName())));
        e.setFormat(p.getDisplayName() + e.getMessage());
        if(!main.chat_status){
            if(!p.hasPermission("chatix.bypass")){
                e.setCancelled(true);
            }
            e.setFormat(main.fixColors(bypassuser) + " " + p.getDisplayName() + e.getMessage());
        }

    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage(main.getConfig().getString("join-msg").replaceAll("%player%",p.getDisplayName()));
    }
}
