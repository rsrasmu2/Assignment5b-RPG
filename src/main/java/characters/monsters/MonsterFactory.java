package characters.monsters;

import characters.monsters.implementations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterFactory {
    private List<MonsterBuilder>[] monstersPerLevel;
    private Random rand;

    public static final int FLOORS = 5;

    public MonsterFactory() {
        rand = new Random();
        monstersPerLevel = new ArrayList[FLOORS];
        monstersPerLevel[0] = getFloorOneMonsters();
        monstersPerLevel[1] = getFloorTwoMonsters();
        monstersPerLevel[2] = getFloorThreeMonsters();
        monstersPerLevel[3] = getFloorFourMonsters();
        monstersPerLevel[4] = getFloorFiveMonsters();
    }

    public Monster getMonster(int floor) {
        MonsterBuilder monsterBuilder = monstersPerLevel[floor - 1]
                .get(rand.nextInt(monstersPerLevel[floor - 1].size()));
        return monsterBuilder
                .buildName()
                .buildHealth()
                .buildCombatStats()
                .buildAbilities()
                .getMonster();
    }

    private List<MonsterBuilder> getFloorOneMonsters() {
        List<MonsterBuilder> monsters = new ArrayList();
        monsters.add(new GoblinMonsterBuilder());
        monsters.add(new ZombieMonsterBuilder());
        monsters.add(new ImpMonsterBuilder());
        monsters.add(new KoboldMonsterBuilder());
        monsters.add(new SlimeMonsterBuilder());
        return monsters;
    }

    private List<MonsterBuilder> getFloorTwoMonsters() {
        List<MonsterBuilder> monsters = new ArrayList();
        monsters.add(new GoblinMonsterBuilder());
        return monsters;
    }

    private List<MonsterBuilder> getFloorThreeMonsters() {
        List<MonsterBuilder> monsters = new ArrayList();
        monsters.add(new GoblinMonsterBuilder());
        return monsters;
    }

    private List<MonsterBuilder> getFloorFourMonsters() {
        List<MonsterBuilder> monsters = new ArrayList();
        monsters.add(new GoblinMonsterBuilder());
        return monsters;
    }

    private List<MonsterBuilder> getFloorFiveMonsters() {
        List<MonsterBuilder> monsters = new ArrayList();
        monsters.add(new GoblinMonsterBuilder());
        return monsters;
    }
}
