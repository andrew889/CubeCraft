package net.minezbot.cubecraft.Events;

import net.minezbot.cubecraft.Util.Packs.Packs;
import net.minezbot.cubecraft.Util.Packs.Packs.MobMode;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

public class EntityTarget implements Listener {

	@EventHandler
	public void onTarget(EntityTargetLivingEntityEvent e) {
		if (e.getTarget() instanceof Player) {
			if (Packs.getMode(e.getEntity().getUniqueId()) == MobMode.PASSIVE || Packs.getMode(e.getEntity().getUniqueId()) == MobMode.ON_HIT) {
				e.setCancelled(true);
			}
			if (Packs.getMode(e.getEntity().getUniqueId()) == MobMode.ANGER || Packs.getMode(e.getEntity().getUniqueId()) == MobMode.HIT || Packs.getMode(e.getEntity().getUniqueId()) == MobMode.BOSS) {
				e.setCancelled(false);
			}
		} else {
			e.setCancelled(true);
		}
	}

}
