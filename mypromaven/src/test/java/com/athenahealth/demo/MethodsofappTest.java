package com.athenahealth.demo;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class MethodsofappTest {

	@Test
	public void test() throws IOException {
		Data arr[]= new Data[2];
		arr[0]=new Data("102","World","30.0");
		arr[1]=new Data("101","hello","70.0");
		Methodsofapp moa=new Methodsofapp();
		moa.arr=arr;
		ArrayList<Boolean> a=moa.checkMarks();
		Assert.assertFalse(a.get(0));
		Assert.assertTrue(a.get(1));
	}

}
