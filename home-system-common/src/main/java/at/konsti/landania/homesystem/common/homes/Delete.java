package at.konsti.landania.homesystem.common.homes;

import at.konsti.landania.homesystem.common.Config;
import at.konsti.landania.homesystem.common.mysql.Connection;
import at.konsti.landania.homesystem.spigot.utils.Messager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete {

    public static void delete(String UUID, String name) {
        try {

            ResultSet set = Connection.onQuery("SELECT * FROM homes WHERE UUID = '" + UUID + "' AND name = '" + name + "'");
            if(!set.next()) {
                Messager.messageWithUUID(UUID, Config.read("prefix") + "§cDu hast kein Home mit dem Namen §7" + name + "§c!");
                return;
            }
            Connection.onUpdate("DELETE FROM homes WHERE UUID = '" + UUID + "' AND name = '" + name + "'");
            Messager.messageWithUUID(UUID, Config.read("prefix") + "Dein Home mit dem Namen §7" + name + " §6wurde erfolgreich gelöscht!");



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteAll(String UUID) {
        try {

            ResultSet set = Connection.onQuery("SELECT * FROM homes WHERE UUID = '" + UUID + "'");
            if(!set.next()) {
                Messager.messageWithUUID(UUID, Config.read("prefix") + "§cDu hast keine Homes");
                return;
            }
            Connection.onUpdate("DELETE FROM homes WHERE UUID = '" + UUID + "'");
            Messager.messageWithUUID(UUID, Config.read("prefix") + "Deine Homes wurden erfolgreich gelöscht!");



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
