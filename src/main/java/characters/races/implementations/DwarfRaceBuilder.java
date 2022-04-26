package characters.races.implementations;

import characters.classes.CharacterClassBuilder;
import characters.races.Race;
import characters.races.RaceBuilder;
import characters.stats.CombatStatType;
import characters.stats.CombatStats;

public class DwarfRaceBuilder implements RaceBuilder {
    private Race race;

    public DwarfRaceBuilder() {
        this.race = new Race();
    }

    @Override
    public RaceBuilder buildName() {
        race.setName("Dwarf");
        return this;
    }

    @Override
    public RaceBuilder buildStartingHealth() {
        race.setStartingHealth(10);
        return this;
    }

    @Override
    public RaceBuilder buildStartingMana() {
        race.setStartingMana(50);
        return this;
    }

    @Override
    public RaceBuilder modifyCombatStats(CombatStats combatStats) {
        combatStats.getStat(CombatStatType.ATTACK).modifyBaseValue(12);
        combatStats.getStat(CombatStatType.DEFENSE).modifyBaseValue(12);
        combatStats.getStat(CombatStatType.MAGIC_ATTACK).modifyBaseValue(6);
        combatStats.getStat(CombatStatType.MAGIC_DEFENSE).modifyBaseValue(10);
        combatStats.getStat(CombatStatType.EVASION).modifyBaseValue(5);
        return this;
    }

    @Override
    public Race getRace() {
        return race;
    }
}
