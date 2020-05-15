package model;
import java.util.*;
public class Hybrid extends Car implements Gasservices, Electricserv {

	private double tankCapacity;
	private String gasType;
	private double gasPerformance;
	private String chargerType;
	private double batLife;
	private double batConsuption;

	/**
	 * This method is the constructor of an used hybrid car 
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
	 * @param chargerType String between normal or fast charger 
	 * @param batLife double of battery life
	 * @param gasType String of type of gas
	 * @param price double price of soat document
	 * @param price2 double price of tech document
	 * @param year integer year of documents
	 * @param accidents double price of accidents cover
	 * @param gas double of gas level
	 * @return an used hybrid car
	 * 
	 * <b><post>:<br><br>
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
	/**
	 * This method is the constructor of a new hybrid car 
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
	 * @param chargerType String between normal or fast charger 
	 * @param batLife double of battery life
	 * @param gasType String of type of gas
	 * @return a new hybrid car
	 * 
	 * <b><post>:<br><br>
	 */
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
	/**
	 * This method calculate the price of sell of a new hybrid car
	 * <b><pre>:<br>A hybrid car must be created as minimum<br>
	 * 
	 * @param basePrice double of base price of vehicle
	 * @return totalPrice is the price with the modification to be sell
	 * 
	 * <b><post>:<br>Price of sell is updated<br>
	 */
	public double calculateFinalPrice(double basePrice) {
		double mount = basePrice * 0.15;
		totalPrice = basePrice + mount;
		return totalPrice;
	}
	/**
	 * This method calculate the price of sell an used hybrid car
	 * <b><pre>:<br>A hybrid car must be created as minimum<br>
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
	 * This method get the gas performance of hybrid car
	 * <b><pre>:<br><br>
	 * 
	 * @return gasPerformance double of performance of hybrid car
	 * 
	 * <b><post>:<br><br>
	 */
	public void setGasPerformance(double gasPerformance) {
		this.gasPerformance = gasPerformance;
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
		gasPerformance = tankCapacity * (cylinder/110);
		return gasPerformance;
	}
	/**
	 * This method shows the description of hybrid car
	 * <b><pre>:<br>A hybrid car as minimum must be created<br>
	 * 
	 * @return info String returns information
	 * 
	 * <b>post:</b><br>
	 */
	@Override
	public String description() { 
		String info = super.description()+"\nCharger type: "+chargerType+"\nBattery life in km: "+batLife+"\nBattery consuption in Kw per km: "+batConsuption+"\nTank capacity in gallons"+tankCapacity+"\nGas type: "+gasType+"\nGas perfomance gallons per km: "+gasPerformance;
		return info;
	}
	/**
	 * This method get the gas performance of hybrid vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @return gasPerformance double of performance of hybrid car
	 * 
	 * <b><post>:<br><br>
	 */
	public double getGasPerformance() {
		return gasPerformance;
	}
	/**
	 * This method calculate the battery consumption depends of the charger type, battery life and cylinder
	 * <b><pre>:<br>A hybrid car must be created as minimum<br>
	 * 
	 * @param chargerType String between FAST or NORMAL
	 * @param batLife double duration of battery 
	 * @param cylinder double cylinder of electric car
	 * @return batConsuption double of battery consumption 
	 * 
	 * <b>post:</b>Battery consumption is updated<br>
	 */
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