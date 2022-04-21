package war;


import java.util.ArrayList;
import java.util.List;

import static java.util.function.Predicate.not;

public class Army {
    private List<Warrior> troops = new ArrayList<>();

    boolean hasWarlord = false;

    public List<Warrior> getTroops() {
        return troops;
    }

    public void addUnits(Warrior.Type type, int quantity) {
        if (type == Warrior.Type.WARLORD) {
            if (hasWarlord) {
                return;
            }
            troops.add(Warrior.of(type));
            hasWarlord = true;
            return;
        }
        for (int i = 0; i < quantity; i++) {
            troops.add(Warrior.of(type));
        }
    }

    public void moveUnits() {
        if (!hasWarlord) {
            return;
        }
        Warrior warlord = troops.stream().filter(Warlord.class::isInstance).findFirst().orElse(null);
        troops.remove(warlord);
        List<Warrior> result = new ArrayList<>();
        result.addAll(getLancer());
        result.addAll(getOther());
        try {
            result.addAll(1, getHealer());
        } catch (IndexOutOfBoundsException e) {
            result.addAll(getHealer());
        }
        result.add(warlord);
        troops = result;
    }

    private List<Warrior> getLancer() {
        List<Warrior> result = troops.stream().filter(Lancer.class::isInstance).toList();
        troops.removeAll(result);
        return result;
    }

    private List<Warrior> getHealer() {
        List<Warrior> result = troops.stream().filter(Healer.class::isInstance).toList();
        troops.removeAll(result);
        return result;
    }

    private List<Warrior> getOther() {
        List<Warrior> result = troops.stream().filter(not(Healer.class::isInstance)).toList();
        troops.removeAll(result);
        return result;
    }

    public void setNextBehind() {
        for (int i = 0; i < troops.size() - 1; i++) {
            troops.get(i).setNext(troops.get(i + 1));
        }
    }
}
