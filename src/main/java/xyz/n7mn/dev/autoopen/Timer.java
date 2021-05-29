package xyz.n7mn.dev.autoopen;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.*;

public class Timer implements Runnable {

    private final Plugin plugin;

    public Timer(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public void run() {

        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);

        int pm = PM;
        int hour = 8;
        int minute = 50;
        int second = 0;

        if (instance.get(AM_PM) == PM && instance.get(HOUR) <= 2){
            hour = 1;
        }

        if (instance.get(AM_PM) == pm && instance.get(HOUR) == hour && instance.get(MINUTE) == minute && instance.get(SECOND) == second){
            Plugin checker = Bukkit.getServer().getPluginManager().getPlugin("PlayerJoinChecker");
            checker.getConfig().set("DefaultJoinPermRank", 0);
            plugin.getServer().getScheduler().cancelTasks(plugin);
            Bukkit.getServer().getPluginManager().disablePlugin(plugin);
        }
    }
}
