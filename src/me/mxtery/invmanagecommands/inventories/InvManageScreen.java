package me.mxtery.invmanagecommands.inventories;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.Objects;

public class InvManageScreen implements InventoryHolder {
    private final Inventory inv;
    public InvManageScreen(Player player){
        inv = Bukkit.createInventory(this,36, (Objects.requireNonNull(player.getName()) + "'s Inventory"));

    init(player);
    }
    private void init(Player player){
    for (int i = 0; i<36; i++){
        inv.setItem(i, Objects.requireNonNull(player.getPlayer()).getInventory().getItem(i));
    }

    }


    @Override
    public Inventory getInventory() {
        return inv;
    }
}
