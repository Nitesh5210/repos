package com.Zurich_automationTC;


	
	import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
	public class LifeinsuranceManagement 
	{
		@SuppressWarnings("unused")
		public static void main(String[] args) throws IOException {
			FileInputStream fis = new FileInputStream("./src/test/resources/Testdata.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet("Lifeinsurancemanagement-1");
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			String url = sheet.getRow(0).getCell(1).getStringCellValue();
			driver.get(url);
			String strurl = driver.getCurrentUrl();
			if (url.equals(strurl)) {
				System.out.println("the login page is being displayed");
			} else {
				System.out.println("the login page is  not being displayed");
			}
			int username = (int) sheet.getRow(1).getCell(1).getNumericCellValue();
			WebElement ele = driver.findElement(By.name("username"));
			if (ele.isDisplayed()) {
				System.out.println("element is being displayed");
				ele.sendKeys(username + "");
			}
			int password = (int) sheet.getRow(2).getCell(1).getNumericCellValue();
			WebElement ele1 = driver.findElement(By.name("password"));
			if (ele1.isDisplayed()) {
				System.out.println("element is being displayed");
				ele1.sendKeys(password + "");
			}
			driver.findElement(By.xpath("//button[text()=\"login\"]")).click();
			String url1 = sheet.getRow(3).getCell(1).getStringCellValue();
			String strurl1 = driver.getCurrentUrl();
			if (url1.equals(strurl1)) {
				System.out.println("the home page is being displayed");
			} else {
				System.out.println("the home page is  not being displayed");
			}
			driver.findElement(By.xpath("(//a[text()='CLIENTS'])")).click();
			driver.findElement(By.xpath("(//a[text()='Add Client'])")).click();
			List<WebElement> user1 = driver.findElements(By.name("client_id"));
			if (user1.size() > 0) {
				System.out.println("Text:" + "is present");
			} else {
				System.out.println("Text is not present");
				driver.close();
			}
			double clientpassword = (double) sheet.getRow(4).getCell(1).getNumericCellValue();
			driver.findElement(By.name("client_password")).sendKeys(clientpassword + "");
			String name = sheet.getRow(5).getCell(1).getStringCellValue();
			driver.findElement(By.name("name")).sendKeys(name);
			String image = sheet.getRow(6).getCell(1).getStringCellValue();
			driver.findElement(By.xpath("//input[@name='fileToUpload']")).sendKeys(image);
			String sex = sheet.getRow(7).getCell(1).getStringCellValue();
			driver.findElement(By.name("sex")).sendKeys(sex);
			String birthdate = sheet.getRow(8).getCell(1).toString();
			driver.findElement(By.name("birth_date")).sendKeys(birthdate + "");
			String maritalstatus = sheet.getRow(9).getCell(1).getStringCellValue();
			driver.findElement(By.name("maritial_status")).sendKeys(maritalstatus);
			String nid = sheet.getRow(10).getCell(1).getStringCellValue();
			driver.findElement(By.name("nid")).sendKeys(nid);
			DataFormatter df = new DataFormatter();
			String phonenumber = df.formatCellValue(sheet.getRow(11).getCell(1));
			driver.findElement(By.name("phone")).sendKeys(phonenumber + "");
			String address = sheet.getRow(12).getCell(1).getStringCellValue();
			driver.findElement(By.name("address")).sendKeys(address);
			int policy_id = (int) sheet.getRow(13).getCell(1).getNumericCellValue();
			driver.findElement(By.name("policy_id")).sendKeys(policy_id + "");
			List<WebElement> user2 = driver.findElements(By.name("agent_id"));
			if (user2.size() > 0) {
				System.out.println("Text:" + "agent_id is present");
			} else {
				System.out.println("agent id  is not present");
				driver.close();
			}
			List<WebElement> user3 = driver.findElements(By.name("nominee_id"));
			if (user3.size() > 0) {
				System.out.println("Text:" + " nominee id is present");
			} else {
				System.out.println("nominee id   is not present");
				driver.close();
			}
			String nominee_name = sheet.getRow(14).getCell(1).getStringCellValue();
			driver.findElement(By.name("nominee_name")).sendKeys(nominee_name + "");
			String nominee_sex = sheet.getRow(15).getCell(1).getStringCellValue();
			driver.findElement(By.name("nominee_sex")).sendKeys(nominee_sex);
			String birthdate1 = sheet.getRow(16).getCell(1).toString();
			driver.findElement(By.name("nominee_birth_date")).sendKeys(birthdate1);
			String NID1 = sheet.getRow(17).getCell(1).getStringCellValue();
			driver.findElement(By.name("nominee_nid")).sendKeys(NID1);
			String RELATIONSHIP = sheet.getRow(18).getCell(1).getStringCellValue();
			driver.findElement(By.name("nominee_relationship")).sendKeys(RELATIONSHIP);
			String priority = sheet.getRow(20).getCell(1).getStringCellValue();
			driver.findElement(By.name("priority")).sendKeys(priority);
			String phonenumber1 = df.formatCellValue(sheet.getRow(21).getCell(1));
			driver.findElement(By.name("nominee_phone")).sendKeys(phonenumber1 + "");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			driver.findElement(By.xpath("(//a[text()='CLIENTS'])")).click();
			String url2 = sheet.getRow(22).getCell(1).getStringCellValue();
			String strurl2 = driver.getCurrentUrl();
			if (url2.equals(strurl2)) {
				System.out.println("the client information page is being displayed");
			} else {
				System.out.println("the client information  page is  not being displayed");
			}

			// List<WebElement> row =
			// driver.findElements(By.xpath("//tbody//tr[last()]//td"));
			// int count = row.size();
			// ArrayList<String> arr=new ArrayList<String>();
			// for (int i = 0; i < count; i++) {
			// arr.add=row.get(i).getText();
			// }

//			for (WebElement b : row) {
//				System.out.print(b.getText());
//			}

			String tbele1 = driver.findElement(By.xpath("//tbody//tr[last()]//td[1]")).getText();
			String tbele2 = driver.findElement(By.xpath("//tbody//tr[last()]//td[2]")).getText();
			String tbele3 = driver.findElement(By.xpath("//tbody//tr[last()]//td[3]")).getText();
			String tbele4 = driver.findElement(By.xpath("//tbody//tr[last()]//td[4]")).getText();
			String tbele5 = driver.findElement(By.xpath("//tbody//tr[last()]//td[5]")).getText();
			String tbele6 = driver.findElement(By.xpath("//tbody//tr[last()]//td[6]")).getText();
			System.out.print(tbele1);
			System.out.print(tbele2);
			System.out.print(tbele3);
			System.out.print(tbele4);
			System.out.print(tbele5);
			System.out.print(tbele6);
			String[] ar = { "tbele1", "tbele2", "tbele3", "tbele4", "tbele5", "tbele6" };
			// double[] d1 = {"tbele1",};
			String[] ar1 = { "user1", "name", "birthdate", "nid", "phonenumber", "address" };
			// double[] d2 = {};
			// if(checkEquality)
			ArrayList<String> ar2 = new ArrayList<String>();
			for (int i = 0; i <= ar1.length; i++) {
				if (!Arrays.asList(ar).contains(ar1[i])) {
					ar2.add(ar1[i]);
					System.out.println("the table is compared and same as the excel details");
					break;
				} else {
					System.out.println("the table is compared but the details are not same as the excel details");
					break;
				}
			}
			WebElement ele8 = driver.findElement(By.xpath("//a[text()='Aegon Life']"));
			Actions a = new Actions(driver);
			a.moveToElement(ele8).perform();
			ele8.click();
			WebElement ele9 = driver.findElement(By.name("key"));
			a.moveToElement(ele9).perform();
			ele9.sendKeys(name);
			driver.findElement(By.xpath("//input[@class='searchBtn']")).click();
			String tb1ele1 = driver.findElement(By.xpath("//tbody//tr//td[1]")).getText();
			String tb1ele2 = driver.findElement(By.xpath("//tbody//tr//td[2]")).getText();
			String tb1ele3 = driver.findElement(By.xpath("//tbody//tr//td[3]")).getText();
			String tb1ele4 = driver.findElement(By.xpath("//tbody//tr//td[4]")).getText();
			String tb1ele5 = driver.findElement(By.xpath("///tbody//tr//td[5]")).getText();
			String tb1ele6 = driver.findElement(By.xpath("//tbody//tr//td[6]")).getText();
			String[] ar3 = { "tb1ele1", "tb1ele2", "tb1ele3", "tb1ele4", "tb1ele5", "tb1ele6" };
			ArrayList<String> ar4 = new ArrayList<String>();
			for (int i = 0; i <= ar3.length; i++) {
				if (!Arrays.asList(ar).contains(ar3[i])) {
					ar4.add(ar3[i]);
					System.out.println("the table is compared and same as the excel details");
					break;
				} else {
					System.out.println("the table is compared but the details are not same as the excel details");
					break;
				}
			}
			driver.findElement(By.xpath("//tbody//tr//td[.='" + name + "']/following-sibling::td//a")).click();
			driver.findElement(By.xpath("//a[text()='Edit Client']")).click();
			String name1 = sheet.getRow(5).getCell(2).getStringCellValue();
			driver.findElement(By.name("name")).sendKeys(name1);
			driver.findElement(By.xpath("//input[@value='UPDATE']")).click();
			WebElement ele10 = driver.findElement(By.xpath("//a[text()='Aegon Life']"));
			a.moveToElement(ele10).perform();
			ele10.click();
			WebElement ele11 = driver.findElement(By.name("key"));
			a.moveToElement(ele11).perform();
			ele9.sendKeys(name);
			String tb2ele1 = driver.findElement(By.xpath("//tbody//tr//td[1]")).getText();
			String tb2ele2 = driver.findElement(By.xpath("//tbody//tr//td[2]")).getText();
			String tb2ele3 = driver.findElement(By.xpath("//tbody//tr//td[3]")).getText();
			String tb2ele4 = driver.findElement(By.xpath("//tbody//tr//td[4]")).getText();
			String tb2ele5 = driver.findElement(By.xpath("///tbody//tr//td[5]")).getText();
			String tb2ele6 = driver.findElement(By.xpath("//tbody//tr//td[6]")).getText();
			String[] ar6 = { "tb2ele1", "tb2ele2", "tb2ele3", "tb2ele4", "tb2ele5", "tb2ele6" };
			ArrayList<String> ar7 = new ArrayList<String>();
			for (int i = 0; i <= ar6.length; i++) {
				if (!Arrays.asList(ar).contains(ar6[i])) {
					ar7.add(ar6[i]);
					System.out.println("the table is compared and same as the excel details:TC FAILED");
					break;
				} else {
					System.out.println("the table is compared but the details are not same as the excel details:TC PASSED");
					break;
				}
			}
			
			
		//	driver.findElement(By.xpath("//tr[last()]")).getText();

		}
	}





