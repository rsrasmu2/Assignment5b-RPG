package combat.abilities;

public interface AbilityAction {
    void execute(Targettable user, Targettable opponent);
}
