package war;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BattleLineArmyTest {

    @Test
    @DisplayName("Line fight mode")
    void straightFight() {
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

        var res = Battle.straightFight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Line fight mode")
    void straightFight1() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior.Type.LANCER, 4);
        army1.addUnits(Warrior.Type.WARRIOR, 3);
        army1.addUnits(Warrior.Type.HEALER, 1);
        army1.addUnits(Warrior.Type.WARRIOR, 4);
        army1.addUnits(Warrior.Type.HEALER, 1);
        army1.addUnits(Warrior.Type.KNIGHT, 2);
        army2.addUnits(Warrior.Type.WARRIOR, 4);
        army2.addUnits(Warrior.Type.DEFENDER, 4);
        army2.addUnits(Warrior.Type.HEALER, 1);
        army2.addUnits(Warrior.Type.VAMPIRE, 2);
        army2.addUnits(Warrior.Type.LANCER, 4);

        var res = Battle.straightFight(army1, army2);

        assertTrue(res);
    }
}