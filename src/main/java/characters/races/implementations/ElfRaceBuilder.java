package characters.races.implementations;

import characters.races.Race;
import characters.races.RaceBuilder;
import characters.stats.CombatStatType;
import characters.stats.CombatStats;

public class ElfRaceBuilder implements RaceBuilder {
    private Race race;

    public ElfRaceBuilder() {
        this.race = new Race();
    }

    @Override
    public RaceBuilder buildName() {
        race.setName("Elf");
        return this;
    }

    @Override
    public RaceBuilder buildStartingHealth() {
        race.setStartingHealth(6);
        return this;
    }

    @Override
    public RaceBuilder buildStartingMana() {
        race.setStartingMana(200);
        return this;
    }

    @Override
    public RaceBuilder modifyCombatStats(CombatStats combatStats) {
        combatStats.getStat(CombatStatType.ATTACK).modifyBaseValue(6);
        combatStats.getStat(CombatStatType.DEFENSE).modifyBaseValue(6);
        combatStats.getStat(CombatStatType.MAGIC_ATTACK).modifyBaseValue(12);
        combatStats.getStat(CombatStatType.MAGIC_DEFENSE).modifyBaseValue(12);
        combatStats.getStat(CombatStatType.EVASION).modifyBaseValue(12);
        return this;
    }

    @Override
    public Race getRace() {
        return race;
    }
}
