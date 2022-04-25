package characters.resources;

public interface CharacterResourceObserver {
    void currentValueChanged(int newCurrentValue);

    void maxValueChanged(int newMaxValue);
}
