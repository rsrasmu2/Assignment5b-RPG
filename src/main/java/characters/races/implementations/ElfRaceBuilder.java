package characters.races.implementations;

import characters.races.Race;
import characters.races.RaceBuilder;

public class ElfRaceBuilder implements RaceBuilder {
    private Race race;

    public ElfRaceBuilder() {
        this.race = new Race();
    }

    @Override
    public void buildName() {
        race.setName("Elf");
    }

    @Override
    public void buildStartingHealth() {
        race.setStartingHealth(6);
    }

    @Override
    public void buildStartingMana() {
        race.setStartingMana(200);
    }

    @Override
    public Race getRace() {
        return race;
    }
}
