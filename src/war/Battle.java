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
        var warrior1 = army1.getArmy().poll();
        var warrior2 = army2.getArmy().poll();
        while(!army1.getArmy().isEmpty() && !army2.getArmy().isEmpty()){
            var res = fight(warrior1, warrior2);
            if(res){
                warrior2 = army2.getArmy().poll();
            } else {
                warrior1 = army1.getArmy().poll();
            }
        }
        return !army1.getArmy().isEmpty();
    }

}
