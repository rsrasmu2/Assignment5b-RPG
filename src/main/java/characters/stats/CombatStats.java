package characters.stats;

import java.util.HashMap;

public class CombatStats {
    private HashMap<CombatStatType, CombatStat> stats;

    public CombatStats() {
        stats = new HashMap();
        stats.put(CombatStatType.ATTACK, new CombatStat(0));
        stats.put(CombatStatType.DEFENSE, new CombatStat(0));
        stats.put(CombatStatType.MAGIC_ATTACK, new CombatStat(0));
        stats.put(CombatStatType.MAGIC_DEFENSE, new CombatStat(0));
        stats.put(CombatStatType.EVASION, new CombatStat(0));
    }

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

    public String toString() {
        return "CombatStats:\nAttack: " + stats.get(CombatStatType.ATTACK)
                + "\nDefense: " + stats.get(CombatStatType.DEFENSE)
                + "\nMagic Attack: " + stats.get(CombatStatType.MAGIC_ATTACK)
                + "\nMagic Defense: " + stats.get(CombatStatType.MAGIC_DEFENSE)
                + "\nEvasion: " + stats.get(CombatStatType.EVASION);
    }
}
