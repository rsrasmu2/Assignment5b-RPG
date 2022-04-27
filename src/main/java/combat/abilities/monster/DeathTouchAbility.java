package combat.abilities.monster;

import characters.stats.CombatStatType;
import combat.Combat;
import combat.abilities.Ability;

public class DeathTouchAbility extends Ability {
    /**
     * Creates a new Death Touch Ability
     */
    public DeathTouchAbility() {
        super("Death Touch");
        addAction(((user, opponent) -> {
            int damage = Combat.calculateDamageRange(user.getCombatStats().getStat(CombatStatType.MAGIC_ATTACK).getValue());
            damage -= opponent.getCombatStats().getStat(CombatStatType.MAGIC_DEFENSE).getValue();
            damage = Math.max(0, damage);
            opponent.getHealth().modifyCurrentValue(-damage);
            System.out.println(opponent.getName() + " took " + damage + " damage.");
            System.out.println(opponent.getName() + " " + opponent.getHealth().toString());
            opponent.getPrimaryResource().modifyCurrentValue(-20);
            System.out.println(opponent.getName() + " had their " + opponent.getPrimaryResource().getName() + " reduced.");
        }));
    }
}
