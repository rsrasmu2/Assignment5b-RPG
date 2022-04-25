package characters.races.implementations;

import characters.races.Race;
import characters.races.RaceBuilder;

public class HumanRaceBuilder implements RaceBuilder {
    private Race race;

    public HumanRaceBuilder() {
        this.race = new Race();
    }

    @Override
    public void buildName() {
        race.setName("Human");
    }

    @Override
    public void buildStartingHealth() {
        race.setStartingHealth(8);
    }

    @Override
    public void buildStartingMana() {
        race.setStartingMana(100);
    }

    @Override
    public Race getRace() {
        return this.race;
    }
}
