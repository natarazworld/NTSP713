package com.nt.beans;

public class Car {
	private String regNo;
	private int engineNo;
	private String type;
	private String model;
	private String company;
	private String color;
	private int engineCC;
	private String owner;
	private String fuelType;

	public Car(String regNo, int engineNo, String type, String model, String company, String color, int engineCC,
			String owner, String fuelType) {
		System.out.println("Car:: 9-param constuctor");
		this.regNo = regNo;
		this.engineNo = engineNo;
		this.type = type;
		this.model = model;
		this.company = company;
		this.color = color;
		this.engineCC = engineCC;
		this.owner = owner;
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Car [regNo=" + regNo + ", engineNo=" + engineNo + ", type=" + type + ", model=" + model + ", company="
				+ company + ", color=" + color + ", engineCC=" + engineCC + ", owner=" + owner + ", fuelType="
				+ fuelType + "]";
	}

}
