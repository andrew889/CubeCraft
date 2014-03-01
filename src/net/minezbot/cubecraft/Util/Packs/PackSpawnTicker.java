package net.minezbot.cubecraft.Util.Packs;

import java.util.Random;

import net.minezbot.cubecraft.Util.Util;
import net.minezbot.cubecraft.Util.Packs.Packs.MobMode;
import net.minezbot.cubecraft.Util.Packs.Packs.Pack;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class PackSpawnTicker {

	private static boolean canSpawn = true;
	private static int task = 0;

	public static void startSpawnTicker() {
		if (canSpawn) {
			canSpawn = false;
			task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Util.getPlugin(), new Runnable() {
				public void run() {
					Random rand = new Random();
					int x = rand.nextInt(1000) + -500;
					int z = rand.nextInt(1000) + -500;
					int type = rand.nextInt(3) + 1;
					int mob = rand.nextInt(6) + 1;
					int size = rand.nextInt(7) + 3;
					Location loc = new Location(Bukkit.getWorld("CubeWorld"), x, 255, z);
					loc.setY(loc.getWorld().getHighestBlockYAt(loc) + 2);
					if (loc.getWorld().getChunkAt(loc).isLoaded() && Packs.mode.size() < (Bukkit.getOnlinePlayers().length * 200)) {
						Pack pack;
						if (mob == 1) {
							pack = Pack.ZOMBIE;
						} else if (mob == 2) {
							pack = Pack.WOLF;
						} else if (mob == 3) {
							pack = Pack.SNOWMAN;
						} else if (mob == 4) {
							pack = Pack.SKELLY;
						} else if (mob == 5) {
							pack = Pack.SLIME;
						} else {
							pack = Pack.IRONGOLEM;
						}
						MobMode mode;
						if (type == 1) {
							mode = MobMode.PASSIVE;
						} else if (type == 2) {
							mode = MobMode.ON_HIT;
						} else {
							mode = MobMode.ANGER;
						}
						Packs.spawnPack(pack, loc, mode, size);
					}
				}
			}, 20, 20);
		}
	}

	public static void stopSpawnTicker() {
		Bukkit.getScheduler().cancelTask(task);
		canSpawn = true;
	}

}
