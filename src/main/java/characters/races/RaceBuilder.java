package characters.races;

public interface RaceBuilder {
    void buildName();

    void buildStartingHealth();

    void buildStartingMana();

    Race getRace();

}
