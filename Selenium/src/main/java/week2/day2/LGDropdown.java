package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LGDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		
		//select training program by index
		WebElement dropDown1Element=driver.findElement(By.id("dropdown1"));
		Select dropDown1=new Select(dropDown1Element);
		dropDown1.selectByIndex(1);
	
//		if(dropDown1Element.getAttribute("value")== "Selenium")
//		System.out.println("The selected value in dropdown1: Selenium - Test Pass");
//		else
//			System.out.println("Test Fail");
//		
		//Select training program using text
		Select dropDown2=new Select(driver.findElement(By.name("dropdown2")));
		dropDown2.selectByVisibleText("Appium");
		
		//select training program using value
		Select dropDown3=new Select(driver.findElement(By.id("dropdown3")));
		dropDown3.selectByValue("3");
		
		//get the number of dropdown options
		List<WebElement> dropdownlist=driver.findElements(By.tagName("select"));
		System.out.println("Number of dropdowns present: "+dropdownlist.size());
		
		//Use sendKeys to select
		driver.findElement(By.xpath("//option[contains(text(),'sendKeys')]/parent::select")).sendKeys("Loadrunner");
		
		//Select multiple choices
		Select dropDown5=new Select(driver.findElement(By.xpath("//option[contains(text(),'programs')]/parent::select[@multiple]")));
		dropDown5.selectByVisibleText("Selenium");
		dropDown5.selectByVisibleText("UFT/QTP");
		//driver.close();
	}

}
