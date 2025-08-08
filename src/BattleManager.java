import java.util.Random;

public class BattleManager {
    private Random random = new Random();

    public void startBattle(Player player) {
        Monster monster = generateRandomMonster();
        System.out.println("Вы столкнулись с " + monster.getName() + "! Битва началась...");

        while (player.isAlive() && monster.isAlive()) {
            player.attack(monster);
            if (!monster.isAlive()) break;
            monster.attack(player);
        }

        if (player.isAlive()) {
            awardVictory(player, monster);
        } else {
            System.out.println("Вы были побеждены.");
        }
    }

    private Monster generateRandomMonster() {
        return random.nextBoolean() ? new Goblin() : new Skeleton();
    }

    private void awardVictory(Player player, Monster monster) {
        int rewardExp = monster.getStrength() * 10;
        int[] possibleGoldRewards = {20, 50, 90, 120}; // Увеличили значения в 2 раза
        int rewardGold = possibleGoldRewards[random.nextInt(possibleGoldRewards.length)];

        player.gainExperience(rewardExp);
        player.setGold(player.getGold() + rewardGold); // Добавление золота к текущему значению

        System.out.println("Победа! Получено опыта: " + rewardExp + ", золота: " + rewardGold);
    }
}