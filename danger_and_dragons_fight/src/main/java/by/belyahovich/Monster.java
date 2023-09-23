package by.belyahovich;

import by.belyahovich.util.InvalidValueException;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Monster extends Creature{
    protected static final int MAX_COUNT_OF_MONSTER = 10;

    public static Monster createUserMonster(){
        Monster monster = new Monster();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Attack of monster [" + Creature.MIN_VALUE_OF_ATTACK + " , " + Creature.MAX_VALUE_OF_ATTACK + "] : ");
            monster.setAttack(scanner.nextInt());
            System.out.println("Defence of monster [" + Creature.MIN_VALUE_OF_DEFENCE + " , " + Creature.MAX_VALUE_OF_DEFENCE + "] : ");
            monster.setDefense(scanner.nextInt());
            System.out.println("Health of monster [" + Creature.MIN_VALUE_OF_HEALTH + ", max integer value] : ");
            monster.setHealth(scanner.nextInt());
            System.out.println("Low damage of monster and max damage");
            monster.setDamage(new int[]{scanner.nextInt(), scanner.nextInt()});

        } catch (InvalidValueException e) {
            e.printStackTrace();
        }
        return monster;
    }

    public static Monster createRandomMonster(){
        Monster monster = new Monster();
        try {
            Random random = new Random();
            monster.setAttack((int)(Math.random() * MAX_VALUE_OF_ATTACK) + MIN_VALUE_OF_ATTACK);
            monster.setDefense((int)(Math.random() * MAX_VALUE_OF_DEFENCE) + MIN_VALUE_OF_DEFENCE);
            monster.setHealth((random.nextInt(Integer.MAX_VALUE)));
            int lowDamage = random.nextInt(Integer.MAX_VALUE);
            int maxDamage = random.nextInt(Integer.MAX_VALUE - lowDamage);
            monster.setDamage(new int[]{lowDamage, maxDamage});
        }catch (InvalidValueException ex){
            ex.printStackTrace();
        }
        return monster;
    }

    @Override
    public String toString() {
        return  "attack=" + this.getAttack() +
                ", defense=" + this.getDefense() +
                ", health=" + this.getHealth() +
                ", damage=" + Arrays.toString(this.getDamage()) +
                ", death=" + this.isDeath();
    }
}
