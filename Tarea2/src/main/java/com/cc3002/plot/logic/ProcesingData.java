package com.cc3002.plot.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * Clase Abstracta que implementa el procesamiento
 * de datos general de los graficos (BarPlot o 
 * ScatterPlot).
 * @author zolid
 *
 */

public abstract class ProcesingData implements IProcesingData{

	/** El eje X. */
	private List<String> axisX;
	
	/** El eje Y. */
	private List<String> axisY;
	
	/** Diccionario. */
	private Map<String, String> dicc;

	/**
	 * Realiza una nueva instancia de ProcesingData.
	 */
	public ProcesingData() {
		axisX = new ArrayList<String>();
		axisY = new ArrayList<String>();
		dicc = new HashMap<String, String>();
	}

	/**
	 * Setea el axis X.
	 *
	 * @param lista de nuevo eje X
	 */
	public void setAxisX(List<String> list) {
		axisX = list;
	}

	/**
	 * Setea el axis Y.
	 *
	 * @param lista de nuevo eje Y
	 */
	public void setAxisY(List<String> list) {
		axisY = list;
	}

	/* (non-Javadoc)
	 * @see com.cc3002.plot.logic.IProcesingData#getAxisX()
	 */
	public List<String> getAxisX() {
		return axisX;
	}

	/**
	 * Getter de la variable axisY
	 * @return una lista del eje Y
	 */
	public List<String> getAxisY() {
		return axisY;
	}

	/**
	 * Devuelve el valor de una llave del dicc,
	 * donde el diccionario es el encargado de 
	 * realizar las comparaciones los elementos
	 * del los ejes, para ver donde va un X o un 
	 * espacio en blanco.
	 * @param
	 * @return 
	 */
	public String getValue(String key) {
		return dicc.get(key);
	}

	/**
	 * Este metodo lee los datos un archivo,
	 * almacenado en un directorio.
	 * @param String ruta del archivo a leer
	 */
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

	/**
	 * Este metodo lee los datos almacenado en 
	 * tuplas con tipo string.
	 * @param tuples lista de tuplas de datos
	 */
	public void readTuple(List<String> tuples) {
		for (String tuple: tuples) {
			String[] values = tuple.split(",");
			axisX.add(values[0]);
			axisY.add(values[1]);
			this.dicc.put(values[0], values[1]);
		}

	}
	
	/**
	 * Este metodo acota los datos del eje X
	 * solo datos tipo Integer
	 * @param num numero por el cual se acota
	 */
	public void acotateX(int num) {
		List<Integer> axisX = ConvertsLists.stringListToIntegerList(getAxisX());
		axisX = Range.range(axisX.get(0), num, 1);
		List<String> listX = ConvertsLists.integerListToStringList(axisX);
		setAxisX(listX);
	}
	
	/**
	 * Este metodo acota los datos del eje Y
	 * solo datos tipo Integer
	 * @param num numero por el cual se acota
	 */
	public void acotateY(int num) {
		List<Integer> axisY = ConvertsLists.stringListToIntegerList(getAxisY());
		axisY = OrderValues.orderIntegerList(axisY);
		axisY = Range.range(axisY.get(0), num, 1);
		axisY = OrderValues.reverseOrderIntegerList(axisY);
		List<String> listY = ConvertsLists.integerListToStringList(axisY);
		setAxisY(listY);
	}
	
	/**
	 * Este metodo acota los datos por ambos
	 * ejes, solo para datos tipo integer.
	 * @param x numero por el cual se acota
	 * @param y numero por el cual se acota
	 */
	public void acotateXY(int x, int y) {
		acotateY(y);
		acotateX(x);
	}

	public abstract void order();


}
