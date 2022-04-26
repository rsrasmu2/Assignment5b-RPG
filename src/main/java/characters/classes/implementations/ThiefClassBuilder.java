package characters.classes.implementations;

import characters.classes.CharacterClass;
import characters.classes.CharacterClassBuilder;
import characters.races.Race;
import characters.resources.CharacterResource;
import characters.stats.CombatStatType;
import characters.stats.CombatStats;
import combat.abilities.Ability;
import combat.abilities.Targettable;
import combat.abilities.AbilityAction;

import java.util.ArrayList;
import java.util.List;

public class ThiefClassBuilder implements CharacterClassBuilder {
    private CharacterClass characterClass;

    private List<Ability> startingAbilities;

    public ThiefClassBuilder() {
        this.characterClass = new CharacterClass();
        startingAbilities = new ArrayList();
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
    public CharacterClassBuilder buildStartingAbilities() {
        Ability attack = new Ability("Attack");
        attack.addAction(new AbilityAction() {
            @Override
            public void execute(Targettable caster, Targettable target) {
                int damage = caster.getCombatStats().getStat(CombatStatType.ATTACK).getValue()
                        - target.getCombatStats().getStat(CombatStatType.DEFENSE).getValue();
                target.getHealth().modifyCurrentValue(-damage);
            }
        });
        startingAbilities.add(attack);

        characterClass.setStartingAbilities(startingAbilities);
        return this;
    }

    @Override
    public CharacterClassBuilder modifyCombatStats(CombatStats combatStats) {
        combatStats.getStat(CombatStatType.ATTACK).modifyBaseValue(12);
        combatStats.getStat(CombatStatType.DEFENSE).modifyBaseValue(8);
        combatStats.getStat(CombatStatType.MAGIC_ATTACK).modifyBaseValue(6);
        combatStats.getStat(CombatStatType.MAGIC_DEFENSE).modifyBaseValue(8);
        combatStats.getStat(CombatStatType.EVASION).modifyBaseValue(10);
        return this;
    }

    @Override
    public CharacterClass getCharacterClass() {
        return characterClass;
    }
}
