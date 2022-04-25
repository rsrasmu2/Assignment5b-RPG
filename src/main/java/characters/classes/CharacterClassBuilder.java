package characters.classes;

import characters.races.Race;

public interface CharacterClassBuilder {
    CharacterClassBuilder buildName();

    CharacterClassBuilder buildStartingHealth();

    CharacterClassBuilder buildPrimaryResource(Race race);

    public CharacterClass getCharacterClass();
}
