package model;
import java.util.*;
public class Motorcycle extends Vehicle implements Gasservices {

	private String motorcycleType;
	private double gasCapacity;
	private double consume;

	/**
	 * This method is the constructor of an used motorcycle
	 * <b><pre>:<br><br>
	 * 
	 * @param basePrice double base price of vehicle
	 * @param brand String about the vehicle brand
	 * @param model integer year of model
	 * @param cylinder double cylinder of vehicle
	 * @param mileage integer of km traveled
	 * @param new1 String is the vehicle is new or no
	 * @param plaque String plaque
	 * @param motorcycleType String of type of motorcycle 
	 * @param gasCapacity double capacity of the gas tank
	 * @param price double price of soat document
	 * @param price2 double price of tech document
	 * @param year integer year of documents
	 * @param accidents double price of accidents cover
	 * @param gas double of gas level
	 * @return an used motorcycle
	 * 
	 * <b><post>:<br><br>
	 */
	public Motorcycle( double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String motorcycleType, double gasCapacity, double price, double price2, int year, double accidents, double gas) {
		super(basePrice, brand, model, cylinder, mileage, new1, plaque, price, price2, year, accidents, gas);
		this.motorcycleType = motorcycleType;
		this.gasCapacity = gasCapacity;
		this.consume = calculateGasPerformance(gasCapacity, cylinder);
		this.totalPrice = calculateFinalPriceUsed(basePrice);
	}
	/**
	 * This method is the constructor of a new motorcycle
	 * <b><pre>:<br><br>
	 * 
	 * @param basePrice double base price of vehicle
	 * @param brand String about the vehicle brand
	 * @param model integer year of model
	 * @param cylinder double cylinder of vehicle
	 * @param mileage integer of km traveled
	 * @param new1 String is the vehicle is new or no
	 * @param motorcycleType String of type of motorcycle 
	 * @param gasCapacity double capacity of the gas tank
	 * @return a new motorcycle
	 * 
	 * <b><post>:<br><br>
	 */
	public Motorcycle( double basePrice, String brand, int model, double cylinder, int mileage, String new1, String motorcycleType, double gasCapacity) {
		super(basePrice, brand, model, cylinder, mileage, new1);
		this.motorcycleType = motorcycleType;
		this.gasCapacity = gasCapacity;
		this.consume = calculateGasPerformance(gasCapacity, cylinder);
		this.totalPrice = calculateFinalPrice(basePrice);
	}
	/**
	 * This method calculate the price of sell of a new motorcycle 
	 * <b><pre>:<br>A motorcycle must be created as minimum<br>
	 * 
	 * @param basePrice double of base price of motorcycle
	 * @return totalPrice is the price with the modification to be sell
	 * 
	 * <b><post>:<br>Price of sell is updated<br>
	 */
	public double calculateFinalPrice(double basePrice) {
		double mount = basePrice * 0.04;
		totalPrice = basePrice + mount;
		return totalPrice;
	}
	/**
	 * This method calculate the price of sell an used motorcycle
	 * <b><pre>:<br>A motorcycle must be created as minimum<br>
	 * 
	 * @param basePrice double of base price of vehicle
	 * @return totalPrice is the price with the modification to be sell
	 * 
	 * <b><post>:<br>Price of sell is updated<br>
	 */
	public double calculateFinalPriceUsed(double basePrice) {
		double mount = basePrice * 0.02;
		totalPrice = basePrice - mount;
		return totalPrice;
	}
	/**
	 * This method sets the motorcycle type 
	 * <b><pre>:<br><br>
	 * 
	 * @param motorcycleType String with the motorcycle type
	 * 
	 * <b><post>:<br><br>
	 */
	public void setMotorcycleType(String motorcycleType) {
		this.motorcycleType = motorcycleType;
	}
	/**
	 * This method gets the motorcycle type
	 * <b><pre>:<br>motorcycle type is not null<br>
	 * 
	 * @return motorcycleType as String with the type
	 * 
	 * <b><post>:<br><br>
	 */
	public String getMotorcycleType() {
		return motorcycleType;
	}
	/**
	 * This method sets the gas capacity
	 * <b><pre>:<br><br>
	 * 
	 * @param gasCapacity double with the gas capacity
	 * 
	 * <b><post>:<br><br>
	 */
	public void setGasCapacity(double gasCapacity) {
		this.gasCapacity = gasCapacity;
	}
	/**
	 * This method gets the gas capacity
	 * <b><pre>:<br>Gas capacity is not null<br>
	 * 
	 * @return gasCapacity as double with gas capacity
	 * 
	 * <b><post>:<br><br>
	 */
	public double getGasCapacity() {
		return gasCapacity;
	}
	/**
	 * This method sets the consume of motorcycle
	 * <b><pre>:<br><br>
	 * 
	 * @param consume double of motorcycle consume
	 * 
	 * <b><post>:<br><br>
	 */
	public void setGasPerformance(double consume) {
		this.consume = consume;
	}
	/**
	 * This method calculate the gas performance depend of gas capacity and his cylinder
	 * <b><pre>:<br>A motorcycle must be created as minimum<br>
	 * 
	 * @param gasCapacity double of tank capacity 
	 * @param cylinder double of cylinder
	 * @return consume already calculated
	 * 
	 * <b><post>:<br><br>
	 */
	@Override
	public double calculateGasPerformance(double gasCapacity, double cylinder) {
		consume = gasCapacity * (cylinder/90);
		return consume;
	}
	/**
	 * This method gets the consume of motorcycle
	 * <b><pre>:<br>consume is not null<br>
	 * 
	 * @return consume double, is the result returns by calculateGasPerformance method
	 * 
	 * <b><post>:<br><br>
	 */
	public double getConsume() {
		return consume;
	}
	/**
	 * This method returns the description of motorcycle
	 * <b><pre>:<br>constructor is not null<br>
	 * 
	 * @return info as String with the information
	 * 
	 * <b><post>:<br><br>
	 */
	@Override
	public String description() { 
		String info = super.description()+"\nMotorcycle type: "+motorcycleType+"\nGas Capacity: "+gasCapacity+"\nConsume: "+consume;
		return info;
	}
}