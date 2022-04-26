package characters.stats;

import java.util.ArrayList;
import java.util.List;

public class CombatStat {
    private int baseValue;

    private List<AdditiveModifier> additiveModifiers;
    private List<MultiplicativeModifier> multiplicativeModifiers;

    private List<CombatStatObserver> observers;

    public CombatStat(int value) {
        baseValue = value;
        additiveModifiers = new ArrayList();
        multiplicativeModifiers = new ArrayList();
        observers = new ArrayList();
    }

    public int getBaseValue() {
        return baseValue;
    }

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

    public void tickModifiers() {
        for (int i = additiveModifiers.size() - 1; i >= 0; i--) {
            CombatStatModifier modifier = additiveModifiers.get(i);
            modifier.tickDuration();
            if (modifier.getDuration() == 0) {
                additiveModifiers.remove(i);
            }
        }
        for (int i = multiplicativeModifiers.size() - 1; i >= 0; i--) {
            CombatStatModifier modifier = multiplicativeModifiers.get(i);
            modifier.tickDuration();
            if (modifier.getDuration() == 0) {
                multiplicativeModifiers.remove(i);
            }
        }
    }
}
