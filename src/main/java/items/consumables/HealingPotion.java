package items.consumables;

import characters.Player;
import items.Consumable;

public class HealingPotion extends Consumable {
    private static final int HEAL_AMOUNT = 50;

    public HealingPotion() {
        super("Healing Potion", 10, 1);
    }

    /**
     * Uses the Healing Potion, healing for HEAL_AMOUNT health.
     * @param player the player using the potion.
     */
    public void use(Player player) {
        super.use(player);
        player.getHealth().modifyCurrentValue(HEAL_AMOUNT);
        System.out.println("Healed " + HEAL_AMOUNT + " Health");
    }
}
