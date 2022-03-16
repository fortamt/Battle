package war;


import java.util.LinkedList;
import java.util.Queue;

public class Army {
    private Queue<Warrior> force = new LinkedList<>();

    public Queue<Warrior> getForce() {
        return force;
    }

    public void addUnits(int warriorCount, int knightCount){
        for(int i = 0; i < warriorCount; i++){
            force.add(new Warrior());
        }
        for(int i = 0; i < knightCount; i++){
            force.add(new Knight());
        }
    }
}
