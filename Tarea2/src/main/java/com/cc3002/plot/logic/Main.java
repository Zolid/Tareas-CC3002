package com.cc3002.plot.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
  
  static public void main(String[] agrs) throws IOException{
   
    /*List<Integer> list = new ArrayList<Integer>();
    
    for (int i = 10; i < 100; i+=10) {
      list.add(i);
    }
    
    System.out.println(list.toString());
    
    list = TruncateShafts.truncate(list, 30);
    
    System.out.println(list.toString());*/
    
    BarData data = new BarData();
    data.readFile("/home/zolid/Desktop/metodologias/plot.txt");
    data.order();
    System.out.println(data.getAxisX().toString());
    System.out.println(data.getAxisY().toString());
    
  }
  
}
