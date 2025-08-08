import java.util.Scanner;

public class Merchant {
    private static final int HEALING_POTION_COST = 50;
    private static final int ENDURANCE_POTION_COST = 150;
    private static final int STRENGTH_POTION_COST = 200;
    private boolean potionBought = false;

    public void resetPotionStatus() {
        potionBought = false;
    }

    public void interact(Player player) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Добро пожаловать в лавку торговца.\nЧто желаете сделать?");
            System.out.println("1. Купите зелье исцеления (+20 здоровья) - " + HEALING_POTION_COST + " золота");
            System.out.println("2. Купите элексир выносливости (+3 выносливости) - " + ENDURANCE_POTION_COST + " золота");
            System.out.println("3. Купите элексир силы (+3 силы) - " + STRENGTH_POTION_COST + " золота");
            System.out.println("4. Покинуть магазин");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (!potionBought && player.getGold() >= HEALING_POTION_COST) {
                        player.heal(20);
                        player.setGold(player.getGold() - HEALING_POTION_COST);
                        potionBought = true;
                        System.out.println("Вы купили зелье исцеления. Ваше здоровье восстановилось на 20 пунктов.");
                    } else {
                        System.out.println("Недостаточно денег или уже куплен предмет.");
                    }
                    break;
                case 2:
                    if (!potionBought && player.getGold() >= ENDURANCE_POTION_COST) {
                        player.increaseAgility(3);
                        player.setGold(player.getGold() - ENDURANCE_POTION_COST);
                        potionBought = true;
                        System.out.println("Вы купили элексир выносливости. Ваша выносливость увеличилась на 3 единицы.");
                    } else {
                        System.out.println("Недостаточно денег или уже куплен предмет.");
                    }
                    break;
                case 3:
                    if (!potionBought && player.getGold() >= STRENGTH_POTION_COST) {
                        player.increaseStrength(3);
                        player.setGold(player.getGold() - STRENGTH_POTION_COST);
                        potionBought = true;
                        System.out.println("Вы купили элексир силы. Ваша сила увеличилась на 3 единицы.");
                    } else {
                        System.out.println("Недостаточно денег или уже куплен предмет.");
                    }
                    break;
                case 4:
                    System.out.println("Вы покинули магазин.");
                    return;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}