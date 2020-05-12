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

	public Company(String name, int nit, double totalGain, int sales) {
		this.name = name;
		this.nit = nit;
		this.totalGain = totalGain;
		this.sales = sales;
		vehicles = new ArrayList<>();
		salesMan = new Employee[MAX_SELLER];
	}

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
		Vehicle Ug1 = new Gasoline(500000, "Hyundai", 2014, 1.7, 700, "No", "HMO-024", "Yes", 4, "Yes", 9, "NORMAL", 300, 200, 2014, 50000, 20);
		Vehicle Ug2 = new Gasoline(400000, "Renault", 2013, 1.5, 900, "No", "TRG-346", "Yes", 4, "Yes", 8, "NORMAL", 200, 500, 2013, 20000, 30);
		Vehicle Ug3 = new Gasoline(200000, "Mazda", 2012, 3.0, 500, "No", "JPR-356", "No", 4, "Yes", 15, "EXTRA", 400, 800, 2012, 30000, 32);
		Vehicle Ug4 = new Gasoline(350000, "Nissan", 2011, 1.6, 200, "No", "BMT-056", "Yes", 4, "Yes", 7, "NORMAL", 100, 200, 2011, 25000, 26);
		Vehicle Ug5 = new Gasoline(410000, "BMW", 2010, 2.2, 800, "No", "GHT-456", "Yes", 2, "Yes", 9, "EXTRA", 500, 400, 2010, 50000, 20);
		Vehicle g1 = new Gasoline(20000, "Chevrolet", 2020, 1.8, 2, "Yes", "Yes", 4, "Yes", 9, "NORMAL");
		Vehicle e1 = new Electric(30000, "Tesla", 2020, 3.5, 2, "Yes", "Yes", 4, "No", "FAST", 300);
		Vehicle h1 = new Hybrid(25000, "Tesla", 2020, 2.1, 1, "Yes", "No", 4, "Yes", "NORMAL", 400, 7, "EXTRA");
		Motorcycle m1 = new Motorcycle(5000, "Honda", 2020, 1.2, 1, "Yes", "SPORT", 2);
		addVehicle(g1);
		addVehicle(e1);
		addVehicle(h1);
		addVehicle(m1);
		addVehicle(Ug1);
		addVehicle(Ug2);
		addVehicle(Ug3);
		addVehicle(Ug4);
		addVehicle(Ug5);
	}
	public Car[][] getParking() {
		return parkingLot;
	}	
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
						info += "\n**There "+(10-k)+" parkings free for 2014 cars models \n**";
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
						info += "\n**There "+(10-k)+" parkings free for 2013 cars models \n**";
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
						info += "\n**There "+(10-k)+" parkings free for 2012 cars models \n**";
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
						info += "\n**There "+(10-k)+" parkings free for 2011 cars models \n**";
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
						info += "\n**There "+(10-k)+" parkings free for cars models below 2011  \n**";
						cont = false;
					}	
				}
			}
		}
		return info;
	}
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
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	public Gasoline createGasolineCar(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String sedan, int doors, String polarized, double tankCapacity, String gasType, double price, double price2, int year, double accidents, double gas) {
		Gasoline gasoline = new Gasoline(basePrice, brand, model, cylinder, mileage, new1, plaque, sedan, doors, polarized, tankCapacity, gasType, price, price2, year, accidents, gas);
		addVehicle(gasoline);
		return gasoline;
	}
	public Gasoline createGasolineCar(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String sedan, int doors, String polarized, double tankCapacity, String gasType) {
		Gasoline gasoline = new Gasoline( basePrice,  brand,  model, cylinder, mileage, new1, sedan,  doors,  polarized, tankCapacity, gasType);
		addVehicle(gasoline);
		return gasoline;
	}

	public Electric createElectricCar(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String sedan, int doors, String polarized, String chargerType, double batLife, double price, double price2, int year,  double accidents, double gas) {
		Electric electric = new Electric( basePrice, brand, model, cylinder, mileage, new1, plaque, sedan, doors, polarized, chargerType, batLife, price, price2, year, accidents, gas);
		addVehicle(electric);
		return electric;
	}

	public Electric createElectricCar(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String sedan, int doors, String polarized, String chargerType, double batLife) {
		Electric electric = new Electric( basePrice, brand, model, cylinder, mileage, new1, sedan, doors, polarized, chargerType, batLife);
		addVehicle(electric);
		return electric;
	}

	public Hybrid createHybridCar(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String sedan, int doors, String polarized, String chargerType, double batLife, double tankCapacity, String gasType, double price, double price2, int year, double accidents, double gas) {
		Hybrid hybrid = new Hybrid(basePrice, brand, model, cylinder, mileage, new1, plaque, sedan, doors, polarized, chargerType, batLife, tankCapacity, gasType, price, price2, year, accidents, gas);
		addVehicle(hybrid);
		return hybrid;
	}

	public Hybrid createHybridCar(double basePrice, String brand, int model, double cylinder, int mileage, String new1, String sedan, int doors, String polarized, String chargerType, double batLife, double tankCapacity, String gasType) {
		Hybrid hybrid = new Hybrid(basePrice, brand, model, cylinder, mileage, new1, sedan, doors, polarized, chargerType, batLife, tankCapacity, gasType);
		addVehicle(hybrid);
		return hybrid;
	}

	public Motorcycle createMotorcycle( double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String motorcycleType, double gasCapacity, double price, double price2, int year, double accidents, double gas) {
		Motorcycle motorcycle = new Motorcycle( basePrice, brand, model, cylinder, mileage, new1, plaque, motorcycleType, gasCapacity, price, price2, year, accidents, gas);
		addVehicle(motorcycle);
		return motorcycle;
	}
	public Motorcycle createMotorcycle( double basePrice, String brand, int model, double cylinder, int mileage, String new1, String motorcycleType, double gasCapacity) {
		Motorcycle motorcycle = new Motorcycle(basePrice, brand, model, cylinder, mileage, new1, motorcycleType,  gasCapacity);
		addVehicle(motorcycle);
		return motorcycle;
	}
	public void addClientXemployee(int num, String name, String lastName, String id, String tel, String mail) {
		boolean add = true;
		if(salesMan[num].clients[4] != null) {
			System.out.println("Client cant be created by excess of clients per employee");
		}
		if(add == true && salesMan[num].clients[0] != null) {
			for (int i = 0; i < salesMan[num].clients.length; i++) {
				if((salesMan[num].clients[i] != null) && id.equals(salesMan[num].clients[i].getId()))  {
					add = false;
					System.out.println("Cannot add client due ID is already registered for this employee\n");
					System.out.println("Please re enter a client with different ID\n");
				}
			}
		}
		if(salesMan[num].clients[4] == null && add ==true)
			for (int i = 0; i < salesMan[num].clients.length; i++) {
				if(salesMan[num].clients[i] == null && add == true) {	
					salesMan[num].clients[i] = new Client(name, lastName, id, tel,mail);
					add = false;
					System.out.println("Client added!");
				} 
			}
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param nit
	 */
	public void setNit(int nit) {
		this.nit = nit;
	}

	public int getNit() {
		return nit;
	}

	/**
	 * 
	 * @param totalGain
	 */
	public void setTotalGain(double totalGain) {
		this.totalGain = totalGain;
	}

	public double getTotalGain() {
		return totalGain;
	}

	/**
	 * 
	 * @param sales
	 */
	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getSales() {
		return sales;
	}

	public String infoVehicles() {
		return name;
	}
	public String showVehicles() {
		String info = "";
		for(int i = 0; i < vehicles.size(); i++) { 
			if(vehicles.get(i) instanceof Car && vehicles.get(i) instanceof Gasoline) {
				info += "\n***Gasoline Cars***"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+1)+"\n";		
			}	
			if(vehicles.get(i) instanceof Car && vehicles.get(i) instanceof Electric) {
				info += "\n***Electric Cars***"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+1)+"\n";		
			}
			if(vehicles.get(i) instanceof Car && vehicles.get(i) instanceof Hybrid) {
				info += "\n***Hybrid Cars***"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+1)+"\n";		
			}
			if(vehicles.get(i) instanceof Motorcycle) {
				info += "\n***Motorcycle***"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+1)+"\n";

			}
		}return info;
	}
	public String showEmployees() {
		String info = "";
		for (int i = 0; i < salesMan.length; i++) {
			info += "\nThe seller #" + (i+1) + " named "+ salesMan[i].getName() + " has assigned: \n";
			for (int j = 0; j < salesMan[i].clients.length; j++) {
				if(salesMan[i].clients[j] != null) {
					info += "Client # "+ (j+1) + "\n" + salesMan[i].clients[j].getName() + "\n" + salesMan[i].clients[j].getLastName() + "\nwith the ID " + salesMan[i].clients[j].getId()+"\n";	
				}
				if(salesMan[i].clients[j] == null) {
					System.out.println();
					info += "Position #"+(j+1)+" free to add a client\n";
				}
			}
		}
		return info;
	}
	public String showEmployeesComplete() {
		String info = "";
		for (int i = 0; i < salesMan.length; i++) {
			info += "\nSeller #" + (i+1) + "\nID: "+salesMan[i].getId()+"\nName: "+salesMan[i].getName()+"\nLast name: "+salesMan[i].getLastName()+"\nHad sold: "+salesMan[i].getTotalSales()+" vehicles\n";
			System.out.println();
		}
		return info;
	}
}