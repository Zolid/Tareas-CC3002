package com.cc3002.plot.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Range implements Iterable<Integer> {

  private int limit;

  public Range(int limit) {
      this.limit = limit;
  }

  public Iterator<Integer> iterator() {
      final int max = limit;
      return new Iterator<Integer>() {

          private int current = 0;

          public boolean hasNext() {
              return current < max;
          }

          public Integer next() {
              if (hasNext()) {
                  return current++;   
              } else {
                  throw new NoSuchElementException("Range reached the end");
              }
          }

          public void remove() {
              throw new UnsupportedOperationException("Can't remove values from a Range");
          }
      };
  }
  
  static public List<Integer> range(int start, int end, int step) {
    int n = (int) Math.ceil((end-start)/(double)step);
    List<Integer> arange = new ArrayList<Integer>();
    for (int i = 0; i < n; i++)
        arange.add(i*step+start);
    return arange;
  }
}