package war;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArmyBattleTest {

    @ParameterizedTest
    @MethodSource("armyGenerate")
    @DisplayName("Army fight")
    void fight(int warriorCount1, int knightCount1, int warriorCount2, int knightCount2, boolean expected) {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(warriorCount1, knightCount1);
        army2.addUnits(warriorCount2, knightCount2);
        var res = Battle.fight(army1, army2);
        assertEquals(expected, res);
    }

    private static Stream<Arguments> armyGenerate(){
        return Stream.of(
                Arguments.of(1, 0, 2, 0, false),
                Arguments.of(2, 0, 3, 0, false),
                Arguments.of(5, 0, 7, 0, false),
                Arguments.of(20, 0, 21, 0, true),
                Arguments.of(10, 0, 11, 0, true),
                Arguments.of(11, 0, 7, 0, true)
        );
    }
}