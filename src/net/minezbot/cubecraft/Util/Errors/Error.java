package net.minezbot.cubecraft.Util.Errors;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Error {

	public static void sendError(Player p, ErrorCode code) {
		p.sendMessage(ChatColor.RED + "[Error] Name: " + code.getName() + " ID: " + code.getId());
		p.sendMessage(ChatColor.RED + "[Error] Please report this to a admin so this can be resolved. They may ask some questions about what you was doing to cause this error, dont lie because we need to know :)");
	}

}
