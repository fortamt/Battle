package war;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArmyBattleTest {

    @ParameterizedTest
    @MethodSource("armyGenerate")
    @DisplayName("Army fight")
    void fight(Warrior.Type warrior1, int quantity1, Warrior.Type warrior2, int quantity2, boolean expected) {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(warrior1, quantity1);
        army2.addUnits(warrior2, quantity2);

        var res = Battle.fight(army1, army2);

        assertEquals(expected, res);
    }

    @Test
    @DisplayName("Army fight")
    void test1() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.WARRIOR, 5);
        army1.addUnits(Warrior.Type.DEFENDER, 4);
        army1.addUnits(Warrior.Type.DEFENDER, 5);
        army2.addUnits(Warrior.Type.WARRIOR, 4);
        var res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("Army fight")
    void test2() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.DEFENDER, 5);
        army1.addUnits(Warrior.Type.WARRIOR, 20);
        army2.addUnits(Warrior.Type.WARRIOR, 21);
        army1.addUnits(Warrior.Type.DEFENDER, 4);
        var res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("Army fight")
    void test3() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.WARRIOR, 10);
        army1.addUnits(Warrior.Type.DEFENDER, 5);
        army2.addUnits(Warrior.Type.WARRIOR, 5);
        army1.addUnits(Warrior.Type.DEFENDER, 10);
        var res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("Army fight")
    void test4() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.DEFENDER, 2);
        army1.addUnits(Warrior.Type.WARRIOR, 1);
        army1.addUnits(Warrior.Type.DEFENDER, 1);
        army2.addUnits(Warrior.Type.WARRIOR, 5);
        var res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("Army fight")
    void test5() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.DEFENDER, 2);
        army1.addUnits(Warrior.Type.VAMPIRE, 1);
        army1.addUnits(Warrior.Type.WARRIOR, 1);
        army2.addUnits(Warrior.Type.WARRIOR, 5);
        army2.addUnits(Warrior.Type.DEFENDER, 5);
        army2.addUnits(Warrior.Type.VAMPIRE, 5);
        var res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("Army fight")
    void test6() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.DEFENDER, 2);
        army1.addUnits(Warrior.Type.VAMPIRE, 3);
        army1.addUnits(Warrior.Type.WARRIOR, 4);
        army2.addUnits(Warrior.Type.WARRIOR, 4);
        army2.addUnits(Warrior.Type.DEFENDER, 4);
        army2.addUnits(Warrior.Type.VAMPIRE, 3);
        var res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("Army fight")
    void test7() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.DEFENDER, 11);
        army1.addUnits(Warrior.Type.VAMPIRE, 3);
        army1.addUnits(Warrior.Type.WARRIOR, 4);
        army2.addUnits(Warrior.Type.WARRIOR, 4);
        army2.addUnits(Warrior.Type.DEFENDER, 4);
        army2.addUnits(Warrior.Type.VAMPIRE, 13);
        var res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("Army fight")
    void test8() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.DEFENDER, 9);
        army1.addUnits(Warrior.Type.VAMPIRE, 3);
        army1.addUnits(Warrior.Type.WARRIOR, 8);
        army2.addUnits(Warrior.Type.WARRIOR, 4);
        army2.addUnits(Warrior.Type.DEFENDER, 4);
        army2.addUnits(Warrior.Type.VAMPIRE, 13);
        var res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("Army fight")
    void test9() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.LANCER, 5);
        army1.addUnits(Warrior.Type.VAMPIRE, 3);
        army1.addUnits(Warrior.Type.WARRIOR, 4);
        army1.addUnits(Warrior.Type.DEFENDER, 2);
        army2.addUnits(Warrior.Type.WARRIOR, 4);
        army2.addUnits(Warrior.Type.DEFENDER, 4);
        army2.addUnits(Warrior.Type.VAMPIRE, 6);
        army2.addUnits(Warrior.Type.LANCER, 5);
        var res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("Army fight")
    void test10() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.LANCER, 7);
        army1.addUnits(Warrior.Type.VAMPIRE, 3);
        army1.addUnits(Warrior.Type.WARRIOR, 4);
        army1.addUnits(Warrior.Type.DEFENDER, 2);
        army2.addUnits(Warrior.Type.WARRIOR, 4);
        army2.addUnits(Warrior.Type.DEFENDER, 4);
        army2.addUnits(Warrior.Type.VAMPIRE, 6);
        army2.addUnits(Warrior.Type.LANCER, 4);
        var res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("Army fight")
    void test11() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.LANCER, 7);
        army1.addUnits(Warrior.Type.VAMPIRE, 3);
        army1.addUnits(Warrior.Type.HEALER, 1);
        army1.addUnits(Warrior.Type.WARRIOR, 4);
        army1.addUnits(Warrior.Type.HEALER, 1);
        army1.addUnits(Warrior.Type.DEFENDER, 2);
        army2.addUnits(Warrior.Type.WARRIOR, 4);
        army2.addUnits(Warrior.Type.DEFENDER, 4);
        army2.addUnits(Warrior.Type.HEALER, 1);
        army2.addUnits(Warrior.Type.VAMPIRE, 6);
        army2.addUnits(Warrior.Type.LANCER, 4);
        var res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("Army fight")
    void test12() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.LANCER, 1);
        army1.addUnits(Warrior.Type.WARRIOR, 3);
        army1.addUnits(Warrior.Type.HEALER, 1);
        army1.addUnits(Warrior.Type.WARRIOR, 4);
        army1.addUnits(Warrior.Type.HEALER, 1);
        army1.addUnits(Warrior.Type.KNIGHT, 2);
        army2.addUnits(Warrior.Type.WARRIOR, 4);
        army2.addUnits(Warrior.Type.DEFENDER, 4);
        army2.addUnits(Warrior.Type.HEALER, 1);
        army2.addUnits(Warrior.Type.VAMPIRE, 6);
        army2.addUnits(Warrior.Type.LANCER, 4);
        var res = Battle.fight(army1, army2);
        assertFalse(res);
    }


    private static Stream<Arguments> armyGenerate() {
        return Stream.of(
                Arguments.of(Warrior.Type.WARRIOR, 1, Warrior.Type.WARRIOR, 2, false),
                Arguments.of(Warrior.Type.WARRIOR, 2, Warrior.Type.WARRIOR, 3, false),
                Arguments.of(Warrior.Type.WARRIOR, 5, Warrior.Type.WARRIOR, 7, false),
                Arguments.of(Warrior.Type.WARRIOR, 20, Warrior.Type.WARRIOR, 21, true),
                Arguments.of(Warrior.Type.WARRIOR, 10, Warrior.Type.WARRIOR, 11, true),
                Arguments.of(Warrior.Type.WARRIOR, 11, Warrior.Type.WARRIOR, 7, true)
        );
    }
}