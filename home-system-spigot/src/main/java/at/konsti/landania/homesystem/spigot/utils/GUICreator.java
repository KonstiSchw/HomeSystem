package at.konsti.landania.homesystem.spigot.utils;

import at.konsti.landania.homesystem.common.mysql.Connection;
import at.konsti.landania.homesystem.spigot.HomeSystem;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GUICreator {

    private static Inventory inv;

    public static Inventory getInv() {
        return inv;
    }

    public static boolean homeGUI(String UUID) {
        try {
            ResultSet set = Connection.onQuery("SELECT * FROM homes WHERE UUID = '" + UUID + "'");
            inv = Bukkit.createInventory(Bukkit.getPlayer(java.util.UUID.fromString(UUID)), 9*6, Component.text("Deine Homes"));

            ItemStack stack = new ItemStack(Material.PAPER);
            ItemMeta meta = stack.getItemMeta();
            int i = 0;
            while(set.next()) {
                if(!(i>45)) {
                    meta.displayName(Component.text(set.getString("name")));
                    List<Component> lore = new ArrayList<>();
                    lore.add(Component.text("Klicke um dich zu diesen Home zu teleportieren!"));
                    meta.lore(lore);
                    stack.setItemMeta(meta);
                    inv.addItem(stack);
                }
                i++;
            }
            i = 45;
            while (!(i>53)) {
                stack = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
                if(i==49){
                    stack = new ItemStack(Material.BARRIER);
                    meta = stack.getItemMeta();
                    meta.displayName(Component.text("Lösche ALLE Homes!"));
                    stack.setItemMeta(meta);
                }
                inv.setItem(i, stack);
                i++;
            }
            OpenInv.openInvWithUUID(UUID, inv);
            return true;






        }catch (SQLException e) {
            return false;

        }



    }

}
