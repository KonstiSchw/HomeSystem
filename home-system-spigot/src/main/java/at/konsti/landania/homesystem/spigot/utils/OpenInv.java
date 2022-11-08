package at.konsti.landania.homesystem.spigot.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class OpenInv {

    public static void openInvWithUUID(String UUID, Inventory inv) {
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p.getUniqueId().toString().equalsIgnoreCase(UUID)) {
                p.openInventory(inv);
            }
        }
    }

}
