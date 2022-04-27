package items;

import characters.Player;

public class Consumable extends Item {
    private int uses;

    public Consumable(String name, int cost, int uses) {
        super(name, cost);
        this.uses = uses;
    }

    public void use(Player player) {
        uses--;
    }

    public int getUses() {
        return uses;
    }
}
