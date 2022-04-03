package de.notjansel.leathercolor;

import de.notjansel.leathercolor.commands.ColorCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LeatherColor extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("Enabling LeatherColor...");
        getCommand("color").setExecutor(new ColorCommand());
        Bukkit.getConsoleSender().sendMessage("LeatherColor enabled!");
    }

    @Override
    public void onDisable() {

    }
}
