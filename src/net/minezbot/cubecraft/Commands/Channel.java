package net.minezbot.cubecraft.Commands;

import net.minezbot.cubecraft.Util.Msg;
import net.minezbot.cubecraft.Util.Msg.Chan;
import net.minezbot.cubecraft.Util.Ranks.Ranks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Channel implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("This is a player command only!");
			return false;
		}

		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("channel")) {
			if (args.length >= 1) {
				if (args.length == 2) {
					if (args[0].equalsIgnoreCase("open")) {
						if (args[1].equalsIgnoreCase("alert")) {
							Msg.setChan(p, Chan.ALERT, true);
						}
						if (args[1].equalsIgnoreCase("chat")) {
							Msg.setChan(p, Chan.CHAT, true);
						}
						if (args[1].equalsIgnoreCase("broadcast")) {
							Msg.setChan(p, Chan.BROADCAST, true);
						}
						if (Ranks.isStaff(p)) {
							if (args[1].equalsIgnoreCase("staff")) {
								Msg.setChan(p, Chan.STAFF, true);
							}
							if (args[1].equalsIgnoreCase("warn")) {
								Msg.setChan(p, Chan.WARN, true);
							}
						}
						return false;
					}
					if (args[0].equalsIgnoreCase("close")) {
						if (args[1].equalsIgnoreCase("alert")) {
							Msg.setChan(p, Chan.ALERT, false);
						}
						if (args[1].equalsIgnoreCase("chat")) {
							Msg.setChan(p, Chan.CHAT, false);
						}
						if (args[1].equalsIgnoreCase("broadcast")) {
							Msg.setChan(p, Chan.BROADCAST, false);
						}
						if (Ranks.isStaff(p)) {
							if (args[1].equalsIgnoreCase("staff")) {
								Msg.setChan(p, Chan.STAFF, false);
							}
							if (args[1].equalsIgnoreCase("warn")) {
								Msg.setChan(p, Chan.WARN, false);
							}
						}
						return false;
					}
				}
				if (args[0].equalsIgnoreCase("list")) {
					Msg.messagePlayer(Chan.INFO, p, "&bChannels you can edit:");
					Msg.messagePlayer(Chan.INFO, p, "Alert - General Alerts.");
					Msg.messagePlayer(Chan.INFO, p, "Chat - Player Chat.");
					Msg.messagePlayer(Chan.INFO, p, "Broadcast - Server wide broadcasts.");
					if (Ranks.isStaff(p)) {
						Msg.messagePlayer(Chan.INFO, p, "&3Staff - Staff Chat / Staff Alerts.");
						Msg.messagePlayer(Chan.INFO, p, "&3Warn - Warnings From Other Staff.");
					}
					return false;
				}
				if (args[0].equalsIgnoreCase("check")) {
					Msg.messagePlayer(Chan.INFO, p, "&bRunning Channels: ");
					if (Msg.isChannelOpen(p, Chan.ALERT)) {
						Msg.messagePlayer(Chan.INFO, p, "Alert &2(&aOpen&2)");
					} else {
						Msg.messagePlayer(Chan.INFO, p, "Alert &4(&cClosed&4)");
					}
					if (Msg.isChannelOpen(p, Chan.CHAT)) {
						Msg.messagePlayer(Chan.INFO, p, "Chat &2(&aOpen&2)");
					} else {
						Msg.messagePlayer(Chan.INFO, p, "Chat &4(&cClosed&4)");
					}
					if (Msg.isChannelOpen(p, Chan.BROADCAST)) {
						Msg.messagePlayer(Chan.INFO, p, "Broadcast &2(&aOpen&2)");
					} else {
						Msg.messagePlayer(Chan.INFO, p, "Broadcast &4(&cClosed&4)");
					}
					if (Ranks.isStaff(p)) {
						if (Msg.isChannelOpen(p, Chan.STAFF)) {
							Msg.messagePlayer(Chan.INFO, p, "&3Staff &2(&aOpen&2)");
						} else {
							Msg.messagePlayer(Chan.INFO, p, "&3Staff &4(&cClosed&4)");
						}
						if (Msg.isChannelOpen(p, Chan.WARN)) {
							Msg.messagePlayer(Chan.INFO, p, "&3Warn &2(&aOpen&2)");
						} else {
							Msg.messagePlayer(Chan.INFO, p, "&3Warn &4(&cClosed&4)");
						}
					}
				}
				return false;
			}
			Msg.messagePlayer(Chan.INFO, p, "/channel <list/check/open/close> [name]");
		}

		return false;
	}

}
