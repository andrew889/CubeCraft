package net.minezbot.cubecraft.Util.Player.Health.Food;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FoodItems {

	public static ItemStack getFoodItem(FoodItem item) {
		ItemStack stack = new ItemStack(item.getItem());
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(item.getDisplayName());
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "+" + item.getHealth() + " Health");
		meta.setLore(lore);
		return stack;
	}
}
