package com.cc3002.jconsole.plot;

import com.cc3002.jconsole.data.IProcesingData;

/**
 * La Clase Graph es una clase abstracta
 * que implementa los metodos generales
 * para plotear los distintos de graficos.
 */
public abstract class GraphPlot implements IGraphPlot{

	/** Matriz que construye el grafico */
	private char[][] matrix;
	
	/** Los Datos  */
	private IProcesingData data;
	
	/** El stream para el plot del grafico. */
	private StringBuilder stream;

	/**
	 * Constructor para inicializar las subclases.
	 *
	 * @param data los datos
	 */
	public GraphPlot(IProcesingData data) {
		this.data =  data;
		this.stream = new StringBuilder();

	}

	/**
	 * Setea la matria.
	 *
	 * @param n el numero de filas
	 * @param m el numero de columnas
	 */
	public void setMatrix(int n, int m) {
		matrix = new char[n][m];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m;++j)
				getMatrix()[i][j] = ' ';
		}
	}

	/**
	 * Metodo encargado de llenar los datos del
	 * eje Y.
	 */
	public void fillAxisY() {
		int num = this.data.getAxisY().get(0).length();
		for (int i = 0; i < getRows()-2; ++i) {
			char[] values = this.data.getAxisY().get(i).toCharArray();
			int len1 = values.length;
			if (len1 < num) {
				matrix[i][len1] = ' ';
			}
			for (int j = 0; j < len1; ++j) {
				matrix[i][j] = values[j];
			}
		}
	}

	/**
	 * Llena la linea de separacion entre el eje Y
	 * y los datos del graficos.
	 */
	public void fillLineY() {
		int num = this.data.getAxisY().get(0).length();
		for (int i = 0; i < getRows()-2;++i) {
			matrix[i][num] = '|';
		}
	}

	/**
	 * Llena la linea de separacion entre el eje X
	 * y los datos del graficos.
	 */
	public void fillLineX() {
		int num = this.data.getAxisY().get(0).length();
		for (int j = num; j < getColumns(); ++j) {
			matrix[getRows()-2][j] = '=';
		}
	}

	/**
	 * Llena los datos del eje X.
	 */
	abstract void fillAxisX();

	/**
	 * Llena las concentracion de los grafico
	 * el tipo de relleno depende del grafico.
	 */
	abstract void fillGraph();

	/**
	 * Obtiene el numero de filas.
	 *
	 * @return el numero de filas
	 */
	public int getRows() {
		return matrix.length;
	}

	/**
	 * Obtiene el numero de columnas.
	 *
	 * @return el numero de columnas
	 */
	public int getColumns() {
		return matrix[0].length;
	}

	/**
	 * Obtiene la matriz.
	 *
	 * @return la matriz
	 */
	public char[][] getMatrix() {
		return matrix;
	}

	/**
	 * Retorna el Data Object con 
	 * los datos plotear.
	 *
	 * @return los datos
	 */
	public IProcesingData getData() {
		return data;
	}

	/**
	 * Retorna un String de la matriz que 
	 * plotea al grafico.
	 * @return un String del grafico
	 */
	public String toString() {
		for (int i = 0; i < getRows(); ++i) {
			stream.append(this.matrix[i]);
			stream.append(System.lineSeparator());
		}
		return stream.toString();
	}

	/**
	 * Plotea el grafico completo
	 * siguiendo el template method
	 * pattern.
	 *
	 * @return the string
	 */
	public String plot() {
		fillAxisY();
		fillLineY();
		fillLineX();
		fillAxisX();
		fillGraph();
		return toString();
	}
	
	/**
	 * Acota el eje Y.
	 *
	 * @param num numero a acotar
	 */
	public void acotateY(int num) {
		getData().acotateY(num);
		setMatrix(getData().getAxisY().size()+2,getData().getAxisX().size()*2+
				getData().getAxisY().get(0).length()+1);
	}
	
	/**
	 * Acota el eje X.
	 *
	 * @param num numero a acotar
	 */
	public void acotateX(int num) {
		getData().acotateX(num);
		setMatrix(getData().getAxisY().size()+2,getData().getAxisX().size()*2+
				getData().getAxisY().get(0).length()+1);
	}
	
	/**
	 * Acota el eje X y el eje Y.
	 *
	 * @param x el valor x a acotar
	 * @param y el valor y a acotar
	 */
	public void acotateXY(int x, int y) {
		getData().acotateXY(x, y);
		setMatrix(getData().getAxisY().size()+2,getData().getAxisX().size()*2+
				getData().getAxisY().get(0).length()+1);
	}



}
