package model;
import java.util.*;
public abstract class Documents {

	private double price;
	private int year;
	private int[][] matrix;
	private final static int SIZE = 5;

	/**
	 * This method is the constructor of documents 
	 * <b><pre>:<br><br>
	 * 
	 * @param price double documents price
	 * @param year int documents year
	 * @param matrix int[][] is the general random matrix for documentations
	 * 
	 * <b><post>:<br><br>
	 */
	public Documents(double price, int year) {
		this.matrix = makeMatrix();
		this.price = price;
		this.year = year;	
	}
	/**
	 * This method return the matrix when done
	 * <b><pre>:<br>Matrix must be initialize to access it<br>
	 * 
	 * @return matrix to make the codes of documentations
	 * 
	 * <b><post>:<br><br>
	 */
	public int[][] getmatrix() {
		return matrix;
	}
	/**
	 * This method make a random matrix of integers
	 * <b><pre>:<br><br>
	 * 
	 * @return matrix of integers ready to coding
	 * 
	 * <b><post>:<br>Matrix is randomly and ready to use it<br>
	 */
	public int[][] makeMatrix() {
		matrix = new int[SIZE][SIZE];
		Random ran = new Random(99);
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				matrix[i][j] = ran.nextInt(99);
			}
		}
		return matrix;
	}
	/**
	 * This method sets the price of documentation
	 * <b><pre>:<br><br>
	 * 
	 * @param price double of documents price
	 * 
	 * <b><post>:<br><br>
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * This method gets the documentation price
	 * <b><pre>:<br>price is not null<br>
	 * 
	 * @return price double of documentation price
	 * 
	 *<b><post>:<br><br>
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * This method sets the documentation year
	 * <b><pre>:<br><br>
	 * 
	 * @param year integer of documentation year
	 * 
	 * <b><post>:<br><br>
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * This method gets the documentation year
	 * <b><pre>:<br>year is not null<br>
	 * 
	 * @return year integer of documentation year
	 * 
	 * <b><post>:<br><br>
	 */
	public int getYear() {
		return year;
	}
	/**
	 * This method sets the document matrix
	 * <b><pre>:<br><br>
	 * 
	 * @param matrix is the matrix to coding
	 * 
	 * <b><post>:<br><br>
	 */
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	/**
	 * This is an abstract method that coding the matrix in two different ways depend if is soat or tech
	 * <b><pre>:<br>Matrix is already created<br>
	 * 
	 * @param matrix integer matrix to coding
	 * @return info String with the coding requested
	 * 
	 * <b><post>:<br>Coding will be assigned to a vehicle<br>
	 * <b><post>:<br>Coding for soat will be on L<br>
	 * <b><post>:<br>Coding for mech will be on Z<br>
	 */
	public abstract String goByMatrix(int[][] matrix);
	/**
	 * This method shows on a String the documents information
	 * @return info String with all documents information (soat and mechTech)
	 */
	public String description() {
		String info = "\nDocument year: "+year;
		return info;
	}
	/**
	 * This is an abstract method that returns the accidents mount price
	 * <b><pre>:<br>Mechanic Technical documentation is ready<br>
	 * 
	 * @return integer of accidents mount price
	 * 
	 * <b><post>:<br><br>
	 */
	public abstract double getAccidents();
	/**
	 * This is an abstract method that returns the level of gases
	 * <b><pre>:<br>Mechanic Technical documentation is ready<br>
	 * 
	 * @return gas double of level of gases
	 * 
	 * <b><post>:<br><br>
	 */
	public abstract double getGas();
}