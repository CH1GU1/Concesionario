package model;
import java.util.*;
public class Motorcycle extends Vehicle implements Gasservices {

	private int STANDAR = 1;
	private int SPORT = 2;
	private int SCOOTER = 3;
	private int CROSS = 4;
	private String motorcycleType;
	private double gasCapacity;
	private double consume;

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
 * @param motorcycleType
 * @param gasCapacity
 * @param consume
 */
	public Motorcycle( double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String motorcycleType, double gasCapacity, double price, double price2, int year, double accidents, double gas) {
		super(basePrice, brand, model, cylinder, mileage, new1, plaque, price, price2, year, accidents, gas);
		this.motorcycleType = motorcycleType;
		this.gasCapacity = gasCapacity;
		this.consume = calculateGasPerformance(gasCapacity, cylinder);
		this.totalPrice = calculateFinalPriceUsed(basePrice);
	}
	public Motorcycle( double basePrice, String brand, int model, double cylinder, int mileage, String new1, String motorcycleType, double gasCapacity) {
		super(basePrice, brand, model, cylinder, mileage, new1);
		this.motorcycleType = motorcycleType;
		this.gasCapacity = gasCapacity;
		this.consume = calculateGasPerformance(gasCapacity, cylinder);
		this.totalPrice = calculateFinalPrice(basePrice);
	}
	public double calculateFinalPrice(double basePrice) {
		double mount = basePrice * 0.04;
		totalPrice = basePrice + mount;
		return totalPrice;
	}
	public double calculateFinalPriceUsed(double basePrice) {
		double mount = basePrice * 0.02;
		totalPrice = basePrice - mount;
		return totalPrice;
	}
	/**
	 * 
	 * @param motorcycleType
	 */
	public void setMotorcycleType(String motorcycleType) {
		this.motorcycleType = motorcycleType;
	}

	public String getMotorcycleType() {
		return motorcycleType;
	}

	/**
	 * 
	 * @param gasCapacity
	 */
	public void setGasCapacity(double gasCapacity) {
		this.gasCapacity = gasCapacity;
	}

	public double getGasCapacity() {
		return gasCapacity;
	}

	/**
	 * 
	 * @param consume
	 */
	
	public void setGasPerformance(double consume) {
		this.consume = consume;
	}
	@Override
	public double calculateGasPerformance(double gasCapacity, double cylinder) {
		consume = gasCapacity * (cylinder/90);
		return consume;
	}
	public double getConsume() {
		return consume;
	}

	
	public double getGasPerformance() {
		 return consume;
	}
	@Override
	  public String description() { 
		String info = super.description()+"\nMotorcycle type: "+motorcycleType+"\nGas Capacity: "+gasCapacity+"\nConsume: "+consume;
				return info;
	}

}