package characters;

import characters.classes.CharacterClass;
import characters.races.Race;
import characters.resources.CharacterResource;

public class Player {
    private CharacterResource health;
    private CharacterResource primaryResource;

    private Race race;
    private CharacterClass characterClass;

    public Player(Race race, CharacterClass characterClass) {
        health = new CharacterResource("Health", race.getStartingHealth()
                + characterClass.getStartingHealth());
        primaryResource = characterClass.getPrimaryResource();
    }

    public CharacterResource getHealth() {
        return health;
    }

    public CharacterResource getPrimaryResource() {
        return primaryResource;
    }

    public Race getRace() {
        return race;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }
}
