package war;

import java.util.ArrayList;
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
        var warrior11 = army1.getForce().poll();
        var warrior22 = army2.getForce().poll();
        while (true) {
            var res = Battle.fight(warrior11, warrior22);
            if (res && !army2.getForce().isEmpty()) {
                warrior22 = army2.getForce().poll();
            }
            if (!res && !army1.getForce().isEmpty()) {
                warrior11 = army1.getForce().poll();
            }
            if (army1.getForce().isEmpty() && !warrior11.isAlive()) {
                return false;
            }
            if (army2.getForce().isEmpty() && !warrior22.isAlive()) {
                return true;
            }
        }
    }

    public static boolean straightFight(Army army1, Army army2) {
        List<Warrior> lineArmy1 = new ArrayList<>(army1.getForce());
        List<Warrior> lineArmy2 = new ArrayList<>(army2.getForce());
        int countPair = Math.min(lineArmy1.size(), lineArmy2.size());
        removeNextWarrior(lineArmy1, lineArmy2);
        while (!lineArmy1.isEmpty() && !lineArmy2.isEmpty()) {
            for (int i = 0; i < countPair; i++) {
                Battle.fight(lineArmy1.get(i), lineArmy2.get(i));
            }
            countPair = calculatePairAfterLineFight(lineArmy1, lineArmy2, countPair);
        }
        return !lineArmy1.isEmpty();
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
