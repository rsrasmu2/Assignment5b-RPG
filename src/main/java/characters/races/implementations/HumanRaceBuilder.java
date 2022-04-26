package characters.races.implementations;

import characters.races.Race;
import characters.races.RaceBuilder;
import characters.stats.CombatStatType;
import characters.stats.CombatStats;

public class HumanRaceBuilder implements RaceBuilder {
    private Race race;

    public HumanRaceBuilder() {
        this.race = new Race();
    }

    @Override
    public RaceBuilder buildName() {
        race.setName("Human");
        return this;
    }

    @Override
    public RaceBuilder buildStartingHealth() {
        race.setStartingHealth(18);
        return this;
    }

    @Override
    public RaceBuilder buildStartingMana() {
        race.setStartingMana(100);
        return this;
    }

    @Override
    public RaceBuilder modifyCombatStats(CombatStats combatStats) {
        combatStats.getStat(CombatStatType.ATTACK).modifyBaseValue(10);
        combatStats.getStat(CombatStatType.DEFENSE).modifyBaseValue(10);
        combatStats.getStat(CombatStatType.MAGIC_ATTACK).modifyBaseValue(10);
        combatStats.getStat(CombatStatType.MAGIC_DEFENSE).modifyBaseValue(10);
        combatStats.getStat(CombatStatType.EVASION).modifyBaseValue(10);
        return this;
    }

    @Override
    public Race getRace() {
        return this.race;
    }
}
