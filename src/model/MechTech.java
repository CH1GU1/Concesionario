package model;
public class MechTech extends Documents {

	private double gas;

	/**
	 * 
	 * @param price
	 * @param year
	 * @param code
	 * @param gas
	 */
	public MechTech(double price, int year, double gas) {
		super(price, year);
		this.gas = gas;
	}

	/**
	 * 
	 * @param gas
	 */
	public void setGas(double gas) {
		this.gas = gas;
	}
	@Override
	public double getGas() {
		return gas;
	}

	@Override
	public String goByMatrix(int[][] matrix) {	
		String MechCode = "";
		// print first row 
		for (int j = 0; j < super.getmatrix().length - 1; j++) { 
			MechCode += matrix[0][j];
		} 
		// Print diagonal 
		int k = 1;
		for (int i = 0; i < super.getmatrix().length - 1; i++) { 
			for (int j = 0; j < super.getmatrix().length; j++) { 
				if (j == super.getmatrix().length - k) { 
					MechCode += matrix[i][j]; 
				} 
			} 
			k++; 
		} 
		// Print last row 
		int l = super.getmatrix().length - 1; 
		for (int j = 0; j < super.getmatrix().length; j++) { 
			MechCode += matrix[l][j];
		}
		return MechCode;
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
	public String descriptionTech(){
		String info = "";
		info += super.descriptionTech()+"\nGas level: "+gas+"\nMech code: "+goByMatrix(super.getmatrix());
		
		return info;
	}
	@Override
	public double getAccidents() {
		return 0;
	}

}