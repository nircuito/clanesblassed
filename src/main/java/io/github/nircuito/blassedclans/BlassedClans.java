package io.github.nircuito.blassedclans;

import io.github.nircuito.blassedclans.commands.ClansCommand;
import io.github.nircuito.blassedclans.configurations.ClansConfig;
import io.github.nircuito.blassedclans.utils.ColorColorize;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlassedClans extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ColorColorize.colorize("&e-------------------"));
        Bukkit.getConsoleSender().sendMessage(ColorColorize.colorize("&e   Blassed Gkit    "));
        Bukkit.getConsoleSender().sendMessage(ColorColorize.colorize("&e  Plugin Enabled   "));
        Bukkit.getConsoleSender().sendMessage(ColorColorize.colorize("&e-------------------"));
        ClansConfig.init();
        commandLoad();

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ColorColorize.colorize("&e-------------------"));
        Bukkit.getConsoleSender().sendMessage(ColorColorize.colorize("&e   Blassed Gkit    "));
        Bukkit.getConsoleSender().sendMessage(ColorColorize.colorize("&e  Plugin Disabled  "));
        Bukkit.getConsoleSender().sendMessage(ColorColorize.colorize("&e-------------------"));
        // Plugin shutdown logic

    }
    public void commandLoad() {
        getCommand("clanes").setExecutor(new ClansCommand());

    }

}
