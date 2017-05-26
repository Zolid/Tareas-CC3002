package com.cc3002.jconsole.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cc3002.jconsole.logic.OrderValues;

public class OrderValuesTest {
	
	private List<String> list1 = new ArrayList<String>();
	private List<String> list2 = new ArrayList<String>();

	@Test
	public void test() {
		list1.add("A");
		list1.add("C");
		list1.add("B");
		OrderValues.reverseOrderStringList(list1);
		list2.add("C");
		list2.add("B");
		list2.add("A");
		
		assertEquals(list1.toString(), list2.toString());
	}

}
