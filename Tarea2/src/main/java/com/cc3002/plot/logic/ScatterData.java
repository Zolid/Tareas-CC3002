package com.cc3002.plot.logic;

import java.util.ArrayList;
import java.util.List;

public class ScatterData extends ProcesingData {

	public ScatterData() {
		super();
	}

	@Override
	public void order() {
		List<Integer> axisX = ConvertsLists.stringListToIntegerList(getAxisX());
		List<Integer> axisY = ConvertsLists.stringListToIntegerList(getAxisY());
		axisX = OrderValues.orderIntegerList(axisX);
		axisY = OrderValues.reverseOrderIntegerList(axisY);
		//axisY = TruncateShafts.truncate(axisY, axisY.get(axisY.size()-1));
		List<String> listX = ConvertsLists.integerListToStringList(axisX);
		List<String> listY = ConvertsLists.integerListToStringList(axisY);
		setAxisX(listX);
		setAxisY(listY);
	}

	public static void main(String[] agrs) {
		IProcesingData data = new ScatterData();
		data.readFile("/home/zolid/Desktop/metodologias/s.txt");
		data.order();
		System.out.println(data.getAxisX().toString());
		System.out.println(data.getAxisY().toString());

		System.out.println("");

		List<String> list = new ArrayList<String>();
		list.add("3,4");
		list.add("2,1");
		list.add("1,0");
		list.add("10,60");

		IProcesingData data2 = new ScatterData();
		data2.readTuple(list);
		data2.order();
		System.out.println(data2.getAxisX().toString());
		System.out.println(data2.getAxisY().toString());

	}

}
