package characters.races;

public interface RaceBuilder {
    RaceBuilder buildName();

    RaceBuilder buildStartingHealth();

    RaceBuilder buildStartingMana();

    Race getRace();
}
