package week5.day1;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLead extends Baseclass1{
	@BeforeTest
	public void setFileName() {
		fileName="datafile";
		sheetNumber="CreateLead";
	}
	
	@Test(dataProvider="Data")
	public void runCreateLead(String companyName,String firstName,String lastName,String emailID,String phoneNumber) {
			 driver.findElement(By.linkText("Leads")).click();
			 driver.findElement(By.linkText("Create Lead")).click();
			 
			 driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
			 driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
			 driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
			 driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(emailID);
			 driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneNumber);
			 driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
			 
//			 if(driver.findElement(By.id("viewLead_firstName_sp")).getText().equalsIgnoreCase("Reena")) {
//				 System.out.println("create Lead success:Test pass");
//			 }else {
//				 System.out.println("Test fail");
//			 }
	}
			 
			
	
	

}

