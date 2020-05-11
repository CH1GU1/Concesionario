package model;
import java.util.*;
public class Soat extends Documents {

	private double accidents;
	

	/**
	 * 
	 * @param price
	 * @param year
	 * @param code
	 * @param accidents
	 */
	public Soat(double price, int year, double accidents) {
		super(price, year);
		this.accidents = accidents;	
	}

	/**
	 * 
	 * @param accidents
	 */
	public void setAccidents(double accidents) {
		this.accidents = accidents;
	}
	@Override
	public double getAccidents() {
		return accidents;
	}
	

	@Override
	public String goByMatrix(int[][] matrix) {
		String soatCode = "";
		for(int i = 0; i < 4; i++) {
			soatCode += matrix[i][0];
			}
		for (int i = 1; i < 4; i++) {
			soatCode += matrix[3][i];
		}
		return soatCode;
	}
	@Override
	public String descriptionSoat(){
		String info = "";
		info += super.descriptionSoat()+"\nAccidents cover price: "+accidents+"\nSoat code: "+goByMatrix(super.getmatrix());
				return info;
	}
	public String testMatrix(int[][] matrix) {
		String test = "";
		for(int i = 0; i < super.getmatrix().length; i++) {
			for (int j = 0; j < super.getmatrix().length; j++) {
				test += matrix[i][j];			
			}
			
		}return test;
	}
	@Override
	public double getGas() {
		return 0;
	}
}