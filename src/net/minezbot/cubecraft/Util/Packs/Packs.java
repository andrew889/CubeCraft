package net.minezbot.cubecraft.Util.Packs;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.UUID;

import net.minezbot.cubecraft.Util.Errors.Error;
import net.minezbot.cubecraft.Util.Errors.ErrorCode;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;

public class Packs {

	public enum Pack {
		WOLF, IRONGOLEM, SKELLY, SLIME, ZOMBIE, SNOWMAN, BOSS_WITHER, BOSS_ENDERDRAGON;
	}

	public enum MobMode {
		PASSIVE, ON_HIT, HIT, ANGER, BOSS, DESPAWN;
	}

	public static HashMap<UUID, Integer> mode = new HashMap<UUID, Integer>();

	public static void spawnPack(Pack pack, Location loc, MobMode mode, int size) {
		for (int i = 0; i < size; i++) {
			if (mode == MobMode.PASSIVE) {
				if (pack == Pack.WOLF) {
					Wolf w = (Wolf) loc.getWorld().spawnEntity(loc, EntityType.WOLF);
					w.setMaxHealth(10.0);
					w.setAdult();
					w.setHealth(10.0);
					w.setCustomName(ChatColor.GREEN + "Wolf [10]");
					w.setCustomNameVisible(false);
					w.setTamed(false);
					w.setAngry(false);
					addMobToMode(w.getUniqueId(), 0);
				}
				if (pack == Pack.IRONGOLEM) {
					IronGolem s = (IronGolem) loc.getWorld().spawnEntity(loc, EntityType.IRON_GOLEM);
					s.setMaxHealth(10.0);
					s.setHealth(10.0);
					s.setCustomName(ChatColor.GREEN + "IronGolem [10]");
					s.setCustomNameVisible(false);
					addMobToMode(s.getUniqueId(), 0);
				}
				if (pack == Pack.SKELLY) {
					Skeleton s = (Skeleton) loc.getWorld().spawnEntity(loc, EntityType.SKELETON);
					s.setMaxHealth(10.0);
					s.setHealth(10.0);
					s.setCustomName(ChatColor.GREEN + "Skeleton [10]");
					s.setCustomNameVisible(false);
					addMobToMode(s.getUniqueId(), 0);
				}
				if (pack == Pack.SLIME) {
					Slime s = (Slime) loc.getWorld().spawnEntity(loc, EntityType.SLIME);
					s.setMaxHealth(10.0);
					s.setHealth(10.0);
					s.setCustomName(ChatColor.GREEN + "Slime [10]");
					s.setCustomNameVisible(false);
					s.setSize(2);
					addMobToMode(s.getUniqueId(), 0);
				}
				if (pack == Pack.ZOMBIE) {
					Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
					z.setMaxHealth(10.0);
					z.setHealth(10.0);
					z.setCustomName(ChatColor.GREEN + "Zombie [10]");
					z.setCustomNameVisible(false);
					z.setBaby(false);
					addMobToMode(z.getUniqueId(), 0);
				}
				if (pack == Pack.SNOWMAN) {
					Snowman s = (Snowman) loc.getWorld().spawnEntity(loc, EntityType.SNOWMAN);
					s.setMaxHealth(10.0);
					s.setHealth(10.0);
					s.setCustomName(ChatColor.GREEN + "Snowman [10]");
					s.setCustomNameVisible(false);
					addMobToMode(s.getUniqueId(), 0);
				}
			}
			if (mode == MobMode.ON_HIT || mode == MobMode.HIT) {
				if (pack == Pack.WOLF) {
					Wolf w = (Wolf) loc.getWorld().spawnEntity(loc, EntityType.WOLF);
					w.setMaxHealth(30.0);
					w.setAdult();
					w.setHealth(30.0);
					w.setCustomName(ChatColor.BLUE + "Wolf [30]");
					w.setCustomNameVisible(false);
					w.setTamed(false);
					w.setAngry(false);
					addMobToMode(w.getUniqueId(), 1);
				}
				if (pack == Pack.IRONGOLEM) {
					IronGolem s = (IronGolem) loc.getWorld().spawnEntity(loc, EntityType.IRON_GOLEM);
					s.setMaxHealth(30.0);
					s.setHealth(30.0);
					s.setCustomName(ChatColor.BLUE + "IronGolem [30]");
					s.setCustomNameVisible(false);
					addMobToMode(s.getUniqueId(), 1);
				}
				if (pack == Pack.SKELLY) {
					Skeleton s = (Skeleton) loc.getWorld().spawnEntity(loc, EntityType.SKELETON);
					s.setMaxHealth(30.0);
					s.setHealth(30.0);
					s.setCustomName(ChatColor.BLUE + "Skeleton [30]");
					s.setCustomNameVisible(false);
					addMobToMode(s.getUniqueId(), 1);
				}
				if (pack == Pack.SLIME) {
					Slime s = (Slime) loc.getWorld().spawnEntity(loc, EntityType.SLIME);
					s.setMaxHealth(30.0);
					s.setHealth(30.0);
					s.setCustomName(ChatColor.BLUE + "Slime [30]");
					s.setCustomNameVisible(false);
					s.setSize(2);
					addMobToMode(s.getUniqueId(), 1);
				}
				if (pack == Pack.ZOMBIE) {
					Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
					z.setMaxHealth(30.0);
					z.setHealth(30.0);
					z.setCustomName(ChatColor.BLUE + "Zombie [30]");
					z.setCustomNameVisible(false);
					z.setBaby(false);
					addMobToMode(z.getUniqueId(), 1);
				}
				if (pack == Pack.SNOWMAN) {
					Snowman s = (Snowman) loc.getWorld().spawnEntity(loc, EntityType.SNOWMAN);
					s.setMaxHealth(30.0);
					s.setHealth(30.0);
					s.setCustomName(ChatColor.BLUE + "Snowman [30]");
					s.setCustomNameVisible(false);
					addMobToMode(s.getUniqueId(), 1);
				}
			}
			if (mode == MobMode.ANGER) {
				if (pack == Pack.WOLF) {
					Wolf w = (Wolf) loc.getWorld().spawnEntity(loc, EntityType.WOLF);
					w.setAdult();
					w.setMaxHealth(60.0);
					w.setHealth(60.0);
					w.setCustomName(ChatColor.RED + "Wolf [60]");
					w.setCustomNameVisible(false);
					w.setTamed(false);
					w.setAngry(false);
					addMobToMode(w.getUniqueId(), 3);
				}
				if (pack == Pack.IRONGOLEM) {
					IronGolem s = (IronGolem) loc.getWorld().spawnEntity(loc, EntityType.IRON_GOLEM);
					s.setMaxHealth(60.0);
					s.setHealth(60.0);
					s.setCustomName(ChatColor.RED + "IronGolem [60]");
					s.setCustomNameVisible(false);
					addMobToMode(s.getUniqueId(), 3);
				}
				if (pack == Pack.SKELLY) {
					Skeleton s = (Skeleton) loc.getWorld().spawnEntity(loc, EntityType.SKELETON);
					s.setMaxHealth(60.0);
					s.setHealth(60.0);
					s.setCustomName(ChatColor.RED + "Skeleton [60]");
					s.setCustomNameVisible(false);
					addMobToMode(s.getUniqueId(), 3);
				}
				if (pack == Pack.SLIME) {
					Slime s = (Slime) loc.getWorld().spawnEntity(loc, EntityType.SLIME);
					s.setMaxHealth(60.0);
					s.setHealth(60.0);
					s.setCustomName(ChatColor.RED + "Slime [60]");
					s.setCustomNameVisible(false);
					s.setSize(2);
					addMobToMode(s.getUniqueId(), 3);
				}
				if (pack == Pack.ZOMBIE) {
					Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
					z.setMaxHealth(60.0);
					z.setHealth(60.0);
					z.setCustomName(ChatColor.RED + "Zombie [60]");
					z.setCustomNameVisible(false);
					z.setBaby(false);
					addMobToMode(z.getUniqueId(), 3);
				}
				if (pack == Pack.SNOWMAN) {
					Snowman s = (Snowman) loc.getWorld().spawnEntity(loc, EntityType.SNOWMAN);
					s.setMaxHealth(60.0);
					s.setHealth(60.0);
					s.setCustomName(ChatColor.RED + "Snowman [60]");
					s.setCustomNameVisible(false);
					addMobToMode(s.getUniqueId(), 3);
				}
			}
			if(mode == MobMode.BOSS) {
				if(pack == Pack.BOSS_ENDERDRAGON) {
					EnderDragon d = (EnderDragon) loc.getWorld().spawnEntity(loc, EntityType.ENDER_DRAGON);
					d.setMaxHealth(400.0);
					d.setHealth(400.0);
					d.setCustomName(ChatColor.DARK_PURPLE + "EnderDragon [400]");
					d.setCustomNameVisible(true);
					addMobToMode(d.getUniqueId(), 4);
				} else if(pack == Pack.BOSS_WITHER) {
					Wither w = (Wither) loc.getWorld().spawnEntity(loc, EntityType.WITHER);
					w.setMaxHealth(400.0);
					w.setHealth(400.0);
					w.setCustomName(ChatColor.DARK_PURPLE + "Wither [400]");
					w.setCustomNameVisible(true);
					addMobToMode(w.getUniqueId(), 4);
				} else {
					Packs.spawnPack(pack, loc, MobMode.ANGER, size);
				}
			}
		}
	}

