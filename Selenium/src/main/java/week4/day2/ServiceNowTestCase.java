
package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowTestCase {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

//		Step1: Load ServiceNow application https://dev68594.service-now.com/
		driver.get("https://dev68594.service-now.com/");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
//		Step2: Enter username as “admin”
//		Step3: Enter password as “India@123”
//		Step4: Click Login

//		get into the Frame as the username and password are within the frame
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		System.out.println("Navigated to My Homepage 55");
		
		//		Step5: Search “incident “ Filter Navigator
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.id("filter")).sendKeys(Keys.ENTER);
		System.out.println("searched for incident");
		Thread.sleep(3000);
		//		Step6: Click “All”
		driver.findElement(By.xpath("(//li//div[text()='All'])[2]")).click();
		Thread.sleep(3000);
		System.out.println("Clicked on All");
		
		//      getting into frame contains New Button
		WebElement frameNew=driver.findElement(By.xpath("//iframe[@aria-label='Main content']"));
		driver.switchTo().frame(frameNew);

		//		Step7: Click New button
		driver.findElement(By.xpath("//button[text()='New']")).click();
		System.out.println("Clicked on New Button");
		
		//		Step8: Select a value for Caller and Enter value for short_description
		driver.findElement(By.xpath("//span[@class='input-group-btn']//button[contains(@aria-label,'Caller')]")).click();
		System.out.println("Clicked on caller button");
		//		clicking caller button will open up a new window.so we have to switch to the new window		
		Set<String> allWindowHandles=driver.getWindowHandles();
		List<String> windowHandlesList=new ArrayList<String> (allWindowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		
		driver.findElement(By.xpath("//a[text()='Abraham Lincoln']")).click();
		System.out.println("Selected Abraham lincoln as caller");
		Thread.sleep(3000);

		//		switching back to the first window	
		driver.switchTo().window(windowHandlesList.get(0));
		//		getting into the frame
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Selected Abraham Lincoln in caller");
		System.out.println("Typed info in Short description");

		//		Step9: Read the incident number and save it a variable
		String incidentNumber=driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("The Incident Number is : " +incidentNumber );
		//		Step10: Click on Submit button
		driver.findElement(By.id("sysverb_insert")).click();
		System.out.println("clicked on Submit Button");
		//		Step 11: Search the same incident number in the next search screen as below
		driver.findElement(By.xpath("//div[@class='input-group']//input[@placeholder='Search']")).sendKeys(incidentNumber);
		driver.findElement(By.xpath("//div[@class='input-group']//input[@placeholder='Search']")).sendKeys(Keys.ENTER);
		//		Step12: Verify the incident is created successful
		WebElement verifyIncident=driver.findElement(By.xpath("//table[@id='incident_table']//tr[1]//td[3]//a"));
		String incidentNumberToBeVerified=verifyIncident.getText();
		
		if(incidentNumberToBeVerified.equalsIgnoreCase(incidentNumber)) {
			System.out.println("The incident is created successfully");
		}else {
			System.out.println("The incident is not created successfully");
		}
		driver.switchTo().defaultContent();
		//driver.close()
	}

}
