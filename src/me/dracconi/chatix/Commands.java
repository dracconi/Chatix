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
@SuppressWarnings("deprecation")
public class Commands implements CommandExecutor {

    private Main plugin;

    public Commands(Main plugin) {
        this.plugin = plugin;
    }
    public void chatToggle(boolean state){
        plugin.chat_status = state;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("chatix")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(ChatColor.YELLOW + "Chatix 1.0v by dracconi");
                if (p.hasPermission("chatix.admin")) {
                    if (args.length == 0) {
                        plugin.chat_status ? chatToggle(false); : chatToggle(true);
                    }
                }else if (args[0].equalsIgnoreCase("clear")) {
                            for (int i = 0; i < 100; i++) {
                                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                                    player.sendMessage("");
                                }
                            }
                            Bukkit.broadcastMessage(plugin.chat_tag + "Chat cleared by " + p.getName());
                        }
                    }
                }
        return false;

    }
}

