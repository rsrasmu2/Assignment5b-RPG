package combat.abilities;

import java.util.ArrayList;
import java.util.List;

public class Ability {
    private String name;

    private List<AbilityAction> actions;

    public Ability(String name) {
        this.name = name;
        actions = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public Ability addAction(AbilityAction action) {
        actions.add(action);
        return this;
    }

    /**
     * Executes the ability.
     * @param caster the character using the ability.
     * @param target the target of the ability.
     */
    public void execute(Targettable caster, Targettable target) {
        for (AbilityAction action : actions) {
            action.execute(caster, target);
        }
    }
}
