package com.cc3002.jconsole.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cc3002.jconsole.data.BarData;
import com.cc3002.jconsole.data.IProcesingData;
import com.cc3002.jconsole.data.ScatterData;



public class ProcesingDataTest {
	
	IProcesingData data1 = new BarData();
	IProcesingData data2 = new BarData();
	
	
	@Before
	public void setUp() {
		data1.readFile("plot.txt");
		data1.order();
		List<String> list = new ArrayList<String>();
		list.add("B,90");
		list.add("A,60");
		list.add("C,50");
		list.add("D,20");
		list.add("F,100");
		list.add("E,70");
		data2.readTuple(list);
		data2.order();
 	}
	
	@Test
	public void getAxisXTest1() {
		String arrayString = data1.getAxisX().toString();
		String string = "[A, B, C, D, E, F]";
		assertEquals(string, arrayString);
	}
	
	@Test
	public void getAxisXTest2() {
		String arrayString = data2.getAxisX().toString();
		String string = "[A, B, C, D, E, F]";
		assertEquals(string, arrayString);
	}
	
	@Test
	public void getAxisYTest1() {
		String arrayString = data1.getAxisY().toString();
		String string = "[20]";
		assertEquals(string, arrayString);
	}
	
	@Test
	public void getAxisYTest2() {
		String arrayString = data2.getAxisY().toString();
		String string = "[20]";
		assertEquals(string, arrayString);
	}
	
	/*@Test
	public void acotateX() {
		IProcesingData data3 = new ScatterData();
		data3.readFile("data.txt");
		data3.order();
		data3.acotateXY(5, 50);
		assertEquals(data3.getAxisX().toString(), "[1, 2, 3, 4]");
	}*/
	
	

}
