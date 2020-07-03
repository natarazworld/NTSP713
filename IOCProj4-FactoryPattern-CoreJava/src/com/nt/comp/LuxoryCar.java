package com.nt.comp;

public class LuxoryCar implements Car {
	private Tyre tyre;
	
	public LuxoryCar(Tyre tyre) {
		System.out.println("LuxoryCar:: 1-param constructor");
		this.tyre=tyre;
	}

	@Override
	public void drive() {
		System.out.println("Driving Sports Car having "+tyre.roadGrip());

	}

}
