package war;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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