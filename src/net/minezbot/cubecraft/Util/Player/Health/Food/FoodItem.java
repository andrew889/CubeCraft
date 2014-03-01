package net.minezbot.cubecraft.Util.Player.Health.Food;

import org.bukkit.Material;

public enum FoodItem {
	
	BREAD ("Bread", 10, Material.BREAD),
	APPLE ("Apple", 8, Material.APPLE),
	GOLDEN_APPLE ("Golden Apple", 35, Material.GOLDEN_APPLE),
	POTATO ("Potato", 5, Material.POTATO),
	BAKED_POTATO("Baked Potato", 12, Material.BAKED_POTATO),
	CARROT("Carrot", 14, Material.CARROT),
	PORK("Pork", 6, Material.PORK),
	COOKIE("Cookie", 4, Material.COOKIE),
	COOKED_BEEF("Cooked Pork", 16, Material.COOKED_BEEF),
	COOKED_FISH("Cooked Fish", 4, Material.COOKED_FISH);
	
	
	String display;
	int health;
	Material item;
	
	private FoodItem(String display, int health, Material item) {
		this.display = display;
		this.health = health;
		this.item = item;
	}
	
	public String getDisplayName() {
		return display;
	}
	
	public int getHealth() {
		return health;
	}
	
	public Material getItem() {
		return item;
	}
	
	public static FoodItem getItemByMaterial(Material material) {
		if(material == Material.BREAD) {
			return FoodItem.BREAD;
		} else if (material == Material.APPLE) {
			return FoodItem.APPLE;
		} else if(material == Material.GOLDEN_APPLE) {
			return FoodItem.GOLDEN_APPLE;
		} else if (material == Material.POTATO) {
			return FoodItem.POTATO;
		} else if(material == Material.BAKED_POTATO) {
			return FoodItem.BAKED_POTATO;
		} else if(material == Material.CARROT) {
			return FoodItem.CARROT;
		} else if(material == Material.PORK) {
			return FoodItem.PORK;
		} else if(material == Material.COOKIE) {
			return FoodItem.COOKIE;
		} else if(material == Material.COOKED_BEEF) {
			return FoodItem.COOKED_BEEF;
		} else if(material == Material.COOKED_FISH) {
			return FoodItem.COOKED_FISH;
		} else {
			return null;
		}
	}
	
}
