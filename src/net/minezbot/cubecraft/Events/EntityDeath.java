package net.minezbot.cubecraft.Events;

import java.util.Random;

import net.minezbot.cubecraft.Util.Msg;
import net.minezbot.cubecraft.Util.Msg.Chan;
import net.minezbot.cubecraft.Util.Packs.Packs;
import net.minezbot.cubecraft.Util.Packs.Packs.MobMode;
import net.minezbot.cubecraft.Util.Player.CCPlayer;
import net.minezbot.cubecraft.Util.Player.Health.Health;
import net.minezbot.cubecraft.Util.Scoreboard.Board;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeath implements Listener {

	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		e.setDroppedExp(0);
		e.getDrops().clear();
		e.setDroppedExp(0);
		MobMode mode = Packs.getMode(e.getEntity().getUniqueId());
		if (Packs.mode.containsKey(e.getEntity().getUniqueId())) {
			Packs.mode.remove(e.getEntity().getUniqueId());
			if (e.getEntity().getKiller() != null) {
				Player p = e.getEntity().getKiller();
				Random random = new Random();
				int xp = 0;
				int gold = 0;
				if (mode == MobMode.PASSIVE) {
					xp = random.nextInt(2);
					gold = random.nextInt(4) + 1;
				} else if (mode == MobMode.ON_HIT || mode == MobMode.HIT) {
					xp = random.nextInt(6) + 2;
					gold = random.nextInt(6) + 3;
				} else if (mode == MobMode.ANGER) {
					xp = random.nextInt(12) + 4;
					gold = random.nextInt(18) + 6;
				} else if (mode == MobMode.BOSS) {
					xp = random.nextInt(120) + 20;
					gold = random.nextInt(300) + 60;
				} else {
					xp = 0;
					gold = 0;
				}
				CCPlayer.setXp(p, CCPlayer.getXp(p) + xp);
				CCPlayer.setGold(p, CCPlayer.getGold(p) + gold);
				Msg.messagePlayer(Chan.ALERT, p, "&9+" + xp + " XP!");
				Msg.messagePlayer(Chan.ALERT, p, "&6+" + gold + " Gold!");
				if (CCPlayer.getXp(p) > CCPlayer.getLevel(p) * 100) {
					CCPlayer.setXp(p, CCPlayer.getXp(p) - CCPlayer.getLevel(p) * 100);
					CCPlayer.setLevel(p, CCPlayer.getLevel(p) + 1);
					Msg.messagePlayer(Chan.ALERT, p, "&e&lLevel Up!");
					Health.setMaxHealth(p, Health.getMaxHealth(p) + 60);
					Msg.messagePlayer(Chan.ALERT, p, "&a+60 Max Health!");
				}
				Board.updateScoreboard(p);
			}
		}
	}
}
