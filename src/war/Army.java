package war;


import java.util.LinkedList;
import java.util.Queue;

public class Army {
    private Queue<Warrior> force = new LinkedList<>();

    public Queue<Warrior> getForce() {
        return force;
    }

    public void addUnits(Warrior.Type type, int quantity) {
        for (int i = 0; i < quantity; i++) {
            force.add(Warrior.of(type));
        }
    }

//    public void addUnits(WarriorImpl prototype, int quantity) {
//        for (int i = 0; i < quantity; i++) {
//            force.add(prototype.clone());
//        }
//    }
//
//    public void addUnits(Class<? extends WarriorImpl> warriorClass, int quantity) {
//        try {
//            var constructor = warriorClass.getDeclaredConstructor();
//            constructor.setAccessible(true);
//            for (int i = 0; i < quantity; i++) {
//                WarriorImpl warrior = constructor.newInstance();
//                force.add(warrior);
//            }
//        } catch (ReflectiveOperationException e) {
//            e.printStackTrace();
//        }
//    }
}
