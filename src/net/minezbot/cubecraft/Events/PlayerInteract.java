package net.minezbot.cubecraft.Events;

import java.util.ArrayList;

import net.minezbot.cubecraft.Util.Msg;
import net.minezbot.cubecraft.Util.Msg.Chan;
import net.minezbot.cubecraft.Util.Player.CCPlayer;
import net.minezbot.cubecraft.Util.Player.Health.Health;
import net.minezbot.cubecraft.Util.Player.Health.Food.FoodItem;
import net.minezbot.cubecraft.Util.Player.Weapons.Weapons;
import net.minezbot.cubecraft.Util.Scoreboard.Board;
import net.minezbot.cubecraft.Util.Teams.Team;
import net.minezbot.cubecraft.Util.Teams.Team.ClassName;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerInteract implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.IRON_SWORD) {
			p.getItemInHand().setDurability((short) 0);
		}
		if (FoodItem.getItemByMaterial(p.getItemInHand().getType()) != null) {
			if (p.getLevel() < Health.getMaxHealth(p)) {
				Health.addHealth(p, FoodItem.getItemByMaterial(p.getItemInHand().getType()).getHealth());
				if (p.getItemInHand().getAmount() > 1) {
					p.getInventory().getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
				} else {
					p.setItemInHand(null);
					p.updateInventory();
				}
			}
		}
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock().getType() == Material.SIGN_POST || e.getClickedBlock().getType() == Material.WALL_SIGN) {
				Sign sign = (Sign) e.getClickedBlock().getState();
				if (sign.getLine(0).equalsIgnoreCase(ChatColor.GOLD + "[Class]")) {
					if (sign.getLine(2).equalsIgnoreCase(ChatColor.BLACK + "Warrior")) {
						Team.setClass(p, ClassName.WARRIOR);
					} else if (sign.getLine(2).equalsIgnoreCase(ChatColor.BLACK + "Ranger")) {
						Team.setClass(p, ClassName.RANGER);
					} else if (sign.getLine(2).equalsIgnoreCase(ChatColor.BLACK + "Mage")) {
						Team.setClass(p, ClassName.MAGE);
					} else if (sign.getLine(2).equalsIgnoreCase(ChatColor.BLACK + "Rogue")) {
						Team.setClass(p, ClassName.ROGUE);
					} else {
						Team.setClass(p, ClassName.WARRIOR);
					}
				} else if (sign.getLine(0).equalsIgnoreCase(ChatColor.GOLD + "[Upgrade]")) {
					if (sign.getLine(2).equalsIgnoreCase(ChatColor.BLACK + "Damage")) {
						if (CCPlayer.getGold(p) >= 200) {
							if (Weapons.isWeapon(p.getItemInHand().getType())) {
								ItemMeta meta = p.getItemInHand().getItemMeta();
								ArrayList<String> newLore = new ArrayList<String>();
								for (String s : meta.getLore()) {
									newLore.add(s);
									if (s.startsWith(ChatColor.GRAY + "Damage:")) {
										int currentDamage = Integer.parseInt(s.substring(s.lastIndexOf(": ") + 2));
										newLore.remove(s);
										int newDamage = currentDamage + 1;
										newLore.add(ChatColor.GRAY + "Damage: " + newDamage);
									}
								}
								meta.setLore(newLore);
								meta.setDisplayName(p.getItemInHand().getItemMeta().getDisplayName());
								p.getItemInHand().setItemMeta(meta);
								CCPlayer.setGold(p, CCPlayer.getGold(p) - 200);
								Board.updateScoreboard(p);
								Msg.messagePlayer(Chan.ALERT, p, "&6-200 Gold! (Damage Upgrade)");
							} else {
								Msg.messagePlayer(Chan.INFO, p, "You need to hold your weapon when doing this!");
							}
						} else {
							Msg.messagePlayer(Chan.INFO, p, "You do not have enough gold for that!");
						}
					}
				} else if (sign.getLine(0).equalsIgnoreCase("[Enchant]")) {
					if (sign.getLine(2).equalsIgnoreCase("Flame")) {
						if (Weapons.isWeapon(p.getItemInHand().getType())) {

						} else {
							Msg.messagePlayer(Chan.INFO, p, "You need to hold your weapon when doing this!");
						}
					}
				}
			}
		}
	}
}
