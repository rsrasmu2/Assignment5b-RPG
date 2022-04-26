package characters.stats;

public class MultiplicativeModifier extends CombatStatModifier {
    private double toMultiply;

    public MultiplicativeModifier(double toMultiply) {
        super();
        this.toMultiply = toMultiply;
    }

    public MultiplicativeModifier(double toMultiply, int duration) {
        super(duration);
        this.toMultiply = toMultiply;
    }

    @Override
    public double getValue() {
        return toMultiply;
    }

    @Override
    public int modify(int valueToModify) {
        return (int)(valueToModify * toMultiply);
    }

    public String toString() {
        return "* " + toMultiply;
    }
}
