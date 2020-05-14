package model;
import java.util.*;
public interface Gasservices {
/**
 * This interface method is Overrider by gas vehicles that calculate theirs own gas performance
 * <b><pre>:<br><br>
 * 
 * @param tankCapacity double of vehicle tank capacity
 * @param cylinder double of vehicle cylinder
 * @return gasPerformance already calculated
 * 
 * <b><post>:<br><br>
 */
	double calculateGasPerformance(double tankCapacity, double cylinder);
}