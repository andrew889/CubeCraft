package net.minezbot.cubecraft.Commands;

import net.minezbot.cubecraft.Util.Msg;
import net.minezbot.cubecraft.Util.Msg.Chan;
import net.minezbot.cubecraft.Util.Player.CCPlayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This is a player command only!");
			return false;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("broadcast")) {
			if (CCPlayer.isAdmin(p)) {
				if (args.length >= 1) {
					String broadcast = "";
					for (int i = 0; i < args.length; i++) {
						broadcast += args[i] + " ";
					}
					broadcast.trim();
					Msg.messageChannal(Chan.BROADCAST, broadcast);
				} else {
					Msg.messagePlayer(Chan.INFO, p, "/broadcast <msg>");
				}
			} else {
				Msg.messagePlayer(Chan.ERROR, p, "You do not have permission to do that!");
			}
		}
		return false;
	}

}
