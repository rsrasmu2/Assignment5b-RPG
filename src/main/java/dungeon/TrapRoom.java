package dungeon;

import characters.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class TrapRoom extends Room {
    public TrapRoom(int floor) {
        super(floor);
    }

    @Override
    void enter(Player player, BufferedReader reader) throws IOException {
        System.out.println("This room contains a nasty trap.");
        Random rand = new Random();
        double chanceToAvoid = rand.nextDouble();
        if (chanceToAvoid > 0.50) {
            System.out.println("You narrowly avoid it.");
        } else {
            System.out.println("You get caught in the trap!");
            int damage = 0;
            switch (getFloor()) {
                case 1:
                    damage = 1 + rand.nextInt(6);
                    break;
                case 2:
                    damage = 5 + rand.nextInt(10);
                    break;
                case 3:
                    damage = 8 + rand.nextInt(18);
                    break;
                case 4:
                    damage = 13 + rand.nextInt(22);
                    break;
                case 5:
                    damage = 18 + rand.nextInt(30);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + getFloor());
            }
            player.getHealth().modifyCurrentValue(-damage);
            System.out.println("You take " + damage + " damage.\n----------");
            System.out.println(player.getHealth().toString());
        }
    }
}
