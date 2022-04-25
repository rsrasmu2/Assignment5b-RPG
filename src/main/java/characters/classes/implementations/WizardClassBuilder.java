package characters.classes.implementations;

import characters.classes.CharacterClass;
import characters.classes.CharacterClassBuilder;
import characters.races.Race;
import characters.resources.CharacterResource;

public class WizardClassBuilder implements CharacterClassBuilder {
    private CharacterClass characterClass;

    public WizardClassBuilder() {
        this.characterClass = new CharacterClass();
    }

    @Override
    public CharacterClassBuilder buildName() {
        characterClass.setName("Wizard");
        return this;
    }

    @Override
    public CharacterClassBuilder buildStartingHealth() {
        characterClass.setStartingHealth(8);
        return this;
    }

    @Override
    public CharacterClassBuilder buildPrimaryResource(Race race) {
        characterClass.setPrimaryResource(
                new CharacterResource("Mana", 500 + race.getStartingMana()));
        return this;
    }

    @Override
    public CharacterClass getCharacterClass() {
        return characterClass;
    }
}
