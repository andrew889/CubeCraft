package net.minezbot.cubecraft.Events;

import net.minezbot.cubecraft.Util.Msg;
import net.minezbot.cubecraft.Util.Msg.Chan;
import net.minezbot.cubecraft.Util.Player.CCPlayer;
import net.minezbot.cubecraft.Util.Teams.Team;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		e.setCancelled(true);
		if (CCPlayer.isChannelOpen(e.getPlayer(), Chan.CHAT)) {
			String className = "";
			if (CCPlayer.getClass(e.getPlayer()) == Team.ClassName.WARRIOR) {
				className = "Warrior";
			}
			if (CCPlayer.getClass(e.getPlayer()) == Team.ClassName.MAGE) {
				className = "Mage";
			}
			if (CCPlayer.getClass(e.getPlayer()) == Team.ClassName.RANGER) {
				className = "Ranger";
			}
			if (CCPlayer.getClass(e.getPlayer()) == Team.ClassName.ROGUE) {
				className = "Rogue";
			}
			String chat = "&8[&6{className}&8] &7{display}&7: {msg}";
			Msg.messageChannal(Chan.CHAT, ChatColor.translateAlternateColorCodes('&', chat).replace("{className}", className).replace("{display}", e.getPlayer().getDisplayName()).replace("{msg}", e.getMessage()));
		}
	}

}
