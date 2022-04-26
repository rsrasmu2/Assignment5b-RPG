package combat.abilities;

import combat.abilities.actions.Action;

import java.util.ArrayList;
import java.util.List;

public abstract class Ability {
    private String name;

    private List<Action> actions;

    public Ability(String name) {
        this.name = name;
        actions = new ArrayList();
    }

    protected Ability addAction(Action action) {
        actions.add(action);
        return this;
    }

    public void execute(Targettable caster, Targettable target) {
        for (Action action : actions) {
            action.execute(caster, target);
        }
    }
}
