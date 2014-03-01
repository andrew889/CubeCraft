package net.minezbot.cubecraft.Util.Teams;

import java.util.ArrayList;

import net.minezbot.cubecraft.Util.Msg;
import net.minezbot.cubecraft.Util.Msg.Chan;
import net.minezbot.cubecraft.Util.Util;
import net.minezbot.cubecraft.Util.Errors.Error;
import net.minezbot.cubecraft.Util.Errors.ErrorCode;
import net.minezbot.cubecraft.Util.Player.Health.Food.FoodItem;
import net.minezbot.cubecraft.Util.Player.Health.Food.FoodItems;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Team {

	private static ArrayList<String> warrior = new ArrayList<String>();
	private static ArrayList<String> ranger = new ArrayList<String>();
	private static ArrayList<String> mage = new ArrayList<String>();
	private static ArrayList<String> rogue = new ArrayList<String>();

	public enum ClassName {
		WARRIOR, RANGER, MAGE, ROGUE, UNKNOWN;
	}

	public static void setClass(Player p, ClassName c) {
		if (warrior.contains(p.getName())) {
			warrior.remove(p.getName());
		}
		if (ranger.contains(p.getName())) {
			ranger.remove(p.getName());
		}
		if (mage.contains(p.getName())) {
			mage.remove(p.getName());
		}
		if (rogue.contains(p.getName())) {
			rogue.remove(p.getName());
		}
		if (c == ClassName.WARRIOR) {
			warrior.add(p.getName());
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".class", "Warrior");
			Util.getPlugin().saveConfig();
			Team.setClassItems(p, ClassName.WARRIOR);
			Msg.messagePlayer(Chan.INFO, p, "You are now a &5Warrior&7 class!");
		} else if (c == ClassName.RANGER) {
			ranger.add(p.getName());
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".class", "Ranger");
			Util.getPlugin().saveConfig();
			Team.setClassItems(p, ClassName.RANGER);
			Msg.messagePlayer(Chan.INFO, p, "You are now a &5Ranger&7 class!");
		} else if (c == ClassName.MAGE) {
			mage.add(p.getName());
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".class", "Mage");
			Util.getPlugin().saveConfig();
			Team.setClassItems(p, ClassName.MAGE);
			Msg.messagePlayer(Chan.INFO, p, "You are now a &5Mage&7 class!");
		} else if (c == ClassName.ROGUE) {
			rogue.add(p.getName());
			Util.getPlugin().getConfig().set("PlayerData." + p.getName() + ".class", "Rogue");
			Util.getPlugin().saveConfig();
			Team.setClassItems(p, ClassName.ROGUE);
			Msg.messagePlayer(Chan.INFO, p, "You are now a &5Rogue&7 class!");
		} else {
			Error.sendError(p, ErrorCode.CLASS_NOT_FOUND);
		}
	}

	public static void setClassItems(Player p, ClassName c) {
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		if (c == ClassName.WARRIOR) {
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GRAY + "Damage: 4");
			lore.add("");
			lore.add(ChatColor.GRAY + "The Club is the default");
			lore.add(ChatColor.GRAY + "weapon for the warrior");
			lore.add(ChatColor.GRAY + "class.");
			ItemStack item = new ItemStack(Material.WOOD_SWORD);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(ChatColor.WHITE + "Club");
			meta.setLore(lore);
			item.setItemMeta(meta);
			Team.fillHotBar(p, item, new ItemStack(Material.WOOD_HOE), FoodItems.getFoodItem(FoodItem.COOKED_FISH), FoodItems.getFoodItem(FoodItem.COOKIE));
		} else if (c == ClassName.MAGE) {
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GRAY + "Damage: 4");
			lore.add("");
			lore.add(ChatColor.GRAY + "The Fire Wand is the default");
			lore.add(ChatColor.GRAY + "weapon for the mage class.");
			ItemStack item = new ItemStack(Material.BLAZE_ROD);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(ChatColor.WHITE + "Fire Wand");
			meta.setLore(lore);
			item.setItemMeta(meta);
			Team.fillHotBar(p, item, new ItemStack(Material.WOOD_HOE), FoodItems.getFoodItem(FoodItem.COOKED_FISH), FoodItems.getFoodItem(FoodItem.COOKIE));
		} else if (c == ClassName.RANGER) {
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GRAY + "Damage: 4");
			lore.add("");
			lore.add(ChatColor.GRAY + "The wooden bow is the default");
			lore.add(ChatColor.GRAY + "bow for the ranger class.");
			ItemStack item = new ItemStack(Material.BOW);
			ItemMeta meta = item.getItemMeta();
			meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
			meta.setDisplayName(ChatColor.WHITE + "Wooden Bow");
			meta.setLore(lore);
			item.setItemMeta(meta);
			Team.fillHotBar(p, item, new ItemStack(Material.WOOD_HOE), FoodItems.getFoodItem(FoodItem.COOKED_FISH), FoodItems.getFoodItem(FoodItem.COOKIE));
			p.getInventory().addItem(new ItemStack(Material.ARROW));
		} else if (c == ClassName.ROGUE) {
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GRAY + "Damage: 4");
			lore.add("");
			lore.add(ChatColor.GRAY + "The knife is the default");
			lore.add(ChatColor.GRAY + "weapon for the rogue");
			lore.add(ChatColor.GRAY + "class.");
			ItemStack item = new ItemStack(Material.IRON_SWORD);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(ChatColor.WHITE + "Knife");
			meta.setLore(lore);
			item.setItemMeta(meta);
			Team.fillHotBar(p, item, new ItemStack(Material.WOOD_HOE), FoodItems.getFoodItem(FoodItem.COOKED_FISH), FoodItems.getFoodItem(FoodItem.COOKIE));
		} else {
			Error.sendError(p, ErrorCode.CLASS_ITEMS_NOT_FOUND);
		}
	}

	@SuppressWarnings("deprecation")
	public static void fillHotBar(Player p, ItemStack main, ItemStack seconds, ItemStack food1, ItemStack food2) {
		ItemStack sign = new ItemStack(Material.BED_BLOCK);
		ItemMeta meta = sign.getItemMeta();
		meta.setDisplayName(null);
		sign.setItemMeta(meta);
		p.getInventory().setItem(0, sign);
		p.getInventory().setItem(1, main);
		p.getInventory().setItem(2, seconds);
		p.getInventory().setItem(3, sign);
		p.getInventory().setItem(4, sign);
		p.getInventory().setItem(5, sign);
		p.getInventory().setItem(6, food1);
		p.getInventory().setItem(7, food2);
		p.getInventory().setItem(8, sign);
		p.updateInventory();
	}

}
