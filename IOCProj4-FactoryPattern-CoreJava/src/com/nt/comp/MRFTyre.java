package com.nt.comp;

public class MRFTyre implements Tyre {

	public MRFTyre() {
		System.out.println("MRFTyre::0-param constructor");
	}
	@Override
	public String roadGrip() {
		 return "MRF Type:: Super Road Grip -->Suitable for Sports";

	}

}
