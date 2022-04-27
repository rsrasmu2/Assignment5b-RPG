package characters.monsters.implementations;

import characters.monsters.Monster;
import characters.monsters.MonsterBuilder;
import characters.resources.CharacterResource;
import characters.stats.CombatStats;
import combat.abilities.Abilities;
import combat.abilities.Ability;
import combat.abilities.monster.AttackAbility;
import combat.abilities.monster.DefendAbility;
import combat.abilities.monster.NoxiousBreathAbility;

import java.util.ArrayList;
import java.util.List;

public class XornMonsterBuilder  implements MonsterBuilder {
    private Monster monster;

    public XornMonsterBuilder() {
        monster = new Monster();
    }

    @Override
    public MonsterBuilder buildName() {
        monster.setName("Xorn");
        return this;
    }

    @Override
    public MonsterBuilder buildHealth() {
        monster.setHealth(new CharacterResource("Health", 75));
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
        monster.setCombatStats(new CombatStats(55, 50, 40, 50, 10));
        return this;
    }

    @Override
    public MonsterBuilder buildExperience() {
        monster.setExperience(420);
        return this;
    }

    @Override
    public MonsterBuilder buildGold() {
        monster.setGold(58);
        return this;
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}