package at.konsti.landania.homesystem.spigot.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.UUID;


public class Teleporter {

    public static boolean teleportWithUUID(String UUID, String worldName, int x, int y, int z) {
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p.getUniqueId().toString().equalsIgnoreCase(UUID)) {
                World world = Bukkit.getWorld(java.util.UUID.fromString(worldName));
                if(world == null) return false;
                Location l = new Location(world, x, y, z);
                p.teleport(l);
                return true;
            }
        }
        return false;


    }


}
