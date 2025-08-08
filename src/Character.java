abstract class Character {
    protected String name;
    protected int healthPoints;
    protected int maxHealthPoints;
    protected int strength;
    protected int agility;
    protected int gold;
    protected int experience;

    public Character(String name, int healthPoints, int strength, int agility) {
        this.name = name;
        this.maxHealthPoints = healthPoints;
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.agility = agility;
    }

    public void attack(Character target) {
        double critChance = Math.random() * 100;
        int damage = this.strength;

        if (critChance < 10) { // Критический шанс составляет примерно 10%
            damage *= 2;
            System.out.println(this.name + " нанес критический удар!");
        }

        if (Math.random() * 100 <= this.agility * 10) { // Увеличили множитель до 10
            System.out.println(this.name + " успешно атаковал " + target.getName());
            target.takeDamage(damage);
        } else {
            System.out.println(this.name + " промахнулся!");
        }
    }

    public void takeDamage(int damage) {
        this.healthPoints -= damage;
        if (this.healthPoints <= 0) {
            die();
        }
    }

    public abstract void die();

    public boolean isAlive() {
        return this.healthPoints > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExperience() {
        return experience;
    }

    public void addExperience(int exp) {
        this.experience += exp;
    }

    public void displayInfo() {
        System.out.println("Имя: " + name +
                "\nЗдоровье: " + healthPoints + "/" + maxHealthPoints +
                "\nСила: " + strength +
                "\nЛовкость: " + agility +
                "\nЗолото: " + gold +
                "\nОпыт: " + experience);
    }
}