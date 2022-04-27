package characters.inventory;

import characters.Player;
import items.Consumable;

import java.util.ArrayList;
import java.util.List;

public class Consumables {
    private List<Consumable> consumables;

    public Consumables() {
        consumables = new ArrayList();
    }

    public void addConsumable(Consumable consumable) {
        consumables.add(consumable);
    }

    public void removeConsumable(Consumable consumable) {
        consumables.remove(consumable);
    }

    public List<Consumable> getConsumables() {
        return consumables;
    }

    /**
     * Uses the consumable.
     * @param player the player character.
     * @param index the index of the consumable.
     */
    public void use(Player player, int index) {
        Consumable consumable = consumables.get(index);
        consumable.use(player);
        if (consumable.getUses() == 0) {
            removeConsumable(consumable);
        }
    }

    /**
     * Returns a formatted string of the inventory.
     * @return a formatted string of the inventory.
     */
    public String toString() {
        String ret = "Consumables:\n";
        for (Consumable consumable :  consumables) {
            ret += consumable.toString() + "\n";
        }
        return ret;
    }
}
