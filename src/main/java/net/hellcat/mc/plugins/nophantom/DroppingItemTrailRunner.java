package net.hellcat.mc.plugins.nophantom;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Item;

public class DroppingItemTrailRunner implements Runnable {
    private Item trailedItem;

    private int taskId = -1;

    DroppingItemTrailRunner(Item trailedItem) {
        this.trailedItem = trailedItem;
    }

    @Override
    public void run() {
        int i;

        for (i = 0; i < 5; i++) {
            trailedItem.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, trailedItem.getLocation(), 0, 0.1, 0.1, 0.1);
        }

        if (trailedItem.isOnGround()) {
            Bukkit.getScheduler().cancelTask(taskId);
        }
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
