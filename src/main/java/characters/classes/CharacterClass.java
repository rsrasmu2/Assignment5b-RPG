package characters.classes;

import characters.resources.CharacterResource;
import combat.abilities.Ability;

import java.util.ArrayList;
import java.util.List;

public class CharacterClass {
    private String name;

    private int startingHealth;
    private CharacterResource primaryResource;
    private int healthPerLevel;

    private List<Ability> startingAbilities;

    public CharacterClass() {
        startingAbilities = new ArrayList();
    }

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

    public int getHealthPerLevel() {
        return healthPerLevel;
    }

    public void setHealthPerLevel(int newHealthPerLevel) {
        healthPerLevel = newHealthPerLevel;
    }

    public void setStartingAbilities(List<Ability> abilities) {
        startingAbilities = abilities;
    }

    public List<Ability> getStartingAbilities() {
        return startingAbilities;
    }
}
