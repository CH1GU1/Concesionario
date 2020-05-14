package model;
import java.util.*;
public interface Electricserv {
	/**
	 * This method is Overrider by electrics vehicles that calculate theirs own gas performance
	 * <b><pre>:<br><br>
	 * 
	 * @param chargerType String between FAST or NORMAL
	 * @param batLife double duration of battery 
	 * @param cylinder double cylinder of electric vehicle
	 * @return batConsuption double of battery consumption  
	 * 
	 * <b><post>:<br><br>
	 */
	double calculateBatConsuption(String chargerType, double batLife, double cylinder);

}