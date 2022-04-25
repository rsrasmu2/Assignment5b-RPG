package characters.races.implementations;

import characters.races.Race;
import characters.races.RaceBuilder;

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
    public Race getRace() {
        return race;
    }
}
