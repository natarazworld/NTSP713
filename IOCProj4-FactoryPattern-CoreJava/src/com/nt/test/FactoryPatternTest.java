package com.nt.test;

import com.nt.comp.Car;
import com.nt.factory.CarFactory;

public class FactoryPatternTest {
	public static void main(String[] args) {
		Car car=null;
		car=CarFactory.getInstance("luxory");
		car.drive();
		System.out.println("...................................");
		car=CarFactory.getInstance("budget");
		car.drive();
	}//main
}//class
