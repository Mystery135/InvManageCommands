package me.mxtery.invmanagecommands.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClearInvScreen implements InventoryHolder {
    private final Inventory inv;
    public ClearInvScreen(){
        inv = Bukkit.createInventory(this, 9, "Clear Inventory?");
        init();
    }

    private void init(){


        ItemStack item;
        item = createItem("§a§lYes", Material.GREEN_STAINED_GLASS_PANE, Collections.singletonList("§7Yes"));
        item.addUnsafeEnchantment(Enchantment.LUCK, 1);
        for(int i = 0; i<4; i++){


            inv.setItem(i, item);

        }


        List<String> lore = new ArrayList<>();
        lore.add("Please select either §a§lYes §ror §c§lNo");
        item = createItem("§b§lMake a selection", Material.CHEST, lore);
        item.addUnsafeEnchantment(Enchantment.LUCK, 1);
        inv.setItem(inv.firstEmpty(), item);


        item = createItem("§c§lNo", Material.RED_STAINED_GLASS_PANE, Collections.singletonList("§7No"));
        item.addUnsafeEnchantment(Enchantment.LUCK, 1);
        for(int i = 5; i<9; i++){


            inv.setItem(i, item);
        }



    }
    private ItemStack createItem(String name, Material mat, List<String> lore){
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(name);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        item.setItemMeta(meta);
        return item;


    }




    @Override
    public Inventory getInventory() {
        return inv;
    }
}
