package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLeadCucumber extends BaseClassCucumber {
	public String firstName;
//	@Given("Enter the username as demoCSR")
//	public void enterUserName() {
//		driver.findElement(By.id("username")).sendKeys("demoCSR");
//	}
//	@Given("Enter the password as crmsfa")
//	public void enterPassWord() {
//		driver.findElement(By.id("password")).sendKeys("crmsfa");
//	}
//	@When("Click on login button")
//	public void clickLogin1() {
//		driver.findElement(By.className("decorativeSubmit")).click();
//	}
//	@Then("Home page should get displayed")
//	public void verifyHomePageDisplay() {
//		softAssert.assertTrue(driver.findElement(By.linkText("CRM/SFA")).isDisplayed());
//	}
//	@When("Click on CRMSFA link")
//	public void clickCRMSFA() {
//		driver.findElement(By.linkText("CRM/SFA")).click();
//	}
//	@When("Click on Leads link")
//	public void clickLeadsLink() {
//		driver.findElement(By.linkText("Leads")).click();
//	}
	@When("Click on Find leads link")
	public void clickFindLeadsLink() {
		driver.findElement(By.linkText("Find Leads")).click();
	}
	@Then("Verify Find Leads page is displayed")
	public void verifyFindLeadsPageDisplay() {
		softAssert.assertTrue(driver.findElement(By.xpath("//div[@class='x-panel-header sectionHeaderTitle']")).getText().equalsIgnoreCase("Find Leads"));
	}
	@Given("Enter First Name as {string} in Find Leads page")
	public void enterFirstNameForEditLead(String firstName) {
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(firstName);
	}
	

	@When("Click on Find Leads button")
	public void clickFindLeadsButton() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
	}
	@When("click on the first resulting Lead ID")
	public void clickFirstResultingLead() {
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//tr[1]//td[1]//a")).click();
	}
	@Then("Verify whether we landed on View Lead page")
	public void verifyViewLeadPageDisplay() {
		softAssert.assertTrue(driver.findElement(By.xpath("//div[@class='x-panel-header sectionHeaderTitle']")).getText().equalsIgnoreCase("View Leads"));
	}
	
	@Then("Verify whether the first name is {string} as given in Find Leads page")
	public void verifyFirstName(String firstName) {
		softAssert.assertTrue(driver.findElement(By.id("viewLead_firstName_sp")).getText().equalsIgnoreCase(firstName));
	}
	@Then("Get the Company name as oldCompanyName")
	public void getOldCompanyName() {
		driver.findElement(By.id("viewLead_companyName_sp")).getText().replaceAll("^[a-z][A-Z]","");
	}
	
	@When("Click on Edit Button in View Lead page")
	public void clickEditButton() {
		driver.findElement(By.linkText("Edit")).click();
	}
	@Then("Verify whether the Edit Lead page is displayed")
	public void verifyEditLeadPageDisplay() {
		softAssert.assertTrue(driver.findElement(By.xpath("//div[@class='x-panel-header sectionHeaderTitle']")).getText().equalsIgnoreCase("Edit Lead"));
	}
	@Given("Clear the Company Name")
	public void clearCompanyname() {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
	}
	@Given("Enter New Company Name as {string}")
	public void enterNewCompanyName(String newCompanyName) {
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(newCompanyName);
		
	}
	@When("Click on Update button")
	public void clickUpdateButton() {
		driver.findElement(By.xpath("//input[@value='Update']")).click();
	}
	@Then("Verify whether the company Name of the lead {string} displayed as {string} in the View Lead page")
	public void verifyNewCompanynameDisplayed(String firstName,String newCompanyName) {
		softAssert.assertEquals(newCompanyName, driver.findElement(By.id("viewLead_companyName_sp")).getText().replaceAll("^[a-z][A-Z]",""));
		System.out.println("Lead "+firstName+"'s company name is changed to "+newCompanyName);
	}


}


