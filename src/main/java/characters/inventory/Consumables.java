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

    public void use(Player player, int index) {
        Consumable consumable = consumables.get(index);
        consumable.use(player);
        if (consumable.getUses() == 0) {
            removeConsumable(consumable);
        }
    }

    public String toString() {
        String ret = "Consumables:\n";
        for (Consumable consumable :  consumables) {
            ret += consumable.toString() + "\n";
        }
        return ret;
    }
}
