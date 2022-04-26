package characters.races.implementations;

import characters.classes.CharacterClassBuilder;
import characters.races.Race;
import characters.races.RaceBuilder;
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
        combatStats.setAttack(combatStats.getAttack() + 12);
        combatStats.setDefense(combatStats.getDefense() + 12);
        combatStats.setMagicAttack(combatStats.getMagicAttack() + 6);
        combatStats.setMagicDefense(combatStats.getMagicDefense() + 10);
        combatStats.setEvasion(combatStats.getEvasion() + 5);
        return this;
    }

    @Override
    public Race getRace() {
        return race;
    }
}
