package characters.classes;

import characters.races.Race;
import characters.stats.CombatStats;

public interface CharacterClassBuilder {
    CharacterClassBuilder buildName();

    CharacterClassBuilder buildStartingHealth();

    CharacterClassBuilder buildPrimaryResource(Race race);

    CharacterClassBuilder buildHealthPerLevel();

    CharacterClassBuilder buildCombatStatsPerLevel();

    CharacterClassBuilder buildStartingAbilities();

    CharacterClassBuilder modifyCombatStats(CombatStats combatStats);

    CharacterClass getCharacterClass();
}
