package net.minezbot.cubecraft.Util;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Msg {

	public enum Chan {

		ALERT, STAFF, CHAT, BROADCAST, INFO, WARN, ERROR;
	}

	private static ArrayList<String> chanBroadcast = new ArrayList<String>();
	private static ArrayList<String> chanStaff = new ArrayList<String>();
	private static ArrayList<String> chanChat = new ArrayList<String>();
	private static ArrayList<String> chanAlert = new ArrayList<String>();
	private static ArrayList<String> chanInfo = new ArrayList<String>();
	private static ArrayList<String> chanWarn = new ArrayList<String>();
	private static ArrayList<String> chanError = new ArrayList<String>();

	private static String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_PURPLE + "CubeCraft" + ChatColor.DARK_GRAY + "] ";
	private static String info = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_PURPLE + "Info" + ChatColor.DARK_GRAY + "] ";
	private static String staff = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_PURPLE + "Staff" + ChatColor.DARK_GRAY + "] ";
	private static String warning = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_PURPLE + "Warning" + ChatColor.DARK_GRAY + "] ";
	private static String error = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_PURPLE + "Error" + ChatColor.DARK_GRAY + "] ";

	public static void messageChannal(Chan chan, String msg) {
		if (chan == Chan.BROADCAST) {
			for (String s : chanBroadcast) {
				Player p = Bukkit.getPlayer(s);
				if (p != null) {
					p.sendMessage(prefix + ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', msg));
				}
			}
		}
		if (chan == Chan.ALERT) {
			for (String s : chanAlert) {
				Player p = Bukkit.getPlayer(s);
				if (p != null) {
					p.sendMessage(ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', msg));
				}
			}
		}
		if (chan == Chan.CHAT) {
			for (String s : chanChat) {
				Player p = Bukkit.getPlayer(s);
				if (p != null) {
					p.sendMessage(ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', msg));
				}
			}
		}
		if (chan == Chan.INFO) {
			for (String s : chanInfo) {
				Player p = Bukkit.getPlayer(s);
				if (p != null) {
					p.sendMessage(info + ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', msg));
				}
			}
		}
		if (chan == Chan.STAFF) {
			for (String s : chanStaff) {
				Player p = Bukkit.getPlayer(s);
				if (p != null) {
					p.sendMessage(staff + ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', msg));
				}
			}
		}
		if (chan == Chan.WARN) {
			for (String s : chanWarn) {
				Player p = Bukkit.getPlayer(s);
				if (p != null) {
					p.sendMessage(warning + ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', msg));
				}
			}
		}
		if (chan == Chan.ERROR) {
			for (String s : chanError) {
				Player p = Bukkit.getPlayer(s);
				if (p != null) {
					p.sendMessage(error + ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', msg));
				}
			}
		}
	}

	public static void messagePlayer(Chan chan, Player p, String msg) {
		if (chan == Chan.ALERT) {
			if (chanAlert.contains(p.getName())) {
				p.sendMessage(ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', msg));
			}
		}
		if (chan == Chan.BROADCAST) {
			if (chanBroadcast.contains(p.getName())) {
				p.sendMessage(prefix + ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', msg));
			}
		}
		if (chan == Chan.CHAT) {
			if (chanChat.contains(p.getName())) {
				p.sendMessage(ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', msg));
			}
		}
		if (chan == Chan.INFO) {
			if (chanInfo.contains(p.getName())) {
				p.sendMessage(info + ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', msg));
			}
		}
		if (chan == Chan.STAFF) {
			if (chanStaff.contains(p.getName())) {
				p.sendMessage(staff + ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', msg));
			}
		}
		if (chan == Chan.WARN) {
			if (chanWarn.contains(p.getName())) {
				p.sendMessage(warning + ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', msg));
			}
		}
		if (chan == Chan.ERROR) {
			if (chanError.contains(p.getName())) {
				p.sendMessage(error + ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', msg));
			}
		}
	}

	public static void setChan(Player p, Chan chan, boolean allow) {
		if (chan == Chan.INFO) {
			if (allow == true) {
				chanInfo.add(p.getName());
				messagePlayer(Chan.INFO, p, "&7Channel " + chan.toString() + " is now open!");
			} else {
				chanInfo.remove(p.getName());
				messagePlayer(Chan.INFO, p, "&7Channel " + chan.toString() + " is now closed!");
			}

		}
		if (chan == Chan.ALERT) {
			if (allow == true) {
				chanAlert.add(p.getName());
				messagePlayer(Chan.INFO, p, "&7Channel " + chan.toString() + " is now open!");
			} else {
				chanAlert.remove(p.getName());
				messagePlayer(Chan.INFO, p, "&7Channel " + chan.toString() + " is now closed!");
			}
		}
		if (chan == Chan.BROADCAST) {
			if (allow == true) {
				chanBroadcast.add(p.getName());
				messagePlayer(Chan.INFO, p, "&7Channel " + chan.toString() + " is now open!");
			} else {
				chanBroadcast.remove(p.getName());
				messagePlayer(Chan.INFO, p, "&7Channel " + chan.toString() + " is now closed!");
			}
		}
		if (chan == Chan.CHAT) {
			if (allow == true) {
				chanChat.add(p.getName());
				messagePlayer(Chan.INFO, p, "&7Channel " + chan.toString() + " is now open!");
			} else {
				chanChat.remove(p.getName());
				messagePlayer(Chan.INFO, p, "&7Channel " + chan.toString() + " is now closed!");
			}
		}
		if (chan == Chan.STAFF) {
			if (allow == true) {
				chanStaff.add(p.getName());
				messagePlayer(Chan.INFO, p, "&7Channel " + chan.toString() + " is now open!");
			} else {
				chanStaff.remove(p.getName());
				messagePlayer(Chan.INFO, p, "&7Channel " + chan.toString() + " is now closed!");
			}
		}
		if (chan == Chan.WARN) {
			if (allow == true) {
				chanWarn.add(p.getName());
				messagePlayer(Chan.INFO, p, "&7Channel " + chan.toString() + " is now open!");
			} else {
				chanWarn.remove(p.getName());
				messagePlayer(Chan.INFO, p, "&7Channel " + chan.toString() + " is now closed!");
			}
		}
		if (chan == Chan.ERROR) {
			if (allow == true) {
				chanError.add(p.getName());
				messagePlayer(Chan.INFO, p, "&7Channel " + chan.toString() + " is now open!");
			} else {
				chanError.remove(p.getName());
				messagePlayer(Chan.INFO, p, "&7Channel " + chan.toString() + " is now closed!");
			}
		}
	}

	public static boolean isChannelOpen(Player p, Chan chan) {
		if (chan == Chan.ALERT) {
			return chanAlert.contains(p.getName());
		}
		if (chan == Chan.BROADCAST) {
			return chanBroadcast.contains(p.getName());
		}
		if (chan == Chan.CHAT) {
			return chanChat.contains(p.getName());
		}
		if (chan == Chan.INFO) {
			return chanInfo.contains(p.getName());
		}
		if (chan == Chan.STAFF) {
			return chanStaff.contains(p.getName());
		}
		if (chan == Chan.WARN) {
			return chanWarn.contains(p.getName());
		}
		return false;
	}

}
