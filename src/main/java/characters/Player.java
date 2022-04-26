package characters;

import characters.classes.CharacterClass;
import characters.inventory.Inventory;
import characters.levels.LevelObserver;
import characters.races.Race;
import characters.resources.CharacterResource;
import characters.stats.CombatStats;
import combat.abilities.Abilities;
import combat.abilities.Targettable;
import items.Equipper;

public class Player implements Targettable, Equipper, LevelObserver {
    private CharacterResource health;
    private CharacterResource primaryResource;

    private Race race;
    private CharacterClass characterClass;

    private CombatStats combatStats;

    private Inventory inventory;

    private Abilities abilities;

    /**
     * Creates a new Player character.
     * @param race the race of the character.
     * @param characterClass the class of the character.
     */
    public Player(Race race, CharacterClass characterClass,
                  CombatStats combatStats, Abilities abilities) {
        this.race = race;
        this.characterClass = characterClass;
        this.combatStats = combatStats;
        health = new CharacterResource("Health", race.getStartingHealth()
                + characterClass.getStartingHealth());
        primaryResource = characterClass.getPrimaryResource();
        inventory = new Inventory(this);
        this.abilities = abilities;
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

    public Abilities getAbilities() {
        return abilities;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void tick() {
        combatStats.tick();
    }

    @Override
    public void leveledUp(int newLevel) {
        health.modifyMaxValue(characterClass.getHealthPerLevel());
        health.modifyCurrentValue(characterClass.getHealthPerLevel());
    }

    @Override
    public void experienceModified(int newValue) {}

    @Override
    public void nextLevelExperienceModified(int newValue) {}
}
