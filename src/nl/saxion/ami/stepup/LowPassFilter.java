package nl.saxion.ami.stepup;

public class LowPassFilter {
	private float previousResult;
	private float alpha;
	private int samplingFrequency;
	private int cutoffFrequency;
	
	public LowPassFilter(int samplingFrequency, int cutoffFrequency) {
		this.samplingFrequency = samplingFrequency;
		this.cutoffFrequency = cutoffFrequency;
		updateAlpha();
	}
	
	public float filter(Float input) {		
		float result = previousResult + alpha * (input - previousResult);
		previousResult = result;
		return result;
	}
	
	private void updateAlpha() {
		//TODO: What value should be stored in alpha?
		alpha = 0.7f;
	}
}
