package characters.levels;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int currentLevel;
    private int currentExperience;
    private int experienceToNextLevel;

    private static final int STARTING_EXPERIENCE = 1000;
    private static final double EXPERIENCE_MULTIPLIER = 1.2;

    private List<LevelObserver> observers;

    /**
     * Creates level data for a new character.
     */
    public Level() {
        currentLevel = 1;
        currentExperience = 0;
        experienceToNextLevel = STARTING_EXPERIENCE;
        observers = new ArrayList();
    }

    /**
     * Creates level data for a pre-leveled character.
     * @param level the level of the character.
     */
    public Level(int level) {
        currentLevel = level;
        currentExperience = STARTING_EXPERIENCE;
        for (int i = 0; i < level - 1; i++) {
            currentExperience += (int)(currentExperience * EXPERIENCE_MULTIPLIER);
        }
        experienceToNextLevel = (int)(currentExperience
                + currentExperience * EXPERIENCE_MULTIPLIER);
        observers = new ArrayList();
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getCurrentExperience() {
        return currentExperience;
    }

    /**
     * Sets the current experience of the character.
     * @param newCurrentExperience The new current experience of the character.
     */
    public void setCurrentExperience(int newCurrentExperience) {
        if (currentExperience == newCurrentExperience) {
            return;
        }

        currentExperience = newCurrentExperience;
        for (LevelObserver observer : observers) {
            observer.experienceModified(currentExperience);
        }
        while (currentExperience >= experienceToNextLevel) {
            currentLevel++;
            for (LevelObserver observer : observers) {
                observer.leveledUp(currentLevel);
            }
            experienceToNextLevel += experienceToNextLevel * EXPERIENCE_MULTIPLIER;
            for (LevelObserver observer : observers) {
                observer.nextLevelExperienceModified(experienceToNextLevel);
            }
        }
    }

    public void modifyCurrentExperience(int value) {
        setCurrentExperience(currentExperience + value);
    }

    public int getExperienceToNextLevel() {
        return experienceToNextLevel;
    }
}
