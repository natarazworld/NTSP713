package com.nt.comp;

public class ApolloTyre implements Tyre {
	
	public ApolloTyre() {
		System.out.println("ApolloTyre::0-param constructor");
	}

	@Override
	public String roadGrip() {
		  return "MRF Tyre:: Standard Road Grip -->Suitable for any Transpotation";

	}

}
