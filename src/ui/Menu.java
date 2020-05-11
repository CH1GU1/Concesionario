package ui;
import java.util.*;

import model.Car;
import model.Company;
import model.Documents;
import model.Electric;
import model.Gasoline;
import model.Hybrid;
import model.Motorcycle;
import model.Vehicle;
public class Menu {

	//Attributes and constants declaration
	static Scanner sc;
	private Company company = new Company("Vehicle sales store", 1234, 0, 0);
	private final static int ADD_VEHICLES = 1;
	private final static int ADD_CLIENTS= 2;
	private final static int SHOW_COMPANY_EMPLOYEES = 3;
	private final static int SHOW_COMPANY_VEHICLES = 4;
	private final static int SHOW_CLIENTS = 5;
	private final static int ENTRY_FAVORITES = 6;
	private final static int APPLY_DICSOUNT = 7;
	private final static int EXIT = 8;


	public Menu() {
		this.company = startCompany();
	}
	public Company startCompany() {
		sc = new Scanner(System.in);
		System.out.println("****"+company.getName()+"****"+"\n - NIT: "+company.getNit()+"\n - Total gain: "+company.getTotalGain()+"\n - Sales: "+company.getSales());
		return company;
	}
	public void initializeEmployees() {
		company.initializeEmployee();
		System.out.println();
		System.out.println("Employees are already created \n");

	}
	public int readOption() {
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println();
		return choice;
	}
	public void readClient() {
		System.out.println("Entry client name");
		String name = sc.nextLine();
		System.out.println("Entry client last name");
		String lastName = sc.nextLine();
		System.out.println("Entry client id");
		String id = sc.nextLine();
		System.out.println("Entry client telephone");
		String tel = sc.nextLine();
		System.out.println("Entry client mail");
		String mail = sc.nextLine();
		System.out.println("Select the employee to assign the client");
		System.out.println(company.showEmployees());
		int num = sc.nextInt();
		num -=1;
		sc.nextLine();
		company.addClientXemployee(num, name, lastName, id, tel, mail);
	} 
	public void favoriteOfClient() {
		System.out.println("The company has these sellers with those assigned clients");
		showClients();
		System.out.println();
		System.out.println("Entry the number of seller who has client registered?");
		int sellerNumber = 0;
		while(sellerNumber<1 || sellerNumber>10) {
			System.out.println("Choose him with her seller number");
			sellerNumber = sc.nextInt();
		}
		sellerNumber-=1;
		System.out.println("Which of the assigned is the client who wants to choose a favorite vehicle?");
		int clientNumber = 0;
		int k = 0;
		for (int i = 0; i < company.salesMan[sellerNumber].clients.length; i++) {
			if(company.salesMan[sellerNumber].clients[i] != null) {	
				k+=1;
			}
		}
		while(clientNumber<1 || clientNumber>k) {
			System.out.println("Choose him with her seller number");
			clientNumber = sc.nextInt();
		}
		clientNumber-=1;
		System.out.println();
		System.out.println("Which vehicle do you want to add to favorites?\n");
		System.out.println(company.showVehicles()+"\n");
		int choose = 0;
		while(choose < 1 || choose>company.vehicles.size()) {
			System.out.println("Choose it with it's vechicle number\n");
			choose = sc.nextInt();
		}
		choose-=1;
		company.salesMan[sellerNumber].clients[clientNumber].tryDrive.add(company.vehicles.get(choose));
		System.out.println("Vehicle added to favorites to the client: " + company.salesMan[sellerNumber].clients[clientNumber].getName());
	}
	public String vehicleChosen(int choose) {
		String info = "";
		switch (choose) {
		case 1:
			System.out.println("Which of these type of cars do you buy?\n1. Gasoline\n2. Electric\n3. Hybrid");
			int typeCar = sc.nextInt();
			info += carChosen(typeCar);
			break;

		case 2:
			info += createMotorcycle();
			break;

		default: System.out.println("Choose a valid option please");
		break;
		}
		return info;
	}
	public String createMotorcycle() {
		String info = "";
		System.out.println("Type his base price");
		double basePrice = sc.nextDouble();
		sc.nextLine();
		System.out.println("Type his brand");
		String brand = sc.nextLine();
		System.out.println("Type his model");
		int model = sc.nextInt();
		System.out.println("Type the cylinder");
		double cylinder = sc.nextDouble();
		System.out.println("Enter his mileage");
		int mileage = sc.nextInt();
		sc.nextLine();
		System.out.println("The motorcycle is new or used? 1.New 2.Used");
		int time = sc.nextInt();
		String new1 = "";
		switch (time) {
		case 1:
			new1 = "Yes"; 
			break;
		case 2:
			new1 = "No";
			break;
		default: 
			System.out.println("Select 1 or 2");
			break;
		}
		System.out.println("Enter the type of the motorcycle \n1.Standar 2.Sport 3.Scooter 4.Cross");
		int Type = sc.nextInt();
		String motorcycleType = "";
		switch (Type) {
		case 1:
			motorcycleType = "Standar";
			break;
		case 2:
			motorcycleType = "Sport";
			break;
		case 3:
			motorcycleType = "Scooter";
			break;
		case 4:
			motorcycleType = "Cross";
			break;
		default: 
			System.out.println("Select 1, 2, 3 or 4");
			break;
		}
		sc.nextLine();
		if(new1.equalsIgnoreCase("No")) {
			System.out.println("Enter his plaque");
			String plaque = sc.nextLine();
			System.out.println("Enter the gas capacity of the motorcycle");
			double gasCapacity = sc.nextDouble();
			System.out.println("Enter SOAT price");
			double price = sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter TECH price");
			double price2 = sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter documents year");
			int year = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter cover cost of accidents: ");
			double accidents = sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter the gases levels");
			double gas = sc.nextDouble();
			sc.nextLine();
			company.createMotorcycle(basePrice, brand, model, cylinder, mileage, new1, plaque, motorcycleType, gasCapacity, price, price2, year, accidents, gas);
		}
		else if(new1.equalsIgnoreCase("Yes")) {
			System.out.println("Type the gasoline capacity of the motorcycle");
			double gasCapacity = sc.nextDouble();
			double consume = (gasCapacity * (cylinder / 90));
			System.out.println("Consume calculated is: "+consume);
			System.out.println();
			company.createMotorcycle(basePrice, brand, model, cylinder, mileage, new1, motorcycleType,  gasCapacity);
		}
		return info += "The motorcycle was succesfully created";
	}
	public void createNewCar(int typeCar) {
		System.out.println("Type his base price");
		double basePrice = sc.nextDouble();
		sc.nextLine();
		System.out.println("Type his brand");
		String brand = sc.nextLine();
		System.out.println("Type his model");
		int model = sc.nextInt();
		System.out.println("Type his cylinder");
		double cylinder = sc.nextDouble();
		System.out.println("Enter his mileage");
		int mileage = sc.nextInt();
		sc.nextLine();
		System.out.println("The car is new or used? 1.New 2.Used");
		int time = sc.nextInt();
		String new1 = "";
		switch (time) {
		case 1:
			new1 = "Yes"; 
			break;
		case 2:
			new1 = "No";
			break;
		default: 
			System.out.println("Select 1 or 2");
			break;
		}
		System.out.println("Is sedan? 1.Yes 2.No");
		int bodyType = sc.nextInt();
		String sedan = "";
		switch (bodyType) {
		case 1:
			sedan = "Yes"; 
			break;
		case 2:
			sedan = "No";
			break;
		default: 
			System.out.println("Select 1 or 2");
			break;
		}
		System.out.println("Type the doors number in the car");
		int doors = sc.nextInt();
		System.out.println("Is polarized? 1.Yes 2.No");
		int pol = sc.nextInt();
		String polarized = "";
		switch (pol) {
		case 1:
			polarized = "Yes"; 
			break;
		case 2:
			polarized = "No";
			break;
		default: 
			System.out.println("Select 1 or 2");
			break;
		}
		if(new1.equalsIgnoreCase("No")) {
			sc.nextLine();
			System.out.println("Enter his plaque");
			String plaque = sc.nextLine();
			switch (typeCar) {
			case 1:
				System.out.println("Enter the tank capacity");
				int tankCapacity = sc.nextInt();
				sc.nextLine();
				boolean continues = false;
				String gasType = "";
				while(!continues){
					System.out.println("Enter the type of gasoline \n1.Normal \n2.Diesel \n3.Extra");
					int key = sc.nextInt();
					sc.nextLine();	
					switch (key) {
					case 1:
						gasType = "Normal";
						continues = true;
						break;
					case 2:
						gasType = "Diesel";
						continues = true;
						break;
					case 3:
						gasType = "Extra";
						continues = true;
						break;
					default:
						System.out.println("**Select a correct option**");
						break;
					}
				}
				System.out.println();
				System.out.println("Enter SOAT price");
				double price = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter TECH price");
				double price2 = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter documents year");
				int year = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter cover cost of accidents: ");
				double accidents = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter the gases levels");
				double gas = sc.nextDouble();
				sc.nextLine();
				company.createGasolineCar(basePrice, brand, model, cylinder, mileage, new1, plaque, sedan, doors, polarized, tankCapacity,  gasType, price, price2, year, accidents, gas);
				break;

			case 2:
				System.out.println("Enter the type of the charger 1.Normal 2.Fast");
				int op = sc.nextInt();
				String chargerType = "";
				switch (op) {
				case 1:
					chargerType = "NORMAL";
					break;
				case 2: 
					chargerType = "FAST";
					break;
				default:System.out.println("Select 1 or 2");
				break;
				}
				System.out.println("Enter the battery life");
				double batLife = sc.nextDouble();
				System.out.println("Enter SOAT price");
				double priceE = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter TECH price");
				double price2E = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter documents year");
				int yearE = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter cover cost of accidents: ");
				double accidentsE = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter the gases levels");
				double gasE = sc.nextDouble();
				sc.nextLine();
				company.createElectricCar( basePrice, brand, model,cylinder, mileage, new1, plaque, sedan, doors, polarized, chargerType, batLife, priceE, price2E, yearE, accidentsE, gasE);
				break;

			case 3:
				System.out.println("Enter the tank capacity");
				int tankCapacityH = sc.nextInt();
				sc.nextLine();
				boolean continuesH = false;
				String gasTypeH = "";
				while(!continuesH){
					System.out.println("Enter the type of gasoline \n1.Normal \n2.Diesel \n3.Extra");
					int key = sc.nextInt();
					sc.nextLine();	
					switch (key) {
					case 1:
						gasTypeH = "Normal";
						continuesH = true;
						break;
					case 2:
						gasTypeH = "Diesel";
						continuesH = true;
						break;
					case 3:
						gasTypeH = "Extra";
						continuesH = true;
						break;
					default:
						System.out.println("**Select a correct option**");
						break;
					}
				}
				System.out.println("Enter the type of the charger 1.Normal 2.Fast");
				int op2 = sc.nextInt();
				String chargerTypeH = "";
				switch (op2) {
				case 1:
					chargerTypeH = "NORMAL";
					break;
				case 2: 
					chargerTypeH = "FAST";
					break;
				default:System.out.println("Select 1 or 2");
				break;
				}
				System.out.println("Enter the battery life");
				double batLifeH = sc.nextDouble();
				System.out.println("Enter SOAT price");
				double priceH = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter TECH price");
				double price2H = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter documents year");
				int yearH = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter cover cost of accidents: ");
				double accidentsH = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter the gases levels");
				double gasH = sc.nextDouble();
				sc.nextLine();
				company.createHybridCar(basePrice,brand, model,cylinder,mileage, new1, plaque, sedan, doors, polarized, chargerTypeH, batLifeH, tankCapacityH, gasTypeH, priceH, price2H, yearH, accidentsH, gasH);
				break;

			default: System.out.println("Enter a valid option");
			break;
			}
		}
		else if(new1.equalsIgnoreCase("Yes")) {
			switch (typeCar) {
			case 1:
				System.out.println("Enter the tank capacity");
				int tankCapacity = sc.nextInt();
				sc.nextLine();
				boolean continues = false;
				String gasType = "";
				while(!continues){
					System.out.println("Enter the type of gasoline \n1.Normal \n2.Diesel \n3.Extra");
					int key = sc.nextInt();
					sc.nextLine();	
					switch (key) {
					case 1:
						gasType = "Normal";
						continues = true;
						break;
					case 2:
						gasType = "Diesel";
						continues = true;
						break;
					case 3:
						gasType = "Extra";
						continues = true;
						break;
					default:
						System.out.println("**Select a correct option**");
						System.out.println();
						break;
					}
				}
				System.out.println();
				company.createGasolineCar( basePrice, brand, model, cylinder, mileage, new1, sedan, doors, polarized, tankCapacity, gasType);
				break;

			case 2:
				System.out.println("Enter the type of the charger 1.Normal 2.Fast");
				int op = sc.nextInt();
				String chargerType = "";
				switch (op) {
				case 1:
					chargerType = "NORMAL";
					break;
				case 2: 
					chargerType = "FAST";
					break;
				default:System.out.println("Select 1 or 2");
				break;
				}
				System.out.println("Enter the battery life");
				double batLife = sc.nextDouble();
				company.createElectricCar(basePrice,brand, model, cylinder, mileage, new1, sedan, doors, polarized, chargerType, batLife);
				break;

			case 3:
				System.out.println("Enter the tank capacity");
				int tankCapacityH = sc.nextInt();
				sc.nextLine();
				boolean continuesH = false;
				String gasTypeH = "";
				while(!continuesH){
					System.out.println("Enter the type of gasoline \n1.Normal \n2.Diesel \n3.Extra");
					int key = sc.nextInt();
					sc.nextLine();	
					switch (key) {
					case 1:
						gasTypeH = "Normal";
						continuesH = true;
						break;
					case 2:
						gasTypeH = "Diesel";
						continuesH = true;
						break;
					case 3:
						gasTypeH = "Extra";
						continuesH = true;
						break;
					default:
						System.out.println("**Select a correct option**");
						System.out.println();
						break;
					}
				}
				System.out.println();
				System.out.println("Enter the type of the charger 1.Normal 2.Fast");
				int op1 = sc.nextInt();
				String chargerTypeH = "";
				switch (op1) {
				case 1:
					chargerTypeH = "NORMAL";
					break;
				case 2: 
					chargerTypeH = "FAST";
					break;
				default:System.out.println("Select 1 or 2");
				break;
				}
				System.out.println("Enter the battery life");
				double batLifeH = sc.nextDouble();
				System.out.println();
				company.createHybridCar(basePrice, brand,model, cylinder, mileage, new1, sedan, doors, polarized, chargerTypeH, batLifeH, tankCapacityH,  gasTypeH);
				break;

			default: System.out.println("Choose a valid option please");
			break;
			}
		}
	}
	public String carChosen(int selection) {
		String info = "";
		switch (selection) {
		case 1:
			createNewCar(selection);
			info += "Your gasoline car was created";
			break;
		case 2:
			createNewCar(selection);
			info += "Your electric car was created";
			break;
		case 3:
			createNewCar(selection);
			info += "Your hybrid car was created";
			break;
		default: System.out.println("Choose a correct option");
		break;
		}
		return info;
	}
	public String enterVehicle() {
		System.out.println("What vehicle do you buy?\n1. Car\n2. Motorcycle");
		int choose = sc.nextInt();
		String info = vehicleChosen(choose);
		return info;
	}
	public void showClients() {
		String info = "";
		for (int i = 0; i < company.salesMan.length; i++) {
			for (int j = 0; j < company.salesMan[i].clients.length; j++) {
				if(company.salesMan[i].clients[j] != null) {
					System.out.println("Employee name: "+company.salesMan[i].getName()+" #"+(i+=1)+"\n");
					i--;
					System.out.println("--Client-- #"+(j+=1)+"\n");
					j--;
					info = "Name: "+company.salesMan[i].clients[j].getName()+"\nLast name: "+company.salesMan[i].clients[j].getLastName()+"\nID: "+company.salesMan[i].clients[j].getId()+"\n";
					System.out.println(info);
				}
			}
		}
	}
	public void apllyDiscount() {
		int select = 0; 
		double value = 0;
		double amount = 0;
		double finalValue = 0;
		System.out.println(company.showVehicles());
		System.out.println();
		System.out.println("Which number of vehicle do you want to apply discount?");
		select = sc.nextInt();
		select-=1;
		System.out.println("How many discount do you want to apply?");
		System.out.println("Enter values between 1 and 99 percent");
		value = sc.nextInt();
		value = value/100;
		amount = company.vehicles.get(select).getTotalPrice() * value;
		finalValue = company.vehicles.get(select).getTotalPrice() - amount;
		company.vehicles.get(select).setTotalPrice(finalValue);
		System.out.println("Discount of "+value*100+"% Was applied to vehicle!\nPlease check on the vehicle list\n");
	}
	public void operation(int choice) {
		switch(choice) {
		case ADD_VEHICLES:
			System.out.println(enterVehicle());
			break;
		case ADD_CLIENTS:
			readClient();
			break;
		case SHOW_COMPANY_EMPLOYEES:			
			System.out.println(company.showEmployees());
			break;
		case SHOW_COMPANY_VEHICLES:
			System.out.println(company.showVehicles());
			break;
		case SHOW_CLIENTS:
			showClients();
			break;
		case ENTRY_FAVORITES:
			favoriteOfClient();
			break;
		case APPLY_DICSOUNT:
			apllyDiscount();
			break;
		default:
			System.out.println();
			System.out.println("Please select a correct option");
			break;
		}
	}
	public void showMenu() {
		System.out.println("********MENU********");
		System.out.println();
		System.out.println("1. Add vehicle\n2. Add clients for each employee\n3. Show company employees\n4. Show company vehicles \n5. Show clients per employee \n6. Show favorites per client\n7. Apply discount to vehicle\n8. Exit\n");
	}
	public void startProgram() {
		int option;
		initializeEmployees();
		do {
			showMenu();
			option = readOption();
			operation(option);
		} while(option!=EXIT);
	}
} 