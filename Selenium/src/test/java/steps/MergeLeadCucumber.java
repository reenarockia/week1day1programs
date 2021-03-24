package steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MergeLeadCucumber extends BaseClassCucumber{
//	Given Enter the username as demoCSR
//	And Enter the password as crmsfa
//	When Click on login button
//	Then Home page should get displayed
//	When Click on CRMSFA link
//	And Click on Leads link
	

	@When("Click on Merge Leads link")
	public void clickMergeLeadLink() {
		driver.findElement(By.linkText("Merge Leads")).click();
	}
	@Then("Verify Merge Leads page is displayed")
	public void verifyMergeLeadPageDisplay() {
		softAssert.assertTrue(driver.findElement(By.id("sectionHeaderTitle_leads")).
				getText().equalsIgnoreCase("Merge Leads"));
	}
	@When("Click on Lookup button of From Lead")
	public void clickFromLeadLookupButton() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(@href,'ComboBox_partyIdFrom')]")).click();
		Thread.sleep(3000);
	}
	@Then("Switch to the new window that opens up")
	public void switchToNewWindow() throws InterruptedException {
		Set<String> allHandles=driver.getWindowHandles();
		handlesList=new ArrayList<String>(allHandles);
		
		driver.switchTo().window(handlesList.get(1));
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Then("Verify whether the title is Find Leads")
	public void verifyFindLeadspageDisplayInNewWindow() {
		softAssert.assertEquals(driver.findElement(By.className("subSectionTitle")).getText(), "Find Leads");
	}
	@Given("Enter lead Id {string}")
	public void enterLeadId1(String leadId1) {
		driver.findElement(By.xpath("(//input)[1]")).sendKeys(leadId1);
	}
//	@When("Click on Find Leads button")
//	public void clickOnFindLeadsButton(){
//		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
//		//Thread.sleep(3000);
//	}
	@When("Click on the resulting Lead Id")
	public void clickOnresultingLeadId() throws InterruptedException {
		//wait.until(ExpectedConditions.
				//elementToBeClickable(driver.findElement(By.xpath("//a[text()='"+leadId+"']"))));
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tr[1]//td[1]//a)[1]")).click();
		Thread.sleep(3000);
		
	}
	@When("Switch back to the ParentWindow")
	public void switchbackToParentWindow() throws InterruptedException {
		driver.switchTo().window(handlesList.get(0));
		Thread.sleep(3000);
		System.out.println("In parent Window now");
	}
//	Then Verify Merge Leads Page is displayed
	@When("Click on Lookup button of To Lead")
	public void clickOnToLeadLookupButton() {
		
		wait.until(ExpectedConditions.elementToBeClickable
				(driver.findElement(By.xpath("//a[contains(@href,'ComboBox_partyIdTo')]"))));
		driver.findElement(By.xpath("//a[contains(@href,'ComboBox_partyIdTo')]")).click();
	}
//	Then Switch to the new window that opens up
//	Then Verify whether the title is Find Leads
//	Given Enter lead Id <LeadId2>
//	When Click on Find Leads button
//	And Click on the resulting lead ID
//	And Switch back to the ParentWindow
//	Then Verify Merge Leads Page is displayed
	@When("Click on Merge button")
	public void clickMergeLeadButton() {
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Merge"))));
		driver.findElement(By.linkText("Merge")).click();
	}
	@When("Accept the Alert")
	public void acceptAlert() {
		//wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
//	Then Verify View Lead page is displayed
//	When Click on Find leads link
//	Then Verify Find Leads page is displayed
	@Given("Enter Lead Id1 {string}")
	public void enterLeadId(String leadId1) {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId1);
	}
//	When Click on Find Leads button
	@Then("Verify NoRecordsMessage is displayed {string},{string}")
	public void verifyNoRecordsMessageDisplay(String leadId1,String leadId2) {
		softAssert.assertEquals(driver.findElement(By.className("x-paging-info")).getText(), "No records to display");
		System.out.println(leadId1+" is merged successfully with "+leadId2);
	}


}
