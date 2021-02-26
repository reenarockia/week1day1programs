package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTapDeleteLead {

	public static void main(String[] args) throws InterruptedException {

//1	Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

//2	Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
//3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");		
//4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
//5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
//6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
//7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
//8	Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
//9	Enter phone number 99
		driver.findElement(By.xpath("//span[text()='Find by']//following::input[@name='phoneNumber']")).sendKeys("9840818049");
//10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
//11	Capture lead ID of First Resulting lead
		//WebElement LeadIDElement=driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tr[1]/td[1])[1]"));
		WebElement LeadIDElement=driver.findElement(By.xpath("(//span[text()='Lead List']//following::a[@class='linktext'])[1]"));
		String LeadID=LeadIDElement.getText();
		System.out.println("Lead ID: "+LeadID);
//12	Click First Resulting lead
		LeadIDElement.click();
		Thread.sleep(2000);
//13	Click Delete
		driver.findElement(By.linkText("Delete")).click();
//14	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
//15	Enter captured lead ID
		driver.findElement(By.name("id")).sendKeys(LeadID);
//16	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
//17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		WebElement infoMessage=driver.findElement(By.className("x-paging-info"));
		System.out.println(infoMessage.getText());
		if(infoMessage.getText().contains("No records to display")) {
			System.out.println("The lead's record is deleted successfully and verified - Test Pass");
		}else {
			System.out.println("The deleted Lead's record is still visible-Test Fail");
		}
//18	Close the browser (Do not log out)
		//driver.close();

	}

}
