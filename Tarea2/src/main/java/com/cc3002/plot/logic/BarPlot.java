package com.cc3002.plot.logic;

import java.util.ArrayList;
import java.util.List;

public class BarPlot extends Graph {

  public BarPlot(IProcesingData data, String path) {
    super(data);
    getData().readFile(path);
    getData().order();
    setMatrix(getData().getAxisY().size()+2,getData().getAxisX().size()*2+
                                                     getData().getAxisY().get(0).length()+1);
    
    
  }
  
  public BarPlot(IProcesingData data, List<String> tuples) {
    super(data);
    getData().readTuple(tuples);
   getData().order();
    setMatrix(getData().getAxisY().size()+2,getData().getAxisX().size()*2+
                                                     getData().getAxisY().get(0).length()+1);
  }
  
  public void fillGraph() {
    int num = getData().getAxisY().get(0).length()+2;
    int cnt = 0;
    for (int i = 0; i < getRows()-2;++i) {
      int valY = Integer.parseInt(getData().getAxisY().get(i));
      for (int j = num; j < getColumns(); j+=2) {
        int diccVal = Integer.parseInt(getData().getValue(String.valueOf(getData().getAxisX().get(cnt))));
        getMatrix()[i][j] = diccVal >= valY?'x':' ';
        cnt++;
      }
      cnt=0;
    }
  }
  
  static public void main(String[] agrs) {
    /**
     * B,90
A,61
C,50
D,21
E,70
     */
    List<String> list = new ArrayList<String>();
    list.add("B,90");
    list.add("A,61");
    list.add("C,50");
    list.add("D,21");
    list.add("E,70");
    IProcesingData d = new BarData();
    IProcesingData d2 = new BarData();
    Graph g = new BarPlot(d, "/home/zolid/Desktop/metodologias/plot.txt");
    System.out.println(g.plot());
    /*Graph g2 = new BarPlot(d2, list);
    System.out.println(g2.plot());
    System.out.println("");
    System.out.println(d2.getAxisX().toString());
    System.out.println(d2.getAxisY().toString());*/
  }

}
