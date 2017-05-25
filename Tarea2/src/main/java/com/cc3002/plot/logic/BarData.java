package com.cc3002.plot.logic;

import java.util.List;

/**
 * La Clase BarData es una subclase de la 
 * ProcesingData y realiza las operaciones 
 * de procesamiento especificos para los datos
 * de un grafico tipo BarPlot.
 */
public class BarData extends ProcesingData {
	
	/**
	 * Crea una nueva instancia del objeto BarData.
	 */
	public BarData() {
		super();
	}

	/**
	 * Este metodo se encarga de ordena los las variables
	 * de instancia del objeto (ordena ascendentemente los
	 * datos del eje x y descendentemente los datos del y), 
	 * y los setea al objeto.
	 */
	public void order() {
		setAxisX(OrderValues.orderStringList(getAxisX()));
		List<Integer> axisY = ConvertsLists.stringListToIntegerList(getAxisY());
		axisY = OrderValues.orderIntegerList(axisY);
		axisY = TruncateShafts.truncate(axisY, axisY.get(axisY.size()-1));
		axisY = OrderValues.reverseOrderIntegerList(axisY);
		List<String> listY = ConvertsLists.integerListToStringList(axisY);
		setAxisY(listY);
	}
}
