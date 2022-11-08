package at.konsti.landania.homesystem.spigot.commands;

import at.konsti.landania.homesystem.common.homes.Set;
import at.konsti.landania.homesystem.spigot.HomeSystem;
import at.konsti.landania.homesystem.spigot.utils.GUICreator;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Homes implements CommandExecutor {

    public Homes() {
        Bukkit.getPluginCommand("homes").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if(!GUICreator.homeGUI(p.getUniqueId().toString())) {
                sender.sendMessage(HomeSystem.getPrefix() + "§cDeine Homes konnten nicht angezeigt werden!");
            }

        } else {
            sender.sendMessage(HomeSystem.getPrefix() + "Dieser Befehl kann nur von Spielern ausgeführt werden!");
        }
        return false;
    }
}
