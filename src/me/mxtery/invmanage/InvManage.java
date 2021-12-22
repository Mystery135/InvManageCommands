package me.mxtery.invmanage;

import me.mxtery.invmanage.commands.InvManageCommands;
import me.mxtery.invmanage.events.InvManageEvents;
import org.bukkit.plugin.java.JavaPlugin;

public class InvManage extends JavaPlugin {
    @Override
    public void onEnable(){
        InvManageCommands commands = new InvManageCommands();
    getServer().getPluginManager().registerEvents(new InvManageEvents(), this);
    getServer().getConsoleSender().sendMessage("§6§l[InvManageCommands] §r§aEnabled!");
    getCommand("clearhotbar").setExecutor(new InvManageCommands());
    getCommand("clearhand").setExecutor(new InvManageCommands());
    getCommand("clearoffhand").setExecutor(new InvManageCommands());
    getCommand("clearhands").setExecutor(new InvManageCommands());
    getCommand("cl").setExecutor(new InvManageCommands());
    getCommand("clearhotbarslot").setExecutor(new InvManageCommands());
    getCommand("cleararmor").setExecutor(new InvManageCommands());
        getCommand("copyinv").setExecutor(new InvManageCommands());

    }

    @Override
    public void onDisable(){

        getServer().getConsoleSender().sendMessage("§6§l[InvManageCommands §r§c Disabled!");


    }



}
