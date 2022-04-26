package characters.monsters;

import characters.resources.CharacterResource;
import characters.stats.CombatStats;
import combat.abilities.Abilities;
import combat.abilities.Ability;
import combat.abilities.Targettable;

import java.util.Random;

public class Monster implements Targettable {
    private String name;

    private CharacterResource health;
    private CharacterResource primaryResource;

    private CombatStats combatStats;

    private Abilities abilities;

    private Random rand;

    public Monster() {
        primaryResource = new CharacterResource("None", 0);
        rand = new Random();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterResource getHealth() {
        return health;
    }

    public void setHealth(CharacterResource health) {
        this.health = health;
    }

    @Override
    public CharacterResource getPrimaryResource() {
        return primaryResource;
    }

    public CombatStats getCombatStats() {
        return combatStats;
    }

    public void setCombatStats(CombatStats combatStats) {
        this.combatStats = combatStats;
    }

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    /**
     * Allows the Monster to use an ability.
     * @param opponent the opposing character.
     */
    public void act(Targettable opponent) {
        Ability abilityToUse = abilities.getAbilities()
                .get(rand.nextInt(abilities.getAbilities().size()));
        System.out.println("The monster used " + abilityToUse.getName());
        abilityToUse.execute(this, opponent);
    }

    public void tick() {
        combatStats.tick();
    }
}
