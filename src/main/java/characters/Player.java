package characters;

import characters.classes.CharacterClass;
import characters.inventory.Inventory;
import characters.levels.Level;
import characters.levels.LevelObserver;
import characters.races.Race;
import characters.resources.CharacterResource;
import characters.stats.CombatStats;
import combat.abilities.Abilities;
import combat.abilities.Ability;
import combat.abilities.Targettable;
import items.Equipper;

import java.io.BufferedReader;
import java.io.IOException;

public class Player implements Targettable, Equipper, LevelObserver {
    private String name;

    private CharacterResource health;
    private CharacterResource primaryResource;

    private Race race;
    private CharacterClass characterClass;

    private CombatStats combatStats;

    private Level level;

    private Inventory inventory;

    private Abilities abilities;

    /**
     * Creates a new Player character.
     * @param race the race of the character.
     * @param characterClass the class of the character.
     */
    public Player(String name, Race race, CharacterClass characterClass,
                  CombatStats combatStats, Abilities abilities) {
        this.name = name;
        this.race = race;
        this.characterClass = characterClass;
        this.combatStats = combatStats;
        health = new CharacterResource("Health", race.getStartingHealth()
                + characterClass.getStartingHealth());
        primaryResource = characterClass.getPrimaryResource();
        this.level = new Level();
        inventory = new Inventory(this);
        this.abilities = abilities;
    }

    public String getName() {
        return name;
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

    public Level getLevel() {
        return level;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Allows the Player to use an ability based on user input.
     * @param opponent the opposing character.
     * @param reader the BufferedReader used to parse user input.
     * @throws IOException based on user input.
     */
    public void act(Targettable opponent, BufferedReader reader) throws IOException {
        while (true) {
            System.out.println("Choose your ability:");
            for (int i = 0; i < abilities.getAbilities().size(); i++) {
                System.out.println(i + " " + abilities.getAbilities().get(i));
            }
            String input = reader.readLine();
            int intInput = 0;
            try {
                intInput = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Select the number of the ability you wish to use.");
                continue;
            }
            if (intInput < 0 || intInput >= abilities.getAbilities().size()) {
                System.out.println("Select the number of the ability you wish to use.");
                continue;
            }
            Ability ability = abilities.getAbilities().get(intInput);
            if (!ability.canExecute(this)) {
                System.out.println("Not enough " + getPrimaryResource().getName() + ".");
                continue;
            }
            System.out.println("You used " + ability.getName() + ".");
            ability.execute(this, opponent);
            break;
        }
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
