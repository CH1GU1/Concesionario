package model;
import java.util.*;
public class Gasoline extends Car implements Gasservices {

	private double tankCapacity;
	private String gasType;
	private double gasPerformance;
	public int ORDINARY = 1;
	public int DIESEL = 2;
	public int EXTRA = 3;

	/**
	 * 
	 * @param sedan
	 * @param doors
	 * @param polarized
	 * @param tankCapacity
	 * @param gasType
	 * @param gasPerformance
	 */
	public Gasoline(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String sedan, int doors, String polarized, double tankCapacity, String gasType, double price, double price2, int year, double accidents, double gas) {
		super(basePrice, brand, model, cylinder, mileage, new1, plaque, sedan, doors, polarized, price, price2, year, accidents, gas);
		this.tankCapacity = tankCapacity;
		this.gasType = gasType;
		this.gasPerformance = calculateGasPerformance(tankCapacity, cylinder);
		this.totalPrice = calculateFinalPriceUsed(basePrice);
	}
	public Gasoline(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String sedan, int doors, String polarized, double tankCapacity, String gasType) {
		super( basePrice, brand, model, cylinder, mileage, new1, sedan, doors, polarized);
		this.tankCapacity = tankCapacity;
		this.gasType = gasType;
		this.gasPerformance = calculateGasPerformance(tankCapacity, cylinder);
		this.totalPrice = basePrice;
	}
	public double calculateFinalPriceUsed(double basePrice) {
		double mount = basePrice * 0.10;
		totalPrice = basePrice - mount;
		return totalPrice;
	}
	public String getGasType() {
		return gasType;
	}
	/**
	 * 
	 * @param gasType
	 */
	public void setGasType(String gasType) {
		this.gasType = gasType;
	}
	public double getGasPerformance() {	
		return gasPerformance;
	}
	/**
	 * 
	 * @param gasPerformance
	 */
	@Override
	public double calculateGasPerformance(double tankCapacity, double cylinder) {
		gasPerformance = tankCapacity * (cylinder/100);
		return gasPerformance;
	}
	public void setGasPerformance(double gasPerformance) {
		this.gasPerformance = gasPerformance;
	}

	@Override
	public String carType(int pepito) {
		return null;
	}
	@Override
	  public String description() { 
		String info = super.description()+"\nTank capacity: "+tankCapacity+"\nGas type: "+gasType+"\nGas performance: "+gasPerformance;
				return info;
	}
}