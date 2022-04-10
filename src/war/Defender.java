package war;

public class Defender extends WarriorImpl {

    private int defense = 2;

    Defender() {
        super(3, 60);
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public void hit(Warrior warrior2) {
        warrior2.takeDamage(this);

    }

    @Override
    public int getInitHealth() {
        return 60;
    }

    @Override
    public void takeDamage(HasAttack warrior) {
        var damage = Math.max(0, warrior.getAttack()) - getDefense();
        super.takeDamage(() -> damage);
        underAttack(this);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        this.defense += weapon.getDefense();
    }
}
