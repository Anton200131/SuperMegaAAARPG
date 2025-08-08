public class Monster extends Character {
    public Monster(String name, int healthPoints, int strength, int agility) {
        super(name, healthPoints, strength, agility);
    }

    @Override
    public void die() {
        System.out.println(getName() + " повержен!");
    }
}

class Goblin extends Monster {
    public Goblin() {
        super("Гоблин", 20, 16, 14); // Увеличили силу и ловкость в 2 раза
    }
}

class Skeleton extends Monster {
    public Skeleton() {
        super("Скелет", 15, 20, 10); // Увеличили силу и ловкость в 2 раза
    }
}