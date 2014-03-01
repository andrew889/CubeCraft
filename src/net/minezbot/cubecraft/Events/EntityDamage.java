package net.minezbot.cubecraft.Events;

import net.minezbot.cubecraft.Util.Packs.Packs;
import net.minezbot.cubecraft.Util.Packs.Packs.MobMode;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {

	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			if (Packs.getMode(e.getEntity().getUniqueId()) == MobMode.DESPAWN) {
				e.getEntity().remove();
			}
			if (Packs.getMode(e.getEntity().getUniqueId()) == MobMode.ON_HIT) {
				Packs.mode.remove(e.getEntity().getUniqueId());
				Packs.addMobToMode(e.getEntity().getUniqueId(), 2);
			}
			e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.STEP_SOUND, 55, 16);
			Packs.updateTag(e.getEntity());
		}
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			p.setLevel(p.getLevel() - (int) e.getDamage());
			e.setDamage(0.0);
			if (p.getLevel() <= 0) {
				p.setHealth(0.0);
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (p.getItemInHand().getType() == Material.IRON_SWORD || p.getItemInHand().getType() == Material.STONE_SWORD || p.getItemInHand().getType() == Material.WOOD_SWORD || p.getItemInHand().getType() == Material.DIAMOND_SWORD || p.getItemInHand().getType() == Material.BOW) {
				for (String s : p.getItemInHand().getItemMeta().getLore()) {
					if (s.startsWith(ChatColor.GRAY + "Damage: ")) {
						e.setDamage(Integer.parseInt(s.substring(s.lastIndexOf(": ") + 2)));
					}
					if (s.startsWith(ChatColor.GRAY + "Enchant: ")) {
						if (s.substring(s.lastIndexOf(": ") + 2).equalsIgnoreCase("Flame")) {
							e.getEntity().setFireTicks(40);
						}
					}
				}
			}
			for (Entity near : e.getEntity().getNearbyEntities(30.0, 30.0, 30.0)) {
				if (near.getType() == e.getEntity().getType()) {
					if (Packs.getMode(near.getUniqueId()) == MobMode.ON_HIT) {
						Packs.mode.remove(near.getUniqueId());
						Packs.addMobToMode(near.getUniqueId(), 2);
					}
				}
			}
		}
	}

}
