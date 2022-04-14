package war;

public class Katana extends WeaponDecorator {
    public Katana(Weapon weapon) {
        super(weapon);
    }

    @Override
    public int getHealth() {
        return -20 + super.getHealth();
    }

    @Override
    public int getAttack() {
        return 6 + super.getAttack();
    }

    @Override
    public int getDefense() {
        return -5 + super.getDefense();
    }

    @Override
    public int getVampiring() {
        return 50 + super.getVampiring();
    }
}
