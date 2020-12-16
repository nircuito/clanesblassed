package io.github.nircuito.blassedclans.commands;

import io.github.nircuito.blassedclans.configurations.ClansConfig;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Set;

public class ClanHandler {
    private boolean clanDeleteBoolean;
    private boolean clanExist;
    private boolean isLeaderClan;
    public ArrayList<String> nameclan = new ArrayList<String>();

    private void clanExistConfig(String clanExist) {
        if (ClansConfig.getConfig().isSet("clan." + clanExist)) {
            this.clanExist = false;
        } else {
            this.clanExist = true;
        }
    }

    public String createClan(String clanExist, Player player) {
        clanExistConfig(clanExist);



            if (this.clanExist) {
                ClansConfig.getConfig().set("clan." + clanExist + ".leader", player.getName());
                ClansConfig.save();
                return "Creaste el clan " + clanExist;


            } else {
                return "El clan " + clanExist + " ya existe";
            }
         }



    private boolean isLeader(Player player) {
        for (String clans : listClans()) {
            if (ClansConfig.getConfig().getString("clan." + clans + ".leader").contains(player.getName())) {
                nameclan.add(clans);
                return true;
            }
        }
        return false;
    }

    private Set<String> listClans() {
        return ClansConfig.getConfig().getConfigurationSection("clan.").getKeys(false);
    }

    public void clanDelete(Player player) {
        if (isLeader(player)) {
            for (String clan : nameclan) {
                ClansConfig.getConfig().set("clan." + clan, null);
                nameclan.remove(clan);
                clanDeleteBoolean = true;
            }
        }
        if (this.clanDeleteBoolean) {
            player.sendMessage("se borro el clan");
            clanDeleteBoolean = false;
        } else {
            player.sendMessage("No tienes un clan");
        }

    }


}
