package town;

import dungeon.Dungeon;

public class Town {
    private Tavern tavern;
    private Dungeon dungeon;

    public Town() {
        tavern = new Tavern();
        dungeon = new Dungeon();
    }

    public void enter() {
        System.out.println("You enter a peaceful town.");
        System.out.println("Where would you like to go?");
        System.out.println("1. Dungeon");
        System.out.println("2. Tavern");
        System.out.println("3. Shop");
    }
}
