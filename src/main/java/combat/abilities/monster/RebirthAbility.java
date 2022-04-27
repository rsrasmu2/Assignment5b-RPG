package combat.abilities.monster;

import combat.abilities.Ability;

public class RebirthAbility extends Ability {
    /**
     * Creates a new Rebirth ability
     */
    public RebirthAbility() {
        super("Rebirth");
        addAction(((user, opponent) -> { user.getHealth().modifyCurrentValue(100);
            System.out.println(user.getName() + " heals its wounds.");
        }));
    }
}
