package combat.abilities;

import characters.stats.CombatStatType;
import combat.Combat;

import java.util.ArrayList;
import java.util.List;

public class Ability {
    private String name;

    int cost;
    private List<AbilityAction> actions;

    /**
     * Creates a new Ability with no cost.
     * @param name the name of the ability.
     */
    public Ability(String name) {
        this.name = name;
        actions = new ArrayList();
        cost = 0;
    }

    /**
     * Creates a new Ability.
     * @param name the name of the ability.
     * @param cost the CharacterResource cost of the ability.
     */
    public Ability(String name, int cost) {
        this.name = name;
        actions = new ArrayList();
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public Ability addAction(AbilityAction action) {
        actions.add(action);
        return this;
    }

    public boolean canExecute(Targettable user) {
        return user.getPrimaryResource().getCurrentValue() >= cost;
    }

    /**
     * Attempts to execute the given Ability.
     * @param user the character using the ability.
     * @param opponent the combat opponent.
     * @return whether the ability was used successfully or not.
     */
    public boolean execute(Targettable user, Targettable opponent) {
        if (user.getPrimaryResource().getCurrentValue() < cost) {
            return false;
        }
        user.getPrimaryResource().modifyCurrentValue(-cost);
        for (AbilityAction action : actions) {
            action.execute(user, opponent);
        }
        return true;
    }

    public static int calculateDamage(int baseDamage, int baseDefense) {
        int damage = Combat.calculateDamageRange(baseDamage) - baseDefense;
        return (int)Math.max(0, damage);
    }

    @Override
    public String toString() {
        String ret = name;
        if (cost != 0) {
            ret += " Cost: " + cost;
        }
        ret += ".";
        return ret;
    }
}
