package net.hellcat.mc.plugins.nophantom;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class PhantomCage extends JavaPlugin {
    private Logger logger;

    private PhantomListener phantomListener;

    @Override
    public void onEnable() {
        logger = getLogger();

        phantomListener = new PhantomListener(this);

        MembraneRecipe.registerRecipe(this);

        getServer().getPluginManager().registerEvents(phantomListener, this);

        logger.info("Good news: The Phantoms have been banished and replaced by shooting star cookies :-)");
    }
}
