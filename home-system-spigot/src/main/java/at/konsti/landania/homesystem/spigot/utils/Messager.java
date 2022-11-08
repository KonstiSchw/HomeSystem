package at.konsti.landania.homesystem.spigot.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Messager {

    public static void messageWithUUID(String UUID, String message) {
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p.getUniqueId().toString().equalsIgnoreCase(UUID)) {
                p.sendMessage(message);
            }
        }
    }

}
