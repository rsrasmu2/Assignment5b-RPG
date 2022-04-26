package combat.abilities;

import combat.abilities.Targettable;

public interface AbilityAction {
    void execute(Targettable caster, Targettable target);
}
