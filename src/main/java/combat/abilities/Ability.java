package combat.abilities;

import characters.resources.CharacterResource;

import java.util.ArrayList;
import java.util.List;

public class Ability {
    private String name;

    int cost;
    private List<AbilityAction> actions;

    public Ability(String name) {
        this.name = name;
        actions = new ArrayList();
        cost = 0;
    }

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

    /**
     * Attempts to execute the given Ability.
     * @param user the character using the ability.
     * @param target the target of the ability.
     * @return whether the ability was used successfully or not.
     */
    public boolean execute(Targettable user, Targettable target) {
        if (user.getPrimaryResource().getCurrentValue() < cost) {
            return false;
        }
        user.getPrimaryResource().modifyCurrentValue(-cost);
        for (AbilityAction action : actions) {
            action.execute(user, target);
        }
        return true;
    }
}
