package model;
import java.util.*;
public abstract class Vehicle {

	protected double totalPrice;
	private double basePrice;
	private String brand;
	private int model;
	private double cylinder;
	private int mileage;
	private String new1;
	private String plaque;
	private String owner;
	private boolean sold;
	private Documents soat;
	private Documents mech; 
	public ArrayList<Documents> docs;
	/**
	 * 
	 * @param totalPrice
	 * @param basePrice
	 * @param brand
	 * @param model
	 * @param cylinder
	 * @param mileage
	 * @param type
	 * @param plaque
	 */
	public Vehicle(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, double price, double price2, int year, double accidents, double gas) {
		this.basePrice = basePrice;
		this.brand = brand;
		this.model = model;
		this.cylinder = cylinder;
		this.mileage = mileage;
		this.new1 = new1;
		this.plaque = plaque;
		this.owner = "Propiety of company";
		this.sold = false;
		docs = new ArrayList<>();
		Documents soat = new Soat(price, year, accidents);
		Documents mech = new MechTech(price2, year, gas);
		docs.add(soat);
		docs.add(mech);
	}
	public Vehicle(double basePrice, String brand, int model, double cylinder, int mileage, String new1) {
		this.basePrice = basePrice;
		this.brand = brand;
		this.model = model;
		this.cylinder = cylinder;
		this.mileage = mileage;
		this.new1 = new1;
		this.owner = "Propiety of company";
		this.sold = false;
	}
	public void adddocs(Documents doc) {
		this.docs.add(doc);
	}
	/**
	 * 
	 * @param totalPrice
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	public boolean getSold() {
		return sold;
	}
	public String getNew1() {
		return new1;
	}
	public void setNew1(String new1) {
		this.new1 = new1;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Documents getSoat() {
		return soat;
	}
	public void setSoat(Documents soat) {
		this.soat = soat;
	}
	public Documents getMech() {
		return mech;
	}
	public void setMech(Documents mech) {
		this.mech = mech;
	}
	/**
	 * 
	 * @param basePrice
	 */
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getBasePrice() {
		return basePrice;
	}

	/**
	 * 
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	/**
	 * 
	 * @param model
	 */
	public void setModel(int model) {
		this.model = model;
	}

	public int getModel() {
		return model;
	}

	/**
	 * 
	 * @param cylinder
	 */
	public void setCylinder(double cylinder) {
		this.cylinder = cylinder;
	}

	public double getCylinder() {
		return cylinder;
	}

	/**
	 * 
	 * @param mileage
	 */
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getMileage() {
		return mileage;
	}

	/**
	 * 
	 * @param new1
	 */
	public void setType(String new1) {
		this.new1 = new1;
	}

	public String getType() {
		return new1;
	}

	/**
	 * 
	 * @param plaque
	 */
	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}

	public String getPlaque() {
		return plaque;
	}
	public String description() {
		String info = "\nCurrent owner: "+owner+"\nSold: "+sold+"\nTotal price: "+totalPrice+"\nBase price: "+basePrice+"\nBrand: "+brand+"\nModel: "+model+"\nCylinder: "+cylinder+"\nMileage: "+mileage+"\nIs new?: "+new1+"\nPlaque: "+plaque;
		if(Vehicle.this.getPlaque() == null) { 
			return info += "\nNo documents yet until car its sould";	
		}
		else
		info += docs.get(0).descriptionSoat()+docs.get(1).descriptionTech(); 
		return info;
	}
}