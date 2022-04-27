package combat.abilities.monster;

import characters.stats.AdditiveModifier;
import characters.stats.CombatStatType;
import combat.Combat;
import combat.abilities.Ability;

public class FreezingBreathAbility extends Ability {
    /**
     * Creates a new Freezing Breath Ability.
     */
    public FreezingBreathAbility() {
        super("Freezing Breath");
        addAction(((user, opponent) -> {
            int damage = Combat.calculateDamageRange(user.getCombatStats()
                    .getStat(CombatStatType.MAGIC_ATTACK).getValue());
            damage -= opponent.getCombatStats().getStat(CombatStatType.MAGIC_DEFENSE).getValue();
            damage = Math.max(0, damage);
            opponent.getHealth().modifyCurrentValue(-damage);
            opponent.getCombatStats().getStat(CombatStatType.EVASION)
                    .addModifier(new AdditiveModifier(-5, 2));
            System.out.println(opponent.getName() + " took " + damage + " damage.");
            System.out.println(opponent.getName() + " " + opponent.getHealth().toString());
            System.out.println(opponent.getName() + " suffers from lowered evasion.");
        }));
    }
}
