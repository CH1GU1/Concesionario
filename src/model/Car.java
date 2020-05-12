package model;

import java.util.*;

public abstract class Car extends Vehicle {

	private String sedan;
	private int doors;
	private String polarized;
	public final static int GASOLINE = 1;
	public final static int ELECTRIC = 2;
	public final static int HYBRID = 3;

	/**
	 * 
	 * @param totalPrice
	 * @param basePrice
	 * @param brand
	 * @param model
	 * @param cylinder
	 * @param mileage
	 * @param new1
	 * @param plaque
	 * @param sedan
	 * @param doors
	 * @param polarized
	 */
	public Car( double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String sedan, int doors, String polarized, double price, double price2, int year, double accidents, double gas) {
		super(basePrice, brand, model, cylinder, mileage, new1, plaque, price, price2, year, accidents, gas);
		this.sedan = sedan;
		this.doors = doors;
		this.polarized = polarized;		
	}
	public Car( double basePrice, String brand, int model, double cylinder, int mileage, String new1, String sedan, int doors, String polarized) {
		super(basePrice, brand, model, cylinder, mileage, new1);
		this.sedan = sedan;
		this.doors = doors;
		this.polarized = polarized;		
	}
	public void setSedan(String sedan) {
		this.sedan = sedan;
	}

	public String getSedan() {
		return sedan;
	}

	/**
	 * 
	 * @param doors
	 */
	public void setDoors(int doors) {
		this.doors = doors;
	}

	public int getDoors() {
		return doors;
	}

	/**
	 * 
	 * @param polarized
	 */
	public void setPolarized(String polarized) {
		this.polarized = polarized;
	}

	public String getPolarized() {
		return polarized;
	}
	@Override
	public String description() {
		String info = super.description()+"\nIs sedan? "+sedan+"\nDoors: "+doors+"\nPolarized? "+polarized;
				return info;
	}

}