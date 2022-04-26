package characters.races.implementations;

import characters.races.Race;
import characters.races.RaceBuilder;
import characters.stats.CombatStatType;
import characters.stats.CombatStats;

public class OrcRaceBuilder implements RaceBuilder {
    private Race race;

    public OrcRaceBuilder() {
        this.race = new Race();
    }

    @Override
    public RaceBuilder buildName() {
        race.setName("Orc");
        return this;
    }

    @Override
    public RaceBuilder buildStartingHealth() {
        race.setStartingHealth(12);
        return this;
    }

    @Override
    public RaceBuilder buildStartingMana() {
        race.setStartingMana(0);
        return this;
    }

    @Override
    public RaceBuilder modifyCombatStats(CombatStats combatStats) {
        combatStats.getStat(CombatStatType.ATTACK).modifyBaseValue(14);
        combatStats.getStat(CombatStatType.DEFENSE).modifyBaseValue(12);
        combatStats.getStat(CombatStatType.MAGIC_ATTACK).modifyBaseValue(4);
        combatStats.getStat(CombatStatType.MAGIC_DEFENSE).modifyBaseValue(6);
        combatStats.getStat(CombatStatType.EVASION).modifyBaseValue(8);
        return this;
    }

    @Override
    public Race getRace() {
        return race;
    }
}
