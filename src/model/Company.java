package model;
import java.util.*;

public class Company {

	private String name;
	private int nit;
	private double totalGain;
	private int sales;
	public static int MAX_SELLER = 10;


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
		Vehicle g1 = new Gasoline(20000, "Chevrolet", 2020, 1.8, 2, "Yes", "Yes", 4, "Yes", 9, "NORMAL");
		Vehicle e1 = new Electric(30000, "Tesla", 2020, 3.5, 2, "Yes", "Yes", 4, "No", "FAST", 300);
		Vehicle h1 = new Hybrid(25000, "Tesla", 2020, 2.1, 1, "Yes", "No", 4, "Yes", "NORMAL", 400, 7, "EXTRA");
		Motorcycle m1 = new Motorcycle(5000, "Honda", 2020, 1.2, 1, "Yes", "SPORT", 2);
		addVehicle(g1);
		addVehicle(e1);
		addVehicle(h1);
		addVehicle(m1);
	}
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	public Gasoline createGasolineCar( double basePrice, String brand, int model, double cylinder, int mileage, String new1, String plaque, String sedan, int doors, String polarized, double tankCapacity, String gasType, double price, double price2, int year, double accidents, double gas) {
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
				info += "\n***Gasoline Cars***"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+=1)+"\n";
				i-=1;
			}	
			if(vehicles.get(i) instanceof Car && vehicles.get(i) instanceof Electric) {
				info += "\n***Electric Cars***"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+=1)+"\n";
				i-=1;
			}
			if(vehicles.get(i) instanceof Car && vehicles.get(i) instanceof Hybrid) {
				info += "\n***Hybrid Cars***"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+=1)+"\n";
				i-=1;
			}
			if(vehicles.get(i) instanceof Motorcycle) {
				info += "\n***Motorcycle***"+"\n"+vehicles.get(i).description()+"\n"+"Number of vehicle in list: #"+(i+=1)+"\n";
				i-=1;
			}
		}return info;
	}
	public String showEmployees() {
		String info = "";
		int k = 5;
		for (int i = 0; i < salesMan.length; i++) {
			info += "\nThe seller #" + (i+1) + " named "+ salesMan[i].getName() + " has assigned: \n";
			for (int j = 0; j < salesMan[i].clients.length; j++) {
				if(salesMan[i].clients[j] != null) {
					info += "Client # "+ (j+1) + " " + salesMan[i].clients[j].getName() + " " + salesMan[i].clients[j].getLastName() + " with the ID " + salesMan[i].clients[j].getId() + "\n";	
					k-=1;
				}
			}
			if(k==5)
				info += "This seller is free in this moments\n\n";
		}
		return info;
	}
}