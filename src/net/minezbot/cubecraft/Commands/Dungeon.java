package net.minezbot.cubecraft.Commands;

import net.minezbot.cubecraft.Util.Msg;
import net.minezbot.cubecraft.Util.Msg.Chan;
import net.minezbot.cubecraft.Util.Player.CCPlayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Dungeon {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("This is a player command only!");
			return false;
		}
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("dungeon")) {
			if(CCPlayer.isAdmin(p)) {
				Msg.messagePlayer(Chan.INFO, p, "Coming Soon :)");
			} else {
				Msg.messagePlayer(Chan.ERROR, p, "&cYou do not have permission to do this!");
			}
		}
		return false;
	}
	
}
