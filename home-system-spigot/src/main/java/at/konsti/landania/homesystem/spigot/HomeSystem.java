package at.konsti.landania.homesystem.spigot;

import at.konsti.landania.homesystem.common.Config;
import at.konsti.landania.homesystem.common.mysql.Connection;
import at.konsti.landania.homesystem.common.mysql.Tables;
import at.konsti.landania.homesystem.spigot.commands.DelHome;
import at.konsti.landania.homesystem.spigot.commands.Home;
import at.konsti.landania.homesystem.spigot.commands.Homes;
import at.konsti.landania.homesystem.spigot.commands.SetHome;
import at.konsti.landania.homesystem.spigot.listeners.InventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class HomeSystem extends JavaPlugin {
    private static HomeSystem Instance;
    private static String prefix;

    @Override
    public void onEnable() {
        Instance = this;
        getDataFolder().mkdir();
        Config.startConfig(getDataFolder());
        Connection.connect(getLogger());
        Tables.create();
        prefix = Config.read("prefix");
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
        new SetHome();
        new DelHome();
        new Home();
        new Homes();

    }

    public static HomeSystem getInstance() {
        return Instance;
    }

    public static String getPrefix() {
        return prefix;
    }
}
