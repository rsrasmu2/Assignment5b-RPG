package characters.monsters.implementations;

import characters.monsters.Monster;
import characters.monsters.MonsterBuilder;
import characters.resources.CharacterResource;
import characters.stats.CombatStats;
import combat.abilities.Abilities;
import combat.abilities.Ability;
import combat.abilities.monster.AttackAbility;
import combat.abilities.monster.DeathTouchAbility;
import combat.abilities.monster.DefendAbility;
import combat.abilities.monster.FireBreathAbility;
import combat.abilities.monster.NoxiousBreathAbility;

import java.util.ArrayList;
import java.util.List;

public class ValthraxMonsterBuilder implements MonsterBuilder {
    private Monster monster;

    public ValthraxMonsterBuilder() {
        monster = new Monster();
    }

    @Override
    public MonsterBuilder buildName() {
        monster.setName("Valthrax, King of Dragons");
        return this;
    }

    @Override
    public MonsterBuilder buildHealth() {
        monster.setHealth(new CharacterResource("Health", 500));
        return this;
    }

    @Override
    public MonsterBuilder buildAbilities() {
        List<Ability> abilityList = new ArrayList();
        abilityList.add(new AttackAbility());
        abilityList.add(new DefendAbility());
        abilityList.add(new FireBreathAbility());
        abilityList.add(new NoxiousBreathAbility());
        abilityList.add(new DeathTouchAbility());
        monster.setAbilities(new Abilities(abilityList));
        return this;
    }

    @Override
    public MonsterBuilder buildCombatStats() {
        monster.setCombatStats(new CombatStats(115, 110, 115, 110, 15));
        return this;
    }

    @Override
    public MonsterBuilder buildExperience() {
        monster.setExperience(100);
        return this;
    }

    @Override
    public MonsterBuilder buildGold() {
        monster.setGold(6);
        return this;
    }

    @Override
    public Monster getMonster() {
        return monster;
    }
}
