package characters;

import characters.resources.CharacterResource;

public class Monster {
    private CharacterResource health;

    public Monster(int startingHealth) {
        health = new CharacterResource("Health", startingHealth);
    }

    public CharacterResource getHealth() {
        return health;
    }
}
