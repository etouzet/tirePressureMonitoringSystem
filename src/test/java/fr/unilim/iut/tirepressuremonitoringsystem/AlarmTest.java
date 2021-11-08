package fr.unilim.iut.tirepressuremonitoringsystem;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {

	@Test
	public void alarm_on_when_value_too_low() {
		Sensor sensor = probe(16.0);

		Alarm alarm = new Alarm(sensor, new SafetyRange(17,21));

		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}

	@Test
	public void alarm_on_when_value_too_high() {
		Sensor sensor = probe(22.0);

		Alarm alarm = new Alarm(sensor, new SafetyRange(17,21));

		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}

	@Test
	public void alarm_off_when_value_in_safety_range() {
		Sensor sensor = probe(18.0);

		Alarm alarm = new Alarm(sensor, new SafetyRange(17,21));

		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}

	@Test
	public void alarm_stay_on_when_alarm_activate_at_once() {
		Sensor sensor = probe(22.0, 18.0);

		Alarm alarm = new Alarm(sensor, new SafetyRange(17,21));

		alarm.check();
		assertTrue(alarm.isAlarmOn());

		// sensor = probe(18.0);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}

	private Sensor probe(double value, double... values) {
		Sensor sensor = Mockito.mock(PressureSensor.class);
		when(sensor.probeValue()).thenReturn(value);
		return sensor;
	}

}
