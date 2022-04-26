package characters.races;

import characters.classes.CharacterClassBuilder;
import characters.stats.CombatStats;

public interface RaceBuilder {
    RaceBuilder buildName();

    RaceBuilder buildStartingHealth();

    RaceBuilder buildStartingMana();

    RaceBuilder modifyCombatStats(CombatStats combatStats);

    Race getRace();
}
