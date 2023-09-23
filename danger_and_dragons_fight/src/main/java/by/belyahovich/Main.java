package by.belyahovich;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        initGame();
    }

    private static void initGame() {
        boolean runChecker = true;
        while (runChecker) {
            System.out.println("""
                    Welcome to Dungeons and Dragons !!!

                    Select the desired category:
                    1 - Create random match
                    2 - Create user match
                    0 - Exit""");
            Scanner scanner = new Scanner(System.in);
            int userChoose = scanner.nextInt();
            switch (userChoose) {
                case 0 -> {
                    runChecker = false;
                    System.out.println("Good luck...");
                }
                case 1 -> createRandomMatch();
                case 2 -> createUserMatch();
                default -> System.err.println("Unknown command. Try again ...\n");
            }
        }
    }

    private static void createRandomMatch() {
        System.out.println("\nRANDOM DEATH MATCH !!!\n");

        Player player = Player.createRandomPlayer();
        System.out.println("Player: \n" + player + "\n");

        int countOfMonsters = (int) ((Math.random() * Monster.MAX_COUNT_OF_MONSTER) + 1);
        System.out.println("Count of monster: " + countOfMonsters);
        List<Monster> listOfMonsters = new ArrayList<>(countOfMonsters);

        for (int i = 0; i < countOfMonsters; i++) {
            Monster newMonster = Monster.createRandomMonster();
            listOfMonsters.add(newMonster);
            System.out.println(newMonster);
        }

        createMatch(player, listOfMonsters);
    }

    private static void createUserMatch() {
        System.out.println("\nUSER DEATH MATCH !!!\n");

        Player player = Player.createUserPlayer();
        System.out.println("Player: \n" + player + "\n");


        System.out.println("Enter count of monster: ");
        Scanner scanner = new Scanner(System.in);
        int countOfMonsters = scanner.nextInt();

        List<Monster> listOfMonsters = new ArrayList<>(countOfMonsters);

        for (int i = 0; i < countOfMonsters; i++) {
            Monster newMonster = Monster.createUserMonster();
            listOfMonsters.add(newMonster);
            System.out.println(newMonster);
        }

        createMatch(player, listOfMonsters);
    }

    private static void createMatch(Player player, List<Monster> listOfMonsters) {
        while (!player.isDeath() && listOfMonsters.size() != 0) {
            int move = (int) ((Math.random() * Monster.MAX_COUNT_OF_MONSTER) + 1);
            //MOVE OF MONSTERS
            if (move == Monster.MAX_COUNT_OF_MONSTER) {
                System.out.print("Monster attack player ");
                Fight fight = new Fight(listOfMonsters.get(0), player);
                if (player.getCountOfHeal() != 4) {
                    player.heal();
                }
                fight.round();
                if (player.isDeath()) {
                    System.out.println("The player lost . . .\n");
                }
                //PLAYER MOVE
            } else {
                System.out.print("Player attack monster ");
                Fight fight = new Fight(player, listOfMonsters.get(0));
                fight.round();
                if (listOfMonsters.get(0).isDeath()) {
                    listOfMonsters.remove(0);
                }
                if (listOfMonsters.size() == 0) {
                    System.out.println("The player WIN ! ! !\n");
                }
            }
        }
    }

}
