package characters.classes.implementations;

import characters.classes.CharacterClass;
import characters.classes.CharacterClassBuilder;
import characters.races.Race;
import characters.resources.CharacterResource;
import characters.stats.CombatStatType;
import characters.stats.CombatStats;

public class WizardClassBuilder implements CharacterClassBuilder {
    private CharacterClass characterClass;

    public WizardClassBuilder() {
        this.characterClass = new CharacterClass();
    }

    @Override
    public CharacterClassBuilder buildName() {
        characterClass.setName("Wizard");
        return this;
    }

    @Override
    public CharacterClassBuilder buildStartingHealth() {
        characterClass.setStartingHealth(8);
        return this;
    }

    @Override
    public CharacterClassBuilder buildPrimaryResource(Race race) {
        characterClass.setPrimaryResource(
                new CharacterResource("Mana", 500 + race.getStartingMana()));
        return this;
    }

    @Override
    public CharacterClassBuilder buildHealthPerLevel() {
        characterClass.setHealthPerLevel(6);
        return this;
    }

    @Override
    public CharacterClassBuilder modifyCombatStats(CombatStats combatStats) {
        combatStats.getStat(CombatStatType.ATTACK).modifyBaseValue(6);
        combatStats.getStat(CombatStatType.DEFENSE).modifyBaseValue(6);
        combatStats.getStat(CombatStatType.MAGIC_ATTACK).modifyBaseValue(12);
        combatStats.getStat(CombatStatType.MAGIC_DEFENSE).modifyBaseValue(10);
        combatStats.getStat(CombatStatType.EVASION).modifyBaseValue(8);
        return this;
    }

    @Override
    public CharacterClass getCharacterClass() {
        return characterClass;
    }
}
