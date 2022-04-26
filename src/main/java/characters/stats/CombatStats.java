package characters.stats;

import java.util.HashMap;

public class CombatStats {
    private HashMap<CombatStatType, CombatStat> stats;

    /**
     * Creates a new instance of Combat Stats with 0s for all values.
     */
    public CombatStats() {
        stats = new HashMap();
        stats.put(CombatStatType.ATTACK, new CombatStat(0));
        stats.put(CombatStatType.DEFENSE, new CombatStat(0));
        stats.put(CombatStatType.MAGIC_ATTACK, new CombatStat(0));
        stats.put(CombatStatType.MAGIC_DEFENSE, new CombatStat(0));
        stats.put(CombatStatType.EVASION, new CombatStat(0));
    }

    /**
     * Creates a new instance of Combat Stats with the given values.
     * @param attack the base value of the attack.
     * @param defense the base value of the defense.
     * @param magicAttack the base value of the magic attack.
     * @param magicDefense the base value of the magic defense.
     * @param evasion the base value of the evasion.
     */
    public CombatStats(int attack, int defense, int magicAttack, int magicDefense, int evasion) {
        stats = new HashMap();
        stats.put(CombatStatType.ATTACK, new CombatStat(attack));
        stats.put(CombatStatType.DEFENSE, new CombatStat(defense));
        stats.put(CombatStatType.MAGIC_ATTACK, new CombatStat(magicAttack));
        stats.put(CombatStatType.MAGIC_DEFENSE, new CombatStat(magicDefense));
        stats.put(CombatStatType.EVASION, new CombatStat(evasion));
    }

    public CombatStat getStat(CombatStatType combatStatType) {
        return stats.get(combatStatType);
    }

    /**
     * Runs a single tick of the simulation, decreasing the duration
     * of all combat stat modifiers.
     */
    public void tick() {
        for (CombatStat stat : stats.values()) {
            stat.tick();
        }
    }

    /**
     * Returns a formatted string of all combat stats.
     * @return a formatted string of all combat stats.
     */
    public String toString() {
        return "CombatStats:\nAttack: " + stats.get(CombatStatType.ATTACK)
                + "\nDefense: " + stats.get(CombatStatType.DEFENSE)
                + "\nMagic Attack: " + stats.get(CombatStatType.MAGIC_ATTACK)
                + "\nMagic Defense: " + stats.get(CombatStatType.MAGIC_DEFENSE)
                + "\nEvasion: " + stats.get(CombatStatType.EVASION);
    }
}
