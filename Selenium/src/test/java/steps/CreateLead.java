package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLead extends BaseClassCucumber {
	public String firstName,lastName;
	@Given("Enter the username as demoCSR")
	public void enterUserName() {
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
	}
	@Given("Enter the password as crmsfa")
	public void enterPassWord() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	}
	@When("Click on login button")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	@Then("Home page should get displayed")
	public void verifyHomePageDisplay() {
		softAssert.assertTrue(driver.findElement(By.linkText("CRM/SFA")).isDisplayed());
	}
	@When("Click on CRMSFA link")
	public void clickCRMSFA() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@When("Click on Leads link")
	public void clickLeadsLink() throws InterruptedException {
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(3000);
	}
	@When("Click on Create Lead link")
	public void clickCreateLeadLink() {
		driver.findElement(By.linkText("Create Lead")).click();
	}
	@Then("Verify Create Lead page is displayed")
	public void verifyCreateLeadPageDisplay() {
		softAssert.assertTrue(driver.findElement(By.xpath("//div[@class='x-panel-header sectionHeaderTitle']")).getText().equalsIgnoreCase("Create Lead"));
	}
	@Given("Enter Company Name as {string}")
	public void enterCompanyName(String companyName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
	}
	@Given("Enter First Name as {string}")
	public void enterFirstName(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	}
	
	@Given("Enter Last Name as {string}")
	public void enterLastName(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	}
	@Given("Enter email Id as {string}")
	public void enterEmailId(String emailId) {
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(emailId);
	}
	@Given("Enter Phone Number as {string}")
	public void enterPhoneNumber(String phoneNumber) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneNumber);
	}
	@When("Click on Create Lead button")
	public void clickCreateLeadButton() {
		driver.findElement(By.className("smallSubmit")).click();
	}
	@Then("Verify whether the view Lead page is displayed with given {string},{string},{string}")
	public void verifyLeadInformation(String companyName,String firstName,String lastName) {
		softAssert.assertTrue(driver.findElement(By.xpath("//div[@class='x-panel-header sectionHeaderTitle']")).getText().equalsIgnoreCase("View Lead"));
		softAssert.assertTrue(driver.findElement(By.id("viewLead_companyName_sp")).getText().contains(companyName));
		softAssert.assertTrue(driver.findElement(By.id("viewLead_firstName_sp")).getText().equalsIgnoreCase(firstName));
		softAssert.assertTrue(driver.findElement(By.id("viewLead_lastName_sp")).getText().equalsIgnoreCase(lastName));
		System.out.println("Successfully created lead information for "+firstName+" "+lastName);
	}
	
	
}