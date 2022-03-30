package war;

public class Vampire extends WarriorImpl {

    private final int VAMPIRISM = 50;

    public Vampire() {
        super(4, 40);
    }

    public int getVampirism() {
        return VAMPIRISM;
    }

    @Override
    public int getInitHealth() {
        return 40;
    }

    @Override
    public void hit(Warrior warrior2) {
        var healthBefore = warrior2.getHealth();
        warrior2.takeDamage(this);
        var heal = (healthBefore - warrior2.getHealth()) * getVampirism() / 100;
        var vampireHealth = this.getHealth() + heal;
        setHealth(Math.min(vampireHealth, 40));
        underAttack(this);
    }
}
