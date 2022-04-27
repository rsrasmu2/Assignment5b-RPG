package characters.monsters.implementations;

import characters.monsters.Monster;
import characters.monsters.MonsterBuilder;
import characters.resources.CharacterResource;
import characters.stats.CombatStats;
import combat.abilities.Abilities;
import combat.abilities.Ability;
import combat.abilities.monster.AttackAbility;
import combat.abilities.monster.DefendAbility;
import combat.abilities.monster.FireboltAbility;

import java.util.ArrayList;
import java.util.List;

public class ImpMonsterBuilder implements MonsterBuilder {
    private Monster monster;

    public ImpMonsterBuilder() {
        monster = new Monster();
    }

    @Override
    public MonsterBuilder buildName() {
        monster.setName("Imp");
        return this;
    }

    @Override
    public MonsterBuilder buildHealth() {
        monster.setHealth(new CharacterResource("Health", 20));
        return this;
    }

    @Override
    public MonsterBuilder buildAbilities() {
        List<Ability> abilityList = new ArrayList();
        abilityList.add(new AttackAbility());
        abilityList.add(new FireboltAbility());
        monster.setAbilities(new Abilities(abilityList));
        return this;
    }

    @Override
    public MonsterBuilder buildCombatStats() {
        monster.setCombatStats(new CombatStats(22, 18, 25, 20, 35));
        return this;
    }

    @Override
    public MonsterBuilder buildExperience() {
        monster.setExperience(120);
        return this;
    }

    @Override
    public MonsterBuilder buildGold() {
        monster.setGold(8);
        return this;
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
