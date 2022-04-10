package war;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeaponTest {

    @Test
    @DisplayName("1")
    void fight() {
        var warrior1 = Warrior.of(Warrior.Type.LANCER);
        warrior1.equipWeapon(Weapon.customizedWeapon(-10, 5, 0, 40, 0));
        var warrior2 = Warrior.of(Warrior.Type.VAMPIRE);
        warrior2.equipWeapon(PredefinedWeapon.SWORD);

        var res = Battle.fight(warrior1, warrior2);

        assertTrue(res);
    }

    @Test
    @DisplayName("2")
    void fight1() {
        var warrior1 = Warrior.of(Warrior.Type.DEFENDER);
        warrior1.equipWeapon(PredefinedWeapon.SHIELD);
        var warrior2 = Warrior.of(Warrior.Type.LANCER);
        warrior2.equipWeapon(PredefinedWeapon.GREAT_AXE);

        var res = Battle.fight(warrior1, warrior2);

        assertFalse(res);
    }

    @Test
    @DisplayName("3")
    void fight2() {
        var warrior1 = Warrior.of(Warrior.Type.HEALER);
        warrior1.equipWeapon(PredefinedWeapon.MAGIC_WAND);
        var warrior2 = Warrior.of(Warrior.Type.KNIGHT);
        warrior2.equipWeapon(PredefinedWeapon.KATANA);

        var res = Battle.fight(warrior1, warrior2);

        assertFalse(res);
    }

    @Test
    @DisplayName("4")
    void fight3() {
        var warrior1 = Warrior.of(Warrior.Type.DEFENDER);
        var warrior2 = Warrior.of(Warrior.Type.VAMPIRE);
        var weapon1 = PredefinedWeapon.SHIELD;
        var weapon2 = PredefinedWeapon.MAGIC_WAND;
        var weapon3 = PredefinedWeapon.SHIELD;
        var weapon4 = PredefinedWeapon.KATANA;
        warrior1.equipWeapon(weapon1);
        warrior1.equipWeapon(weapon2);
        warrior2.equipWeapon(weapon3);
        warrior2.equipWeapon(weapon4);

        var res = Battle.fight(warrior1, warrior2);

        assertFalse(res);
    }

    @Test
    @DisplayName("5")
    void fight4() {
        var weapon1 = PredefinedWeapon.MAGIC_WAND;
        var weapon2 = PredefinedWeapon.GREAT_AXE;
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.KNIGHT, 1);
        army1.addUnits(Warrior.Type.LANCER, 1);
        army2.addUnits(Warrior.Type.VAMPIRE, 1);
        army2.addUnits(Warrior.Type.HEALER, 1);
        army1.getForce().get(0).equipWeapon(weapon1);
        army1.getForce().get(1).equipWeapon(weapon2);
        army2.getForce().get(0).equipWeapon(weapon1);
        army2.getForce().get(1).equipWeapon(weapon2);


        var res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("6")
    void fight5() {
        var weapon1 = PredefinedWeapon.SWORD;
        var weapon2 = PredefinedWeapon.GREAT_AXE;
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.DEFENDER, 1);
        army1.addUnits(Warrior.Type.WARRIOR, 1);
        army2.addUnits(Warrior.Type.KNIGHT, 1);
        army2.addUnits(Warrior.Type.HEALER, 1);
        army1.getForce().get(0).equipWeapon(weapon2);
        army1.getForce().get(1).equipWeapon(weapon2);
        army2.getForce().get(0).equipWeapon(weapon1);
        army2.getForce().get(1).equipWeapon(weapon1);


        var res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("7")
    void fight6() {
        var weapon1 = PredefinedWeapon.KATANA;
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.DEFENDER, 2);
        army2.addUnits(Warrior.Type.KNIGHT, 1);
        army2.addUnits(Warrior.Type.VAMPIRE, 1);
        army1.getForce().get(0).equipWeapon(weapon1);
        army1.getForce().get(1).equipWeapon(weapon1);
        army2.getForce().get(0).equipWeapon(weapon1);
        army2.getForce().get(1).equipWeapon(weapon1);


        var res = Battle.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("8")
    void fight7() {
        var weapon1 = Weapon.customizedWeapon(-20, 6, 1, 40, -2);
        var weapon2 = Weapon.customizedWeapon(20, -2, 2, -55, 3);
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.KNIGHT, 3);
        army2.addUnits(Warrior.Type.WARRIOR, 1);
        army2.addUnits(Warrior.Type.DEFENDER, 2);
        army1.getForce().get(0).equipWeapon(weapon1);
        army1.getForce().get(1).equipWeapon(weapon1);
        army1.getForce().get(2).equipWeapon(weapon2);
        army2.getForce().get(0).equipWeapon(weapon1);
        army2.getForce().get(1).equipWeapon(weapon2);
        army2.getForce().get(2).equipWeapon(weapon2);


        var res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("9")
    void fight8() {
        var weapon1 = Weapon.customizedWeapon(-20, 1, 1, 40, -2);
        var weapon2 = Weapon.customizedWeapon(20, 2, 2, -55, 3);
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.VAMPIRE, 3);
        army2.addUnits(Warrior.Type.WARRIOR, 1);
        army2.addUnits(Warrior.Type.DEFENDER, 2);
        army1.getForce().get(0).equipWeapon(weapon1);
        army1.getForce().get(1).equipWeapon(weapon1);
        army1.getForce().get(2).equipWeapon(weapon2);
        army2.getForce().get(0).equipWeapon(weapon1);
        army2.getForce().get(1).equipWeapon(weapon2);
        army2.getForce().get(2).equipWeapon(weapon2);


        var res = Battle.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("10")
    void fight9() {
        var weapon1 = PredefinedWeapon.KATANA;
        var weapon2 = PredefinedWeapon.SHIELD;
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.VAMPIRE, 2);
        army1.addUnits(Warrior.Type.ROOKIE, 2);
        army2.addUnits(Warrior.Type.WARRIOR, 1);
        army2.addUnits(Warrior.Type.DEFENDER, 2);
        army1.getForce().get(0).equipWeapon(weapon1);
        army1.getForce().get(1).equipWeapon(weapon1);
        army1.getForce().get(2).equipWeapon(weapon2);
        army2.getForce().get(0).equipWeapon(weapon1);
        army2.getForce().get(1).equipWeapon(weapon2);
        army2.getForce().get(2).equipWeapon(weapon2);


        var res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("11")
    void fight10() {
        var weapon1 = PredefinedWeapon.SWORD;
        var weapon2 = PredefinedWeapon.GREAT_AXE;
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.VAMPIRE, 3);
        army2.addUnits(Warrior.Type.WARRIOR, 1);
        army2.addUnits(Warrior.Type.DEFENDER, 1);
        army1.getForce().get(0).equipWeapon(weapon2);
        army1.getForce().get(1).equipWeapon(weapon2);
        army1.getForce().get(2).equipWeapon(weapon2);
        army2.getForce().get(0).equipWeapon(weapon1);
        army2.getForce().get(1).equipWeapon(weapon1);

        var res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("12")
    void fight11() {
        var weapon1 = PredefinedWeapon.KATANA;
        var weapon2 = PredefinedWeapon.MAGIC_WAND;
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.ROOKIE, 3);
        army2.addUnits(Warrior.Type.WARRIOR, 1);
        army2.addUnits(Warrior.Type.HEALER, 1);
        army1.getForce().get(0).equipWeapon(weapon1);
        army1.getForce().get(1).equipWeapon(weapon1);
        army1.getForce().get(2).equipWeapon(weapon1);
        army2.getForce().get(0).equipWeapon(weapon2);
        army2.getForce().get(1).equipWeapon(weapon2);

        var res = Battle.fight(army1, army2);

        assertFalse(res);
    }
}