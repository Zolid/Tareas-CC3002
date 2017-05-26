package com.cc3002.jconsole.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cc3002.jconsole.data.BarData;
import com.cc3002.jconsole.data.IProcesingData;
import com.cc3002.jconsole.data.ScatterData;
import com.cc3002.jconsole.plot.IGraphPlot;
import com.cc3002.jconsole.plot.ScatterPlot;

public class ScatterPlotTest {
	
	private IProcesingData data = new ScatterData();
	String path = "data.txt";
	private IGraphPlot g = new ScatterPlot(data, path);

	@Test
	public void readFileDataTest() {
		String plot = g.plot();
		assertEquals(plot.length(), 144);
		
	}
	
	@Test
	public void readListDataTest() {
		List<String> list = new ArrayList<String>();
		list.add("2,90");
		list.add("1,60");
		list.add("3,50");
		list.add("4,20");
		list.add("5,100");
		list.add("6,70");
		IGraphPlot g2 = new ScatterPlot(data, list);
		String plot2 = g2.plot();
		assertEquals(plot2.length(), 406);
		
	}
	
	@Test
	public void acotateX() {
		g.acotateX(5);
		assertEquals(g.getData().getAxisX().size(), 4);
	}
	
	@Test
	public void acotateY() {
		g.acotateY(70);
		assertEquals(g.getData().getAxisY().size(), 48);
	}

}
