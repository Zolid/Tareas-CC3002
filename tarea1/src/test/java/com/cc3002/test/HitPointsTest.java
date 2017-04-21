package com.cc3002.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cc3002.logic.HitPoints;


public class HitPointsTest {
  
  private transient HitPoints life;


  @Before
  public void setUp() {
   life = new HitPoints(1000.0);
  
   
  }
  
  @Test
  public void pointsLifeTest() {
    assertEquals("Check for damage received",1000.0 , life.getHp(), 1000.0);
  }
  
  @Test
  public void checkDamageTest() {
    life.restLife(250.0);
    assertEquals("Check for damage accumulated", 250.0, life.getDamage(), 250.0);
  }
  
  @Test
  public void isDeadFalseTest() {
    assertFalse("Check if the life is not 0.0", life.isDead());
  }
  
  @Test
  public void isDeadTrueTest() {
    life.restLife(1000.0);
    assertTrue("Check if the life is 0.0", life.isDead());
  }
  
  
  
  
  

}
