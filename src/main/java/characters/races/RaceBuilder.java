package characters.races;

import characters.stats.CombatStats;

public interface RaceBuilder {
    RaceBuilder buildName();

    RaceBuilder buildStartingHealth();

    RaceBuilder buildStartingMana();

    RaceBuilder modifyCombatStats(CombatStats combatStats);

    Race getRace();
}
