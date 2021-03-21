package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DeleteLeadAssert extends BaseClassTestAssert {

	@BeforeTest
	public void setFileName() {
		fileName="datafile";
		sheetNumber="DeleteLead";
	}
	@Test(dataProvider="Data")
	
	public void runDeleteLead(String phoneNumber) throws InterruptedException {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();

		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//span[text()='Find by']//following::input[@name='phoneNumber']")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);

		WebElement LeadIDElement=driver.findElement(By.xpath("(//span[text()='Lead List']//following::a[@class='linktext'])[1]"));
		String LeadID=LeadIDElement.getText();
		System.out.println("Lead ID: "+LeadID);
		LeadIDElement.click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Delete")).click();

		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(LeadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);

		WebElement infoMessage=driver.findElement(By.className("x-paging-info"));
		String actual=infoMessage.getText();
		String expected="No records to display";
		
		
		
		 SoftAssert softAssert=new SoftAssert();
		 softAssert.assertEquals(actual, expected);
		 
		  
		 System.out.println("lines after assert check");
		 
		 softAssert.assertAll();
		 
//		if(infoMessage.getText().contains("No records to display")) {
//			System.out.println("The lead's record is deleted successfully and verified - Test Pass");
//		}else {
//			System.out.println("The deleted Lead's record is still visible-Test Fail");
//		}

	}

}
