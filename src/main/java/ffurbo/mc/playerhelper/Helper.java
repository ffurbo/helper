package ffurbo.mc.playerhelper;

import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Helper {

    private Player player;
    private World world;
    private Logger logger;

    public Helper(Player player, Logger logger) {
        this.player = player;
        this.logger = logger;
        this.world = player.getWorld();

    }

    public void echo(String txt) {
        player.sendMessage(txt);
    }

    public int playerX() {
        return player.getLocation().getBlockX();
    }

    public int playerY() {
        return player.getLocation().getBlockY();
    }

    public int playerZ() {
        return player.getLocation().getBlockZ();
    }

    public void putBlock(int x, int y, int z) {
        Block block = world.getBlockAt(x, y, z);
        block.setType(Material.BRICKS);
    }

    public void putBlock(int x, int y, int z, Material type) {
        Block block = world.getBlockAt(x, y, z);
        block.setType(type);
    }

    public Material checkBlock(int x, int y, int z) {
        Block block = world.getBlockAt(x, y, z);
        return block.getType();
    }

    public String yourName() {
        return player.getName();
    }

    public int random(int min, int max) {
        Random rand;
        rand = new Random();

        return rand.nextInt(max - min) + min;
    }

    private boolean isLocationSafe(int x, int y, int z) {
        // logger.info("checking altitude " + y + "...");

        // ground
        if (world.getBlockAt(x, y - 1, z).getType() == Material.AIR) {
            return false;
        }

        // legs - tp point
        if (world.getBlockAt(x, y, z).getType() != Material.AIR) {
            return false;
        }

        // head
        if (world.getBlockAt(x, y + 1, z).getType() != Material.AIR) {
            return false;
        }

        return true;

    }

    private int safeAltitude(int x, int y, int z) {

        for (int i = y; i >= -64; i--) {
            if (isLocationSafe(x, i, z)) {
                return i;
            }
        }

        for (int i = 320; i >= y; i--) {
            if (isLocationSafe(x, i, z)) {
                return i;
            }
        }

        return y;
    }

    public void teleport(int x, int y, int z) {

        logger.info("x:" + x + " y:" + y + " z:" + z);

        int safeY = safeAltitude(x, y, z);
        player.teleport(new Location(world, x + 0.5, safeY, z + 0.5));
    }

    public static String checkClass() {
        return "Helper class present";
    }

}
