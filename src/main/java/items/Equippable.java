package items;

import characters.Player;
import characters.inventory.EquipmentSlot;
import characters.stats.AdditiveModifier;
import characters.stats.CombatStatModifier;
import characters.stats.CombatStatType;

public class Equippable extends Item {
    private EquipmentSlot slot;

    private CombatStatModifier attackModifier;
    private CombatStatModifier defenseModifier;
    private CombatStatModifier magicAttackModifier;
    private CombatStatModifier magicDefenseModifier;
    private CombatStatModifier evasionModifier;

    public Equippable(String name, EquipmentSlot slot, int attack, int defense, int magicAttack, int magicDefense, int evasion) {
        super(name);
        this.slot = slot;
        attackModifier = new AdditiveModifier(attack);
        defenseModifier = new AdditiveModifier(defense);
        magicAttackModifier = new AdditiveModifier(magicAttack);
        magicDefenseModifier = new AdditiveModifier(magicDefense);
        evasionModifier = new AdditiveModifier(evasion);
    }

    public void equip(Equipper equipper) {
        equipper.getCombatStats().getStat(CombatStatType.ATTACK).addModifier(attackModifier);
        equipper.getCombatStats().getStat(CombatStatType.DEFENSE).addModifier(defenseModifier);
        equipper.getCombatStats().getStat(CombatStatType.MAGIC_ATTACK).addModifier(magicAttackModifier);
        equipper.getCombatStats().getStat(CombatStatType.MAGIC_DEFENSE).addModifier(magicDefenseModifier);
        equipper.getCombatStats().getStat(CombatStatType.EVASION).addModifier(evasionModifier);
    }

    public void unequip(Equipper equipper) {
        equipper.getCombatStats().getStat(CombatStatType.ATTACK).removeModifier(attackModifier);
        equipper.getCombatStats().getStat(CombatStatType.DEFENSE).removeModifier(defenseModifier);
        equipper.getCombatStats().getStat(CombatStatType.MAGIC_ATTACK).removeModifier(magicAttackModifier);
        equipper.getCombatStats().getStat(CombatStatType.MAGIC_DEFENSE).removeModifier(magicDefenseModifier);
        equipper.getCombatStats().getStat(CombatStatType.EVASION).removeModifier(evasionModifier);
    }

    public EquipmentSlot getSlot() {
        return slot;
    }

    public String toString() {
        String retValue = getName() + ":\n";
        if (attackModifier.getValue() != 0) {
            retValue += "Attack: " + attackModifier + "\n";
        }
        if (defenseModifier.getValue() != 0) {
            retValue += "Defense: " + defenseModifier + "\n";
        }
        if (magicAttackModifier.getValue() != 0) {
            retValue += "Magic Attack: " + magicAttackModifier + "\n";
        }
        if (magicDefenseModifier.getValue() != 0) {
            retValue += "Magic Defense: " + magicDefenseModifier + "\n";
        }
        if (evasionModifier.getValue() != 0) {
            retValue += "Evasion: " + evasionModifier + "\n";
        }
        return retValue;
    }
}
