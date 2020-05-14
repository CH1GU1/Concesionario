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
	 * This method is the constructor of used Vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @param totalPrice double final price 
	 * @param basePrice double base price 
	 * @param brand String brand
	 * @param model year of vehicle model
	 * @param cylinder double cylinder 
	 * @param mileage int km traveled
	 * @param plaque String of the plaque
	 * 
	 * <b>post:</b>Create a used vehicle object<br>
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
	/**
	 * This method is the constructor of new Vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @param totalPrice double final price 
	 * @param basePrice double base price 
	 * @param brand String brand
	 * @param model year of vehicle model
	 * @param cylinder double cylinder 
	 * @param mileage int km traveled
	 * 
	 * <b>post:</b>Create a new vehicle object<br>
	 */
	public Vehicle(double basePrice, String brand, int model, double cylinder, int mileage, String new1) {
		this.basePrice = basePrice;
		this.brand = brand;
		this.model = model;
		this.cylinder = cylinder;
		this.mileage = mileage;
		this.new1 = new1;
		this.owner = "Propiety of company";
		this.sold = false;
		docs = new ArrayList<>();
	}
	/**
	 * This method add documentation to the docs array
	 * <b><pre>:<br><br>
	 * 
	 * @param doc
	 * 
	 * <b>post:</b><br>
	 */
	public void adddocs(Documents doc) {
		this.docs.add(doc);
	}
	/**
	 * This method sets the sell price of vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @param totalPrice double final price 
	 * 
	 * <b>post:</b><br>
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * This method change the boolean to String about if is new or a used vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @return info String about the condition
	 * 
	 * <b>post:</b><br>
	 */
	public String soldToString() {
		String info = "";
		if(sold == true)
			info = "Yes";
		else
			info = "No";
		return info;
	}
	/**
	 * This method get the total Price
	 * <b><pre>:<br>A car must be created as minimum<br>
	 * 
	 * @return totalPrice
	 * 
	 * <b>post:</b><br>
	 */
	public double getTotalPrice() {
		return totalPrice;
	}
	/**
	 * This method sets the state of sell of vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @param sold boolean of state of sell
	 * 
	 * <b>post:</b>Sets the condition of pay<br>
	 */
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	/**
	 * This method get the state of sold
	 * <b><pre>:<br>A car must be created as minimum<br>
	 * 
	 * @return sold boolean of state of sell
	 * 
	 * <b>post:</b><br>
	 */
	public boolean getSold() {
		return sold;
	}
	/**
	 * This method get the state of use of vehicle
	 * <b><pre>:<br>A car must be created as minimum<br>
	 * 
	 * @return new1 boolean of state of use
	 * 
	 * <b>post:</b><br>
	 */
	public String getNew1() {
		return new1;
	}
	/**
	 * This method sets the state of use of vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @param new1 boolean of state of sell
	 * 
	 * <b>post:</b>Sets the condition of pay<br>
	 */
	public void setNew1(String new1) {
		this.new1 = new1;
	}
	/**
	 * This method get the owner of vehicle
	 * <b><pre>:<br>A car must be created as minimum<br>
	 * 
	 * @return owner String name of owner
	 * 
	 * <b>post:</b><br>
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * This method sets the owner of a vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @param owner String name of owner
	 * 
	 * <b>post:</b>Sets the owner name<br>
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * This method get the soat document
	 * <b><pre>:<br><br>
	 * 
	 * @return soat Documents 
	 * 
	 * <b>post:</b><br>
	 */
	public Documents getSoat() {
		return soat;
	}
	/**
	 * This method sets the soat document
	 * <b><pre>:<br><br>
	 * 
	 * @param soat Documents
	 * 
	 * <b>post:</b>Sets soat document<br>
	 */
	public void setSoat(Documents soat) {
		this.soat = soat;
	}
	/**
	 * This method get the mech document
	 * <b><pre>:<br><br>
	 * 
	 * @return mech Documents 
	 * 
	 * <b>post:</b><br>
	 */
	public Documents getMech() {
		return mech;
	}
	/**
	 * This method sets the mech document
	 * <b><pre>:<br><br>
	 * 
	 * @param mech Documents
	 * 
	 * <b>post:</b>Sets mech document<br>
	 */
	public void setMech(Documents mech) {
		this.mech = mech;
	}
	/**
	 * This method sets the base price of vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @param basePrice
	 * 
	 * <b>post:</b>Sets base price of vehicle<br>
	 */
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	/**
	 * This method gets the base price of vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @return basePrice 
	 * 
	 * <b>post:</b><br>
	 */
	public double getBasePrice() {
		return basePrice;
	}
	/**
	 * This method sets the brand of vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @param brand
	 * 
	 * <b>post:</b>Sets brand of vehicle<br>
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * This method gets the base brand of vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @return brand
	 * 
	 * <b>post:</b><br>
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * This method sets the model of vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @param model
	 * 
	 * <b>post:</b>Sets model of vehicle<br>
	 */
	public void setModel(int model) {
		this.model = model;
	}
	/**
	 * This method gets the model of vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @return model
	 * 
	 * <b>post:</b><br>
	 */
	public int getModel() {
		return model;
	}
	/**
	 * This method sets the cylinder of vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @param cylinder
	 * 
	 * <b>post:</b>Sets cylinder of vehicle<br>
	 */
	public void setCylinder(double cylinder) {
		this.cylinder = cylinder;
	}
	/**
	 * This method gets the cylinder  of vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @return cylinder
	 * 
	 * <b>post:</b><br>
	 */
	public double getCylinder() {
		return cylinder;
	}
	/**
	 * This method sets the mileage of vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @param mileage
	 * 
	 * <b>post:</b>Sets mileage of vehicle<br>
	 */
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	/**
	 * This method gets the mileage of vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @return mileage
	 * 
	 * <b>post:</b><br>
	 */
	public int getMileage() {
		return mileage;
	}
	/**
	 * This method sets the condition of use of vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @param new1
	 * 
	 * <b>post:</b>Sets condition of use of vehicle<br>
	 */
	public void setType(String new1) {
		this.new1 = new1;
	}
	/**
	 * This method sets the plaque of vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @param plaque String for plaque 
	 * 
	 * <b>post:</b>Sets plaque of vehicle<br>
	 */
	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}
	/**
	 * This method gets the plaque of vehicle
	 * <b><pre>:<br><br>
	 * 
	 * @return plaque
	 * 
	 * <b>post:</b><br>
	 */
	public String getPlaque() {
		return plaque;
	}
	/**
	 * This method shows the description of vehicles
	 * <b><pre>:<br>A vehicle as minimum must be created<br>
	 * 
	 * @return info String returns information
	 * 
	 * <b>post:</b><br>
	 */
	public String description() {
		String info = "\nCurrent owner: "+owner+"\nSold: "+soldToString()+"\nTotal price: "+totalPrice+"\nBase price: "+basePrice+"\nBrand: "+brand+"\nModel: "+model+"\nCylinder: "+cylinder+"\nMileage: "+mileage+"\nIs new?: "+new1+"\nPlaque: "+plaque;
		if(Vehicle.this.getPlaque() == null) { 
			return info += "\nNo documents yet until car its sould";	
		}
		else 
			info += docs.get(docs.size()-2).description()+docs.get(docs.size()-1).description() + "\n"; 
		return info;
	}		
}