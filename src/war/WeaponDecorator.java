package war;

public class WeaponDecorator implements Weapon {

    private Weapon wrappee;

    public WeaponDecorator(Weapon wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public int getHealth() {
        return wrappee.getHealth();
    }

    @Override
    public int getAttack() {
        return wrappee.getAttack();
    }

    @Override
    public int getDefense() {
        return wrappee.getDefense();
    }

    @Override
    public int getVampiring() {
        return wrappee.getVampiring();
    }

    @Override
    public int healPower() {
        return wrappee.healPower();
    }
}
