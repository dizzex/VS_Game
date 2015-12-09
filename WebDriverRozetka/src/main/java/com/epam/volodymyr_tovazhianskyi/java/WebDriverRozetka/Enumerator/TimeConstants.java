package com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.Enumerator;

public enum TimeConstants {
	
	HALF_A_SECOND(500),
	ONE_SECOND(1000),
	TWO_SECONDS(2000),
	TEN_SECONDS(10000);
	
	private final int milliseconds;
	
	TimeConstants(int milliseconds){
		this.milliseconds = milliseconds; 
	}
	
	public int getMilliseconds(){
		return this.milliseconds;
	}
	

}
