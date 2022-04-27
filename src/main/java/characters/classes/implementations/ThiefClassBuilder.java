package characters.classes.implementations;

import characters.classes.CharacterClass;
import characters.classes.CharacterClassBuilder;
import characters.races.Race;
import characters.resources.CharacterResource;
import characters.stats.CombatStatType;
import characters.stats.CombatStats;
import characters.stats.MultiplicativeModifier;
import combat.abilities.Ability;

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
        characterClass.setStartingHealth(22);
        return this;
    }

    @Override
    public CharacterClassBuilder buildPrimaryResource(Race race) {
        characterClass.setPrimaryResource(new CharacterResource("Energy", 0, 100));
        return this;
    }

    @Override
    public CharacterClassBuilder buildHealthPerLevel() {
        characterClass.setHealthPerLevel(8);
        return this;
    }

    @Override
    public CharacterClassBuilder buildCombatStatsPerLevel() {
        characterClass.setCombatStatsPerLevel(new CombatStats(12, 9, 6, 10, 1));
        return this;
    }

    @Override
    public CharacterClassBuilder buildStartingAbilities() {
        int energyGeneration = 20;

        Ability attack = new Ability("Attack");
        attack.addAction((user, opponent) -> {
            int damage = Ability.calculateDamage(
                    (int)(user.getCombatStats().getStat(CombatStatType.ATTACK).getValue()),
                    opponent.getCombatStats().getStat(CombatStatType.DEFENSE).getValue());
            opponent.getHealth().modifyCurrentValue(-damage);
            System.out.println(opponent.getName() + " took " + damage + " damage.");
            System.out.println(opponent.getName() + " " + opponent.getHealth().toString());
            user.getPrimaryResource().modifyCurrentValue(energyGeneration);
            System.out.println("Generated " + energyGeneration + " energy.");
        });
        startingAbilities.add(attack);

        Ability defend = new Ability("Defend");
        defend.addAction((user, opponent) -> {
            user.getCombatStats().getStat(CombatStatType.DEFENSE)
                .addModifier(new MultiplicativeModifier(2.0, 1));
            System.out.println(user.getName() + " entered a defensive stance.");
            user.getPrimaryResource().modifyCurrentValue(energyGeneration);
            System.out.println("Generated " + energyGeneration + " energy.");
        });
        startingAbilities.add(defend);

        int energyCost = 35;
        double damageModifier = 1.3;
        Ability sneakAttack = new Ability("Sneak Attack", energyCost);
        sneakAttack.addAction((user, opponent) -> {
            int damage = Ability.calculateDamage(
                    (int)(user.getCombatStats()
                            .getStat(CombatStatType.ATTACK).getValue() * damageModifier),
                    opponent.getCombatStats().getStat(CombatStatType.DEFENSE).getValue());
            opponent.getHealth().modifyCurrentValue(-damage);
            System.out.println(user.getName() + " spent " + energyCost + " energy.");
            System.out.println(user.getName() + " " + user.getPrimaryResource().toString());
            System.out.println(opponent.getName() + " took " + damage + " damage.");
            System.out.println(opponent.getName() + " " + opponent.getHealth().toString());
            user.getPrimaryResource().modifyCurrentValue(energyGeneration);
            System.out.println("Generated " + energyGeneration + " energy.");
        });
        startingAbilities.add(sneakAttack);

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
