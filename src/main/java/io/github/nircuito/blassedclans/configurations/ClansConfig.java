package io.github.nircuito.blassedclans.configurations;

import io.github.nircuito.blassedclans.BlassedClans;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class ClansConfig {
    private static FileConfiguration player = null;
    private static File playerFile = null;
    private static Plugin plugin = BlassedClans.getPlugin(BlassedClans.class);

    public static void init() {
        reload();
        load();
        reload();
    }

    private static void load() {
        getConfig().options().copyDefaults(true);
        save();
    }

    public static void reload() {
        if (playerFile == null) {
            playerFile = new File(plugin.getDataFolder(), "clan.yml");
        }
        player = YamlConfiguration.loadConfiguration(playerFile);
    }

    public static FileConfiguration getConfig() {
        if (player == null) reload();
        return player;
    }

    public static void save() {
        if (player == null || playerFile == null) {
            return;
        }

        try {
            player.save(playerFile);
        } catch (IOException ex) {
            plugin.getLogger().severe("Could not save clan.yml to " + playerFile.getAbsolutePath());
            ex.printStackTrace();
        }
    }
}
