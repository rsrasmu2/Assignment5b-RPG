package characters.inventory;

import items.Consumable;
import items.Equipper;

public class Inventory {
    private Equipment equipment;
    private Consumables consumables;

    private int gold;

    public Inventory(Equipper equipper) {
        equipment = new Equipment(equipper);
        consumables = new Consumables();
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Consumables getConsumables() {
        return consumables;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void modifyGold(int value) {
        setGold(gold + value);
    }

    public String toString() {
        return  equipment.toString() + "\n" + consumables.toString() + "\nGold: " + gold;
    }
}
