package war;


import java.util.ArrayDeque;
import java.util.Deque;

public class Army {
    private Deque<Warrior> force = new ArrayDeque<>();

    public Deque<Warrior> getForce() {
        return force;
    }

    public void addUnits(Warrior.Type type, int quantity) {
        for (int i = 0; i < quantity; i++) {
            if (!force.isEmpty()) {
                var warrior = Warrior.of(type);
                force.getLast().setNext(warrior);
                force.add(warrior);
            } else {
                force.add(Warrior.of(type));
            }
        }
    }
}
