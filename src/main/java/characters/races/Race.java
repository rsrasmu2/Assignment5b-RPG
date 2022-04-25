package characters.races;

public class Race {
    private String name;

    private int startingHealth;
    private int startingMana;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartingHealth() {
        return startingHealth;
    }

    /**
     * Returns the starting health of the race.
     * @param startingHealth the starting health of the race.
     */
    public void setStartingHealth(int startingHealth) {
        this.startingHealth = startingHealth;
    }

    public int getStartingMana() {
        return startingMana;
    }

    /**
     * Returns the starting mana of the race.
     * @param startingMana the starting mana of the race.
     */
    public void setStartingMana(int startingMana) {
        this.startingMana = startingMana;
    }
}
