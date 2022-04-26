package characters.resources;

import java.util.ArrayList;
import java.util.List;

public class CharacterResource {
    private String name;

    private int startingValue;
    private int currentValue;
    private int maxValue;

    private List<CharacterResourceObserver> observers;

    /**
     * Creates a new CharacterResource.
     * @param resourceName the name of the resource.
     * @param startingValue the starting current and max value of the resource.
     */
    public CharacterResource(String resourceName, int startingValue) {
        this.name = resourceName;
        this.startingValue = startingValue;
        maxValue = startingValue;
        currentValue = startingValue;
        observers = new ArrayList<>();
    }

    /**
     * Creates a new CharacterResource with separate current and max values.
     * @param resourceName the name of the resource.
     * @param startingCurrentValue the starting current and max value of the resource.
     * @param startingMaxValue the starting max value of the resource.
     */
    public CharacterResource(String resourceName, int startingCurrentValue, int startingMaxValue) {
        this.name = resourceName;
        this.startingValue = startingCurrentValue;
        maxValue = startingMaxValue;
        currentValue = startingCurrentValue;
        observers = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    /**
     * Sets the current value of the resource.
     * Will be clamped between 0 and MaxValue.
     * @param newCurrentValue the new current value of the resource.
     */
    public void setCurrentValue(int newCurrentValue) {
        if (newCurrentValue == currentValue) {
            return;
        }

        currentValue = newCurrentValue;

        // Clamp HP to [0, Max]
        if (currentValue > maxValue) {
            currentValue = maxValue;
        } else if (currentValue < 0) {
            currentValue = 0;
        }

        for (var observer : observers) {
            observer.currentValueChanged(currentValue);
        }
    }

    public void modifyCurrentValue(int modifier) {
        setCurrentValue(getCurrentValue() + modifier);
    }

    /**
     * sets the new maximum value of the resource.
     * @param newMaxValue the new maximum value of the resource.
     */
    public void setMaxValue(int newMaxValue) {
        if (newMaxValue == maxValue) {
            return;
        }

        maxValue = newMaxValue;
        for (var observer : observers) {
            observer.maxValueChanged(currentValue);
        }

        if (currentValue > maxValue) {
            setCurrentValue(maxValue);
        }
    }

    public void modifyMaxValue(int modifier) {
        setMaxValue(getMaxValue() + modifier);
    }

    public void refresh() {
        setCurrentValue(startingValue);
    }

    @Override
    public String toString() {
        return name + ": " + currentValue + " / " + maxValue;
    }

    public void addObserver(CharacterResourceObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CharacterResourceObserver observer) {
        observers.remove(observer);
    }
}
