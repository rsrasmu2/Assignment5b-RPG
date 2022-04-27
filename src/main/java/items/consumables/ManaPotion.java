package items.consumables;

import characters.Player;
import items.Consumable;

public class ManaPotion extends Consumable {
    private static final int RESTORE_AMOUNT = 400;

    public ManaPotion() {
        super("Mana Potion", 15, 1);
    }

    /**
     * Uses the Mana Potion, resting for RESTORE_AMOUNT mana.
     * @param player the player using the potion.
     */
    public void use(Player player) {
        super.use(player);
        if (player.getPrimaryResource().getName().equals("Mana")) {
            player.getPrimaryResource().modifyCurrentValue(RESTORE_AMOUNT);
            System.out.println("Restored " + RESTORE_AMOUNT + " Mana");
        } else {
            System.out.println("You do not have mana.");
        }
    }
}
