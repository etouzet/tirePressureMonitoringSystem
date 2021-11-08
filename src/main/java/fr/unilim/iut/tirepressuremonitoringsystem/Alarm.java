package fr.unilim.iut.tirepressuremonitoringsystem;

public class Alarm {
	Sensor sensor = new PressureSensor();
	SafetyRange safetyRange;

	boolean alarmOn = false;
	
	public Alarm(Sensor sensor, SafetyRange safetyRange) {
		this.sensor = sensor;
		this.safetyRange = safetyRange;
	}
	
	public Alarm() {
		this(new PressureSensor(), new SafetyRange(17,21));
	}
	

	public void check() {
		double psiPressureValue = probePressure();

		if (safetyRange.isValueOutOfRange(psiPressureValue)) {
			activeAlarm();
		}
	}

	private double probePressure() {
		return sensor.probeValue();
	}

	private void activeAlarm() {
		alarmOn = true;
	}

	public boolean isAlarmOn() {
		return alarmOn;
	}

	boolean isValueOutOfSafetyRange(SafetyRange safetyRange, double psiPressureValue) {
		return safetyRange.isValueOutOfRange(psiPressureValue);
	}
}
