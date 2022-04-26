package characters.inventory;

import items.Consumable;
import items.Equipper;

public class Inventory {
    private Equipment equipment;
    private Consumables consumables;

    public Inventory(Equipper equipper) {
        equipment = new Equipment(equipper);
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Consumables getConsumables() {
        return consumables;
    }
}
