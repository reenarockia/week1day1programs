package week6.day1;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLeadAssert extends BaseClassTestAssert {
	@BeforeTest
	public void setFileName() {
		System.out.println("Setting file name");
		fileName="datafile";
		sheetNumber="CreateLead";

	}
	
	@Test(dataProvider="Data")
	public void runCreateLead(String companyName,String firstName,String lastName,String emailID,String phoneNumber) {
			System.out.println("In Test");
			 driver.findElement(By.linkText("Leads")).click();
			 driver.findElement(By.linkText("Create Lead")).click();
			 
			 driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
			 driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
			 driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
			 driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(emailID);
			 driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneNumber);
			 driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
			 
			 //Hard Assert
//			 String expected="Reena";
//			 String actual=driver.findElement(By.id("viewLead_firstName_sp")).getText();
//			 Assert.assertEquals(actual, expected);
			 
			 //Soft Assert
			 boolean actual = driver.findElement(By.id("viewLead_firstName_sp")).isDisplayed();
			
			 
			 softAssert.assertTrue(actual);
			 System.out.println("First Name of the created lead is displayed");
			 softAssert.assertAll();
}
}
