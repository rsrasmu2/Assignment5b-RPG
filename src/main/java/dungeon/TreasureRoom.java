package dungeon;

import characters.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class TreasureRoom extends Room {
    public TreasureRoom(int floor) {
        super(floor);
    }

    @Override
    void enter(Player player, BufferedReader reader) throws IOException {
        System.out.println("You found a room full of treasure!");
        Random rand = new Random();
        int treasure = 0;
        switch (getFloor()) {
            case 1:
                treasure = 8 + rand.nextInt(10);
                break;
            case 2:
                treasure = 14 + rand.nextInt(18);
                break;
            case 3:
                treasure = 27 + rand.nextInt(26);
                break;
            case 4:
                treasure = 38 + rand.nextInt(36);
                break;
            case 5:
                treasure = 50 + rand.nextInt(50);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + getFloor());
        }
        System.out.println("You gained " + treasure + " gold!\n----------");
    }
}
