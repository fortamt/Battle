package war;

public interface Warrior extends HasAttack {

    enum Type {
        WARRIOR, KNIGHT, DEFENDER, ROOKIE, VAMPIRE, LANCER, HEALER, WARLORD
    }

    static Warrior of(Type type) {
        return switch (type) {
            case WARRIOR -> new WarriorImpl(5, 50);
            case KNIGHT -> new WarriorImpl(7, 50);
            case DEFENDER -> new Defender();
            case ROOKIE -> new WarriorImpl(1, 50);
            case VAMPIRE -> new Vampire();
            case LANCER -> new Lancer();
            case HEALER -> new Healer();
            case WARLORD -> new Warlord();
        };
    }

    int getHealth();

    int getInitHealth();

    int getInitHealthWithModifier();

    int getAttack();

    boolean isAlive();

    void equipWeapon(Weapon name);

    void hit(Warrior warrior2);

    void takeDamage(HasAttack warrior);

    Warrior getNext();

    void setNext(Warrior nextBehind);

    void setHealth(int health);

    void underAttack(Warrior thisWarrior);
}
