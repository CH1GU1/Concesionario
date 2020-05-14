package model;
import java.util.*;
public class Soat extends Documents {

	private double accidents;
	

	/**
	 * This method is the constructor of Soat
	 * <b><pre>:<br><br>
	 * 
	 * @param price double of Soat price
	 * @param year int of soat year
	 * @param accidents double of accidents cover mount
	 * 
	 * <b><post>:<br><br>
	 */
	public Soat(double price, int year, double accidents) {
		super(price, year);
		this.accidents = accidents;	
	}
	/**
	 * This method sets the cover mount of accidents
	 *  <b><pre>:<br><br>
	 *  
	 * @param accidents double of accidents cover mount
	 * 
	 * <b><post>:<br><br>
	 */
	public void setAccidents(double accidents) {
		this.accidents = accidents;
	}
	/**
	 * This method gets the accidents cover mount
	 * <b><pre>:<br>accidents is not null<br>
	 * 
	 * @return accidents double of accidents cover mount
	 * 
	 * <b><post>:<br><br>
	 */
	@Override
	public double getAccidents() {
		return accidents;
	}
	/**
	 * This method decode the matrix on L and then return that code in a String
	 * <b><pre>:<br>matrix is not null<br>
	 * 
	 * @param matrix is the matrix documentation 
	 * @return soatCode as String of the coding on L of documents matrix
	 * 
	 * <b><post>:<br>Coding in L and returned<br>
	 */
	@Override
	public String goByMatrix(int[][] matrix) {
		String soatCode = "";
		for(int i = 0; i < super.getmatrix().length; i++) {
			soatCode += matrix[i][0];
			}
		for (int i = 1; i < super.getmatrix().length; i++) {
			soatCode += matrix[super.getmatrix().length-1][i];
		}
		return soatCode;
	}
	/**
	 * This method returns the description of soat documentation 
	 * <b><pre>:<br>constructor is not null<br>
	 * 
	 * @return info as String with the information
	 * 
	 * <b><post>:<br><br>
	 */
	@Override
	public String description(){
		String info = "";
		info += super.description()+"\nAccidents cover price: "+accidents+"\nSoat code: "+goByMatrix(super.getmatrix());
				return info;
	}
	/**
	 * This method is to complete heritage of Documents class
	 * <b><pre>:<br><br>
	 * 
	 * @return double
	 * 
	 * <b><post>:<br><br>
	 */
	@Override
	public double getGas() {
		return 0;
	}
}