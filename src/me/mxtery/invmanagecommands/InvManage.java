package me.mxtery.invmanagecommands;

import me.mxtery.invmanagecommands.bstats.Metrics;
import me.mxtery.invmanagecommands.commands.InvManageCommands;
import me.mxtery.invmanagecommands.events.InvManageEvents;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class InvManage extends JavaPlugin {
    public static InvManage plugin;
    @Override
    public void onEnable(){
        plugin = this;
    getServer().getPluginManager().registerEvents(new InvManageEvents(), this);
    getServer().getConsoleSender().sendMessage("§6§l[InvManageCommands] §r§aEnabled!");
    Objects.requireNonNull(getCommand("clearhotbar")).setExecutor(new InvManageCommands());
    Objects.requireNonNull(getCommand("clearhand")).setExecutor(new InvManageCommands());
    Objects.requireNonNull(getCommand("clearoffhand")).setExecutor(new InvManageCommands());
    Objects.requireNonNull(getCommand("clearhands")).setExecutor(new InvManageCommands());
    Objects.requireNonNull(getCommand("cl")).setExecutor(new InvManageCommands());
    Objects.requireNonNull(getCommand("clearhotbarslot")).setExecutor(new InvManageCommands());
    Objects.requireNonNull(getCommand("cleararmor")).setExecutor(new InvManageCommands());
    Objects.requireNonNull(getCommand("invmanage")).setExecutor(new InvManageCommands());
        Objects.requireNonNull(getCommand("copyinv")).setExecutor(new InvManageCommands());
        int pluginId = 14666; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);

        // Optional: Add custom charts
        metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));

    }

    @Override
    public void onDisable(){

        getServer().getConsoleSender().sendMessage("§6§l[InvManageCommands §r§c Disabled!");


    }



}
