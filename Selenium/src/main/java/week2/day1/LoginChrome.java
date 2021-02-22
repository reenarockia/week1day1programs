package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginChrome {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println("Title: "+title);
		//id=username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		//id=password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//class=decorativeSubmit
		driver.findElement(By.className("decorativeSubmit")).click();
		//linkText=CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		//linkText=Create Lead
		driver.findElement(By.linkText("Create Lead")).click();
		//id=createLeadForm_companyName
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("My Home");
		//id=createLeadForm_firstName
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Reena");
		//id=createLeadForm_lastName
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Arockiasamy");
		//to select the value from dropdown Source
		//locate the element for Source, id="createLeadForm_dataSourceId".
		//As findElement returns a webElement, store the result in a webElement
		WebElement element=driver.findElement(By.id("createLeadForm_dataSourceId"));
		//create an object for the class Select passing the WebElement located
		Select obj1=new Select(element);
		//Now select one of the dropdown values from the options given.
		obj1.selectByVisibleText("Employee");
		WebElement element1=driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select obj2=new Select(element1);
		obj2.selectByValue("9001");
		WebElement element2=driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select obj3=new Select(element2);
		obj3.selectByIndex(5);
		WebElement element3=driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select obj4=new Select(element3);
		obj4.selectByVisibleText("India");
		//name=submitButton
		driver.findElement(By.name("submitButton")).click();
		System.out.println("Title of the current page is : "+driver.getTitle());
		//driver.close();

	}

}
