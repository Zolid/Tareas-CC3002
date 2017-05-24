package com.cc3002.plot.logic;

import java.util.ArrayList;
import java.util.List;

public class ConvertsLists {

	static List<Integer> stringListToIntegerList(List<String> stringList) {
		List<Integer> integerList = new ArrayList<Integer>();
		for (String value: stringList) {
			integerList.add(Integer.parseInt(value));
		}
		return integerList;
	}

	static List<String> integerListToStringList(List<Integer> integerList) {
		List<String> stringList = new ArrayList<String>();
		for (Integer value: integerList) {
			stringList.add(String.valueOf(value));
		}
		return stringList;
	}

}
