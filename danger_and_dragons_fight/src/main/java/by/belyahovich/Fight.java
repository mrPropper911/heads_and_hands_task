package by.belyahovich;

import by.belyahovich.util.InvalidValueException;

public class Fight {
    public static final int NUMBER_OF_SIDES_OF_DICE = 6;
    public static final int SUCCESS_OF_ROLL = 5;
    private final Creature attacker;
    private final Creature defender;

    public Fight(Creature attacker, Creature defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public void round(){
        int rollOfDice = (int) (Math.random() * (attackModifier() + 1)) + 1; //[1 - attackModifier]
        for (int i = 0; i <= rollOfDice; i++){
            int roll = (int)(Math.random() * NUMBER_OF_SIDES_OF_DICE) + 1; //[1 - 6]
            if (roll >= SUCCESS_OF_ROLL){
                int damage = (int)(Math.random() * attacker.getDamage()[1]) + attacker.getDamage()[0]; //[M - N]
                System.out.print("for " + damage + " damage\n");
                try {
                    int health = defender.getHealth() - damage;
                    if (health <= 0){
                        defender.setHealth(0);
                        defender.setDeath(true);
                    } else {
                        defender.setHealth(health);
                    }
                } catch (InvalidValueException ex) {
                    ex.printStackTrace();
                }
                return;
            }
        }
        System.out.print("...no one shed blood...\n");
    }

    private int attackModifier (){
        return attacker.getAttack() - defender.getDefense() + 1;
    }
}
