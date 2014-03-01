package net.minezbot.cubecraft.Commands;

import net.minezbot.cubecraft.Util.Msg;
import net.minezbot.cubecraft.Util.Msg.Chan;
import net.minezbot.cubecraft.Util.Ranks.Ranks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Staff implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This is a player command only!");
			return false;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("sc") || cmd.getName().equalsIgnoreCase("staffchat")) {
			if (Ranks.isStaff(p)) {
				if (args.length >= 1) {
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < args.length; i++) {
						sb.append(args[i] + " ");
					}
					Msg.messageChannal(Chan.STAFF, p.getDisplayName() + "&7: " + sb.toString());
				} else {
					Msg.messagePlayer(Chan.ERROR, p, "/sc <msg>");
				}
			} else {
				Msg.messagePlayer(Chan.ERROR, p, "You dont have permission to do that!");
			}
		}
		return false;
	}

}
