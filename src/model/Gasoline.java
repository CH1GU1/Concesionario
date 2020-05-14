package model;
import java.util.*;
public class Gasoline extends Car implements Gasservices {

	private double tankCapacity;
	private String gasType;
	private double gasPerformance;

	/**
	 * This method is the constructor of an used gasoline car 
	 * <b><pre>:<br><br>
	 * 
	 * @param basePrice double base price of vehicle
	 * @param brand String about the vehicle brand
	 * @param model integer year of model
	 * @param cylinder double cylinder of vehicle
	 * @param mileage integer of km traveled
	 * @param new1 String is the vehicle is new or no
	 * @param plaque String plaque
	 * @param sedan String is is sedan or no
	 * @param doors integer quantity of doors
	 * @param polarized String if is polarized or no
	 * @param tankCapacity double capacity of the gas tank
	 * @param gasType String type of gas
	 * @param price double price of soat document
	 * @param price2 double price of tech document
	 * @param year integer year of documents
	 * @param accidents double price of accidents cover
	 * @param gas double of gas level
	 * @return an used Gasoline vehicle
	 * 
	 * <b><post>:<br><br>
	 */
	public Gasoline(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String sedan, int doors, String polarized, double tankCapacity, String gasType, double price, double price2, int year, double accidents, double gas) {
		super(basePrice, brand, model, cylinder, mileage, new1, plaque, sedan, doors, polarized, price, price2, year, accidents, gas);
		this.tankCapacity = tankCapacity;
		this.gasType = gasType;
		this.gasPerformance = calculateGasPerformance(tankCapacity, cylinder);
		this.totalPrice = calculateFinalPriceUsed(basePrice);
	}
	/**
	 * This method is the constructor a new gasoline car 
	 * <b><pre>:<br><br>
	 * 
	 * @param basePrice double base price of vehicle
	 * @param brand String about the vehicle brand
	 * @param model integer year of model
	 * @param cylinder double cylinder of vehicle
	 * @param mileage integer of km traveled
	 * @param new1 String is the vehicle is new or no
	 * @param sedan String is is sedan or no
	 * @param doors integer quantity of doors
	 * @param polarized String if is polarized or no
	 * @param tankCapacity double capacity of the gas tank
	 * @param gasType String type of gas
	 * @return a new Gasoline vehicle
	 * 
	 * <b><post>:<br><br>
	 */
	public Gasoline(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String sedan, int doors, String polarized, double tankCapacity, String gasType) {
		super( basePrice, brand, model, cylinder, mileage, new1, sedan, doors, polarized);
		this.tankCapacity = tankCapacity;
		this.gasType = gasType;
		this.gasPerformance = calculateGasPerformance(tankCapacity, cylinder);
		this.totalPrice = basePrice;
	}
	/**
	 * This method calculate the price of sell
	 * <b><pre>:<br>A gasoline car must be created as minimum<br>
	 * 
	 * @param basePrice double of base price of vehicle
	 * @return totalPrice is the price with the modification to be sell
	 * 
	 * <b><post>:<br>Price of sell is updated<br>
	 */
	public double calculateFinalPriceUsed(double basePrice) {
		double mount = basePrice * 0.10;
		totalPrice = basePrice - mount;
		return totalPrice;
	}
	/**
	 * This method get the gas type of gasoline vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @return gasType String type of gas used
	 * 
	 * <b><post>:<br><br>
	 */
	public String getGasType() {
		return gasType;
	}
	/**
	 * This method sets the gas type of gasoline vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @param gasType
	 * 
	 * <b>post:</b>Sets gas type of gasoline vehicle<br>
	 */
	public void setGasType(String gasType) {
		this.gasType = gasType;
	}
	/**
	 * This method get the gas performance of gasoline vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @return gasPerformance double of performance of gasoline car
	 * 
	 * <b><post>:<br><br>
	 */
	public double getGasPerformance() {	
		return gasPerformance;
	}
	/**
	 * This method calculate the gas performance depend of tank capacity and his cylinder
	 * <b><pre>:<br>A gasoline car must be created as minimum<br>
	 * 
	 * @param tankCapacity double of tank capacity 
	 * @param cylinder double of cylinder
	 * @return gasPerformance already calculated
	 * 
	 * <b><post>:<br><br>
	 */
	@Override
	public double calculateGasPerformance(double tankCapacity, double cylinder) {
		gasPerformance = tankCapacity * (cylinder/100);
		return gasPerformance;
	}
	/**
	 * This method sets the gas performance of gasoline vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @param gasPerformance
	 * 
	 * <b>post:</b>Sets gas performance of gasoline vehicle<br>
	 */
	public void setGasPerformance(double gasPerformance) {
		this.gasPerformance = gasPerformance;
	}
	/**
	 * This method returns the information of the gasoline vehicle
	 * <b><pre>:<br>A gasoline car must be created as minimum<br>
	 * 
	 * @return info String with the information of gasoline car
	 * 
	 * <b>post:</b><br>
	 */
	@Override
	public String description() { 
		String info = super.description()+"\nTank capacity: "+tankCapacity+"\nGas type: "+gasType+"\nGas performance: "+gasPerformance;
		return info;
	}
}