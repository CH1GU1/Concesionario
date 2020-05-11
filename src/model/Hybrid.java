package model;
import java.util.*;
public class Hybrid extends Car implements Gasservices, Electricserv {

	private double tankCapacity;
	private String gasType;
	private double gasPerformance;
	public int ORDINARY = 1;
	public int DIESEL = 2;
	public int EXTRA = 3;
	private String chargerType;
	private double batLife;
	private double batConsuption;

	/**
	 * 
	 * @param sedan
	 * @param doors
	 * @param polarized
	 */
	public Hybrid( double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String sedan, int doors, String polarized, String chargerType, double batLife, double tankCapacity, String gasType, double price, double price2, int year, double accidents, double gas) {
		super(basePrice,  brand,model,  cylinder,  mileage,  new1,  plaque,  sedan, doors, polarized, price, price2, year, accidents, gas);
		this.tankCapacity = tankCapacity;
		this.gasType = gasType;
		this.gasPerformance = calculateGasPerformance(tankCapacity, cylinder);
		this.chargerType = chargerType;
		this.batLife = batLife;
		this.batConsuption = calculateBatConsuption(chargerType,  batLife,  cylinder);
		this.totalPrice = calculateFinalPriceUsed(basePrice);
	}
	public Hybrid(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String sedan, int doors, String polarized, String chargerType, double batLife, double tankCapacity, String gasType) {
		super(basePrice,  brand, model,  cylinder, mileage, new1, sedan, doors, polarized);
		this.tankCapacity = tankCapacity;
		this.gasType = gasType;
		this.gasPerformance = calculateGasPerformance(tankCapacity, cylinder);
		this.chargerType = chargerType;
		this.batLife = batLife;
		this.batConsuption = calculateBatConsuption(chargerType,  batLife,  cylinder);
		this.totalPrice = calculateFinalPrice(basePrice);
	}
	public double calculateFinalPrice(double basePrice) {
		double mount = basePrice * 0.15;
		totalPrice = basePrice + mount;
		return totalPrice;
	}
	public double calculateFinalPriceUsed(double basePrice) {
		double mount = basePrice * 0.10;
		totalPrice = basePrice - mount;
		return totalPrice;
	}
	public int carType() {
		return DIESEL;
	}

	public void gasType() {

	}

	public void tankCapacity() {

	}

	public void setGasPerformance(double gasPerformance) {
		this.gasPerformance = gasPerformance;
	}
	@Override
	public double calculateGasPerformance(double tankCapacity, double cylinder) {
		gasPerformance = tankCapacity * (cylinder/110);
		return gasPerformance;
	}
	public void batLife() {

	}

	public void batConsuption() {

	}

	public void chargerType() {

	}

	@Override
	public String carType(int pepito) {

		return null;
	}
	@Override
	public String description() { 
		String info = super.description()+"\nCharger type: "+chargerType+"\nBattery life: "+batLife+"\nBattery consuption: "+batConsuption+"\nTank capacity"+tankCapacity+"\nGas type: "+gasType+"\nGas perfomance: "+gasPerformance;
		return info;
	}
	public double getGasPerformance() {
		return gasPerformance;
	}
	@Override
	public double calculateBatConsuption(String chargerType, double batLife, double cylinder) {
		double batConsuption = 0;
		if(chargerType == "FAST") {
			batConsuption = batLife * (cylinder/ 100);  
		}
		if(chargerType == "NORMAL") {
			batConsuption = (batLife + 5)*(cylinder/100);
		}	
		return batConsuption;
	}
}