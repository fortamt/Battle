package war;

import java.util.List;

public class Battle {

    private Battle() {
    }

    public static boolean fight(Warrior warrior1, Warrior warrior2) {
        while (true) {
            if (warrior1.isAlive()) {
                warrior1.hit(warrior2);
            } else {
                return false;
            }
            if (warrior2.isAlive()) {
                warrior2.hit(warrior1);
            } else {
                return true;
            }
        }
    }

    public static boolean fight(Army army1, Army army2) {
        while (true) {
            army1.moveUnits();
            army2.moveUnits();
            army1.setNextBehind();
            army2.setNextBehind();
            var warrior11 = army1.getTroops().get(0);
            var warrior22 = army2.getTroops().get(0);
            var res = Battle.fight(warrior11, warrior22);
            if (res) {
                army2.getTroops().remove(0);
            } else {
                army1.getTroops().remove(0);
            }
            if (res && !army2.getTroops().isEmpty()) {
                warrior22 = army2.getTroops().get(0);
            }
            if (!res && !army1.getTroops().isEmpty()) {
                warrior11 = army1.getTroops().get(0);
            }
            if (army1.getTroops().isEmpty() && !warrior11.isAlive()) {
                return false;
            }
            if (army2.getTroops().isEmpty() && !warrior22.isAlive()) {
                return true;
            }
        }
    }

    public static boolean straightFight(Army army1, Army army2) {
        army1.moveUnits();
        army2.moveUnits();
        int countPair = Math.min(army1.getTroops().size(), army2.getTroops().size());
        removeNextWarrior(army1.getTroops(), army2.getTroops());
        while (!army1.getTroops().isEmpty() && !army2.getTroops().isEmpty()) {
            for (int i = 0; i < countPair; i++) {
                Battle.fight(army1.getTroops().get(i), army2.getTroops().get(i));
            }
            countPair = calculatePairAfterLineFight(army1.getTroops(), army2.getTroops(), countPair);
        }
        return !army1.getTroops().isEmpty();
    }

    private static int calculatePairAfterLineFight(List<Warrior> lineArmy1, List<Warrior> lineArmy2, int countPair) {
        for (int j = 0; j < countPair; j++) {
            if (lineArmy1.get(j).getHealth() <= 0) {
                lineArmy1.remove(j);
            }
            if (lineArmy2.get(j).getHealth() <= 0) {
                lineArmy2.remove(j);
            }
            countPair = Math.min(lineArmy1.size(), lineArmy2.size());
        }
        return countPair;
    }

    private static void removeNextWarrior(List<Warrior> army1, List<Warrior> army2) {
        for (Warrior warrior : army1) {
            warrior.setNext(null);
        }
        for (Warrior warrior : army2) {
            warrior.setNext(null);
        }
    }


}
