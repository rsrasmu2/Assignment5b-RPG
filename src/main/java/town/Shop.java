package town;

import characters.Player;
import characters.inventory.EquipmentSlot;
import items.Consumable;
import items.Equippable;
import items.consumables.HealingPotion;
import items.consumables.ManaPotion;
import items.consumables.PowerPotion;
import items.consumables.StrengthPotion;

import java.io.BufferedReader;
import java.io.IOException;

public class Shop implements TownBuilding {
    @Override
    public void enter(Player player, BufferedReader reader) throws IOException {
        System.out.println("You enter a quiet shop.");
        while (true) {
            printEntrance(player);
            String input = reader.readLine();
            switch (input) {
                case "1":
                    printWeaponSelection();
                    shopWeapons(player, reader);
                    return;
                case "2":
                    printArmorSelection();
                    shopArmor(player, reader);
                    return;
                case "3":
                    printConsumablesSelection();
                    shopConsumables(player, reader);
                    return;
                case "4":
                    System.out.println("You leave the shop.");
                    return;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }

    private void printEntrance(Player player) {
        System.out.println("1. Shop Weapons");
        System.out.println("2. Shop Armor");
        System.out.println("3. Shop Consumables");
        System.out.println("4. Leave.");
        System.out.println(player.getInventory().toString());
    }

    private void printWeaponSelection() {
        System.out.println("1. Iron Sword");
        System.out.println("2. Steel Sword");
        System.out.println("3. Diamond Sword");
        System.out.println("4. Obsidian Sword");
        System.out.println("5. Iron Dagger");
        System.out.println("6. Steel Dagger");
        System.out.println("7. Diamond Dagger");
        System.out.println("8. Obsidian Dagger");
        System.out.println("9. Ash Staff");
        System.out.println("10. Birch Staff");
        System.out.println("11. Oak Staff");
        System.out.println("12. Heartwood Staff");
        System.out.println("13. Back");
    }

    private void shopWeapons(Player player, BufferedReader reader) throws IOException {
        String input = reader.readLine();
        Equippable item = null;
        switch (input) {
            case "1":
                item = new Equippable("Iron Sword", 25, EquipmentSlot.WEAPON, 20, 0, 0, 0, 0);
                selectWeapon(player, reader, item);
                break;
            case "2":
                item = new Equippable("Steel Sword", 75, EquipmentSlot.WEAPON, 35, 0, 0, 0, 0);
                selectWeapon(player, reader, item);
                break;
            case "3":
                item = new Equippable("Diamond Sword", 150, EquipmentSlot.WEAPON, 50, 0, 0, 0, 0);
                selectWeapon(player, reader, item);
                break;
            case "4":
                item = new Equippable("Obsidian Sword", 350, EquipmentSlot.WEAPON, 80, 0, 0, 0, 0);
                selectWeapon(player, reader, item);
                break;
            case "5":
                item = new Equippable("Iron Daggers", 25, EquipmentSlot.WEAPON, 18, 0, 0, 0, 2);
                selectWeapon(player, reader, item);
                break;
            case "6":
                item = new Equippable("Steel Daggers", 75, EquipmentSlot.WEAPON, 30, 0, 0, 0, 4);
                selectWeapon(player, reader, item);
                break;
            case "7":
                item = new Equippable("Diamond Daggers", 150, EquipmentSlot.WEAPON, 44, 0, 0, 0, 6);
                selectWeapon(player, reader, item);
                break;
            case "8":
                item = new Equippable("Obsidian Daggers", 350, EquipmentSlot.WEAPON, 72, 0, 0, 0, 8);
                selectWeapon(player, reader, item);
                break;
            case "9":
                item = new Equippable("Ash Staff", 25, EquipmentSlot.WEAPON, 10, 0, 15, 0, 0);
                selectWeapon(player, reader, item);
                break;
            case "10":
                item = new Equippable("Birch Staff", 75, EquipmentSlot.WEAPON, 25, 0, 35, 0, 0);
                selectWeapon(player, reader, item);
                break;
            case "11":
                item = new Equippable("Oak Staff", 150, EquipmentSlot.WEAPON, 38, 0, 50, 0, 0);
                selectWeapon(player, reader, item);
                break;
            case "12":
                item = new Equippable("Heartwood Staff", 350, EquipmentSlot.WEAPON, 65, 0, 80, 0, 0);
                selectWeapon(player, reader, item);
                break;
            case "13":
                break;
            default:
                System.out.println("Invalid selection.");
        }
    }

    private void printArmorSelection() {
        System.out.println("1. Padded Armor");
        System.out.println("2. Scale Mail");
        System.out.println("3. Breastplate");
        System.out.println("4. Full Plate");
        System.out.println("5. Leather Vest");
        System.out.println("6. Leather Armor");
        System.out.println("7. Studded Leather Armor");
        System.out.println("8. Chain Mail");
        System.out.println("9. Patchwork Robes");
        System.out.println("10. Fine Robes");
        System.out.println("11. Silk Robes");
        System.out.println("12. Runic Robes");
        System.out.println("13. Back");
    }

    private void shopArmor(Player player, BufferedReader reader) throws IOException {
        String input = reader.readLine();
        Equippable item = null;
        switch (input) {
            case "1":
                item = new Equippable("Padded Armor", 25, EquipmentSlot.ARMOR, 0, 10, 0, 5, 0);
                selectArmor(player, reader, item);
                break;
            case "2":
                item = new Equippable("Scale Mail", 75, EquipmentSlot.ARMOR, 0, 18, 0, 10, 0);
                selectArmor(player, reader, item);
                break;
            case "3":
                item = new Equippable("Breastplate", 150, EquipmentSlot.ARMOR, 0, 25, 0, 18, 0);
                selectArmor(player, reader, item);
                break;
            case "4":
                item = new Equippable("Full Plate", 350, EquipmentSlot.ARMOR, 0, 40, 0, 25, 0);
                selectArmor(player, reader, item);
                break;
            case "5":
                item = new Equippable("Leather Vest", 25, EquipmentSlot.ARMOR, 0, 8, 0, 5, 2);
                selectArmor(player, reader, item);
                break;
            case "6":
                item = new Equippable("Leather Armor", 75, EquipmentSlot.ARMOR, 0, 15, 0, 10, 4);
                selectArmor(player, reader, item);
                break;
            case "7":
                item = new Equippable("Studded Leather Armor", 150, EquipmentSlot.ARMOR, 21, 0, 18, 0, 6);
                selectArmor(player, reader, item);
                break;
            case "8":
                item = new Equippable("Chain Mail", 350, EquipmentSlot.ARMOR, 0, 34, 0, 25, 8);
                selectArmor(player, reader, item);
                break;
            case "9":
                item = new Equippable("Patchwork Robes", 25, EquipmentSlot.ARMOR, 0, 6, 0, 10, 0);
                selectArmor(player, reader, item);
                break;
            case "10":
                item = new Equippable("Fine Robes", 75, EquipmentSlot.ARMOR, 0, 12, 0, 18, 0);
                selectArmor(player, reader, item);
                break;
            case "11":
                item = new Equippable("Silk Robes", 150, EquipmentSlot.ARMOR, 0, 18, 0, 25, 0);
                selectArmor(player, reader, item);
                break;
            case "12":
                item = new Equippable("Runic Robes", 350, EquipmentSlot.ARMOR, 0, 30, 0, 40, 0);
                selectArmor(player, reader, item);
                break;
            case "13":
                break;
            default:
                System.out.println("Invalid selection.");
        }
    }

    private void printConsumablesSelection() {
        System.out.println("1. Healing Potion");
        System.out.println("2. Mana Potion");
        System.out.println("3. Strength Potion");
        System.out.println("4. Power Potion");
        System.out.println("5. Back");
    }

    private void shopConsumables(Player player, BufferedReader reader) throws IOException {
        String input = reader.readLine();
        Consumable item = null;
        switch (input) {
            case "1":
                item = new HealingPotion();
                break;
            case "2":
                item = new ManaPotion();
                break;
            case "3":
                item = new StrengthPotion();
                break;
            case "4":
                item = new PowerPotion();
                break;
            case "5":
                return;
            default:
                System.out.println("Invalid selection");
        }
        System.out.println(item.toString() + "\nCost " + item.getCost());
    }

    private void selectWeapon(Player player, BufferedReader reader, Equippable item) throws IOException {
        System.out.println("Your weapon: " + player.getInventory().getEquipment().getEquippable(EquipmentSlot.WEAPON));
        System.out.println(item.toString() + "\nCost: " + item.getCost());
        if (checkBuy(player, reader, item)) {
            System.out.println("You bought the " + item.getName());
            player.getInventory().modifyGold(-item.getCost());
            player.getInventory().getEquipment().equip(item);
        }
    }

    private void selectArmor(Player player, BufferedReader reader, Equippable item) throws IOException {
        System.out.println("Your armor: " + player.getInventory().getEquipment().getEquippable(EquipmentSlot.ARMOR));
        System.out.println(item.toString() + "\nCost: " + item.getCost());
        if (checkBuy(player, reader, item)) {
            System.out.println("You bought the " + item.getName());
            player.getInventory().modifyGold(-item.getCost());
            player.getInventory().getEquipment().equip(item);
        }
    }


    private boolean checkBuy(Player player, BufferedReader reader, Equippable item) throws IOException {
        System.out.println("1. Buy");
        System.out.println("2. Back");
        String input = reader.readLine();
        switch (input) {
            case "1":
                if (player.getInventory().getGold() < item.getCost()) {
                    System.out.println("You cannot afford this item.");
                    return false;
                }
                return true;
            case "2":
                return false;
            default:
                System.out.println("Invalid selection");
        }
        return false;
    }
}
