package characters.stats;

public class AdditiveModifier extends CombatStatModifier {
    private int toAdd;

    public AdditiveModifier(int toAdd) {
        super();
        this.toAdd = toAdd;
    }

    public AdditiveModifier(int toAdd, int duration) {
        super(duration);
        this.toAdd = toAdd;
    }

    @Override
    public int modify(int valueToModify) {
        return valueToModify + toAdd;
    }
}
