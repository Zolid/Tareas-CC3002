package com.cc3002.plot.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.chart.Axis;

public abstract class ProcesingData implements IProcesingData{

	private List<String> axisX;
	private List<String> axisY;
	private Map<String, String> dicc;

	public ProcesingData() {
		axisX = new ArrayList<String>();
		axisY = new ArrayList<String>();
		dicc = new HashMap<String, String>();
	}

	public void setAxisX(List<String> list) {
		axisX = list;
	}

	public void setAxisY(List<String> list) {
		axisY = list;
	}

	public List<String> getAxisX() {
		return axisX;
	}

	public List<String> getAxisY() {
		return axisY;
	}

	public String getValue(String key) {
		return dicc.get(key);
	}

	public void readFile(String path) {
		try {
			File f  = new File(path);
			BufferedReader b = new BufferedReader(new FileReader(f));
			String line = "";
			String[] splitLine = null;
			while ((line = b.readLine()) != null) {
				splitLine = line.split(",");
				axisX.add(splitLine[0]);
				axisY.add(splitLine[1]);
				this.dicc.put(splitLine[0], splitLine[1]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readTuple(List<String> tuples) {
		for (String tuple: tuples) {
			String[] values = tuple.split(",");
			axisX.add(values[0]);
			axisY.add(values[1]);
			this.dicc.put(values[0], values[1]);
		}

	}
	
	public void acotateX(int num) {
		List<Integer> axisX = ConvertsLists.stringListToIntegerList(getAxisX());
		axisX = Range.range(axisX.get(0), num, 1);
		List<String> listX = ConvertsLists.integerListToStringList(axisX);
		setAxisX(listX);
	}
	
	public void acotateY(int num) {
		List<Integer> axisY = ConvertsLists.stringListToIntegerList(getAxisY());
		axisY = OrderValues.orderIntegerList(axisY);
		axisY = Range.range(axisY.get(0), num, 1);
		axisY = OrderValues.reverseOrderIntegerList(axisY);
		List<String> listY = ConvertsLists.integerListToStringList(axisY);
		setAxisY(listY);
	}
	
	public void acotateXY(int x, int y) {
		acotateY(y);
		acotateX(x);
	}

	public abstract void order();


	static public void main(String[] agrs) {
		IProcesingData b = new BarData();
		b.readFile("/home/zolid/Desktop/metodologias/plot.txt");
		b.order();
		b.acotateY(80);
		System.out.println(b.getAxisY().toString());
	}





}
