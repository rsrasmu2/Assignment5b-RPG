package combat.abilities;

import java.util.ArrayList;
import java.util.List;

public class Abilities {
    private List<Ability> abilities;

    public Abilities() {
        abilities = new ArrayList();
    }

    public void AddAbility(Ability ability) {
        abilities.add(ability);
    }

    public void RemoveAbility(Ability ability) {
        abilities.remove(ability);
    }

    public List<Ability> GetAbilities() {
        return abilities;
    }
}
