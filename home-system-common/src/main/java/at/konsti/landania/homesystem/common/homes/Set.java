package at.konsti.landania.homesystem.common.homes;

import at.konsti.landania.homesystem.common.Config;
import at.konsti.landania.homesystem.common.mysql.Connection;
import at.konsti.landania.homesystem.spigot.utils.Messager;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Set {

    public static void set(String name, String UUID, HashMap<String, Integer> loc, String world) {
        try {
            ResultSet set = Connection.onQuery("SELECT * FROM homes WHERE UUID = '" + UUID + "' AND name = '" + name + "'");

            if(set.next()) {
                Messager.messageWithUUID(UUID, Config.read("prefix") + "§cDu hast bereits ein Home mit diesem Namen. Um es zu ersetzen" +
                        " lösche dieses bitte mit §7/delhome <name> §cund erstelle ein neues!");
                return;
            }
            int x = loc.get("x");
            int y = loc.get("y");
            int z = loc.get("z");
            Connection.onUpdate("INSERT INTO homes(UUID, name, world, x, y, z) VALUES('" + UUID + "', '" + name + "', '" + world + "', " + x + ", " + y + ", " + z + ")");
            Messager.messageWithUUID(UUID, Config.read("prefix") + "Dein Home mit dem Namen §7" + name + " §6wurde erstellt!");

        }catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
