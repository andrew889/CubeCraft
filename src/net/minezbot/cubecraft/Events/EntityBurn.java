package net.minezbot.cubecraft.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;

public class EntityBurn implements Listener {
	
	@EventHandler
	public void onBurn(EntityCombustEvent e) {
		e.setCancelled(true);
	}
	
}
