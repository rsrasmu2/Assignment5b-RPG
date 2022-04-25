package characters.races.implementations;

import characters.races.Race;
import characters.races.RaceBuilder;

public class OrcRaceBuilder implements RaceBuilder {
    private Race race;

    public OrcRaceBuilder() {
        this.race = new Race();
    }

    @Override
    public void buildName() {
        race.setName("Orc");
    }

    @Override
    public void buildStartingHealth() {
        race.setStartingHealth(12);
    }

    @Override
    public void buildStartingMana() {
        race.setStartingMana(0);
    }

    @Override
    public Race getRace() {
        return race;
    }
}
