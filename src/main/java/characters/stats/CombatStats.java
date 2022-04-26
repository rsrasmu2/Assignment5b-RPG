package characters.stats;

public class CombatStats {
    private int attack;
    private int defense;
    private int magicAttack;
    private int magicDefense;
    private int evasion;

    public CombatStats() {
        attack = 0;
        defense = 0;
        magicAttack = 0;
        magicDefense = 0;
        evasion = 0;
    }

    public CombatStats(int attack, int defense, int magicAttack, int magicDefense, int evasion) {
        this.attack = attack;
        this.defense = defense;
        this.magicAttack = magicAttack;
        this.magicDefense = magicDefense;
        this.evasion = evasion;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMagicAttack() {
        return magicAttack;
    }

    public void setMagicAttack(int magicAttack) {
        this.magicAttack = magicAttack;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public void setMagicDefense(int magicDefense) {
        this.magicDefense = magicDefense;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public String toString() {
        return "CombatStats:\nAttack: " + attack +"\nDefense: " + defense + "\nMagic Attack: "
                + magicAttack + "\nMagic Defense: " + magicDefense + "\nEvasion: " + evasion;
    }
}
