package characters;

import characters.classes.CharacterClass;
import characters.races.Race;
import characters.resources.CharacterResource;
import characters.stats.CombatStats;
import combat.abilities.Targettable;

public class Player implements Targettable {
    private CharacterResource health;
    private CharacterResource primaryResource;

    private Race race;
    private CharacterClass characterClass;

    private CombatStats combatStats;

    /**
     * Creates a new Player character.
     * @param race the race of the character.
     * @param characterClass the class of the character.
     */
    public Player(Race race, CharacterClass characterClass, CombatStats combatStats) {
        this.race = race;
        this.characterClass = characterClass;
        this.combatStats = combatStats;
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

    public CombatStats getCombatStats() {
        return combatStats;
    }
}
