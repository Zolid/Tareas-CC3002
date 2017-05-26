package com.cc3002.jconsole.plot;

import java.util.List;

import com.cc3002.jconsole.data.IProcesingData;

/**
 * La Clase BarPlot encargada de plotear un grafico 
 * tipo BarPlot.
 */
public class BarPlot extends GraphPlot {

	/**
	 * Realiza una instancia de tipo BarPlot, 
	 * obteniendo los datos un archivo.
	 *
	 * @param data los datos
	 * @param path la ruta del archivo
	 */
	public BarPlot(IProcesingData data, String path) {
		super(data);
		getData().readFile(path);
		getData().order();
		setMatrix(getData().getAxisY().size()+2,getData().getAxisX().size()*2+
				getData().getAxisY().get(0).length()+1);
	}

	/**
	 * Realiza una instancia tipo BarPlot,
	 * obteniendo los datos de una lista de tuplas.
	 *
	 * @param data los datos
	 * @param tuples lista de tuplas
	 */
	public BarPlot(IProcesingData data, List<String> tuples) {
		super(data);
		getData().readTuple(tuples);
		getData().order();
		setMatrix(getData().getAxisY().size()+2,getData().getAxisX().size()*2+
				getData().getAxisY().get(0).length()+1);
	}

	/**
	 * Llena los datos del eje X.
	 */
	public void fillAxisX() {
		int num = getData().getAxisY().get(0).length()+2;
		int cnt = 0;
		for (int j = num; j < getColumns(); j+=2) {
			getMatrix()[getRows()-1][j] = getData().getAxisX().get(cnt).charAt(0);
			++cnt;
		}
	}

	/**
	 * Llena la concentracion de los datos del grafico
	 * del tipo BarPlot .
	 */
	public void fillGraph() {
		int num = getData().getAxisY().get(0).length()+2;
		int cnt = 0;
		for (int i = 0; i < getRows()-2;++i) {
			int valY = Integer.parseInt(getData().getAxisY().get(i));
			for (int j = num; j < getColumns(); j+=2) {
				int diccVal = Integer.parseInt(getData().getValue(String.valueOf(getData().getAxisX().get(cnt))));
				getMatrix()[i][j] = diccVal >= valY?'x':' ';
				cnt++;
			}
			cnt=0;
		}
	}
	
	

}
