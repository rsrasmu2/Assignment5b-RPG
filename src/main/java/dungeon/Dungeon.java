package dungeon;

import characters.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class Dungeon {
    private int floorNumber;
    private int roomNumber;

    private Room currentRoom;

    private static final int ROOMS_PER_FLOOR = 10;
    private static final int MAX_FLOORS = 5;

    public Dungeon() {
        floorNumber = 1;
        roomNumber = 1;
    }

    /**
     * Begins the dungeon escapade.
     * @param player the player character.
     * @param reader the BufferedReader being used.
     * @throws IOException the BufferedReader IO exception.
     */
    public void begin(Player player, BufferedReader reader) throws IOException {
        while (true) {
            currentRoom = generateRoom();
            currentRoom.enter(player, reader);
            if (player.getHealth().getCurrentValue() == 0) {
                System.out.println("Returning to town...\n----------");
                return;
            }
            System.out.println("1. Continue\n2. Return to town");
            String input = reader.readLine();
            if (input == null) {
                throw new IOException("Null input");
            }
            if (input.equals("1")) {
                roomNumber++;
                if (roomNumber == ROOMS_PER_FLOOR + 1) {
                    System.out.println("You find a stairway leading further down...\n----------");
                    floorNumber++;
                    roomNumber = 1;
                    if (floorNumber == MAX_FLOORS + 1) {
                        System.out.println("Congratulations! You win!");
                        return;
                    }
                }
            } else if (input.equals("2")) {
                return;
            } else {
                System.out.println("Invalid selection");
            }
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Sets the current room to a newly generated room.
     */
    private Room generateRoom() {
        if (roomNumber == 10) {
            return new BossRoom(floorNumber);
        }
        Random rand = new Random();
        double chanceValue = rand.nextDouble();
        if (chanceValue < 0.80) {
            return new MonsterRoom(floorNumber);
        } else if (chanceValue < 0.90) {
            return new TrapRoom(floorNumber);
        } else {
            return new TreasureRoom(floorNumber);
        }
    }
}
