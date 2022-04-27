package town;

import characters.Player;

import java.io.BufferedReader;
import java.io.IOException;

public class Tavern implements TownBuilding {
    public static final int REST_COST = 5;


    @Override
    public void enter(Player player, BufferedReader reader) throws IOException {
        System.out.println("You enter a lively tavern.");
        while (true) {
            System.out.println("1. Stay for the night (" + REST_COST + " gold).");
            System.out.println("2. Leave.");
            System.out.println("You have " + player.getInventory().getGold() + " gold.");
            String input = reader.readLine();
            if (input == null) {
                throw new IOException("Null input");
            }
            switch (input) {
                case "1":
                    if (player.getInventory().getGold() < REST_COST) {
                        System.out.println("You can't afford to rest here.");
                        System.out.println("You leave the tavern.");
                        return;
                    }
                    player.getInventory().modifyGold(-REST_COST);
                    player.getHealth().refresh();
                    player.getPrimaryResource().refresh();
                    System.out.println("You have a relaxing rest.");
                    System.out.println("Health restored. "
                            + player.getPrimaryResource().getName() + " restored.");
                    System.out.println("You leave the tavern.");
                    return;
                case "2":
                    System.out.println("You leave the tavern.");
                    return;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }
}
