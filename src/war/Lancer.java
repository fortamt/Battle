package war;

public class Lancer extends WarriorImpl {

    public Lancer() {
        super(6, 50);
    }

    @Override
    public int getInitHealth() {
        return 50;
    }

    @Override
    public void hit(Warrior warrior2) {
        var beforeHealth = warrior2.getHealth();
        warrior2.takeDamage(this);
        var damageVolume = beforeHealth - warrior2.getHealth();
        if (warrior2.getNext() != null) {
            warrior2.getNext().takeDamage(() -> damageVolume / 2);
        }
        underAttack(this);
    }
}
