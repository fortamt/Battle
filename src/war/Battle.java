package war;

public class Battle {
    private Battle(){}

    public static boolean fight(Warrior warrior1, Warrior warrior2){
        while(true) {
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

    public static boolean fight(Army army1, Army army2){
//        var warrior1 = army1.getArmy().poll();
//        var warrior2 = army2.getArmy().poll();
//        do {
//            var res = fight(warrior1, warrior2);
//            if(res){
//                warrior2 = army2.getArmy().poll();
//            } else {
//                warrior1 = army1.getArmy().poll();
//            }
//        } while (!army1.getArmy().isEmpty() && !army2.getArmy().isEmpty());
//        return !army1.getArmy().isEmpty();


        var warrior11 = army1.getForce().poll();
        var warrior22 = army2.getForce().poll();
        while(true){
            var res = Battle.fight(warrior11, warrior22);
            if(res && !army2.getForce().isEmpty()){
                warrior22 = army2.getForce().poll();
            }
            if(!res && !army1.getForce().isEmpty()){
                warrior11 = army1.getForce().poll();
            }
            if(army1.getForce().isEmpty() && !warrior11.isAlive()){
                return false;
            }
            if(army2.getForce().isEmpty() && !warrior22.isAlive()){
                return true;
            }
        }
    }

}
