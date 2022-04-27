package characters.monsters.implementations;

import characters.monsters.Monster;
import characters.monsters.MonsterBuilder;
import characters.resources.CharacterResource;
import characters.stats.CombatStats;
import combat.abilities.Abilities;
import combat.abilities.Ability;
import combat.abilities.monster.AttackAbility;
import combat.abilities.monster.DefendAbility;
import combat.abilities.monster.FireBreathAbility;
import combat.abilities.monster.StrengthenAbility;

import java.util.ArrayList;
import java.util.List;

public class ElderDragonMonsterBuilder implements MonsterBuilder {
    private Monster monster;

    public ElderDragonMonsterBuilder() {
        monster = new Monster();
    }

    @Override
    public MonsterBuilder buildName() {
        monster.setName("Elder Dragon");
        return this;
    }

    @Override
    public MonsterBuilder buildHealth() {
        monster.setHealth(new CharacterResource("Health", 200));
        return this;
    }

    @Override
    public MonsterBuilder buildAbilities() {
        List<Ability> abilityList = new ArrayList();
        abilityList.add(new AttackAbility());
        abilityList.add(new DefendAbility());
        abilityList.add(new FireBreathAbility());
        monster.setAbilities(new Abilities(abilityList));
        return this;
    }

    @Override
    public MonsterBuilder buildCombatStats() {
        monster.setCombatStats(new CombatStats(100, 110, 100, 100, 15));
        return this;
    }

    @Override
    public MonsterBuilder buildExperience() {
        monster.setExperience(800);
        return this;
    }

    @Override
    public MonsterBuilder buildGold() {
        monster.setGold(75);
        return this;
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
