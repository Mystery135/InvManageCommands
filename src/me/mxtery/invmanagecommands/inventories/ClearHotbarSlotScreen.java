package me.mxtery.invmanagecommands.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClearHotbarSlotScreen implements InventoryHolder {
private final Inventory inv;
public ClearHotbarSlotScreen(){

   inv = Bukkit.createInventory(this, 9, "Which hotbar slot to clear?");
init();

}

private void init(){
ItemStack item;
for(int i = 0; i<10; i++){
    item = createItem(i);
    inv.setItem(inv.firstEmpty(), item);



}


}
private ItemStack createItem(int i){

    ItemStack item = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, i);
    ItemMeta meta = item.getItemMeta();
    item.setItemMeta(meta);
    return item;




}

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
