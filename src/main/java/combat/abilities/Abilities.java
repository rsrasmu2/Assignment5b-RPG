package combat.abilities;

import java.util.ArrayList;
import java.util.List;

public class Abilities {
    private List<Ability> abilities;

    public Abilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

    public void removeAbility(Ability ability) {
        abilities.remove(ability);
    }

    public List<Ability> getAbilities() {
        return abilities;
    }
}
