package characters.monsters.implementations;

import characters.monsters.Monster;
import characters.monsters.MonsterBuilder;
import characters.resources.CharacterResource;
import characters.stats.CombatStats;
import combat.abilities.Abilities;
import combat.abilities.Ability;
import combat.abilities.monster.AttackAbility;
import combat.abilities.monster.DefendAbility;

import java.util.ArrayList;
import java.util.List;

public class SkeletalChampionMonsterBuilder implements MonsterBuilder {
    private Monster monster;

    public SkeletalChampionMonsterBuilder() {
        monster = new Monster();
    }

    @Override
    public MonsterBuilder buildName() {
        monster.setName("Skeletal Champion");
        return this;
    }

    @Override
    public MonsterBuilder buildHealth() {
        monster.setHealth(new CharacterResource("Health", 60));
        return this;
    }

    @Override
    public MonsterBuilder buildAbilities() {
        List<Ability> abilityList = new ArrayList();
        abilityList.add(new AttackAbility());
        monster.setAbilities(new Abilities(abilityList));
        return this;
    }

    @Override
    public MonsterBuilder buildCombatStats() {
        monster.setCombatStats(new CombatStats(32, 25, 5, 25, 15));
        return this;
    }

    @Override
    public MonsterBuilder buildExperience() {
        monster.setExperience(250);
        return this;
    }

    @Override
    public MonsterBuilder buildGold() {
        monster.setGold(24);
        return this;
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
