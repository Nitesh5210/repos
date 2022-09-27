package com.Zurich_automationTC;

import java.util.Map;

import org.Zurich.LifeInsurenceObjectRepositery.AddClientPage;
import org.Zurich.LifeInsurenceObjectRepositery.ClientStatusPage;
import org.Zurich.LifeInsurenceObjectRepositery.CommanPage;
import org.Zurich.LifeInsurenceObjectRepositery.LoginPage;
import org.openqa.selenium.WebDriver;

import com.Zurich.Genericutility.ExcelUtility;
import com.Zurich.Genericutility.FileUtility;
import com.Zurich.Genericutility.IConstantUtility;
import com.Zurich.Genericutility.WebDriverUtility;

public class AutomateSearchBarPOM {

	public static void main(String[] args) {
		
		ExcelUtility excel=new ExcelUtility();
		FileUtility file= new FileUtility();
		WebDriverUtility web=new WebDriverUtility();
		
		file.intializePropertyFile(IConstantUtility.Property_File_Path);
		excel.openExcel(IConstantUtility.Excel_Path);
		
		String browser = file.getDataFromProperyfile("browser");
		String url = file.getDataFromProperyfile("url");
		WebDriver driver = web.openBrowserwithApplication(browser, 10,url);

		String username = file.getDataFromProperyfile("username");
		String password = file.getDataFromProperyfile("password");
		
		LoginPage login=new LoginPage(driver);
		CommanPage comman=new CommanPage(driver);
		AddClientPage client=new AddClientPage(driver);
		ClientStatusPage status=new ClientStatusPage(driver);
		
		login.loginAction(username, password);
		comman.Client();
		
		
		
		
		Map<String, String> map = excel.getDataFromExcelbyMap("ClientDetails");
		client.addClientfromexcel(map);
		
		String clientid = client.checkclientId();
		System.out.println(clientid);
		
		
		Map<String, String>map1=excel.getDataFromExcelbyMap("NomineeDetail");
	    client.addNomineeFromexcel(map1);
	    
	    
		comman.homePage();
		comman.searchBox(excel.getDataFromExcel("ClientDetails", "Name", "Client Details"));
		comman.clickclientstatus();
		
		status.editClient();
		comman.searchBox(excel.getDataFromExcel("ClientDetails", "Name", "Client Details"));
		status.submitClient();
		

		if (client.checkclientId()== clientid) {
			System.out.println("TC----is fail");

		} else {
			System.out.println("TC--is pass");
		}
		excel.closeExcelworkbook();
		web.closeBrowser(driver);
		
		
		
	}

}
