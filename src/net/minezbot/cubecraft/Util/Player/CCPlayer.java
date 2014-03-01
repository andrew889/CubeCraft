package net.minezbot.cubecraft.Util.Player;

import net.minezbot.cubecraft.Util.Msg;
import net.minezbot.cubecraft.Util.Msg.Chan;
import net.minezbot.cubecraft.Util.Util;
import net.minezbot.cubecraft.Util.Errors.Error;
import net.minezbot.cubecraft.Util.Errors.ErrorCode;
import net.minezbot.cubecraft.Util.Ranks.Rank;
import net.minezbot.cubecraft.Util.Ranks.Ranks;
import net.minezbot.cubecraft.Util.Teams.Team;
import net.minezbot.cubecraft.Util.Teams.Team.ClassName;

import org.bukkit.entity.Player;

public class CCPlayer {

	public static Rank getRank(Player p) {
		return Ranks.getRank(p);
	}

	public static void setRank(Player p, Rank rank) {
		Ranks.setRank(p.getName().toLowerCase(), rank);
	}

	public static boolean isChannelOpen(Player p, Chan chan) {
		return Msg.isChannelOpen(p, chan);
	}

	public static boolean isStaff(Player p) {
		return Ranks.isStaff(p);
	}

	public static boolean isAdmin(Player p) {
		return Ranks.getRank(p) == Rank.ADMIN || Ranks.getRank(p) == Rank.DEVELOPER || Ranks.getRank(p) == Rank.OWNER;
	}

	public static boolean dosePlayerDataExist(Player p) {
		return Util.getPlugin().getConfig().contains("PlayerData." + p.getName());
	}

	public static void createPlayerData(Player p) {
		if (!dosePlayerDataExist(p)) {
			Util.getPlugin().getConfig().createSection("PlayerData." + p.getName() + ".xp");
			Util.getPlugin().getConfig().createSection("PlayerData." + p.getName() + ".level");
			Util.getPlugin().getConfig().createSection("PlayerData." + p.getName() + ".class");
			Util.getPlugin().getConfig().createSection("PlayerData." + p.getName() + ".gold");
			Util.getPlugin().getConfig().createSection("PlayerData." + p.getName() + ".maxhealth");
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".xp", 0);
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".level", 1);
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".class", "Unknown");
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".gold", 0);
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".maxhealth", 160);
			Util.getPlugin().saveConfig();
		}
	}

	public static int getGold(Player p) {
		if (dosePlayerDataExist(p)) {
			return Util.getPlugin().getConfig().getInt("PlayerData." + p.getName() + ".gold");
		} else {
			createPlayerData(p);
			return 0;
		}
	}

	public static int getXp(Player p) {
		if (dosePlayerDataExist(p)) {
			return Util.getPlugin().getConfig().getInt("PlayerData." + p.getName() + ".xp");
		} else {
			createPlayerData(p);
			return 0;
		}
	}

	public static int getLevel(Player p) {
		if (dosePlayerDataExist(p)) {
			return Util.getPlugin().getConfig().getInt("PlayerData." + p.getName() + ".level");
		} else {
			createPlayerData(p);
			return 1;
		}
	}

	public static Team.ClassName getClass(Player p) {
		if (dosePlayerDataExist(p)) {
			if (Util.getPlugin().getConfig().getString("PlayerData." + p.getName() + ".class").equalsIgnoreCase("warrior")) {
				return ClassName.WARRIOR;
			} else if (Util.getPlugin().getConfig().getString("PlayerData." + p.getName() + ".class").equalsIgnoreCase("ranger")) {
				return ClassName.RANGER;
			} else if (Util.getPlugin().getConfig().getString("PlayerData." + p.getName() + ".class").equalsIgnoreCase("mage")) {
				return ClassName.MAGE;
			} else if (Util.getPlugin().getConfig().getString("PlayerData." + p.getName() + ".class").equalsIgnoreCase("rogue")) {
				return ClassName.ROGUE;
			} else {
				Error.sendError(p, ErrorCode.PLAYER_CLASS_NOT_FOUND);
				return ClassName.UNKNOWN;
			}
		} else {
			createPlayerData(p);
			return Team.ClassName.WARRIOR;
		}
	}

	public static void setGold(Player p, int gold) {
		if (dosePlayerDataExist(p)) {
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".gold", gold);
			Util.getPlugin().saveConfig();
		} else {
			createPlayerData(p);
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".gold", gold);
			Util.getPlugin().saveConfig();
		}
	}

	public static void setXp(Player p, int xp) {
		if (dosePlayerDataExist(p)) {
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".xp", xp);
			Util.getPlugin().saveConfig();
		} else {
			createPlayerData(p);
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".xp", xp);
			Util.getPlugin().saveConfig();
		}
	}

	public static void setLevel(Player p, int level) {
		if (dosePlayerDataExist(p)) {
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".level", level);
			Util.getPlugin().saveConfig();
		} else {
			createPlayerData(p);
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".level", level);
			Util.getPlugin().saveConfig();
		}
	}

	public static void setClass(Player p, ClassName name) {

	}

}
