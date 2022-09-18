package ffurbo.mc.playerhelper;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getLogger().log(Level.INFO, "PlayerHelper plugin...");
        this.getLogger().log(Level.INFO, Helper.checkClass());
    }

}
