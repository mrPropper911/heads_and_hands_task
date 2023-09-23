package by.belyahovich;

import by.belyahovich.util.InvalidValueException;

public class Creature {
    protected static final int MIN_VALUE_OF_ATTACK = 1;
    protected static final int MAX_VALUE_OF_ATTACK = 30;
    protected static final int MIN_VALUE_OF_DEFENCE = 1;
    protected static final int MAX_VALUE_OF_DEFENCE = 30;
    protected static final int MIN_VALUE_OF_HEALTH = 0;

    private Integer attack; //[MIN_VALUE_OF_ATTACK - MAX_VALUE_OF_ATTACK]
    private Integer defense; //[MIN_VALUE_OF_DEFENCE - MAX_VALUE_OF_DEFENCE]
    private Integer health; //Value[0-N]
    private int[] damage = new int[2]; //Value[M - N]
    private boolean death = false;

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) throws InvalidValueException {
        if (attack < MIN_VALUE_OF_ATTACK || attack > MAX_VALUE_OF_ATTACK) {
            throw new InvalidValueException("Invalid value for attack");
        }
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) throws InvalidValueException {
        if (defense < MIN_VALUE_OF_DEFENCE || defense > MAX_VALUE_OF_DEFENCE) {
            throw new InvalidValueException("Invalid value for defence");
        }
        this.defense = defense;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) throws InvalidValueException {
        if (health < MIN_VALUE_OF_HEALTH) {
            throw new InvalidValueException("Invalid value for health");
        }
        this.health = health;
    }

    public boolean isDeath() {
        return death;
    }

    public void setDeath(boolean death) {
        this.death = death;
    }

    public int[] getDamage() {
        return damage;
    }

    public void setDamage(int[] damage) throws InvalidValueException {
        if ((damage[0] < 0) || (damage[1] < 0)) {
            throw new InvalidValueException("Invalid value for damage");
        }
        this.damage = damage;
    }


}
