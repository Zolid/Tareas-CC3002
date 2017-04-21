package com.cc3002.logic;

import com.cc3002.pkm.Pokemon;


/**
 * The Class Battle, This class is in charge of 
 * interacting the attacks of a pokemon to another,
 * following three classes of blows, normal, 
 * effective and ineffective.
 * 
 * @author zolid.
 */
final public class Battle {
  
  /** The increase. */
  static private transient double increase = 2.0;
  
  /** The reducer. */
  static private transient double reducer = 20.0;
  
  /**
   * Instantiates a new battle.
   */
  private Battle() {}
  
  /**
   * Normal hit, this attack is when, 
   * the pokemons have no advantage or disadvantage 
   * of types.
   * @param attacked the attacked
   * @param attacker the attacker
   */
  static public void hit(final Pokemon attacked, final Pokemon attacker) {
    attacked.getObjectLife().restLife(attacker.getAttackPoint());
  }
  
  /**
   * Effective hit, this attack happen when, 
   * the attacker have type advantage on the 
   * attacked Pokemon, wether the attacked to
   * receive the hit, he loss the double of 
   * attacker's PointAttack
   *
   * @param attacked the attacked
   * @param attacker the attacker
   */
  static public void effective(final Pokemon attacked, final Pokemon attacker) {
    
    attacked.getObjectLife().restLife(increase * attacker.getAttackPoint());
    
  }
  
  /**
   * Ineffective hit, this attack happen when, 
   * the attacker have type disadvantage on the 
   * attacked Pokemon, wether the attacked to
   * receive the hit, he loss attacker's 
   * PointAttack less reducer variable.
   * @param attacked the attacked
   * @param attacker the attacker
   */
  static public void ineffective(final Pokemon attacked, final Pokemon attacker) {
    attacked.getObjectLife().restLife(attacker.getAttackPoint() - reducer);
  }

}
