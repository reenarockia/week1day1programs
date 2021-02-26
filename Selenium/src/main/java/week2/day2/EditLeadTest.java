package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

//		1	Launch the browser
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();		
//		2	Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");		
//		3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");		
//		4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
//		5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
//		6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
//		7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
//		8	Enter first name as Gopi 
		driver.findElement(By.xpath("//span[text()='Find by']//following::input[@name='firstName']")).sendKeys("Gopi");
//		9	Click Find leads button- Thread.sleep(2000)
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
//		10	Click on first resulting lead - try this with table
		driver.findElement(By.xpath("(//span[text()='Lead List']//following::a[@class='linktext'])[1]")).click();
//		11	Verify title of the page
		System.out.println("Title of the page after clicking on the first resulting lead: "+driver.getTitle());
//		12	Click Edit
		driver.findElement(By.linkText("Edit")).click();
//		13	Change the company name - changing from New company to TestLeaf
		driver.findElement(By.xpath("//div[text()='Edit Lead']//following::input[@name='companyName']")).clear();
		driver.findElement(By.xpath("//div[text()='Edit Lead']//following::input[@name='companyName']")).sendKeys("Accenture");
//		14	Click Update
		driver.findElement(By.xpath("//div[text()='Edit Lead']//following::input[@value='Update']")).click();
//		15	Confirm the changed name appears
		WebElement check=driver.findElement(By.xpath("//span[contains(@id,'viewLead_companyName')]"));

		if(check.getText().contains("Accenture")) {
			System.out.println("Lead Gopi's comany name is changed to Accenture - Test Pass");
		}else {
			System.out.println("Lead Gopi's comany name is not changed to Accenture - Test Fail");
		}
//		16	Close the browser (Do not log out)
		driver.close();
	}

}
