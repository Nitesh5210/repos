package org.Zurich_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Zurich.Genericutility.BaseClass;
import com.Zurich.Genericutility.JavaUtility;
import com.Zurich.Genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotPractice extends BaseClass {

	
	@Test
	public void Screenshot() {
		WebDriverManager.chromedriver().setup();
		WebDriverUtility web=new WebDriverUtility();
		web.navigateApplication(driver, "http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		JavaUtility java=new JavaUtility();
		java.currentTime();
		web.takeScreenShot(driver, java, "ScreenshotPractice");
		Assert.fail();
	}
	
	
	
}
