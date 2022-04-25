package characters.races.implementations;

import characters.races.Race;
import characters.races.RaceBuilder;

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
    public Race getRace() {
        return race;
    }
}
