package model;

import java.util.*;

public abstract class Car extends Vehicle {

	private String sedan;
	private int doors;
	private String polarized;

	/**
	 * This is the constructor of an used car
	 * <b><pre>:<br><br>
	 * 
	 * @param basePrice double base price of car
	 * @param brand String about the car brand
	 * @param model integer year of model
	 * @param cylinder double cylinder of car
	 * @param mileage integer of km traveled
	 * @param new1 String is the car is new or no
	 * @param plaque String plaque
	 * @param sedan String is is sedan or no
	 * @param doors integer quantity of doors
	 * @param polarized String if is polarized or no
	 * @param price double price of soat document
	 * @param price2 double price of tech document
	 * @param year integer year of documents
	 * @param accidents double price of accidents cover
	 * @param gas double of gas level
	 * @return an used car
	 * 
	 * <b><post>:<br><br>
	 */
	public Car( double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String sedan, int doors, String polarized, double price, double price2, int year, double accidents, double gas) {
		super(basePrice, brand, model, cylinder, mileage, new1, plaque, price, price2, year, accidents, gas);
		this.sedan = sedan;
		this.doors = doors;
		this.polarized = polarized;		
	}
	/**
	 * This is the constructor of a new car
	 * <b><pre>:<br><br>
	 * 
	 * @param basePrice double base price of car
	 * @param brand String about the car brand
	 * @param model integer year of model
	 * @param cylinder double cylinder of car
	 * @param mileage integer of km traveled
	 * @param new1 String is the car is new or no
	 * @param sedan String is is sedan or no
	 * @param doors integer quantity of doors
	 * @param polarized String if is polarized or no
	 * 
	 * @return a new car
	 * 
	 * <b><post>:<br><br>
	 */
	public Car( double basePrice, String brand, int model, double cylinder, int mileage, String new1, String sedan, int doors, String polarized) {
		super(basePrice, brand, model, cylinder, mileage, new1);
		this.sedan = sedan;
		this.doors = doors;
		this.polarized = polarized;		
	}
	/**
	 * This method sets the sedan type of car
	 * <b><pre>:<br><br>
	 * 
	 * @param sedan
	 * 
	 * <b>post:</b><br>
	 */
	public void setSedan(String sedan) {
		this.sedan = sedan;
	}
	/**
	 * This method get the sedan type of car
	 * <b><pre>:<br><br>
	 * 
	 * @return sedan
	 * 
	 * <b><post>:<br><br>
	 */
	public String getSedan() {
		return sedan;
	}
	/**
	 * This method sets the doors number of car
	 * <b><pre>:<br><br>
	 * 
	 * @param doors
	 * 
	 * <b>post:</b><br>
	 */
	public void setDoors(int doors) {
		this.doors = doors;
	}
	/**
	 * This method get the doors number of car
	 * <b><pre>:<br><br>
	 * 
	 * @return doors
	 * 
	 * <b><post>:<br><br>
	 */
	public int getDoors() {
		return doors;
	}
	/**
	 * This method sets if the car is polarized or no
	 * <b><pre>:<br><br>
	 * 
	 * @param polarized
	 * 
	 * <b>post:</b><br>
	 */
	public void setPolarized(String polarized) {
		this.polarized = polarized;
	}
	/**
	 * This method gets the state of car polarized 
	 * <b><pre>:<br><br>
	 * 
	 * @return doors
	 * 
	 * <b><post>:<br><br>
	 */
	public String getPolarized() {
		return polarized;
	}
	/**
	 * This method returns the information of the car
	 * <b><pre>:<br>A car must be created as minimum<br>
	 * 
	 * @return info String with the information of car
	 * 
	 * <b>post:</b><br>
	 */
	@Override
	public String description() {
		String info = super.description()+"\nIs sedan? "+sedan+"\nDoors: "+doors+"\nPolarized? "+polarized;
		return info;
	}
}