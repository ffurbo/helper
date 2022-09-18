package ffurbo.mc.example;

import java.util.logging.Logger;

import org.bukkit.entity.Player;

import ffurbo.mc.playerhelper.Helper;

public class Tutor extends Helper {

    public Tutor(Player player, Logger logger) {
        super(player, logger);
    }

    public void doSomeThings() {

        
        echo("x "+playerX());
        echo("x "+playerY());
        echo("x "+playerZ());

        //teleport(playerX(), playerY()-20, playerZ());

        echo("Siema!!!!");







	}
    
}
