package com.cc3002.pkm;

import com.cc3002.logic.HitPoints;

public interface Pokemon {
  
  String getName();
  
  double getAttackPoint();
  
  HitPoints getObjectLife();
  
  void attack(Pokemon attacked);
  
  void battleWithPlantType(Plant plant);
  
  void battleWithFireType(Fire fire);
  
  void battleWithAguaType(Aqua agua);
  
  void battleWithElectricType(Electric electric);
  
  void battleWithEarthType(Earth earth);
  
  void battleWithPsychicType(Psychic psychic);
  
  void battleWithFightType(Fight fight);
  
  void battleWithNormalType(Normal normal);
}
