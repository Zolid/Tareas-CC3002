package com.cc3002.jconsole.plot;

import com.cc3002.jconsole.data.IProcesingData;

public interface IGraphPlot {
	
	void setMatrix(int n, int m);
	
	void fillAxisY();
	
	void fillLineY();
	
	void fillLineX();
	
	int getRows();
	
	int getColumns();
	
	char[][] getMatrix();
	
	IProcesingData getData();
	
	String toString();
	
	String plot();
	
	void acotateY(int num);
	
	void acotateX(int num);
	
	void acotateXY(int x, int y);

}
