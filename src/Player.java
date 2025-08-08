public class Player extends Character {
    private int level = 1;

    public Player(String name, int healthPoints, int strength, int agility) {
        super(name, healthPoints, strength, agility);
    }

    @Override
    public void die() {
        System.out.println("Вы погибли! Игра окончена.");
        System.exit(0);
    }

    public void heal(int amount) {
        healthPoints += amount;
        if (healthPoints > maxHealthPoints) {
            healthPoints = maxHealthPoints;
        }
    }

    public void levelUp() {
        level++;
        System.out.println("Поздравляю! Вы достигли нового уровня (" + level + ").");
        strength++;
        agility++;
        maxHealthPoints += 10;
    }

    public void checkLevelUp() {
        if (experience >= Math.pow(level, 2) * 100) {
            levelUp();
        }
    }

    public int getLevel() {
        return level;
    }

    public void gainExperience(int exp) {
        addExperience(exp);
        checkLevelUp();
    }

    public void displayInfo() {
        System.out.println("Имя: " + name +
                "\nЗдоровье: " + healthPoints + "/" + maxHealthPoints +
                "\nСила: " + strength +
                "\nЛовкость: " + agility +
                "\nЗолото: " + gold +
                "\nОпыт: " + experience);
    }

    public void increaseAgility(int amount) {
        agility += amount;
    }

    public void increaseStrength(int amount) {
        strength += amount;
    }
}