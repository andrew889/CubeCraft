package net.minezbot.cubecraft.Commands;

import net.minezbot.cubecraft.Util.Msg;
import net.minezbot.cubecraft.Util.Msg.Chan;
import net.minezbot.cubecraft.Util.Packs.Packs;
import net.minezbot.cubecraft.Util.Packs.Packs.MobMode;
import net.minezbot.cubecraft.Util.Player.CCPlayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnPack implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This is a player command only!");
			return false;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("spawnpack")) {
			if (CCPlayer.isAdmin(p)) {
				if (args.length == 3) {
					if (isInt(args[2])) {
						MobMode mode = MobMode.PASSIVE;
						if (args[1].equalsIgnoreCase("passive")) {
							mode = MobMode.PASSIVE;
						} else if (args[1].equalsIgnoreCase("hit")) {
							mode = MobMode.ON_HIT;
						} else if (args[1].equalsIgnoreCase("attack")) {
							mode = MobMode.ANGER;
						} else if (args[1].equalsIgnoreCase("boss")) {
							mode = MobMode.BOSS;
						} else {
							Msg.messagePlayer(Msg.Chan.INFO, p, "/spawnpack <wolf/silverfish/skeleton/slime/spider/zombie> <passive, hit, attack> <size>");
							return false;
						}
						if (args[0].equalsIgnoreCase("wolf")) {
							Packs.spawnPack(Packs.Pack.WOLF, p.getTargetBlock(null, 50).getLocation().add(0, 1, 0), mode, getInt(args[2]));
							Msg.messageChannal(Msg.Chan.STAFF, p.getDisplayName() + " &7spawned a &3" + args[0].toUpperCase() + "&7 pack! (" + mode.toString() + ")" + " (" + getInt(args[2]) + ")");
							return false;
						}
						if (args[0].equalsIgnoreCase("snowman")) {
							Packs.spawnPack(Packs.Pack.SNOWMAN, p.getTargetBlock(null, 50).getLocation().add(0, 1, 0), mode, getInt(args[2]));
							Msg.messageChannal(Msg.Chan.STAFF, p.getDisplayName() + " &7spawned a &3" + args[0].toUpperCase() + "&7 pack! (" + mode.toString() + ")" + " (" + getInt(args[2]) + ")");
							return false;
						}
						if (args[0].equalsIgnoreCase("skeleton")) {
							Packs.spawnPack(Packs.Pack.SKELLY, p.getTargetBlock(null, 50).getLocation().add(0, 1, 0), mode, getInt(args[2]));
							Msg.messageChannal(Msg.Chan.STAFF, p.getDisplayName() + " &7spawned a &3" + args[0].toUpperCase() + "&7 pack! (" + mode.toString() + ")" + " (" + getInt(args[2]) + ")");
							return false;
						}
						if (args[0].equalsIgnoreCase("slime")) {
							Packs.spawnPack(Packs.Pack.SLIME, p.getTargetBlock(null, 50).getLocation().add(0, 1, 0), mode, getInt(args[2]));
							Msg.messageChannal(Msg.Chan.STAFF, p.getDisplayName() + " &7spawned a &3" + args[0].toUpperCase() + "&7 pack! (" + mode.toString() + ")" + " (" + getInt(args[2]) + ")");
							return false;
						}
						if (args[0].equalsIgnoreCase("irongolem")) {
							Packs.spawnPack(Packs.Pack.IRONGOLEM, p.getTargetBlock(null, 50).getLocation().add(0, 1, 0), mode, getInt(args[2]));
							Msg.messageChannal(Msg.Chan.STAFF, p.getDisplayName() + " &7spawned a &3" + args[0].toUpperCase() + "&7 pack! (" + mode.toString() + ")" + " (" + getInt(args[2]) + ")");
							return false;
						}
						if (args[0].equalsIgnoreCase("zombie")) {
							Packs.spawnPack(Packs.Pack.ZOMBIE, p.getTargetBlock(null, 50).getLocation().add(0, 1, 0), mode, getInt(args[2]));
							Msg.messageChannal(Msg.Chan.STAFF, p.getDisplayName() + " &7spawned a &3" + args[0].toUpperCase() + "&7 pack! (" + mode.toString() + ")" + " (" + getInt(args[2]) + ")");
							return false;
						}
						p.sendMessage("Entity Size: " + p.getWorld().getEntities().size());
						if (args[0].equalsIgnoreCase("wither")) {
							Packs.spawnPack(Packs.Pack.BOSS_WITHER, p.getTargetBlock(null, 50).getLocation().add(0, 1, 0), mode, getInt(args[2]));
							Msg.messageChannal(Msg.Chan.STAFF, p.getDisplayName() + " &7spawned a &3" + args[0].toUpperCase() + "&7 pack! (" + mode.toString() + ")" + " (" + getInt(args[2]) + ")");
							return false;
						}
						if (args[0].equalsIgnoreCase("enderdragon")) {
							Packs.spawnPack(Packs.Pack.BOSS_ENDERDRAGON, p.getTargetBlock(null, 50).getLocation().add(0, 1, 0), mode, getInt(args[2]));
							Msg.messageChannal(Msg.Chan.STAFF, p.getDisplayName() + " &7spawned a &3" + args[0].toUpperCase() + "&7 pack! (" + mode.toString() + ")" + " (" + getInt(args[2]) + ")");
							return false;
						}
						Msg.messagePlayer(Msg.Chan.INFO, p, "/spawnpack <wolf/snowman/skeleton/slime/irongolem/zombie/&cwither&7/&cenderdragon&7> <passive/hit/attack/&cboss&7> <size>");
						return false;
					} else {
						Msg.messagePlayer(Msg.Chan.INFO, p, "/spawnpack <wolf/snowman/skeleton/slime/irongolem/zombie/&cwither&7/&cenderdragon&7> <passive/hit/attack/&cboss&7> <size>");
					}
				} else {
					Msg.messagePlayer(Msg.Chan.INFO, p, "/spawnpack <wolf/snowman/skeleton/slime/irongolem/zombie/&cwither&7/&cenderdragon&7> <passive/hit/attack/&cboss&7> <size>");
				}
			} else {
				Msg.messagePlayer(Chan.ERROR, p, "&cYou do not have permission to do that!");
			}
		}
		return false;
	}

	public static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public int getInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return 0;
		}
	}

}
