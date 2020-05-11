package model;
public class Employee {

	private String name;
	private String lastName;
	private int id;
	private int totalSales;
	public final static int MAX_CLIENTS = 5;



	public Client [] clients;

	/**
	 * 
	 * @param name
	 * @param lastName
	 * @param id
	 * @param totalSales
	 */
	public Employee(String name, String lastName, int id, int totalSales) {
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.totalSales = totalSales;
		clients = new Client[MAX_CLIENTS];

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
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param totalSales
	 */
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	public int getTotalSales() {
		return totalSales;
	}
//	public void addClients() {
//		String name = "";
//		String lastName = "";
//		int id = 0;
//		int tel = 0;
//		String mail = "";
//		for(int i = 0; i < clients.length; i++) {
//			
//
//		}
//
//
//	}
	

}