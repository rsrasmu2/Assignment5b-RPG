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
        characterClass.setStartingHealth(26);
        return this;
    }


    @Override
    public CharacterClassBuilder buildPrimaryResource(Race race) {
        characterClass.setPrimaryResource(new CharacterResource("Rage", 0, 100));
        return this;
    }

    @Override
    public CharacterClassBuilder buildHealthPerLevel() {
        characterClass.setHealthPerLevel(20);
        return this;
    }

    @Override
    public CharacterClassBuilder buildCombatStatsPerLevel() {
        characterClass.setCombatStatsPerLevel(new CombatStats(10, 12, 4, 7, 0));
        return this;
    }

    @Override
    public CharacterClassBuilder buildStartingAbilities() {
        Ability attack = new Ability("Attack");
        attack.addAction((user, opponent) -> {
            int rageGain = 10;
            int damage = Ability.calculateDamage(
                (int)(user.getCombatStats().getStat(CombatStatType.ATTACK).getValue()),
                opponent.getCombatStats().getStat(CombatStatType.DEFENSE).getValue());
            opponent.getHealth().modifyCurrentValue(-damage);
            user.getPrimaryResource().modifyCurrentValue(rageGain);
            System.out.println(opponent.getName() + " took " + damage + " damage.");
            System.out.println(opponent.getName() + " health - " + opponent.getHealth().toString());
            System.out.println(user.getName() + " built up " + rageGain + " rage.");
            System.out.println(user.getName() + " " + user.getPrimaryResource().toString());
        });
        startingAbilities.add(attack);

        Ability defend = new Ability("Defend");
        defend.addAction((user, opponent) -> {
            user.getCombatStats()
            .getStat(CombatStatType.DEFENSE)
                .addModifier(new MultiplicativeModifier(2.0, 1));
            System.out.println(user.getName() + " entered a defensive stance.");
        });
        startingAbilities.add(defend);

        int rageCost = 20;
        double damageModifier = 1.5;
        Ability powerAttack = new Ability("PowerAttack", rageCost);
        powerAttack.addAction((user, opponent) -> {
            int damage = Ability.calculateDamage(
                (int)(user.getCombatStats().getStat(CombatStatType.ATTACK).getValue()
                    * damageModifier),
                opponent.getCombatStats().getStat(CombatStatType.DEFENSE).getValue());
            opponent.getHealth().modifyCurrentValue(-damage);
            System.out.println(user.getName() + " spent " + rageCost + " rage.");
            System.out.println(user.getName() + " " + user.getPrimaryResource().toString());
            System.out.println(opponent.getName() + " took " + damage + " damage.");
            System.out.println(opponent.getName() + " " + opponent.getHealth().toString());
        });
        startingAbilities.add(powerAttack);

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
