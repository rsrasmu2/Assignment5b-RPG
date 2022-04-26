package characters.stats;

public interface CombatStatObserver {
    void baseValueChanged(int newBaseValue);

    void valueChanged(int newValue);
}
