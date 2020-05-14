package model;
public class MechTech extends Documents {

	private double gas;

	/**
	 * This is the constructor of mechanic technical documentation
	 * <b><pre>:<br><br>
	 * 
	 * @param price double mech price
	 * @param year int mech year
	 * @param gas double of gases level on mech
	 * 
	 * <b><post>:<br><br>
	 */
	public MechTech(double price, int year, double gas) {
		super(price, year);
		this.gas = gas;
	}
	/**
	 * this method sets the gas level
	 *  <b><pre>:<br><br>
	 *  
	 * @param gas double of gases level
	 * 
	 * <b><post>:<br><br>
	 */
	public void setGas(double gas) {
		this.gas = gas;
	}
	/**
	 * This method gets the gases level
	 * <b><pre>:<br>Gas level is not null<br>
	 * 
	 * @param gas double of gases level
	 * 
	 * <b><post>:<br><br>
	 */
	@Override
	public double getGas() {
		return gas;
	}
	/**
	 * This method decode the matrix on Z and then return that code in a String
	 * <b><pre>:<br>matrix is not null<br>
	 * 
	 * @param matrix is the matrix documentation 
	 * @return MechCode as String of the coding on Z of documents matrix
	 * 
	 * <b><post>:<br>Coding in Z and returned<br>
	 */
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
	/**
	 * This method returns the description of mechanical technician documentation 
	 * <b><pre>:<br>constructor is not null<br>
	 * 
	 * @return info as String with the information
	 * 
	 * <b><post>:<br><br>
	 */
	@Override
	public String description(){
		String info = "";
		info += super.description()+"\nGas level: "+gas+"\nMech code: "+goByMatrix(super.getmatrix());

		return info;
	}
	/**
	 * This method is to complete heritage of Documents class
	 * <b><pre>:<br><br>
	 * 
	 * @return integer
	 * 
	 * <b><post>:<br><br>
	 */
	@Override
	public double getAccidents() {
		return 0;
	}
}