	public static void addMobToMode(UUID id, Integer n) {
		mode.put(id, n);
	}

	public static MobMode getMode(UUID id) {
		if (mode.containsKey(id)) {
			if (mode.get(id) == 0) {
				return MobMode.PASSIVE;
			}
			if (mode.get(id) == 1) {
				return MobMode.ON_HIT;
			}
			if (mode.get(id) == 2) {
				return MobMode.HIT;
			}
			if (mode.get(id) == 3) {
				return MobMode.ANGER;
			}
			if (mode.get(id) == 4) {
				return MobMode.BOSS;
			}
			return MobMode.DESPAWN;
		} else {
			return MobMode.DESPAWN;
		}
	}

	public static void updateTag(Entity k) {
		LivingEntity e = (LivingEntity) k;
		Damageable d = (Damageable) k;
		double ch = d.getHealth();
		DecimalFormat df = new DecimalFormat("#.#");
		String h = df.format(ch);
		if (e instanceof Wolf) {
			Wolf t = (Wolf) e;
			if (getMode(t.getUniqueId()) == MobMode.PASSIVE) {
				t.setCustomName(ChatColor.GREEN + "Wolf [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.HIT || getMode(t.getUniqueId()) == MobMode.ON_HIT) {
				t.setCustomName(ChatColor.BLUE + "Wolf [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.ANGER) {
				t.setCustomName(ChatColor.RED + "Wolf [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.BOSS) {
				t.setCustomName(ChatColor.DARK_PURPLE + "Wolf [" + h + "]");
			}
		} else if (e instanceof IronGolem) {
			IronGolem t = (IronGolem) e;
			if (getMode(t.getUniqueId()) == MobMode.PASSIVE) {
				t.setCustomName(ChatColor.GREEN + "IronGolem [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.HIT || getMode(t.getUniqueId()) == MobMode.ON_HIT) {
				t.setCustomName(ChatColor.BLUE + "IronGolem [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.ANGER) {
				t.setCustomName(ChatColor.RED + "IronGolem [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.BOSS) {
				t.setCustomName(ChatColor.DARK_PURPLE + "IronGolem [" + h + "]");
			}
		} else if (e instanceof Skeleton) {
			Skeleton t = (Skeleton) e;
			if (getMode(t.getUniqueId()) == MobMode.PASSIVE) {
				t.setCustomName(ChatColor.GREEN + "Skeleton [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.HIT || getMode(t.getUniqueId()) == MobMode.ON_HIT) {
				t.setCustomName(ChatColor.BLUE + "Skeleton [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.ANGER) {
				t.setCustomName(ChatColor.RED + "Skeleton [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.BOSS) {
				t.setCustomName(ChatColor.DARK_PURPLE + "Skeleton [" + h + "]");
			}
		} else if (e instanceof Slime) {
			Slime t = (Slime) e;
			if (getMode(t.getUniqueId()) == MobMode.PASSIVE) {
				t.setCustomName(ChatColor.GREEN + "Slime [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.HIT || getMode(t.getUniqueId()) == MobMode.ON_HIT) {
				t.setCustomName(ChatColor.BLUE + "Slime [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.ANGER) {
				t.setCustomName(ChatColor.RED + "Slime [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.BOSS) {
				t.setCustomName(ChatColor.DARK_PURPLE + "Slime [" + h + "]");
			}
		} else if (e instanceof Silverfish) {
			Silverfish t = (Silverfish) e;
			if (getMode(t.getUniqueId()) == MobMode.PASSIVE) {
				t.setCustomName(ChatColor.GREEN + "Silverfish [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.HIT || getMode(t.getUniqueId()) == MobMode.ON_HIT) {
				t.setCustomName(ChatColor.BLUE + "Silverfish [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.ANGER) {
				t.setCustomName(ChatColor.RED + "Silverfish [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.BOSS) {
				t.setCustomName(ChatColor.DARK_PURPLE + "Silverfish [" + h + "]");
			}
		} else if (e instanceof Zombie) {
			Zombie t = (Zombie) e;
			if (getMode(t.getUniqueId()) == MobMode.PASSIVE) {
				t.setCustomName(ChatColor.GREEN + "Zombie [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.HIT || getMode(t.getUniqueId()) == MobMode.ON_HIT) {
				t.setCustomName(ChatColor.BLUE + "Zombie [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.ANGER) {
				t.setCustomName(ChatColor.RED + "Zombie [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.BOSS) {
				t.setCustomName(ChatColor.DARK_PURPLE + "Zombie [" + h + "]");
			}
		} else if (e instanceof Snowman) {
			Snowman t = (Snowman) e;
			if (getMode(t.getUniqueId()) == MobMode.PASSIVE) {
				t.setCustomName(ChatColor.GREEN + "Snowman [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.HIT || getMode(t.getUniqueId()) == MobMode.ON_HIT) {
				t.setCustomName(ChatColor.BLUE + "Snowman [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.ANGER) {
				t.setCustomName(ChatColor.RED + "Snowman [" + h + "]");
			}
			if (getMode(t.getUniqueId()) == MobMode.BOSS) {
				t.setCustomName(ChatColor.DARK_PURPLE + "Snowman [" + h + "]");
			}
		} else if(e instanceof Wither) {
			Wither t = (Wither)e;
			if (getMode(t.getUniqueId()) == MobMode.BOSS) {
				t.setCustomName(ChatColor.DARK_PURPLE + "Wither [" + h + "]");
			} else {
				e.remove();
			}
		}else if(e instanceof EnderDragon) {
			EnderDragon t = (EnderDragon)e;
			if (getMode(t.getUniqueId()) == MobMode.BOSS) {
				t.setCustomName(ChatColor.DARK_PURPLE + "EnderDragon [" + h + "]");
			} else {
				e.remove();
			}
		} else {
			for (Entity near : e.getNearbyEntities(30, 30, 30)) {
				if (near instanceof Player) {
					Player pnear = (Player) near;
					Error.sendError(pnear, ErrorCode.ENITIY_PACK_TYPE_NOT_FOUND);
				}
			}
		}
	}

}
