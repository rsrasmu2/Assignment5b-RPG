package characters.stats;

import java.util.ArrayList;
import java.util.List;

public class CombatStat {
    private int baseValue;

    private List<AdditiveModifier> additiveModifiers;
    private List<MultiplicativeModifier> multiplicativeModifiers;

    private List<CombatStatObserver> observers;

    /**
     * Creates a new combat stat.
     * @param baseValue the base value of the stat.
     */
    public CombatStat(int baseValue) {
        this.baseValue = baseValue;
        additiveModifiers = new ArrayList();
        multiplicativeModifiers = new ArrayList();
        observers = new ArrayList();
    }

    public int getBaseValue() {
        return baseValue;
    }

    /**
     * Sets the base value of the combat stat.
     * @param newBaseValue the new base value of the combat stat.
     */
    public void setBaseValue(int newBaseValue) {
        if (baseValue == newBaseValue) {
            return;
        }
        baseValue = newBaseValue;

        for (CombatStatObserver observer : observers) {
            observer.baseValueChanged(baseValue);
        }
        for (CombatStatObserver observer : observers) {
            observer.valueChanged(getValue());
        }
    }

    public void modifyBaseValue(int toModify) {
        setBaseValue(baseValue + toModify);
    }

    /**
     * Adds a value modifier to the combat stat.
     * @param modifier the value modifier.
     */
    public void addModifier(CombatStatModifier modifier) {
        if (modifier instanceof AdditiveModifier) {
            additiveModifiers.add((AdditiveModifier) modifier);
        } else if (modifier instanceof MultiplicativeModifier) {
            multiplicativeModifiers.add((MultiplicativeModifier) modifier);
        }

        for (CombatStatObserver observer : observers) {
            observer.valueChanged(getValue());
        }
    }

    /**
     * Removes the given modifier from the combat stat.
     * @param modifier the modifier to remove.
     */
    public void removeModifier(CombatStatModifier modifier) {
        if (modifier instanceof AdditiveModifier) {
            additiveModifiers.remove((AdditiveModifier) modifier);
        } else if (modifier instanceof MultiplicativeModifier) {
            multiplicativeModifiers.remove((MultiplicativeModifier) modifier);
        }

        for (CombatStatObserver observer : observers) {
            observer.valueChanged(getValue());
        }
    }

    /**
     * Returns the total value of the stat after modifiers are applied.
     * @return the total value of the stat after modifiers are applied.
     */
    public int getValue() {
        int totalValue = baseValue;
        for (CombatStatModifier modifier : additiveModifiers) {
            totalValue = modifier.modify(totalValue);
        }
        for (CombatStatModifier modifier : multiplicativeModifiers) {
            totalValue = modifier.modify(totalValue);
        }
        return totalValue;
    }

    /**
     * Ticks the simulation a single tick, lowering modifier durations by 1.
     */
    public void tick() {
        for (int i = additiveModifiers.size() - 1; i >= 0; i--) {
            CombatStatModifier modifier = additiveModifiers.get(i);
            modifier.tickDuration();
            if (modifier.getDuration() == 0) {
                removeModifier(modifier);
            }
        }
        for (int i = multiplicativeModifiers.size() - 1; i >= 0; i--) {
            CombatStatModifier modifier = multiplicativeModifiers.get(i);
            modifier.tickDuration();
            if (modifier.getDuration() == 0) {
                removeModifier(modifier);
            }
        }
    }
}
