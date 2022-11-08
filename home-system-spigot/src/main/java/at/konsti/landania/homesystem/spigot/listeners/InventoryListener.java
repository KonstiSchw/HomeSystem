package at.konsti.landania.homesystem.spigot.listeners;

import at.konsti.landania.homesystem.common.homes.Delete;
import at.konsti.landania.homesystem.common.homes.Teleport;
import at.konsti.landania.homesystem.spigot.utils.GUICreator;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class InventoryListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Inventory inv = e.getClickedInventory();
        if(inv.equals(GUICreator.getInv())) {
            if(e.getWhoClicked() instanceof Player) {
                Player p = (Player) e.getWhoClicked();
                final ItemStack clickedItem = e.getCurrentItem();

                if(clickedItem == null || clickedItem.getType().isAir() || (clickedItem.getType() == Material.BLACK_STAINED_GLASS)) return;

                switch(clickedItem.getType()) {

                    case PAPER:
                        p.performCommand("home " + clickedItem.getItemMeta().getDisplayName());
                        break;

                    case BARRIER:
                        Delete.deleteAll(p.getUniqueId().toString());
                        break;

                    default:
                        return;

                }
                p.closeInventory();
            }
        }
    }

}
