package com.cc3002.plot.logic;


public abstract class Graph {

	private char[][] matrix;
	private IProcesingData data;
	private StringBuilder stream;

	public Graph(IProcesingData data) {
		this.data =  data;
		this.stream = new StringBuilder();

	}

	public void setMatrix(int n, int m) {
		matrix = new char[n][m];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m;++j)
				getMatrix()[i][j] = ' ';
		}
	}

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

	public void fillLineY() {
		int num = this.data.getAxisY().get(0).length();
		for (int i = 0; i < getRows()-2;++i) {
			matrix[i][num] = '|';
		}
	}

	public void fillLineX() {
		int num = this.data.getAxisY().get(0).length();
		for (int j = num; j < getColumns(); ++j) {
			matrix[getRows()-2][j] = '=';
		}
	}

	abstract void fillAxisX();

	abstract void fillGraph();

	public int getRows() {
		return matrix.length;
	}

	public int getColumns() {
		return matrix[0].length;
	}

	public char[][] getMatrix() {
		return matrix;
	}

	public IProcesingData getData() {
		return data;
	}

	public String toString() {
		for (int i = 0; i < getRows(); ++i) {
			stream.append(this.matrix[i]);
			stream.append(System.lineSeparator());
		}
		return stream.toString();
	}

	public String plot() {
		fillAxisY();
		fillLineY();
		fillLineX();
		fillAxisX();
		fillGraph();
		return toString();
	}



}
