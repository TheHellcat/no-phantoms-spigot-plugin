package net.hellcat.mc.plugins.nophantom;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitTask;

import java.util.logging.Logger;

public class PhantomListener implements Listener {
    private final Logger logger;

    private PhantomCage plugin;

    PhantomListener(PhantomCage plugin) {
        this.plugin = plugin;
        logger = this.plugin.getLogger();
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        Location spawnLocation;
        ItemStack cookieStack;
        Item spawnedItem;
        DroppingItemTrailRunner trailRunner;
        BukkitTask trailTask;
        ItemMeta cookieMeta;

        if (event.getEntity().getType() == EntityType.PHANTOM) {
            event.setCancelled(true);

            spawnLocation = event.getLocation();

            cookieStack = new ItemStack(Material.COOKIE, 1);
            cookieMeta = cookieStack.getItemMeta();
            cookieMeta.setDisplayName(ChatColor.AQUA + "Menaced Phantom");
            cookieStack.setItemMeta(cookieMeta);

            spawnLocation.setY(128);
            spawnedItem = Bukkit.getServer().getWorld(spawnLocation.getWorld().getName()).dropItem(spawnLocation, cookieStack);

            trailRunner = new DroppingItemTrailRunner(spawnedItem);
            trailTask = Bukkit.getScheduler().runTaskTimer(plugin, trailRunner, 0, 2);
            trailRunner.setTaskId(trailTask.getTaskId());
        }
    }
}
