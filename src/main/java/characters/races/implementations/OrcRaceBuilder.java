package characters.races.implementations;

import characters.races.Race;
import characters.races.RaceBuilder;
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
        combatStats.setAttack(combatStats.getAttack() + 14);
        combatStats.setDefense(combatStats.getDefense() + 12);
        combatStats.setMagicAttack(combatStats.getMagicAttack() + 4);
        combatStats.setMagicDefense(combatStats.getMagicDefense() + 6);
        combatStats.setEvasion(combatStats.getEvasion() + 8);
        return this;
    }

    @Override
    public Race getRace() {
        return race;
    }
}
