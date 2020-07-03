package com.nt.comp;

public class BudgetCar implements Car {
	private Tyre tyre;

	public BudgetCar(Tyre tyre) {
	  System.out.println("BudgetCar:: 1-param cosntructor");
		this.tyre = tyre;
	}

	@Override
	public void drive() {
		System.out.println("Driving Budget car  having"+tyre.roadGrip());
	}

}
