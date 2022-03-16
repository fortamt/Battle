package war;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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

    private static Stream<Arguments> isAliveSecondWarrior(){
        return Stream.of(
                Arguments.of(new Warrior(), new Warrior(), false),
                Arguments.of(new Warrior(), new Knight(), true)
        );
    }

    private static Stream<Arguments> isAliveFirstWarrior(){
        return Stream.of(
                Arguments.of(new Warrior(), new Warrior(), true),
                Arguments.of(new Knight(), new Warrior(), true)
        );
    }

    private static Stream<Arguments> provideFightersForResultOfFight(){
        return Stream.of(
                Arguments.of(new Warrior(), new Knight(), false),
                Arguments.of(new Knight(), new Warrior(), true)
        );
    }

}