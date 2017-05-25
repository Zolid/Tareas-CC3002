package com.cc3002.plot.logic;

import java.util.ArrayList;
import java.util.List;

public class TruncateShafts {
  
  private static Integer digits = 1;
   
  static public List<Integer> truncate(List<Integer> list, Integer num) {
    List<Integer> newList = new ArrayList<Integer>();
    if (list.get(0).toString().length() > 1 && list.get(list.size()-1).toString().length() > 1){
      digits *= 10;
      Integer exp = list.get(0).toString().length();
      digits = (int) Math.pow(digits, exp-1);
      newList = Range.range(list.get(0), num+1, digits);
      return newList;
    } else 
    	newList = Range.range(list.get(0), num+1, digits);
    return newList;
  }
  
  static public void main(String[] agrs) {
	  List<Integer> list = new ArrayList<Integer>();
	  for (int i= 10; i < 100; i+=10) {
		  list.add(i);
	  }
	  list = TruncateShafts.truncate(list, 100);
	  list = TruncateShafts.truncate(list, 80);
	  System.out.println(list.toString());
  }
  
}
