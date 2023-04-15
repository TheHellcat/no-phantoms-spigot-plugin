package net.hellcat.mc.plugins.nophantom;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class MembraneRecipe {

    private MembraneRecipe() {
    }

    public static void registerRecipe(JavaPlugin plugin) {
        Bukkit.addRecipe(getRecipe(plugin));
    }

    private static ShapedRecipe getRecipe(JavaPlugin plugin) {
        NamespacedKey key;
        ShapedRecipe recipe;
        ItemStack craftedItem;

        craftedItem = new ItemStack(Material.PHANTOM_MEMBRANE, 1);

        key = new NamespacedKey(plugin, MembraneRecipe.class.getPackageName() + ".craftedmembrane");
        recipe = new ShapedRecipe(key, craftedItem);
        recipe.shape("   ", "FAF", "   ");
        recipe.setIngredient('F', Material.FEATHER);
        recipe.setIngredient('A', Material.AMETHYST_SHARD);

        return recipe;
    }
}
