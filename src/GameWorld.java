import java.util.Scanner;

public class GameWorld {
    private Player player;
    private Merchant merchant;
    private BattleManager battleManager;

    public GameWorld() {
        merchant = new Merchant();
        battleManager = new BattleManager();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя своего персонажа: ");
        String name = scanner.nextLine();
        player = new Player(name, 100, 10, 10);

        showMainMenu(scanner);
    }

    private void showMainMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nКуда отправитесь дальше?");
            System.out.println("1. Посетить торговца");
            System.out.println("2. Отправиться в Тёмный Лес");
            System.out.println("3. Проверить инвентарь и статус");
            System.out.println("4. Выход");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    visitMerchant();
                    break;
                case 2:
                    enterDarkForest();
                    break;
                case 3:
                    player.displayInfo();
                    break;
                case 4:
                    System.out.println("Прощайте!");
                    System.exit(0);
                default:
                    System.out.println("Ошибка выбора. Попробуйте снова.");
            }
        }
    }

    private void visitMerchant() {
        merchant.resetPotionStatus(); // Сброс состояния покупки
        merchant.interact(player);
    }

    private void enterDarkForest() {
        battleManager.startBattle(player);
    }

    public static void main(String[] args) {
        GameWorld game = new GameWorld();
        game.start();
    }
}