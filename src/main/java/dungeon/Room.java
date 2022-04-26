package dungeon;

import characters.Player;
import characters.monsters.Monster;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class Room {
    private int floor;

    public Room(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    abstract void enter(Player player, BufferedReader reader) throws IOException;
}
