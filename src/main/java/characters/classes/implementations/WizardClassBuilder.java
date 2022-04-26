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

public class WizardClassBuilder implements CharacterClassBuilder {
    private CharacterClass characterClass;

    private List<Ability> startingAbilities;

    public WizardClassBuilder() {
        this.characterClass = new CharacterClass();
        startingAbilities = new ArrayList();
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
    public CharacterClassBuilder buildStartingAbilities() {
        Ability attack = new Ability("Attack");
        attack.addAction((user, opponent) -> {
            int damage = Ability.calculateDamage(
                    (int)(user.getCombatStats().getStat(CombatStatType.ATTACK).getValue()),
                    opponent.getCombatStats().getStat(CombatStatType.DEFENSE).getValue());
            opponent.getHealth().modifyCurrentValue(-damage);
        });
        startingAbilities.add(attack);

        Ability defend = new Ability("Defend");
        defend.addAction((user, opponent) -> { user.getCombatStats().getStat(CombatStatType.DEFENSE)
                .addModifier(new MultiplicativeModifier(2.0, 1));
        });
        startingAbilities.add(defend);

        int manaCost = 100;
        double damageModifier = 1.0;
        Ability magicMissiles = new Ability("Magic Missiles", manaCost);
        magicMissiles.addAction((user, opponent) -> {
            System.out.println(user.getName() + " spent " + manaCost + " mana.");
            System.out.println(user.getName() + " " + user.getPrimaryResource().toString());
            int dartDamage = (int)(user.getCombatStats().getStat(CombatStatType.MAGIC_ATTACK).getValue() * damageModifier);
            for (int i = 0; i < 3; i++) {
                int damage = Ability.calculateDamage(
                        (int)(user.getCombatStats().getStat(CombatStatType.ATTACK).getValue() * damageModifier),
                        opponent.getCombatStats().getStat(CombatStatType.DEFENSE).getValue());
                opponent.getHealth().modifyCurrentValue(-damage);
                System.out.println(opponent.getName() + " took " + damage + " damage.");
            }
            System.out.println(opponent.getName() + " " + opponent.getHealth().toString());
        });
        startingAbilities.add(magicMissiles);

        characterClass.setStartingAbilities(startingAbilities);
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
