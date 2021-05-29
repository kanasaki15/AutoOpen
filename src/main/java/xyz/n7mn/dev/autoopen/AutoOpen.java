package xyz.n7mn.dev.autoopen;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class AutoOpen extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Timer timer = new Timer(this);
        getServer().getScheduler().runTaskTimerAsynchronously(this, timer, 0L, 20L);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
