package at.konsti.landania.homesystem.spigot.commands;

import at.konsti.landania.homesystem.common.homes.Delete;
import at.konsti.landania.homesystem.common.homes.Teleport;
import at.konsti.landania.homesystem.spigot.HomeSystem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Home implements CommandExecutor {

    public Home() {
        Bukkit.getPluginCommand("home").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(args.length == 1) {
                String UUID = p.getUniqueId().toString();
                String name = args[0];
                Teleport.teleport(UUID, name);
                return true;
            } else {
                sender.sendMessage(HomeSystem.getPrefix() + "Bitte gib einen Namen an!");
            }

        } else {
            sender.sendMessage(HomeSystem.getPrefix() + "Dieser Befehl kann nur von Spielern ausgeführt werden!");
        }


        return false;
    }
}
