package model;
public class Employee {

	private String name;
	private String lastName;
	private int id;
	private int totalSales;
	public final static int MAX_CLIENTS = 5;
	public Client [] clients;

	/**
	 * This method is the constructor of employee
	 * <b><pre>:<br><br>
	 * 
	 * @param name String is the name of employee
	 * @param lastName String if the last name of employee
	 * @param id integer is the id of employee
	 * @param totalSales integer is the employee number sales
	 * 
	 * <b><post>:<br><br>
	 */
	public Employee(String name, String lastName, int id, int totalSales) {
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.totalSales = totalSales;
		clients = new Client[MAX_CLIENTS];
	}
	/**
	 * This method sets the name of employee
	 * <b><pre>:<br><br>
	 * 
	 * @param name
	 * 
	 * <b>post:</b><br>
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This method gets the name of employee
	 * <b><pre>:<br><br>
	 * 
	 * @return name
	 * 
	 * <b>post:</b><br>
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method sets the last name of employee
	 * <b><pre>:<br><br>
	 * 
	 * @param lastName
	 * 
	 * <b>post:</b><br>
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * This method gets the last name of employee
	 * <b><pre>:<br><br>
	 * 
	 * @return lastName
	 * 
	 * <b>post:</b><br>
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * This method sets the id of employee
	 * <b><pre>:<br><br>
	 * 
	 * @param id
	 * 
	 * <b>post:</b><br>
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * This method gets the id of employee
	 * <b><pre>:<br><br>
	 * 
	 * @return id
	 * 
	 * <b>post:</b><br>
	 */
	public int getId() {
		return id;
	}
	/**
	 * This method sets the employee sales number 
	 * <b><pre>:<br><br>
	 * 
	 * @param totalSales
	 * 
	 * <b>post:</b><br>
	 */
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	/**
	 * This method gets the employee sales number 
	 * <b><pre>:<br><br>
	 * 
	 * @return totalSales
	 * 
	 * <b>post:</b><br>
	 */
	public int getTotalSales() {
		return totalSales;
	}
}