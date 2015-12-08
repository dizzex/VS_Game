package com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.TimeConstants;

public enum TimeConstants {
	
	ONE_SECOND(1000),
	HALF_OF_A_SECOND(500),
	TWO_SECONDS(2000),
	THREE_SECONDS(3000),
	TEN_SECONDS(10000);
	
	private int milliseconds;
	
	private TimeConstants(int milliseconds) {
		this.milliseconds = milliseconds;
	}
	
	public int getTime(){
		return this.milliseconds; 
	}

}
