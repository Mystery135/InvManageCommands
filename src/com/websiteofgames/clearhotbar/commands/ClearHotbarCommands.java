package com.websiteofgames.clearhotbar.commands;

import com.websiteofgames.clearhotbar.inventories.ClearHotbarSlotScreen;
import com.websiteofgames.clearhotbar.inventories.ClearInvScreen;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClearHotbarCommands implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] args) {
        if (commandSender instanceof Player){
            Player player = (Player)commandSender;
            if (cmd.getName().equalsIgnoreCase("clearhotbar")){
                player.sendMessage("§6§l[ClearHotbarCommands] " + "§r§l§aHotbar cleared!");
                for(int i = 0; i<9; i++){

                    player.getInventory().setItem(i, null);


                }



            }
            if(cmd.getName().equalsIgnoreCase("clearhand")){

                player.getInventory().setItemInMainHand(null);
                player.sendMessage("§6§l[ClearHotbarCommands] " + "§r§l§aHand cleared!");


            }
            if(cmd.getName().equalsIgnoreCase("clearhands")){

                player.getInventory().setItemInMainHand(null);
                player.getInventory().setItemInOffHand(null);
                player.sendMessage("§6§l[ClearHotbarCommands] " + "§r§l§aHands cleared!");


            }
            if(cmd.getName().equalsIgnoreCase("clearoffhand")){

                player.getInventory().setItemInOffHand(null);
                player.sendMessage("§6§l[ClearHotbarCommands] " + "§r§l§aOffhand cleared!");

            }
            if (cmd.getName().equalsIgnoreCase("cl")){
                ClearInvScreen inv = new ClearInvScreen();
                player.openInventory(inv.getInventory());
                player.sendMessage(  "§6§l[ClearHotbarCommands]" + " §l§bAre you sure you want to clear your inventory?");

            }
            if (cmd.getName().equalsIgnoreCase("clearhotbarslot")){
                if (args.length == 0){
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

        player.sendMessage("§6§l[ClearHotbarCommands] §r§l§aHotbar slot" + st +" cleared!" );



    }else{

        player.sendMessage("§6§l[ClearHotbarCommands] §r§l§aHotbar slots " + st+" cleared!" );




    }




}      else {


    player.sendMessage("§6§l[ClearHotbarCommands] " + "§r§c§lThere are only 9 slots in your hotbar!");


}








                }else {

                    player.sendMessage("§6§l[ClearHotbarCommands] " + "§r§l§c/chbs <hotbarslot> <hotbarslot>");
                    player.sendMessage("§l§cYou can only input 9 hotbar slots!");

                }



            }
            if (cmd.getName().equalsIgnoreCase("cleararmor")){


                player.getInventory().setArmorContents(null);
                player.sendMessage("§6§l[ClearHotbarCommands] " + "§r§l§aArmour/Armor cleared!");




            }





        }else{

            commandSender.sendMessage("§6§l[ClearHotbarCommands] §r§l§cOnly players can execute this command!");


        }
        return true;


    }
}
