package com.cc3002.plot.logic;

import java.util.List;


/**
 * La Clase ScatterData es una subclase de la 
 * ProcesingData y realiza las operaciones 
 * de procesamiento especificos para los datos
 * de un grafico tipo ScatterPlot.
 */
public class ScatterData extends ProcesingData {

	/**
	 * Crea una nueva instancia del objeto ScatterData.
	 */
	public ScatterData() {
		super();
	}

	/**
	 * Este metodo se encarga de ordena los las variables
	 * de instancia del objeto (ordena ascendentemente los
	 * datos del eje x y descendentemente los datos del y), 
	 * y los setea al objeto.
	 */
	@Override
	public void order() {
		List<Integer> axisX = ConvertsLists.stringListToIntegerList(getAxisX());
		List<Integer> axisY = ConvertsLists.stringListToIntegerList(getAxisY());
		axisX = OrderValues.orderIntegerList(axisX);
		axisY = OrderValues.reverseOrderIntegerList(axisY);
		List<String> listX = ConvertsLists.integerListToStringList(axisX);
		List<String> listY = ConvertsLists.integerListToStringList(axisY);
		setAxisX(listX);
		setAxisY(listY);
	}
}
