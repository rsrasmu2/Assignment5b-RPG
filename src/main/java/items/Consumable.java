package items;

public class Consumable extends Item {
    private int uses;

    public Consumable(String name, int uses) {
        super(name);
        this.uses = uses;
    }

    public void use() {
        uses--;
    }

    public int getUses() {
        return uses;
    }
}
