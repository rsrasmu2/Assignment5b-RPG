package combat;

import characters.Monster;
import characters.Player;

import java.util.Random;

public class Combat {
    private Player player;
    private Monster monster;

    private static final double DAMAGE_RANGE = 0.2;

    public Combat(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public void tick() {

    }

    public static int calculateDamageRange(int damage) {
        Random rand = new Random();
        double min = damage * (1 - DAMAGE_RANGE);
        return (int)(min + rand.nextDouble() * (damage * (1 + DAMAGE_RANGE) - min));
    }
}
