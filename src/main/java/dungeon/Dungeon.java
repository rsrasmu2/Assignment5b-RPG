package dungeon;

public class Dungeon {
    private Room currentRoom;

    public Dungeon() {

    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setRoom(Room room) {
        currentRoom = room;
    }
}
