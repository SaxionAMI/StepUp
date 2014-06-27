package nl.saxion.ami.stepup;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity implements SensorEventListener {
	private SensorManager mSensorManager;
	private Sensor mSensor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		Log.v(getClass().toString(), "onSensorChanged");
	}

	@Override
	public final void onAccuracyChanged(Sensor sensor, int accuracy) {
		Log.v(getClass().toString(), "onAccuracyChanged");
	}

	@Override
	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(this, mSensor,
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onPause() {
		super.onPause();
		mSensorManager.unregisterListener(this);
	}
	
	/**
	 * Returns the length of a 3d vector.
	 * @param event
	 * @return
	 */
	public static float norm(SensorEvent event) {
		assert event.values.length == 3;
		
		float result = event.values[0] * event.values[0] +
				event.values[1] * event.values[1] +
				event.values[2] * event.values[2];
		
		return FloatMath.sqrt(result);
	}

}
