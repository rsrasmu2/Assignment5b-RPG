package characters.races.implementations;

import characters.races.Race;
import characters.races.RaceBuilder;

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
    public Race getRace() {
        return this.race;
    }
}
