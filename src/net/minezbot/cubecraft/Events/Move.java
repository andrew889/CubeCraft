package net.minezbot.cubecraft.Events;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Move implements Listener {

	public static ArrayList<String> user = new ArrayList<String>();
	public static ArrayList<String> glid = new ArrayList<String>();

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (p.getGameMode() != GameMode.CREATIVE) {
			if (p.getExp() > 0F) {
				if (p.isSneaking()) {
					if (isNextToBlock(p)) {
						if (!glid.contains(p.getName())) {
							p.setVelocity(p.getLocation().getDirection().multiply(0.2).setY(0.3));
							p.setExp(p.getExp() - 0.012F);
							p.setFallDistance(0F);
							if (user.contains(p.getName())) {
								user.remove(p.getName());
							}
						} else {
							glid.remove(p.getName());
							p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 10, true));
							p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, 124, 16);
							if (!user.contains(p.getName())) {
								user.add(p.getName());
							}
						}
					}
				} else {
					if (isNextToBlock(p)) {
						if (!glid.contains(p.getName())) {
							if (!user.contains(p.getName())) {
								user.add(p.getName());
							}
						} else {
							glid.remove(p.getName());
							p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 10, true));
							p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, 124, 16);
							if (!user.contains(p.getName())) {
								user.add(p.getName());
							}
						}
					}
				}
				if (p.getItemInHand().getType() == Material.PAPER && p.getLocation().subtract(0, 1, 0).getBlock().getType() == Material.AIR) {
					if (!glid.contains(p.getName())) {
						glid.add(p.getName());
					}
					p.setFallDistance(0);
					if (p.isSneaking()) {
						p.setVelocity(p.getLocation().getDirection().multiply(1.2).setY(-0.1));
						p.setExp(p.getExp() - 0.014F);
						if (user.contains(p.getName())) {
							user.remove(p.getName());
						}
					} else {
						p.setVelocity(p.getLocation().getDirection().multiply(0.8).setY(-0.3));
						if (user.contains(p.getName())) {
							user.remove(p.getName());
						}
					}
				}
			} else {
				if (glid.contains(p.getName())) {
					glid.remove(p.getName());
				}
				if (!isNextToBlock(p)) {
					if (!user.contains(p.getName())) {
						user.add(p.getName());
					}
				}
			}
		}
	}

	public boolean isNextToBlock(Player p) {
		if (p.getLocation().add(1, 0, 0).getBlock().getType() != Material.AIR && (!p.getLocation().add(1, 0, 0).getBlock().isLiquid())) {
			return true;
		} else if (p.getLocation().add(-1, 0, 0).getBlock().getType() != Material.AIR && (!p.getLocation().add(-1, 0, 0).getBlock().isLiquid())) {
			return true;
		} else if (p.getLocation().add(0, 0, -1).getBlock().getType() != Material.AIR && (!p.getLocation().add(0, 0, -1).getBlock().isLiquid())) {
			return true;
		} else if (p.getLocation().add(0, 0, 1).getBlock().getType() != Material.AIR && (!p.getLocation().add(0, 0, 1).getBlock().isLiquid())) {
			return true;
		} else {
			return false;
		}
	}
}
