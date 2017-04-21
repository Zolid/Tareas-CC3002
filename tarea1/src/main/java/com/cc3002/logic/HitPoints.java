package com.cc3002.logic;


/**
 * The Class Hit Points, it's the class 
 * in charge to set the life points and damage 
 * received for a pokemon.
 *
 * @author zolid
 */

public class HitPoints {
  
  /** The damage received. */
  private transient double damage;
  
  /** The full life. */
  private transient double hp;
  
  /**
   * Instantiates a new Hit Points.
   * For default the damage for a new 
   * pokemon is 0.0
   * @param hp the points life
   */
  public HitPoints(final double hp) {
    this.damage = 0.0;
    this.hp = hp;
  }
  
  /**
   * Reduces hitpoints and,
   *  when another pokemen attack him.
   * 
   * @param damage the damage
   */
  public void restLife(final double damage) {
    this.damage += damage;
  }
  
  /**
   * Gets the total life.
   *
   * @return the total life
   */
  public double getHp() {
    return hp;
  }
  
  /**
   * Get the Received damage.
   *
   * @return the damage received
   */
  public double getDamage() {
    return damage;
  }
  
  /**
   * Checks if is dead.
   *
   * @return true, if is dead
   */
  public boolean isDead() {
    return getDamage() >= getHp();
  }
  
  

}
