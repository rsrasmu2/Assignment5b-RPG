import characters.Monster;
import characters.Player;
import characters.classes.CharacterClass;
import characters.classes.implementations.FighterClassBuilder;
import characters.classes.implementations.WizardClassBuilder;
import characters.inventory.EquipmentSlot;
import characters.races.Race;
import characters.races.implementations.HumanRaceBuilder;
import characters.stats.CombatStats;
import combat.Combat;
import combat.abilities.Abilities;
import combat.abilities.monster.AttackAbility;
import combat.abilities.monster.DefendAbility;
import items.Equippable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    /**
     * The main method of the program.
     * @param args input args.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CombatStats combatStats = new CombatStats();

        Race playerRace = new HumanRaceBuilder()
                .buildName()
                .buildStartingHealth()
                .buildStartingMana()
                .modifyCombatStats(combatStats)
                .getRace();

        CharacterClass playerClass = new WizardClassBuilder()
                .buildName()
                .buildStartingHealth()
                .buildPrimaryResource(playerRace)
                .buildStartingAbilities()
                .modifyCombatStats(combatStats)
                .getCharacterClass();

        Abilities abilities = new Abilities(playerClass.getStartingAbilities());



        Player player = new Player(playerRace, playerClass, combatStats, abilities);
        Abilities monsterAbilities =  new Abilities(new ArrayList());
        monsterAbilities.addAbility(new AttackAbility());
        monsterAbilities.addAbility(new DefendAbility());
        Monster monster = new Monster("Goblin", 26,
                new CombatStats(25, 25, 5, 20, 20),
                monsterAbilities);


        var rustySword = new Equippable("Rusty Sword", EquipmentSlot.WEAPON, 10, 0, 0, 0, 0);
        player.getInventory().getEquipment().equip(rustySword);

        Combat combat = new Combat(player, monster);
        combat.begin(reader);

        reader.close();
    }
}
