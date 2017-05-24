package com.cc3002.plot.logic;

import java.util.List;

public interface IProcesingData {

	void readFile(String path);

	void readTuple(List<String> tuples);

	void order();

	List<String> getAxisX();

	List<String> getAxisY();

	String getValue(String key);

}
