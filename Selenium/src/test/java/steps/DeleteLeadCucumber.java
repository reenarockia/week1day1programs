package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteLeadCucumber extends BaseClassCucumber{
//	Given Enter the username as demoCSR
//	And Enter the password as crmsfa
//	When Click on login button
//	Then Home page should get displayed
//	When Click on CRMSFA link
//	And Click on Leads link
//	When Click on Find leads link
//	Then Verify Find Leads page is displayed
	public String originalLeadId;
	@Given("Enter LeadPhoneNumber as {string}")
	public void enterLeadPhoneNumber(String leadPhoneNumber) {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys(leadPhoneNumber);
	}
//	When Click on Find Leads button
//	And Click on the first resulting lead ID
//	Then Verify whether we landed on View Lead page
	@Then("Store the OriginalLeadId")
	public void storeOriginalLeadId() {
		originalLeadId=driver.findElement(By.id("viewLead_companyName_sp")).getText().replaceAll("\\D", "");
	}
	@When("Click on Delete button")
	public void clickDeleteButton() {
		driver.findElement(By.className("subMenuButtonDangerous")).click();
	}
	@Then("Verify whether we landed on My Leads Page")
	public void verifyMyLeadsPageDisplay() {
		softAssert.assertTrue(driver.findElement(By.id("sectionHeaderTitle_leads")).getText().equalsIgnoreCase("My Leads"));
	}
//	When Click on Find leads link
//	Then Verify Find Leads page is displayed
	@Given("Enter Lead Id OriginalLeadId")
	public void enterOriginalLeadIdInFindLeadsPage() {
		driver.findElement(By.name("id")).sendKeys(originalLeadId);
	}
//	When Click on Find Leads button
	@Then("Verify NoRecordsMessage is displayed")
	public void verifyNoRecordsFoundMessageDisplay() {
		softAssert.assertEquals(driver.findElement(By.className("x-paging-info")).getText(), "No records to display");
		System.out.println(originalLeadId+" is deleted successfully");
	}

}
