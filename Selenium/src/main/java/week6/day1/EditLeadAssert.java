package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLeadAssert extends BaseClassTestAssert{

	@BeforeTest
	public void setFileName() {
		fileName="datafile";
		sheetNumber="EditLead";
	}
	
	@Test(dataProvider="Data")
	public void runEditLead(String firstName,String companyName) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
 
		driver.findElement(By.xpath("//span[text()='Find by']//following::input[@name='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[text()='Lead List']//following::a[@class='linktext'])[1]")).click();
		System.out.println("Title of the page after clicking on the first resulting lead: "+driver.getTitle());

		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.xpath("//div[text()='Edit Lead']//following::input[@name='companyName']")).clear();
		driver.findElement(By.xpath("//div[text()='Edit Lead']//following::input[@name='companyName']")).sendKeys(companyName);
		driver.findElement(By.xpath("//div[text()='Edit Lead']//following::input[@value='Update']")).click();
		WebElement check=driver.findElement(By.xpath("//span[contains(@id,'viewLead_companyName')]"));
		
		softAssert.assertEquals(check.getText(), companyName);
		softAssert.assertAll();

//		if(check.getText().contains(companyName)) {
//			System.out.println("Lead "+firstName+"'s company name is changed to"+ companyName+" - Test Pass");
//		}else {
//			System.out.println("Lead "+firstName+"'s company name is not changed to "+ companyName+" - Test Fail");
//		}
	}



}
