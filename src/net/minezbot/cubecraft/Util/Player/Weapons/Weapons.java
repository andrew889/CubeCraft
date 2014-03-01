package net.minezbot.cubecraft.Util.Player.Weapons;

import org.bukkit.Material;

public class Weapons {

	public static boolean isWeapon(Material item) {
		if (item.toString().contains("SWORD")) {
			return true;
		} else if (item.toString().contains("AXE")) {
			return true;
		} else if (item.toString().contains("BOW")) {
			return true;
		} else if (item == Material.BLAZE_ROD) {
			return true;
		} else {
			return false;
		}
	}

}
