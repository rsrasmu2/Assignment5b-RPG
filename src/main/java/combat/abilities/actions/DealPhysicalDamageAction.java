package combat.abilities.actions;

import characters.stats.CombatStatType;
import combat.abilities.Targettable;

public class DealPhysicalDamageAction implements Action {
    @Override
    public void execute(Targettable caster, Targettable target) {
        target.getHealth().modifyCurrentValue(-(caster.getCombatStats().getStat(CombatStatType.ATTACK).getValue()
                - target.getCombatStats().getStat(CombatStatType.DEFENSE).getValue()));
    }
}
