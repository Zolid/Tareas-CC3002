package com.cc3002.plot.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public abstract void order();








}
