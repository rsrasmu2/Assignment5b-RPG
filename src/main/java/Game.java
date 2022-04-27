import characters.Player;
import characters.classes.CharacterClass;
import characters.classes.implementations.FighterClassBuilder;
import characters.classes.implementations.ThiefClassBuilder;
import characters.classes.implementations.WizardClassBuilder;
import characters.inventory.EquipmentSlot;
import characters.races.Race;
import characters.races.implementations.DwarfRaceBuilder;
import characters.races.implementations.ElfRaceBuilder;
import characters.races.implementations.HumanRaceBuilder;
import characters.races.implementations.OrcRaceBuilder;
import characters.stats.CombatStats;
import combat.abilities.Abilities;
import items.Consumable;
import items.Equippable;
import items.consumables.HealingPotion;
import java.io.BufferedReader;
import java.io.IOException;
import town.Town;

public class Game {
    private BufferedReader reader;

    /**
     * Creates a new Game instance.
     * @param reader the BufferedReader to use.
     */
    public Game(BufferedReader reader) {
        this.reader = reader;
    }

    /**
     * Begins the game.
     * @throws IOException BufferReader exception.
     */
    public void begin() throws IOException {
        Player player = createPlayer();

        Equippable rustySword = new Equippable("Rusty Sword", 5, EquipmentSlot.WEAPON,
                10, 0, 0, 0, 0);
        player.getInventory().getEquipment().equip(rustySword);

        Equippable clothShirt = new Equippable("Cloth Shirt", 5, EquipmentSlot.ARMOR,
                0, 5, 0, 2, 0);
        player.getInventory().getEquipment().equip(clothShirt);

        Consumable healingPotion = new HealingPotion();
        player.getInventory().getConsumables().addConsumable(healingPotion);

        Town town = new Town(player);
        town.enter(reader);
    }

    /**
     * Creates a new Player character.
     * @return the new player character.
     * @throws IOException based on player input.
     */
    private Player createPlayer() throws IOException {
        CombatStats combatStats = new CombatStats();

        Race playerRace = selectRace(combatStats);
        CharacterClass playerClass = selectClass(combatStats, playerRace);

        System.out.println("Enter a name:");
        String name = reader.readLine();

        Abilities abilities = new Abilities(playerClass.getStartingAbilities());
        return new Player(name, playerRace, playerClass, combatStats, abilities);
    }

    /**
     * Creates a new Race based on the user's input.
     * @param combatStats The combat stats of the character.
     * @return The selected race.
     * @throws IOException based on player input.
     */
    private Race selectRace(CombatStats combatStats) throws IOException {
        Race playerRace = null;
        while (true) {
            System.out.println("Enter your race:\n(H)uman\n(E)lf\n(D)warf\n(O)rc\n");
            String selection = reader.readLine();
            if (selection == null) {
                System.out.println("Invalid selection.");
                continue;
            }
            switch (selection) {
                case "H":
                    System.out.println("You have selected Human");
                    playerRace = new HumanRaceBuilder()
                            .buildName()
                            .buildStartingHealth()
                            .buildStartingMana()
                            .modifyCombatStats(combatStats)
                            .getRace();
                    break;
                case "E":
                    System.out.println("You have selected Elf");
                    playerRace = new ElfRaceBuilder()
                            .buildName()
                            .buildStartingHealth()
                            .buildStartingMana()
                            .modifyCombatStats(combatStats)
                            .getRace();
                    break;
                case "D":
                    System.out.println("You have selected Dwarf");
                    playerRace = new DwarfRaceBuilder()
                            .buildName()
                            .buildStartingHealth()
                            .buildStartingMana()
                            .modifyCombatStats(combatStats)
                            .getRace();
                    break;
                case "O":
                    System.out.println("You have selected Orc");
                    playerRace = new OrcRaceBuilder()
                            .buildName()
                            .buildStartingHealth()
                            .buildStartingMana()
                            .modifyCombatStats(combatStats)
                            .getRace();
                    break;
                default:
                    System.out.println("Invalid selection.");
                    continue;
            }
            break;
        }
        return playerRace;
    }

    /**
     * Creates a new Class based on the user's input.
     * @param combatStats The combat stats of the character.
     * @return The selected class.
     * @throws IOException based on player input.
     */
    private CharacterClass selectClass(CombatStats combatStats, Race playerRace)
            throws IOException {
        CharacterClass playerClass = null;
        while (true) {
            System.out.println("Enter your class:\n(F)ighter\n(T)hief\n(W)izard\n");
            String selection = reader.readLine();
            if (selection == null) {
                System.out.println("Invalid selection.");
                continue;
            }
            switch (selection) {
                case "F":
                    playerClass = new FighterClassBuilder()
                            .buildName()
                            .buildStartingHealth()
                            .buildPrimaryResource(playerRace)
                            .buildStartingAbilities()
                            .buildHealthPerLevel()
                            .buildCombatStatsPerLevel()
                            .modifyCombatStats(combatStats)
                            .getCharacterClass();
                    break;
                case "T":
                    playerClass = new ThiefClassBuilder()
                            .buildName()
                            .buildStartingHealth()
                            .buildPrimaryResource(playerRace)
                            .buildStartingAbilities()
                            .buildHealthPerLevel()
                            .buildCombatStatsPerLevel()
                            .modifyCombatStats(combatStats)
                            .getCharacterClass();
                    break;
                case "W":
                    playerClass = new WizardClassBuilder()
                            .buildName()
                            .buildStartingHealth()
                            .buildPrimaryResource(playerRace)
                            .buildStartingAbilities()
                            .buildHealthPerLevel()
                            .buildCombatStatsPerLevel()
                            .modifyCombatStats(combatStats)
                            .getCharacterClass();
                    break;
                default:
                    System.out.println("Invalid selection.");
                    continue;
            }
            break;
        }
        return playerClass;
    }
}
