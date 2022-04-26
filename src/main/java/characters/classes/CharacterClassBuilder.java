package characters.classes;

import characters.races.Race;
import characters.stats.CombatStats;

public interface CharacterClassBuilder {
    CharacterClassBuilder buildName();

    CharacterClassBuilder buildStartingHealth();

    CharacterClassBuilder buildPrimaryResource(Race race);

    CharacterClassBuilder buildHealthPerLevel();

    CharacterClassBuilder modifyCombatStats(CombatStats combatStats);

    CharacterClassBuilder buildAbilities();

    CharacterClass getCharacterClass();
}
