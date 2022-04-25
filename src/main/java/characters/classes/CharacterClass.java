package characters.classes;

import characters.resources.CharacterResource;

public class CharacterClass {
    private String name;
    private int startingHealth;
    private CharacterResource primaryResource;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartingHealth() {
        return startingHealth;
    }

    public void setStartingHealth(int startingHealth) {
        this.startingHealth = startingHealth;
    }

    public CharacterResource getPrimaryResource() {
        return primaryResource;
    }

    public void setPrimaryResource(CharacterResource primaryResource) {
        this.primaryResource = primaryResource;
    }
}
