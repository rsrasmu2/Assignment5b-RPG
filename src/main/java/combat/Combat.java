package combat;

import characters.Monster;
import characters.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class Combat {
    private Player player;
    private Monster monster;

    private static final double DAMAGE_RANGE = 0.2;

    public Combat(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public void begin(BufferedReader reader) throws IOException {
        System.out.println("Combat has begun.\n----------");
        while (true) {
            printCombatants();
            if (player.getHealth().getCurrentValue() == 0) {
                System.out.println("You lose!\n----------");
                return;
            }
            if (monster.getHealth().getCurrentValue() == 0) {
                System.out.println("You win!\n----------");
                return;
            }
            tick(reader);
        }
    }

    private void tick(BufferedReader reader) throws IOException {
        player.tick();
        if (checkWinCondition()) {
            System.out.println("----------");
            return;
        }
        player.act(monster, reader);
        if (checkWinCondition()) {
            System.out.println("----------");
            return;
        }
        System.out.println("----------");
        monster.tick();
        if (checkWinCondition()) {
            return;
        }
        monster.act(player);
        if (checkWinCondition()) {
            System.out.println("----------");
            return;
        }
        System.out.println("----------");
    }

    private void printCombatants() {
        System.out.println(player.getName() + ":");
        System.out.println(player.getHealth().toString());
        System.out.println(player.getPrimaryResource().toString());
        System.out.println("----------");
        System.out.println(monster.getName() + ":");
        System.out.println(monster.getHealth().toString());
        System.out.println("----------");
    }

    private boolean checkWinCondition() {
        if (player.getHealth().getCurrentValue() == 0) {
            return true;
        }
        if (monster.getHealth().getCurrentValue() == 0) {
            return true;
        }
        return false;
    }

    public static int calculateDamageRange(int damage) {
        Random rand = new Random();
        double min = damage * (1 - DAMAGE_RANGE);
        return (int)(min + rand.nextDouble() * (damage * (1 + DAMAGE_RANGE) - min));
    }
}
