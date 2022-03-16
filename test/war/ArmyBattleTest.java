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
    void fight(Warrior warrior1, int count1, Warrior warrior2, int count2, boolean expected) {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(warrior1, count1);
        army2.addUnits(warrior2, count2);
        var res = Battle.fight(army1, army2);
        assertEquals(expected, res);
    }

    private static Stream<Arguments> armyGenerate(){
        return Stream.of(
                Arguments.of(new Warrior(), 1, new Warrior(), 2, false),
                Arguments.of(new Warrior(), 2, new Warrior(), 3, false),
                Arguments.of(new Warrior(), 5, new Warrior(), 7, false),
                Arguments.of(new Warrior(), 20, new Warrior(), 21, true),
                Arguments.of(new Warrior(), 10, new Warrior(), 11, true),
                Arguments.of(new Warrior(), 11, new Warrior(), 7, true)
        );
    }
}