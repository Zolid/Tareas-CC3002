package com.cc3002.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cc3002.pkm.Aqua;
import com.cc3002.pkm.Earth;
import com.cc3002.pkm.Electric;
import com.cc3002.pkm.Fight;
import com.cc3002.pkm.Fire;
import com.cc3002.pkm.Normal;
import com.cc3002.pkm.Plant;
import com.cc3002.pkm.Pokemon;
import com.cc3002.pkm.Psychic;

public class AquaTest {
  
  private transient Pokemon pkm1;
  private transient Pokemon pkm2;
  private transient Pokemon pkm3;
  private transient Pokemon pkm4;
  private transient Pokemon pkm5;
  private transient Pokemon pkm6;
  private transient Pokemon pkm7;
  private transient Pokemon pkm8;
  private transient Pokemon pkm9;

  @Before
  public void setUp() throws Exception {
    pkm1 = new Aqua("aqua", 100.0, 1000.0);
    pkm2 = new Fire("fire", 100.0, 1000.0);
    pkm3 = new Plant("plant", 100.0, 1000.0);
    pkm4 = new Electric("electric", 100.0, 1000.0);
    pkm5 = new Earth("earth", 100.0, 1000.0);
    pkm6 = new Psychic("psychic", 100.0, 1000.0);
    pkm7 = new Fight("fight", 100.0, 1000.0);
    pkm8 = new Normal("Normal", 100.0, 1000.0);
    pkm9 = new Aqua("aqua2", 100.0, 1000.0);
  }

  @Test
  public void vsAqua() {
    pkm1.attack(pkm9);
    assertEquals("check damage agua to aqua", 100.0,
        pkm9.getObjectLife().getDamage(), 100.0);
  }
  
  @Test
  public void vsFire() {
    pkm1.attack(pkm2);
    assertEquals("check damage aqua to fire",200.0,
        pkm2.getObjectLife().getDamage(), 200.0);
  }
  
  @Test
  public void vsPlant() {
    pkm1.attack(pkm3);
    assertEquals("check damage aqua to plant", 80.0,
        pkm3.getObjectLife().getDamage(), 80.0);
  }
  
  
  @Test
  public void vsElectric() {
    pkm1.attack(pkm4);
    assertEquals("check damage aqua to electric", 80.0,
        pkm4.getObjectLife().getDamage(), 80.0);
  }
  
  
  @Test
  public void vsEarth() {
    pkm1.attack(pkm5);
    assertEquals("check damage aqua to earth", 100.0,
        pkm5.getObjectLife().getDamage(), 100.0);
  }
  
  @Test
  public void vsPsychic() {
    pkm1.attack(pkm6);
    assertEquals("check damage aqua to psychic", 100.0,
        pkm6.getObjectLife().getDamage(), 100.0);
  }
  
  @Test
  public void vsFight() {
    pkm1.attack(pkm7);
    assertEquals("check damage aqua to fight", 100.0,
        pkm7.getObjectLife().getDamage(), 100.0);
  }
  
  @Test
  public void vsNormal() {
    pkm1.attack(pkm8);
    assertEquals("check damage aqua to normal", 100.0,
        pkm8.getObjectLife().getDamage(), 100.0);
  }
  
  
}