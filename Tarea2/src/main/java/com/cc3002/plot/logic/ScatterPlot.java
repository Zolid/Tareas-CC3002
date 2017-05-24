package com.cc3002.plot.logic;

import java.util.List;

public class ScatterPlot extends Graph {

	public ScatterPlot(IProcesingData data, String path) {
		super(data);
		getData().readFile(path);
		getData().order();
		setMatrix(getData().getAxisY().size()+2,getData().getAxisX().size()*2+
				getData().getAxisY().get(0).length()+2);
	}
	
	public ScatterPlot(IProcesingData data, List<String> tuples) {
		super(data);
		getData().readTuple(tuples);
		getData().order();
		setMatrix(getData().getAxisY().size()+2,getData().getAxisX().size()*2+
				getData().getAxisY().get(0).length()+1);
	}


	@Override
	public void fillAxisX() {
		int num = getData().getAxisY().get(0).length()+2;
		int cnt = 0;
		int j = num;
		while (j < getColumns()) {
			int len = getData().getAxisX().get(cnt).length();
			if (len > 1) {
				int i = 0;
				while (i != len) {
					getMatrix()[getRows()-1][j] = getData().getAxisX().get(cnt).charAt(i);
					++i;
					++j;
				}
				cnt++;
			} else {
				getMatrix()[getRows()-1][j] = getData().getAxisX().get(cnt).charAt(0);
				j+=2;
				cnt++;
			}
		}

	}

	@Override
	void fillGraph() {
		int num = getData().getAxisY().get(0).length()+2;
		int cnt = 0;
		for (int i = 0; i < getRows()-2;++i) {
			int valY = Integer.parseInt(getData().getAxisY().get(i));
			for (int j = num; j < getColumns(); j+=2) {
				int diccVal = Integer.parseInt(getData().getValue(String.valueOf(getData().getAxisX().get(cnt))));
				getMatrix()[i][j] = diccVal == valY?'x':' ';
				cnt++;
			}
			cnt=0;
		}

	}
}
