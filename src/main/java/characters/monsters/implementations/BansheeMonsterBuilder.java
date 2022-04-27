package characters.monsters.implementations;

import characters.monsters.Monster;
import characters.monsters.MonsterBuilder;
import characters.resources.CharacterResource;
import characters.stats.CombatStats;
import combat.abilities.Abilities;
import combat.abilities.Ability;
import combat.abilities.monster.AttackAbility;
import combat.abilities.monster.DefendAbility;
import combat.abilities.monster.HowlAbility;
import combat.abilities.monster.RebirthAbility;

import java.util.ArrayList;
import java.util.List;

public class BansheeMonsterBuilder implements MonsterBuilder {
    private Monster monster;

    public BansheeMonsterBuilder() {
        monster = new Monster();
    }

    @Override
    public MonsterBuilder buildName() {
        monster.setName("Banshee");
        return this;
    }

    @Override
    public MonsterBuilder buildHealth() {
        monster.setHealth(new CharacterResource("Health", 160));
        return this;
    }

    @Override
    public MonsterBuilder buildAbilities() {
        List<Ability> abilityList = new ArrayList();
        abilityList.add(new AttackAbility());
        abilityList.add(new DefendAbility());
        abilityList.add(new HowlAbility());
        monster.setAbilities(new Abilities(abilityList));
        return this;
    }

    @Override
    public MonsterBuilder buildCombatStats() {
        monster.setCombatStats(new CombatStats(90, 90, 100, 100, 10));
        return this;
    }

    @Override
    public MonsterBuilder buildExperience() {
        monster.setExperience(760);
        return this;
    }

    @Override
    public MonsterBuilder buildGold() {
        monster.setGold(54);
        return this;
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
