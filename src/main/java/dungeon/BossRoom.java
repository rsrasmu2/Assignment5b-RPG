package dungeon;

import characters.Player;
import characters.monsters.Monster;
import characters.monsters.MonsterFactory;
import combat.Combat;

import java.io.BufferedReader;
import java.io.IOException;

public class BossRoom extends Room{
    private Monster monster;

    public BossRoom(int floor) {
        super(floor);
        monster = new MonsterFactory().getBoss(getFloor());
    }

    @Override
    void enter(Player player, BufferedReader reader) throws IOException {
        System.out.println("In this room you find a terrifying " + monster.getName() + "!");
        Combat combat = new Combat(player, monster);
        combat.begin(reader);
    }
}
