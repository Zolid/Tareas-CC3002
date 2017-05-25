package com.cc3002.jconsole.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// TODO: Auto-generated Javadoc
/**
 * La Clase Range se encargar de 
 * distribuir los datos que se 
 * encuentran en un ArrayList
 * Object
 */
public class Range implements Iterable<Integer> {

	/** The limit. */
	private int limit;

	/**
	 * Realiza una nueva instancia de Range.
	 *
	 * @param limit the limit
	 */
	public Range(int limit) {
		this.limit = limit;
	}

	/**
	 * Metodo iterator que es pedido por
	 * la interface Iterable para iterar 
	 * datos sobre un ArrayList Object.
	 */
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

	/**
	 * Este metodo realiza la distribucion de datos
	 * empezando por start, donde las separacion 
	 * de los datos es por step, y el final de los datos
	 * estan acotados por end
	 *
	 * @param start el inicio
	 * @param end el fin
	 * @param step el paso
	 * @return the list
	 */
	static public List<Integer> range(int start, int end, int step) {
		int n = (int) Math.ceil((end-start)/(double)step);
		List<Integer> arange = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			arange.add(i*step+start);
		return arange;
	}
}