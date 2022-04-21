package war;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WarlordsTest {

    @Test
    @DisplayName("Army fight")
    void test1() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.WARLORD, 1);
        army1.addUnits(Warrior.Type.WARRIOR, 2);
        army1.addUnits(Warrior.Type.LANCER, 2);
        army1.addUnits(Warrior.Type.HEALER, 2);
        army2.addUnits(Warrior.Type.WARLORD, 1);
        army2.addUnits(Warrior.Type.VAMPIRE, 1);
        army2.addUnits(Warrior.Type.HEALER, 2);
        army2.addUnits(Warrior.Type.KNIGHT, 2);

        var res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Army fight")
    void test2() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.WARRIOR, 2);
        army1.addUnits(Warrior.Type.LANCER, 2);
        army1.addUnits(Warrior.Type.DEFENDER, 1);
        army1.addUnits(Warrior.Type.WARLORD, 3);
        army2.addUnits(Warrior.Type.WARLORD, 2);
        army2.addUnits(Warrior.Type.VAMPIRE, 1);
        army2.addUnits(Warrior.Type.HEALER, 5);
        army2.addUnits(Warrior.Type.KNIGHT, 2);

        var res = Battle.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Army fight")
    void test3() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.WARRIOR, 2);
        army1.addUnits(Warrior.Type.LANCER, 3);
        army1.addUnits(Warrior.Type.DEFENDER, 1);
        army1.addUnits(Warrior.Type.WARLORD, 4);
        army2.addUnits(Warrior.Type.WARLORD, 1);
        army2.addUnits(Warrior.Type.VAMPIRE, 1);
        army2.addUnits(Warrior.Type.ROOKIE, 1);
        army2.addUnits(Warrior.Type.KNIGHT, 1);
        army1.getTroops().get(0).equipWeapon(new Sword(new NoWeapon()));
        army2.getTroops().get(0).equipWeapon(new Shield(new NoWeapon()));
        var res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Army fight")
    void test4() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.WARRIOR, 2);
        army1.addUnits(Warrior.Type.LANCER, 3);
        army1.addUnits(Warrior.Type.DEFENDER, 1);
        army1.addUnits(Warrior.Type.WARLORD, 1);
        army2.addUnits(Warrior.Type.WARLORD, 5);
        army2.addUnits(Warrior.Type.VAMPIRE, 1);
        army2.addUnits(Warrior.Type.ROOKIE, 1);
        army2.addUnits(Warrior.Type.KNIGHT, 1);
        army1.getTroops().get(0).equipWeapon(new Sword(new NoWeapon()));
        army2.getTroops().get(0).equipWeapon(new Shield(new NoWeapon()));

        var res = Battle.straightFight(army1, army2);

        assertFalse(res);
    }

}
