package characters.inventory;

import items.Equippable;
import items.Equipper;

public class Equipment {
    private Equippable weapon;
    private Equippable armor;

    private Equipper equipper;

    public Equipment(Equipper equipper) {
        this.equipper = equipper;
    }

    public void equip(Equippable equippable) {
        switch (equippable.getSlot()) {
            case WEAPON:
                if (weapon != null) {
                    weapon.unequip(equipper);
                }
                weapon = equippable;
                weapon.equip(equipper);
                break;
            case ARMOR:
                if (armor != null) {
                    armor.unequip(equipper);
                }
                armor = equippable;
                armor.equip(equipper);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + equippable.getSlot());
        }
    }

    public void unequip(EquipmentSlot slot) {
        switch (slot) {
            case WEAPON:
                if (weapon != null) {
                    weapon.unequip(equipper);
                }
                break;
            case ARMOR:
                if (armor != null) {
                    armor.unequip(equipper);
                }
                break;
        }
    }

    public Equippable getEquippable(EquipmentSlot slot) {
        switch (slot) {
            case WEAPON:
                return weapon;
            case ARMOR:
                return armor;
            default:
                throw new IllegalStateException("Unexpected value: " + slot);
        }
    }

    public String toString() {
        String ret = "";
        if (weapon != null) {
            ret += "Weapon:\n" + weapon.toString();
        }
        if (armor != null) {
            ret += "Armor:\n" + armor.toString();
        }
        return ret;
    }
}
