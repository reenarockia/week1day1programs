package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEditPageTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		System.out.println("Title: "+driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("reenarockia@gmail.com");
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys(" used xpath to locate");
		System.out.println("Default text Entered: " + driver.findElement(By.name("username")).getAttribute("value"));
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		if(driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled()) {
			System.out.println("Confirm that edit field is disabled field - Enabled");
		} else {
			System.out.println("Confirm that edit field is disabled field - Disabled");
		}
		driver.close();
	}
}
