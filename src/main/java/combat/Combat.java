package combat;

import java.util.Random;

public class Combat {
    private static final double DAMAGE_RANGE = 0.2;

    public static int calculateDamageRange(int damage) {
        Random rand = new Random();
        double min = damage * (1 - DAMAGE_RANGE);
        return (int)(min + rand.nextDouble() * (damage * (1 + DAMAGE_RANGE) - min));
    }
}
