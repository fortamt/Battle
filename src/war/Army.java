package war;


import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Warrior> force = new ArrayList<>();

    public List<Warrior> getForce() {
        return force;
    }

    public void addUnits(Warrior.Type type, int quantity) {
        for (int i = 0; i < quantity; i++) {
            if (!force.isEmpty()) {
                var warrior = Warrior.of(type);
                force.get(force.size() - 1).setNext(warrior);
                force.add(warrior);
            } else {
                force.add(Warrior.of(type));
            }
        }
    }
}
