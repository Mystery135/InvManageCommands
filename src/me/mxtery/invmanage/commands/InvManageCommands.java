package me.mxtery.invmanage.commands;

import me.mxtery.invmanage.inventories.ClearHotbarSlotScreen;
import me.mxtery.invmanage.inventories.ClearInvScreen;
import me.mxtery.invmanage.inventories.CopyInvScreen;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;
import java.util.stream.Collectors;

public class InvManageCommands implements CommandExecutor {
public static HashMap<UUID, UUID> playertargetplayer = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] args) {
        if (commandSender instanceof Player){
            Player player = (Player)commandSender;
            if (cmd.getName().equalsIgnoreCase("clearhotbar")){
                if (args.length == 0){

                    player.sendMessage("§6§l[InvManageCommands] " + "§r§l§aHotbar cleared!");
                    for(int i = 0; i<9; i++){

                        player.getInventory().setItem(i, null);


                    }



                }else if (args.length == 1){
                    if (player.hasPermission("invmanage.affectothers")){


                        try{

                            Player target = Bukkit.getPlayerExact(args[0]);

                            if (player.getUniqueId().equals(target.getUniqueId())){

                                player.sendMessage("§6§l[InvManageCommands] " + "§r§l§aHotbar cleared!");
                                for(int i = 0; i<9; i++){

                                    player.getInventory().setItem(i, null);


                                }



                            }else{
                                for(int i = 0; i<9; i++){

                                    target.getInventory().setItem(i, null);


                                }

                                player.sendMessage("§6§l[InvManageCommands] §aCleared §e" + target.getName() + "'s §r§ahotbar!");
                                target.sendMessage("§6§l[InvManageCommands] §e" + player.getName() + " §bhas cleared your hotbar!");

                            }


                        }catch (Exception e){


                            player.sendMessage("§cThat player does not exist!");


                        }

                    }else{
                        player.sendMessage("§cYou don't have the required permission: invmanage.affectothers");

                    }



                }else{

                    player.sendMessage("§c/clearhotbar <player>");



                }



            }
            if(cmd.getName().equalsIgnoreCase("clearhand")){


                if (args.length == 0){

                    player.getInventory().setItemInMainHand(null);
                    player.sendMessage("§6§l[InvManageCommands] " + "§r§l§aHand cleared!");


                }else if (args.length == 1){

                    if (player.hasPermission("invmanage.affectothers")){

                        try{
                            Player target = Bukkit.getPlayerExact(args[0]);
                            target.getInventory().setItemInMainHand(null);
                            if(target.getUniqueId().equals(player.getUniqueId())){

                                player.getInventory().setItemInMainHand(null);
                                player.sendMessage("§6§l[InvManageCommands] " + "§r§l§aHand cleared!");


                            }else{

                                player.sendMessage("§6§l[InvManageCommands] §r§l§aCleared §e" + target.getName() + "'s §r§l§ahand!");
                                target.sendMessage("§6§l[InvManageCommands] §r§e" + player.getName() + " §bhas cleared your hand!");
                            }


                        }catch (Exception e){
                            player.sendMessage("§cThat player does not exist!");


                        }



                    }else{

                        player.sendMessage("§cYou don't have the required permission: invmanage.affectothers");

                    }



                }else{


                    player.sendMessage("§c/clearhand <player>");

                }



            }
            if(cmd.getName().equalsIgnoreCase("clearhands")){


                player.getInventory().setItemInMainHand(null);
                player.getInventory().setItemInOffHand(null);
                player.sendMessage("§6§l[InvManageCommands] " + "§r§l§aHands cleared!");


            }
            if(cmd.getName().equalsIgnoreCase("clearoffhand")){

                player.getInventory().setItemInOffHand(null);
                player.sendMessage("§6§l[InvManageCommands] " + "§r§l§aOffhand cleared!");

            }
            if (cmd.getName().equalsIgnoreCase("cl")){
                if(args.length == 0){
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    ClearInvScreen inv = new ClearInvScreen();
                    player.openInventory(inv.getInventory());
                    player.sendMessage(  "§6§l[InvManageCommands]" + " §l§bAre you sure you want to clear your inventory?");
                    playertargetplayer.put(player.getUniqueId(), player.getUniqueId());

                }


                else if (args.length == 1){
                    if (player.hasPermission("invmanage.affectothers")){



                        try{


                            Player target = Bukkit.getPlayerExact(args[0]);


                            if (player.getUniqueId() == target.getUniqueId()){


                                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                                ClearInvScreen inv = new ClearInvScreen();
                                player.openInventory(inv.getInventory());
                                player.sendMessage(  "§6§l[InvManageCommands]" + " §l§bAre you sure you want to clear your inventory?");
                                playertargetplayer.put(player.getUniqueId(), player.getUniqueId());

                            }else{

                                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                                playertargetplayer.put(player.getUniqueId(), target.getUniqueId());
                                player.sendMessage(  "§6§l[InvManageCommands]" + " §bAre you sure you want to clear §e" + target.getName() +  "'s§b inventory?");
                                ClearInvScreen clearInvScreen = new ClearInvScreen();
                                player.openInventory(clearInvScreen.getInventory());



                            }


                        }catch (Exception e){


                            player.sendMessage("That player does not exist!");


                        }
                    }else{
                        player.sendMessage("§cYou don't have the required permission: invmanage.affectothers");


                    }




                }
                else{


                    player.sendMessage("§c/cl <player>");

                }



            }
            if (cmd.getName().equalsIgnoreCase("clearhotbarslot")){
                if (args.length == 0){

                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    ClearHotbarSlotScreen inv = new ClearHotbarSlotScreen();
                    player.openInventory(inv.getInventory());




                }else if (args.length <=9){
                    boolean error = false;

                    for (int h = 0; h< args.length; h++) {

                        if (Integer.parseInt(args[h]) <= 9) {
                           error = false;

                        }else {

                            error = true;

                        }
                    }

if (!error){

    for (int i = 0; i<args.length; i++){
        if (Integer.parseInt(args[i]) <=9){
            int intargs = Integer.parseInt(args[i]) - 1;
            player.getInventory().setItem(intargs, null);



        }

}

    int[] args2 = new int[args.length];
    for (int i=0; i < args.length; i++){
        if (Integer.parseInt(args[i]) <=9){
            int g = Integer.parseInt(args[i]);
            args2[i]=g;
        }


    }


    int[] intArgs = new int[args2.length];
    for (int o = 0; o<intArgs.length;o++){


        intArgs[o] = (args2[o]);


    }

    String st = Arrays.stream(intArgs)
            .mapToObj(String::valueOf) // convert each int to a string
            .collect(Collectors.joining(", ")); // join them with ", "






    if (args.length == 1){

        player.sendMessage("§6§l[InvManageCommands] §r§l§aHotbar slot" + st +" cleared!" );



    }else{

        player.sendMessage("§6§l[InvManageCommands] §r§l§aHotbar slots " + st+" cleared!" );




    }




}      else {


    player.sendMessage("§6§l[InvManageCommands] " + "§r§c§lThere are only 9 slots in your hotbar!");


}








                }else {

                    player.sendMessage("§6§l[InvManageCommands] " + "§r§l§c/chbs <hotbarslot> <hotbarslot>");
                    player.sendMessage("§l§cYou can only input 9 hotbar slots!");

                }



            }
            if (cmd.getName().equalsIgnoreCase("cleararmor")){

if (args.length == 0){



    player.getInventory().setArmorContents(null);
    player.sendMessage("§6§l[InvManageCommands] " + "§r§l§aArmor cleared!");



}else if (args.length == 1){

    if (player.hasPermission("invmanage.affectothers")){



        try{
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target.getUniqueId().equals(player.getUniqueId())){

                player.getInventory().setArmorContents(null);
                player.sendMessage("§6§l[InvManageCommands] " + "§r§l§aArmor cleared!");



            }else{

                target.getInventory().setArmorContents(null);
                target.sendMessage("§6§l[InvManageCommands] §e" + player.getName() + " §bhas cleared your armor!");
                player.sendMessage("§6§l[InvManageCommands] §aCleared §r§e"+ target.getName() + "'s §r§aArmor!");

            }



        }catch (Exception e){

            player.sendMessage("§cThat player does not exist!");

        }


    }else{

        player.sendMessage("§cYou don't have the required permission: invmanage.affectothers");

    }


}else{


    player.sendMessage("§c/cleararmor <player>");

}

            }



if (cmd.getName().equalsIgnoreCase("copyinv")){
if (player.hasPermission("invmanage.copyinv")){

    if (args.length != 1){

        player.sendMessage("§c/copyinv <player>");




    }else if (args.length == 1){


        try{

            Player target =
                    Bukkit.getPlayerExact(args[0]);




            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            playertargetplayer.put(player.getUniqueId(), target.getUniqueId());


            if (player.getUniqueId().equals(target.getUniqueId())){


                player.sendMessage("§6§l[InvManageCommands] §bCopied your own inventory...?");

            }else{

                CopyInvScreen copyInvScreen = new CopyInvScreen();
                player.sendMessage("§6§l[InvManageCommands] §bAre you sure you want to copy §e" +target.getName() + "'s §binventory?" );
                player.openInventory(copyInvScreen.getInventory());

            }



        }catch (Exception e){


            player.sendMessage("§cThat player does not exist!");

        }






    }



}else{

    player.sendMessage("§cYou don't have the required permission: clearhotbarcommands.copyinv");


}


}

        }else{

            commandSender.sendMessage("§6§l[InvManageCommands] §r§l§cOnly players can execute this command!");


        }
        return true;


    }
}
