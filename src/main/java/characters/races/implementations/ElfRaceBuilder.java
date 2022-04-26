package characters.races.implementations;

import characters.races.Race;
import characters.races.RaceBuilder;
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
        combatStats.setAttack(combatStats.getAttack() + 6);
        combatStats.setDefense(combatStats.getDefense() + 8);
        combatStats.setMagicAttack(combatStats.getMagicAttack() + 12);
        combatStats.setMagicDefense(combatStats.getMagicDefense() + 12);
        combatStats.setEvasion(combatStats.getEvasion() + 12);
        return this;
    }

    @Override
    public Race getRace() {
        return race;
    }
}
