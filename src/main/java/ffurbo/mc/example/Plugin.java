package ffurbo.mc.example;

import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import ffurbo.mc.playerhelper.Helper;

public class Plugin extends JavaPlugin implements Listener {
    
    @Override
    public void onEnable() {
        this.getLogger().log(Level.INFO, "PlayerHelper plugin...");
        this.getLogger().log(Level.INFO, Helper.checkClass());
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			return false;
		}
		Tutor tutor = new Tutor((Player) sender,  this.getLogger());

        if (label.equals("qwe")) {
			tutor.doSomeThings();	
            return true;
        }
		return true;
	}
    
}
