package characters.stats;

public abstract class CombatStatModifier {
    private CombatStatModifierDuration durationType;
    private int duration;

    public CombatStatModifier() {
        durationType = CombatStatModifierDuration.Infinite;
        duration = -1;
    }

    public CombatStatModifier(int duration) {
        durationType = CombatStatModifierDuration.Timed;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void tickDuration() {
        if (durationType == CombatStatModifierDuration.Timed) {
            duration--;
        }
    }

    public abstract int modify(int valueToModify);
}
