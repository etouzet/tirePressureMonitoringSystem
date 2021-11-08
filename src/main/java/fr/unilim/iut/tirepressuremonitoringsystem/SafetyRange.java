package fr.unilim.iut.tirepressuremonitoringsystem;

public class SafetyRange {

	private final double lowThreshold;
	private final double highThreshold;

	public SafetyRange(double lowThreshold, double highThreshold) {
		this.lowThreshold = lowThreshold;
		this.highThreshold = highThreshold;
	}

	boolean isValueOutOfRange(double value) {
		return value < lowThreshold || highThreshold < value;
	}

}
