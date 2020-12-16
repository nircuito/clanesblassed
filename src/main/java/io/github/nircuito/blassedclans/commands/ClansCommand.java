package io.github.nircuito.blassedclans.commands;

import io.github.nircuito.blassedclans.configurations.ClansConfig;
import io.github.nircuito.blassedclans.utils.ColorColorize;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClansCommand implements CommandExecutor {
    String blassed = ColorColorize.colorize("&6[&eBlassed&6]");
    private String clanname;
    ClanHandler clanHandler = new ClanHandler();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ColorColorize.colorize(blassed+" No puedes usar este comando en la consola"));
        }else {
            Player p = (Player) sender;
            if(args.length < 1) {
                p.sendMessage(" "+blassed);
                p.sendMessage(ColorColorize.colorize("&eUse /clan create"));
                p.sendMessage(ColorColorize.colorize("&eUse /clan delete"));
            }
            else if(args[0].equalsIgnoreCase("create")) {
                if(args.length < 2) {
                    p.sendMessage(ColorColorize.colorize(blassed+" &eUse /clan create"));
                }
                else if (args.length < 3) {
                    clanname = args[1];
                     p.sendMessage(clanHandler.createClan(clanname, p));
                }
            }
            else if(args[0].equalsIgnoreCase("delete")) {
                if (args.length < 2) {
                    clanHandler.clanDelete(p);
                    ClansConfig.save();
                }
            }
        }
        return false;
    }
}
