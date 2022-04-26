package characters.monsters;

public interface MonsterBuilder {
    MonsterBuilder buildName();

    MonsterBuilder buildHealth();

    MonsterBuilder buildAbilities();

    MonsterBuilder buildCombatStats();

    MonsterBuilder buildExperience();

    MonsterBuilder buildGold();

    Monster getMonster();
}
