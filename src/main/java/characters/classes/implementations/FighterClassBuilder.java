package characters.classes.implementations;

import characters.classes.CharacterClass;
import characters.classes.CharacterClassBuilder;
import characters.races.Race;
import characters.resources.CharacterResource;
import characters.stats.CombatStatType;
import characters.stats.CombatStats;
import characters.stats.MultiplicativeModifier;
import combat.Combat;
import combat.abilities.Ability;
import combat.abilities.Targettable;
import combat.abilities.AbilityAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FighterClassBuilder implements CharacterClassBuilder {
    private CharacterClass characterClass;

    private List<Ability> startingAbilities;

    public FighterClassBuilder() {
        this.characterClass = new CharacterClass();
        startingAbilities = new ArrayList();
    }

    @Override
    public CharacterClassBuilder buildName() {
        characterClass.setName("Fighter");
        return this;
    }

    @Override
    public CharacterClassBuilder buildStartingHealth() {
        characterClass.setStartingHealth(12);
        return this;
    }


    @Override
    public CharacterClassBuilder buildPrimaryResource(Race race) {
        characterClass.setPrimaryResource(new CharacterResource("Rage", 0, 100));
        return this;
    }

    @Override
    public CharacterClassBuilder buildHealthPerLevel() {
        characterClass.setHealthPerLevel(10);
        return this;
    }

    @Override
    public CharacterClassBuilder buildStartingAbilities() {
        Ability attack = new Ability("Attack");
        attack.addAction(new AbilityAction() {
            @Override
            public void execute(Targettable caster, Targettable target) {
                int damage = Combat.calculateDamageRange(caster.getCombatStats().getStat(CombatStatType.ATTACK).getValue());
                damage -= target.getCombatStats().getStat(CombatStatType.DEFENSE).getValue();
                target.getHealth().modifyCurrentValue(-damage);
                caster.getPrimaryResource().modifyCurrentValue(damage);
            }
        });
        startingAbilities.add(attack);

        Ability defend = new Ability("Defend");
        defend.addAction(new AbilityAction() {
            @Override
            public void execute(Targettable caster, Targettable target) {
                target.getCombatStats().getStat(CombatStatType.DEFENSE)
                        .addModifier(new MultiplicativeModifier(2.0, 1));
            }
        });
        startingAbilities.add(defend);

        characterClass.setStartingAbilities(startingAbilities);
        return this;
    }

    @Override
    public CharacterClassBuilder modifyCombatStats(CombatStats combatStats) {
        combatStats.getStat(CombatStatType.ATTACK).modifyBaseValue(10);
        combatStats.getStat(CombatStatType.DEFENSE).modifyBaseValue(10);
        combatStats.getStat(CombatStatType.MAGIC_ATTACK).modifyBaseValue(4);
        combatStats.getStat(CombatStatType.MAGIC_DEFENSE).modifyBaseValue(6);
        combatStats.getStat(CombatStatType.EVASION).modifyBaseValue(8);
        return this;
    }

    @Override
    public CharacterClass getCharacterClass() {
        return characterClass;
    }
}
