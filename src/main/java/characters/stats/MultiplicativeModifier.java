package characters.stats;

public class MultiplicativeModifier extends CombatStatModifier {
    private float toMultiply;

    public MultiplicativeModifier(int toMultiply) {
        super();
        this.toMultiply = toMultiply;
    }

    public MultiplicativeModifier(int toMultiply, int duration) {
        super(duration);
        this.toMultiply = toMultiply;
    }

    @Override
    public int modify(int valueToModify) {
        return (int)(valueToModify * toMultiply);
    }
}
