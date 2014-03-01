package net.minezbot.cubecraft.Util.Player.Health;

import net.minezbot.cubecraft.Util.Util;
import net.minezbot.cubecraft.Util.Player.CCPlayer;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Health {

	public static void setMaxHealth(Player p, int max) {
		if (CCPlayer.dosePlayerDataExist(p)) {
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".maxhealth", max);
			Util.getPlugin().saveConfig();
		} else {
			CCPlayer.createPlayerData(p);
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".maxhealth", max);
			Util.getPlugin().saveConfig();
		}
	}

	public static int getMaxHealth(Player p) {
		if (CCPlayer.dosePlayerDataExist(p)) {
			return Util.getPlugin().getConfig().getInt("PlayerData." + p.getName() + ".maxhealth");
		} else {
			CCPlayer.createPlayerData(p);
			return Util.getPlugin().getConfig().getInt("PlayerData." + p.getName() + ".maxhealth");
		}
	}

	public static int getCurrentHealth(Player p) {
		return p.getLevel();
	}

	public static void setCurrentHealth(Player p, int health) {
		p.setLevel(health);
	}

	public static void addHealth(final Player p, int healthToAdd) {
		final int task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Util.getPlugin(), new Runnable() {
			public void run() {
				if (getCurrentHealth(p) < getMaxHealth(p)) {
					Health.setCurrentHealth(p, Health.getCurrentHealth(p) + 1);
					p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 1, 3);
				}
			}
		}, 0, 3);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Util.getPlugin(), new Runnable() {
			public void run() {
				Bukkit.getScheduler().cancelTask(task);
			}
		}, 3 * healthToAdd);
	}

}
