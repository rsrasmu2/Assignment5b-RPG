package characters.classes;

import characters.races.Race;
import characters.resources.CharacterResource;

public class CharacterClass {
    private CharacterClassType characterClassType;

    private CharacterResource resource;

    public CharacterClass(CharacterClassType characterClassType) {
        this.characterClassType = characterClassType;
    }

    /**
     * Returns the name of the class.
     * @return the name of the class.
     */
    public String getName() {
        switch (characterClassType) {
            case FIGHTER:
                return "Fighter";
            case ROGUE:
                return "Rogue";
            case WIZARD:
                return "Wizard";
            default:
                throw new IllegalStateException("Unexpected value: " + characterClassType);
        }
    }

    /**
     * Returns the starting health of the class.
     * @return the starting health of the class.
     */
    public int getStartingHealth() {
        switch (characterClassType) {
            case FIGHTER:
                return 12;
            case ROGUE:
                return 10;
            case WIZARD:
                return 8;
            default:
                throw new IllegalStateException("Unexpected value: " + characterClassType);
        }
    }

    /**
     * Returns the class's primary resource.
     * @param characterRace the race of the character.
     * @return the class's primary resource.
     */
    public CharacterResource getPrimaryResource(Race characterRace) {
        switch (characterClassType) {
            case FIGHTER:
                return new CharacterResource("Rage", 0, 100);
            case ROGUE:
                return new CharacterResource("Energy", 100);
            case WIZARD:
                return new CharacterResource("Mana", 500 + characterRace.getStartingMana());
            default:
                throw new IllegalStateException("Unexpected value: " + characterRace);
        }
    }
}
