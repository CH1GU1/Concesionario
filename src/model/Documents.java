package model;
import java.util.*;
public abstract class Documents {

	private double price;
	private int year;
	private int[][] matrix;
	private final static int SIZE = 4;

	/**
	 * 
	 * @param price
	 * @param year
	 * @param matrix
	 */
	public Documents(double price, int year) {
		this.matrix = makeMatrix();
		this.price = price;
		this.year = year;	
	}
	public int[][] getmatrix() {
		return matrix;
	}	
	public int[][] makeMatrix() {
		matrix = new int[SIZE][SIZE];
		Random ran = new Random();
		int value = ran.nextInt(9);
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				matrix[i][j] = ran.nextInt(9);
			}
		}
		return matrix;
	}
	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	/**
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	public int getYear() {
		return year;
	}
	/**
	 * 
	 * @param code
	 */
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	public abstract String goByMatrix(int[][] matrix);

	public String descriptionSoat() {
		String info = "\nDocument year: "+year;
		return info;
	}
	public String descriptionTech() {
		String info = "\nDocument year: "+year;
		return info;
	}
	public abstract double getAccidents();

	public abstract double getGas();
}