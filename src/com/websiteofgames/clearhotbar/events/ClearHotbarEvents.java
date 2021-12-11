package com.websiteofgames.clearhotbar.events;

import com.websiteofgames.clearhotbar.inventories.ClearHotbarSlotScreen;
import com.websiteofgames.clearhotbar.inventories.ClearInvScreen;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class ClearHotbarEvents implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e){

        if (e.getClickedInventory() == null){
            return; //returns and stops running the rest of the code


        }
        if (e.getClickedInventory().getHolder() instanceof ClearInvScreen){



            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null){
                return;

            }

            if (e.isLeftClick()) {
                if (e.getSlot()< 4){
                    player.sendMessage("§6§l[ClearHotbarCommands"+ChatColor.GREEN + " Inventory cleared!");

                    player.closeInventory();
                    for(int i = 0; i<36; i++){
                        player.getInventory().setItem(i, null);

                    }
                    player.getInventory().setItemInOffHand(null);
                    player.getInventory().setArmorContents(null);



                }else if (e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE){


                    player.sendMessage("§6§l[ClearHotbarCommands"+ChatColor.RED + " Did not clear your inventory!");
                    player.closeInventory();
                }else if (e.getSlot() == 4){

                    player.sendMessage("§6§l[ClearHotbarCommands" +ChatColor.AQUA +" Are you sure you want to clear your inventory? Make a selection!");


                }

            }

        }
    if (e.getInventory().getHolder() instanceof ClearHotbarSlotScreen){


        e.setCancelled(true);
        Player player = (Player)e.getWhoClicked();
        if (e.getCurrentItem() == null){

            return;
        }


if (e.getSlot()<=8 && e.getSlot()>=0){
    int hotbarslotcleard = e.getSlot();
    hotbarslotcleard++;


    player.sendMessage("§6§l[ClearHotbarCommands " + "§r§l§aHotbar slot " + hotbarslotcleard + " cleared!" );
    player.closeInventory();
    player.getInventory().setItem(e.getSlot(), null);

}

    }









    }}
