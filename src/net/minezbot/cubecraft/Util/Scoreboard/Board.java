package net.minezbot.cubecraft.Util.Scoreboard;

import net.minezbot.cubecraft.Util.Player.CCPlayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Board {

	private static ScoreboardManager manager;
	private static Scoreboard board;

	/*
	 * private static Team owner; private static Team admin; private static Team
	 * developer; private static Team staff; private static Team vip; private
	 * static Team donator; private static Team player;
	 */

	public static void loadScoreboard() {
		manager = Bukkit.getScoreboardManager();
		board = manager.getNewScoreboard();
	}

	public static void updateScoreboard(Player p) {
		board = p.getScoreboard();
		Objective o = board.getObjective(p.getName() + "Stats");
		if (o == null) {
			o = board.registerNewObjective(p.getName() + "Stats", "Dummy");
			o.setDisplaySlot(DisplaySlot.SIDEBAR);
			p.setScoreboard(board);
			for (Player all : Bukkit.getOnlinePlayers()) {
				updateScoreboard(all);
			}
		}
		o.setDisplayName(ChatColor.GOLD + "Stats");
		Score xp = o.getScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "XP"));
		xp.setScore(CCPlayer.getXp(p));
		Score gold = o.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "Gold"));
		gold.setScore(CCPlayer.getGold(p));
		Score level = o.getScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "Level"));
		level.setScore(CCPlayer.getLevel(p));
	}

	public static void removeObjective(Player p) {
		board = p.getScoreboard();
		Objective o = board.getObjective(p.getName() + "Stats");
		if (o != null) {
			o.unregister();
		}
	}

}