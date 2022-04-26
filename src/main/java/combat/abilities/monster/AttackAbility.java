package combat.abilities.monster;

import characters.stats.CombatStatType;
import combat.Combat;
import combat.abilities.Ability;

public class AttackAbility extends Ability {
    /**
     * Creates a new AttackAbility
     */
    public AttackAbility() {
        super("Attack");
        addAction(((user, opponent) -> {
            int damage = Combat.calculateDamageRange(user.getCombatStats().getStat(CombatStatType.ATTACK).getValue());
            damage -= opponent.getCombatStats().getStat(CombatStatType.DEFENSE).getValue();
            damage = Math.max(0, damage);
            opponent.getHealth().modifyCurrentValue(-damage);
            System.out.println(opponent.getName() + " took " + damage + " damage.");
            System.out.println(opponent.getName() + " " + opponent.getHealth().toString());
        }));
    }
}
