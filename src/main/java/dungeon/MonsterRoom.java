package dungeon;

import characters.Player;
import characters.monsters.Monster;
import characters.monsters.MonsterFactory;
import combat.Combat;

import java.io.BufferedReader;
import java.io.IOException;

public class MonsterRoom extends Room {
    private Monster monster;

    public MonsterRoom(int floor) {
        super(floor);
        monster = new MonsterFactory().getMonster(getFloor());
    }

    /**
     * Places the player in the room.
     * @param player the player character.
     * @param reader the BufferedReader being used.
     * @throws IOException the IOException throw by the BufferedReader.
     */
    public void enter(Player player, BufferedReader reader) throws IOException {
        System.out.println("In this room you find a " + monster.getName() + "!");
        Combat combat = new Combat(player, monster);
        combat.begin(reader);
    }
}
