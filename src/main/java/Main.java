import characters.Player;
import characters.classes.CharacterClass;
import characters.classes.implementations.WizardClassBuilder;
import characters.races.Race;
import characters.races.implementations.HumanRaceBuilder;

public class Main {
    public static void main(String[] args) {
        Race human = new HumanRaceBuilder()
                .buildName()
                .buildStartingHealth()
                .buildStartingMana()
                .getRace();

        CharacterClass wizard = new WizardClassBuilder()
                .buildName()
                .buildStartingHealth()
                .buildPrimaryResource(human)
                .getCharacterClass();

        Player player = new Player(human, wizard);
    }
}
