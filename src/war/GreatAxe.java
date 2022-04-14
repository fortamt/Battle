package war;

public class GreatAxe extends WeaponDecorator {

    public GreatAxe(Weapon weapon) {
        super(weapon);
    }

    @Override
    public int getHealth() {
        return -15 + super.getHealth();
    }

    @Override
    public int getAttack() {
        return 5 + super.getAttack();
    }

    @Override
    public int getDefense() {
        return -2 + super.getDefense();
    }

    @Override
    public int getVampiring() {
        return 10 + super.getVampiring();
    }
}
