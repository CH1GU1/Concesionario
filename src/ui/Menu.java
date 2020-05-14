package ui;
import java.time.LocalDate;
import java.util.*;
import model.Company;
public class Menu {

	//Attributes and constants declaration
	static Scanner sc;
	private Company company = new Company("Vehicle sales store", 1234, 0, 0);
	private final static int ADD_VEHICLES = 1;
	private final static int CLIENT_FAVORITES = 1;
	private final static int ADD_CLIENTS= 2;
	private final static int SHOW_COMPANY_EMPLOYEES = 3;
	private final static int SHOW_COMPNAY_EMPLOYEES_COMPLETE = 4;
	private final static int SHOW_COMPANY_VEHICLES = 5;
	private final static int SHOW_CLIENTS = 6;
	private final static int ENTRY_FAVORITES = 7;
	private final static int SHOW_FAVORITES = 8;
	private final static int APPLY_DICSOUNT = 9;
	private final static int ORGANIZE_PARKING = 10;
	private final static int FINAL_PAY = 11;
	private final static int EXIT = 12;

	/**
	 *This method initialize the menu.
	 *<b>pre:</b> <br>
	 *<b>post:</b>The Menu is ready<br>
	 */
	public Menu() {
		this.company = startCompany();
	}
	/**
	 *This method initialize the company.
	 *
	 *<b>pre:</b><br>
	 *
	 *<b>post:</b> The company is already created.<br>
	 *@return company. 
	 */
	public Company startCompany() {	
		sc = new Scanner(System.in);	
		return company;
	}
	/**
	 *This method call the method "initializeEmployees" on company and initialize the ten employees and six vehicles.
	 *<b>pre:</b> Company already created<br>
	 *
	 *<b>post:</b> The ten employees and six vehicles are already created.<br>
	 */
	public void initializeEmployees() {
		company.initializeEmployee();
		System.out.println();
		System.out.println("Employees are already created \n");

	}
	/**
	 *This method read the option entry by the client for the Main menu.
	 *<b>pre:</b>Select an option between 1 to 11. <br>
	 *
	 *<b>post:</b><br>
	 *@return choice integer of option to do
	 */
	public int readOption() {
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println();
		return choice;
	}
	/**
	 *This method read the information of a new client and then is assigned to an employee.
	 *<b>pre:</b>The employees must be created.<br>
	 *
	 *<b>post:</b>A new client was created and assigned to an employee.<br>
	 */
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
		System.out.println(company.addClientXemployee(num, name, lastName, id, tel, mail));
	} 
	/**
	 *This method add a favorite vehicle to a client.
	 *<b>pre:</b>A client as minimum was created.<br>
	 *
	 *<b>post:</b>The selected client has a favorite vehicle on his list.<br>
	 */
	public void favoriteOfClient() {
		System.out.println("Employees with assigned clients:");
		showClients();
		System.out.println();
		System.out.println("Entry the number of seller who has assigned a client");
		int sellerNumber = 0;
		while(sellerNumber<1 || sellerNumber>10) {
			System.out.println("Choose the seller number");
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
			System.out.println("Select the client number on the list");
			clientNumber = sc.nextInt();
		}
		clientNumber-=1;
		System.out.println();
		System.out.println("Which vehicle do you want to add to favorites?\n");
		System.out.println(company.showVehicles(3)+"\n");
		int choose = 0;
		while(choose < 1 || choose>company.vehicles.size()) {
			System.out.println("Choose the vehicle number on the list\n");
			choose = sc.nextInt();
		}
		choose-=1;
		company.salesMan[sellerNumber].clients[clientNumber].tryDrive.add(company.vehicles.get(choose));
		System.out.println("Vehicle added to favorites to the client: " + company.salesMan[sellerNumber].clients[clientNumber].getName());
	}
	/**
	 *This method is a sub menu for select the type of car between Gasoline, electric or hybrid car to add to company.
	 *<b>pre:</b>Company already created.<br>
	 *
	 * @param choose option to type of vehicle to add
	 * @return info to report the state of the process.
	 * 
	 *<b>post:</b>A selection was done and then can continue to the process of add a car.<br>
	 */
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
	/**
	 * This method request the information of a motorcycle and then create it. 
	 * <b>pre:</b>Company already created.<br> 
	 * 
	 * @return info to report the state of the process.
	 * 
	 * <b>post:</b>The motorcycle was created.<br>
	 */
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
			System.out.println();
			company.createMotorcycle(basePrice, brand, model, cylinder, mileage, new1, motorcycleType,  gasCapacity);
		}
		return info += "The motorcycle was succesfully created";
	}
	/**This method receives the type of car to add, and request all information.
	 * <b>pre:</b>Company already created.<br> 
	 * 
	 * @param typeCar Integer of the selection of what type of car to add.
	 * 
	 * <b>post:</b>The car information is saved to continue to the process of ad a car.<br>
	 */
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
	/**
	 * This method notify about the car was added without problems.
	 * <b>pre:</b>A car was created.<br> 
	 * 
	 * @param selection integer depend of the type of car that was created.
	 * @return info as String of the notification.
	 * 
	 * <b>post:</b>The new car now is visible on the list.<br>
	 */
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
	/**
	 * This method select the type of vehicle to add between Car o Motorcycle.
	 * <b>pre:</b>The company was created.<br>
	 * 
	 * @return info as String of the notification of process.
	 * 
	 * <b>post:</b>Continues on the process to add a vehicle.<br>
	 */
	public String enterVehicle() {
		System.out.println("What vehicle do you buy?\n1. Car\n2. Motorcycle");
		int choose = sc.nextInt();
		String info = vehicleChosen(choose);
		return info;
	}
	/**
	 * This method deploy a list of the employees with their clients assigned, employees without clients assigned will not be visibles.
	 * <b>pre:</b>A client must be added as minimum.<br>
	 * 
	 * <b>post:</b>A list with the employee and his assigned clients are deployed.<br>
	 */
	public void showClients() {
		String info = "";
		for (int i = 0; i < company.salesMan.length; i++) {
			for (int j = 0; j < company.salesMan[i].clients.length; j++) {
				if(company.salesMan[i].clients[j] != null) {
					System.out.println("Employee name: "+company.salesMan[i].getName()+" #"+(i+1)+"\n");
					System.out.println("--Client-- #"+(j+1)+"\n");
					info = "Name: "+company.salesMan[i].clients[j].getName()+"\nLast name: "+company.salesMan[i].clients[j].getLastName()+"\nID: "+company.salesMan[i].clients[j].getId()+"\n";
					System.out.println(info);
				}
			}
		}
	}
	/**
	 * This method deploy a list of the employees with their clients assigned and their complete information, employees without clients assigned will not be visibles.
	 *<b>pre:</b>A client must be added as minimum.<br>
	 * 
	 *<b>post:</b>A list with the employee and his assigned clients are deployed with complete information.<br>
	 */
	public void showClientsComplete() {
		String info = "";
		for (int i = 0; i < company.salesMan.length; i++) {
			for (int j = 0; j < company.salesMan[i].clients.length; j++) {
				if(company.salesMan[i].clients[j] != null) {
					System.out.println("Employee name: "+company.salesMan[i].getName()+" #"+(i+1)+"\n");	
					System.out.println("--Client-- #"+(j+1)+"\n");
					info = "Name: "+company.salesMan[i].clients[j].getName()+"\nLast name: "+company.salesMan[i].clients[j].getLastName()+"\nID: "+company.salesMan[i].clients[j].getId()+"\n"+"Telephone: "+company.salesMan[i].clients[j].getTel()+"\n"+"Mail: "+company.salesMan[i].clients[j].getMail()+"\n";
					System.out.println(info);
				}
			}
		}
	}
	/**
	 * This method makes the discount of a selected vehicle and then apply it, used on the Main menu.
	 * <b>pre:</b>A vehicle must be created as minimum.<br>
	 * 
	 * <b>post:</b>The discount was applied to selected vehicle.<br>
	 */
	public void applyDiscount() {
		int select = 0; 
		double value = 0;
		double amount = 0;
		double finalValue = 0;
		System.out.println(company.showVehicles(3));
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
	/**
	 * This method show the catalog of vehicles depend of the choose to show
	 *  <b>pre:</b>Select a number between 1 or 3.<br>
	 *  
	 *  <b>post:</b><br>
	 */
	public void showCatalog() {
		int choose = 0;
		while(choose < 1 || choose > 3) {
			System.out.println("What vehicles do you want to see?\n1. New vehicles\n2. Used vehicles\n3. Both kind of vehicles");
			choose = sc.nextInt();
		}
		System.out.println(company.showVehicles(choose));
	}
	/**
	 * This method is the operation of the options to select on Main menu.
	 * <b>pre:</b>Select numbers between that options.<br>
	 * 
	 * @param choice
	 * 
	 * <b>post:</b><br>
	 */
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
		case SHOW_COMPNAY_EMPLOYEES_COMPLETE:
			System.out.println(company.showEmployeesComplete());
			break;
		case SHOW_COMPANY_VEHICLES:
			showCatalog();
			break;
		case SHOW_CLIENTS:
			showClientsComplete();
			break;
		case ENTRY_FAVORITES:
			favoriteOfClient();
			break;
		case SHOW_FAVORITES:
			showFavorites();
			break;
		case APPLY_DICSOUNT:
			applyDiscount();
			break;
		case ORGANIZE_PARKING:
			company.organizeParking();
			selectModelOrganize();
			break;
		case FINAL_PAY:
			operationsWithSpecificClient(2);
			break;
		case EXIT:
			System.out.println("Good bye!");
			break;
		default:
			System.out.println();
			System.out.println("Please select a correct option");
			break;
		}
	}
	/**
	 * This method makes the discount of a selected vehicle and then apply it at the moment to pay.
	 * <b>pre:</b>A vehicle must be created as minimum.<br>
	 * 
	 *@param vehicleNumber
	 *
	 * <b>post:</b>The discount was applied to selected vehicle.<br>
	 */
	public void discount(int vehicleNumber) {
		double value = 0;
		double amount = 0;
		double finalValue = 0;
		System.out.println("How many discount do you want to apply?");
		System.out.println("Enter values between 1 and 99 percent");
		value = sc.nextInt();
		value /= 100;
		amount = company.vehicles.get(vehicleNumber).getTotalPrice() * value;
		finalValue = company.vehicles.get(vehicleNumber).getTotalPrice() - amount;
		company.vehicles.get(vehicleNumber).setTotalPrice(finalValue);
		System.out.println("Discount of "+value*100+"% Was applied to vehicle!\nPlease check on the vehicle list\n");
	}
	/**
	 * This method receives the values to make a discount or continue to the sell of a vehicle.
	 * <b>pre:</b>A vehicle must be created as minimum.<br>
	 * 
	 * @param decision integer of option
	 * @param vehicleNumber position on the vehicles list
	 * 
	 * <b>post:</b>The discount was applied to selected vehicle or the sell was finalized.<br>
	 */
	public void applyDiscount(int decision, int vehicleNumber) {
		switch (decision) {
		case 1:
			discount(vehicleNumber);
			System.out.println("Vehicle sold!");
			break;
		case 2:
			System.out.println("Vehicle sold!");
			break;
		default:
			break;
		}
	}
	/**
	 * This method makes the pay for a vehicle.
	 * <b>pre:</b>A vehicle must be created as minimum.<br>
	 * 
	 * @param vehicleNumber Integer of position on the arrayList
	 * @param sellerNumber Integer of position on sales Man array
	 * @param clientNumber Integer of position of client on clients arrayList
	 * 
	 * <b>post:</b>The paid was finalized and the vehicle now have a new owner.<br>
	 */ 
	public void pay(int vehicleNumber, int sellerNumber, int clientNumber) {
		int docSoat = company.vehicles.get(vehicleNumber).docs.size()-2;
		int docMech = company.vehicles.get(vehicleNumber).docs.size()-1;
		int sells = company.salesMan[sellerNumber].getTotalSales()+1;
		company.salesMan[sellerNumber].setTotalSales(sells);
		int companySells = company.getSales()+1;
		company.setSales(companySells);
		if(LocalDate.now().getYear()!= company.vehicles.get(vehicleNumber).docs.get(docSoat).getYear()) {
			System.out.println("\nThe mount for the SOAT is $"+company.vehicles.get(vehicleNumber).docs.get(docSoat).getPrice()+"\n");
			System.out.println("Your SOAT is out of date, you need to pay a extrapay. This equals to $500.000 extra\n");
			double pay = company.vehicles.get(vehicleNumber).getTotalPrice() + company.vehicles.get(vehicleNumber).docs.get(docSoat).getPrice()+ 500000;
			company.vehicles.get(vehicleNumber).setTotalPrice(pay);
			company.setTotalGain(pay);
		}
		else {
			System.out.println("\nThe mount for the SOAT is $"+company.vehicles.get(vehicleNumber).docs.get(docSoat).getPrice()+"\n");
			double pay = company.vehicles.get(vehicleNumber).getTotalPrice() + 500000;
			company.vehicles.get(vehicleNumber).setTotalPrice(pay);
			company.setTotalGain(pay);
		}
		if(LocalDate.now().getYear()!= company.vehicles.get(vehicleNumber).docs.get(docMech).getYear()) {
			System.out.println("\nThe mount for the mechanical technician is $"+company.vehicles.get(vehicleNumber).docs.get(docSoat).getPrice()+"+\n");
			System.out.println("Your mechanical technician is out of date, you need to pay a extrapay. This equals to $500.000 extra\n");
			double pay = company.vehicles.get(vehicleNumber).getTotalPrice()+company.vehicles.get(vehicleNumber).docs.get(docSoat).getPrice() + 500000;
			company.vehicles.get(vehicleNumber).setTotalPrice(pay);
			company.setTotalGain(pay);
		}
		else {
			System.out.println("\nThe mount for the mechanical technician is $"+company.vehicles.get(vehicleNumber).docs.get(docSoat).getPrice()+"\n");
			double pay = company.vehicles.get(vehicleNumber).getTotalPrice() + 500000;
			company.vehicles.get(vehicleNumber).setTotalPrice(pay);
			company.setTotalGain(pay);
		}
		int decision = 0;
		while(decision<1 || decision>2) {
			System.out.println("\nYou want to do some discount?\n1. Yes\n2. No");
			decision = sc.nextInt();
		}
		applyDiscount(decision, vehicleNumber);
	}
	/**
	 * This shows favorites list per client
	 * <b>pre:</b>A client was created as minimum.<br>
	 * 
	 * <b>post:</b><br>
	 */ 
	public void showFavorites() {
		System.out.println("The company has these sellers with those assigned clients");
		System.out.println(company.showEmployees()+"\n");
		System.out.println("With which seller are the client inscribe?\n");
		int sellerNumber = 0;
		int d = 0;
		for (int i = 0; i < company.salesMan.length; i++) {
			if(company.salesMan[i] != null) {	
				d+=1;
			}
		}
		while(sellerNumber<1 || sellerNumber>d) {
			System.out.println("Choose him with his seller number\n");
			sellerNumber = sc.nextInt();
		}
		sellerNumber-=1;
		if(company.salesMan[sellerNumber].clients[0]!=null) {
			System.out.println("\nWhich of the assigned clients you need?\n");
			int clientNumber = 0;
			int k = 0;
			for (int i = 0; i < company.salesMan[sellerNumber].clients.length; i++) {
				if(company.salesMan[sellerNumber].clients[i] != null) {	
					k+=1;
				}
			}
			while(clientNumber<1 || clientNumber>k) {
				System.out.println("Choose him with his seller number\n");
				clientNumber = sc.nextInt();
			}
			clientNumber-=1;
			System.out.println(company.favoriteVehicles(sellerNumber, clientNumber));
		}
		else
			System.out.println("No clients with the seller yet");
	}
	/**
	 * This method receives the operation to do with a client, between add a vehicle to favorites or do the documentation for a vehicle to sell.
	 * <b>pre:</b>A vehicle and a client must be created as minimum.<br>
	 * 
	 * @param choose Integer of the option selected. 
	 * 
	 * <b>post:</b>Makes the operation that was selected.<br>
	 */
	public void operationsWithSpecificClient(int choose) {
		System.out.println("The company has these sellers with those assigned clients");
		System.out.println(company.showEmployees()+"\n");
		System.out.println("With which seller are the client inscribe?\n");
		int sellerNumber = 0;
		int d = 0;
		for (int i = 0; i < company.salesMan.length; i++) {
			if(company.salesMan[i] != null) {	
				d+=1;
			}
		}
		while(sellerNumber<1 || sellerNumber>d) {
			System.out.println("Choose him with his seller number\n");
			sellerNumber = sc.nextInt();
		}
		sellerNumber-=1;
		if(company.salesMan[sellerNumber].clients[0]!=null) {
			System.out.println("Which of the assigned clients you need?");
			int clientNumber = 0;
			int k = 0;
			for (int i = 0; i < company.salesMan[sellerNumber].clients.length; i++) {
				if(company.salesMan[sellerNumber].clients[i] != null) {	
					k+=1;
				}
			}
			while(clientNumber<1 || clientNumber>k) {
				System.out.println("Choose him with his seller number");
				clientNumber = sc.nextInt();
			}
			clientNumber-=1;
			System.out.println();
			System.out.println("Vehicle to use\n");
			System.out.println(company.showVehicles(3)+"\n");
			int vehicleNumber = 0;
			while(vehicleNumber < 1 || vehicleNumber>company.vehicles.size()) {
				System.out.println("Select his number of the list\n");
				vehicleNumber = sc.nextInt();
			}
			vehicleNumber-=1;
			sc.nextLine();
			switch (choose) {

			case CLIENT_FAVORITES:
				company.salesMan[sellerNumber].clients[clientNumber].tryDrive.add(company.vehicles.get(choose));
				System.out.println("Vehicle added to favorites to the client: " + company.salesMan[sellerNumber].clients[clientNumber].getName());
				break;

			case 2:
				if(company.vehicles.get(vehicleNumber).getSold()==true) {
					System.out.println("This vehicle is already sold");
				}
				else {
					company.vehicles.get(vehicleNumber).setSold(true);
					company.vehicles.get(vehicleNumber).setOwner(company.salesMan[sellerNumber].clients[clientNumber].getName());
					if(company.vehicles.get(vehicleNumber).getNew1().equalsIgnoreCase("Yes")) {
						System.out.println("Type a plaque for the vehicle: ");
						String plaque = sc.nextLine();
						company.vehicles.get(vehicleNumber).setPlaque(plaque);
						System.out.println("Now, let's do the documentation");
						int year = LocalDate.now().getYear();
						System.out.println("Enter the mount to cover accidents");
						double accidents = sc.nextDouble();
						System.out.println("Enter the gas levels");
						double gas = sc.nextDouble();
						System.out.println("Enter the price of documentation");
						double price = sc.nextDouble();
						company.addDocumentation(vehicleNumber, year, accidents, price, gas);
						pay(vehicleNumber, sellerNumber, clientNumber);
					}
					else if(company.vehicles.get(vehicleNumber).getNew1().equalsIgnoreCase("No")){
						System.out.println("Now, let's do the documentation");
						int year = LocalDate.now().getYear();
						System.out.println("Enter the mount to cover accidents");
						double accidents = sc.nextDouble();
						System.out.println("Enter the gas levels");
						double gas = sc.nextDouble();
						System.out.println("Enter the price of documentation");
						double price = sc.nextDouble();
						company.addDocumentation(vehicleNumber, year, accidents, price, gas);
						pay(vehicleNumber, sellerNumber, clientNumber);
					}
				}
				break;
			default: System.out.println("Enter a valid number");
			break;
			}
		}
	}
	/**
	 * This method receives the model year to know on the parking lot.
	 * <b>pre:</b>A vehicle of 2014 or less model must be created as minimum.<br>
	 * <b>pre:</b>Must be select an option between 1 to 5.<br>
	 * 
	 * <b>post:</b>Will continue to know the information of that model on the parking lot.<br>
	 */
	public void selectModelOrganize() {
		int select = 0; 
		boolean cont = false;
		System.out.println("\nTo show the organization of parking lot please select the year");
		System.out.println("\n1. 2014 \n2. 2013 \n3. 2012\n4. 2011\n5. Below 2011\n");
		select = sc.nextInt();
		while(!cont) {
			switch (select) {
			case 1:
				select = 2014;
				cont = true;
				break;
			case 2:
				select = 2013;
				cont = true;
				break;
			case 3:
				select = 2012;
				cont = true;
				break;
			case 4:
				select = 2011;
				cont = true;
				break;
			case 5:
				select = 2010;
				cont = true;
				break;
			default:
				System.out.println("***please select a correct option***");
				break;
			}
		}
		System.out.println(company.getInfoParking(select));
	}
	/**
	 * This method deploy the main program menu.
	 * <b>pre:</b>Company and employees must be initialized.<br>
	 * <b>pre:</b>Select a valid option.<br>
	 * 
	 * <b>post:</b><br>
	 */
	public void showMenu() {
		System.out.println("****"+company.getName()+"****"+"\n - NIT: "+company.getNit()+"\n - Total gain: "+company.getTotalGain()+"\n - Sales: "+company.getSales()+"\n");
		System.out.println("********MENU********");
		System.out.println();
		System.out.println("1. Add vehicle\n2. Add clients for each employee\n3. Show positions free per employee\n4. Deploy employees information \n5. Show company vehicles \n6. Show clients per employee \n7. Entry favorites per client\n8. Show favorites per clients \n9. Apply discount to vehicle\n10. Organize parking loat\n11. Make the pay for a vehicle\n12. Exit\n");
	}
	/**
	 * This method start the program, initialize the employees, company and some vehicles too.
	 * <b>pre:</b><br>
	 * 
	 * <b>post:</b><br>
	 */
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