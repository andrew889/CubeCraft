package net.minezbot.cubecraft.Commands;

import net.minezbot.cubecraft.Util.Msg;
import net.minezbot.cubecraft.Util.Msg.Chan;
import net.minezbot.cubecraft.Util.Ranks.Rank;
import net.minezbot.cubecraft.Util.Ranks.Ranks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetRank implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (Ranks.getRank(p) != Rank.OWNER || Ranks.getRank(p) != Rank.ADMIN || Ranks.getRank(p) != Rank.DEVELOPER) {
				Msg.messagePlayer(Chan.ERROR, p, "You dont have permission to do that!");
				return false;
			}
		}
		if (cmd.getName().equalsIgnoreCase("setrank")) {
			if (args.length == 2) {
				if (Ranks.getRankByName(args[1]) != Rank.UNKNOWN) {
					Ranks.setRank(args[0], Ranks.getRankByName(args[1]));
					if (sender instanceof Player) {
						Player p = (Player) sender;
						Msg.messageChannal(Chan.STAFF, p.getDisplayName() + " &7set &3" + args[0] + "'s &7rank to &3" + Ranks.getRankByName(args[1]).toString() + "&7!");
					} else {
						Msg.messageChannal(Chan.STAFF, " &4[CONSOLE] &7set &3" + args[0] + "'s &7rank to &3" + Ranks.getRankByName(args[1]).toString() + "&7!");
					}
				} else {
					if (sender instanceof Player) {
						Msg.messagePlayer(Chan.ERROR, (Player) sender, "That rank was not found!");
					} else {
						sender.sendMessage("That rank was not found!");
					}
				}
			} else {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					Msg.messagePlayer(Chan.INFO, p, "/setrank <player> <rank>");
				}
			}
		}
		return false;
	}

}
