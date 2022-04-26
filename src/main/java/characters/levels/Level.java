package characters.levels;

import java.util.List;

public class Level {
    private int currentLevel;
    private int currentExperience;
    private int experienceToNextLevel;

    private static final int STARTING_EXPERIENCE = 1000;
    private static final double EXPERIENCE_MULTIPLIER = 1.2;

    private List<LevelObserver> observers;

    public Level() {
        currentLevel = 1;
        currentExperience = 0;
        experienceToNextLevel = STARTING_EXPERIENCE;
    }

    public Level(int level) {
        currentLevel = level;
        currentExperience = STARTING_EXPERIENCE;
        for (int i = 0; i < level - 1; i++) {
            currentExperience += (int)(currentExperience * EXPERIENCE_MULTIPLIER);
        }
        experienceToNextLevel = (int)(currentExperience + currentExperience * EXPERIENCE_MULTIPLIER);
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getCurrentExperience() {
        return currentExperience;
    }

    public void setCurrentExperience(int newCurrentExperience) {
        currentExperience = newCurrentExperience;
        while (currentExperience >= experienceToNextLevel) {
            currentLevel++;
            experienceToNextLevel += experienceToNextLevel * EXPERIENCE_MULTIPLIER;
        }
    }

    public int getExperienceToNextLevel() {
        return experienceToNextLevel;
    }
}
