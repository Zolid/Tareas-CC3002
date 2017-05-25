package com.cc3002.plot.logic;

import java.util.List;

/**
 * The Interface IProcesingData.
 */
public interface IProcesingData {

	/**
	 * Read file.
	 *
	 * @param path the path
	 */
	void readFile(String path);

	/**
	 * Read tuple.
	 *
	 * @param tuples the tuples
	 */
	void readTuple(List<String> tuples);

	/**
	 * Order.
	 */
	void order();

	/**
	 * Gets the axis X.
	 *
	 * @return the axis X
	 */
	List<String> getAxisX();

	/**
	 * Gets the axis Y.
	 *
	 * @return the axis Y
	 */
	List<String> getAxisY();

	/**
	 * Gets the value.
	 *
	 * @param key the key
	 * @return the value
	 */
	String getValue(String key);
	
	/**
	 * Acotate X.
	 *
	 * @param num the num
	 */
	void acotateX(int num);
	
	/**
	 * Acotate Y.
	 *
	 * @param num the num
	 */
	void acotateY(int num);
	
	/**
	 * Acotate XY.
	 *
	 * @param x the x
	 * @param y the y
	 */
	void acotateXY(int x, int y);

}
