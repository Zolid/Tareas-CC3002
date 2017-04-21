package com.cc3002.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cc3002.pkm.Aqua;
import com.cc3002.pkm.Fire;
import com.cc3002.pkm.Plant;
import com.cc3002.pkm.Pokemon;

public class BattleTest {
  
  private transient Pokemon pkm1;
  private transient Pokemon pkm2;
  private transient Pokemon pkm3;
  private transient Pokemon pkm4;

  @Before
  public void setUp() {
    pkm1 = new Fire("PokeTest1", 100.0, 1000.0);
    pkm2 = new Aqua("PokeTest2", 80.0, 1200.0);
    pkm3 = new Plant("PokeTest3", 70.0, 900.0);
    pkm4 = new Fire("PokeTest4", 50.0, 4000.0);
  }
  
  @Test
  public void hitTest() {
    pkm1.attack(pkm4);
    assertEquals("Check normal battle", 100.0, 
        pkm4.getObjectLife().getDamage(), 100.0);
  }
  
  @Test
  public void effectiveTest() {
    pkm1.attack(pkm3);
    assertEquals("Check normal battle", 200.0, 
        pkm3.getObjectLife().getDamage(), 200.0);
  }
  
  @Test
  public void ineffectiveTest() {
    pkm1.attack(pkm2);
    assertEquals("Check normal battle", 80.0, 
        pkm2.getObjectLife().getDamage(), 80.0);
  }

  

}
