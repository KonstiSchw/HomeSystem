package at.konsti.landania.homesystem.spigot.commands;

import at.konsti.landania.homesystem.common.homes.Set;
import at.konsti.landania.homesystem.spigot.HomeSystem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class SetHome implements CommandExecutor {

    public SetHome(){
        try {
            Bukkit.getPluginCommand("sethome").setExecutor(this);
        }catch(NullPointerException e) {
            Bukkit.getPluginManager().disablePlugin(HomeSystem.getInstance());
        }
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 1) {
                String UUID = p.getUniqueId().toString();
                String name = args[0];
                HashMap<String, Integer> loc = new HashMap();
                loc.put("x", p.getLocation().getBlockX());
                loc.put("y", p.getLocation().getBlockY());
                loc.put("z", p.getLocation().getBlockZ());
                String world = p.getLocation().getWorld().getUID().toString();
                Set.set(name, UUID, loc, world);
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
