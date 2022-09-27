package org.Zurich_Practice;

import org.testng.annotations.Test;

import com.Zurich.Genericutility.WebDriverUtility;

public class MavenpracticeTest {
	
	@Test(groups="Sanity")
	public void step1() {
		String browser = System.getProperty("b");
		     String url = System.getProperty("u");
		     
		     System.out.println("browser name is==>" +browser);
		     System.out.println("url name is ===>" + url);
		     
		     WebDriverUtility web=new WebDriverUtility();
		     web.openBrowserwithApplication(browser, 10, url);
		     System.out.println("method passed");
		     
		     //maven
	}
}
