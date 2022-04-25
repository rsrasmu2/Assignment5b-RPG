package characters.races.implementations;

import characters.races.Race;
import characters.races.RaceBuilder;

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
    public Race getRace() {
        return race;
    }
}
