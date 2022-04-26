package combat.abilities;

import characters.resources.CharacterResource;
import characters.stats.CombatStats;

public interface Targettable {
    CharacterResource getHealth();

    CharacterResource getPrimaryResource();

    CombatStats getCombatStats();
}
