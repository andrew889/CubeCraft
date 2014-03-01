package net.minezbot.cubecraft.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class EntitySpawn implements Listener {
	
	@EventHandler
	public void onEntitySpawn(CreatureSpawnEvent e) {
		if(e.getSpawnReason() != SpawnReason.CUSTOM) {
			e.setCancelled(true);
		}
	}	
}
