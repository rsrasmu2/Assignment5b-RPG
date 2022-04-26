import characters.Monster;
import characters.Player;
import characters.classes.CharacterClass;
import characters.classes.implementations.FighterClassBuilder;
import characters.classes.implementations.WizardClassBuilder;
import characters.inventory.EquipmentSlot;
import characters.races.Race;
import characters.races.implementations.HumanRaceBuilder;
import characters.stats.CombatStatType;
import characters.stats.CombatStats;
import combat.abilities.Abilities;
import items.Equippable;

import java.util.ArrayList;

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

        CharacterClass fighter = new FighterClassBuilder()
                .buildName()
                .buildStartingHealth()
                .buildPrimaryResource(human)
                .buildStartingAbilities()
                .modifyCombatStats(combatStats)
                .getCharacterClass();

        Abilities abilities = new Abilities(fighter.getStartingAbilities());



        Player player = new Player(human, fighter, combatStats, abilities);
        Monster monster = new Monster("Goblin", 6,
                new CombatStats(10, 5, 10, 5, 13),
                new Abilities(new ArrayList()));


        var sword = new Equippable("Sword", EquipmentSlot.WEAPON, 10, 0, 0, 0, 0);
        System.out.println(player.getCombatStats().getStat(CombatStatType.ATTACK).getValue());
        player.getInventory().getEquipment().equip(sword);
        System.out.println(player.getInventory().getEquipment().getEquippable(EquipmentSlot.WEAPON));
        System.out.println(player.getCombatStats().getStat(CombatStatType.ATTACK).getValue());
        player.getInventory().getEquipment().unequip(EquipmentSlot.WEAPON);
        System.out.println(player.getCombatStats().getStat(CombatStatType.ATTACK).getValue());
    }
}
