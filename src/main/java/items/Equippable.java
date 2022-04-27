package items;

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

    /**
     * Creates a new Equippable item.
     * @param name the name of the item.
     * @param cost the cost of the item.
     * @param slot the slot the item occupies.
     * @param attack the attack value the item modifies.
     * @param defense the defense value the item modifies.
     * @param magicAttack the magic attack value the item modifies.
     * @param magicDefense the magic defense value the item modifies.
     * @param evasion the evasion value the item modifies.
     */
    public Equippable(String name, int cost, EquipmentSlot slot, int attack,
                      int defense, int magicAttack, int magicDefense, int evasion) {
        super(name, cost);
        this.slot = slot;
        attackModifier = new AdditiveModifier(attack);
        defenseModifier = new AdditiveModifier(defense);
        magicAttackModifier = new AdditiveModifier(magicAttack);
        magicDefenseModifier = new AdditiveModifier(magicDefense);
        evasionModifier = new AdditiveModifier(evasion);
    }

    /**
     * Adds modifiers to the equipper's combat stats.
     * @param equipper the character equipping the Equippable.
     */
    public void equip(Equipper equipper) {
        equipper.getCombatStats().getStat(CombatStatType.ATTACK)
                .addModifier(attackModifier);
        equipper.getCombatStats().getStat(CombatStatType.DEFENSE)
                .addModifier(defenseModifier);
        equipper.getCombatStats().getStat(CombatStatType.MAGIC_ATTACK)
                .addModifier(magicAttackModifier);
        equipper.getCombatStats().getStat(CombatStatType.MAGIC_DEFENSE)
                .addModifier(magicDefenseModifier);
        equipper.getCombatStats().getStat(CombatStatType.EVASION)
                .addModifier(evasionModifier);
    }

    /**
     * Remove the modifiers to the equipper's Combat Stats.
     * @param equipper the character equipping the Equippable.
     */
    public void unequip(Equipper equipper) {
        equipper.getCombatStats().getStat(CombatStatType.ATTACK)
                .removeModifier(attackModifier);
        equipper.getCombatStats().getStat(CombatStatType.DEFENSE)
                .removeModifier(defenseModifier);
        equipper.getCombatStats().getStat(CombatStatType.MAGIC_ATTACK)
                .removeModifier(magicAttackModifier);
        equipper.getCombatStats().getStat(CombatStatType.MAGIC_DEFENSE)
                .removeModifier(magicDefenseModifier);
        equipper.getCombatStats().getStat(CombatStatType.EVASION)
                .removeModifier(evasionModifier);
    }

    public EquipmentSlot getSlot() {
        return slot;
    }

    /**
     * Returns a formatted String of the Equippable.
     * @return a formatted String of the Equippable.
     */
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
