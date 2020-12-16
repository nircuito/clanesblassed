package io.github.nircuito.blassedclans.utils;

import org.bukkit.ChatColor;

public class ColorColorize {
    public static String colorize(String input) {
       return ChatColor.translateAlternateColorCodes('&', input);
    }
}
