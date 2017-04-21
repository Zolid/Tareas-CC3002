package com.cc3002.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cc3002.pkm.Fire;
import com.cc3002.pkm.Plant;
import com.cc3002.pkm.Pokemon;

public class DiedPokemonTest {
  
  private transient Pokemon pkm1;
  private transient Pokemon pkm2;

  @Before
  public void setUp() throws Exception {
    pkm1 = new Fire("Chamander", 100.0, 1000.0);
    pkm2 = new Plant("Chikorita", 10.0, 100.0);
  }
  
  @Test
  public void noAttacktTest() {
    pkm1.attack(pkm2); //Pkm2 should be dead
    pkm2.attack(pkm1);
    
    assertEquals("Check if a pokemon died can attack",
        0.0, pkm1.getObjectLife().getDamage(), 0.0);
  }
  
  @Test
  public void pkm2IsDead() {
    pkm1.attack(pkm2);
    assertTrue("Check if a pkm2 is dead", 
        pkm2.getObjectLife().isDead());
  }

  

}
