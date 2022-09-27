package com.Zurich.Genericutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * this method is use to generate the random number
	 * @author Nitesh ambastha
	 * @param limit 
	 * @return
	 */
	public int getRandomNumber(int limit ) {
		return new Random().nextInt(limit);
	}
	
	/**
	 * this method is use to convert string into any datatype based on strategy
	 * @author Nitesh ambastha
	 */
	
	public Object convertStringIntoAnyDataType(String data, DataType strategy) {
		Object obj = null;
		if (strategy.toString().equalsIgnoreCase("long")) 
			obj=Long.parseLong(data);
		
		else if(strategy.toString().equalsIgnoreCase("int")) 
			obj=Integer.parseInt(data);
		
		else if(strategy.toString().equalsIgnoreCase("double"))
			obj=Double.parseDouble(data);
		
		return obj;
		
	}
	public String currentTime() {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualDate = sdf.format(date);
		return actualDate;
	}
}
