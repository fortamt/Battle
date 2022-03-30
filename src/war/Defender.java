package war;

public class Defender extends WarriorImpl {

    private final int DEFENSE = 2;

    Defender() {
        super(3, 60);
    }

    public int getDefense() {
        return DEFENSE;
    }

    @Override
    public void hit(Warrior warrior2) {
        warrior2.takeDamage(this);
        underAttack(this);
    }

    @Override
    public int getInitHealth() {
        return 60;
    }

    @Override
    public void takeDamage(HasAttack warrior) {
        var damage = Math.max(0, warrior.getAttack()) - getDefense();
        super.takeDamage(() -> damage);
    }


}
