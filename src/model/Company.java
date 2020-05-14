package model;
import java.util.*;

public class Company {

	private String name;
	private int nit;
	private double totalGain;
	private int sales;
	public static int MAX_SELLER = 10;
	private Car[][] parkingLot;
	public static int parkRows = 10;
	public static int parkCols = 5;
	public ArrayList<Vehicle> vehicles;
	public Employee[] salesMan;
	/**
	 * This method is the constructor of Company
	 * <b><pre>:<br>
	 * 
	 * @param name is the name of company
	 * @param nit nit of company
	 * @param totalGain of the price vehicles sold
	 * @param sales quantity of sales
	 * 
	 * <b>post: Create a Company object</b>
	 */
	public Company(String name, int nit, double totalGain, int sales) {
		this.name = name;
		this.nit = nit;
		this.totalGain = totalGain;
		this.sales = sales;
		vehicles = new ArrayList<>();
		salesMan = new Employee[MAX_SELLER];
	}
	/**
	 * This method initialize the employees and six vehicles
	 * <b><pre>:<br>Array of employees is already initialize with size 10, arraylist of vehicles is initialize<br>
	 * 
	 * <b>post:Create 10 employees and six cars  ready to be used.</b>
	 */
	public void initializeEmployee() {
		salesMan[0] = new Employee("Julian", "Riascos", 1001445130, 0);
		salesMan[1] = new Employee("Joe", "Monitor", 1002351025, 0);
		salesMan[2] = new Employee("Camilo", "Ruiz", 1005296215, 0);
		salesMan[3] = new Employee("Juan", "Ramirez", 1005896212, 0);
		salesMan[4] = new Employee("Kevin", "Mera", 1002035621, 0);
		salesMan[5] = new Employee("Andres", "Collazos", 1009875410, 0);
		salesMan[6] = new Employee("Tomas", "Velez", 1005120365, 0);
		salesMan[7] = new Employee("Sarah", "Lopez", 1001520364, 0);
		salesMan[8] = new Employee("Camila", "Lopez", 1001020254, 0);
		salesMan[9] = new Employee("Laurent", "Duarte", 1005894120, 0);	
		Vehicle Ug1 = new Gasoline(20000000, "Mazda", 2012, 3.0, 500, "No", "JPR-356", "No", 4, "Yes", 15, "EXTRA", 400000, 800000, 2012, 30000000, 32);
		Vehicle Ug2 = new Gasoline(41000000, "BMW", 2010, 2.2, 800, "No", "GHT-456", "Yes", 2, "Yes", 9, "EXTRA", 500000, 400000, 2010, 50000000, 20);
		Vehicle g1 = new Gasoline(20000000, "Chevrolet", 2020, 1.8, 2, "Yes", "Yes", 4, "Yes", 9, "NORMAL");
		Vehicle e1 = new Electric(30000000, "Tesla", 2020, 3.5, 2, "Yes", "Yes", 4, "No", "FAST", 300);
		Vehicle h1 = new Hybrid(25000000, "Tesla", 2020, 2.1, 1, "Yes", "No", 4, "Yes", "NORMAL", 400, 7, "EXTRA");
		Motorcycle m1 = new Motorcycle(5000, "Honda", 2020, 1.2, 1, "Yes", "SPORT", 2);
		addVehicle(g1);
		addVehicle(e1);
		addVehicle(h1);
		addVehicle(m1);
		addVehicle(Ug1);
		addVehicle(Ug2);
	}
	/**
	 * This method get the parking lot in a matrix form
	 * 
	 *<b><pre>:<br>The matrix Car[][] is already initialize<br>
	 *
	 *@return Car matrix of parking lot
	 *
	 *<b>post:</b>
	 */
	public Car[][] getParking() {
		return parkingLot;
	}
	/**
	 * This method get the information of the car on the parking lot depend of the model year
	 * <b><pre>:<br>The matrix Car[][] is already initialize<br>
	 * <b><pre>:<br>The matrix Car[][] is already initialize<br>
	 * 
	 * @param request integer of the year model to request.
	 * @return info String with the information about the car requested.
	 * 
	 * <b><post>:<br>Returns the information os the specific car<br>
	 */
	public String getInfoParking(int request) {
		String info = "";
		boolean cont = true;
		boolean go = true;
		if(request == 2010) {
			info += "\nUsed cars of models below "+(request+1)+" on the parking lot are: \n";
		}
		else {
			info += "\nUsed cars models "+request+" on the parking lot are: \n";
		}	
		for (int i = 0; i < vehicles.size(); i++) {
			go = true;
			if(vehicles.get(i) instanceof Car && vehicles.get(i).getModel() == 2014 && request == 2014) {
				for(int k = 0; k < parkRows; k++) {
					if(parkingLot[k][0] != null && cont) {
						info +=	"\n***Car #"+(k+1)+"**"+"\n"+parkingLot[k][0].description()+"\n";
						go = false;
					}
					else if(cont) {
						info += "\n**"+(10-k)+" parkings remaining for 2014 cars models**\n";
						cont = false;
					}	
				}
			}
			if(vehicles.get(i) instanceof Car && vehicles.get(i).getModel() == 2013 && request == 2013) {
				for(int k = 0; k < parkRows; k++) {
					if(parkingLot[k][1] != null && cont) {
						info +=	"\n***Car #"+(k+1)+"**"+"\n"+parkingLot[k][1].description()+"\n";
						go = false;
					}
					else if(cont) {
						info += "\n**"+(10-k)+" parkings remaining for 2013 cars models**\n";
						cont = false;
					}	
				}
			}
			if(vehicles.get(i) instanceof Car && vehicles.get(i).getModel() == 2012 && request == 2012) {
				for(int k = 0; k < parkRows; k++) {
					if(parkingLot[k][2] != null && cont) {
						info +=	"\n***Car #"+(k+1)+"**"+"\n"+parkingLot[k][2].description()+"\n";
						go = false;
					}
					else if(cont) {
						info += "\n**"+(10-k)+" parkings remaining for 2012 cars models**\n";
						cont = false;
					}	
				}
			}
			if(vehicles.get(i) instanceof Car && vehicles.get(i).getModel() == 2011 && request == 2011) {
				for(int k = 0; k < parkRows; k++) {
					if(parkingLot[k][3] != null && cont) {
						info +=	"\n***Car #"+(k+1)+"**"+"\n"+parkingLot[k][3].description()+"\n";
						go = false;
					}
					else if(cont) {
						info += "\n**"+(10-k)+" parkings remaining for 2011 cars models**\n";
						cont = false;
					}	
				}
			}
			if(vehicles.get(i) instanceof Car && vehicles.get(i).getModel() == 2010 && request == 2010) {
				for(int k = 0; k < parkRows; k++) {
					if(parkingLot[k][4] != null && cont) {
						info +=	"\n***Car #"+(k+1)+"**"+"\n"+parkingLot[k][4].description()+"\n";
						go = false;
					}
					else if(cont) {
						info += "\n**"+(10-k)+" parkings free for cars models below 2011**\n";
						cont = false;
					}	
				}
			}
		}
		return info;
	}
	/**
	 * This method organize the used cars on the parking lot matrix depend of their models year.
	 * <b><pre>:<br>The matrix Car[][] is already initialize<br>
	 * <b><pre>:<br>An used car is created as minimum<br>
	 * 
	 * @return info String in case if the parking lot is full.
	 * 
	 * <b><post>:<br><br>
	 */
	public String organizeParking() {
		String info = "";
		boolean cont = true;
		boolean go = true;
		parkingLot = new Car[parkRows][parkCols];
		for (int i = 0; i < vehicles.size(); i++) {
			go = true;
			if(vehicles.get(i) instanceof Car && vehicles.get(i).getModel() == 2014 && vehicles.get(i).getNew1().equalsIgnoreCase("No")){
				for(int k = 0; k < parkRows; k++) {
					if(parkingLot[k][0] == null && cont && vehicles.get(i).getModel() == 2014 && vehicles.get(i).getNew1().equalsIgnoreCase("No") && go) {
						parkingLot[k][0] = (Car) vehicles.get(i);	
						go = false;
					}
					else if(!cont) {
						info = "Parking lot must be extended";
						cont = false;
					}
				}
			}
			if(vehicles.get(i) instanceof Car && vehicles.get(i).getModel() == 2013 && vehicles.get(i).getNew1().equalsIgnoreCase("No")){
				for(int k = 0; k < parkRows; k++) {
					if(parkingLot[k][1] == null && cont && vehicles.get(i).getModel() == 2013 && vehicles.get(i).getNew1().equalsIgnoreCase("No") && go) {
						parkingLot[k][1] = (Car) vehicles.get(i);	
						go = false;
					}
					else if(!cont) {
						info = "Parking lot must be extended";
						cont = false;
					}
				}
			}
			if(vehicles.get(i) instanceof Car && vehicles.get(i).getModel() == 2012 && vehicles.get(i).getNew1().equalsIgnoreCase("No")){
				for(int k = 0; k < parkRows; k++) {
					if(parkingLot[k][2] == null && cont && vehicles.get(i).getModel() == 2012 && vehicles.get(i).getNew1().equalsIgnoreCase("No") && go) {
						parkingLot[k][2] = (Car) vehicles.get(i);	
						go = false;
					}
					else if(!cont) {
						info = "Parking lot must be extended";
						cont = false;
					}
				}
			}
			if(vehicles.get(i) instanceof Car && vehicles.get(i).getModel() == 2011 && vehicles.get(i).getNew1().equalsIgnoreCase("No")){
				for(int k = 0; k < parkRows; k++) {
					if(parkingLot[k][3] == null && cont && vehicles.get(i).getModel() == 2011 && vehicles.get(i).getNew1().equalsIgnoreCase("No") && go) {
						parkingLot[k][3] = (Car) vehicles.get(i);	
						go = false;
					}
					else if(!cont) {
						info = "Parking lot must be extended";
						cont = false;
					}
				}
			}
			if(vehicles.get(i) instanceof Car && vehicles.get(i).getModel() <= 2010 && vehicles.get(i).getNew1().equalsIgnoreCase("No")){
				for(int k = 0; k < parkRows; k++) {
					if(parkingLot[k][4] == null && cont && vehicles.get(i).getModel() <= 2010 && vehicles.get(i).getNew1().equalsIgnoreCase("No") && go) {
						parkingLot[k][4] = (Car) vehicles.get(i);	
						go = false;
					}
					else if(!cont) {
						info = "Parking lot must be extended";
						cont = false;
					}
				}
			}
		}
		return info;
	}
	/**
	 * This method add the documentation of a vehicle
	 * <b><pre>:<br>A vehicle is created as minimum<br>
	 * 
	 * @param vehicleNumber number on the arrayList of vehicles
	 * @param year year of documentation
	 * @param accidents cover of accidents price
	 * @param price price of documentation 
	 * @param gas level of gas
	 * 
	 * <b><post>:<br>A vehicle added documentation was sold too<br>
	 */
	public void addDocumentation(int vehicleNumber, int year, double accidents, double price, double gas) {
		Documents soat  = new Soat(price, year, accidents);
		Documents mech  = new MechTech(price, year, gas);
		vehicles.get(vehicleNumber).docs.add(soat);
		vehicles.get(vehicleNumber).docs.add(mech);
	}
	/**
	 * This method add a vehicle to the arrayList
	 * <b><pre>:<br>ArrayList of vehicle is already initialize<br>
	 * 
	 * @param vehicle object vehicle type
	 * 
	 * <b><post>:<br>Vehicle must be visible on the list<br>
	 */
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	/**
	 * This method create and add an used gasoline car 
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
	 * <b><post>:<br><br>
	 */
	public Gasoline createGasolineCar(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String sedan, int doors, String polarized, double tankCapacity, String gasType, double price, double price2, int year, double accidents, double gas) {
		Gasoline gasoline = new Gasoline(basePrice, brand, model, cylinder, mileage, new1, plaque, sedan, doors, polarized, tankCapacity, gasType, price, price2, year, accidents, gas);
		addVehicle(gasoline);
		return gasoline;
	}
	/**
	 * This method create and add a new gasoline car 
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
	public Gasoline createGasolineCar(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String sedan, int doors, String polarized, double tankCapacity, String gasType) {
		Gasoline gasoline = new Gasoline( basePrice,  brand,  model, cylinder, mileage, new1, sedan,  doors,  polarized, tankCapacity, gasType);
		addVehicle(gasoline);
		return gasoline;
	}
	/**
	 * This method create and add an used electric car 
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
	public Electric createElectricCar(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String sedan, int doors, String polarized, String chargerType, double batLife, double price, double price2, int year,  double accidents, double gas) {
		Electric electric = new Electric( basePrice, brand, model, cylinder, mileage, new1, plaque, sedan, doors, polarized, chargerType, batLife, price, price2, year, accidents, gas);
		addVehicle(electric);
		return electric;
	}
	/**
	 *This method create and add a new electric car 
	 *<b><pre>:<br><br>
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
	public Electric createElectricCar(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String sedan, int doors, String polarized, String chargerType, double batLife) {
		Electric electric = new Electric( basePrice, brand, model, cylinder, mileage, new1, sedan, doors, polarized, chargerType, batLife);
		addVehicle(electric);
		return electric;
	}
	/**
	 * This method create and add an used hybrid car 
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
	public Hybrid createHybridCar(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String sedan, int doors, String polarized, String chargerType, double batLife, double tankCapacity, String gasType, double price, double price2, int year, double accidents, double gas) {
		Hybrid hybrid = new Hybrid(basePrice, brand, model, cylinder, mileage, new1, plaque, sedan, doors, polarized, chargerType, batLife, tankCapacity, gasType, price, price2, year, accidents, gas);
		addVehicle(hybrid);
		return hybrid;
	}
	/**
	 * This method create and add a new hybrid car 
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
	public Hybrid createHybridCar(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String sedan, int doors, String polarized, String chargerType, double batLife, double tankCapacity, String gasType) {
		Hybrid hybrid = new Hybrid(basePrice, brand, model, cylinder, mileage, new1, sedan, doors, polarized, chargerType, batLife, tankCapacity, gasType);
		addVehicle(hybrid);
		return hybrid;
	}
	/**
	 * This method create and add an used motorcycle
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
	public Motorcycle createMotorcycle( double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String motorcycleType, double gasCapacity, double price, double price2, int year, double accidents, double gas) {
		Motorcycle motorcycle = new Motorcycle( basePrice, brand, model, cylinder, mileage, new1, plaque, motorcycleType, gasCapacity, price, price2, year, accidents, gas);
		addVehicle(motorcycle);
		return motorcycle;
	}
	/**
	 * This method create and add a new motorcycle
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
	public Motorcycle createMotorcycle( double basePrice, String brand, int model, double cylinder, int mileage, String new1, String motorcycleType, double gasCapacity) {
		Motorcycle motorcycle = new Motorcycle(basePrice, brand, model, cylinder, mileage, new1, motorcycleType,  gasCapacity);
		addVehicle(motorcycle);
		return motorcycle;
	}
	/**
	 * This method add a client with his respective employee 
	 * <b><pre>:<br>The employees are already created<br>
	 * 
	 * @param num position of the sales Man array
	 * @param name String name of the client
	 * @param lastName String last name of the client
	 * @param id integer id of client
	 * @param tel integer telephone of client 
	 * @param mail String mail of client
	 * @return String info notifying the state of client adding 
	 * 
	 * <b><post>:<br><br>
	 */
	public String addClientXemployee(int num, String name, String lastName, String id, String tel, String mail) {
		String info = "";
		boolean add = true;
		if(salesMan[num].clients[4] != null) {
			info += "Client cant be created by excess of clients per employee";
		}
		if(add == true && salesMan[num].clients[0] != null) {
			for (int i = 0; i < salesMan[num].clients.length; i++) {
				if((salesMan[num].clients[i] != null) && id.equals(salesMan[num].clients[i].getId()))  {
					add = false;
					info += "Cannot add client due ID is already registered for this employee\n";
					info += "Please re enter a client with different ID\n";
				}
			}
		}
		if(salesMan[num].clients[4] == null && add ==true)
			for (int i = 0; i < salesMan[num].clients.length; i++) {
				if(salesMan[num].clients[i] == null && add == true) {	
					salesMan[num].clients[i] = new Client(name, lastName, id, tel,mail);
					add = false;
					info += "Client added!";
				} 
			}
		return info;
	}
	/**
	 * This method set the name of company
	 * <b><pre>:<br><br>
	 * 
	 * @param name is the name of company
	 * 
	 * <b><post>:<br>Sets the company name<br>
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This method returns the company name
	 * <b><pre>:<br><br>
	 * 
	 * @return name is the name of company
	 * 
	 * <b><post>:<br><br>
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method set the nit code of company
	 * <b><pre>:<br><br>
	 * 
	 * @param nit is the nit code of company
	 * 
	 * <b><post>:<br>Sets the company nit<br>
	 */
	public void setNit(int nit) {
		this.nit = nit;
	}
	/**
	 * This method returns the company nit
	 * <b><pre>:<br><br>
	 * 
	 * @return nit code is the name of company
	 * 
	 * <b><post>:<br><br>
	 */
	public int getNit() {
		return nit;
	}
	/**
	 * This method set the total gain of company
	 * <b><pre>:<br><br>
	 * 
	 * @param totalGain is the gain of money of company
	 * 
	 * <b><post>:<br>Sets the company gain<br>
	 */
	public void setTotalGain(double totalGain) {
		this.totalGain = totalGain;
	}
	/**
	 * This method returns the company gain 
	 * <b><pre>:<br><br>
	 * 
	 * @return totalGain is the gain of money of company
	 * 
	 * <b><post>:<br><br>
	 */
	public double getTotalGain() {
		return totalGain;
	}
	/**
	 * This method set number of company sales
	 * <b><pre>:<br><br>
	 * 
	 * @param sales number of sales
	 * 
	 * <b><post>:<br>Sets the number of vehicles sales<br>
	 */
	public void setSales(int sales) {
		this.sales = sales;
	}
	/**
	 * This method returns the company sales 
	 * <b><pre>:<br><br>
	 * 
	 * @return sales is the number of vehicles sales
	 * 
	 * <b><post>:<br><br>
	 */
	public int getSales() {
		return sales;
	}
	/**
	 * This method deploy a list of vehicles on the concessionary 
	 * <b><pre>:<br>A vehicle must be created as minimum<br>
	 * 
	 * @param choose is the integer to choose the vehicle to show
	 * @return info as String with all information of vehicles
	 * 
	 * <b><post>:<br><br>
	 */
	public String showVehicles(int choose) {
		String info = "";
		if(vehicles.size()>0) {
			if(choose == 1) {
				for(int i = 0; i < vehicles.size(); i++) { 
						if(vehicles.get(i) instanceof Gasoline && vehicles.get(i).getNew1().equalsIgnoreCase("Yes")) {
							info += "\n*Gasoline Cars*"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+1)+"\n";
						}	
						if(vehicles.get(i) instanceof Electric && vehicles.get(i).getNew1().equalsIgnoreCase("Yes")) {
							info += "\n*Electric Cars*"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+1)+"\n";
						}
						if(vehicles.get(i) instanceof Hybrid && vehicles.get(i).getNew1().equalsIgnoreCase("Yes")) {
							info += "\n*Hybrid Cars*"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+1)+"\n";
						}
						if(vehicles.get(i) instanceof Motorcycle && vehicles.get(i).getNew1().equalsIgnoreCase("Yes")) {
							info += "\n*Motorcycles*"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+1)+"\n";
						}
					}
				}
			}
			if(choose == 2) {
				for(int i = 0; i < vehicles.size(); i++) { 
						if(vehicles.get(i) instanceof Gasoline && vehicles.get(i).getNew1().equalsIgnoreCase("No")) {
							info += "\n*Gasoline Cars*"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+1)+"\n";
						}	
						if(vehicles.get(i) instanceof Electric && vehicles.get(i).getNew1().equalsIgnoreCase("No")) {
							info += "\n*Electric Cars*"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+1)+"\n";
						}
						if(vehicles.get(i) instanceof Hybrid && vehicles.get(i).getNew1().equalsIgnoreCase("No")) {
							info += "\n*Hybrid Cars*"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+1)+"\n";
						}
						if(vehicles.get(i) instanceof Motorcycle && vehicles.get(i).getNew1().equalsIgnoreCase("No")) {
							info += "\n*Motorcycle*"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+1)+"\n";
						}
					}
				}
			if(choose == 3) {
				for(int i = 0; i < vehicles.size(); i++) { 
					if(vehicles.get(i) instanceof Gasoline) {
						info += "\n*Gasoline Cars*"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+1)+"\n";
					}	
					if(vehicles.get(i) instanceof Electric) {
						info += "\n*Electric Cars*"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+1)+"\n";
					}
					if(vehicles.get(i) instanceof Hybrid) {
						info += "\n*Hybrid Cars*"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+1)+"\n";
					}
					if(vehicles.get(i) instanceof Motorcycle) {
						info += "\n*Motorcycle*"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+1)+"\n";
					}
				}
			}
		return info;
		}
	/**
	 * This method deploy a list of clients per sellers
	 * <b><pre>:<br>A client must be created as minimum<br>
	 * 
	 * @return info as String with the information of client and his sales man attend
	 * 
	 * <b><post>:<br>Notify slots remaining per employee<br>
	 */
	public String showEmployees() {
		String info = "";
		int k = 0;
		for (int i = 0; i < salesMan.length; i++) {
			info += "\nThe seller #" + (i+1) + " named "+ salesMan[i].getName() + " has assigned: \n";
			for (int j = 0; j < salesMan[i].clients.length; j++) {
				if(salesMan[i].clients[j] != null) {
					info += "--Client #"+(j+1) +"--\n" + "Name: "+salesMan[i].clients[j].getName() + "\nLast name: " + salesMan[i].clients[j].getLastName() + "\nID: " + salesMan[i].clients[j].getId()+"\n";	
				}
				if(salesMan[i].clients[j] == null) {
					k+=1;
				}
			}
			info += +k+" Slots remaining to add a client\n";
			k = 0;
		}
		return info;
	}
	/**
	 * This method show the complete information per employees
	 *  <b><pre>:<br>array of employees must be already initialize<br>
	 *  
	 * @return info String with the information
	 * 
	 * <b><post>:<br>Deploy a list<br>
	 */
	public String showEmployeesComplete() {
		String info = "";
		for (int i = 0; i < salesMan.length; i++) {
			info += "\nSeller #" + (i+1) + "\nID: "+salesMan[i].getId()+"\nName: "+salesMan[i].getName()+"\nLast name: "+salesMan[i].getLastName()+"\nHad sold: "+salesMan[i].getTotalSales()+" vehicles\n";
		}
		return info;
	}
	/**
	 * This method show the vehicles on the arrayList of a specific client 
	 * <b><pre>:<br><br>
	 * 
	 * @param sellerNumber integer position of arrayList salesMan
	 * @param clientNumber integer position of array clients
	 * @return info String returns information of favorite vehicle
	 * 
	 * <b><post>:<br>Deploy a list<br>
	 */
	public String favoriteVehicles(int sellerNumber, int clientNumber) {
		String info = "";
		if(salesMan[sellerNumber].clients[clientNumber].tryDrive.size() > 0) {
			for (int i = 0; i < salesMan[sellerNumber].clients[clientNumber].tryDrive.size(); i++) {
				info += salesMan[sellerNumber].clients[clientNumber].tryDrive.get(i).description();
			}
		}
		else
			info += "This client hasn't vehicles added in his favorites";
		return info;
	}
}