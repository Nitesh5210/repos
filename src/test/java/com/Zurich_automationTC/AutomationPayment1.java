package com.Zurich_automationTC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Zurich.Genericutility.ExcelUtility;
import com.Zurich.Genericutility.FileUtility;
import com.Zurich.Genericutility.IConstantUtility;
import com.Zurich.Genericutility.WebDriverUtility;

public class AutomationPayment1 {

	public static void main(String[] args) {
		
		WebDriverUtility wb=new WebDriverUtility();
		ExcelUtility ex=new ExcelUtility();
		FileUtility fu=new FileUtility();
		
		fu.intializePropertyFile(IConstantUtility.Property_File_Path);
		String browser = fu.getDataFromProperyfile("browser");
		
		String url = fu.getDataFromProperyfile("url");
		WebDriver driver = wb.openBrowserwithApplication(browser, 10, url);
		
		String user = fu.getDataFromProperyfile("username");
		String pass = fu.getDataFromProperyfile("password");
		
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
		
		
	}

}
