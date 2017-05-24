package com.cc3002.plot.logic;

import java.util.List;

public class BarData extends ProcesingData {
  public BarData() {
    super();
  }
  
  public void order() {
    setAxisX(OrderValues.orderStringList(getAxisX()));
    List<Integer> axisY = ConvertsLists.stringListToIntegerList(getAxisY());
    axisY = OrderValues.orderIntegerList(axisY);
    axisY = TruncateShafts.truncate(axisY, axisY.get(axisY.size()-1));
    axisY = OrderValues.reverseOrderIntegerList(axisY);
    List<String> listY = ConvertsLists.integerListToStringList(axisY);
    setAxisY(listY);
  }
}
