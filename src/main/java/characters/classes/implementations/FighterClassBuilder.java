package characters.classes.implementations;

import characters.classes.CharacterClass;
import characters.classes.CharacterClassBuilder;
import characters.races.Race;
import characters.resources.CharacterResource;

public class FighterClassBuilder implements CharacterClassBuilder {
    private CharacterClass characterClass;

    public FighterClassBuilder() {
        this.characterClass = new CharacterClass();
    }

    @Override
    public CharacterClassBuilder buildName() {
        characterClass.setName("Fighter");
        return this;
    }

    @Override
    public CharacterClassBuilder buildStartingHealth() {
        characterClass.setStartingHealth(12);
        return this;
    }


    @Override
    public CharacterClassBuilder buildPrimaryResource(Race race) {
        characterClass.setPrimaryResource(new CharacterResource("Rage", 0, 100));
        return this;
    }

    @Override
    public CharacterClass getCharacterClass() {
        return characterClass;
    }
}
