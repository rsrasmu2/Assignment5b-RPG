package combat.abilities.monster;

import characters.stats.CombatStatType;
import characters.stats.MultiplicativeModifier;
import combat.abilities.Ability;

public class DefendAbility extends Ability {
    /**
     * Creates a new Defend ability
     */
    public DefendAbility() {
        super("Defend");
        addAction(((user, opponent) -> { user.getCombatStats().getStat(CombatStatType.DEFENSE)
                .addModifier(new MultiplicativeModifier(2.0, 1));
            System.out.println(user.getName() + " entered a defensive stance.");
        }));
    }
}
