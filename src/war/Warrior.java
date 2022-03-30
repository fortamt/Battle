package war;

public interface Warrior extends HasAttack {

    enum Type {
        WARRIOR, KNIGHT, DEFENDER, ROOKIE, VAMPIRE, LANCER, HEALER
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
        };
    }

    int getHealth();

    int getInitHealth();

    int getAttack();

    boolean isAlive();

    void hit(Warrior warrior2);

    void takeDamage(HasAttack warrior);

    Warrior getNext();

    void setNext(Warrior nextBehind);

    void underAttack(WarriorImpl thisWarrior);
}
