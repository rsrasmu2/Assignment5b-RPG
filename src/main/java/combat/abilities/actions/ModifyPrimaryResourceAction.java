package combat.abilities.actions;

import combat.abilities.Targettable;

public class ModifyPrimaryResourceAction implements Action {
    private int amount;

    public ModifyPrimaryResourceAction(int amount) {
        this.amount = amount;
    }

    @Override
    public void execute(Targettable caster, Targettable target) {
        target.getPrimaryResource().modifyCurrentValue(amount);
    }
}
