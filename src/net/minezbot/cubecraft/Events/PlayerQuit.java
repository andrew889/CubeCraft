package net.minezbot.cubecraft.Events;

import net.minezbot.cubecraft.Util.Msg;
import net.minezbot.cubecraft.Util.Scoreboard.Board;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Board.removeObjective(e.getPlayer());
		Msg.setChan(e.getPlayer(), Msg.Chan.ALERT, false);
		Msg.setChan(e.getPlayer(), Msg.Chan.BROADCAST, false);
		Msg.setChan(e.getPlayer(), Msg.Chan.CHAT, false);
		Msg.setChan(e.getPlayer(), Msg.Chan.ERROR, false);
		Msg.setChan(e.getPlayer(), Msg.Chan.INFO, false);
		Msg.setChan(e.getPlayer(), Msg.Chan.WARN, false);
	}

}
