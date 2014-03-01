package net.minezbot.cubecraft;

import net.minezbot.cubecraft.Commands.Broadcast;
import net.minezbot.cubecraft.Commands.Channel;
import net.minezbot.cubecraft.Commands.Debug;
import net.minezbot.cubecraft.Commands.SetRank;
import net.minezbot.cubecraft.Commands.SpawnPack;
import net.minezbot.cubecraft.Commands.Staff;
import net.minezbot.cubecraft.Events.Chat;
import net.minezbot.cubecraft.Events.EntityBurn;
import net.minezbot.cubecraft.Events.EntityDamage;
import net.minezbot.cubecraft.Events.EntityDeath;
import net.minezbot.cubecraft.Events.EntitySpawn;
import net.minezbot.cubecraft.Events.EntityTarget;
import net.minezbot.cubecraft.Events.Move;
import net.minezbot.cubecraft.Events.PlayerFoodChange;
import net.minezbot.cubecraft.Events.PlayerInteract;
import net.minezbot.cubecraft.Events.PlayerJoin;
import net.minezbot.cubecraft.Events.PlayerQuit;
import net.minezbot.cubecraft.Events.Respawn;
import net.minezbot.cubecraft.Events.SignBuild;
import net.minezbot.cubecraft.Util.Msg;
import net.minezbot.cubecraft.Util.Msg.Chan;
import net.minezbot.cubecraft.Util.Util;
import net.minezbot.cubecraft.Util.Packs.PackSpawnTicker;
import net.minezbot.cubecraft.Util.Scoreboard.Board;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CubeCraft extends JavaPlugin {

	public void onEnable() {
		Util.setPlugin(this);
		saveDefaultConfig();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new EntityDamage(), this);
		pm.registerEvents(new EntityTarget(), this);
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new PlayerQuit(), this);
		pm.registerEvents(new Chat(), this);
		pm.registerEvents(new Move(), this);
		pm.registerEvents(new Respawn(), this);
		pm.registerEvents(new SignBuild(), this);
		pm.registerEvents(new EntitySpawn(), this);
		pm.registerEvents(new EntityBurn(), this);
		pm.registerEvents(new PlayerInteract(), this);
		pm.registerEvents(new EntityDeath(), this);
		pm.registerEvents(new PlayerFoodChange(), this);
		getCommand("debug").setExecutor(new Debug());
		getCommand("channel").setExecutor(new Channel());
		getCommand("sc").setExecutor(new Staff());
		getCommand("staffchat").setExecutor(new Staff());
		getCommand("setrank").setExecutor(new SetRank());
		getCommand("spawnpack").setExecutor(new SpawnPack());
		getCommand("broadcast").setExecutor(new Broadcast());
		PackSpawnTicker.startSpawnTicker();
		Board.loadScoreboard();

		for (Player p : Bukkit.getOnlinePlayers()) {
			Msg.setChan(p, Chan.INFO, true);
			Msg.setChan(p, Chan.ALERT, true);
			Msg.setChan(p, Chan.BROADCAST, true);
			Msg.setChan(p, Chan.CHAT, true);
			Msg.setChan(p, Chan.ERROR, true);
			Msg.setChan(p, Chan.WARN, true);
		}
		for (World w : Bukkit.getWorlds()) {
			for (Entity e : w.getEntities()) {
				e.remove();
			}
		}
	}

}
