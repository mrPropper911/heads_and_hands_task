package by.belyahovich;

import by.belyahovich.util.InvalidValueException;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Player extends Creature{
    private static final int MAX_COUNT_OF_HEAL = 4;
    private static final double PERCENT_OF_HEAL = 0.3;
    private Integer countOfHeal = 0;

    public Integer getCountOfHeal() {
        return countOfHeal;
    }

    public void heal(){
        if (this.countOfHeal <= MAX_COUNT_OF_HEAL){
            int health = this.getHealth();
            try {
                int heal = (int)Math.round(health * PERCENT_OF_HEAL);
                int valueOfHeal = health + heal;
                this.countOfHeal++;
                System.out.print("player " + this.countOfHeal + "-healing for " + heal + " and take ");
                //if heal > max integer we add max hp
                if ((valueOfHeal) <= 0){
                    this.setHealth(Integer.MAX_VALUE);
                } else
                    this.setHealth(valueOfHeal);

            } catch (InvalidValueException ex){
                ex.printStackTrace();
            }
        } else {
            System.out.println("Exceeded number of healing...=(");
        }
    }

    public static Player createUserPlayer(){
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Attack of player [" + Creature.MIN_VALUE_OF_ATTACK + " , " + Creature.MAX_VALUE_OF_ATTACK + "] : ");
            player.setAttack(scanner.nextInt());
            System.out.println("Defence of player [" + Creature.MIN_VALUE_OF_DEFENCE + " , " + Creature.MAX_VALUE_OF_DEFENCE + "] : ");
            player.setDefense(scanner.nextInt());
            System.out.println("Health of player [" + Creature.MIN_VALUE_OF_HEALTH + ", max integer value] : ");
            player.setHealth(scanner.nextInt());
            System.out.println("Low damage of player and max damage");
            player.setDamage(new int[]{scanner.nextInt(), scanner.nextInt()});

        } catch (InvalidValueException e) {
            e.printStackTrace();
        }
        return player;
    }

    public static Player createRandomPlayer(){
        Player player = new Player();
        try {
            Random random = new Random();
            player.setAttack((int)(Math.random() * MAX_VALUE_OF_ATTACK) + MIN_VALUE_OF_ATTACK);
            player.setDefense((int)(Math.random() * MAX_VALUE_OF_DEFENCE) + MIN_VALUE_OF_DEFENCE);
            player.setHealth((random.nextInt(Integer.MAX_VALUE)));
            int lowDamage = random.nextInt(Integer.MAX_VALUE);
            int maxDamage = random.nextInt(Integer.MAX_VALUE - lowDamage);
            player.setDamage(new int[]{lowDamage, maxDamage});
        }catch (InvalidValueException ex){
            ex.printStackTrace();
        }
        return player;
    }

    @Override
    public String toString() {
        return  "   Attack=" + this.getAttack() +
                "\n   Defense = " + this.getDefense() +
                "\n   Health = " + this.getHealth() +
                "\n   Damage = " + Arrays.toString(this.getDamage()) +
                "\n   Death = " + this.isDeath() +
                "\n   Count Of Heal = " + countOfHeal;
    }
}
