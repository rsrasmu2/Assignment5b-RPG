package characters.races.implementations;

import characters.races.Race;
import characters.races.RaceBuilder;
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
        race.setStartingHealth(8);
        return this;
    }

    @Override
    public RaceBuilder buildStartingMana() {
        race.setStartingMana(100);
        return this;
    }

    @Override
    public RaceBuilder modifyCombatStats(CombatStats combatStats) {
        combatStats.setAttack(combatStats.getAttack() + 10);
        combatStats.setDefense(combatStats.getDefense() + 10);
        combatStats.setMagicAttack(combatStats.getMagicAttack() + 10);
        combatStats.setMagicDefense(combatStats.getMagicDefense() + 10);
        combatStats.setEvasion(combatStats.getEvasion() + 10);
        return this;
    }

    @Override
    public Race getRace() {
        return this.race;
    }
}
