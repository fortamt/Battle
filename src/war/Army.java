package war;


import java.util.Queue;

public class Army {
    private Queue<Warrior> army;

    public Queue<Warrior> getArmy() {
        return army;
    }

    public void addUnits(Warrior warrior, int count){
        for(int i = 0; i < count; i++){
            army.add(warrior);
        }
    }
}
