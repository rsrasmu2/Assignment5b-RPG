package combat.abilities.monster;

import characters.stats.CombatStatType;
import characters.stats.MultiplicativeModifier;
import combat.abilities.Ability;

public class StrengthenAbility extends Ability {
    /**
     * Creates a new Strengthen ability
     */
    public StrengthenAbility() {
        super("Strengthen");
        addAction(((user, opponent) -> { user.getCombatStats().getStat(CombatStatType.ATTACK)
                .addModifier(new MultiplicativeModifier(1.2, 2));
            System.out.println(user.getName() + " becomes more powerful.");
        }));
    }
}
