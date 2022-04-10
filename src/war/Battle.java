package war;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Battle {
    private Battle() {
    }

    private final static Logger logger = Logger.getLogger(Battle.class.getName());

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
        var warrior11 = army1.getForce().get(0);
        var warrior22 = army2.getForce().get(0);
        while (true) {
            logger.entering(Battle.class.getName(), "fight");
            logger.log(Level.SEVERE, "enter");
            logger.log(Level.SEVERE, "warrior = " + warrior11.getClass().getName() + " health = " + warrior11.getHealth() + " strong = " + warrior11.getAttack());
            logger.log(Level.SEVERE, "warrior = " + warrior22.getClass().getName() + " health = " + warrior22.getHealth() + " strong = " + warrior22.getAttack());
            var res = Battle.fight(warrior11, warrior22);
            logger.log(Level.SEVERE, "warrior = " + warrior11.getClass().getName() + " health = " + warrior11.getHealth() + " strong = " + warrior11.getAttack());
            logger.log(Level.SEVERE, "warrior = " + warrior22.getClass().getName() + " health = " + warrior22.getHealth() + " strong = " + warrior22.getAttack());
            logger.log(Level.SEVERE, "out");
            logger.exiting(Battle.class.getName(), "fight");

            if (res) {
                army2.getForce().remove(0);
            } else {
                army1.getForce().remove(0);
            }
            if (res && !army2.getForce().isEmpty()) {
                warrior22 = army2.getForce().get(0);
            }
            if (!res && !army1.getForce().isEmpty()) {
                warrior11 = army1.getForce().get(0);
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
        int countPair = Math.min(army1.getForce().size(), army2.getForce().size());
        removeNextWarrior(army1.getForce(), army2.getForce());
        while (!army1.getForce().isEmpty() && !army2.getForce().isEmpty()) {
            for (int i = 0; i < countPair; i++) {
                Battle.fight(army1.getForce().get(i), army2.getForce().get(i));
            }
            countPair = calculatePairAfterLineFight(army1.getForce(), army2.getForce(), countPair);
        }
        return !army1.getForce().isEmpty();
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
