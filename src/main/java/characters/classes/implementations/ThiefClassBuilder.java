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
        attack.addAction((user, target) -> {
            int damage = Combat.calculateDamageRange(user.getCombatStats().getStat(CombatStatType.ATTACK).getValue());
            damage -= target.getCombatStats().getStat(CombatStatType.DEFENSE).getValue();
            target.getHealth().modifyCurrentValue(-damage);
        });
        startingAbilities.add(attack);

        Ability defend = new Ability("Defend");
        defend.addAction((user, target) -> {
            target.getCombatStats().getStat(CombatStatType.DEFENSE)
                .addModifier(new MultiplicativeModifier(2.0, 1));
        });
        startingAbilities.add(defend);

        Ability sneakAttack = new Ability("Sneak Attack", 25);
        sneakAttack.addAction((user, target) -> {
            int damage = Combat.calculateDamageRange(user.getCombatStats().getStat(CombatStatType.ATTACK).getValue() * 2);
            damage -= target.getCombatStats().getStat(CombatStatType.DEFENSE).getValue();
            target.getHealth().modifyCurrentValue(-damage);
        });

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
