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

    public void begin(Player player, BufferedReader reader) throws IOException {
        while (true) {
            generateRoom();
            currentRoom.enter(player, reader);
            if (player.getHealth().getCurrentValue() == 0) {
                System.out.println("Returning to town...\n----------");
                break;
            }
            roomNumber++;
            if (roomNumber == ROOMS_PER_FLOOR + 1) {
                System.out.println("You find a stairway leading further down...\n----------");
                floorNumber++;
                roomNumber = 1;
                if (floorNumber == MAX_FLOORS + 1) {
                    System.out.println("Congratulations! You win!");
                    break;
                }
            }
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    private void generateRoom() {
        Random rand = new Random();
        double chanceValue = rand.nextDouble();
        if (chanceValue < 0.60) {
            currentRoom = new MonsterRoom(floorNumber);
        } else if (chanceValue < 0.80) {
            currentRoom = new TrapRoom(floorNumber);
        } else {
            currentRoom = new TreasureRoom(floorNumber);
        }
    }
}
