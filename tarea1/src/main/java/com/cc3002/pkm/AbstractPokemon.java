package com.cc3002.pkm;

import com.cc3002.logic.HitPoints;

/**
 * AbstractPokemon is the abstract class for all
 * pokemon types, this class allows you to define
 * the entity Pokemon, its giving name, hit points
 * and attack points. 
 * @author zolid
 *
 */
public abstract class AbstractPokemon implements Pokemon {
  
  /** The name. */
  private final transient String name;
  
  /** The damage. */
  private final transient double attackPoint;
  
  /** The life. */
  private final transient HitPoints hp;
  
  /**
   * Instantiates a new abstract Pokemon.
   *
   * @param name set the name of Pokemon.
   * @param damage set the attack points
   * @param life set the hit points.
   */
  
  public AbstractPokemon(final String name, 
      final double attackPoint, final double life) {
    this.name = name;
    this.attackPoint = attackPoint;
    this.hp = new HitPoints(life);
  }
  
  /**
   * Gets the name of Pokemon.
   * 
   * @return the name of Pokemon
   */
  
  public String getName() {
    return name;
  }
  
  /**
   * Gets the attack points
   * of a Pokemon.
   * 
   * @return the attack points
   */
  public double getAttackPoint() {
    return attackPoint;
  }
  
  /**
   * Gets the Hit Points Object.
   * 
   * @return hp the hit points
   */
  public HitPoints getObjectLife() {
    return hp;
  }
  
}
