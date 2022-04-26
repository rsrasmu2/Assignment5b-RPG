package characters.monsters;

public interface MonsterBuilder {
    MonsterBuilder buildName();

    MonsterBuilder buildHealth();

    MonsterBuilder buildAbilities();

    MonsterBuilder buildCombatStats();

    Monster getMonster();
}
