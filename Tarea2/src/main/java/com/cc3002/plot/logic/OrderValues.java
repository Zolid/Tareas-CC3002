package com.cc3002.plot.logic;

import java.util.Collections;
import java.util.List;

/**
 * La Clase OrderValues ordena los valores 
 * en un ArrayList Object que almacena String
 * o Integer Object's.
 */
public class OrderValues {

	/**
	 * Ordena una lista lexicograficamente
	 * en orden ascendente.
	 * @param list la lista a ordenar
	 * @return una lista ordenada.
	 */
	static List<String> orderStringList(List<String> list) {
		Collections.sort(list);
		return list;
	}

	/**
	 * Reverse order string list.
	 * Ordena un ArrayList Object que 
	 * almacena String lexicograficamente
	 * en orden descendente.
	 * @param list la lista a ordenar
	 * @return una lista ordenada descentemente.
	 */
	static List<String> reverseOrderStringList(List<String> list) {
		Collections.sort(list, Collections.reverseOrder());
		return list;
	}

	/**
	 * Order integer list.
	 * Ordena un ArrayList Object que
	 * almacena Integer en orden
	 * ascendente
	 * @param list la lista a ordenar
	 * @return una lista ordenada.
	 */
	static List<Integer> orderIntegerList(List<Integer> list) {
		Collections.sort(list);
		return list;
	}

	/**
	 * Reverse order integer list.
	 * Ordena un ArrayList Object que 
	 * almacena Integer en 
	 * orden descendente.
	 * @param list the list
	 * @return the list
	 */
	static List<Integer> reverseOrderIntegerList(List<Integer> list) {
		Collections.sort(list, Collections.reverseOrder());
		return list;
	}



}
