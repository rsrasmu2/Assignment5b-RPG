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

public class KoboldMonsterBuilder implements MonsterBuilder {
    private Monster monster;

    public KoboldMonsterBuilder() {
        monster = new Monster();
    }

    @Override
    public MonsterBuilder buildName() {
        monster.setName("Kobold");
        return this;
    }

    @Override
    public MonsterBuilder buildHealth() {
        monster.setHealth(new CharacterResource("Health", 45));
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
        monster.setCombatStats(new CombatStats(22, 20, 8, 25, 15));
        return this;
    }

    @Override
    public MonsterBuilder buildExperience() {
        monster.setExperience(85);
        return this;
    }

    @Override
    public MonsterBuilder buildGold() {
        monster.setGold(10);
        return this;
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
