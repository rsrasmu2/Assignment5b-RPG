package combat.abilities.actions;

import combat.abilities.Targettable;

public interface Action {
    void execute(Targettable caster, Targettable target);
}
