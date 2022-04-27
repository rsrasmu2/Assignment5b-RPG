package characters.monsters;

// There are far too many monsters to list out individually
import characters.monsters.implementations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterFactory {
    private List<MonsterBuilder>[] monstersPerLevel;
    private Random rand;

    public static final int FLOORS = 5;

    /**
     * Creates a new Factory for Monster creation.
     */
    public MonsterFactory() {
        rand = new Random();
        monstersPerLevel = new ArrayList[FLOORS];
        monstersPerLevel[0] = getFloorOneMonsters();
        monstersPerLevel[1] = getFloorTwoMonsters();
        monstersPerLevel[2] = getFloorThreeMonsters();
        monstersPerLevel[3] = getFloorFourMonsters();
        monstersPerLevel[4] = getFloorFiveMonsters();
    }

    /**
     * Returns a random monster appropriate for the floor.
     * @param floor the floor the monster is on.
     * @return the monster.
     */
    public Monster getMonster(int floor) {
        MonsterBuilder monsterBuilder = monstersPerLevel[floor - 1]
                .get(rand.nextInt(monstersPerLevel[floor - 1].size()));
        return monsterBuilder
                .buildName()
                .buildHealth()
                .buildCombatStats()
                .buildAbilities()
                .buildExperience()
                .buildGold()
                .getMonster();
    }

    /**
     * Returns the boss monster guarding the given floor.
     * @param floor the floor that the boss is on.
     * @return the boss.
     */
    public Monster getBoss(int floor) {
        MonsterBuilder monsterBuilder = null;
        switch (floor) {
            case 1:
                monsterBuilder = new SkeletalChampionMonsterBuilder();
                break;
            case 2:
                monsterBuilder = new HarpyMonsterBuilder();
                break;
            case 3:
                monsterBuilder = new SphinxMonsterBuilder();
                break;
            case 4:
                monsterBuilder = new HurricaneElementalMonsterBuilder();
                break;
            case 5:
                monsterBuilder = new ValthraxMonsterBuilder();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + floor);
        }

        return monsterBuilder
                .buildName()
                .buildHealth()
                .buildCombatStats()
                .buildAbilities()
                .buildExperience()
                .buildGold()
                .getMonster();
    }

    private List<MonsterBuilder> getFloorOneMonsters() {
        List<MonsterBuilder> monsters = new ArrayList();
        monsters.add(new GoblinMonsterBuilder());
        monsters.add(new ImpMonsterBuilder());
        monsters.add(new KoboldMonsterBuilder());
        monsters.add(new SlimeMonsterBuilder());
        monsters.add(new ZombieMonsterBuilder());
        return monsters;
    }

    private List<MonsterBuilder> getFloorTwoMonsters() {
        List<MonsterBuilder> monsters = new ArrayList();
        monsters.add(new GargoyleMonsterBuilder());
        monsters.add(new HobgoblinMonsterBuilder());
        monsters.add(new MimicMonsterBuilder());
        monsters.add(new MinotaurMonsterBuilder());
        monsters.add(new OwlbearMonsterBuilder());
        return monsters;
    }

    private List<MonsterBuilder> getFloorThreeMonsters() {
        List<MonsterBuilder> monsters = new ArrayList();
        monsters.add(new ChimeraMonsterBuilder());
        monsters.add(new FrostDrakeMonsterBuilder());
        monsters.add(new MedusaMonsterBuilder());
        monsters.add(new StoneGiantMonsterBuilder());
        monsters.add(new XornMonsterBuilder());
        return monsters;
    }

    private List<MonsterBuilder> getFloorFourMonsters() {
        List<MonsterBuilder> monsters = new ArrayList();
        monsters.add(new CyclopseMonsterBuilder());
        monsters.add(new IronGolemMonsterBuilder());
        monsters.add(new LichMonsterBuilder());
        monsters.add(new NightmareMonsterBuilder());
        monsters.add(new TrollKingMonsterBuilder());
        return monsters;
    }

    private List<MonsterBuilder> getFloorFiveMonsters() {
        List<MonsterBuilder> monsters = new ArrayList();
        monsters.add(new BansheeMonsterBuilder());
        monsters.add(new ElderDragonMonsterBuilder());
        monsters.add(new PhoenixMonsterBuilder());
        monsters.add(new SkeletonHulkMonsterBuilder());
        monsters.add(new WarswornMonsterBuilder());
        return monsters;
    }
}
