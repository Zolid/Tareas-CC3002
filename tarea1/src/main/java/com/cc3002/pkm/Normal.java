package com.cc3002.pkm;

import com.cc3002.logic.Battle;

/**
 * The Class Normal, is the class to set a new
 * Pokemon Normal Type.
 */
public class Normal extends AbstractPokemon {

  /**
   * Instantiates a new normal.
   *
   * @param name the name
   * @param damage the damage
   * @param life the life
   */
  public Normal(final String name, final double damage, 
      final double life) {
    super(name, damage, life);
  }

  /**
   * This method is called when a pokemon 
   * attacks another pokemon.
   * 
   * @param Pokemon pokemon to attack
   */
  public void attack(final Pokemon attacked) {
    if (!this.getObjectLife().isDead()) {
      attacked.battleWithNormalType(this); 
    }
  }

  /**
   * This method is called when a plant-type
   * pokemon attack a normal-type pokemon.
   * 
   * @param Plant Pokemon plant-type.
   */
  public void battleWithPlantType(final Plant plant) {
    Battle.hit(this, plant);
  }

  /**
   * This method is called when a fire-type
   * pokemon attack a normal-type pokemon.
   * 
   * @param Fire Pokemon fire-type.
   */
  public void battleWithFireType(final Fire fire) {
    Battle.hit(this, fire);
  }

  /**
   * This method is called when a aqua-type
   * pokemon attack a normal-type pokemon.
   * 
   * @param Aqua Pokemon aqua-type.
   */
  public void battleWithAguaType(final Aqua agua) {
    Battle.hit(this, agua);
  }

  /**
   * This method is called when a electric-type
   * pokemon attack a normal-type pokemon.
   * 
   * @param Electric Pokemon electric-type.
   */
  public void battleWithElectricType(final Electric electric) {
    Battle.hit(this, electric);
  }

  /**
   * This method is called when a earth-type
   * pokemon attack a normal-type pokemon.
   * 
   * @param Earth Pokemon earth-type.
   */
  public void battleWithEarthType(final Earth earth) {
    Battle.hit(this, earth);
  }

  /**
   * This method is called when a psychic-type
   * pokemon attack a normal-type pokemon.
   * 
   * @param Pyschic Pokemon psychic-type.
   */
  public void battleWithPsychicType(final Psychic psychic) {
    Battle.ineffective(this, psychic);
  }

  /**
   * This method is called when a fight-type
   * pokemon attack a normal-type pokemon.
   * 
   * @param Fight Pokemon fight-type.
   */
  public void battleWithFightType(final Fight fight) {
    Battle.effective(this, fight);
  }

  /**
   * This method is called when a normal-type
   * pokemon attack a normal-type pokemon.
   * 
   * @param Normal Pokemon normal-type.
   */
  public void battleWithNormalType(final Normal normal) {
    Battle.hit(this, normal);
  }

}
