package model;
import java.util.*;
public class Electric extends Car implements Electricserv {

	private String chargerType;
	private double batLife;
	private double batConsuption;

	/**
	 * This method is the constructor of an used electric car 
	 * <b><pre>:<br><br>
	 * 
	 *@param basePrice double base price of vehicle
	 * @param brand String about the vehicle brand
	 * @param model integer year of model
	 * @param cylinder double cylinder of vehicle
	 * @param mileage integer of km traveled
	 * @param new1 String is the vehicle is new or no
	 * @param plaque String plaque
	 * @param sedan String is is sedan or no
	 * @param doors integer quantity of doors
	 * @param polarized String if is polarized or no
	 * @param chargerType String between normal or fast charger 
	 * @param batLife double of battery life
	 * @param price double price of soat document
	 * @param price2 double price of tech document
	 * @param year integer year of documents
	 * @param accidents double price of accidents cover
	 * @param gas double of gas level
	 * @return an used Electric car
	 * 
	 * <b><post>:<br><br>
	 */
	public Electric(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String sedan, int doors, String polarized, String chargerType, double batLife, double price, double price2, int year, double accidents, double gas) {
		super( basePrice, brand, model, cylinder, mileage, new1, plaque, polarized, doors, polarized, price, price2, year, accidents, gas);
		this.chargerType = chargerType;
		this.batLife = batLife;
		this.batConsuption = calculateBatConsuption(chargerType, batLife, cylinder);
		this.totalPrice = calculateFinalPriceUsed(basePrice);
	}
	/**
	 *This method is the constructor of a new electric car 
	 *<b><pre>:<br><br>
	 *
	 * @param basePrice double base price of vehicle
	 * @param brand String about the vehicle brand
	 * @param model integer year of model
	 * @param cylinder double cylinder of vehicle
	 * @param mileage integer of km traveled
	 * @param new1 String is the vehicle is new or no
	 * @param sedan String is is sedan or no
	 * @param doors integer quantity of doors
	 * @param chargerType String between normal or fast charger 
	 * @param batLife double of battery life
	 * @return a new Electric car
	 * 
	 * <b><post>:<br><br>
	 */
	public Electric(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String sedan, int doors, String polarized, String chargerType, double batLife) {
		super(basePrice, brand, model, cylinder, mileage, new1, polarized, doors, polarized);
		this.chargerType = chargerType;
		this.batLife = batLife;
		this.batConsuption = calculateBatConsuption(chargerType, batLife, cylinder);
		this.totalPrice = calculateFinalPrice(basePrice);
	}
	/**
	 * This method calculate the price of sell a new electric car
	 * <b><pre>:<br>An electric car must be created as minimum<br>
	 * 
	 * @param basePrice double of base price of vehicle
	 * @return totalPrice is the price with the modification to be sell
	 * 
	 * <b><post>:<br>Price of sell is updated<br>
	 */
	public double calculateFinalPrice(double basePrice) {
		double mount = basePrice * 0.2;
		totalPrice = basePrice + mount;
		return totalPrice;
	}
	/**
	 * This method calculate the price of sell an used electric car
	 * <b><pre>:<br>An electric car must be created as minimum<br>
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
	 * This method returns the information of the electric car
	 * <b><pre>:<br>An electric car must be created as minimum<br>
	 * 
	 * @return info String with the information of electric car
	 * 
	 * <b>post:</b><br>
	 */
	@Override
	  public String description() { 
		String info = super.description()+"\nCharger type: "+chargerType+"\nBattery life in km: "+batLife+"\nBattery consuption in Kw per km: "+batConsuption;
				return info;
	}
	/**
	 * This method calculate the battery consumption depends of the charger type, battery life and cylinder
	 * <b><pre>:<br>An electric car must be created as minimum<br>
	 * 
	 * @param chargerType String between FAST or NORMAL
	 * @param batLife double duration of battery 
	 * @param cylinder double cylinder of electric car
	 * @return batConsuption  
	 * 
	 * <b>post:</b>Battery consumption is updated<br>
	 */
	@Override
	public double calculateBatConsuption(String chargerType, double batLife, double cylinder) {
		double batConsuption = 0;
		if(chargerType == "FAST") {
			batConsuption = (batLife + 10)*(cylinder/ 100);  
		}
		if(chargerType == "NORMAL") {
			batConsuption = (batLife + 15)*(cylinder/100);
		}	
		return batConsuption;
	}
}