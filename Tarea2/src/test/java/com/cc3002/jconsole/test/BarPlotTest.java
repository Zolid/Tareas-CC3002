package com.cc3002.jconsole.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cc3002.jconsole.data.BarData;
import com.cc3002.jconsole.data.IProcesingData;
import com.cc3002.jconsole.plot.BarPlot;
import com.cc3002.jconsole.plot.IGraphPlot;

public class BarPlotTest {
	
	private IProcesingData data = new BarData();
	String path = "plot.txt";
	private IGraphPlot g1 = new BarPlot(data, path);
	List<String> list = new ArrayList<String>();
	

	@Test
	public void plotFileTest() {
		String plot1 = g1.plot();
		int len1 = plot1.length();
		assertEquals(len1, 48);
		
	}
	
	@Test
	public void plotListTest() {
		List<String> list = new ArrayList<String>();
		list.add("B,90");
		list.add("A,60");
		list.add("C,50");
		list.add("D,20");
		list.add("F,100");
		list.add("E,70");
		
		IProcesingData data = new BarData();
		IGraphPlot g2 = new BarPlot(data, list);
		String plot = g2.plot();
		int len = plot.length();
		assertEquals(len, 48);
		
	}

}
