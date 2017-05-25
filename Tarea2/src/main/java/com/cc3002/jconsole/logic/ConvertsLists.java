package com.cc3002.jconsole.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * La Clase ConvertsLists se encarga 
 * de convertir un ArrayList Object que 
 * almacena String a un ArrayList Object
 * que almacena Integer y viceversa.
 */
public class ConvertsLists {

	/**
	 * String list to integer list.
	 * Convierte una lista de String a una lista de 
	 * Integer's
	 * @param stringList la string list a transformar
	 * @return una lista de Integer.
	 */
	public static List<Integer> stringListToIntegerList(List<String> stringList) {
		List<Integer> integerList = new ArrayList<Integer>();
		for (String value: stringList) {
			integerList.add(Integer.parseInt(value));
		}
		return integerList;
	}

	/**
	 * Integer list to string list.
	 * Convierte una lista de Integer a una lista
	 * de String's.
	 * @param integerList la integer list a transformar.
	 * @return una lista de String.
	 */
	public static List<String> integerListToStringList(List<Integer> integerList) {
		List<String> stringList = new ArrayList<String>();
		for (Integer value: integerList) {
			stringList.add(String.valueOf(value));
		}
		return stringList;
	}

}
