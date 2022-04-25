package characters.races.implementations;

import characters.races.Race;
import characters.races.RaceBuilder;

public class DwarfRaceBuilder implements RaceBuilder {
    private Race race;

    public DwarfRaceBuilder() {
        this.race = new Race();
    }

    @Override
    public void buildName() {
        race.setName("Dwarf");
    }

    @Override
    public void buildStartingHealth() {
        race.setStartingHealth(10);
    }

    @Override
    public void buildStartingMana() {
        race.setStartingMana(50);
    }

    @Override
    public Race getRace() {
        return race;
    }
}
