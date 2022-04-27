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

public class OwlbearMonsterBuilder implements MonsterBuilder {
    private Monster monster;

    public OwlbearMonsterBuilder() {
        monster = new Monster();
    }

    @Override
    public MonsterBuilder buildName() {
        monster.setName("Owlbear");
        return this;
    }

    @Override
    public MonsterBuilder buildHealth() {
        monster.setHealth(new CharacterResource("Health", 80));
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
        monster.setCombatStats(new CombatStats(40, 38, 15, 30, 5));
        return this;
    }

    @Override
    public MonsterBuilder buildExperience() {
        monster.setExperience(200);
        return this;
    }

    @Override
    public MonsterBuilder buildGold() {
        monster.setGold(12);
        return this;
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
