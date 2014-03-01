package net.minezbot.cubecraft.Events;

import net.minezbot.cubecraft.Util.Player.CCPlayer;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignBuild implements Listener {

	@EventHandler
	public void onSignBuild(SignChangeEvent e) {
		if (CCPlayer.isAdmin(e.getPlayer())) {
			if (e.getLine(0).equalsIgnoreCase("[class]")) {
				if (e.getLine(1).equalsIgnoreCase("warrior")) {
					e.setLine(0, ChatColor.GOLD + "[Class]");
					e.setLine(1, null);
					e.setLine(2, ChatColor.BLACK + "Warrior");
					e.setLine(3, null);
				} else if (e.getLine(1).equalsIgnoreCase("ranger")) {
					e.setLine(0, ChatColor.GOLD + "[Class]");
					e.setLine(1, null);
					e.setLine(2, ChatColor.BLACK + "Ranger");
					e.setLine(3, null);
				} else if (e.getLine(1).equalsIgnoreCase("mage")) {
					e.setLine(0, ChatColor.GOLD + "[Class]");
					e.setLine(1, null);
					e.setLine(2, ChatColor.BLACK + "Mage");
					e.setLine(3, null);
				} else if (e.getLine(1).equalsIgnoreCase("rogue")) {
					e.setLine(0, ChatColor.GOLD + "[Class]");
					e.setLine(1, null);
					e.setLine(2, ChatColor.BLACK + "Rogue");
					e.setLine(3, null);
				} else {
					e.setLine(0, null);
					e.setLine(1, null);
					e.setLine(2, null);
					e.setLine(3, null);
				}
			} else if (e.getLine(0).equalsIgnoreCase("[upgrade]")) {
				if(e.getLine(1).equalsIgnoreCase("damage")) {
					e.setLine(0, ChatColor.GOLD + "[Upgrade]");
					e.setLine(1, "");
					e.setLine(2, ChatColor.BLACK + "Damage");
					e.setLine(3, ChatColor.GOLD + "$200 Gold");
				} else {
					e.setLine(0, null);
					e.setLine(1, null);
					e.setLine(2, null);
					e.setLine(3, null);
				}
			} else if(e.getLine(0).equalsIgnoreCase("[enchant]")) {
				if(e.getLine(1).equalsIgnoreCase("flame")) {
					e.setLine(0, ChatColor.GOLD + "[Enchant]");
					e.setLine(1, "");
					e.setLine(2, ChatColor.BLACK + "Flame");
					e.setLine(3, ChatColor.GOLD + "$500 Gold");
				} else {
					e.setLine(0, null);
					e.setLine(1, null);
					e.setLine(2, null);
					e.setLine(3, null);
				}
			} else {
				e.setLine(0, null);
				e.setLine(1, null);
				e.setLine(2, null);
				e.setLine(3, null);
			}
		} else {
			e.setLine(0, null);
			e.setLine(1, null);
			e.setLine(2, null);
			e.setLine(3, null);
		}
	}

}
