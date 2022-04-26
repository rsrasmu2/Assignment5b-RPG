package characters.classes.implementations;

import characters.classes.CharacterClass;
import characters.classes.CharacterClassBuilder;
import characters.races.Race;
import characters.resources.CharacterResource;
import characters.stats.CombatStats;

public class ThiefClassBuilder implements CharacterClassBuilder {
    private CharacterClass characterClass;

    public ThiefClassBuilder() {
        this.characterClass = new CharacterClass();
    }

    @Override
    public CharacterClassBuilder buildName() {
        characterClass.setName("Thief");
        return this;
    }

    @Override
    public CharacterClassBuilder buildStartingHealth() {
        characterClass.setStartingHealth(10);
        return this;
    }

    @Override
    public CharacterClassBuilder buildPrimaryResource(Race race) {
        characterClass.setPrimaryResource(new CharacterResource("Energy", 100));
        return this;
    }

    @Override
    public CharacterClassBuilder buildHealthPerLevel() {
        characterClass.setHealthPerLevel(8);
        return this;
    }

    @Override
    public CharacterClassBuilder modifyCombatStats(CombatStats combatStats) {
        combatStats.setAttack(combatStats.getAttack() + 12);
        combatStats.setDefense(combatStats.getDefense() + 8);
        combatStats.setMagicAttack(combatStats.getMagicAttack() + 6);
        combatStats.setMagicDefense(combatStats.getMagicDefense() + 8);
        combatStats.setEvasion(combatStats.getEvasion() + 10);
        return this;
    }

    @Override
    public CharacterClass getCharacterClass() {
        return characterClass;
    }
}
