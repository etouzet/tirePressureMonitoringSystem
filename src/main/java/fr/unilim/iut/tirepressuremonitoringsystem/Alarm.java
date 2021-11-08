package fr.unilim.iut.tirepressuremonitoringsystem;

public class Alarm
{
    private final double lowPressureThreshold = 17;
    private final double highPressureThreshold = 21;

    Sensor sensor = new Sensor();

    boolean alarmOn = false;
    
    public Alarm() {
    	
    }
    
    public Alarm(Sensor sensor) {
    	this.sensor=sensor;
    }

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < lowPressureThreshold || highPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
