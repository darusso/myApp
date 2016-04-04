package russo.it.newapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;


public class Accelera extends AppCompatActivity implements SensorEventListener
{
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelera);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : sensorList)
        {
            Log.d("Sensor", sensor.getName());
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        synchronized (this)

        {
            switch (event.sensor.getType())
            {
                case Sensor.TYPE_ACCELEROMETER:
                    for (int i = 0; i < 3; i++)
                    {
                        Log.d("Accelera", String.valueOf(event.values[i]));
                    }
            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }
}
