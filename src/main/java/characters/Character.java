package characters;

import characters.classes.CharacterClass;
import characters.classes.CharacterClassType;
import characters.races.Race;
import characters.races.RaceType;
import characters.resources.CharacterResource;

public class Character {
    private CharacterResource health;
    private CharacterResource primaryResource;

    private Race race;
    private CharacterClass characterClass;

    public Character(Race race, CharacterClassType characterClassType) {
        characterClass = new CharacterClass(characterClassType);
        health = new CharacterResource("Health", race.getStartingHealth()
                + characterClass.getStartingHealth());
        primaryResource = characterClass.getPrimaryResource(race);
    }
}
