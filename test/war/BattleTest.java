package war;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BattleTest {

    @ParameterizedTest
    @MethodSource("provideFightersForResultOfFight")
    @DisplayName("Single fight result")
    void test(Warrior warrior1, Warrior warrior2, boolean expected) {
        var res = Battle.fight(warrior1, warrior2);
        assertEquals(expected, res);
    }

    @ParameterizedTest
    @MethodSource("isAliveFirstWarrior")
    @DisplayName("Who alive result")
    void test2(Warrior warrior1, Warrior warrior2, boolean expected) {
        Battle.fight(warrior1, warrior2);
        assertEquals(expected, warrior1.isAlive());
    }

    @ParameterizedTest
    @MethodSource("isAliveSecondWarrior")
    @DisplayName("Who alive result")
    void test3(Warrior warrior1, Warrior warrior2, boolean expected) {
        Battle.fight(warrior1, warrior2);
        assertEquals(expected, warrior2.isAlive());
    }

    @Test
    @DisplayName("Fight one by one")
    void test4() {
        var warrior1 = Warrior.of(Warrior.Type.WARRIOR);
        var warrior2 = Warrior.of(Warrior.Type.KNIGHT);
        var warrior3 = Warrior.of(Warrior.Type.WARRIOR);
        Battle.fight(warrior1, warrior2);
        var res = Battle.fight(warrior2, warrior3);
        assertFalse(res);
    }

    private static Stream<Arguments> isAliveSecondWarrior() {
        return Stream.of(
                Arguments.of(Warrior.of(Warrior.Type.WARRIOR), Warrior.of(Warrior.Type.WARRIOR), false),
                Arguments.of(Warrior.of(Warrior.Type.WARRIOR), Warrior.of(Warrior.Type.KNIGHT), true)
        );
    }

    private static Stream<Arguments> isAliveFirstWarrior() {
        return Stream.of(
                Arguments.of(Warrior.of(Warrior.Type.WARRIOR), Warrior.of(Warrior.Type.WARRIOR), true),
                Arguments.of(Warrior.of(Warrior.Type.KNIGHT), Warrior.of(Warrior.Type.WARRIOR), true)
        );
    }

    private static Stream<Arguments> provideFightersForResultOfFight() {
        return Stream.of(
                Arguments.of(Warrior.of(Warrior.Type.WARRIOR), Warrior.of(Warrior.Type.KNIGHT), false),
                Arguments.of(Warrior.of(Warrior.Type.WARRIOR), Warrior.of(Warrior.Type.WARRIOR), true)
        );
    }

}