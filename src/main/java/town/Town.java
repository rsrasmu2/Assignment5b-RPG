package town;

import characters.Player;
import dungeon.Dungeon;

import java.io.BufferedReader;
import java.io.IOException;

public class Town {
    private Dungeon dungeon;
    private Tavern tavern;
    private Shop shop;

    private Player player;

    public Town(Player player) {
        this.player = player;
        dungeon = new Dungeon();
        tavern = new Tavern();
        shop = new Shop();
    }

    public void enter(BufferedReader reader) throws IOException {
        while (true) {
            System.out.println("You enter a peaceful town.");
            System.out.println("Where would you like to go?");
            System.out.println("1. Dungeon");
            System.out.println("2. Tavern");
            System.out.println("3. Shop");
            System.out.println("4. Quit");

            String input = reader.readLine();
            switch (input) {
                case "1":
                    Dungeon dungeon = new Dungeon();
                    dungeon.begin(player, reader);
                    break;
                case "2":
                    tavern.enter(player, reader);
                    break;
                case "3":
                    shop.enter(player, reader);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid selection");
            }
        }
    }
}
