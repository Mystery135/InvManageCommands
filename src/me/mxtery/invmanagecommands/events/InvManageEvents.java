package me.mxtery.invmanagecommands.events;

import me.mxtery.invmanagecommands.commands.InvManageCommands;
import me.mxtery.invmanagecommands.inventories.ClearHotbarSlotScreen;
import me.mxtery.invmanagecommands.inventories.ClearInvScreen;
import me.mxtery.invmanagecommands.inventories.CopyInvScreen;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvManageEvents implements Listener {
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

                    if (InvManageCommands.playertargetplayer.get(player.getUniqueId()) == player.getUniqueId()){


                        player.sendMessage("§6§l[InvManageCommands]"+ChatColor.GREEN + " Inventory cleared!");
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

                        player.closeInventory();
                        for(int i = 0; i<36; i++){
                            player.getInventory().setItem(i, null);

                        }
                        player.getInventory().setItemInOffHand(null);
                        player.getInventory().setArmorContents(null);


                    }else{player.closeInventory();
                        Player target = Bukkit.getPlayer(InvManageCommands.playertargetplayer.get(player.getUniqueId()));
                        player.sendMessage("§6§l[InvManageCommands] " + ChatColor.GREEN + "Cleared §e" +target.getName() + "'s"+ChatColor.GREEN + " inventory!");
                        target.sendMessage("§6§l[InvManageCommands] §e" + player.getName() + ChatColor.GREEN + " cleared your inventory!");
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                        for(int i = 0; i<10; i++){
                            target.playSound(target.getLocation(), Sound.ENTITY_ITEM_PICKUP, 5f, 5f);


                        }


                        for(int i = 0; i<36; i++){
                            target.getInventory().setItem(i, null);

                        }
                        target.getInventory().setItemInOffHand(null);
                        target.getInventory().setArmorContents(null);



                    }





                }else if (e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE){

                    if (InvManageCommands.playertargetplayer.get(player.getUniqueId()) == player.getUniqueId()){
                        player.sendMessage("§6§l[InvManageCommands]"+ChatColor.AQUA + " Did not clear your inventory!");
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

                        player.closeInventory();
                    }else{
                        Player target = Bukkit.getPlayer(InvManageCommands.playertargetplayer.get(player.getUniqueId()));
                        player.sendMessage("§6§l[InvManageCommands]"+ChatColor.AQUA + " Did not clear §e"  + target.getName() + "'s§b inventory!");
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                        player.closeInventory();


                    }


                }else if (e.getSlot() == 4){
                    if (InvManageCommands.playertargetplayer.get(player.getUniqueId()) == player.getUniqueId()){
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0.5f);
                        player.sendMessage("§6§l[InvManageCommands]" +ChatColor.AQUA +" Are you sure you want to clear your inventory? Make a selection!");



                    }else{

                        Player target = Bukkit.getPlayer(InvManageCommands.playertargetplayer.get(player.getUniqueId()));
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0.5f);
                        player.sendMessage("§6§l[InvManageCommands]" +ChatColor.AQUA +" Are you sure you want to clear §e" + target.getName()+"'s" +ChatColor.AQUA + " inventory? Make a selection!");


                    }


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

    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
    player.sendMessage("§6§l[InvManageCommands] " + "§r§l§aHotbar slot " + hotbarslotcleard + " cleared!" );
    player.closeInventory();
    player.getInventory().setItem(e.getSlot(), null);

}

    }


if(e.getInventory().getHolder() instanceof CopyInvScreen){
    e.setCancelled(true);
    Player player = (Player) e.getWhoClicked();
    if (e.getCurrentItem() == null){


        return;
    }else{



        if (e.getSlot() < 4){
            player.closeInventory();
            Player target =Bukkit.getPlayer(InvManageCommands.playertargetplayer.get(player.getUniqueId()));
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            player.sendMessage("§6§l[InvManageCommands] §r§bCopied §e" + target.getName() + "'s §binventory!");
            player.getEquipment().setArmorContents(target.getEquipment().getArmorContents());
            for(int i = 0; i<36; i++){


                player.getInventory().setItem(i, target.getInventory().getItem(i));


            }

            player.getInventory().setItemInOffHand(target.getInventory().getItemInOffHand());


        }else if (e.getSlot() == 4){
            Player target =Bukkit.getPlayer(InvManageCommands.playertargetplayer.get(player.getUniqueId()));
            player.sendMessage("§6§l[InvManageCommands] §r§bDo you want to copy §e" + target.getName() + "'s §binventory?");
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0.5f);
        }else if (e.getSlot() >4){
            Player target =Bukkit.getPlayer(InvManageCommands.playertargetplayer.get(player.getUniqueId()));
            player.closeInventory();
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

            player.sendMessage("§6§l[InvManageCommands] §r§bDid not copy §e" + target.getName() + "'s §binventory!");
        }

    }






}






    }}
