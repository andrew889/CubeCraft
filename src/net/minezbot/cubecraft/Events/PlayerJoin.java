package net.minezbot.cubecraft.Events;

import net.minezbot.cubecraft.Util.Msg;
import net.minezbot.cubecraft.Util.Util;
import net.minezbot.cubecraft.Util.Msg.Chan;
import net.minezbot.cubecraft.Util.Player.Health.Health;
import net.minezbot.cubecraft.Util.Ranks.Rank;
import net.minezbot.cubecraft.Util.Ranks.Ranks;
import net.minezbot.cubecraft.Util.Scoreboard.Board;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent e) {

		if (!Ranks.hasRank(e.getPlayer())) {
			Ranks.setRank(e.getPlayer().getName(), Rank.PLAYER);
		}

		Msg.setChan(e.getPlayer(), Chan.INFO, true);
		Msg.setChan(e.getPlayer(), Chan.ALERT, true);
		Msg.setChan(e.getPlayer(), Chan.BROADCAST, true);
		Msg.setChan(e.getPlayer(), Chan.CHAT, true);
		Msg.setChan(e.getPlayer(), Chan.ERROR, true);
		Msg.setChan(e.getPlayer(), Chan.WARN, true);
		if (Ranks.isStaff(e.getPlayer())) {
			Msg.setChan(e.getPlayer(), Chan.STAFF, true);
		}
		if (Ranks.getRank(e.getPlayer()) == Rank.OWNER) {
			e.getPlayer().setDisplayName(ChatColor.DARK_RED + e.getPlayer().getName());
			e.getPlayer().setPlayerListName(ChatColor.DARK_RED + e.getPlayer().getName());
		}
		if (Ranks.getRank(e.getPlayer()) == Rank.ADMIN) {
			e.getPlayer().setDisplayName(ChatColor.DARK_PURPLE + e.getPlayer().getName());
			e.getPlayer().setPlayerListName(ChatColor.DARK_PURPLE + e.getPlayer().getName());
		}
		if (Ranks.getRank(e.getPlayer()) == Rank.DEVELOPER) {
			e.getPlayer().setDisplayName(ChatColor.DARK_GREEN + e.getPlayer().getName());
			e.getPlayer().setPlayerListName(ChatColor.DARK_GREEN + e.getPlayer().getName());
		}
		if (Ranks.getRank(e.getPlayer()) == Rank.STAFF) {
			e.getPlayer().setDisplayName(ChatColor.BLUE + e.getPlayer().getName());
			e.getPlayer().setPlayerListName(ChatColor.BLUE + e.getPlayer().getName());
		}
		if (Ranks.getRank(e.getPlayer()) == Rank.VIP) {
			e.getPlayer().setDisplayName(ChatColor.GOLD + e.getPlayer().getName());
			e.getPlayer().setPlayerListName(ChatColor.GOLD + e.getPlayer().getName());
		}
		if (Ranks.getRank(e.getPlayer()) == Rank.DONATOR) {
			e.getPlayer().setDisplayName(ChatColor.YELLOW + e.getPlayer().getName());
			e.getPlayer().setPlayerListName(ChatColor.YELLOW + e.getPlayer().getName());
		}
		if (Ranks.getRank(e.getPlayer()) == Rank.PLAYER) {
			e.getPlayer().setDisplayName(ChatColor.GRAY + e.getPlayer().getName());
			e.getPlayer().setPlayerListName(ChatColor.GRAY + e.getPlayer().getName());
		}

		if (!Move.user.contains(e.getPlayer().getName())) {
			Move.user.add(e.getPlayer().getName());
		}

		e.getPlayer().setLevel(Health.getMaxHealth(e.getPlayer()));
		Board.updateScoreboard(e.getPlayer());

		Bukkit.getScheduler().scheduleSyncRepeatingTask(Util.getPlugin(), new Runnable() {
			public void run() {
				if (Move.user.contains(e.getPlayer().getName())) {
					if (e.getPlayer().getExp() < 1F) {
						e.getPlayer().setExp(e.getPlayer().getExp() + 0.006F);
					}
				}
			}
		}, 40, 2);
	}

}
