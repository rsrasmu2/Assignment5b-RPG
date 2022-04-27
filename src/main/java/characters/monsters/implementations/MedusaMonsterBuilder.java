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

public class MedusaMonsterBuilder implements MonsterBuilder {
    private Monster monster;

    public MedusaMonsterBuilder() {
        monster = new Monster();
    }

    @Override
    public MonsterBuilder buildName() {
        monster.setName("Medusa");
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
        abilityList.add(new NoxiousBreathAbility());
        monster.setAbilities(new Abilities(abilityList));
        return this;
    }

    @Override
    public MonsterBuilder buildCombatStats() {
        monster.setCombatStats(new CombatStats(50, 50, 65, 60, 20));
        return this;
    }

    @Override
    public MonsterBuilder buildExperience() {
        monster.setExperience(380);
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
