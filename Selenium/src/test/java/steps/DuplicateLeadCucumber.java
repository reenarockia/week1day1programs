package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DuplicateLeadCucumber extends BaseClassCucumber{
	public String originalLeadFirstName;
//	Given Enter the username as demoCSR
//	And Enter the password as crmsfa
//	When Click on login button
//	Then Home page should get displayed
//	When Click on CRMSFA link
//	And Click on Leads link
//	And Click on Find leads link
//	Then Verify Find Leads page is displayed
	@Given("Enter the email Id of the lead to be duplicated as {string}")
	public void enterEmailID_DuplicateLeadTC(String emailId) {
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(emailId);
	}
//	When Click on Find Leads button
	@When("Click on the first resulting Lead ID")
	public void clickOnTheFirstResultingLeadId() throws InterruptedException {
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//tr[1]//td[1]//a")).click();
		Thread.sleep(3000);
	}
//	Then Verify whether we landed on View Lead page
	@Then("Store the OriginalLeadFirstName")
	public String stroreOriginalLeadFirstName() {
		originalLeadFirstName=driver.findElement(By.id("viewLead_firstName_sp")).getText();
		return originalLeadFirstName;
	}
	
	@When("Click on Duplicate Lead button")
	public void clickDuplicateLeadButton_DuplicateLeadTC() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	@Then("Verify Duplicate Lead page is displayed")
	public void verifyDuplicateLeadPageDisplay() {
		softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='x-panel-header sectionHeaderTitle']")).getText(), "Duplicate Lead");
	}
	@When("Click on Create Lead button in Duplicate Lead page")
	public void clickCreateLeadButton_in_DuplicateLeadPage() {
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
	}
//	Then Verify whether we landed on View Lead page
	@Then("Verify whether the DuplicatedLeadFirstName is same as that of the OriginalLeadFirstName")
	public void compareOriginalAndDupicateLeadNames() {
		originalLeadFirstName=stroreOriginalLeadFirstName();
		System.out.println("original lead name = "+originalLeadFirstName);
		String duplicateLeadFirstName=driver.findElement(By.id("viewLead_firstName_sp")).getText();
		softAssert.assertEquals(duplicateLeadFirstName, originalLeadFirstName);
		System.out.println("Duplicate entry for "+originalLeadFirstName+" is created successfully");
	}


}
