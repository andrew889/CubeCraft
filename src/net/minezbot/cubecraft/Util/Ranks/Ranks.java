package net.minezbot.cubecraft.Util.Ranks;

import net.minezbot.cubecraft.Util.Msg;
import net.minezbot.cubecraft.Util.Msg.Chan;
import net.minezbot.cubecraft.Util.Util;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Ranks {

	/*
	 * EVERYTHING IN THIS CLASS MUST BE CHANGED FROM YAML TO MYSQL WHEN SQL
	 * SERVER IS LIVE!
	 */
	private static void saveConfig() {
		Util.getPlugin().saveConfig();
	}

	private static FileConfiguration getConfig() {
		return Util.getPlugin().getConfig();
	}

	public static boolean hasRank(Player p) {
		return getConfig().contains("Ranks." + p.getName().toLowerCase());
	}

	public static void setRank(String p, Rank rank) {
		if (getConfig().contains("Ranks." + p.toLowerCase())) {
			getConfig().set("Ranks." + p.toLowerCase(), rank.toString());
			Player pl = Bukkit.getPlayer(p);
			if (pl != null) {
				Msg.messagePlayer(Chan.INFO, pl, "Your rank has been set to &3" + rank.toString().toLowerCase() + "&7!");
			}
			saveConfig();
		} else {
			getConfig().createSection("Ranks." + p.toLowerCase());
			getConfig().set("Ranks." + p.toLowerCase(), rank.toString());
			saveConfig();
		}
	}

	public static Rank getRank(Player p) {
		return getRankByName(getConfig().getString("Ranks." + p.getName().toLowerCase()));
	}

	public static boolean isStaff(Player p) {
		return getRank(p) == Rank.OWNER || getRank(p) == Rank.DEVELOPER || getRank(p) == Rank.ADMIN || getRank(p) == Rank.STAFF;
	}

	public static Rank getRankByName(String name) {
		if (name.equalsIgnoreCase("owner")) {
			return Rank.OWNER;
		}
		if (name.equalsIgnoreCase("admin")) {
			return Rank.ADMIN;
		}
		if (name.equalsIgnoreCase("developer")) {
			return Rank.DEVELOPER;
		}
		if (name.equalsIgnoreCase("staff")) {
			return Rank.STAFF;
		}
		if (name.equalsIgnoreCase("vip")) {
			return Rank.VIP;
		}
		if (name.equalsIgnoreCase("donator")) {
			return Rank.DONATOR;
		}
		if (name.equalsIgnoreCase("player")) {
			return Rank.PLAYER;
		}
		return Rank.UNKNOWN;
	}

}
