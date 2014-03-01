package net.minezbot.cubecraft.Events;

import net.minezbot.cubecraft.Util.Util;
import net.minezbot.cubecraft.Util.Player.Health.Health;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class Respawn implements Listener {

	@EventHandler
	public void onRespawn(final PlayerRespawnEvent e) {
		if (!Move.user.contains(e.getPlayer().getName())) {
			Move.user.add(e.getPlayer().getName());
		}
		e.getPlayer().setExp(0F);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Util.getPlugin(), new Runnable() {
			public void run() {
				e.getPlayer().setLevel(Health.getMaxHealth(e.getPlayer()));
			}
		}, 2);
	}

}
