package items.consumables;

import characters.Player;
import characters.stats.AdditiveModifier;
import characters.stats.CombatStatType;
import items.Consumable;

public class StrengthPotion extends Consumable {
    private static final int INCREASE_AMOUNT = 50;

    public StrengthPotion() {
        super("Strength Potion", 25, 1);
    }

    /**
     * Uses the Power Potion, granting INCREASE_AMOUNT attack.
     * @param player the player using the potion.
     */
    public void use(Player player) {
        super.use(player);
        player.getCombatStats().getStat(CombatStatType.ATTACK)
                .addModifier(new AdditiveModifier(INCREASE_AMOUNT, 3));
        System.out.println("Gained " + INCREASE_AMOUNT + " Attack.");
    }
}
