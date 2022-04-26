package characters.levels;

public interface LevelObserver {
    void leveledUp(int newLevel);
    void experienceModified(int newValue);
    void nextLevelExperienceModified(int newValue);
}
