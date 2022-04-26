import characters.Player;
import characters.classes.CharacterClass;
import characters.classes.implementations.WizardClassBuilder;
import characters.races.Race;
import characters.races.implementations.HumanRaceBuilder;
import characters.stats.CombatStats;

public class Main {
    /**
     * The main method of the program.
     * @param args input args.
     */
    public static void main(String[] args) {
        CombatStats combatStats = new CombatStats();

        Race human = new HumanRaceBuilder()
                .buildName()
                .buildStartingHealth()
                .buildStartingMana()
                .modifyCombatStats(combatStats)
                .getRace();

        CharacterClass wizard = new WizardClassBuilder()
                .buildName()
                .buildStartingHealth()
                .buildPrimaryResource(human)
                .modifyCombatStats(combatStats)
                .getCharacterClass();

        Player player = new Player(human, wizard, combatStats);

        System.out.println(player.getRace().getName());
        System.out.println(player.getCharacterClass().getName());
        System.out.println(player.getHealth().toString());
        System.out.println(player.getPrimaryResource().toString());
        System.out.println(player.getCombatStats().toString());
    }
}
