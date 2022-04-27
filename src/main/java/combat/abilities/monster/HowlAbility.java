package combat.abilities.monster;

import characters.stats.CombatStatType;
import combat.Combat;
import combat.abilities.Ability;

public class HowlAbility extends Ability {
    /**
     * Creates a new Howl Ability.
     */
    public HowlAbility() {
        super("Firebolt");
        addAction(((user, opponent) -> {
            int damage = Combat.calculateDamageRange(user.getCombatStats()
                    .getStat(CombatStatType.MAGIC_ATTACK).getValue());
            damage -= opponent.getCombatStats().getStat(CombatStatType.MAGIC_DEFENSE).getValue();
            damage = Math.max(0, damage);
            opponent.getHealth().modifyCurrentValue(-damage);
            System.out.println(opponent.getName() + " took " + damage + " damage.");
            System.out.println(opponent.getName() + " " + opponent.getHealth().toString());
        }));
    }
}
