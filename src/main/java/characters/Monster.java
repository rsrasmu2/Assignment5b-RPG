package characters;

import characters.resources.CharacterResource;
import characters.stats.CombatStats;
import combat.abilities.Abilities;
import combat.abilities.Targettable;

public class Monster implements Targettable {
    private String name;

    private CharacterResource health;
    private CharacterResource primaryResource;

    private CombatStats combatStats;

    private Abilities abilities;

    public Monster(String name, int startingHealth, CombatStats combatStats, Abilities abilities) {
        this.name = name;
        health = new CharacterResource("Health", startingHealth);
        primaryResource = new CharacterResource("None", 0);
        this.combatStats = combatStats;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public CharacterResource getHealth() {
        return health;
    }

    @Override
    public CharacterResource getPrimaryResource() {
        return primaryResource;
    }

    public CombatStats getCombatStats() {
        return combatStats;
    }
}
