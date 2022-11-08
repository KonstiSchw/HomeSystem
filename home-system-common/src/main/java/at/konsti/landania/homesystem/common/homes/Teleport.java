package at.konsti.landania.homesystem.common.homes;

import at.konsti.landania.homesystem.common.Config;
import at.konsti.landania.homesystem.common.mysql.Connection;
import at.konsti.landania.homesystem.spigot.utils.Messager;
import at.konsti.landania.homesystem.spigot.utils.Teleporter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Teleport {

    public static void teleport(String UUID, String name) {

        try {

            ResultSet set = Connection.onQuery("SELECT * FROM homes WHERE UUID = '" + UUID + "' AND name = '" + name + "'");
            if(!set.next()) {
                Messager.messageWithUUID(UUID, Config.read("prefix") + "§cDu hast kein Home mit dem Namen §7" + name + "§c!");
                return;
            }

            int x = set.getInt("x");
            int y = set.getInt("y");
            int z = set.getInt("z");
            String world = set.getString("world");

            if(Teleporter.teleportWithUUID(UUID, world, x, y, z)) {
                Messager.messageWithUUID(UUID, Config.read("prefix") + "Du wurdest erfolgreich zu deinem Home mit dem Namen §7" + name + " §6teleportiert!");
            }else {
                Messager.messageWithUUID(UUID, Config.read("prefix") + "§cDu konntest nicht teleportiert werden!");

            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
