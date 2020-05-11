package model;
import java.util.*;
public class Electric extends Car implements Electricserv {

	private String chargerType;
	private double batLife;
	private double batConsuption;

	/**
	 * 
	 * @param sedan
	 * @param doors
	 * @param polarized
	 * @param chargerType
	 * @param batLife
	 * @param batConsuption
	 */
	public Electric(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String sedan, int doors, String polarized, String chargerType, double batLife, double price, double price2, int year, double accidents, double gas) {
		super( basePrice, brand, model, cylinder, mileage, new1, plaque, polarized, doors, polarized, price, price2, year, accidents, gas);
		this.chargerType = chargerType;
		this.batLife = batLife;
		this.batConsuption = calculateBatConsuption(chargerType, batLife, cylinder);
		this.totalPrice = calculateFinalPriceUsed(basePrice);
	}
	public Electric(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String sedan, int doors, String polarized, String chargerType, double batLife) {
		super(basePrice, brand, model, cylinder, mileage, new1, polarized, doors, polarized);
		this.chargerType = chargerType;
		this.batLife = batLife;
		this.batConsuption = calculateBatConsuption(chargerType, batLife, cylinder);
		this.totalPrice = calculateFinalPrice(basePrice);
	}
	public double calculateFinalPrice(double basePrice) {
		double mount = basePrice * 0.2;
		totalPrice = basePrice + mount;
		return totalPrice;
	}
	public double calculateFinalPriceUsed(double basePrice) {
		double mount = basePrice * 0.10;
		totalPrice = basePrice - mount;
		return totalPrice;
	}
	public int carType() {
		return 0;
	
	}

	/**
	 * 
	 * @param String
	 */
	public void SetChargerType(int String) {
		
	}

	@Override
	public String carType(int pepito) {
		
		return null;
	}
	@Override
	  public String description() { 
		String info = super.description()+"\nCharger type: "+chargerType+"\nBattery life: "+batLife+"\nBattery consuption: "+batConsuption;
				return info;
	}
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