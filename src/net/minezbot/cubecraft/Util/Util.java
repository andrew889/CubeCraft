package net.minezbot.cubecraft.Util;

import net.minezbot.cubecraft.CubeCraft;

public class Util {

	private static CubeCraft cc;

	public static void setPlugin(CubeCraft plugin) {
		cc = plugin;
	}

	public static CubeCraft getPlugin() {
		return cc;
	}

}
