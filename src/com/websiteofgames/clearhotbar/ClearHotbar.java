package com.websiteofgames.clearhotbar;

import com.websiteofgames.clearhotbar.commands.ClearHotbarCommands;
import com.websiteofgames.clearhotbar.events.ClearHotbarEvents;
import org.bukkit.plugin.java.JavaPlugin;

public class ClearHotbar extends JavaPlugin {
    @Override
    public void onEnable(){
        ClearHotbarCommands commands = new ClearHotbarCommands();
    getServer().getPluginManager().registerEvents(new ClearHotbarEvents(), this);
    getServer().getConsoleSender().sendMessage("§6§l[ClearHotbarCommands] §r§aEnabled!");
    getCommand("clearhotbar").setExecutor(new ClearHotbarCommands());
    getCommand("clearhand").setExecutor(new ClearHotbarCommands());
    getCommand("clearoffhand").setExecutor(new ClearHotbarCommands());
    getCommand("clearhands").setExecutor(new ClearHotbarCommands());
    getCommand("cl").setExecutor(new ClearHotbarCommands());
    getCommand("clearhotbarslot").setExecutor(new ClearHotbarCommands());
    getCommand("cleararmor").setExecutor(new ClearHotbarCommands());
    }

    @Override
    public void onDisable(){

        getServer().getConsoleSender().sendMessage("§6§l[ClearHotbarCommands §r§c Disabled!");


    }



}
