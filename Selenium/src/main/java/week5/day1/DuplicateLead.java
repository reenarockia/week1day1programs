package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DuplicateLead extends Baseclass1 {
	@BeforeTest
	public void setFileName() {
		fileName="datafile";
		sheetNumber="DuplicateLead";
	}
	@Test(dataProvider = "Data")
	public void runDuplicateLead(String emailId) throws InterruptedException {
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//span[text()='Find by']//following::input[@name='emailAddress']")).sendKeys(emailId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);

		WebElement LeadNameElement=driver.findElement(By.xpath("((//table[@class='x-grid3-row-table']//tr[1]/td[1])[1]/following::a[@class='linktext'])[2]"));
		String leadName=LeadNameElement.getText();
		System.out.println("Name of the first resulting lead is : "+leadName);

		LeadNameElement.click();

		driver.findElement(By.linkText("Duplicate Lead")).click();

		if(driver.getTitle().contains("Duplicate Lead")){
			System.out.println("Landed in Duplicate Lead page as expected- Test Pass");
		}else{
			System.out.println("Not Landed in Duplicate Lead page - Test Fail ");
		}

		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();

		WebElement dupLeadNameElement=driver.findElement(By.xpath("(//span[contains(@id,'viewLead_firstName')])[1]"));
		String duplicatedLeadName=dupLeadNameElement.getText();
		System.out.println("Duplicated lead name:" +duplicatedLeadName);
		if(duplicatedLeadName.equalsIgnoreCase(leadName)) {
			System.out.println("Duplicated name is same as the captured name");
		}else {
			System.out.println("Duplicated name is not same as the captured name");
		}

		//driver.close();

	}

}
