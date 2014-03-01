package net.minezbot.cubecraft.Commands;

import java.util.ArrayList;

import net.minezbot.cubecraft.Util.Msg;
import net.minezbot.cubecraft.Util.Msg.Chan;
import net.minezbot.cubecraft.Util.Player.CCPlayer;
import net.minezbot.cubecraft.Util.Scoreboard.Board;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Debug implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("This is a player command only!");
		}

		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("debug")) {
			if (CCPlayer.isAdmin(p)) {
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("sword")) {
						ArrayList<String> lore = new ArrayList<String>();
						lore.add(ChatColor.RED + "Debug Sword!");
						lore.add(ChatColor.GRAY + "Damage: 8");
						lore.add(ChatColor.GRAY + "Enchant: Flame");
						ItemStack item = new ItemStack(Material.IRON_SWORD);
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName("Debug Iron Sword");
						meta.setLore(lore);
						item.setItemMeta(meta);
						p.getInventory().addItem(item);
						return false;
					}
					Msg.messagePlayer(Chan.INFO, p, "/debug <sword, givexp, givegold>");
				} else if (args.length == 2) {
					if (args[0].equalsIgnoreCase("givexp")) {
						if (isInt(args[1])) {
							CCPlayer.setXp(p, CCPlayer.getXp(p) + getInt(args[1]));
							Msg.messagePlayer(Chan.INFO, p, "You have been given " + args[1] + " xp points!");
							Board.updateScoreboard(p);
						} else {
							Msg.messagePlayer(Chan.INFO, p, "/debug givexp <n>");
						}
						return false;
					} else if(args[0].equalsIgnoreCase("givegold")) {
						if (isInt(args[1])) {
							CCPlayer.setGold(p, CCPlayer.getGold(p) + getInt(args[1]));
							Msg.messagePlayer(Chan.INFO, p, "You have been given " + args[1] + " gold!");
							Board.updateScoreboard(p);
						} else {
							Msg.messagePlayer(Chan.INFO, p, "/debug givegold <n>");
						}
						return false;
					}
					Msg.messagePlayer(Chan.INFO, p, "/debug <sword, givexp, givegold>");
				} else {
					Msg.messagePlayer(Chan.INFO, p, "/debug <sword, givexp, givegold>");
				}
			} else {
				Msg.messagePlayer(Msg.Chan.ERROR, p, "You dont have permission to do that!");
			}
		}
		return false;
	}

	public static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public int getInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return 0;
		}
	}

}
