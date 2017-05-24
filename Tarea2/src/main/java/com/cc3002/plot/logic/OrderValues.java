package com.cc3002.plot.logic;

import java.util.Collections;
import java.util.List;

public class OrderValues {
  
  static List<String> orderStringList(List<String> list) {
    Collections.sort(list);
    return list;
  }
  
  static List<String> reverseOrderStringList(List<String> list) {
    Collections.sort(list, Collections.reverseOrder());
    return list;
  }
  
  static List<Integer> orderIntegerList(List<Integer> list) {
    Collections.sort(list);
    return list;
  }
  
  static List<Integer> reverseOrderIntegerList(List<Integer> list) {
    Collections.sort(list, Collections.reverseOrder());
    return list;
  }
  
  

}
