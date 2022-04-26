package characters.classes.implementations;

import characters.classes.CharacterClass;
import characters.classes.CharacterClassBuilder;
import characters.races.Race;
import characters.resources.CharacterResource;
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
        combatStats.setAttack(combatStats.getAttack() + 6);
        combatStats.setDefense(combatStats.getDefense() + 6);
        combatStats.setMagicAttack(combatStats.getMagicAttack() + 12);
        combatStats.setMagicDefense(combatStats.getMagicDefense() + 10);
        combatStats.setEvasion(combatStats.getEvasion() + 8);
        return this;
    }

    @Override
    public CharacterClass getCharacterClass() {
        return characterClass;
    }
}
